package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.GkkdDialogAction;
import com.action.LoginAction;
import com.action.MjbFjMouseListener;
import com.dao.BaojianDao;
import com.dao.xiaofeiDao;
import com.view.util.MyJButton;
import com.vo.BaojianVo;

public class GhbjDialog extends JDialog{
	
	private JTextField jtfXbj=new JTextField(8);
	private AppMainFrame frame;
	
	public GhbjDialog(AppMainFrame owner,boolean model){
		
		super(owner,model);
		this.frame=owner;
		super.setSize(234,178);
		super.setLocationRelativeTo(null);
		super.setTitle("��������");
		super.setResizable(false);
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		JCheckBox jcbBlyfjf=new JCheckBox("����ԭ�����");
		jcbBlyfjf.setBackground(new Color(236,233,216));
		jcbBlyfjf.setFocusable(false);
		jcbBlyfjf.setBounds(48, 75, 165, 20);
		
		jPanel.add(jp1());
		jPanel.add(jp2());
		jPanel.add(jcbBlyfjf);
		jPanel.add(jp3());
		
		return jPanel;
	}
	
	public JPanel jp1(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(40, 15, 165, 20);
		
		jPanel.add(new JLabel("ԭ���䣺"));
		JLabel jlYbj=new JLabel(MjbFjMouseListener.getQygVo().getBjid());
		jlYbj.setFont(new Font("����", Font.BOLD, 16));
		jlYbj.setForeground(Color.BLUE);
		jPanel.add(jlYbj);
		
		return jPanel;
	}
	
	public JPanel jp2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(40, 45, 165, 20);
		
		jPanel.add(new JLabel("����Ϊ��"));
		
		jtfXbj.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.add(jtfXbj);
		
		return jPanel;
	}
	
	public JPanel jp3(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 110, 204, 20);
		
		MyJButton mjbQd=new MyJButton("ȷ��").set_Background(new Color(248,245,229)).set_Margin(new Insets(0, 0, 0, 0)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_PreferredSize(new Dimension(66, 20)).set_FocusPainted(false);
		MyJButton mjbQx=new MyJButton("ȡ��").set_Background(new Color(248,245,229)).set_Margin(new Insets(0, 0, 0, 0)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_PreferredSize(new Dimension(66, 20)).set_FocusPainted(false);
		
		mjbQd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jtfXbj.getText()!=null && jtfXbj.getText().length()!=0){
					
					String bjid=jtfXbj.getText().toUpperCase();
					BaojianDao bjDao=new BaojianDao();
					try {
						BaojianVo bjVoOld=bjDao.getBjByBjid(MjbFjMouseListener.getQygVo().getBjid());
						BaojianVo bjVoNew=bjDao.getBjByBjid(bjid);
						if(bjVoNew==null){
							JOptionPane.showMessageDialog(getParent(), "û���ҵ�Ŀ������Ŀ����䴦�ڷǿɹ�״̬!");
							jtfXbj.setText("");
							jtfXbj.requestFocus();
						}else if(!(bjVoOld.getBjtid().equals(bjVoNew.getBjtid()))){
							JOptionPane.showMessageDialog(getParent(), "���ܵ�������ͬ�������͵İ���");
							jtfXbj.setText("");
							jtfXbj.requestFocus();
						}else{
							if(bjVoNew.getState()!=1){
								JOptionPane.showMessageDialog(getParent(), "û���ҵ�Ŀ������Ŀ����䴦�ڷǿɹ�״̬!");
								jtfXbj.setText("");
								jtfXbj.requestFocus();
							}else{
								xiaofeiDao xfDao=new xiaofeiDao();
								Vector<Vector> xfDatas=xfDao.queryXfByBjid(bjVoOld.getBjid());
								int val =xfDao.updateBjidAndOid(xfDatas.get(0).get(0).toString(), bjid, LoginAction.getDqOid());
								if(val==0){
									JOptionPane.showMessageDialog(getParent(), "����ʧ��");
								}else{
									bjDao.updateState(bjVoOld.getBjid(), 1);
									bjDao.updateState(bjid,4);
									GkkdDialogAction.sxBj(frame);
									dispose();
								}
							}
						}
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "���ݿ��쳣");
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		mjbQx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		jPanel.add(mjbQd);
		jPanel.add(mjbQx);
		
		return jPanel;
	}


	
	
	public JTextField getJtfXbj() {
		return jtfXbj;
	}
	
	
	/*public static void main(String[] args) {
		new GhbjDialog();
	}*/

	
}

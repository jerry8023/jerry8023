package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dao.MemberDao;
import com.view.util.GBC;
import com.view.util.MyJButton;

public class HyglXghymmDialog extends JDialog {
	private JTextField jtfhybhXghy = new JTextField(10);
	private JPasswordField jtfjmmXghy = new JPasswordField(10);
	private JPasswordField jtfxmmXghy = new JPasswordField(10);
	private JPasswordField jtfqrxmmXghy = new JPasswordField(10);
	
	private MyJButton mjbOkXghy = new MyJButton("确定");
	private MyJButton mjbCancelXghy = new MyJButton("取消");
	
	private HyglXghymmDialog dialog;
	private HyglDialog frame;
	public HyglXghymmDialog(HyglDialog frame,boolean model){
		super(frame,model);
		this.frame = frame;
		dialog = this;
		super.setSize(299,251);
		super.setLocationRelativeTo(null);
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	public JPanel content(){
		JPanel jpanel = new JPanel();
		jpanel.setBackground(new Color(236,233,216));
		GridBagLayout gbl = new GridBagLayout();
		jpanel.setLayout(gbl);
		
		GridBagConstraints gbc1=new GBC(0, 0).setAnchor(GBC.EAST).setInSets(5,5, 5, 5);
		JLabel jl= new JLabel("会员编号:");
		gbl.setConstraints(jl, gbc1);
		jpanel.add(jl);
		int selected = frame.getJtHyxx().getSelectedRow();
		Object hyid = frame.getJtHyxx().getValueAt(selected, 0);
		jtfhybhXghy.setText(hyid.toString());
		GridBagConstraints gbc2=new GBC(1, 0).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		gbl.setConstraints(jtfhybhXghy, gbc2);
		jpanel.add(jtfhybhXghy);
		
		GridBagConstraints gbc3=new GBC(0, 1).setAnchor(GBC.EAST).setInSets(5,5, 5, 5);
		JLabel jl1= new JLabel("旧密码:");
		gbl.setConstraints(jl1, gbc3);
		jpanel.add(jl1);
		GridBagConstraints gbc4=new GBC(1, 1).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		gbl.setConstraints(jtfjmmXghy, gbc4);
		jpanel.add(jtfjmmXghy);
		
		GridBagConstraints gbc5=new GBC(0, 2).setAnchor(GBC.EAST).setInSets(5,5, 5, 5);
		JLabel jl2= new JLabel("新密码:");
		gbl.setConstraints(jl2, gbc5);
		jpanel.add(jl2);
		GridBagConstraints gbc6=new GBC(1, 2).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		gbl.setConstraints(jtfxmmXghy, gbc6);
		jpanel.add(jtfxmmXghy);
		
		GridBagConstraints gbc7=new GBC(0, 3).setAnchor(GBC.EAST).setInSets(5,5, 5, 5);
		JLabel jl3= new JLabel("确认新密码:");
		gbl.setConstraints(jl3, gbc7);
		jpanel.add(jl3);
		GridBagConstraints gbc8=new GBC(1, 3).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		gbl.setConstraints(jtfqrxmmXghy, gbc8);
		jpanel.add(jtfqrxmmXghy);
		
		mjbOkXghy.set_FocusPainted(false).set_Background(new Color(249,245,227)).set_PreferredSize(new Dimension(60,21));
		mjbCancelXghy.set_FocusPainted(false).set_Background(new Color(249,245,227)).set_PreferredSize(new Dimension(60,21));
		GridBagConstraints gbc9=new GBC(0, 4).setAnchor(GBC.EAST).setInSets(15,-20, 5, 10);
		gbl.setConstraints(mjbOkXghy, gbc9);
		jpanel.add(mjbOkXghy);
		GridBagConstraints gbc10=new GBC(1, 4).setAnchor(GBC.EAST).setInSets(15,20, 5, 0);
		gbl.setConstraints(mjbCancelXghy, gbc10);
		jpanel.add(mjbCancelXghy);
		mjbOkXghy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MemberDao dao = new MemberDao();
				try {
					Object password = dao.queryDataById(Integer.parseInt(jtfhybhXghy.getText()),2);
					String str = password.toString();
					str= str.substring(str.indexOf("[[")+2,str.indexOf("]"));
					//System.out.println(str);
					if(!jtfjmmXghy.getText().equals("")){
					if(jtfjmmXghy.getText().equals(str)){
						if(!jtfxmmXghy.getText().equals("")){
							if(jtfxmmXghy.getText().equals(dialog.jtfqrxmmXghy.getText())){
								dao.queryPwd(jtfxmmXghy.getText(),Integer.parseInt(jtfhybhXghy.getText()));
								dialog.dispose();
							}else{
								JOptionPane.showMessageDialog(dialog, "新密码与确认新密码不一致，请重新输入！");
								return;
							}
						}else{
							JOptionPane.showMessageDialog(dialog, "新密码不能为空！");
							return;
						}
							
					}else{
						JOptionPane.showMessageDialog(dialog, "对不起，原密码输入错误！");
						return;
					}
					}else{
						JOptionPane.showMessageDialog(dialog, "原密码不能为空！");
						return;
					}
					} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mjbCancelXghy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		return jpanel;
	}
	
	public JTextField getJtfhybhXghy() {
		return jtfhybhXghy;
	}
	public JTextField getJtfjmmXghy() {
		return jtfjmmXghy;
	}
	public JTextField getJtfxmmXghy() {
		return jtfxmmXghy;
	}
	public JTextField getJtfqrxmmXghy() {
		return jtfqrxmmXghy;
	}
	public MyJButton getMjbOkXghy() {
		return mjbOkXghy;
	}
	public MyJButton getMjbCancelXghy() {
		return mjbCancelXghy;
	}
	public static void main(String args[]){
	//	new HyglXghyDialog(null, false);
	}
}

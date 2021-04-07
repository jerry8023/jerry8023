package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.action.GkkdDialogAction;
import com.view.util.GBC;

/**
 *
 * GkkdDialog.java:�˿Ϳ�������
 * @author czp
 * @time 2013-7-11 ����2:15:46
 * 
 */
public class GkkdDialog extends JDialog {
	
 
	private static final long serialVersionUID = -5226667369247722099L;

	public static final int GKKD=1;
	public static final int XGDJ=2;
	public static int yongtu;
	
	private JLabel jlBjjsff=new JLabel("******");
	private JTextField jtBjlx=new JTextField(10);
	private JTextField jtZdbj=new JTextField(10);
	private JTextField jtZdxf=new JTextField(10);
	private JTextField jtSqyj=new JTextField("0",7);
	private JButton jbQd=new JButton("ȷ��");
	private JButton jbQx=new JButton("ȡ��");
	private JLabel jltitle=new JLabel("������㷽��:");

	public GkkdDialog(AppMainFrame owner, boolean model,int yongtu){
		super(owner,model);
		this.yongtu=yongtu;
		super.setSize(444,363);
		super.setLocationRelativeTo(null);
		super.setTitle("�˿Ϳ���");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		addlistener();
		
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public void addlistener(){
		GkkdDialogAction action=new GkkdDialogAction(this);
		jbQd.addActionListener(action);
		jbQx.addActionListener(action);
	}
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		JPanel jpMain=new JPanel(new BorderLayout());
		jpMain.setBackground(new Color(236,233,216));
		jpMain.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpMain.setBounds(11, 9, 412,254);
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
		jpNorth.setBackground(new Color(181,198,141));
		jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpNorth.add(jltitle);
		
		jpNorth.add(jlBjjsff);
		
		
		jbQd.setBounds(49, 284, 76, 21);
		jbQd.setBackground(new Color(248,245,229));
		
		
		jbQx.setBounds(308, 285, 76, 21);
		jbQx.setBackground(new Color(248,245,229));
		
		
		jpMain.add(jpNorth, BorderLayout.NORTH);
		jpMain.add(jpCenter(), BorderLayout.CENTER);
		jpMain.add(jpSouth(),BorderLayout.SOUTH);
		
		jPanel.add(jpMain);
		jPanel.add(jbQd);
		jPanel.add(jbQx);
		
		return jPanel;
	}
	
	
	public JPanel jpCenter(){
		JPanel jpCenter=new JPanel(new GridLayout(6,1));
		jpCenter.setBackground(new Color(236,233,216));
		
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
		jp1.setBackground(new Color(236,233,216));
		
		jp1.add(new JLabel("        ��������:  "));
		
		
		jtBjlx.setBackground(new Color(236,233,216));
		jtBjlx.setForeground(Color.BLUE);
		jtBjlx.setBorder(null);
		jtBjlx.setEditable(false);
		jp1.add(jtBjlx);
		
		jp1.add(new JLabel("��������:  "));
		
		
		jtZdbj.setBackground(new Color(236,233,216));
		jtZdbj.setBorder(null);
		jtZdbj.setEditable(false);
		jtZdbj.setForeground(Color.BLUE);
		jp1.add(jtZdbj);
		
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp2.setBackground(new Color(236,233,216));
		
		jp2.add(new JLabel("        �������:  "));
		
		
		jtZdxf.setBackground(new Color(236,233,216));
		jtZdxf.setBorder(null);
		jtZdxf.setEditable(false);
		jtZdxf.setForeground(Color.BLUE);
		jp2.add(jtZdxf);
		
		jp2.add(new JLabel("��ȡѺ��:  "));
		
		
		jtSqyj.setBackground(Color.WHITE);
		jtSqyj.setCaretPosition(jtSqyj.getText().length());
		jp2.add(jtSqyj);
		
		
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
		jp3.setBackground(new Color(236,233,216));
		
		JCheckBox jcb1=new JCheckBox("��ʱ���ѣ�����ʹ��: ");
		jcb1.setMargin(new Insets(0, 24, 0, 0));
		jcb1.setBackground(new Color(236,233,216));
		JTextField jtTime=new JTextField("0", 5);
		JLabel jl1=new JLabel("�����Զ�����");
		jp3.add(jcb1);
		jp3.add(jtTime);
		jp3.add(jl1);
		
		
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
		jp4.setBackground(new Color(236,233,216));
		
		JCheckBox jcb2=new JCheckBox("��Ϸ��䣬��ϼ۸�: ");
		jcb2.setMargin(new Insets(0, 24, 0, 0));
		jcb2.setBackground(new Color(236,233,216));
		JTextField jtMoney=new JTextField("0", 5);
		JLabel jl2=new JLabel("Ԫ");
		jp4.add(jcb2);
		jp4.add(jtMoney);
		jp4.add(jl2);
		
		
		JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
		jp5.setBackground(new Color(236,233,216));
		
		JCheckBox jcb3=new JCheckBox("��ӡ������Ϣ");
		jcb3.setMargin(new Insets(0, 24, 0, 0));
		jcb3.setBackground(new Color(236,233,216));
		
		jp5.add(jcb3);
		
		
		jpCenter.add(jp1);
		jpCenter.add(jp2);
		JLabel jl=new JLabel("        ------------------------------------------------------------------------------------------");
		jl.setForeground(new Color(192,192,192));
		jpCenter.add(jl);
		jpCenter.add(jp3);
		jpCenter.add(jp4);
		jpCenter.add(jp5);
		
		return jpCenter;
	}
	
	
	public JPanel jpSouth(){
		GridBagLayout gbl=new GridBagLayout();
		JPanel jPanel=new JPanel(gbl);
		jPanel.setBackground(new Color(236,233,216));
		
		
		JLabel jl=new JLabel("��ע:");
		GridBagConstraints gbc1=new GBC(0, 0).setAnchor(GridBagConstraints.EAST).setAnchor(GridBagConstraints.NORTH);
		gbl.setConstraints(jl, gbc1);
		
		
		JTextArea jta=new JTextArea(3, 27);
		jta.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		GridBagConstraints gbc2=new GBC(1, 0);
		gbl.setConstraints(jta, gbc2);
		
		jPanel.add(jl);
		jPanel.add(jta);
		
		return jPanel;
	}
	
	

	public JLabel getJlBjjsff() {
		return jlBjjsff;
	}

	public JTextField getJtBjlx() {
		return jtBjlx;
	}

	public JTextField getJtZdbj() {
		return jtZdbj;
	}

	public JTextField getJtZdxf() {
		return jtZdxf;
	}

	public JTextField getJtSqyj() {
		return jtSqyj;
	}

	public JButton getJbQd() {
		return jbQd;
	}

	public JButton getJbQx() {
		return jbQx;
	}

	public JLabel getJltitle() {
		return jltitle;
	}
	
	
	
	
	
	
/*	public static void main(String[] args) {
		new GkkdDialog();
	}
*/
	
	
	
}

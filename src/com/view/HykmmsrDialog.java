package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.action.HykmmsrAction;
import com.view.util.MyJButton;

public class HykmmsrDialog extends JDialog{
	
	private MyJButton mjbQd=new MyJButton("确定").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(68, 20)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false);
	private MyJButton mjbQx=new MyJButton("退出").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(68, 20)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false);
	private JPasswordField jpfPassword=new JPasswordField(10);
	
	
	public HykmmsrDialog(BkjzDialog owner,boolean model){
		
		super(owner,model);
		super.setSize(286,155);
		super.setLocationRelativeTo(null);
		super.setTitle("会员卡密码输入窗口");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public void addListener(){
		HykmmsrAction action=new HykmmsrAction(this);
		mjbQd.addActionListener(action);
		mjbQx.addActionListener(action);
	}
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		
		jPanel.add(jp1());
		jPanel.add(jp2());
		
		return jPanel;
	}
	
	
	public JPanel jp1(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jPanel.setBounds(43,28, 200, 22);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		
		jPanel.add(new JLabel("会员卡密码："));
		jpfPassword.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpfPassword.setEchoChar('*');
		jPanel.add(jpfPassword);
		
		
		return jPanel;
	}
	
	
	public JPanel jp2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,48,0));
		jPanel.setBounds(0,73, 286, 21);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		
	
		jPanel.add(mjbQd);
		jPanel.add(mjbQx);
		
		return jPanel;
	
	}


	public MyJButton getMjbQd() {
		return mjbQd;
	}


	public MyJButton getMjbQx() {
		return mjbQx;
	}


	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}
	
	
	/*public static void main(String[] args){
		new HykmmsrDialog();
	}*/

}

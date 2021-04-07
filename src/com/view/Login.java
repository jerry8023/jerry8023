package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.action.LoginAction;
import com.dao.OperatorDao;
import com.view.util.ChineseCodePanel;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.GoodstypeVo;
import com.vo.OperatorVo;


/**
 *
 * Login.java:登入界面
 * @author czp
 * @time 2013-7-11 上午2:16:10
 */

public class Login extends JFrame{
	
	private static final long serialVersionUID = -2680349151235094241L;
	
	private MyJComBoBox mjcbName=new MyJComBoBox();
	private JPasswordField jpfPassword=new JPasswordField("123456",10);
	private JButton jbLogin=new JButton("登录");
	private JButton jbExit=new JButton("退出");
	private MyJButton mjbHyz=new MyJButton("换一张").set_Opaque(false).set_Margin(new Insets(0, 0, 0, 0)).set_ContentAreaFilled(false).set_PreferredSize(new Dimension(40, 22)).set_FocusPainted(false).set_Border(null);
	private JTextField jtfYz=new JTextField(6);
	private ChineseCodePanel jpYz=new ChineseCodePanel(110,35);
	private JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
	

	public Login(){
		
		super.setTitle("登入窗口");
		//super.setSize(325,245);
		super.setSize(335,250);
		super.setLocationRelativeTo(null);
		
		Container container=super.getContentPane();
		container.add(centercontain(),BorderLayout.CENTER);
		
		
		addListener();
		
		super.setResizable(false);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

	public void addListener(){
		LoginAction action=new LoginAction(this);
		jbLogin.addActionListener(action);
		jbExit.addActionListener(action);
		mjbHyz.addActionListener(action);
	}
	
	public JPanel centercontain(){
		
		//JPanel jp=new JPanel(new GridLayout(5,1));
		JPanel jp=new JPanel(null);
		
		JPanel jpTitle=new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		jpTitle.setBounds(-15, 0, 344, 50);
		jpTitle.setBackground(new Color(236,233,216));
		JLabel jlTitle1=new JLabel("");
		jlTitle1.setForeground(Color.RED);
		jlTitle1.setFont(new Font("黑体",Font.BOLD,24));
		JLabel jlTitle2=new JLabel("KTV娱乐行业管理系统");
		jlTitle2.setFont(new Font("黑体",Font.BOLD,24));
		
		jpTitle.add(jlTitle1);
		jpTitle.add(jlTitle2);
		
		
		JPanel jpName=new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
		jpName.setBounds(-15,50, 344, 40);
		jpName.setBackground(new Color(236,233,216));
		jpName.add(new JLabel("用户名称:"));
		
		
		
		try {
			OperatorDao dao=new OperatorDao();
			ArrayList<OperatorVo> dataList=dao.getAllOperator();
			for(OperatorVo vo:dataList){
				mjcbName.addItem(vo.getNickname(),vo.getOid());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,"数据查找失败");
			e1.printStackTrace();
		}
		
		mjcbName.setPreferredSize(new Dimension(110,20));
		jpName.add(mjcbName);
		
		
		JPanel jpPassword=new JPanel();
		jpPassword.setBounds(-15,95, 344,30);
		jpPassword.setBackground(new Color(236,233,216));
		jpPassword.add(new JLabel("用户密码:"));
		jpfPassword.setEchoChar('*');
		jpPassword.add(jpfPassword);
		
		
		JPanel jpCommand=new JPanel(new FlowLayout(FlowLayout.CENTER,30,10));
		jpCommand.setBounds(-10,175, 344,40);
		jpCommand.setBackground(new Color(236,233,216));
		jbLogin.setBackground(null);
		jbLogin.setOpaque(false);
		jbLogin.setBorder(BorderFactory.createRaisedBevelBorder());
		jbLogin.setPreferredSize(new Dimension(65,22));
		
		
		jbExit.setBackground(null);
		jbExit.setOpaque(false);
		jbExit.setBorder(BorderFactory.createRaisedBevelBorder());
		jbExit.setPreferredSize(new Dimension(65,22));
		
		jpCommand.add(jbLogin);
		jpCommand.add(jbExit);
		
		
		//------------------------------------------
		
		jp5.setBounds(78,125, 344,30);
		jp5.setBackground(null);
		jp5.setOpaque(false);
		jp5.add(new JLabel("验证码:"));
		jpYz.setPreferredSize(new Dimension(110,35));
		jp5.add(jtfYz);
		jp5.add(jpYz);
		
		
		mjbHyz.setBounds(260, 156, 60, 22);
		
		
		jp.add(jpTitle);
		jp.add(jpName);
		jp.add(jpPassword);
		jp.add(jp5);
		jp.add(jpCommand);
		jp.add(mjbHyz);
		
		jp.setBackground(new Color(236,233,216));
		
		return jp;
		
	}
	
	
	
	public MyJComBoBox getMjcbName() {
		return mjcbName;
	}


	public JPasswordField getJpfPassword() {
		return jpfPassword;
	}


	public JButton getJbLogin() {
		return jbLogin;
	}


	public JButton getJbExit() {
		return jbExit;
	}

	
	public MyJButton getMjbHyz() {
		return mjbHyz;
	}


	public JTextField getJtfYz() {
		return jtfYz;
	}


	public ChineseCodePanel getJpYz() {
		return jpYz;
	}
	

	public void setJpYz(ChineseCodePanel jpYz) {
		this.jpYz = jpYz;
	}

	public JPanel getJp5() {
		return jp5;
	}


	public static void main(String[] args) {
		new Login();
	}

}

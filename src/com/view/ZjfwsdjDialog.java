package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.ZjfwsdjAction;
import com.view.util.MyJButton;

/**
 *
 * ZjfwsdjDialog.java:增删服务生等级界面
 * @author ZP
 * @time 2013-7-14 下午11:51:31
 * 
 */
public class ZjfwsdjDialog extends JDialog {
 
	
	private static final long serialVersionUID = 8814724404081441710L;
	JTextField jtfDjbh=new JTextField(8);//等级编号文本框
	JTextField jtfFwsdj=new JTextField(8);//服务生等级文本框
	
    MyJButton mjbBcFwsdj=new MyJButton("保存");
	MyJButton mjbQxFwsdj=new MyJButton("取消"); 
	
	XtszDialog  xtsz;
	
	
	public XtszDialog getXtsz() {
		return xtsz;
	}
	//定义常量
	public static final int ADD=1;
	public static final int UPDATE=2;
	
	//定义变量接收常量
	public static int addOrUpdate;
	 
	
	public ZjfwsdjDialog(XtszDialog  ower,boolean  model,int addOrUpdate){
		 
		//调用父类的构造方法，将dialog传递过去
        super(ower, model);	
        this.xtsz=ower;
       if(addOrUpdate==ADD ||  addOrUpdate==UPDATE ){ 
        this.addOrUpdate=addOrUpdate;
        
        if(addOrUpdate==ADD){
    		this.setTitle("添加服务生等级");	
    		}else if(addOrUpdate==UPDATE){
    			this.setTitle("修改服务生等级");
    			
    		} 
       }
		this.setSize(250, 212);
		
		 
		Container container=this.getContentPane();
		container.add(center(),BorderLayout.CENTER);
		
	 
		addListener();
		this.setLocationRelativeTo(null);//居中
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		 
		
		
		 
		
	} 
	
	 public void addListener(){
     
		 ZjfwsdjAction  zjfwsdjAction=new  ZjfwsdjAction(this);
		 
		 mjbBcFwsdj.addActionListener(zjfwsdjAction);
		 mjbQxFwsdj.addActionListener(zjfwsdjAction);
		 
		 
	 }
	
	
	 public JPanel center(){
	
		 JPanel jp=new JPanel(null);
		 jp.setBackground(new Color(236,233,216));
		 
	  JPanel  jPanel=new  JPanel(new  GridLayout(3, 1));
	  jPanel.setBackground(new Color(236,233,216));
	  jPanel.setBounds(15,35, 200, 121);
	  
	  	JPanel firstPanel=new JPanel();
	  	firstPanel.setBackground(new Color(236,233,216));
	  	firstPanel.add(new JLabel("    等级编号："));
	  	
	  	//JTextField jtfDjbh=new JTextField(8);
	   	//jtfDjbh.setEditable(false);//将文本框设置为不可编辑
	  	//jtfDjbh.setEnabled(false);
	  	firstPanel.add(jtfDjbh);
	  	
	  	
	  	if(this.addOrUpdate==ZjfwsdjDialog.UPDATE){
	  		jtfDjbh.setText(xtsz.getjTableFwsdj().getValueAt(xtsz.getjTableFwsdj().getSelectedRow(), 0).toString());
	  		jtfFwsdj.setText(xtsz.getjTableFwsdj().getValueAt(xtsz.getjTableFwsdj().getSelectedRow(), 1).toString());
	  		jtfDjbh.setEnabled(false);
	  	}
	  	
	  	
	  	JPanel secondPanel=new JPanel();
	  	secondPanel.setBackground(new Color(236,233,216));
	  	
	  	secondPanel.add(new JLabel("服务生等级："));
	  	secondPanel.add(jtfFwsdj);
	  	
	  	JPanel  thirdPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 15));
	  	thirdPanel.setBackground(new Color(236,233,216));
	  	
	  		 mjbBcFwsdj.set_Background(new Color(248,245,229));
	  		 mjbBcFwsdj.set_FocusPainted(false);
	  		 mjbBcFwsdj.set_Margin(new Insets(0, 0, 0, 0));
	  		 mjbBcFwsdj.set_PreferredSize(new Dimension(67, 22));
	  		 
	  		 mjbQxFwsdj.set_Background(new Color(248,245,229));
	  		 mjbQxFwsdj.set_FocusPainted(false);
	  		 mjbQxFwsdj.set_Margin(new Insets(0, 0, 0, 0));
	  		 mjbQxFwsdj.set_PreferredSize(new Dimension(67, 22));
		  	
	  		thirdPanel.add(mjbBcFwsdj);
	  		thirdPanel.add(mjbQxFwsdj);
	  		
	  		
	  		
	  	
	  	
	  	jPanel.add(firstPanel);
	  	jPanel.add(secondPanel);
	  	jPanel.add(thirdPanel);
	  	
	  	
	  	jp.add(jPanel);
	  	
		return jp;
	  	
	 }
	
	 

	public JTextField getJtfDjbh() {
		return jtfDjbh;
	}
	public JTextField getJtfFwsdj() {
		return jtfFwsdj;
	}
	public MyJButton getMjbBcFwsdj() {
		return mjbBcFwsdj;
	}
	public MyJButton getMjbQxFwsdj() {
		return mjbQxFwsdj;
	}
	
	 
}

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
 * ZjfwsdjDialog.java:��ɾ�������ȼ�����
 * @author ZP
 * @time 2013-7-14 ����11:51:31
 * 
 */
public class ZjfwsdjDialog extends JDialog {
 
	
	private static final long serialVersionUID = 8814724404081441710L;
	JTextField jtfDjbh=new JTextField(8);//�ȼ�����ı���
	JTextField jtfFwsdj=new JTextField(8);//�������ȼ��ı���
	
    MyJButton mjbBcFwsdj=new MyJButton("����");
	MyJButton mjbQxFwsdj=new MyJButton("ȡ��"); 
	
	XtszDialog  xtsz;
	
	
	public XtszDialog getXtsz() {
		return xtsz;
	}
	//���峣��
	public static final int ADD=1;
	public static final int UPDATE=2;
	
	//����������ճ���
	public static int addOrUpdate;
	 
	
	public ZjfwsdjDialog(XtszDialog  ower,boolean  model,int addOrUpdate){
		 
		//���ø���Ĺ��췽������dialog���ݹ�ȥ
        super(ower, model);	
        this.xtsz=ower;
       if(addOrUpdate==ADD ||  addOrUpdate==UPDATE ){ 
        this.addOrUpdate=addOrUpdate;
        
        if(addOrUpdate==ADD){
    		this.setTitle("��ӷ������ȼ�");	
    		}else if(addOrUpdate==UPDATE){
    			this.setTitle("�޸ķ������ȼ�");
    			
    		} 
       }
		this.setSize(250, 212);
		
		 
		Container container=this.getContentPane();
		container.add(center(),BorderLayout.CENTER);
		
	 
		addListener();
		this.setLocationRelativeTo(null);//����
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
	  	firstPanel.add(new JLabel("    �ȼ���ţ�"));
	  	
	  	//JTextField jtfDjbh=new JTextField(8);
	   	//jtfDjbh.setEditable(false);//���ı�������Ϊ���ɱ༭
	  	//jtfDjbh.setEnabled(false);
	  	firstPanel.add(jtfDjbh);
	  	
	  	
	  	if(this.addOrUpdate==ZjfwsdjDialog.UPDATE){
	  		jtfDjbh.setText(xtsz.getjTableFwsdj().getValueAt(xtsz.getjTableFwsdj().getSelectedRow(), 0).toString());
	  		jtfFwsdj.setText(xtsz.getjTableFwsdj().getValueAt(xtsz.getjTableFwsdj().getSelectedRow(), 1).toString());
	  		jtfDjbh.setEnabled(false);
	  	}
	  	
	  	
	  	JPanel secondPanel=new JPanel();
	  	secondPanel.setBackground(new Color(236,233,216));
	  	
	  	secondPanel.add(new JLabel("�������ȼ���"));
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

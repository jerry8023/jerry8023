package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.CkszZsgAction;
import com.view.util.MyJButton;



public class CkszZsgDialog extends JDialog {
	
	JTextField jtfCkbh=new JTextField();//�ֿ���
	JTextField jtfCkmc=new JTextField();//�ֿ�����
	
	MyJButton jbQd=new MyJButton("ȷ��").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 21));
	MyJButton jbQx=new MyJButton("ȡ��").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 21));
    
	CkszDialog cksz;
	
	
	public CkszDialog getCksz() {
		return cksz;
	}

	//���峣��
	public static final int ADD=1;
	public static final int UPDATE=2;
	public static int addorUpdate;
	
	public CkszZsgDialog(CkszDialog ower,boolean model,int addorUpdate){
		
		super(ower,model);//���ø���Ĺ��췽��
		if(addorUpdate==ADD||addorUpdate==UPDATE){
			this.addorUpdate=addorUpdate;
			
			if(addorUpdate==ADD){
				this.setTitle("���Ӳֿ�����");
				 
			}else if(addorUpdate==UPDATE){
				this.setTitle("�޸Ĳֿ�����");
			}
			
			
		}
		this.setSize(259,202);
		this.cksz=ower;
		Container container=this.getContentPane();
		container.add(centerPanel(),BorderLayout.CENTER);
		
		addLister();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
	}
	
      public void addLister(){
    	  
    	  CkszZsgAction  ckszZsgAction= new CkszZsgAction(this);
    	  jbQd.addActionListener(ckszZsgAction);
    	  jbQx.addActionListener(ckszZsgAction);//ע�����
      }	
 	
	  public JPanel  centerPanel(){
		  
		  	JPanel  jPanel=new JPanel(null);
		  	jPanel.setBackground(new Color(236,233,216));
		  	
		  	
		  	
		  	JPanel firstPanel=new JPanel();
		  	firstPanel.setBounds(20, 20, 200,30);
		  	firstPanel.setBackground(new Color(236,233,216));
		  	firstPanel.add(new JLabel("�ֿ��ţ�"));
		  	
		  	 
		  	jtfCkbh.setPreferredSize(new Dimension(121,21));
		  	jtfCkbh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���ñ߿���ɫ
		  	
		  	firstPanel.add(jtfCkbh);
		  	
		  	
		  	JPanel secondPanel=new JPanel();
		  	secondPanel.setBounds(20, 60, 200,30);
		  	secondPanel.setBackground(new Color(236,233,216));
		  	secondPanel.add(new JLabel("�ֿ����ƣ�"));
		  	
		  	 
		  	jtfCkmc.setPreferredSize(new Dimension(121,21));
		  	jtfCkmc.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���ñ߿���ɫ
		  	
		  	secondPanel.add(jtfCkmc);
		  	
		  	JPanel thirdpPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		  	thirdpPanel.setBounds(10, 115, 200,25);
		  	thirdpPanel.setBackground(new Color(236,233,216));
		  	
		  	thirdpPanel.add(jbQd);
		  	thirdpPanel.add(jbQx);
		  	
		  	
		  	if(this.addorUpdate==2){
		  		jtfCkbh.setText(cksz.getJtCk().getValueAt(cksz.getJtCk().getSelectedRow(), 0).toString());
		  		jtfCkmc.setText(cksz.getJtCk().getValueAt(cksz.getJtCk().getSelectedRow(), 1).toString());
		  		jtfCkbh.setEnabled(false);
		  	}
		  	
		  jPanel.add(firstPanel);
		  jPanel.add(secondPanel);
		  jPanel.add(thirdpPanel);
		  return jPanel;
	  }
	 
	
	
	public int getAddorUpdate() {
		return addorUpdate;
	}

	public JTextField getJtfCkbh() {
		return jtfCkbh;
	}

	public JTextField getJtfCkmc() {
		return jtfCkmc;
	}

	public MyJButton getJbQd() {
		return jbQd;
	}

	public MyJButton getJbQx() {
		return jbQx;
	}


}

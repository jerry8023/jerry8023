package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ContainerEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BmckszDialog extends JDialog{
	 
	
	
	 public BmckszDialog(CkszDialog owner,boolean model){
		 
		super(owner,model);
		this.setSize(286,186);	
		this.setTitle("���š��ֿ�����");
		
		Container container=this.getContentPane();
		container.add(centerPanel(),BorderLayout.CENTER);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	 public JPanel centerPanel(){
		
		 JPanel jPanel=new JPanel(new GridLayout(3,1));
		 
		 JPanel firstPanel=new JPanel();
		 firstPanel.add(new JLabel("�����������ţ�"));
		 
		 Object  []items1=new Object[]{}; 
		 JComboBox  jcbBjssbm=new JComboBox(items1);//121  23
		 jcbBjssbm.setPreferredSize(new Dimension(121,23));//����������С
		 jcbBjssbm.setBorder(null);//ȥ�߿�
		 jcbBjssbm.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���ñ߿���ɫ
		 firstPanel.add(jcbBjssbm);
		 
		 
		 
		 JPanel secondPanel=new JPanel();
		 secondPanel.add(new JLabel("���������ֿ⣺"));
		 Object [] items2=new Object[]{}; 
		 JComboBox jcbBjssck=new JComboBox(items2);
		 jcbBjssck.setPreferredSize(new Dimension(121,23));//����������С //����������С
		 jcbBjssck.setBorder(null);//ȥ�߿�
		 jcbBjssck.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		 secondPanel.add(jcbBjssck);
		 
		 
		 JPanel thirdPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
		 
		 JButton jbBc=new JButton("ȷ��");
		 thirdPanel.add(jbBc);
		 
		 JButton jbQx=new JButton("ȡ��");
		 thirdPanel.add(jbQx);
		 
		 
		 
		 jPanel.add(firstPanel);
		 jPanel.add(secondPanel);
		 jPanel.add(thirdPanel);
		 return jPanel;
		 
		 
		 
	 }
	 

}

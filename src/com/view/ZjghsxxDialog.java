package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.action.ZjghsxxAction;
import com.view.util.GBC;
import com.view.util.MyJButton;

public class ZjghsxxDialog extends JDialog {
    
	
	public  static final  int ADD=1;
	public  static final int UPDATE=2;
	public  int addOrUpdate;
	private GhsxxDialog maindialog;
	
	MyJButton jbsave=new MyJButton("保存");
	MyJButton jbcancel=new MyJButton("取消");
	JTextField jtbh=new JTextField(15);
	JTextField jtqc=new JTextField(15);
	JTextField jtjp=new JTextField(15);
	JTextField jtr=new JTextField(15);
	JTextField jtdh=new JTextField(15);
	JTextField jtdz=new JTextField(15);
	JTextArea  jtabz=new JTextArea(3,15);
	JTextField jtfs=new JTextField(15);
	public ZjghsxxDialog(GhsxxDialog ower,boolean modl,int number){
		super(ower,modl);
		
		if(number==ADD || number==UPDATE ){
			this.addOrUpdate=number;
			if(number==ADD){
				super.setTitle("添加供货商信息");
			}else if(number==UPDATE){
				super.setTitle("修改供货商信息");
			}
			
			
		}
		super.setSize(340,390);
		super.setLocationRelativeTo(null);
		Container container=super.getContentPane();
		container.add(center(),BorderLayout.CENTER);
		container.add(sorth(),BorderLayout.SOUTH);
		addListener();
		super.setResizable(false);	
 		super.setVisible(true);
 		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	
	public void addListener(){
		ZjghsxxAction  action=new ZjghsxxAction(this);
		jbsave.addActionListener(action);
		jbcancel.addActionListener(action);
		
	}
	
	
	public JPanel  center(){
		
		GridBagLayout gbl=new GridBagLayout();
		JPanel jpanel=new JPanel(gbl);
		jpanel.setBackground(new Color(236,233,216));
		
		JLabel jlbh = new JLabel("单位编号:");
		gbl.setConstraints(jlbh, new GBC(0, 0).setInSets(15, 15, 8, 0));
		jpanel.add(jlbh);
        
        gbl.setConstraints(jtbh, new GBC(1,0).setInSets(15, 5, 8, 0));
        jtbh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtbh);
		
		JLabel jlqc = new JLabel("单位全称:");
		gbl.setConstraints(jlqc, new GBC(0, 1).setInSets(0, 15, 8, 0));
		jpanel.add(jlqc);
		
        gbl.setConstraints(jtqc, new GBC(1,1).setInSets(0, 5, 8, 0));
        jtqc.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtqc);
		
		JLabel jljp = new JLabel("单位简拼:");
		gbl.setConstraints(jljp, new GBC(0, 2).setInSets(0, 15, 8,0));
		jpanel.add(jljp);
		
        gbl.setConstraints(jtjp, new GBC(1,2).setInSets(0, 5, 8, 0));
        jtjp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtjp);
        
		JLabel jllxr =new JLabel("联  系  人:");
		gbl.setConstraints(jllxr, new GBC(0, 3).setInSets(0, 15, 8,0));
		jpanel.add(jllxr);
		
        gbl.setConstraints(jtr, new GBC(1,3).setInSets(0, 5, 8, 0));
        jtr.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtr);
        
		JLabel jldh = new JLabel("联系电话:");
		gbl.setConstraints(jldh, new GBC(0, 4).setInSets(0, 15, 8,0));
		jpanel.add(jldh);
		
        gbl.setConstraints(jtdh, new GBC(1,4).setInSets(0, 5, 8, 0));
        jtdh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtdh);
        
		JLabel jldz = new JLabel("联系地址:");
		gbl.setConstraints(jldz, new GBC(0, 5).setInSets(0, 15, 8,0));
		jpanel.add(jldz);
		
		
        gbl.setConstraints(jtdz, new GBC(1,5).setInSets(0, 5, 8, 0));
        jtdz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtdz);
        
        JLabel jlfs = new JLabel("默认方式:");
		gbl.setConstraints(jlfs, new GBC(0, 6).setInSets(0, 15, 8,0));
		jpanel.add(jlfs);
		
        gbl.setConstraints(jtfs, new GBC(1,6).setInSets(0, 5, 8, 0));
        jtfs.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
        jpanel.add(jtfs);
		
		
		JLabel jlbz = new JLabel("备注信息:");
		gbl.setConstraints(jlbz, new GBC(0, 7).setInSets(0, 15, 8,0).setAnchor(GBC.NORTHEAST));
		jpanel.add(jlbz);
		
		gbl.setConstraints(jtabz, new GBC(1, 7,3,1).setFill(GBC.HORIZONTAL));
		jtabz.setBorder(BorderFactory.createLineBorder(new Color(170, 184, 131)));
		jtabz.setBackground(new Color(247,247,247));
		jpanel.add(jtabz);
		
		JCheckBox jcbIsmr=new JCheckBox("设为默认供货商");
		jcbIsmr.setBackground(null);
		jcbIsmr.setOpaque(false);
		gbl.setConstraints(jcbIsmr, new GBC(0, 8, 2, 1).setAnchor(GBC.WEST).setInSets(0, 12, 0, 0));
		jpanel.add(jcbIsmr);
		
		return jpanel;
		
	}
	
	
	public JPanel sorth(){
		
		JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT,70,20));
		jp.setBackground(new Color(236,233,216));
		
		
		jbsave.set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(70,21)).set_Background(new Color(249,246,230));
		//jbsave.setPreferredSize(new Dimension(75, 21));
		
		jbcancel.set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(70,21)).set_Background(new Color(249,246,230));

		//jbcancel.setMargin(new Insets(0, 10, 0, 10));
        jp.add(jbsave);
        jp.add(jbcancel);
		
		
		
		return jp;
	}
	
	public JTextField getJtfs() {
		return jtfs;
	}

	public MyJButton getJbsave() {
		return jbsave;
	}
	public MyJButton getJbcancel() {
		return jbcancel;
	}
	public JTextField getJtbh() {
		return jtbh;
	}
	public JTextField getJtqc() {
		return jtqc;
	}
	public JTextField getJtjp() {
		return jtjp;
	}
	public JTextField getJtr() {
		return jtr;
	}
	public JTextField getJtdh() {
		return jtdh;
	}
	public JTextField getJtdz() {
		return jtdz;
	}
	public JTextArea getJtabz() {
		return jtabz;
	}
	
	public void setJtbh(JTextField jtbh) {
		this.jtbh = jtbh;
	}

	public static void main(String[] args) {
	//s	new ZjghsxxDialog(ower,true,ad);

	}

}

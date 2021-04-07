package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.util.ColumnContent;

public class SpszDialog extends JDialog{
	
	
	private static final long serialVersionUID = 6589907913875558397L;


	public SpszDialog(SpglDialog owner,boolean model){
		
		super(owner,model);
		super.setSize(595,465);
		super.setLocationRelativeTo(null);
		super.setTitle("商品设置");
		super.setResizable(false);
		
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
	}
	
	
	
	public JPanel content(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		jPanel.add(contentOfSplxsz());
		jPanel.add(contentOfSpsz());
		
		
		return jPanel;
		
	}
	
	
	public JPanel contentOfSplxsz(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,172,117)), "商品类型设置",TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.PLAIN, 12),Color.BLUE));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(7, 9, 577, 151);
		
		//---------------------------------------------------
		JTable jTableSplx=new JTable(null, ColumnContent.arrayToVector(ColumnContent.SHANGPINLEIBIE_CLUMN_NAME));
		JScrollPane jScrollPane=new JScrollPane(jTableSplx,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),2));
		jScrollPane.setBounds(10,22,478,117);
		//-----------------------------------------------------
		
		GridLayout gl1=new GridLayout(3,1);
		gl1.setVgap(16);
		JPanel jp1=new JPanel(gl1);
		jp1.setBounds(500, 39, 66, 96);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		
		JButton jbTjSplx=new JButton("添加");
		jbTjSplx.setBackground(new Color(251,249,231));
		JButton jbXgSplx=new JButton("修改");
		jbXgSplx.setBackground(new Color(251,249,231));
		JButton jbScSplx=new JButton("删除");
		jbScSplx.setBackground(new Color(251,249,231));
		
		jp1.add(jbTjSplx);
		jp1.add(jbXgSplx);
		jp1.add(jbScSplx);
		
		
		
		
		jPanel.add(jScrollPane);
		jPanel.add(jp1);
		
		return jPanel;
	}

	
	public JPanel contentOfSpsz(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,172,117)), "商品设置",TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.PLAIN, 12),Color.BLUE));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(7, 166, 577,268);
		
		//----------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(new Color(236,233,216));
		jp1.setBounds(40,20,400,24);
		
		jp1.add(new JLabel("  按项目类别过滤: "));
		
		JComboBox jcbSplx=new JComboBox();
		jcbSplx.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));
		jcbSplx.setPreferredSize(new Dimension(93,24));
		jcbSplx.setBackground(Color.WHITE);
		jp1.add(jcbSplx);
		
		jp1.add(new JLabel("  简称: "));
		
		JTextField jtfSpjc=new JTextField(4);
		jtfSpjc.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));
		jp1.add(jtfSpjc);
		
		//------------------------------------------------------------
		
		JTable jTableSp=new JTable(null, ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
		jTableSp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane1=new JScrollPane(jTableSp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),2));
		jScrollPane1.setBounds(10,43,478,214);
		
		//--------------------------------------------------------------
		
		GridLayout gl1=new GridLayout(3,1);
		gl1.setVgap(16);
		JPanel jp2=new JPanel(gl1);
		jp2.setBounds(500, 146, 66, 96);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JButton jbTjSp=new JButton("添加");
		jbTjSp.setBackground(new Color(251,249,231));
		JButton jbXgSp=new JButton("修改");
		jbXgSp.setBackground(new Color(251,249,231));
		JButton jbScSp=new JButton("删除");
		jbScSp.setBackground(new Color(251,249,231));
		
		jp2.add(jbTjSp);
		jp2.add(jbXgSp);
		jp2.add(jbScSp);
		
		//------------------------------------------------------------
		
		jPanel.add(jp1);
		jPanel.add(jScrollPane1);
		jPanel.add(jp2);
		
		
		return jPanel;
	}
	
	

}

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.action.GhsxxAction;
import com.dao.GhsxxDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;

public class GhsxxDialog extends JDialog {
	
	
	private static final long serialVersionUID = 9103195097298101738L;

	
	MyJButton mjbZjGhsxx=new MyJButton("image/zj0.png", "image/zj1.png","image/zj2.png");
	MyJButton mjbXgGhsxx=new MyJButton("image/xg0.png","image/xg1.png","image/xg2.png");
	MyJButton mjbScGhsxx=new MyJButton("image/sc0.png","image/sc1.png","image/sc2.png");
	JTextField jtfDwbhjc=new JTextField(10);
	MyJButton mjbCxGhsxx;
	MyJButton mjbDyGhsxx;
	JTable jtGhsxx;
	public GhsxxDialog(SpglDialog owner,boolean model){
		
		super(owner,model);
		super.setSize(697,505);
		super.setLocationRelativeTo(null);
		super.setTitle("供货商信息");
		super.setResizable(false);
		
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		addListener();
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	public void addListener(){
		GhsxxAction anctio=new GhsxxAction(this);
		mjbZjGhsxx.addActionListener(anctio);
		mjbXgGhsxx.addActionListener(anctio);
		mjbScGhsxx.addActionListener(anctio);
		mjbCxGhsxx.addActionListener(anctio);
		mjbDyGhsxx.addActionListener(anctio);
		
	}
	public JPanel content(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		jPanel.add(contentOfNorth());
		jPanel.add(contentOfCenter());
		jPanel.add(contentOfSouth());
		
		
		return jPanel;
		
	}
	
	
	public JPanel contentOfNorth(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(20,20,602,40);
		
		
		//---------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-5));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setPreferredSize(new Dimension(138, 40));
		
		
		
		jp1.add(mjbZjGhsxx);
		jp1.add(mjbXgGhsxx);
		jp1.add(mjbScGhsxx);
		
		//------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		
		JLabel jlDwbhjc=new JLabel("单位编号/简称：");
		jlDwbhjc.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		jtfDwbhjc.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		jp2.add(jlDwbhjc);
		jp2.add(jtfDwbhjc);
		
		//--------------------------------------------------------------
		
	    mjbCxGhsxx=new MyJButton("查询").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(70, 20));
		mjbCxGhsxx.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDcGhsxx=new MyJButton("导出").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(70, 20));
		mjbDcGhsxx.setFont(new Font("宋体", Font.PLAIN, 12));
		mjbDyGhsxx=new MyJButton("打印").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(70, 20));
		mjbDyGhsxx.setFont(new Font("宋体", Font.PLAIN, 12));
		
		//--------------------------------------------------------------
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(mjbCxGhsxx);
		jPanel.add(mjbDcGhsxx);
		jPanel.add(mjbDyGhsxx);
		
		return jPanel;
		
		
	}
	
	
	public JPanel contentOfCenter(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,172,117)), "供货商信息",TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.PLAIN, 12),Color.BLUE));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(7,59,676,225);
		
		
		Vector<Vector> data=null;
		GhsxxDao  gdao=new GhsxxDao();
		try {
			data=gdao.querGhsxx();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	    jtGhsxx=new JTable(data,ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
	    jtGhsxx.setAutoCreateRowSorter(true);
	    jtGhsxx.setFillsViewportHeight(true);
	    
	    JScrollPane jScrollPane1=new JScrollPane(jtGhsxx, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),2));
		jScrollPane1.setBounds(1,21,673,204);
		
		
		jPanel.add(jScrollPane1);
		
		return jPanel;
	}
	
	
	public JPanel contentOfSouth(){
		
		
		
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,172,117)), "往来账务",TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.PLAIN, 12),Color.BLUE));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(7,285,676, 188);
		
		
		
		JTable jtWlzwGhs=new JTable(null,ColumnContent.arrayToVector(ColumnContent.WANGLAIZHANGWUGHS_CLUMN_NAME));
		jtWlzwGhs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane1=new JScrollPane(jtWlzwGhs, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),2));
		jScrollPane1.setBounds(1,21,673,167);
		
		
		jPanel.add(jScrollPane1);
		
		return jPanel;
		
		
	}
	
	

	
	public MyJButton getMjbZjGhsxx() {
		return mjbZjGhsxx;
	}

	public MyJButton getMjbXgGhsxx() {
		return mjbXgGhsxx;
	}

	public MyJButton getMjbScGhsxx() {
		return mjbScGhsxx;
	}

	public MyJButton getMjbCxGhsxx() {
		return mjbCxGhsxx;
	}

	public JTable getJtGhsxx() {
		return jtGhsxx;
	}

	public JTextField getJtfDwbhjc() {
		return jtfDwbhjc;
	}
	public MyJButton getMjbDyGhsxx() {
		return mjbDyGhsxx;
	}
	
	
	/*public static void main(String[] args) {
		new GhsxxDialog();
	}*/

}

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import com.util.ColumnContent;
import com.view.util.MyJButton;



public class ZdLdbkxfmxDialog extends JDialog{
	       
	  
	private static final long serialVersionUID = -1594875757197938009L;



	public ZdLdbkxfmxDialog(){
		super.setTitle("在店宾客消费明细");
		super.setSize(721, 593);
		super.setResizable(false);
		Container container=super.getContentPane();
		//container.setBackground(Color.red);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		container.add(jtNorth(),BorderLayout.CENTER);
		
		
		JPanel jpNorth=new JPanel();
		jpNorth.setBackground(new Color(236,233,216));
		jpNorth.setPreferredSize(new Dimension(725, 15));
		jpNorth.setBorder(BorderFactory.createLineBorder(new Color(180, 196, 139)));
		
		container.add(jpNorth,BorderLayout.NORTH);
		
	
		super.setVisible(true);
	
	}
	
	
	
	
	
	public JPanel jtNorth(){
		
		JPanel jPanel0=new JPanel(new BorderLayout());
		jPanel0.setBackground(new Color(236,233,216));
		
		
		/*JButton jbzdbkxfmx=new JButton("在店宾客消费明细");
		JButton jbldbkxfmx=new JButton("离店宾客消费明细");
		*/
		JTabbedPane jtpzdbkxfmx=new JTabbedPane(JTabbedPane.NORTH);
		jtpzdbkxfmx.setBackground(new Color(249,246,230));
		jtpzdbkxfmx.getSelectedIndex();
		jtpzdbkxfmx.getSelectedComponent();
		
	
		jPanel0.add(jtpzdbkxfmx,BorderLayout.CENTER);
		
		//jpzdbkxfmx---------------------开始----------------------------------
	    JPanel jpzdbkxfmx =new JPanel(null);
	    jpzdbkxfmx.setBackground(new Color(236,233,216));
	     jtpzdbkxfmx.addTab("在店宾客消费明细",  jpzdbkxfmx);
	     jpzdbkxfmx.setBorder(BorderFactory.createLineBorder(new Color(180,169,136)));
	     
	     
	     JPanel jpanel=new JPanel(new FlowLayout(FlowLayout.LEFT,15,8));
	     jpanel.setBackground(new Color(236,233,216));
	     //jpanel.setBackground(Color.pink);
	     //jpanel.setBounds(5, 5, width, height)
	     
	     
	     JLabel jlxzcx=new JLabel("选择查询条件(Q):");
	    // jlxzcx.setBounds(30, 14, 97, 16);
	     
	     JComboBox jczdbk=new JComboBox();
	     jczdbk.setPreferredSize(new Dimension(97, 20));
	     jczdbk.addItem("按包间号");
	     jczdbk.addItem("按消费项目");
	     jczdbk.setBackground(Color.white);
	     //jczdbk.setBounds(127,14,69,23);
	     JLabel jlcxgjz=new JLabel("查询关键字:");
	     JTextField jtcxgjz=new JTextField(10);
	     MyJButton jbzdcx=new MyJButton("查询").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 20)).set_FocusPainted(false);
	     
	     MyJButton jbzdsx=new MyJButton("刷新").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 20)).set_FocusPainted(false);
	     
	     MyJButton jbzddc=new MyJButton("导出").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 20)).set_FocusPainted(false);
	     
	     MyJButton jbzddy=new MyJButton("打印").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 20)).set_FocusPainted(false);
	     
	   // jpanel.add(jlxzcx,new FlowLayout(0, 0, 88));
	    jpanel.add(jlxzcx);
	    jpanel.add(jczdbk);
	    jpanel.add(jlcxgjz);
	    jpanel.add(jtcxgjz);
	    jpanel.add(jbzdcx);
	    jpanel.add(jbzdsx);
	    jpanel.add(jbzddc);
	    jpanel.add(jbzddy);
	    jpanel.setBounds(1, 1, 712, 40);
	    jpzdbkxfmx.add(jpanel);
	     
	     JPanel jpanel2=new JPanel(null);
	     JLabel jlzdbkxfmx1=new JLabel("在店宾客消费明细");
	     jpanel2.add(jlzdbkxfmx1);
	     jpanel2.setBackground(Color.blue);
	     jpanel2.setBounds(10, 40, 693, 460);
	     JPanel jpanel2_1=new JPanel(new FlowLayout(FlowLayout.CENTER,1,1));
	     jpanel2_1.add(jlzdbkxfmx1);
	     jpanel2_1.setBounds(0, 0, 693, 16);
	     jpanel2_1.setBackground(new Color(170,	184,131 ));
	     jpanel2.add(jpanel2_1);
	     
	     
	     
	     
	     JTable   jtble2=new JTable(null,ColumnContent.arrayToVector(ColumnContent.ZAIDIANBINKEXIAOFEI_CLUMN_NAME));
	     jtble2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     
	     
	     JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
	     
	     JTextField jtSlZdbkxf=new JTextField(5);
	     jtSlZdbkxf.setBackground(null);
	     jtSlZdbkxf.setOpaque(false);
	     
	     JTextField jtYhjeZdbkxf=new JTextField(5);
	     jtYhjeZdbkxf.setBackground(null);
	     jtYhjeZdbkxf.setOpaque(false);
	     
	     JTextField jtYsjeZdbkxf=new JTextField(5);
	     jtYsjeZdbkxf.setBackground(null);
	     jtYsjeZdbkxf.setOpaque(false);
	     
	     jp1.add(jtSlZdbkxf);
	     jp1.add(jtYhjeZdbkxf);
	     jp1.add(jtYsjeZdbkxf);

	     
	     //jp.add(jtble2,BorderLayout.CENTER);
	     //jp.add(jp1,BorderLayout.SOUTH);
	     
	     
	     JScrollPane  jscrollpane2=new JScrollPane(jtble2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    		 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	     //jscrollpane2.setViewportView(jp1);
	     //jscrollpane2.setBackground(Color.black);
	     jscrollpane2.setBounds(0, 16, 693, 444);
	     jpanel2.add(jscrollpane2);
	     
	    /* JPanel jpanel2_2=new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
	     JTextField jtshul=new JTextField(5);
	     JTextField jtyouh=new JTextField(5);
	     JTextField jtyings=new JTextField(5);
	     jpanel2_2.add(jtshul);
	     jpanel2_2.add(jtyouh);
	     jpanel2_2.add(jtyings);
	     jpanel2_2.setBounds(0, 416, 692, 45);
	     jpanel2_2.setBackground(Color.pink);
	    jpanel2.add(jpanel2_2);*/
	     //jscrollpane2.add(jpanel2_2);
	     jpzdbkxfmx.add(jpanel2);
	     
	  
	     jpzdbkxfmx.setBorder(BorderFactory.createLineBorder(new Color(170, 184, 131) ));
	     // jpzdbkxfmx----------------------------结束--------------------------------------------
	     
	     //jpldbkxfmx-----------------------------sart-------------------------------------------
	    JPanel jpldbkxfmx =new JPanel(null);
	    jtpzdbkxfmx.addTab("离店宾客消费明细",jpldbkxfmx);
	    
	    
	    JPanel jp0=new JPanel(null);
	    jp0.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,172,117)), "组合查询条件", TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.PLAIN, 12),Color.BLUE));
	    jp0.setBounds(2, 7, 415, 114);
	    jp0.setBackground(new Color(236,233,216));
	    jpldbkxfmx.add(jp0);
	    
	    
	    JPanel jpa=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	    jpa.setBounds(10, 25, 212, 20);
	    
	   
	  //*******************************************************
	  		JPanel jpText1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
	  		jpText1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
	  		jpText1.setPreferredSize(new Dimension(90, 20));
	  		jpText1.setBackground(Color.WHITE);
	  		
	  		JTextField jtfTimeQssj=new JTextField(6);
	  		jtfTimeQssj.setBorder(null);
	  		
	  		
	  		MyJButton mjbRlQssj=new MyJButton("image/rl.png", "image/rl1.png", "image/rl2.png");
	  		
	  		jpText1.add(jtfTimeQssj);
	  		jpText1.add(mjbRlQssj);
	  //*********************************************************
	   JTextField jtfQssjLdbkxf=new JTextField(); 
	   jtfQssjLdbkxf.setPreferredSize(new Dimension(55, 20)) ;
	    
	   jpa.add(new JLabel("起始时间："));
	   jpa.add(jpText1);
	   jpa.add(jtfQssjLdbkxf);
	    
	  //-------------------------------------------------------------
	   
	   JPanel jpb=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	    jpb.setBounds(10, 50, 212, 20);
	    
	   
	  //*******************************************************
	  		JPanel jpText2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
	  		jpText2.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
	  		jpText2.setPreferredSize(new Dimension(90, 20));
	  		jpText2.setBackground(Color.WHITE);
	  		
	  		JTextField jtfTimeZzsj=new JTextField(6);
	  		jtfTimeZzsj.setBorder(null);
	  		
	  		MyJButton mjbRlZzsj=new MyJButton("image/rl.png", "image/rl1.png", "image/rl2.png");
	  		
	  		jpText2.add(jtfTimeZzsj);
	  		jpText2.add(mjbRlZzsj);
	  //*********************************************************
	   JTextField jtfZzsjLdbkxf=new JTextField(); 
	   jtfZzsjLdbkxf.setPreferredSize(new Dimension(55, 20)) ;
	    
	   jpb.add(new JLabel("终止时间："));
	   jpb.add(jpText2);
	   jpb.add(jtfZzsjLdbkxf);
	    
	  //-------------------------------------------------------------
	   JPanel jpc=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	   jpc.setBounds(10, 75, 212, 20);
	    
	   JComboBox jcbJzzt=new JComboBox();
	   jcbJzzt.setBackground(Color.white);
	   jcbJzzt.setPreferredSize(new Dimension(144, 20));
	    
	   jpc.add(new JLabel("结账状态："));
	   jpc.add(jcbJzzt);
	  //--------------------------------------------------------------
	   JPanel jpd=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	   jpd.setBounds(228, 40, 170, 20);
	    
	   JComboBox jcbCxtj=new JComboBox();
	   jcbCxtj.setBackground(Color.white);
	   jcbCxtj.setPreferredSize(new Dimension(93, 20));
	    
	   jpd.add(new JLabel("    查询条件："));
	   jpd.add(jcbCxtj);
	  //--------------------------------------------------------------
	   JPanel jpe=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
	   jpe.setBounds(228, 70, 173, 20);
	    
	   JTextField jtfCxgjz=new JTextField();
	   jtfCxgjz.setPreferredSize(new Dimension(93, 20));
	    
	   jpe.add(new JLabel("查询关键字："));
	   jpe.add(jtfCxgjz);
	  //--------------------------------------------------------------
	   jpa.setBackground(new Color(236,233,216));
	   jpb.setBackground(new Color(236,233,216));
	   jpc.setBackground(new Color(236,233,216));
	   jpd.setBackground(new Color(236,233,216));
	   jpe.setBackground(new Color(236,233,216));
	   
	   
	   jp0.add(jpa);
	   jp0.add(jpb);
	   jp0.add(jpc);
	   jp0.add(jpd);
	   jp0.add(jpe);
	   
	  
	   
	  //------------------------------------------------------------- 
	    
	    JPanel jpanelld2=new JPanel(new FlowLayout(FlowLayout.LEFT,20,55));
	    jpanelld2.setBackground(new Color(236,233,216));
	    MyJButton jbldcx=new MyJButton("查询").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 21));
	    MyJButton jbldsx=new MyJButton("刷新").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 21));
	    MyJButton jblddc=new MyJButton("导出").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 21));
	    MyJButton jblddy=new MyJButton("打印").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(50, 21));
	    jpanelld2.add(jbldcx);
	    jpanelld2.add(jbldsx);
	    jpanelld2.add(jblddc);
	    jpanelld2.add(jblddy);
	   // jpanelld2.setBackground(Color.red);
	    jpanelld2.setBounds(405, 10, 312, 112);
	    jpldbkxfmx.add(jpanelld2);
	    jpldbkxfmx.setBackground(new Color(236,233,216));
	    
	    
	    JPanel jpanelld3=new JPanel(new FlowLayout(FlowLayout.CENTER,0,2));
	     JLabel jlldbkxfmx1=new JLabel("离店宾客消费明细");
	     jpanelld3.add(jlldbkxfmx1);
	     jpanelld3.setBackground(new Color(170,184,131));
	     jpanelld3.setBounds(3, 122, 708, 21);
	     jpldbkxfmx.add(jpanelld3);
	     
	     
	     
	     
	     JTable   jtbleld=new JTable(null,ColumnContent.arrayToVector(ColumnContent.LIDIANBINKEXIAOFEI_CLUMN_NAME));
	     jtbleld.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     JScrollPane  jscrollpane_ld=new JScrollPane(jtbleld,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    		 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    // jscrollpane_ld.setBackground(Color.black);
	     jscrollpane_ld.setBounds(3, 143, 710, 362);
	     jpldbkxfmx.add(jscrollpane_ld);
	     
	     /*
	     JPanel jpanelld3_2=new JPanel(new FlowLayout(FlowLayout.CENTER,5,2));
	     JTextField jtshul_ld=new JTextField(5);
	     JTextField jtyouh_ld=new JTextField(5);
	     JTextField jtyings_ld=new JTextField(5);
	     jpanelld3_2.add(jtshul_ld);
	     jpanelld3_2.add(jtyouh_ld);
	     jpanelld3_2.add(jtyings_ld);
	     jpanelld3_2.setBounds(0, 347, 800, 40);
	     jpanelld3.add(jpanelld3_2);
	     */
	    //jpldbkxfmx.setBackground(Color.red);
	    
	   
		/*jbzdbkxfmx.setMargin(new Insets(0, 0, 0, 0));
		jbldbkxfmx.setMargin(new Insets(0, 0, 0, 0));
		
		jbzdbkxfmx.setBackground(Color.white);
		jbldbkxfmx.setBackground(Color.white);
		//jpanel.setBackground(Color.WHITE);		
*/
		jpldbkxfmx.setBorder(BorderFactory.createLineBorder(new Color(170,184,131)));
		
		return jPanel0;
		
	}
	

	
	
	public static void main(String[]args){
		 
		
		new ZdLdbkxfmxDialog();
		
	}

	
	

	

}

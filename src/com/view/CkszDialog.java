package com.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.action.CkszAction;
import com.dao.StorehouseDao;
import com.util.ColumnContent;



public class CkszDialog extends JDialog{
	
	
	private static final long serialVersionUID = -2141977697363689805L;
	private JButton jbTjCk=new JButton("添加");
	private JButton jbXgCk=new JButton("修改");
	private JButton jbScCk=new JButton("删除");
	private JButton jbBjssckCk=new JButton("本机所属仓库");
	private JTable jtCk;
	
	
	public CkszDialog(SpglDialog owner,boolean model){
		
		super(owner,model);
		super.setSize(350,254);
		super.setLocationRelativeTo(null);
		super.setTitle("仓库设置");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		addlistener();
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	 public void addlistener(){
		 
		 CkszAction ckszAction=new  CkszAction(this);
		 jbTjCk.addActionListener(ckszAction);
		 jbXgCk.addActionListener(ckszAction);
		 jbScCk.addActionListener(ckszAction);
		 jbBjssckCk.addActionListener(ckszAction);
		 
	 } 
	
	
	
	public JPanel content(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//-------------------------------------------
		StorehouseDao shDao=new StorehouseDao();
		Vector<Vector> rowdatas=null;
		try {
			rowdatas=shDao.queryStoreData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		jtCk=new JTable(rowdatas, ColumnContent.arrayToVector(ColumnContent.CANGKU_CLUMN_NAME));
		jtCk.setAutoCreateRowSorter(true);
		jtCk.setFillsViewportHeight(true);
		//jtCk.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jtCk, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(6, 6, 237, 195);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(143,172,117),2));
		
		//--------------------------------------------
		
		JLabel jl=new JLabel("注：设置本机所属仓库后重新运行本软件此项功能才生效!");
		jl.setFont(new Font("宋体", Font.PLAIN, 12));
		jl.setForeground(Color.RED);
		jl.setBounds(6, 202, 354, 18);
		
		//------------------------------------------------
		
		GridLayout gl1=new GridLayout(4,1);
		gl1.setVgap(10);
		JPanel jp1=new JPanel(gl1);
		jp1.setBounds(249,67,79,120);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		
		//JButton jbTjCk=new JButton("添加");
		jbTjCk.setBackground(new Color(251,249,231));
		//JButton jbXgCk=new JButton("修改");
		jbXgCk.setBackground(new Color(251,249,231));
		//JButton jbScCk=new JButton("删除");
		jbScCk.setBackground(new Color(251,249,231));
		//JButton jbBjssckCk=new JButton("本机所属仓库");
		jbBjssckCk.setBackground(new Color(251,249,231));
		jbBjssckCk.setMargin(new Insets(0, 0, 0, 0));
		jbBjssckCk.setFont(new Font("宋体",Font.PLAIN,12));
		
		jp1.add(jbTjCk);
		jp1.add(jbXgCk);
		jp1.add(jbScCk);
		jp1.add(jbBjssckCk);
		
		//-------------------------------------------
		
		jPanel.add(jScrollPane);
		jPanel.add(jl);
		jPanel.add(jp1);
		
		return jPanel;
		
	}
	
	

	
	public JTable getJtCk() {
		return jtCk;
	}

	public JButton getJbTjCk() {
		return jbTjCk;
	}

	public JButton getJbXgCk() {
		return jbXgCk;
	}

	public JButton getJbScCk() {
		return jbScCk;
	}

	public JButton getJbBjssckCk() {
		return jbBjssckCk;
	}
	
	
}

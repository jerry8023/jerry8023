package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.action.TcszDialogAction;
import com.dao.GoodsDao;
import com.dao.GoodstypeDao;
import com.dao.SgradeDao;
import com.dao.TichengDao;
import com.util.ColumnContent;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.GoodsVo;
import com.vo.SgradeVo;
import com.vo.TichengVo;


public class TcszDialog extends JDialog{

	
	private static final long serialVersionUID = -1216560761682605227L;

	private MyJComBoBox  jcb_ticheng=new MyJComBoBox();
	private JLabel  jlbj=new JLabel();
	private JTextField  jtld_ticheng=new JTextField(8);
	private JTextField  jtdd_ticheng=new JTextField(8);
	public static MyJButton mjbTjTc;
	private MyJButton mjScTc=new MyJButton("image/xlsc0.png", "image/xlsc1.png", "image/xlsc2.png");
	private MyJButton jbsave_ticheng=new MyJButton("保存").set_Background(new Color(248,245,229)).set_FocusPainted(false);
	private MyJButton jbdelete_ticheng=new MyJButton("取消").set_Background(new Color(248,245,229)).set_FocusPainted(false);
	private JTable jtable_ticheng;
	public  XtszDialog frame;
	private JPanel jpanel3=new JPanel(null);
	public static Vector<Vector> rowdatas;

	
	public TcszDialog(XtszDialog owner,boolean model){
		super(owner,model);
		this.frame=owner;
		super.setTitle("提成设置");
		super.setSize(449,319);
		super.setLocationRelativeTo(null);
		Container container=super.getContentPane();
		JPanel jpanl=new JPanel();
		jpanl.setBackground(new Color(236,233,216));
		jpanl.setPreferredSize(new Dimension(449,15	));
		
		container.add(jpanl,BorderLayout.NORTH);
		container.add(Center(),BorderLayout.CENTER);
		container.add(South(),BorderLayout.SOUTH);
		
		addListener();
		
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setResizable(false);
		super.setVisible(true);
		
		
	}
	
	public void addListener(){
		TcszDialogAction action=new TcszDialogAction(this);
		jcb_ticheng.addActionListener(action);
		jbsave_ticheng.addActionListener(action);
		jbdelete_ticheng.addActionListener(action);
		mjbTjTc.addActionListener(action);
		mjScTc.addActionListener(action);
	}
	
	
	public JPanel Center(){
		
		JPanel jpanel=new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(170, 184, 131)),
				"服务提成设置",TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体", Font.BOLD, 12),Color.red));
		
		TichengDao tcDao1=new TichengDao();
		int gid1=Integer.parseInt(frame.getjTableSp().getValueAt(frame.getjTableSp().getSelectedRow(), 0).toString());
		try {
			rowdatas = tcDao1.queryDataByGid(gid1);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e1.printStackTrace();
		}
		
		 jtable_ticheng=new JTable(rowdatas,ColumnContent.arrayToVector(ColumnContent.TICHENG_CLUMN_NAME));
		 jtable_ticheng.setAutoCreateRowSorter(true);
		 jtable_ticheng.setFillsViewportHeight(true);
		 JScrollPane jscroll_ticheng=new JScrollPane(jtable_ticheng,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
		jscroll_ticheng.setBounds(212, 26, 221, 182);
		
		
		GridBagLayout gbl_ticheng=new GridBagLayout();
		JPanel jpanel2=new JPanel(gbl_ticheng);
		jpanel2.setBounds(15, 20, 191, 120);
		
		JLabel  jlxm=new JLabel(" 项目名称：");
		gbl_ticheng.setConstraints(jlxm, new GBC(0,0).setInSets(10, 0, 5, 0).setAnchor(GBC.EAST));
		jlbj.setText(frame.getjTableSp().getValueAt(frame.getjTableSp().getSelectedRow(), 1).toString());
		jlbj.setForeground(Color.blue);
		jlbj.setFont(new Font("宋体", Font.PLAIN, 14));
		gbl_ticheng.setConstraints(jlbj, new GBC(1,0).setInSets(10, 0, 5, 0).setAnchor(GBC.WEST));
		
		JLabel  jlfw=new JLabel("服务生等级：");
		gbl_ticheng.setConstraints(jlfw, new GBC(0,1).setInSets(0, 0, 5, 0).setAnchor(GBC.EAST));

		
		SgradeDao sgDao=new SgradeDao();
		try {
			ArrayList<SgradeVo> sgdatas=sgDao.getAllSgrade();
			for(SgradeVo vo:sgdatas){
				jcb_ticheng.addItem(vo.getSgname(), vo.getSgid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		jcb_ticheng.setPreferredSize(new Dimension(92, 22));
		jcb_ticheng.setBackground(Color.white);
		gbl_ticheng.setConstraints(jcb_ticheng, new GBC(1,1).setInSets(0, 0, 5, 0).setAnchor(GBC.EAST));
		
		
		
		JLabel  jlld=new JLabel(" 轮单提成：");
		gbl_ticheng.setConstraints(jlld, new GBC(0,2).setInSets(0, 0, 5, 0).setAnchor(GBC.EAST));
		gbl_ticheng.setConstraints(jtld_ticheng, new GBC(1,2).setInSets(0, 0, 5, 0).setAnchor(GBC.EAST));
		
		JLabel  jldd=new JLabel(" 点单提成：");
		gbl_ticheng.setConstraints(jldd, new GBC(0,3).setInSets(0, 0, 0, 0).setAnchor(GBC.EAST));
		gbl_ticheng.setConstraints(jtdd_ticheng, new GBC(1,3).setInSets(0, 0, 0, 0).setAnchor(GBC.EAST));
		
		jpanel2.setBackground(Color.pink);
		jpanel2.add(jlxm);
		jpanel2.add(jlbj);
		jpanel2.add(jlfw);
		jpanel2.add(jlld);
		jpanel2.add(jldd);
		jpanel2.add(jcb_ticheng);
		jpanel2.add(jtld_ticheng);
		jpanel2.add(jtdd_ticheng);
		
		
	   
	    
	    
	    TichengDao tcDao=new TichengDao();
	    int gid=Integer.parseInt(frame.getjTableSp().getValueAt(frame.getjTableSp().getSelectedRow(), 0).toString());
	    try {
			ArrayList<TichengVo> tcVo=tcDao.getVoByGidAndSgid(gid,jcb_ticheng.getValues().get(jcb_ticheng.getSelectedIndex()));
			if(tcVo.size()==0){
				mjbTjTc=new MyJButton("image/xrtj0.png", "image/xrtj1.png", "image/xrtj2.png");
			}else{
				mjbTjTc=new MyJButton("image/gx0.png", "image/gx1.png", "image/gx2.png");
			}
	    } catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
	    mjbTjTc.setBounds(87, 5, 51, 27);
	    mjScTc.setBounds(85, 35, 51, 27);
	    
	    jpanel3.add(mjbTjTc);
	    jpanel3.add(mjScTc);
	    
		jpanel2.setBackground(new Color(236,233,216));
		jpanel3.setBackground(new Color(236,233,216));
		jpanel3.setBounds(15, 140, 190, 60);
		
		jpanel.add(jscroll_ticheng);
		jpanel.add(jpanel2);
		jpanel.add(jpanel3);
		return jpanel;
	}

	public JPanel South(){
		JPanel jpanel =new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setPreferredSize(new Dimension(449,50));
		jbsave_ticheng.setBounds(40, 15, 65, 20);
		jbdelete_ticheng.setBounds(333, 15, 65, 20);
		jpanel.add(jbsave_ticheng);
		jpanel.add(jbdelete_ticheng);
		return jpanel;
	}


	public MyJComBoBox getJcb_ticheng() {
		return jcb_ticheng;
	}


	public JLabel getJlbj() {
		return jlbj;
	}


	public JTextField getJtld_ticheng() {
		return jtld_ticheng;
	}


	public JTextField getJtdd_ticheng() {
		return jtdd_ticheng;
	}


	public MyJButton getMjbTjTc() {
		return mjbTjTc;
	}


	public MyJButton getMjScTc() {
		return mjScTc;
	}


	public MyJButton getJbsave_ticheng() {
		return jbsave_ticheng;
	}


	public MyJButton getJbdelete_ticheng() {
		return jbdelete_ticheng;
	}


	public JTable getJtable_ticheng() {
		return jtable_ticheng;
	}


	public XtszDialog getFrame() {
		return frame;
	}

	public JPanel getJpanel3() {
		return jpanel3;
	}
	
	
	
	
}

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.XgbjlxDialogAction;
import com.dao.BaojiantypeDao;
import com.dao.JieriDao;
import com.dao.JifeiDao;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.BaojiantypeVo;
import com.vo.JieriVo;
import com.vo.JifeiVo;


public class XgbjlxDialog extends JDialog{

	private static final long serialVersionUID = 5843248858844414747L;
	
	
	public static final int TIANJIA=1;
	public static final int XIUGAI=2;
	public static int yongtu;
	private XtszDialog frame;
	
	private JTextField jtfnamebjlx = new JTextField(9);
	private JTextField jtfzdxfbjlx = new JTextField(9);
	private JTextField jtfrnrsbjlx = new JTextField(9);
	private JCheckBox  jcbzdbzjfbjlx = new JCheckBox("指定包间计费方式");
	private JCheckBox  jcbbtjr1bjlx = new JCheckBox("普通节日1计费方式");
	private JCheckBox  jcbbtjr2bjlx = new JCheckBox("普通节日2计费方式");
	private JCheckBox  jcbtsjrbjlx  = new JCheckBox("特殊节日计费方式");
	private MyJComBoBox jcmzdbzjfbjlx = new MyJComBoBox();
	private MyJComBoBox jcmbtjr1bjlx = new MyJComBoBox();
	private MyJComBoBox jcmbtjr2bjlx = new MyJComBoBox();
	private MyJComBoBox jcmtsjrbjlx = new MyJComBoBox();
	private MyJButton  mjbSavexgbjlx = new MyJButton("保存");
	private MyJButton  mjbBjfdzxgbjlx = new MyJButton("包间费打折");
	private MyJButton  mjbExitxgbjlx = new MyJButton("取消");
	
	
	public XgbjlxDialog(XtszDialog owner,boolean model,int yongtu){
		
		super(owner,model);
		this.frame=owner;
		this.yongtu=yongtu;
		super.setSize(349, 312);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		container.add(conNorth(),BorderLayout.SOUTH);
		
		if(this.yongtu==1){
			super.setTitle("增加包间信息");
		}else if(this.yongtu==2){
			super.setTitle("修改包间信息");
		}
		
		 addListener();
		
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	
	public void addListener(){
		
		XgbjlxDialogAction action=new XgbjlxDialogAction(this);
		
		jcbzdbzjfbjlx.addActionListener(action);
		jcbbtjr1bjlx.addActionListener(action);
		jcbbtjr2bjlx.addActionListener(action);
		jcbtsjrbjlx.addActionListener(action);
		mjbSavexgbjlx.addActionListener(action);
		mjbBjfdzxgbjlx.addActionListener(action);
		mjbExitxgbjlx.addActionListener(action);
		
	}
	
	
	
	
	
	public JPanel conNorth(){
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT,75,20));
		jpNorth.setBackground(new Color(236,233,216));
		mjbSavexgbjlx.set_PreferredSize(new Dimension(65,22)).set_FocusPainted(false).set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
		jpNorth.add(mjbSavexgbjlx);
		
		if(this.yongtu==2){
			mjbBjfdzxgbjlx.set_PreferredSize(new Dimension(65,22)).set_FocusPainted(false).set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
			mjbBjfdzxgbjlx.setFont(new Font("宋体", Font.PLAIN, 12));
			jpNorth.add(mjbBjfdzxgbjlx);
			jpNorth.setLayout(new FlowLayout(FlowLayout.LEFT,40,20));
		}
		
		mjbExitxgbjlx.set_PreferredSize(new Dimension(65,22)).set_FocusPainted(false).set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
		jpNorth.add(mjbExitxgbjlx);
		return jpNorth;
	}
	public JPanel content(){
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 10, 343, 268);
		GridBagLayout layout = new GridBagLayout();
		jpanel.setLayout(layout);
		jpanel.setBackground(new Color(236,233,216));
		
		JLabel jlbjlx = new JLabel("包间类型:");
		layout.setConstraints(jlbjlx, new GBC(0, 0).setInSets(10, 70, 5, 1));
		jpanel.add(jlbjlx);
		layout.setConstraints(jtfnamebjlx, new GBC(1, 0).setInSets(10, 0, 5, 0));
		jpanel.add(jtfnamebjlx);
		
		JLabel jlzdxf = new JLabel("最低消费:");
		layout.setConstraints(jlzdxf, new GBC(0, 1).setInSets(1, 70, 5, 1));
		jpanel.add(jlzdxf);
		jtfzdxfbjlx.setText("￥0.00");
		layout.setConstraints(jtfzdxfbjlx, new GBC(1, 1).setInSets(1, 0, 5, 0));
		jpanel.add(jtfzdxfbjlx);
		
		JLabel jlrnrs = new JLabel("容纳人数:");
		layout.setConstraints(jlrnrs, new GBC(0, 2).setInSets(1, 70, 5, 1));
		jpanel.add(jlrnrs);
		layout.setConstraints(jtfrnrsbjlx, new GBC(1, 2).setInSets(1, 0,1, 0));
		jpanel.add(jtfrnrsbjlx);
	
		jcmzdbzjfbjlx.setPreferredSize(new Dimension(103,22));
		jcmzdbzjfbjlx.setBackground(Color.WHITE);
		jcmzdbzjfbjlx.setEnabled(false);
		jcbzdbzjfbjlx.setBackground(null);
		jcbzdbzjfbjlx.setOpaque(false);
		layout.setConstraints(jcbzdbzjfbjlx, new GBC(0, 3).setInSets(5, 0, 5, 0).setAnchor(GBC.WEST));
		jpanel.add(jcbzdbzjfbjlx);
		layout.setConstraints(jcmzdbzjfbjlx, new GBC(1, 3).setInSets(5, 0, 5, 0).setAnchor(GBC.EAST));
		jpanel.add(jcmzdbzjfbjlx);
		
		
		jcmbtjr1bjlx.setPreferredSize(new Dimension(103,22));
		jcmbtjr1bjlx.setBackground(Color.WHITE);
		jcmbtjr1bjlx.setEnabled(false);
		jcbbtjr1bjlx.setBackground(null);
		jcbbtjr1bjlx.setOpaque(false);
		layout.setConstraints(jcbbtjr1bjlx, new GBC(0, 4).setInSets(1, 0, 1, 0).setAnchor(GBC.WEST));
		jpanel.add(jcbbtjr1bjlx);
		layout.setConstraints(jcmbtjr1bjlx, new GBC(1, 4).setInSets(1, 0, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jcmbtjr1bjlx);
		
		
		jcmbtjr2bjlx.setPreferredSize(new Dimension(103,22));
		jcmbtjr2bjlx.setBackground(Color.WHITE);
		jcmbtjr2bjlx.setEnabled(false);
		jcbbtjr2bjlx.setBackground(null);
		jcbbtjr2bjlx.setOpaque(false);
		layout.setConstraints(jcbbtjr2bjlx, new GBC(0, 5).setInSets(1, 0, 1, 0).setAnchor(GBC.WEST));
		jpanel.add(jcbbtjr2bjlx);
		layout.setConstraints(jcmbtjr2bjlx, new GBC(1, 5).setInSets(1, 0, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jcmbtjr2bjlx);
		
		
		jcmtsjrbjlx.setPreferredSize(new Dimension(103,22));
		jcmtsjrbjlx.setBackground(Color.WHITE);
		jcmtsjrbjlx.setEnabled(false);
		jcbtsjrbjlx.setBackground(null);
		jcbtsjrbjlx.setOpaque(false);
		layout.setConstraints(jcbtsjrbjlx, new GBC(0, 6).setInSets(1, 0, 1, 0).setAnchor(GBC.WEST));
		jpanel.add(jcbtsjrbjlx);
		layout.setConstraints(jcmtsjrbjlx, new GBC(1, 6).setInSets(1, 0, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jcmtsjrbjlx);
		
		
		//-------------------初始化数据-----------------------
		if(this.yongtu==2){

			int index=frame.getjTableBjlx().getSelectedRow();
			jtfnamebjlx.setText(frame.getjTableBjlx().getValueAt(index, 0).toString());
			jtfzdxfbjlx.setText("￥"+frame.getjTableBjlx().getValueAt(index, 1).toString());
			jtfrnrsbjlx.setText(frame.getjTableBjlx().getValueAt(index, 3).toString());
			
			String bjlx=frame.getjTableBjlx().getValueAt(index, 0).toString();
			BaojiantypeDao bjtDao=new BaojiantypeDao();
			try {
				BaojiantypeVo bjtVo=bjtDao.getVoByBjtname(bjlx);
				if(bjtVo.getJrid()!=null){
					JieriDao jrDao=new JieriDao();
					JieriVo jrVo=jrDao.getVoByJrid(bjtVo.getJrid());
					
					JifeiDao jfDao=new JifeiDao();
					try {
						ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
						for(JifeiVo vo:datas){
							jcmzdbzjfbjlx.addItem(vo.getJfname(), vo.getJfid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "數據庫異常");
						e1.printStackTrace();
					}
					jcmzdbzjfbjlx.setSelectedItem(jrVo.getJifei().getJfname());
					jcmzdbzjfbjlx.setEnabled(true);
				}
				
				
				
				if(bjtVo.getJrid1()!=null){
					JieriDao jrDao=new JieriDao();
					JieriVo jrVo1=jrDao.getVoByJrid(bjtVo.getJrid1());
					
					JifeiDao jfDao=new JifeiDao();
					try {
						ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
						for(JifeiVo vo:datas){
							jcmbtjr1bjlx.addItem(vo.getJfname(), vo.getJfid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "數據庫異常");
						e1.printStackTrace();
					}
					jcmbtjr1bjlx.setSelectedItem(jrVo1.getJifei().getJfname());
					jcmbtjr1bjlx.setEnabled(true);
				}
				
				
				
				if(bjtVo.getJrid2()!=null){
					JieriDao jrDao=new JieriDao();
					JieriVo jrVo2=jrDao.getVoByJrid(bjtVo.getJrid2());
					
					JifeiDao jfDao=new JifeiDao();
					try {
						ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
						for(JifeiVo vo:datas){
							jcmbtjr2bjlx.addItem(vo.getJfname(), vo.getJfid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "數據庫異常");
						e1.printStackTrace();
					}
					jcmbtjr2bjlx.setSelectedItem(jrVo2.getJifei().getJfname());
					jcmbtjr2bjlx.setEnabled(true);
				}
				
				if(bjtVo.getJridt()!=null){
					JieriDao jrDao=new JieriDao();
					JieriVo jrVot=jrDao.getVoByJrid(bjtVo.getJridt());
					
					JifeiDao jfDao=new JifeiDao();
					try {
						ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
						for(JifeiVo vo:datas){
							jcmtsjrbjlx.addItem(vo.getJfname(), vo.getJfid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "數據庫異常");
						e1.printStackTrace();
					}
					jcmtsjrbjlx.setSelectedItem(jrVot.getJifei().getJfname());
					jcmtsjrbjlx.setEnabled(true);
				}
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e.printStackTrace();
			}
			
			
		}
		
		return jpanel;
	}
	
	
	
	public JTextField getJtfnamebjlx() {
		return jtfnamebjlx;
	}
	public JTextField getJtfzdxfbjlx() {
		return jtfzdxfbjlx;
	}
	public JTextField getJtfrnrsbjlx() {
		return jtfrnrsbjlx;
	}
	public JCheckBox getJcbzdbzjfbjlx() {
		return jcbzdbzjfbjlx;
	}
	public JCheckBox getJcbbtjr1bjlx() {
		return jcbbtjr1bjlx;
	}
	public JCheckBox getJcbbtjr2bjlx() {
		return jcbbtjr2bjlx;
	}
	public JCheckBox getJcbtsjrbjlx() {
		return jcbtsjrbjlx;
	}
	public MyJComBoBox getJcmzdbzjfbjlx() {
		return jcmzdbzjfbjlx;
	}
	public MyJComBoBox getJcmbtjr1bjlx() {
		return jcmbtjr1bjlx;
	}
	public MyJComBoBox getJcmbtjr2bjlx() {
		return jcmbtjr2bjlx;
	}
	public MyJComBoBox getJcmtsjrbjlx() {
		return jcmtsjrbjlx;
	}
	public MyJButton getMjbSavexgbjlx() {
		return mjbSavexgbjlx;
	}
	public MyJButton getMjbBjfdzxgbjlx() {
		return mjbBjfdzxgbjlx;
	}
	public MyJButton getMjbExitxgbjlx() {
		return mjbExitxgbjlx;
	}
	
	
	
	
	
	
	/*public static void main(String[] args) {
		new XgbjlxDialog();
	}*/

}

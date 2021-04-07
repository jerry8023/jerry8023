package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.action.CgjhDialogAction;
import com.dao.OperatorDao;
import com.dao.StorehouseDao;
import com.sunking.swing.JDatePicker;
import com.util.ColumnContent;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.OperatorVo;
import com.vo.StorehouseVo;

/**
 * CgjhDialog.java :采购进货界面
 * @author TSS
 * @time 2013-7-12 下午9:43:27
 * 
 * */
public class CgjhDialog extends JDialog {
	
	private static final long serialVersionUID = -272608244060399215L;
	
	//定义选采购进货表则记为常量0
	public static final int CGJH = 0;
	
	//定义选采购退货表则记为常量1
	public static final int CGTH = 1;
	
	//定义选库存调拨表则记为常量1
	public static final int KCDB = 2;
	
	//定义选报损报溢表则记为常量1
	public static final int BSBY = 3;
	
	//得到所选的按钮
	private int CCKB;
	
	private JLabel jlcgjh = new JLabel("                       采购进货    ");
	private JTextField jtfhdbh = new JTextField(6);
	private JLabel     jlghdw = new JLabel(" 供货单位：");
	private JTextField jtfghdw = new JTextField(7);
	private MyJButton mjbghdw = new MyJButton("image//ghdw0.png", "image//ghdw1.png", "image//ghdw2.png");  
	private JLabel     jlxzck = new JLabel("   选择仓库：");
	private MyJComBoBox  jcmxzck = new MyJComBoBox();
	private JLabel     jltdrq = new JLabel("   填单日期：");
	private JDatePicker jdptdrq = new JDatePicker(JDatePicker.STYLE_CN_DATE1);
	private MyJButton  jbaddsp = new MyJButton("添加采购商品");
	private MyJButton  jbupdatesp = new MyJButton("修改采购商品");
	private MyJButton  jbdeletesp = new MyJButton("删除采购商品");
	private JLabel     jlyfzk = new JLabel("应付账款：");
	private JTextField jtfyfzk = new JTextField("0",5);
	private JLabel     jlsfzk  = new JLabel("实付账款：");
	private JTextField jtfsfzk = new JTextField("0",5);
	private JLabel     jljsyg  = new JLabel("经手员工：");
	private MyJComBoBox jcbjsyg  = new MyJComBoBox();
	private JLabel     jlhdbz  = new JLabel("货单备注：");
	private JTextField jtfhdbz = new JTextField(31);
	
	//商品调拨
	private MyJComBoBox mjbdrck = new MyJComBoBox();
	
	//商品报溢报损
	private MyJComBoBox mjbbsby = new MyJComBoBox();
	
	private MyJButton    jbsave  = new MyJButton("保存");
	private MyJButton    jbclose = new MyJButton("关闭");
	
	private JTable jTableCgjh= null;
	private Vector<Vector> vecZjsp = null;
	
	public CgjhDialog(SpglDialog frame,boolean model,int CCKB){
		super(frame,model);
		
		this.CCKB = CCKB;
		super.setSize(619,442);
		super.setLocationRelativeTo(null);
		super.setTitle("填写货单窗口");
		super.setResizable(false);
		
		Container container = super.getContentPane();
		container.add(conNorth(), BorderLayout.NORTH);
		container.add(conCenter(),BorderLayout.CENTER);
		
		
		JPanel jp=new JPanel();
		jp.setPreferredSize(new Dimension(621,13));
		jp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp.setBackground(new Color(236,233,216));
		container.add(jp,BorderLayout.SOUTH);
		
		addListener();
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	private void addListener(){
		
		
		CgjhDialogAction  action = new  CgjhDialogAction(this,CCKB);
		//为供货单位添加JWindow，为供货按钮注册监听器
		mjbghdw.addActionListener(action);
		this.addComponentListener(action); //窗体随CgjhDialog移动
		//为增、删、改注册监听器
		jbaddsp.addActionListener(action);
		jbupdatesp.addActionListener(action);
		jbdeletesp.addActionListener(action);
		//为修改关闭按钮注册监听器
		jbsave.addActionListener(action);
		jbclose.addActionListener(action);
	
	}
	
	//北部组件
	public JPanel conNorth(){
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT,0,8));
		jpNorth.setBackground(new Color(236,233,216));
		jpNorth.setPreferredSize(new Dimension(618,40));
		
		if(CCKB==CGTH){
			jlcgjh.setText("                       采购退货    ");
			jbaddsp.setText("添加退货商品");
			jbupdatesp.setText("修改退货商品");
			jbdeletesp.setText("删除采购商品");
		}else if(CCKB==KCDB){
			jlcgjh = new JLabel("                       库存调拨    ");
			jbaddsp.setText("添加调拨商品");
			jbupdatesp.setText("修改调拨商品");
			jbdeletesp.setText("删除调拨商品");
		}else if(CCKB==BSBY){
			jlcgjh = new JLabel("                       报损报溢    ");
			jbaddsp.setText("添加报损商品");
			jbupdatesp.setText("修改报损商品");
			jbdeletesp.setText("删除报损商品");
		}
		jlcgjh.setFont(new Font("宋体",Font.BOLD,22));
		
		JLabel jlhdbh = new JLabel("     货单编号:");
		jlhdbh.setFont(new Font("宋体",Font.PLAIN,12));
		jlhdbh.setForeground(Color.blue);
		
		jtfhdbh.setBorder(null);
		jtfhdbh.setColumns(10);
		jtfhdbh.setEditable(false);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		//System.out.println("货单编号："+sdf.format(date));
		if(CCKB==0){
			jtfhdbh.setText("JH"+sdf.format(date));
		}else if(CCKB==1){
			jtfhdbh.setText("TH"+sdf.format(date));
		}else if(CCKB==2){
			jtfhdbh.setText("DB"+sdf.format(date));
		}else if(CCKB==3){
			jtfhdbh.setText("SY"+sdf.format(date));
		}
		jtfhdbh.setBackground(new Color(236,233,216));
		
		//Map<Attribute,Object> map = new HashMap<Attribute,Object>();
		
	//	map.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
		//jtfhdbh.setFont(Font.getFont(map));
		
		jpNorth.add(jlcgjh);
		jpNorth.add(jlhdbh);
		jpNorth.add(jtfhdbh);
		return jpNorth;
	}
	
	
	//中间组件
	public JPanel conCenter(){
		JPanel jpCenter = new JPanel();
		jpCenter.setBackground(new Color(236,233,216));
		jpCenter.setPreferredSize(new Dimension(605,275));
		
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,3,20));
		jp1.setBackground(new Color(236,233,216));
		jp1.setPreferredSize(new Dimension(603,52));	
		jp1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//设置选择库存的大小
		StorehouseDao dao = new StorehouseDao();
		ArrayList<StorehouseVo> listData = null;
		try {
			listData = dao.queryData();
			for(StorehouseVo vo : listData){
				//System.out.println(vo.getShname()+"-"+vo.getShid());
				jcmxzck.addItem(vo.getShname(), vo.getShid());
				mjbdrck.addItem(vo.getShname(), vo.getShid());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		jcmxzck.setPreferredSize(new Dimension(100,23));
		jcmxzck.setBackground(Color.WHITE);
		mjbdrck.setPreferredSize(new Dimension(100,23));
		mjbdrck.setBackground(Color.WHITE);
	
		if(CCKB==0||CCKB==1){
			jp1.add(jlghdw);
			jtfghdw.setEditable(false);
			jtfghdw.setBackground(Color.white);
			jp1.add(jtfghdw);
			jp1.add(mjbghdw);
		}else if(CCKB==2){
			jp1.add(new JLabel("调入仓库："));
			jp1.add(mjbdrck);
			jlxzck.setText("调出仓库：");
		}else if(CCKB==3){
			mjbbsby.setPreferredSize(new Dimension(100,23));
			mjbbsby.addItem("报损", 0);
			mjbbsby.addItem("报溢",1);
			mjbbsby.setBackground(Color.WHITE);
			jp1.add(new JLabel("单据类型："));
			jp1.add(mjbbsby);
			
			//为下拉列表增加监听器
			mjbbsby.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int selected = mjbbsby.getSelectedIndex();
					HashMap<Integer, Integer> map = mjbbsby.getValues();
					int id = map.get(selected);
					if(id==0){
						
						jbaddsp.setText("添加报损商品");
						jbupdatesp.setText("修改报损商品");
						jbdeletesp.setText("删除报损商品");
						jlyfzk.setText("报损金额");
					}else if(id==1){
						jbaddsp.setText("添加报溢商品");
						jbupdatesp.setText("修改报溢商品");
						jbdeletesp.setText("删除报溢商品");
						jlyfzk.setText("报溢金额");
					}
					
				}
			});
			
		}
		
		jp1.add(jlxzck);
		jp1.add(jcmxzck);
		jp1.add(jltdrq);
		
		// 将和按钮添加到填单日期
		JPanel jprq = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,-2));
		jprq.setBackground(Color.WHITE);
		jprq.setPreferredSize(new Dimension(120,20));
		jprq.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jdptdrq.setBorder(null);
		jprq.add(jdptdrq);
		jp1.add(jprq);
		
		
		
		//增加增加、修改、删除按钮
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		jbaddsp.set_FocusPainted(false).set_PreferredSize(new Dimension(116,22)).set_Background(new Color(249,246,230));
		jbupdatesp.set_FocusPainted(false).set_PreferredSize(new Dimension(116,22)).set_Background(new Color(249,246,230));
		jbdeletesp.set_FocusPainted(false).set_PreferredSize(new Dimension(116,22)).set_Background(new Color(249,246,230));
		
		jbupdatesp.setEnabled(false);
		jbdeletesp.setEnabled(false);
		jp2.add(jbaddsp);
		jp2.add(jbupdatesp);
		jp2.add(jbdeletesp);
		jp2.setBounds(0,0,619,39);
		jp2.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp2.setBackground(new Color(236,233,216));
		jp2.setPreferredSize(new Dimension(618,40));		
		
		
		jTableCgjh=new JTable(null, ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
		jTableCgjh.setAutoCreateRowSorter(true);
		jTableCgjh.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableCgjh,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setPreferredSize(new Dimension(603,182));	
		
		jpCenter.add(jp1);
		jpCenter.add(jp2);
		jpCenter.add(jScrollPane); 
		jpCenter.add(centerSouth());
		return jpCenter;
	}
	
	
	
	
	//中间容器的南边组件
	public JPanel centerSouth(){
		JPanel jpSouth = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		jpSouth.setLayout(layout);
		if(CCKB==0||CCKB==1){
			if(CCKB==1){
				jlyfzk.setText("应收账款:");
				jlsfzk.setText("实收账款:");
			}
			layout.setConstraints(this.jlyfzk, new GBC(0, 0).setInSets(1, 0, 15, 1));
			jpSouth.add(this.jlyfzk);
			jtfyfzk.setEnabled(false);
			layout.setConstraints(this.jtfyfzk, new GBC(1,0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jtfyfzk);
			
			layout.setConstraints(this.jlsfzk, new GBC(2, 0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jlsfzk);
			layout.setConstraints(this.jtfsfzk, new GBC(3,0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jtfsfzk);
	
		
			layout.setConstraints(this.jljsyg, new GBC(4, 0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jljsyg);
		}	
		
		
	
		OperatorDao oDao = new OperatorDao();
		ArrayList<OperatorVo> opList = null;
		try {
				opList = oDao.queryOperatorData();
				for(OperatorVo vo:opList){
					jcbjsyg.addItem(vo.getOname(), vo.getOid());
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jcbjsyg.setPreferredSize(new Dimension(90,20));
		jcbjsyg.setBackground(Color.WHITE);
		if(CCKB==0||CCKB==1){
			layout.setConstraints(this.jcbjsyg, new GBC(5,0).setInSets(1, 1, 15, 0));
		}else if(CCKB==2){
			layout.setConstraints(this.jljsyg, new GBC(0, 0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jljsyg);
			layout.setConstraints(this.jcbjsyg, new GBC(1,0).setInSets(1, 1, 15, 0));
		}else if(CCKB==3){
			jlyfzk.setText("报损金额：");
			layout.setConstraints(this.jlyfzk, new GBC(0, 0).setInSets(1, 0, 15, 1));
			jpSouth.add(this.jlyfzk);
			jtfyfzk.setEnabled(false);
			layout.setConstraints(this.jtfyfzk, new GBC(1,0).setInSets(1, 1, 15, 6));
			jpSouth.add(this.jtfyfzk);
			layout.setConstraints(this.jljsyg, new GBC(2, 0).setInSets(1, 1, 15, 1));
			jpSouth.add(this.jljsyg);
			layout.setConstraints(this.jcbjsyg, new GBC(3,0).setInSets(1, 1, 15, 0));
		}
		jpSouth.add(this.jcbjsyg);
	
	
	
		layout.setConstraints(this.jlhdbz, new GBC(0, 1).setInSets(-10,0, 0, 1));
		jpSouth.add(this.jlhdbz);
		
		layout.setConstraints(this.jtfhdbz, new GBC(1,1,5,1).setInSets(-10, 1, 0, 1));
		jpSouth.add(this.jtfhdbz);
		
		jbsave.set_FocusPainted(false).set_Background(new Color(236,233,216)).set_PreferredSize(new Dimension(60,21));
		layout.setConstraints(this.jbsave, new GBC(6, 1).setInSets(-10, 5, 0, 1));
		jpSouth.add(jbsave);
		
		jbclose.set_FocusPainted(false).set_PreferredSize(new Dimension(60,21)).set_Background(new Color(236,233,216));
		layout.setConstraints(this.jbclose, new GBC(7, 1).setInSets(-10, 5, 0, 0));
		jpSouth.add(jbclose);
		
		jpSouth.setPreferredSize(new Dimension(601,73));
		jpSouth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpSouth.setBackground(new Color(236,233,216));
		return jpSouth;
	}

	public JLabel getJlyfzk() {
		return jlyfzk;
	}
	public JTextField getJtfhdbh() {
		return jtfhdbh;
	}

	public JTextField getJtfghdw() {
		return jtfghdw;
	}

	public MyJButton getMjbghdw() {
		return mjbghdw;
	}

	public MyJComBoBox getJcmxzck() {
		return jcmxzck;
	}

	
	public JDatePicker getJdptdrq() {
		return jdptdrq;
	}
	

	public MyJButton getJbaddsp() {
		return jbaddsp;
	}

	public MyJButton getJbupdatesp() {
		return jbupdatesp;
	}

	public MyJButton getJbdeletesp() {
		return jbdeletesp;
	}

	public JTextField getJtfyfzk() {
		return jtfyfzk;
	}

	public JTextField getJtfsfzk() {
		return jtfsfzk;
	}

	public MyJComBoBox getJcbjsyg() {
		return jcbjsyg;
	}

	public JTextField getJtfhdbz() {
		return jtfhdbz;
	}

	public MyJButton getJbsave() {
		return jbsave;
	}

	public MyJButton getJbclose() {
		return jbclose;
	}
	public JTable getjTableCgjh() {
		return jTableCgjh;
	}
	public Vector<Vector> getVecZjsp() {
		return vecZjsp;
	}
	public MyJComBoBox getMjbdrck() {
		return mjbdrck;
	}
	public MyJComBoBox getMjbbsby() {
		return mjbbsby;
	}
	
	
}

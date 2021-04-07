package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.action.XtszAction;
import com.dao.BaojianDao;
import com.dao.BaojiantypeDao;
import com.dao.FuwushengDao;
import com.dao.GoodsDao;
import com.dao.GoodstypeDao;
import com.dao.JifeiDao;
import com.dao.MgradeDao;
import com.dao.OperatorDao;
import com.dao.RoleDao;
import com.dao.SgradeDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.BaojiantypeVo;
import com.vo.GoodstypeVo;
import com.vo.SgradeVo;

/**
 *
 * XtszDialog.java:ϵͳ���ý���
 * @author czp
 * @time 2013-7-11 ����2:17:04
 * 
 */
public class XtszDialog extends JDialog{


	private static final long serialVersionUID = 6238503895295139466L;

	private JButton jbDgtjBj=new JButton("�������");
	private JButton jbPltjBj=new JButton("�������");
	private JButton jbXgBj=new JButton("�޸�");
	private JButton jbScbj=new JButton("ɾ��");
	private JTable jTableBj=null;
	private MyJComBoBox mjcbBjlx=new MyJComBoBox();
	
	private JButton jbTjSplx=new JButton("���");
	private	JButton jbXgSplx=new JButton("�޸�");
	private	JButton jbScSplx=new JButton("ɾ��");
	private	JButton jbTcszSp=new JButton("�������");
	private JTable jTableSplx;
	private JTable jTableSp;
	private	JButton jbTjHydj=new JButton("���");
	private	JButton jbXgHydj=new JButton("�޸�");
	private	JButton jbScHydj=new JButton("ɾ��");
	private	JButton jbGbHydj=new JButton("�ر�");
	private	JTable jTableHydj;
	private MyJComBoBox mjcbSplx=new MyJComBoBox();
	
	
	private JButton jbTjFwsdj=new JButton("���");
	private JButton jbXgFwsdj=new JButton("�޸�");
	private JButton jbScFwsdj=new JButton("ɾ��");
	private JButton jbTjFws=new JButton("���");
	private JButton jbXgFws=new JButton("�޸�");
	private JButton jbScFws=new JButton("ɾ��");
	private JTable jTableFwsdj;
	private JTable jTableFws;
	
	
	private JButton jbTjBjlx=new JButton("���");
	private JButton jbXgBjlx=new JButton("�޸�");
	private JButton jbScBjlx=new JButton("ɾ��");
	private JButton jbBjfdzBjlx=new JButton("����Ѵ���");
	private JTable jTableBjlx;
	
	private JButton jbDzszSp=new JButton("��������");
	
	private JButton jbTjSp=new JButton("���");
	private JButton jbXgSp=new JButton("�޸�");
	private JButton jbScSp=new JButton("ɾ��");
	
	public XtszDialog(AppMainFrame owner,boolean model){
		
		super(owner,model);
		super.setSize(621,484);
		super.setLocationRelativeTo(null);
		super.setTitle("ϵͳ����");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		JPanel jp=new JPanel();
		jp.setPreferredSize(new Dimension(621,13));
		jp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp.setBackground(new Color(236,233,216));
		
		
		container.add(jp, BorderLayout.NORTH);
		addListener();
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	
	}
	
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(new Color(236,233,216));
		
		JTabbedPane jTabbedPane=new JTabbedPane();
		jTabbedPane.setBackground(new Color(251,249,231));
		jTabbedPane.setFont(new Font("����",Font.PLAIN,12));
		jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(155,172,156)));
		
		jPanel.add(jTabbedPane, BorderLayout.CENTER);
		
		
		jTabbedPane.add("������Ŀ����",contentOfBjxmsz());
		jTabbedPane.add("��Ʒ��Ŀ����",contentOfSpxmsz());
		jTabbedPane.add("����������",contentOfFwssz());
		jTabbedPane.add("��Ա����",contentOfHysz());
		jTabbedPane.add("����Ա����",contentOfCzysz());
		jTabbedPane.add("�Ʒ�����",contentOfJfsz());
		
		
		return jPanel;
	}
	
	public void addListener(){
		
		XtszAction action = new XtszAction(this);
		jbDgtjBj.addActionListener(action);
		jbPltjBj.addActionListener(action);
		jbXgBj.addActionListener(action);
		jbScbj.addActionListener(action);
		mjcbBjlx.addActionListener(action);
		
		jbTjSplx.addActionListener(action);
		jbXgSplx.addActionListener(action);
		jbScSplx.addActionListener(action);
		jbTcszSp.addActionListener(action);
		mjcbSplx.addActionListener(action);
		
		jbTjHydj.addActionListener(action);
		jbXgHydj.addActionListener(action);
		jbScHydj.addActionListener(action);
		jbGbHydj.addActionListener(action);
		
		jbTjFwsdj.addActionListener(action);
		jbXgFwsdj.addActionListener(action);
		jbScFwsdj.addActionListener(action);
		jbTjFws.addActionListener(action);
		jbXgFws.addActionListener(action);
		jbScFws.addActionListener(action);
		
		
		jbTjBjlx.addActionListener(action);
		jbXgBjlx.addActionListener(action);
		jbScBjlx.addActionListener(action);
		jbBjfdzBjlx.addActionListener(action);
		
		jbDzszSp.addActionListener(action);
		
		jbTjSp.addActionListener(action);
		jbXgSp.addActionListener(action);
		jbScSp.addActionListener(action);
		
	}
	
	public JPanel contentOfBjxmsz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//-----------------------------------------------------
		Vector<Vector> rowdatesBjlx=null;
		BaojiantypeDao bjtDao=new BaojiantypeDao();
		try {
			rowdatesBjlx=bjtDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jTableBjlx=new JTable(rowdatesBjlx, ColumnContent.arrayToVector(ColumnContent.BAOJIANLEIXING_CLUMN_NAME));
		jTableBjlx.setAutoCreateRowSorter(true);
		jTableBjlx.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableBjlx,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(5,10,478,117);
		
		
		//-----------------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(new Color(236,233,216));
		jp1.add(new JLabel("  ���������͹���: "));
		
		
		mjcbBjlx.addItem("���а���", -2);
		
		try {
			ArrayList<BaojiantypeVo> dataList=bjtDao.getAllBaojiantype();
			for(BaojiantypeVo vo:dataList){
				mjcbBjlx.addItem(vo.getBjtname(),vo.getBjtid());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,"���ݲ���ʧ��");
			e1.printStackTrace();
		}
		
		//JComboBox jcbBjlx=new JComboBox();
		mjcbBjlx.setPreferredSize(new Dimension(123,22));
		mjcbBjlx.setBackground(Color.WHITE);
		jp1.add(mjcbBjlx);
		jp1.setBounds(5, 142,300,24);
		
		
		//------------------------------------------------------
		
		Vector<Vector> rowdatesBj=null;
		BaojianDao bjDao=new BaojianDao();
		try {
			rowdatesBj=bjDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		jTableBj=new JTable(rowdatesBj, ColumnContent.arrayToVector(ColumnContent.BAOJIAN_CLUMN_NAME));
		jTableBj.setAutoCreateRowSorter(true);
		jTableBj.setFillsViewportHeight(true);
		JScrollPane jScrollPane1=new JScrollPane(jTableBj,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBounds(5,172,478,224);
		
		
		//------------------------------------------------------
		GridLayout gl1=new GridLayout(4,1);
		gl1.setVgap(13);
		JPanel jp2=new JPanel(gl1);
		jp2.setBounds(503, 15, 68, 124);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		
		jbTjBjlx.setBackground(new Color(251,249,231));
		jbXgBjlx.setBackground(new Color(251,249,231));
		jbScBjlx.setBackground(new Color(251,249,231));
		jbBjfdzBjlx.setBackground(new Color(251,249,231));
		jbBjfdzBjlx.setFont(new Font("����", Font.PLAIN, 12));
		jbBjfdzBjlx.setMargin(new Insets(0,0,0,0));
		
		jp2.add(jbTjBjlx);
		jp2.add(jbXgBjlx);
		jp2.add(jbScBjlx);
		jp2.add(jbBjfdzBjlx);
		
		
		//--------------------------------------------------------
		GridLayout gl2=new GridLayout(4,1);
		gl2.setVgap(13);
		JPanel jp3=new JPanel(gl2);
		jp3.setBounds(503,272, 68, 124);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		
		jbDgtjBj.setBackground(new Color(251,249,231));
		jbDgtjBj.setFont(new Font("����", Font.BOLD, 12));
		jbDgtjBj.setMargin(new Insets(0,0,0,0));
		jbPltjBj.setBackground(new Color(251,249,231));
		jbPltjBj.setFont(new Font("����", Font.BOLD, 12));
		jbPltjBj.setMargin(new Insets(0,0,0,0));
		jbXgBj.setBackground(new Color(251,249,231));
		jbScbj.setBackground(new Color(251,249,231));
		
		
		jp3.add(jbDgtjBj);
		jp3.add(jbPltjBj);
		jp3.add(jbXgBj);
		jp3.add(jbScbj);
		
		
		
		
		jPanel.add(jScrollPane);
		jPanel.add(jp1);
		jPanel.add(jScrollPane1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		
		return jPanel;
	}
	
	
	
	
	public JPanel contentOfSpxmsz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//-----------------------------------------------------
		Vector<Vector> rowdatesSplb=null;
		GoodstypeDao gtDao=new GoodstypeDao();
		try {
			rowdatesSplb=gtDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		jTableSplx=new JTable(rowdatesSplb, ColumnContent.arrayToVector(ColumnContent.SHANGPINLEIBIE_CLUMN_NAME));
		jTableSplx.setAutoCreateRowSorter(true);
		jTableSplx.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableSplx,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(5,10,478,117);
		
		
		//-----------------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(new Color(236,233,216));
		jp1.setBounds(5, 142,400,24);
		
		jp1.add(new JLabel("  ����Ŀ������: "));
		

		
		mjcbSplx.addItem("������Ŀ", -2);
		
		try {
			ArrayList<GoodstypeVo> dataList=gtDao.getAllGoodstype();
			for(GoodstypeVo vo:dataList){
				mjcbSplx.addItem(vo.getGtname(),vo.getGtid());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,"���ݲ���ʧ��");
			e1.printStackTrace();
		}
		
		mjcbSplx.setPreferredSize(new Dimension(110,22));
		mjcbSplx.setBackground(Color.WHITE);
		jp1.add(mjcbSplx);
		
		jp1.add(new JLabel("  ���: "));
		
		final JTextField jtfSpjc=new JTextField(5);
		
		jtfSpjc.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if((e.getKeyCode()>=65 && e.getKeyCode()<=90) || (e.getKeyCode()>=97 && e.getKeyCode()<=122)|| (e.getKeyCode()>=48 && e.getKeyCode()<=57)){
					
					String str=jtfSpjc.getText()+e.getKeyChar();
					GoodsDao goodsDao=new GoodsDao();
					try {
						Vector<Vector> rowdatas=goodsDao.queryDateByJcOrBh1(str);
						DefaultTableModel dtm=new DefaultTableModel(rowdatas,ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
						jTableSp.setModel(dtm);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "���ݿ��쳣");
						e1.printStackTrace();
					}
					
				}else if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
					
					String str="";
					if(jtfSpjc.getText().length()<=1){
						str="";
					}else{
						str=jtfSpjc.getText().substring(0, jtfSpjc.getText().length()-1);
					}
					GoodsDao goodsDao=new GoodsDao();
					try {
						Vector<Vector> rowdatas=goodsDao.queryDateByJcOrBh1(str);
						DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
						jTableSp.setModel(dtm);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "���ݿ��쳣");
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		jp1.add(jtfSpjc);
		
		
		//------------------------------------------------------
		
		Vector<Vector> rowdatesSp=null;
		GoodsDao goodsDao=new GoodsDao();
		try {
			rowdatesSp=goodsDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		jTableSp=new JTable(rowdatesSp, ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
		jTableSp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableSp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableSp.setAutoCreateRowSorter(true);
		jTableSp.setFillsViewportHeight(true);
		JScrollPane jScrollPane1=new JScrollPane(jTableSp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBounds(5,172,478,224);
		
		
		//------------------------------------------------------
		GridLayout gl1=new GridLayout(3,1);
		gl1.setVgap(16);
		JPanel jp2=new JPanel(gl1);
		jp2.setBounds(503, 30, 66, 96);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		jbTjSplx.setBackground(new Color(251,249,231));
		jbXgSplx.setBackground(new Color(251,249,231));
		jbScSplx.setBackground(new Color(251,249,231));
		
		jp2.add(jbTjSplx);
		jp2.add(jbXgSplx);
		jp2.add(jbScSplx);
		
		
		//--------------------------------------------------------
		GridLayout gl2=new GridLayout(6,1);
		gl2.setVgap(16);
		JPanel jp3=new JPanel(gl2);
		jp3.setBounds(503,184, 66, 202);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		
		jbTjSp.setBackground(new Color(251,249,231));
		jbXgSp.setBackground(new Color(251,249,231));
		jbScSp.setBackground(new Color(251,249,231));
		JButton jb=new JButton("");
		jb.setBackground(new Color(236,233,216));
		jb.setBorderPainted(false);
		jbDzszSp.setBackground(new Color(251,249,231));
		jbDzszSp.setFont(new Font("����", Font.BOLD, 12));
		jbDzszSp.setMargin(new Insets(0,0,0,0));
		jbTcszSp=new JButton("�������");
		jbTcszSp.setBackground(new Color(251,249,231));
		jbTcszSp.setFont(new Font("����", Font.BOLD, 12));
		jbTcszSp.setMargin(new Insets(0,0,0,0));
		
		
		jp3.add(jbTjSp);
		jp3.add(jbXgSp);
		jp3.add(jbScSp);
		jp3.add(jb);
		jp3.add(jbDzszSp);
		jp3.add(jbTcszSp);
		
		
		
		
		
		jPanel.add(jScrollPane);
		jPanel.add(jp1);
		jPanel.add(jScrollPane1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		
		return jPanel;
	}
	
	
	
	public JPanel contentOfFwssz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//-----------------------------------------------------
		Vector<Vector> rowdatesFwsdj=null;
		SgradeDao sgDao=new SgradeDao();
		try {
			rowdatesFwsdj=sgDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jTableFwsdj=new JTable(rowdatesFwsdj, ColumnContent.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
		jTableFwsdj.setAutoCreateRowSorter(true);
		jTableFwsdj.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableFwsdj,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(5,10,478,117);
		
		
		//-----------------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(new Color(236,233,216));
		jp1.setBounds(5, 142,500,24);
		
		jp1.add(new JLabel("  ���������ȼ�����: "));
		
		final MyJComBoBox mjcbSgrade=new MyJComBoBox();
		mjcbSgrade.addItem("���з�����", -2);
		
		try {
			ArrayList<SgradeVo> dataList=sgDao.getAllSgrade();
			for(SgradeVo vo:dataList){
				mjcbSgrade.addItem(vo.getSgname(),vo.getSgid());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,"���ݲ���ʧ��");
			e1.printStackTrace();
		}
		
		mjcbSgrade.setPreferredSize(new Dimension(110,22));
		mjcbSgrade.setBackground(Color.WHITE);
		jp1.add(mjcbSgrade);
		
		
		mjcbSgrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuwushengDao fwsDao=new FuwushengDao();
				try {
					Vector<Vector> rowdatas=null;
					if(mjcbSgrade.getSelectedItem().toString().equals("���з�����")){
						rowdatas=fwsDao.queryDate();
					}else{
						rowdatas=fwsDao.queryDateBySgname(mjcbSgrade.getSelectedItem().toString());
					}
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.FUWUSHENG1_CLUMN_NAME));
					jTableFws.setModel(dtm);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getParent(), "�����쮐��", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JLabel jl=new JLabel("  ע:������Ʒ�������������÷������! ");
		jl.setForeground(Color.red);
		jp1.add(jl);
		
		
		//------------------------------------------------------
		Vector<Vector> rowdatesFwsd=null;
		FuwushengDao fwsDao=new FuwushengDao();
		try {
			rowdatesFwsd=fwsDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		jTableFws=new JTable(rowdatesFwsd, ColumnContent.arrayToVector(ColumnContent.FUWUSHENG1_CLUMN_NAME));
		jTableFws.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableFws.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableFws.setAutoCreateRowSorter(true);
		jTableFws.setFillsViewportHeight(true);
		JScrollPane jScrollPane1=new JScrollPane(jTableFws,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBounds(5,172,478,224);
		
		
		//------------------------------------------------------
		GridLayout gl1=new GridLayout(3,1);
		gl1.setVgap(16);
		JPanel jp2=new JPanel(gl1);
		jp2.setBounds(503, 30, 66, 96);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		jbTjFwsdj.setBackground(new Color(251,249,231));
		jbXgFwsdj.setBackground(new Color(251,249,231));
		jbScFwsdj.setBackground(new Color(251,249,231));
		
		jp2.add(jbTjFwsdj);
		jp2.add(jbXgFwsdj);
		jp2.add(jbScFwsdj);
		
		
		//--------------------------------------------------------
		GridLayout gl2=new GridLayout(3,1);
		gl2.setVgap(16);
		JPanel jp3=new JPanel(gl2);
		jp3.setBounds(503,295, 66, 96);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		jbTjFws.setBackground(new Color(251,249,231));
		jbXgFws.setBackground(new Color(251,249,231));
		jbScFws.setBackground(new Color(251,249,231));
		
		jp3.add(jbTjFws);
		jp3.add(jbXgFws);
		jp3.add(jbScFws);
		
		
		jPanel.add(jScrollPane);
		jPanel.add(jp1);
		jPanel.add(jScrollPane1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		
		return jPanel;
	}
	
	
	
	
	public JPanel contentOfHysz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117),2));
		
		
		//-----------------------------------------------------
		JPanel jpNorth=new JPanel(null);
		jpNorth.setBackground(new Color(236,233,216));
		jpNorth.setBounds(5,7,568,159);
		jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117),1));
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		jp1.setBounds(20, 10, 387, 22);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		JCheckBox jcbQyickgl=new JCheckBox("����IC������                     ");
		jcbQyickgl.setBackground(new Color(236,233,216));
		jcbQyickgl.setBorder(null);
		jp1.add(jcbQyickgl);
		jp1.add(new JLabel(" ע:  �谲װIC��������"));
		
		
		//----------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
		jp2.setBounds(20, 35, 387, 22);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		JCheckBox jcbQyhyjf=new JCheckBox("���û�Ա����                     ");
		jcbQyhyjf.setBackground(new Color(236,233,216));
		jcbQyhyjf.setBorder(null);
		jp2.add(jcbQyhyjf);
		jp2.add(new JLabel("         ÿ���� "));
		JTextField jtfJfhsbl=new JTextField("100",5) ;
		jtfJfhsbl.setPreferredSize(new Dimension(60, 20));
		jp2.add(jtfJfhsbl);
		jp2.add(new JLabel("   Ԫ��һ��"));
		
		
		//------------------------------------------------------------------
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp3.setBounds(20, 60, 297, 22);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		JCheckBox jcbQyczkzdbl=new JCheckBox("���ô�ֵ���۶Ա���        ");
		jcbQyczkzdbl.setBackground(new Color(236,233,216));
		jcbQyczkzdbl.setBorder(null);
		jp3.add(jcbQyczkzdbl);
		jp3.add(new JLabel("�۶Ա���Ϊ "));
		JTextField jtfCzkzdbl=new JTextField("1.2",5) ;
		jtfCzkzdbl.setPreferredSize(new Dimension(60, 20));
		jp3.add(jtfCzkzdbl);

		
		//----------------------------------------------------------------------------
		String str="<html>��: 1.2��100Ԫ�ֽ�<br>&nbsp &nbsp &nbsp &nbsp�۶�120Ԫ��ֵ��<html>";
		JLabel jl1=new JLabel(str);
		jl1.setForeground(Color.red);
		jl1.setBounds(324, 63, 127, 35);
		
		
		//--------------------------------------------------------------------------------
		JLabel jlSplit=new JLabel("-----------------------------------------------------------------------------------------------------------------------------");
		jlSplit.setForeground(new Color(143,172,117));
		jlSplit.setBounds(20,100,800,10);
		
		//---------------------------------------------------------------------------------
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp4.setBounds(20, 115, 497, 22);
		jp4.setBackground(null);
		jp4.setOpaque(false);
		JCheckBox jcbQysrtqtx=new JCheckBox("����������ǰ����        ");
		jcbQysrtqtx.setBackground(new Color(236,233,216));
		jcbQysrtqtx.setBorder(null);
		jp4.add(jcbQysrtqtx);
		jp4.add(new JLabel("     ������ǰ "));
		JTextField jtfSrtqts=new JTextField("0",5) ;
		jtfSrtqts.setPreferredSize(new Dimension(60, 20));
		jp4.add(jtfSrtqts);
		jp4.add(new JLabel("������"));
		
		
		//-----------------------------------------------------------------------------------
		JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp5.setBounds(20, 140, 497, 22);
		jp5.setBackground(null);
		jp5.setOpaque(false);
		JCheckBox jcbXstxck=new JCheckBox("ϵͳ����ʱ��ʾ�������Ѵ���");
		jcbXstxck.setBackground(new Color(236,233,216));
		jcbXstxck.setBorder(null);
		jcbXstxck.setEnabled(false);
		jp5.add(jcbXstxck);
		
		//------------------------------------------------------------------
		JButton jbBcBl=new JButton("����");
		jbBcBl.setMargin(new Insets(0, 0, 0, 0));
		jbBcBl.setBackground(new Color(248,245,229));
		//jbBcBl.setPreferredSize(new Dimension(62, 21));
		jbBcBl.setBounds(447, 45, 62, 21);
		
		JButton jbBcSrtx=new JButton("����");
		jbBcSrtx.setMargin(new Insets(0, 0, 0, 0));
		jbBcSrtx.setBackground(new Color(248,245,229));
		//jbBcBl.setPreferredSize(new Dimension(62, 21));
		jbBcSrtx.setBounds(447, 124, 62, 21);
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		jPanel.add(jl1);
		jPanel.add(jlSplit);
		jPanel.add(jp4);
		jPanel.add(jp5);
		jPanel.add(jbBcBl);
		jPanel.add(jbBcSrtx);
		
		//*********************************************************************************************
		Vector<Vector> rowdatesHydj=null;
		MgradeDao mgardeDao=new MgradeDao();
		try {
			rowdatesHydj=mgardeDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jTableHydj=new JTable(rowdatesHydj, ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
		jTableHydj.setAutoCreateRowSorter(true);
		jTableHydj.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableHydj, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(5,176,568,186);
		
		//-----------------------------------------------------------
		JPanel jpSouth=new JPanel(new FlowLayout(FlowLayout.CENTER,80, 5));
		jpSouth.setBackground(null);
		jpSouth.setOpaque(false);
		jpSouth.setBounds(5,364,583,31);
		
		
		jbTjHydj=new JButton("���");
		jbTjHydj.setPreferredSize(new Dimension(65, 21));
		jbTjHydj.setBackground(new Color(251,249,231));
		jbTjHydj.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		jbXgHydj=new JButton("�޸�");
		jbXgHydj.setPreferredSize(new Dimension(65, 21));
		jbXgHydj.setBackground(new Color(251,249,231));
		jbXgHydj.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		jbScHydj=new JButton("ɾ��");
		jbScHydj.setPreferredSize(new Dimension(65, 21));
		jbScHydj.setBackground(new Color(251,249,231));
		jbScHydj.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		jbGbHydj=new JButton("�ر�");
		jbGbHydj.setPreferredSize(new Dimension(65, 21));
		jbGbHydj.setBackground(new Color(251,249,231));
		jbGbHydj.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		jpSouth.add(jbTjHydj);
		jpSouth.add(jbXgHydj);
		jpSouth.add(jbScHydj);
		jpSouth.add(jbGbHydj);
		
		
		
		jPanel.add(jpNorth);
		jPanel.add(jScrollPane);
		jPanel.add(jpSouth);
		
		
		return jPanel;
	}
	
	
	
	public JPanel contentOfCzysz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//-----------------------------------------------------
		Vector<Vector> rowdatesRole=null;
		RoleDao roleDao=new RoleDao();
		try {
			rowdatesRole=roleDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JTable jTableQxz=new JTable(rowdatesRole, ColumnContent.arrayToVector(ColumnContent.QUANXIANZU_CLUMN_NAME));
		jTableQxz.setAutoCreateRowSorter(true);
		jTableQxz.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jTableQxz,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(5,10,478,157);
		
		
		
		//------------------------------------------------------
		OperatorDao operatorDao=new OperatorDao();
		Vector<Vector> rowdatas=null;
		try {
			rowdatas=operatorDao.queryOperator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JTable jTableCzy=new JTable(rowdatas, ColumnContent.arrayToVector(ColumnContent.CAOZUOYUAN_CLUMN_NAME));
		jTableCzy.setAutoCreateRowSorter(true);
		jTableCzy.setFillsViewportHeight(true);
		JScrollPane jScrollPane1=new JScrollPane(jTableCzy,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setBounds(5,182,478,218);
		
		
		//------------------------------------------------------
		GridLayout gl1=new GridLayout(4,1);
		gl1.setVgap(16);
		JPanel jp2=new JPanel(gl1);
		jp2.setBounds(503, 30, 66, 131);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JButton jbTjQxz=new JButton("���");
		jbTjQxz.setBackground(new Color(251,249,231));
		JButton jbXgQxz=new JButton("�޸�");
		jbXgQxz.setBackground(new Color(251,249,231));
		JButton jbScQxz=new JButton("ɾ��");
		jbScQxz.setBackground(new Color(251,249,231));
		JButton jbBjssQxz=new JButton("��������");
		jbBjssQxz.setBackground(new Color(251,249,231));
		jbBjssQxz.setFont(new Font("����", Font.BOLD, 12));
		jbBjssQxz.setMargin(new Insets(0,0,0,0));
		
		
		jp2.add(jbTjQxz);
		jp2.add(jbXgQxz);
		jp2.add(jbScQxz);
		jp2.add(jbBjssQxz);
		
		
		//--------------------------------------------------------
		GridLayout gl2=new GridLayout(3,1);
		gl2.setVgap(16);
		JPanel jp3=new JPanel(gl2);
		jp3.setBounds(503,295, 66, 96);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		JButton jbTjCzy=new JButton("���");
		jbTjCzy.setBackground(new Color(251,249,231));
		JButton jbXgCzy=new JButton("�޸�");
		jbXgCzy.setBackground(new Color(251,249,231));
		JButton jbScCzy=new JButton("ɾ��");
		jbScCzy.setBackground(new Color(251,249,231));
		
		jp3.add(jbTjCzy);
		jp3.add(jbXgCzy);
		jp3.add(jbScCzy);
		
		
		jPanel.add(jScrollPane);
		jPanel.add(jScrollPane1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		
		return jPanel;
	}
	
	
	
	public JPanel contentOfJfsz(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(new Color(236,233,216));
		
		
		JTabbedPane jTabbedPane=new JTabbedPane();
		jTabbedPane.setBackground(new Color(251,249,231));
		jTabbedPane.setFont(new Font("����",Font.PLAIN,12));
		jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(155,172,156)));
		
		jTabbedPane.add("�Ʒѷ�������",jfszOfFfsz());
		jTabbedPane.add("�ڼ�������",jfszOfJjrsz());
		
		jPanel.add(jTabbedPane,BorderLayout.CENTER);
		
		
		
		
		
		return jPanel;
	}
	
	
	
	
	public JPanel jfszOfFfsz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		//---------------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
		jp1.setBounds(7, 7, 583, 40);
		jp1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		
		JCheckBox jcbQcdz=new JCheckBox("����ȫ������");
		jcbQcdz.setBackground(null);
		jcbQcdz.setOpaque(false);
		JTextField jtfQcdzbl=new JTextField("0.9",5);
		JButton jbBcQcdz=new JButton("����");
		jbBcQcdz.setPreferredSize(new Dimension(65, 21));
		jbBcQcdz.setBackground(new Color(251,249,231));
		jbBcQcdz.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
	
		
		jp1.add(jcbQcdz);
		jp1.add(new JLabel("���۱���:  "));
		jp1.add(jtfQcdzbl);
		jp1.add(new JLabel("(0.8��Ϊ����)                                "));
		jp1.add(jbBcQcdz);
		
		
		//----------------------------------------------------------
		JifeiDao jfDao=new JifeiDao();
		Vector<Vector> rowdatasJf=null;
		try {
			rowdatasJf=jfDao.queryDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JTable jTableJfff=new JTable(rowdatasJf, ColumnContent.arrayToVector(ColumnContent.JIFEIFANGFA_CLUMN_NAME));
		jTableJfff.setAutoCreateRowSorter(true);
		jTableJfff.setFillsViewportHeight(true);
		
		jTableJfff.getColumnModel().getColumn(0).setPreferredWidth(70);
		jTableJfff.getColumnModel().getColumn(1).setPreferredWidth(92);
		jTableJfff.getColumnModel().getColumn(2).setPreferredWidth(107);
		jTableJfff.getColumnModel().getColumn(3).setPreferredWidth(154);
		jTableJfff.getColumnModel().getColumn(4).setPreferredWidth(380);
		jTableJfff.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jTableJfff, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(7,54,584,276);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),2));
		
		
		//------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.CENTER,80, 5));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		jp2.setBounds(7,338,583,31);
		
		
		JButton jbTjJfff=new JButton("���");
		jbTjJfff.setPreferredSize(new Dimension(65, 21));
		jbTjJfff.setBackground(new Color(251,249,231));
		jbTjJfff.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		JButton jbXgJfff=new JButton("�޸�");
		jbXgJfff.setPreferredSize(new Dimension(65, 21));
		jbXgJfff.setBackground(new Color(251,249,231));
		jbXgJfff.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		JButton jbScJfff=new JButton("ɾ��");
		jbScJfff.setPreferredSize(new Dimension(65, 21));
		jbScJfff.setBackground(new Color(251,249,231));
		jbScJfff.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		JButton jbGbJfff=new JButton("�ر�");
		jbGbJfff.setPreferredSize(new Dimension(65, 21));
		jbGbJfff.setBackground(new Color(251,249,231));
		jbGbJfff.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		jp2.add(jbTjJfff);
		jp2.add(jbXgJfff);
		jp2.add(jbScJfff);
		jp2.add(jbGbJfff);
		
		
		
		jPanel.add(jp1);
		jPanel.add(jScrollPane);
		jPanel.add(jp2);
		
		
		return jPanel;
	}
	
	
	
	public JPanel jfszOfJjrsz(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//--------------------------------------------------------
		JPanel jp1=new JPanel(new GridLayout(2, 8));
		jp1.setBounds(10,18,545,56);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setBackground(new Color(236,233,216));
		
		JLabel jl1=new JLabel("1.��ͨ����1:");
		jl1.setFont(new Font("����", Font.BOLD, 10));
		
		JCheckBox jcbPtjr17=new JCheckBox("������");
		jcbPtjr17.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr11=new JCheckBox("����һ");
		jcbPtjr11.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr12=new JCheckBox("���ڶ�");
		jcbPtjr12.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr13=new JCheckBox("������");
		jcbPtjr13.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr14=new JCheckBox("������");
		jcbPtjr14.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr15=new JCheckBox("������");
		jcbPtjr15.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr16=new JCheckBox("������");
		jcbPtjr16.setBackground(new Color(236,233,216));
		
		JLabel jl2=new JLabel("2.��ͨ����2:");
		jl2.setFont(new Font("����", Font.BOLD, 10));
		
		JCheckBox jcbPtjr27=new JCheckBox("������");
		jcbPtjr27.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr21=new JCheckBox("����һ");
		jcbPtjr21.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr22=new JCheckBox("���ڶ�");
		jcbPtjr22.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr23=new JCheckBox("������");
		jcbPtjr23.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr24=new JCheckBox("������");
		jcbPtjr24.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr25=new JCheckBox("������");
		jcbPtjr25.setBackground(new Color(236,233,216));
		JCheckBox jcbPtjr26=new JCheckBox("������");
		jcbPtjr26.setBackground(new Color(236,233,216));
		
		jp1.add(jl1);
		jp1.add(jcbPtjr17);
		jp1.add(jcbPtjr11);
		jp1.add(jcbPtjr12);
		jp1.add(jcbPtjr13);
		jp1.add(jcbPtjr14);
		jp1.add(jcbPtjr15);
		jp1.add(jcbPtjr16);
		jp1.add(jl2);
		jp1.add(jcbPtjr27);
		jp1.add(jcbPtjr21);
		jp1.add(jcbPtjr22);
		jp1.add(jcbPtjr23);
		jp1.add(jcbPtjr24);
		jp1.add(jcbPtjr25);
		jp1.add(jcbPtjr26);
		
		
		//----------------------------------------------------------
		GridLayout gl=new GridLayout(2,2);
		gl.setVgap(14);
		
		JPanel jp2=new JPanel(gl);
		jp2.setBounds(10,100,180,58);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JLabel jl3=new JLabel("3.�������:");
		jl3.setFont(new Font("����", Font.BOLD, 10));
		
		JLabel jl4=new JLabel("  ��������:");
		jl4.setFont(new Font("����", Font.BOLD, 10));
		
		
		//*******************************************************
		JPanel jpText=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jpText.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText.setPreferredSize(new Dimension(100, 22));
		jpText.setBackground(Color.WHITE);
		
		JTextField jtfTime=new JTextField(6);
		jtfTime.setText(DateUtil.getStrDate(new Date(),DateUtil.DATE));
		jtfTime.setBorder(null);
		
		JButton jbRl=new JButton(new ImageIcon("image/rl.png"));
		jbRl.setContentAreaFilled(false);
		jbRl.setMargin(new Insets(0, 0, 0, 0));
		jbRl.setBorderPainted(false);
		
		jpText.add(jtfTime);
		jpText.add(jbRl);
		//*********************************************************
		
		JTextField jtfJrmc=new JTextField(10);
		jtfJrmc.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		jp2.add(jl3);
		jp2.add(jpText);
		jp2.add(jl4);
		jp2.add(jtfJrmc);
		//---------------------------------------------------------------------
		GridLayout g2=new GridLayout(2,1);
		g2.setVgap(14);
		
		JPanel jp3=new JPanel(g2);
		jp3.setBounds(200,100,30,56);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		MyJButton mjbJrxr=new MyJButton("image/xr0.png", "image/xr1.png","image/xr2.png");
		MyJButton mjbJrxl=new MyJButton("image/xl0.png","image/xl1.png","image/xl2.png");
		
		jp3.add(mjbJrxr);
		jp3.add(mjbJrxl);
		
		//----------------------------------------------------------
		JTable jTableTsjr=new JTable(null, ColumnContent.arrayToVector(ColumnContent.TESHUJIERI_CLUMN_NAME));
		JScrollPane jScrollPane=new JScrollPane(jTableTsjr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(237, 89, 330, 86);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(55,98,6),1));
		
		//--------------------------------------------------------------
		String str="<html>��ʾ:  �ڴ����õĽڼ�����Ϊ����Ʒ�ʱ׼���������Ӱ�������ʱΪ����ָ����Ӧ�ļƷѷ�ʽ��,<br>&nbsp&nbsp&nbspϵͳ����ݵ���������Զ�ѡ����Ӧ�ļƷѷ�ʽ�԰�����мƷ�!</html>";
		JLabel jlText=new JLabel(str);
		jlText.setBounds(10,173,640,50);
		jlText.setForeground(Color.red);
		jlText.setFont(new Font("����", Font.PLAIN, 12));
		
		//-----------------------------------------------------------------
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,45,0));
		jp4.setBounds(332,251, 280, 24);
		jp4.setBackground(null);
		jp4.setOpaque(false);
		
		JButton jbBcJjrsz=new JButton("����");
		jbBcJjrsz.setMargin(new Insets(0, 0, 0, 0));
		jbBcJjrsz.setPreferredSize(new Dimension(65,21));
		jbBcJjrsz.setBackground(new Color(248,245,229));
		jbBcJjrsz.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		JButton jbGbJjrsz=new JButton("�ر�");
		jbGbJjrsz.setMargin(new Insets(0, 0, 0, 0));
		jbGbJjrsz.setPreferredSize(new Dimension(65,21));
		jbGbJjrsz.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		jbGbJjrsz.setBackground(new Color(248,245,229));
		
		
		jp4.add(jbBcJjrsz);
		jp4.add(jbGbJjrsz);
		
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		jPanel.add(jScrollPane);
		jPanel.add(jlText);
		jPanel.add(jp4);
		
		
		
		return jPanel;
	}
	
	
	
	
	public JButton getJbDgtjBj() {
		return jbDgtjBj;
	}



	public JButton getJbPltjBj() {
		return jbPltjBj;
	}



	public JButton getJbXgBj() {
		return jbXgBj;
	}



	public JButton getJbScbj() {
		return jbScbj;
	}



	public JTable getjTableBj() {
		return jTableBj;
	}

	

	public MyJComBoBox getMjcbBjlx() {
		return mjcbBjlx;
	}



	public JButton getJbTjSplx() {
		return jbTjSplx;
	}



	public JButton getJbXgSplx() {
		return jbXgSplx;
	}



	public JButton getJbScSplx() {
		return jbScSplx;
	}



	public JButton getJbTcszSp() {
		return jbTcszSp;
	}



	public JTable getjTableSplx() {
		return jTableSplx;
	}



	public JTable getjTableSp() {
		return jTableSp;
	}



	public JButton getJbTjHydj() {
		return jbTjHydj;
	}



	public JButton getJbXgHydj() {
		return jbXgHydj;
	}



	public JButton getJbScHydj() {
		return jbScHydj;
	}



	public JButton getJbGbHydj() {
		return jbGbHydj;
	}



	public JTable getjTableHydj() {
		return jTableHydj;
	}



	public JButton getJbTjFwsdj() {
		return jbTjFwsdj;
	}



	public JButton getJbXgFwsdj() {
		return jbXgFwsdj;
	}



	public JButton getJbScFwsdj() {
		return jbScFwsdj;
	}



	public JButton getJbTjFws() {
		return jbTjFws;
	}



	public JButton getJbXgFws() {
		return jbXgFws;
	}



	public JButton getJbScFws() {
		return jbScFws;
	}



	public JTable getjTableFwsdj() {
		return jTableFwsdj;
	}



	public JTable getjTableFws() {
		return jTableFws;
	}



	public JButton getJbTjBjlx() {
		return jbTjBjlx;
	}



	public JButton getJbXgBjlx() {
		return jbXgBjlx;
	}



	public JButton getJbScBjlx() {
		return jbScBjlx;
	}



	public JButton getJbBjfdzBjlx() {
		return jbBjfdzBjlx;
	}



	public JTable getjTableBjlx() {
		return jTableBjlx;
	}



	public MyJComBoBox getMjcbSplx() {
		return mjcbSplx;
	}



	public JButton getJbDzszSp() {
		return jbDzszSp;
	}



	public JButton getJbTjSp() {
		return jbTjSp;
	}


	public JButton getJbXgSp() {
		return jbXgSp;
	}


	public JButton getJbScSp() {
		return jbScSp;
	}

	

	/*public static void main(String[] args) {
		new XtszDialog();
	}*/

}

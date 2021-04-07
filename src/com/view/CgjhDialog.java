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
 * CgjhDialog.java :�ɹ���������
 * @author TSS
 * @time 2013-7-12 ����9:43:27
 * 
 * */
public class CgjhDialog extends JDialog {
	
	private static final long serialVersionUID = -272608244060399215L;
	
	//����ѡ�ɹ����������Ϊ����0
	public static final int CGJH = 0;
	
	//����ѡ�ɹ��˻������Ϊ����1
	public static final int CGTH = 1;
	
	//����ѡ�����������Ϊ����1
	public static final int KCDB = 2;
	
	//����ѡ����������Ϊ����1
	public static final int BSBY = 3;
	
	//�õ���ѡ�İ�ť
	private int CCKB;
	
	private JLabel jlcgjh = new JLabel("                       �ɹ�����    ");
	private JTextField jtfhdbh = new JTextField(6);
	private JLabel     jlghdw = new JLabel(" ������λ��");
	private JTextField jtfghdw = new JTextField(7);
	private MyJButton mjbghdw = new MyJButton("image//ghdw0.png", "image//ghdw1.png", "image//ghdw2.png");  
	private JLabel     jlxzck = new JLabel("   ѡ��ֿ⣺");
	private MyJComBoBox  jcmxzck = new MyJComBoBox();
	private JLabel     jltdrq = new JLabel("   ����ڣ�");
	private JDatePicker jdptdrq = new JDatePicker(JDatePicker.STYLE_CN_DATE1);
	private MyJButton  jbaddsp = new MyJButton("��Ӳɹ���Ʒ");
	private MyJButton  jbupdatesp = new MyJButton("�޸Ĳɹ���Ʒ");
	private MyJButton  jbdeletesp = new MyJButton("ɾ���ɹ���Ʒ");
	private JLabel     jlyfzk = new JLabel("Ӧ���˿");
	private JTextField jtfyfzk = new JTextField("0",5);
	private JLabel     jlsfzk  = new JLabel("ʵ���˿");
	private JTextField jtfsfzk = new JTextField("0",5);
	private JLabel     jljsyg  = new JLabel("����Ա����");
	private MyJComBoBox jcbjsyg  = new MyJComBoBox();
	private JLabel     jlhdbz  = new JLabel("������ע��");
	private JTextField jtfhdbz = new JTextField(31);
	
	//��Ʒ����
	private MyJComBoBox mjbdrck = new MyJComBoBox();
	
	//��Ʒ���籨��
	private MyJComBoBox mjbbsby = new MyJComBoBox();
	
	private MyJButton    jbsave  = new MyJButton("����");
	private MyJButton    jbclose = new MyJButton("�ر�");
	
	private JTable jTableCgjh= null;
	private Vector<Vector> vecZjsp = null;
	
	public CgjhDialog(SpglDialog frame,boolean model,int CCKB){
		super(frame,model);
		
		this.CCKB = CCKB;
		super.setSize(619,442);
		super.setLocationRelativeTo(null);
		super.setTitle("��д��������");
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
		//Ϊ������λ���JWindow��Ϊ������ťע�������
		mjbghdw.addActionListener(action);
		this.addComponentListener(action); //������CgjhDialog�ƶ�
		//Ϊ����ɾ����ע�������
		jbaddsp.addActionListener(action);
		jbupdatesp.addActionListener(action);
		jbdeletesp.addActionListener(action);
		//Ϊ�޸Ĺرհ�ťע�������
		jbsave.addActionListener(action);
		jbclose.addActionListener(action);
	
	}
	
	//�������
	public JPanel conNorth(){
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT,0,8));
		jpNorth.setBackground(new Color(236,233,216));
		jpNorth.setPreferredSize(new Dimension(618,40));
		
		if(CCKB==CGTH){
			jlcgjh.setText("                       �ɹ��˻�    ");
			jbaddsp.setText("����˻���Ʒ");
			jbupdatesp.setText("�޸��˻���Ʒ");
			jbdeletesp.setText("ɾ���ɹ���Ʒ");
		}else if(CCKB==KCDB){
			jlcgjh = new JLabel("                       ������    ");
			jbaddsp.setText("��ӵ�����Ʒ");
			jbupdatesp.setText("�޸ĵ�����Ʒ");
			jbdeletesp.setText("ɾ��������Ʒ");
		}else if(CCKB==BSBY){
			jlcgjh = new JLabel("                       ������    ");
			jbaddsp.setText("��ӱ�����Ʒ");
			jbupdatesp.setText("�޸ı�����Ʒ");
			jbdeletesp.setText("ɾ��������Ʒ");
		}
		jlcgjh.setFont(new Font("����",Font.BOLD,22));
		
		JLabel jlhdbh = new JLabel("     �������:");
		jlhdbh.setFont(new Font("����",Font.PLAIN,12));
		jlhdbh.setForeground(Color.blue);
		
		jtfhdbh.setBorder(null);
		jtfhdbh.setColumns(10);
		jtfhdbh.setEditable(false);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		//System.out.println("������ţ�"+sdf.format(date));
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
	
	
	//�м����
	public JPanel conCenter(){
		JPanel jpCenter = new JPanel();
		jpCenter.setBackground(new Color(236,233,216));
		jpCenter.setPreferredSize(new Dimension(605,275));
		
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,3,20));
		jp1.setBackground(new Color(236,233,216));
		jp1.setPreferredSize(new Dimension(603,52));	
		jp1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//����ѡ����Ĵ�С
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
			jp1.add(new JLabel("����ֿ⣺"));
			jp1.add(mjbdrck);
			jlxzck.setText("�����ֿ⣺");
		}else if(CCKB==3){
			mjbbsby.setPreferredSize(new Dimension(100,23));
			mjbbsby.addItem("����", 0);
			mjbbsby.addItem("����",1);
			mjbbsby.setBackground(Color.WHITE);
			jp1.add(new JLabel("�������ͣ�"));
			jp1.add(mjbbsby);
			
			//Ϊ�����б����Ӽ�����
			mjbbsby.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int selected = mjbbsby.getSelectedIndex();
					HashMap<Integer, Integer> map = mjbbsby.getValues();
					int id = map.get(selected);
					if(id==0){
						
						jbaddsp.setText("��ӱ�����Ʒ");
						jbupdatesp.setText("�޸ı�����Ʒ");
						jbdeletesp.setText("ɾ��������Ʒ");
						jlyfzk.setText("������");
					}else if(id==1){
						jbaddsp.setText("��ӱ�����Ʒ");
						jbupdatesp.setText("�޸ı�����Ʒ");
						jbdeletesp.setText("ɾ��������Ʒ");
						jlyfzk.setText("������");
					}
					
				}
			});
			
		}
		
		jp1.add(jlxzck);
		jp1.add(jcmxzck);
		jp1.add(jltdrq);
		
		// ���Ͱ�ť��ӵ������
		JPanel jprq = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,-2));
		jprq.setBackground(Color.WHITE);
		jprq.setPreferredSize(new Dimension(120,20));
		jprq.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jdptdrq.setBorder(null);
		jprq.add(jdptdrq);
		jp1.add(jprq);
		
		
		
		//�������ӡ��޸ġ�ɾ����ť
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
	
	
	
	
	//�м��������ϱ����
	public JPanel centerSouth(){
		JPanel jpSouth = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		jpSouth.setLayout(layout);
		if(CCKB==0||CCKB==1){
			if(CCKB==1){
				jlyfzk.setText("Ӧ���˿�:");
				jlsfzk.setText("ʵ���˿�:");
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
			jlyfzk.setText("�����");
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

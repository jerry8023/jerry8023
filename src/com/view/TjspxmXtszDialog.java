package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.action.TjspxmXtszDialogAction;
import com.dao.GoodsDao;
import com.dao.GoodstypeDao;
import com.dao.JifeiDao;
import com.util.ColumnContent;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.GoodsVo;
import com.vo.GoodstypeVo;
import com.vo.JifeiVo;

public class TjspxmXtszDialog extends JDialog{

	private JTextField jtfxmbmTjsp = new JTextField(8);
	private JTextField jtfysdjTjsp = new JTextField("0.00",8);
	private JTextField jtfdwcbTjsp = new JTextField("0.00",8);
	private JTextField jtfxmmcTjsp = new JTextField(8);
	private JTextField jtfxmjpTjsp = new JTextField(8);
	private JTextField jtfjjdwTjsp = new JTextField(8);
	private JTextField jtfbjkcTjsp = new JTextField(8);
	private JTextField jtfdhjfTjsp = new JTextField("0",8);
	
	
	
	private MyJComBoBox mjbxmlbTjsp = new MyJComBoBox();
	private MyJComBoBox mjbjffsTjsp = new MyJComBoBox();
	
	private JCheckBox jcbzdxfTjsp = new JCheckBox("����Ʒ���������������");
	private JCheckBox jcbzdskcTjsp = new JCheckBox("�����Զ�������");
	private JCheckBox jcbthspTjsp = new JCheckBox("�����Ա���ֶһ�����Ʒ             �һ�����:");
	private JCheckBox jcbtjzhxmTjsp = new JCheckBox("Ϊ���ײͲμ���Ŀ���");
	
	private MyJButton mjbSaveTjsp = new MyJButton("����");
	private MyJButton mjbCancelTjsp = new MyJButton("ȡ��");
	private MyJButton mjbtjxmTjsp = new MyJButton("�����Ŀ��");
	
	private JTable jttjspxmTjsp;

	public final static int ADD = 1;
	public final static int UPDATE = 2;
	public static int yongtu;
	private XtszDialog frame;

	public TjspxmXtszDialog(XtszDialog owner,boolean model,int yongtu){
		super(owner,model);
		this.frame=owner;
		this.yongtu=yongtu;
		super.setSize(442,443);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setTitle("�����Ʒ��Ŀ");
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		addListener();
		
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	
	
	public void addListener(){
		TjspxmXtszDialogAction action=new TjspxmXtszDialogAction(this);
		mjbSaveTjsp.addActionListener(action);
		mjbCancelTjsp.addActionListener(action);
		mjbtjxmTjsp.addActionListener(action);
	}
	
	
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawLine(22, 250, 420, 250);
	}
	
	
	public JPanel content(){
		JPanel jpanel = new JPanel(null);
		JPanel jpp2 = new JPanel();
		jpp2.setBounds(0, 10, 434, 190);
		//jpp2.setBackground(Color.green);
		jpp2.setBackground(null);
		jpp2.setOpaque(false);
		jpanel.setBackground(new Color(236,233,216));
		GridBagLayout gbl = new GridBagLayout();
		jpp2.setLayout(gbl);
		
		
		//��һ��
		GridBagConstraints gbc1=new GBC(0, 0).setAnchor(GBC.EAST).setInSets(-5,10, 5, 5);
		JLabel jl= new JLabel("��Ŀ���:");
		gbl.setConstraints(jl, gbc1);
		jpp2.add(jl);
		
		
		GoodstypeDao gtDao=new GoodstypeDao();
		try {
			ArrayList<GoodstypeVo> gtDataList=gtDao.getAllGoodstype();
			for(GoodstypeVo vo:gtDataList){
				mjbxmlbTjsp.addItem(vo.getGtname(), vo.getGtid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "���ݿ��쳣");
			e.printStackTrace();
		}
		
		
		GridBagConstraints gbc2=new GBC(1, 0).setAnchor(GBC.EAST).setInSets(-5,0, 5, 20);
		mjbxmlbTjsp.setPreferredSize(new Dimension(92,22));
		mjbxmlbTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		mjbxmlbTjsp.setBackground(Color.white);
		gbl.setConstraints(mjbxmlbTjsp, gbc2);
		jpp2.add(mjbxmlbTjsp);
		
		
		mjbxmlbTjsp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mjbxmlbTjsp.getSelectedItem().equals("�ײ�")){
					jcbtjzhxmTjsp.setEnabled(true);
					jcbzdskcTjsp.setEnabled(false);
				}else{
					jcbtjzhxmTjsp.setEnabled(false);
					jcbzdskcTjsp.setEnabled(true);
				}
				
			}
		});
		
		
		GridBagConstraints gbc3=new GBC(2, 0).setAnchor(GBC.EAST).setInSets(-5,30, 0, 5);
		JLabel jl1= new JLabel("�Ʒѷ�ʽ:");
		gbl.setConstraints(jl1, gbc3);
		jpp2.add(jl1);
		
		mjbjffsTjsp.addItem("Ԥ�赥��", -2);
		JifeiDao jfDao=new JifeiDao();
		try {
			ArrayList<JifeiVo> jfDataList=jfDao.queryAllDatas();
			for(JifeiVo vo:jfDataList){
				mjbjffsTjsp.addItem(vo.getJfname(), vo.getJfid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "���ݿ��쳣");
			e.printStackTrace();
		}
		
		
		GridBagConstraints gbc4=new GBC(3, 0).setAnchor(GBC.EAST).setInSets(-5,0, 0, 0);
		mjbjffsTjsp.setPreferredSize(new Dimension(92,22));
		mjbjffsTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		mjbjffsTjsp.setBackground(Color.white);
		gbl.setConstraints(mjbjffsTjsp, gbc4);
		jpp2.add(mjbjffsTjsp);
		
		mjbjffsTjsp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mjbjffsTjsp.getSelectedItem().equals("Ԥ�赥��")){
					jtfysdjTjsp.setEnabled(true);
				}else{
					jtfysdjTjsp.setText("0.00");
					jtfysdjTjsp.setEnabled(false);
				}
				
			}
		});
		
		
		//�ڶ���
		GridBagConstraints gbc5=new GBC(0, 1).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl2= new JLabel("��Ŀ����:");
		gbl.setConstraints(jl2, gbc5);
		jpp2.add(jl2);
		
		GridBagConstraints gbc6=new GBC(1, 1).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		jtfxmbmTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		gbl.setConstraints(jtfxmbmTjsp, gbc6);
		jpp2.add(jtfxmbmTjsp);
		
		
		
		GridBagConstraints gg7=new GBC(2, 1).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JLabel jt1= new JLabel("Ԥ�赥��:");
		gbl.setConstraints(jt1, gg7);
		jpp2.add(jt1);
		
	
		GridBagConstraints gbc8=new GBC(3, 1).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		jtfysdjTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jtfysdjTjsp.setPreferredSize(new Dimension(113,22));
		jtfysdjTjsp.setBackground(Color.white);
		gbl.setConstraints(jtfysdjTjsp, gbc8);
		jpp2.add(jtfysdjTjsp);
		
		//������
		GridBagConstraints gbc9=new GBC(0, 2).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl4= new JLabel("��Ŀ����:");
		gbl.setConstraints(jl4, gbc9);
		jpp2.add(jl4);
		
		GridBagConstraints gb1=new GBC(1, 2).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		gbl.setConstraints(jtfxmmcTjsp, gb1);
		jtfxmmcTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpp2.add(jtfxmmcTjsp);
		
		
		GridBagConstraints gb2=new GBC(2, 2).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JLabel jl5= new JLabel("��λ�ɱ�:");
		gbl.setConstraints(jl5, gb2);
		jpp2.add(jl5);
		
		GridBagConstraints gb3=new GBC(3, 2).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		gbl.setConstraints(jtfdwcbTjsp, gb3);
		jtfdwcbTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpp2.add(jtfdwcbTjsp);
		
		//������
		GridBagConstraints gb4=new GBC(0, 3).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl6= new JLabel("��Ŀ��ƴ:");
		gbl.setConstraints(jl6, gb4);
		jpp2.add(jl6);
		
		GridBagConstraints gb6=new GBC(1, 3).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		gbl.setConstraints(jtfxmjpTjsp, gb6);
		jtfxmjpTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpp2.add(jtfxmjpTjsp);
		
		
		
		GridBagConstraints gb7=new GBC(2, 3).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JLabel jl7= new JLabel("�������:");
		gbl.setConstraints(jl7, gb7);
		jpp2.add(jl7);
		GridBagConstraints gb8=new GBC(3, 3).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		gbl.setConstraints(jtfbjkcTjsp, gb8);
		jtfbjkcTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpp2.add(jtfbjkcTjsp);
		
		
		//������
		GridBagConstraints g5=new GBC(0, 4).setAnchor(GBC.EAST).setInSets(-15,10, -5, 5);
		JLabel j1= new JLabel("�Ƽ۵�λ:");
		gbl.setConstraints(j1, g5);
		jpp2.add(j1);
		
		GridBagConstraints g6=new GBC(1, 4).setAnchor(GBC.EAST).setInSets(-15,0, -5, 20);	
		gbl.setConstraints(jtfjjdwTjsp, g6);
		jtfjjdwTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpp2.add(jtfjjdwTjsp);
		
		
		
		GridBagConstraints g7=new GBC(2, 4,3,1).setAnchor(GBC.EAST).setInSets(5,30, -5, 5);
		JPanel jp1 = new JPanel(new GridLayout(2,1));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setPreferredSize(new Dimension(200,39));
		jcbzdskcTjsp.setBackground(null);
		jcbzdskcTjsp.setOpaque(false);
		jcbzdskcTjsp.setEnabled(true);
		jcbzdskcTjsp.setFocusPainted(false);
		jcbzdxfTjsp.setBackground(null);
		jcbzdxfTjsp.setOpaque(false);
		jcbzdxfTjsp.setFocusPainted(false);
		jp1.add(jcbzdskcTjsp);
		jp1.add(jcbzdxfTjsp);
		gbl.setConstraints(jp1, g7);
		jpp2.add(jp1);
		jpanel.add(jpp2);
				

		
		//������
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp3.setBackground(null);
		jp3.setOpaque(false);
		jp3.setBounds(18, 188, 434, 30);
		jcbthspTjsp.setBackground(null);
		jcbthspTjsp.setOpaque(false);
		jcbthspTjsp.setFocusPainted(false);
		jp3.add(jcbthspTjsp);
		jp3.add(jtfdhjfTjsp);
		jtfdhjfTjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpanel.add(jp3);
		
		
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT,20,5));
		jp5.setBounds(-2, 225, 434, 42);
		jp5.setBackground(null);
		jp5.setOpaque(false);
		jcbtjzhxmTjsp.setEnabled(false);
		jcbtjzhxmTjsp.setBackground(null);
		jcbtjzhxmTjsp.setOpaque(false);
		jcbtjzhxmTjsp.setFocusPainted(false);
		mjbtjxmTjsp.set_PreferredSize(new Dimension(80,20)).set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).setFont(new Font("����", Font.PLAIN, 12));
		mjbtjxmTjsp.setEnabled(false);
		jp5.add(jcbtjzhxmTjsp);
		jp5.add(mjbtjxmTjsp);
		jpanel.add(jp5);
		
		jcbtjzhxmTjsp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcbtjzhxmTjsp.isSelected()){
					mjbtjxmTjsp.setEnabled(true);
				}else{
					mjbtjxmTjsp.setEnabled(false);
				}
				
			}
		});
		
		
		jttjspxmTjsp = new JTable(null,ColumnContent.arrayToVector(ColumnContent.TIANJIASHANGPINXIANGMU_CLUMN_NAME));
		//jttjspxmTjsp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jttjspxmTjsp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jttjspxmTjsp.setAutoCreateRowSorter(true);
		jttjspxmTjsp.setFillsViewportHeight(true);
		jScrollPane.setBounds(15, 260, 405, 97);
		jpanel.add(jScrollPane);
		
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.LEFT,90,10));
		jp6.setBackground(null);
		jp6.setOpaque(false);
		jp6.setBounds(0, 362, 434, 60);
		mjbSaveTjsp.set_PreferredSize(new Dimension(75,22)).set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0));
		mjbCancelTjsp.set_PreferredSize(new Dimension(75,22)).set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0));
		jp6.add(mjbSaveTjsp);
		jp6.add(mjbCancelTjsp);
		jpanel.add(jp6);
		
		//------------------------------------------------------------------
		if(this.yongtu==2){
			int index=frame.getjTableSp().getSelectedRow();
			GoodsDao gdao=new GoodsDao();
			GoodsVo gvo=null;
			try {
				gvo=gdao.getDoodsByGid(Integer.parseInt(frame.getjTableSp().getValueAt(index, 0).toString()));
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "ת���쳣");
				e1.printStackTrace();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "���ݿ��쳣");
				e1.printStackTrace();
			}
			
			mjbxmlbTjsp.setSelectedItem(frame.getjTableSp().getValueAt(index, 5).toString());
			jtfxmbmTjsp.setText(frame.getjTableSp().getValueAt(index, 0).toString());
			jtfxmbmTjsp.setEnabled(false);
			jtfxmmcTjsp.setText(frame.getjTableSp().getValueAt(index, 1).toString());
			jtfxmjpTjsp.setText(gvo.getJp());
			jtfjjdwTjsp.setText(gvo.getDw());
			Integer jfff=gvo.getJfid();
			if(jfff==-2){
				mjbjffsTjsp.setSelectedItem("Ԥ�赥��");
				jtfysdjTjsp.setText(gvo.getPrice().toString());
			}else{
				try {
					JifeiVo jfvo=jfDao.getVoByJfid(gvo.getJfid());
					mjbjffsTjsp.setSelectedItem(jfvo.getJfname());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "���ݿ��쳣");
					e1.printStackTrace();
				}
			}
			
			jtfdwcbTjsp.setText(gvo.getCosts().toString());
			jtfbjkcTjsp.setText(gvo.getWarnstock().toString());
			
			if(gvo.getIsjskc()==1){
				jcbzdskcTjsp.setSelected(true);
			}else if(gvo.getIsjskc()==2){
				jcbzdskcTjsp.setSelected(false);
			}
			
			if(gvo.getIsdh()==2){
				jcbthspTjsp.setSelected(false);
			}else if(gvo.getIsdh()==1){
				jcbthspTjsp.setSelected(true);
				jtfdhjfTjsp.setText(gvo.getDhjf().toString());
			}
			
			
		}
		
		
		return jpanel;
	}


	public JTextField getJtfxmbmTjsp() {
		return jtfxmbmTjsp;
	}


	public JTextField getJtfysdjTjsp() {
		return jtfysdjTjsp;
	}


	public JTextField getJtfdwcbTjsp() {
		return jtfdwcbTjsp;
	}


	public JTextField getJtfxmmcTjsp() {
		return jtfxmmcTjsp;
	}


	public JTextField getJtfxmjpTjsp() {
		return jtfxmjpTjsp;
	}


	public JTextField getJtfjjdwTjsp() {
		return jtfjjdwTjsp;
	}


	public JTextField getJtfbjkcTjsp() {
		return jtfbjkcTjsp;
	}


	public JTextField getJtfdhjfTjsp() {
		return jtfdhjfTjsp;
	}


	public MyJComBoBox getMjbxmlbTjsp() {
		return mjbxmlbTjsp;
	}


	public MyJComBoBox getMjbjffsTjsp() {
		return mjbjffsTjsp;
	}


	public JCheckBox getJcbzdxfTjsp() {
		return jcbzdxfTjsp;
	}


	public JCheckBox getJcbzdskcTjsp() {
		return jcbzdskcTjsp;
	}


	public JCheckBox getJcbthspTjsp() {
		return jcbthspTjsp;
	}


	public JCheckBox getJcbtjzhxmTjsp() {
		return jcbtjzhxmTjsp;
	}


	public MyJButton getMjbSaveTjsp() {
		return mjbSaveTjsp;
	}


	public MyJButton getMjbCancelTjsp() {
		return mjbCancelTjsp;
	}


	public MyJButton getMjbtjxmTjsp() {
		return mjbtjxmTjsp;
	}


	public JTable getJttjspxmTjsp() {
		return jttjspxmTjsp;
	}


	public static int getUPDATE() {
		return UPDATE;
	}
	
	

}
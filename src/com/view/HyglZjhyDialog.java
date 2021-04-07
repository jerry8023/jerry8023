package com.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.action.HyglZjhyDialogAction;
import com.dao.MgradeDao;
import com.sunking.swing.JDatePicker;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.MgradeVo;

public class HyglZjhyDialog extends JDialog {
	
	private JTextField jtfhybhZjhy = new JTextField(10);
	private JTextField jtfhyxmZjhy = new JTextField(10);
	private JTextField jtfdqjfZjhy = new JTextField(10);
	private JTextField jtflxdhZjhy = new JTextField(10);
	private JPasswordField jtfqrkmmZjhy = new JPasswordField(10);
	private JPasswordField jtfszkmmZjhy = new JPasswordField(10);
	
	private MyJComBoBox mjbklxZjhy = new MyJComBoBox();
	private MyJComBoBox mjbhydjZjhy = new MyJComBoBox();
	private MyJComBoBox mjbhyxbZjhy = new MyJComBoBox();
	private MyJComBoBox mjbdqztZjhy = new MyJComBoBox();
	
	private JCheckBox jcbqrmmZjhy = new JCheckBox();
	private JCheckBox jcbyxqzZjhy = new JCheckBox("卡有效期至:");
	
	private JLabel jlqrkmm= new JLabel("确认卡密码:");
	private JLabel jlszkmm= new JLabel("设置卡密码:");
	
	private JDatePicker jdpcsrqZjhy = new JDatePicker(JDatePicker.STYLE_CN_DATE1);
	private JDatePicker jdpyxqZjhy = new JDatePicker(JDatePicker.STYLE_CN_DATE1);

	private JTextArea jtabzZjhy = new JTextArea();
	
	private MyJButton mjbSaveZjhy = new MyJButton("保存");
	private MyJButton mjbCancelZjhy = new MyJButton("取消");

	public final static int ADD = 1;
	public static int UPDATE = 2;
	
	private int addOrUpdate;
	public HyglZjhyDialog(HyglDialog frame,boolean model,int addOrUpdate){
		super(frame,model);
		this.addOrUpdate = addOrUpdate;
		this.setSize(532,410);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("增加会员");
		
		Container container = super.getContentPane();
		container.setLayout(null);
		container.add(content());
		addListener();
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	private void addListener(){
		HyglZjhyDialogAction action = new HyglZjhyDialogAction(this,addOrUpdate);
		mjbSaveZjhy.addActionListener(action);
		mjbCancelZjhy.addActionListener(action);
	}
	public JPanel content(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBounds(0, 0, 532, 400);
		jpanel.setBackground(new Color(236,233,216));
		
		JPanel jp1 = new JPanel(null);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setBounds(11, 7, 510, 320);
		jp1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jpp1 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpp1.add(new JLabel("会员信息"));
		jpp1.setBounds(0,0,510,25);
		jpp1.setBackground(new Color(176,192,135));
		jp1.add(jpp1);
		
		JPanel jpp2 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		jpp2.setLayout(gbl);
		jpp2.setBackground(null);
		jpp2.setOpaque(false);
		jpp2.setBounds(0, 25, 510, 300);
		
		//第一列
		GridBagConstraints gbc1=new GBC(0, 0).setAnchor(GBC.EAST).setInSets(-5,10, 5, 5);
		JLabel jl= new JLabel("会员编号:");
		gbl.setConstraints(jl, gbc1);
		jpp2.add(jl);
		
		GridBagConstraints gbc2=new GBC(1, 0).setAnchor(GBC.EAST).setInSets(-5,0, 5, 20);
		gbl.setConstraints(jtfhybhZjhy, gbc2);
		jpp2.add(jtfhybhZjhy);
		
		
		GridBagConstraints gbc3=new GBC(2, 0).setAnchor(GBC.EAST).setInSets(-5,20, 0, 5);
		JLabel jl1= new JLabel("卡类型:");
		gbl.setConstraints(jl1, gbc3);
		jpp2.add(jl1);
		
		GridBagConstraints gbc4=new GBC(3, 0).setAnchor(GBC.EAST).setInSets(-5,0, 0, 0);
		mjbklxZjhy.addItem("折扣卡", 0);
		mjbklxZjhy.addItem("储值卡", 0);
		mjbklxZjhy.setPreferredSize(new Dimension(113,22));
		mjbklxZjhy.setBackground(Color.white);
		gbl.setConstraints(mjbklxZjhy, gbc4);
		jpp2.add(mjbklxZjhy);
		
		
		//第二列
		GridBagConstraints gbc5=new GBC(0, 1).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl2= new JLabel("会员姓名:");
		gbl.setConstraints(jl2, gbc5);
		jpp2.add(jl2);
		
		GridBagConstraints gbc6=new GBC(1, 1).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		gbl.setConstraints(jtfhyxmZjhy, gbc6);
		jpp2.add(jtfhyxmZjhy);
		
		
		
		GridBagConstraints gg7=new GBC(2, 1).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JLabel jt1= new JLabel("会员等级:");
		gbl.setConstraints(jt1, gg7);
		jpp2.add(jt1);
		
		MgradeDao dao = new MgradeDao();
		ArrayList<MgradeVo> dataList = null;
		try {
			dataList = dao.queryData();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(MgradeVo vo:dataList){
			mjbhydjZjhy.addItem(vo.getMgname(), vo.getMgid());
		}
		GridBagConstraints gbc8=new GBC(3, 1).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		mjbhydjZjhy.setPreferredSize(new Dimension(113,22));
		mjbhydjZjhy.setBackground(Color.white);
		gbl.setConstraints(mjbhydjZjhy, gbc8);
		jpp2.add(mjbhydjZjhy);
		
		//第三列
		GridBagConstraints gbc9=new GBC(0, 2).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl4= new JLabel("会员性别:");
		gbl.setConstraints(jl4, gbc9);
		jpp2.add(jl4);
		
		GridBagConstraints gb1=new GBC(1, 2).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		mjbhyxbZjhy.addItem("男", 1);
		mjbhyxbZjhy.addItem("女", 2);
		mjbhyxbZjhy.setPreferredSize(new Dimension(113,22));
		mjbhyxbZjhy.setBackground(Color.white);
		gbl.setConstraints(mjbhyxbZjhy, gb1);
		jpp2.add(mjbhyxbZjhy);
		
		
		GridBagConstraints gb2=new GBC(2, 2).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JLabel jl5= new JLabel("当前积分:");
		gbl.setConstraints(jl5, gb2);
		jpp2.add(jl5);
		
		GridBagConstraints gb3=new GBC(3, 2).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		jtfdqjfZjhy.setText("100");
		gbl.setConstraints(jtfdqjfZjhy, gb3);
		jpp2.add(jtfdqjfZjhy);
		
		//第四列
		GridBagConstraints gb4=new GBC(0, 3).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jl6= new JLabel("出生日期:");
		gbl.setConstraints(jl6, gb4);
		jpp2.add(jl6);
		
		GridBagConstraints gb6=new GBC(1, 3).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		gbl.setConstraints(jdpcsrqZjhy, gb6);
		jdpcsrqZjhy.setPreferredSize(new Dimension(113,22));
		jdpcsrqZjhy.setBackground(Color.white);
		jpp2.add(jdpcsrqZjhy);
		
		
		
		GridBagConstraints gb7=new GBC(2, 3).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		
		jlszkmm.setEnabled(false);
		gbl.setConstraints(jlszkmm, gb7);
		jpp2.add(jlszkmm);
		GridBagConstraints gb8=new GBC(3, 3).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		gbl.setConstraints(jtfszkmmZjhy, gb8);
		jpp2.add(jtfszkmmZjhy);
		jtfszkmmZjhy.setEditable(false);
		jtfszkmmZjhy.setBackground(Color.white);
		
		//第五列
		GridBagConstraints g5=new GBC(0, 4).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel j1= new JLabel("联系电话:");
		gbl.setConstraints(j1, g5);
		jpp2.add(j1);
		GridBagConstraints g6=new GBC(1, 4).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		gbl.setConstraints(jtflxdhZjhy, g6);
		jpp2.add(jtflxdhZjhy);
		
		
		
		GridBagConstraints g7=new GBC(2, 4).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JPanel jpk =new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		
		jpk.add(jcbqrmmZjhy);
		//为单选按钮添加监听器
		jcbqrmmZjhy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(jcbqrmmZjhy.isSelected()){
					jlqrkmm.setEnabled(true);
					jlszkmm.setEnabled(true);
					jtfqrkmmZjhy.setEnabled(true);
					jtfszkmmZjhy.setEditable(true);
				}else{
					jlqrkmm.setEnabled(false);
					jlszkmm.setEnabled(false);
					jtfqrkmmZjhy.setEnabled(false);
					jtfszkmmZjhy.setEditable(false);
				}
				
			}
		});
		
		jcbqrmmZjhy.setBackground(null);
		jcbqrmmZjhy.setOpaque(false);
		jlqrkmm.setEnabled(false);
		jpk.add(jlqrkmm);
		jpk.setBackground(null);
		jpk.setOpaque(false);
		gbl.setConstraints(jpk, g7);
		jpp2.add(jpk);
		
				
		GridBagConstraints g8=new GBC(3, 4).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		jtfqrkmmZjhy.setEnabled(false);
		gbl.setConstraints(jtfqrkmmZjhy, g8);
		jpp2.add(jtfqrkmmZjhy);
		
		//第六列
		GridBagConstraints g1=new GBC(0,5).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jll1= new JLabel("当前状态:");
		gbl.setConstraints(jll1, g1);
		jpp2.add(jll1);
		
		GridBagConstraints g2=new GBC(1, 5).setAnchor(GBC.EAST).setInSets(5,0, 5, 20);
		mjbdqztZjhy.addItem("可用",1);
		mjbdqztZjhy.addItem("停用",2);
		mjbdqztZjhy.setPreferredSize(new Dimension(113,22));
		mjbdqztZjhy.setBackground(Color.white);
		gbl.setConstraints(mjbdqztZjhy, g2);
		jpp2.add(mjbdqztZjhy);
		
		
		GridBagConstraints g3=new GBC(2, 5).setAnchor(GBC.EAST).setInSets(5,20, 0, 5);
		JPanel jpe= new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jpe.setBackground(null);
		jpe.setOpaque(false);
		jpe.add(jcbyxqzZjhy);
		jcbyxqzZjhy.setBackground(null);
		jcbyxqzZjhy.setOpaque(false);
		gbl.setConstraints(jpe, g3);
		jpp2.add(jpe);
		
		GridBagConstraints g4=new GBC(3, 5).setAnchor(GBC.EAST).setInSets(5,0, 0, 0);
		jdpyxqZjhy.setPreferredSize(new Dimension(113,22));
		jdpyxqZjhy.setBackground(Color.white);
		gbl.setConstraints(jdpyxqZjhy, g4);
		jpp2.add(jdpyxqZjhy);
		jdpyxqZjhy.setEnabled(false);
		jcbyxqzZjhy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(jcbyxqzZjhy.isSelected()){
					jdpyxqZjhy.setEnabled(true);
				}else if(!jcbyxqzZjhy.isSelected()){
					jdpyxqZjhy.setEnabled(false);
				}
			}
		});
		
		
		GridBagConstraints gbb=new GBC(0, 6).setAnchor(GBC.EAST).setInSets(5,10, 5, 5);
		JLabel jlbz = new JLabel("备注：");
		gbl.setConstraints(jlbz, gbb);
		jpp2.add(jlbz);
		
		GridBagConstraints gbb1=new GBC(1, 6,3,3).setAnchor(GBC.EAST).setInSets(5,0, 5, 0);
		jtabzZjhy.setPreferredSize(new Dimension(380,68));
		jtabzZjhy.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//jdpyxqZjhy.setBackground(Color.white);
		gbl.setConstraints(jtabzZjhy, gbb1);
		jpp2.add(jtabzZjhy);
		
		
		jp1.add(jpp2);
		jpanel.add(jp1);
		
		JPanel jp2 = new JPanel();
		jp2.setBounds(0, 332, 530, 80);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		mjbSaveZjhy.set_FocusPainted(false).set_Background(new Color(249,245,227)).set_PreferredSize(new Dimension(60,21));
		mjbCancelZjhy.set_FocusPainted(false).set_Background(new Color(249,245,227)).set_PreferredSize(new Dimension(60,21));

		jp2.add(mjbSaveZjhy);
		JLabel jlbel = new JLabel();
		jlbel.setPreferredSize(new Dimension(200,21));
		jp2.add(jlbel);
		jp2.add(mjbCancelZjhy);
		
		jpanel.add(jp2);
		
		return jpanel;
	}
	
	public JTextField getJtfhybhZjhy() {
		return jtfhybhZjhy;
	}
	public JTextField getJtfhyxmZjhy() {
		return jtfhyxmZjhy;
	}
	public JTextField getJtfdqjfZjhy() {
		return jtfdqjfZjhy;
	}
	public JTextField getJtflxdhZjhy() {
		return jtflxdhZjhy;
	}
	public JTextField getJtfqrkmmZjhy() {
		return jtfqrkmmZjhy;
	}
	public JTextField getJtfszkmmZjhy() {
		return jtfszkmmZjhy;
	}
	public MyJComBoBox getMjbklxZjhy() {
		return mjbklxZjhy;
	}
	public MyJComBoBox getMjbhydjZjhy() {
		return mjbhydjZjhy;
	}
	public MyJComBoBox getMjbhyxbZjhy() {
		return mjbhyxbZjhy;
	}
	public MyJComBoBox getMjbdqztZjhy() {
		return mjbdqztZjhy;
	}
	public JCheckBox getJcbqrmmZjhy() {
		return jcbqrmmZjhy;
	}
	public JCheckBox getJcbyxqzZjhy() {
		return jcbyxqzZjhy;
	}
	public JLabel getJlqrkmm() {
		return jlqrkmm;
	}
	public JLabel getJlszkmm() {
		return jlszkmm;
	}
	public JDatePicker getJdpcsrqZjhy() {
		return jdpcsrqZjhy;
	}
	public JDatePicker getJdpyxqZjhy() {
		return jdpyxqZjhy;
	}
	public JTextArea getJtabzZjhy() {
		return jtabzZjhy;
	}
	public MyJButton getMjbSaveZjhy() {
		return mjbSaveZjhy;
	}
	public MyJButton getMjbCancelZjhy() {
		return mjbCancelZjhy;
	}
	public static void main(String args[]){
		//new HyglZjhyDialog();
	}
}

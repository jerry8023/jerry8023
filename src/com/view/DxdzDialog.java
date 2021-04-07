package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.action.DxdzDialogAction;
import com.action.DxdzDialogMouseListener;
import com.dao.DazheDao;
import com.dao.MgradeDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;
import com.vo.DazheVo;
import com.vo.MgradeVo;



public class DxdzDialog extends JDialog{

	public static final int BAOJIANLXDZ=1;
	public static final int SHANGPINDZ=2;
	public static int yongtu;
	
	private static final long serialVersionUID = 6221409894886430473L;
	
	private XtszDialog frame;
	public static Vector<Vector> rowdatas=new Vector<Vector>();
	
	private JTextField jtfxmmcdx = new JTextField(10);
	private JTextField jtfpricedx= new JTextField("0.00",6);
	private JTextField jtfdzbldx    = new JTextField(4);
	private JComboBox jcmptgbdzlxdx = new JComboBox();
	private JCheckBox  jcbsfzytyspdx = new JCheckBox("此项设置作用于所有同类商品");
	private MyJButton  mjbSavedxdz = new MyJButton("保存");
	private MyJButton  mjbQcdzdxdz = new MyJButton("清除打折");
	private MyJButton  mjbExitdxdx = new MyJButton("取消");
	private JTable jtdxdzdxdz;
	
	
	public DxdzDialog(XtszDialog owner,boolean model,int yongtu){
		super(owner,model);
		this.frame=owner;
		this.yongtu=yongtu;
		super.setSize(409, 358);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setTitle("单项打折设置");
		
		Container container = super.getContentPane();
		container.add(north(),BorderLayout.NORTH);
		container.add(content(),BorderLayout.CENTER);
		
		
		addListener();
		
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void addListener(){
		DxdzDialogMouseListener mouseListener=new DxdzDialogMouseListener(this);
		jtdxdzdxdz.addMouseListener(mouseListener);
		
		DxdzDialogAction action=new DxdzDialogAction(this);
		mjbSavedxdz.addActionListener(action);
		mjbQcdzdxdz.addActionListener(action);
		mjbExitdxdx.addActionListener(action);
	}
	
	
	public JPanel north(){
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT,0,12));
		jpNorth.setBackground(new Color(236,233,216));
		jpNorth.setPreferredSize(new Dimension(410,40));
		JLabel jl1 = new JLabel(" 项目名称:");
		jl1.setFont(new Font("宋体", Font.PLAIN, 19));
		jtfxmmcdx.setEditable(false);
		jtfxmmcdx.setBackground(null);
		jtfxmmcdx.setOpaque(false);
		jtfxmmcdx.setBorder(null);
		jtfxmmcdx.setFont(new Font("宋体",Font.PLAIN,19));
		jtfxmmcdx.setForeground(Color.blue);
		jpNorth.add(jl1);
		jpNorth.add(jtfxmmcdx);
		
		if(this.yongtu==1){
			jtfxmmcdx.setText(frame.getjTableBjlx().getValueAt(frame.getjTableBjlx().getSelectedRow(), 0).toString());
		}else if(this.yongtu==2){
			jtfxmmcdx.setText(frame.getjTableSp().getValueAt(frame.getjTableSp().getSelectedRow(), 1).toString());
		}
		
		
		JLabel jl2 = new JLabel("       单价:");
		jl2.setFont(new Font("宋体",Font.PLAIN,19));
		jtfpricedx.setEditable(false);
		jtfpricedx.setBackground(null);
		jtfpricedx.setOpaque(false);
		jtfpricedx.setBorder(null);
		jtfpricedx.setFont(new Font("宋体",Font.PLAIN,19));
		jtfpricedx.setForeground(Color.blue);
		jpNorth.add(jl2);
		jpNorth.add(jtfpricedx);
		
		if(this.yongtu==2){
			jtfpricedx.setText(frame.getjTableSp().getValueAt(frame.getjTableSp().getSelectedRow(), 3).toString());
		}
		
		return jpNorth;
	}
	
	public JPanel content(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		//jpanel.setPreferredSize(new Dimension(227,225));
		
		JPanel jpp1 = new JPanel(null);
		jpp1.setBounds(5, 8, 391, 187);
		jpp1.setBackground(new Color(236,233,216));
		jpp1.setBackground(null);
		jpp1.setOpaque(false);
		//加第一个面板
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		jp1.setBackground(new Color(236,233,216));
		jp1.setBounds(6,5,381,33);
		JLabel jldzlx = new JLabel("  普通贵宾打折类型:");
		jcmptgbdzlxdx.setPreferredSize(new Dimension(70,22));
		jcmptgbdzlxdx.setModel(new DefaultComboBoxModel(new String[]{"打折","不打折"}));
		jcmptgbdzlxdx.setBackground(Color.WHITE);
		jp1.add(jldzlx);
		jp1.add(jcmptgbdzlxdx);
		JLabel jldzbl = new JLabel("  普通贵宾打折比例:");
		jtfdzbldx.setText("无");
		jp1.add(jldzbl);
		jp1.add(jtfdzbldx);
		jpp1.add(jp1);
		
		jcmptgbdzlxdx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcmptgbdzlxdx.getSelectedItem().toString().equals("打折")){
					jtfdzbldx.setText("无");
					jtfdzbldx.setEnabled(true);
				}else if(jcmptgbdzlxdx.getSelectedItem().toString().equals("不打折")){
					jtfdzbldx.setText("1.0");
					jtfdzbldx.setEnabled(false);
				}
				
			}
		});
		
		
		
		
		
		
		//Vector<Vector> rowdatas=new Vector<Vector>();
		int index=0;
		String dzname="";
		if(this.yongtu==1){
			index=frame.getjTableBjlx().getSelectedRow();
			dzname=frame.getjTableBjlx().getValueAt(index, 0).toString();
		}else if(this.yongtu==2){
			index=frame.getjTableSp().getSelectedRow();
			dzname=frame.getjTableSp().getValueAt(index, 1).toString();
		}
		MgradeDao mgDao=new MgradeDao();
		DazheDao dzDao=new DazheDao();
		try {
			ArrayList<MgradeVo> mgDataList=mgDao.queryData();
			Vector<Vector> datas=new Vector<Vector>();
			for(MgradeVo vo:mgDataList){
				ArrayList<DazheVo> dzDatalist=dzDao.getVoByDznameAndMgname(dzname, vo.getMgid());
				Vector row=new Vector();
				if(dzDatalist==null||dzDatalist.size()==0){
					row.add(vo.getMgname());
					row.add("无");
					row.add(Double.parseDouble(jtfpricedx.getText()));
					//jtfdzbldx.setText("无");
					
				}else{
					row.add(vo.getMgname());
					row.add(dzDatalist.get(0).getDzbl());
					row.add((dzDatalist.get(0).getDzbl())*Double.parseDouble(jtfpricedx.getText()));
					if(dzDatalist.get(0).getDzremarks()==null){
						jtfdzbldx.setText("无");
					}else{
						jtfdzbldx.setText(dzDatalist.get(0).getDzremarks().toString());
					}
				}
				datas.add(row);
			}
			rowdatas=datas;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		
		jtdxdzdxdz = new JTable(rowdatas, ColumnContent.arrayToVector(ColumnContent.DANXIANGDAZHESHEZHI_CLUMN_NAME)) {//添加部分1
			  public boolean isCellEditable(int row, int column) {
			    return false;
			  }
		};
		
		
		
		//jtdxdzdxdz = new JTable(rowdatas, ColumnContent.arrayToVector(ColumnContent.DANXIANGDAZHESHEZHI_CLUMN_NAME));
		jtdxdzdxdz.setAutoCreateRowSorter(true);
		jtdxdzdxdz.setFillsViewportHeight(true);
		JScrollPane jScrollPane = new JScrollPane(jtdxdzdxdz,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jScrollPane.setViewportView(jtdxdzdxdz);
		jtdxdzdxdz.getColumnModel().getColumn(0).setPreferredWidth(170);
		jtdxdzdxdz.getColumnModel().getColumn(1).setPreferredWidth(81);
		jtdxdzdxdz.getColumnModel().getColumn(2).setPreferredWidth(158);
		jtdxdzdxdz.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(143,142,117)));
		jScrollPane.setBounds(9, 39, 372, 143);
		jpp1.add(jScrollPane);
		jpp1.setBorder(BorderFactory.createLineBorder(new Color(143,142,117),1));
		jpanel.add(jpp1);
		

		JPanel jpa1 = new JPanel(new GridLayout(2,1));
		jpa1.setBackground(new Color(236,233,216));
		jpa1.setBounds(5,195, 406, 49);
		jcbsfzytyspdx.setBackground(new Color(236,233,216));
		jcbsfzytyspdx.setFocusable(false);
		jpa1.add(jcbsfzytyspdx);
		JLabel jl1 = new JLabel(" 注：打折比例为“无”时即没有单项打折比例，0.8为八折，0为免费！");
		jl1.setForeground(Color.red);
		jl1.setFont(new Font("宋体",Font.PLAIN,12));
		jpa1.add(jl1);
		jpanel.add(jpa1);
		
		JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.LEFT,40,12));
		jpButton.setBackground(new Color(236,233,216));
		jpButton.setBounds(5, 240, 406, 59);
		mjbSavedxdz.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
		   		   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
		mjbQcdzdxdz.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
		     	   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
		mjbExitdxdx.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
 				   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(251,249,231));
		jpButton.add(mjbSavedxdz);
		jpButton.add(mjbQcdzdxdz);
		jpButton.add(mjbExitdxdx);
		jpanel.add(jpButton);
		
		
		return jpanel;
	}

	
	public JTextField getJtfxmmcdx() {
		return jtfxmmcdx;
	}

	public JTextField getJtfpricedx() {
		return jtfpricedx;
	}

	public JTextField getJtfdzbldx() {
		return jtfdzbldx;
	}

	public JComboBox getJcmptgbdzlxdx() {
		return jcmptgbdzlxdx;
	}

	public JCheckBox getJcbsfzytyspdx() {
		return jcbsfzytyspdx;
	}

	public MyJButton getMjbSavedxdz() {
		return mjbSavedxdz;
	}

	public MyJButton getMjbQcdzdxdz() {
		return mjbQcdzdxdz;
	}

	public MyJButton getMjbExitdxdx() {
		return mjbExitdxdx;
	}

	public JTable getJtdxdzdxdz() {
		return jtdxdzdxdz;
	}

	
	
	
	
	/*public static void main(String[] args) {
		new DxdzDialog();

	}*/

	
	
}

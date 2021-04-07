package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.ZjbjAction;
import com.dao.BaojiantypeDao;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.vo.BaojiantypeVo;

public class ZjbjDialog extends JDialog{

	private static final long serialVersionUID = -8376723306976398598L;
	private JComboBox jcmBjlxzjbj ;
	private JTextField     jtfbjbhzjbj = new JTextField(8);
	private JTextField     jtfszqyzjzb = new JTextField("无",8);
	private MyJButton      mjbSavezjzb = new MyJButton("保存");
	private MyJButton      mjbExitzjzb = new MyJButton("取消");
	
	private XtszDialog xtszDialog;
	private int addOrUpdate;
	
	public XtszDialog getXtszDialog() {
		return xtszDialog;
	}
	



	public int getAddOrUpdate() {
		return addOrUpdate;
	}




	public static final int ADD = 0;
	public static final int UPDATE = 1;
	
	public ZjbjDialog(XtszDialog frame,boolean model,int addOrUpdate){
		super(frame,model);
		if(addOrUpdate==ADD||addOrUpdate==UPDATE){
			this.addOrUpdate = addOrUpdate;
			this.xtszDialog = frame;
			if(addOrUpdate==ADD){
				this.setTitle("增加包间");
			}else if(addOrUpdate==UPDATE){
				this.setTitle("修改包间信息");
			}
			super.setSize(274, 220);
			super.setLocationRelativeTo(null);
			super.setResizable(false);
			
			Container container = super.getContentPane();
			container.add(content(),BorderLayout.CENTER);
			addListener();
			super.setVisible(true);
			super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}else{
			throw new IllegalArgumentException("addOrUpdate参数必需为0或1");
		
		}
	
	}
	
	
	
	private void addListener(){
		ZjbjAction action = new ZjbjAction(this);
		mjbSavezjzb.addActionListener(action);
		mjbExitzjzb.addActionListener(action);
	}
	public JPanel content(){
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 10, 343, 228);
		GridBagLayout layout = new GridBagLayout();
		jpanel.setLayout(layout);
		jpanel.setBackground(new Color(236,233,216));
		
		JLabel jlbjlx = new JLabel("包间类型:");
		layout.setConstraints(jlbjlx, new GBC(0, 0).setInSets(0, 15, 8, 0));
		jpanel.add(jlbjlx);
		BaojiantypeDao dao = new BaojiantypeDao();
		List<BaojiantypeVo> baojianTypeList = null;
		try {
			baojianTypeList =  dao.getAllBaojiantype();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "初始化部门信息出错");
			e.printStackTrace();
		}
		Vector values = new Vector();
		for(BaojiantypeVo vo :baojianTypeList){
						//10-accounting
			values.add(vo.getBjtname()); //Jcombobox中的每一项，最好能够即存储部门名称，又存储部门编号
		}
		
		jcmBjlxzjbj = new JComboBox(values);
		jcmBjlxzjbj.setPreferredSize(new Dimension(91,20));
		jcmBjlxzjbj.setBackground(Color.WHITE);
		layout.setConstraints(jcmBjlxzjbj, new GBC(1, 0).setInSets(0, 1, 8, 0).setAnchor(GBC.EAST));
		jpanel.add(jcmBjlxzjbj);
		
		JLabel jlzdxf = new JLabel("包间编号:");
		layout.setConstraints(jlzdxf, new GBC(0, 1).setInSets(8, 15, 8, 0));
		jpanel.add(jlzdxf);
		layout.setConstraints(jtfbjbhzjbj, new GBC(1, 1).setInSets(8, 8, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfbjbhzjbj);
	
		
		JLabel jlrnrs = new JLabel("所在区域:");
		layout.setConstraints(jlrnrs, new GBC(0, 2).setInSets(8, 15, 8,0));
		jpanel.add(jlrnrs);
		layout.setConstraints(jtfszqyzjzb, new GBC(1, 2).setInSets(8, 8, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfszqyzjzb);
		
		mjbSavezjzb.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
		           .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		layout.setConstraints(mjbSavezjzb, new GBC(0, 3).setInSets(16, 0, 1, 20));
		jpanel.add(mjbSavezjzb);
		mjbExitzjzb.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
        		   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		layout.setConstraints(mjbExitzjzb, new GBC(1, 3).setInSets(16, 30, 1, 0));
		jpanel.add(mjbExitzjzb);
		
		
		return jpanel;
	}




	public JComboBox getJcmBjlxzjbj() {
		return jcmBjlxzjbj;
	}




	public JTextField getJtfbjbhzjbj() {
		return jtfbjbhzjbj;
	}




	public JTextField getJtfszqyzjzb() {
		return jtfszqyzjzb;
	}




	public MyJButton getMjbSavezjzb() {
		return mjbSavezjzb;
	}




	public MyJButton getMjbExitzjzb() {
		return mjbExitzjzb;
	}
	
	

}

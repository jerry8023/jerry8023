package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.action.UpdateCgjhDialogAction;
import com.view.util.GBC;
import com.view.util.MyJButton;

public class UpdateCgjhDialog extends JDialog {
	
	private JTextField     jtfSpbhucd = new JTextField(8);
	private JTextField     jtfSpnameucd = new JTextField("无",8);
	private JTextField     jtfSpslucd = new JTextField(8);
	private JTextField     jtfSppricecd = new JTextField("无",8);
	private MyJButton      mjbSaveucd = new MyJButton("保存");
	private MyJButton      mjbExitucd = new MyJButton("取消");

	private JTable jTable = null;
	
	public UpdateCgjhDialog(CgjhDialog frame,boolean model){
		super(frame,model);
		jTable = frame.getjTableCgjh();
		this.setTitle("修改商品信息");
	
		super.setSize(274, 220);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		addListener();
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	
	
	}
	
	private void addListener(){
		UpdateCgjhDialogAction action = new UpdateCgjhDialogAction(this);
		mjbSaveucd.addActionListener(action);
		mjbExitucd.addActionListener(action);
	}
	public JPanel content(){
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 10, 343, 228);
		GridBagLayout layout = new GridBagLayout();
		jpanel.setLayout(layout);
		jpanel.setBackground(new Color(236,233,216));
		
		//得到JTable中的相关数据
		int selected = jTable.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) jTable.getModel();
		Vector<Vector> vector = model.getDataVector();
		
		JLabel jlbjlx = new JLabel("商品编号:");
		layout.setConstraints(jlbjlx, new GBC(0, 0).setInSets(0, 15, 8, 0));
		jpanel.add(jlbjlx);
		jtfSpbhucd.setText(vector.get(selected).get(0).toString());
		jtfSpbhucd.setEditable(false);
		layout.setConstraints(jtfSpbhucd, new GBC(1, 0).setInSets(0, 1, 8, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfSpbhucd);
		
		
		JLabel jlzdxf = new JLabel("商品名称:");
		layout.setConstraints(jlzdxf, new GBC(0, 1).setInSets(8, 15, 8, 0));
		jpanel.add(jlzdxf);
		jtfSpnameucd.setText(vector.get(selected).get(1).toString());
		jtfSpnameucd.setEditable(false);
		layout.setConstraints(jtfSpnameucd, new GBC(1, 1).setInSets(8, 8, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfSpnameucd);
	
		
		JLabel jlprice = new JLabel("单价:");
		layout.setConstraints(jlprice, new GBC(0, 2).setInSets(8, 15, 8,0));
		jpanel.add(jlprice);
		jtfSppricecd.setText(vector.get(selected).get(3).toString());
		jtfSppricecd.setEditable(false);
		layout.setConstraints(jtfSppricecd, new GBC(1, 2).setInSets(8, 8, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfSppricecd);
		
		JLabel jlnumber = new JLabel("数量:");
		layout.setConstraints(jlnumber, new GBC(0, 3).setInSets(8, 15, 8,0));
		jpanel.add(jlnumber);
		layout.setConstraints(jtfSpslucd, new GBC(1, 3).setInSets(8, 8, 1, 0).setAnchor(GBC.EAST));
		jpanel.add(jtfSpslucd);
		
		mjbSaveucd.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
		           .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		layout.setConstraints(mjbSaveucd, new GBC(0, 4).setInSets(16, 0, 1, 20));
		jpanel.add(mjbSaveucd);
		mjbExitucd.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
        		   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		layout.setConstraints(mjbExitucd, new GBC(1, 4).setInSets(16, 30, 1, 0));
		jpanel.add(mjbExitucd);
		
		
		return jpanel;
	}
	
	
	public JTextField getJtfSpbhucd() {
		return jtfSpbhucd;
	}

	public JTextField getJtfSpnameucd() {
		return jtfSpnameucd;
	}

	public JTextField getJtfSpslucd() {
		return jtfSpslucd;
	}

	public JTextField getJtfSppricecd() {
		return jtfSppricecd;
	}

	public MyJButton getMjbSaveucd() {
		return mjbSaveucd;
	}

	public MyJButton getMjbExitucd() {
		return mjbExitucd;
	}

	public JTable getjTable() {
		return jTable;
	}

	public static void main(String args[]){
	//	new UpdateCgjhDialog(null, false);
	}

}

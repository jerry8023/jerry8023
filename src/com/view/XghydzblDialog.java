package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import com.action.XghydzblDialogAction;
import com.util.YanZhengUtil;
import com.view.util.GBC;
import com.view.util.MyJButton;

public class XghydzblDialog extends JDialog{
	
	private DxdzDialog frame;
	private MyJButton mjbQd=new MyJButton("确定").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(60, 22));
	private MyJButton mjbQx=new MyJButton("取消").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(60, 22));
	private JComboBox jcbDzlx=new JComboBox(new Object[]{"打折","不打折"});
	private JTextField jtfDzbl=new JTextField(8);
	
	
	public XghydzblDialog(DxdzDialog owner,boolean model){
		
		super(owner,model);
		this.frame=owner;
		super.setSize(250,192);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setTitle("修改会员打折比例");
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		addListener();
		
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	
	
	public void addListener(){
		
		XghydzblDialogAction action=new XghydzblDialogAction(this);
		mjbQd.addActionListener(action);
		mjbQx.addActionListener(action);
		jcbDzlx.addActionListener(action);
	}
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		jPanel.add(jp1());
		jPanel.add(jp2());
		
		return jPanel;
	}

	public JPanel jp1(){
		GridBagLayout gbl=new GridBagLayout();
		JPanel jPanel=new JPanel(gbl);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(30, 15, 187, 88);
		
		JLabel jlHydj=new JLabel("会员等级：");
		gbl.setConstraints(jlHydj, new GBC(0, 0).setInSets(0, 0, 8, 0));
		
		JLabel jlMgname=new JLabel("高级会员");
		gbl.setConstraints(jlMgname, new GBC(1, 0).setInSets(0, 0, 8, 0).setAnchor(GBC.WEST));
		
		int index=frame.getJtdxdzdxdz().getSelectedRow();
		jlMgname.setText(frame.getJtdxdzdxdz().getValueAt(index, 0).toString());
		
		
		JLabel jlDzlx=new JLabel("打折类型：");
		gbl.setConstraints(jlDzlx, new GBC(0,1).setInSets(0, 0, 8, 0));
		
		
		jcbDzlx.setBackground(Color.WHITE);
		jcbDzlx.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jcbDzlx.setPreferredSize(new Dimension(91, 21));
		gbl.setConstraints(jcbDzlx, new GBC(1,1).setInSets(0, 0, 8, 0));
		
		
		JLabel jlDzbl=new JLabel("打折比例：");
		gbl.setConstraints(jlDzbl, new GBC(0,2).setInSets(0, 0, 0, 0));
		
		
		jtfDzbl.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		gbl.setConstraints(jtfDzbl, new GBC(1,2).setInSets(0, 0, 0, 0));
		
		
		String dzbl=frame.getJtdxdzdxdz().getValueAt(index, 1).toString();
		jtfDzbl.setText(dzbl);
		jcbDzlx.setSelectedItem("打折");
		if(dzbl.equals("无")){
			jtfDzbl.setText(dzbl);
			jcbDzlx.setSelectedItem("打折");
		}else if(Double.parseDouble(dzbl)==1.0){
			jcbDzlx.setSelectedItem("不打折");
			jtfDzbl.setEnabled(false);
		}
		
		
		
		
		jPanel.add(jlHydj);
		jPanel.add(jlMgname);
		jPanel.add(jlDzlx);
		jPanel.add(jcbDzlx);
		jPanel.add(jlDzbl);
		jPanel.add(jtfDzbl);
		
		
		return jPanel;
	}
	
	
	public JPanel jp2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,45,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(-5, 120, 214, 22);
		
		
		jPanel.add(mjbQd);
		jPanel.add(mjbQx);
		
		
		return jPanel;
	}


	public DxdzDialog getFrame() {
		return frame;
	}


	public MyJButton getMjbQd() {
		return mjbQd;
	}


	public MyJButton getMjbQx() {
		return mjbQx;
	}


	public JComboBox getJcbDzlx() {
		return jcbDzlx;
	}


	public JTextField getJtfDzbl() {
		return jtfDzbl;
	}
	
	
	

}

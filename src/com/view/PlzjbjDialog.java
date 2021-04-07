package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.action.KeyListenerPlzjbj;
import com.action.PlzjbjAction;
import com.dao.BaojiantypeDao;
import com.view.util.MyJButton;
import com.vo.BaojiantypeVo;

public class PlzjbjDialog extends JDialog{

	
	private static final long serialVersionUID = 3905588800544325879L;
	
	
	private JTextField jtfStartbjfwplzj = new JTextField(6);
	private JTextField jtfEndbjfwplzj = new JTextField(6);
	private JRadioButton jrbzqplzj = new JRadioButton("置前",true);
	private JRadioButton jrbzhplzj = new JRadioButton("置后");
	private JTextField jtfbjzfplzj = new JTextField(6);
	private JComboBox jcmBjlxplzj;
	private JTextField jtfszqyplzj = new JTextField("无",8);
	private MyJButton  mjbSaveplzj = new MyJButton("保存");
	private MyJButton  mjbExitplzj = new MyJButton("取消");
	public PlzjbjDialog(XtszDialog frame,boolean model){
		super(frame,model);
		super.setTitle("增加包间");
		super.setSize(279, 239);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		container.setBackground(Color.blue);
		
		addListener();
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setVisible(true);
		
	}
	private void addListener(){
		PlzjbjAction action = new PlzjbjAction(this);
		mjbSaveplzj.addActionListener(action);
		mjbExitplzj.addActionListener(action);
		jtfStartbjfwplzj.addKeyListener(new KeyListenerPlzjbj());
		jtfEndbjfwplzj.addKeyListener(new KeyListenerPlzjbj());
	}
	public JPanel content(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBounds(0, 0,276, 212);
		//jpanel.setBackground(Color.blue);
		jpanel.setBackground(new Color(236,233,216));
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,8));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		//jp1.setBackground(Color.blue);
		jp1.setBounds(5, 13, 270, 80);
		//jp1.setPreferredSize(new Dimension(280,80));
		JLabel jlbjfw =new JLabel("    包间范围: ") ;
		JLabel jlz = new JLabel("  至  ");
		jp1.add(jlbjfw);
		jp1.add(jtfStartbjfwplzj);
		jp1.add(jlz);
		jp1.add(jtfEndbjfwplzj);
		jpanel.add(jp1);
		
		JPanel jp2  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,8));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		jp2.setBounds(5,45,276,37);
		JLabel jlbjzf = new JLabel("    标记字符: ");
		ButtonGroup bgBjzfplzj = new ButtonGroup();
		jrbzqplzj.setBackground(null);
		jrbzqplzj.setOpaque(false);
		jrbzhplzj.setBackground(null);
		jrbzhplzj.setOpaque(false);
		bgBjzfplzj.add(jrbzqplzj);
		bgBjzfplzj.add(jrbzhplzj);
		jp2.add(jlbjzf);
		jp2.add(jtfbjzfplzj);
		jp2.add(jrbzqplzj);
		jp2.add(jrbzhplzj);
		jpanel.add(jp2);
		
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp3.setBackground(null);
		jp3.setOpaque(false);
		jp3.setBounds(5, 82, 276, 37);
		JLabel jlbjlx = new JLabel("   包间类型:");
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
		
		jcmBjlxplzj = new JComboBox(values);
		jcmBjlxplzj.setPreferredSize(new Dimension(91,20));
		jcmBjlxplzj.setBackground(Color.WHITE);
		jp3.add(jlbjlx);
		jp3.add(jcmBjlxplzj);
		jpanel.add(jp3);
		
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp4.setBackground(null);
		jp4.setOpaque(false);
		jp4.setBounds(5, 120, 276, 37);
		JLabel jlrnrs = new JLabel("   所在区域:");
		jp4.add(jlrnrs);
		jp4.add(jtfszqyplzj);
		jpanel.add(jp4);
		
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT,48,5));
		jp5.setBackground(null);
		jp5.setOpaque(false);
		jp5.setBounds(5, 170, 276, 70);
		mjbSaveplzj.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
        .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		jp5.add(mjbSaveplzj);
		mjbExitplzj.set_PreferredSize(new Dimension(62,22)).set_FocusPainted(false)
				   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));
		jp5.add(mjbExitplzj);
		jpanel.add(jp5);
		return jpanel;
	}
	public JTextField getJtfStartbjfwplzj() {
		return jtfStartbjfwplzj;
	}
	public JTextField getJtfEndbjfwplzj() {
		return jtfEndbjfwplzj;
	}
	public JRadioButton getJrbzqplzj() {
		return jrbzqplzj;
	}
	public JRadioButton getJrbzhplzj() {
		return jrbzhplzj;
	}
	public JTextField getJtfbjzfplzj() {
		return jtfbjzfplzj;
	}
	public JComboBox getJcmBjlxplzj() {
		return jcmBjlxplzj;
	}
	public JTextField getJtfszqyplzj() {
		return jtfszqyplzj;
	}
	public MyJButton getMjbSaveplzj() {
		return mjbSaveplzj;
	}
	public MyJButton getMjbExitplzj() {
		return mjbExitplzj;
	}
	
}

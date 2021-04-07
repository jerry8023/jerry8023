package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.action.SpglDialogAction;
import com.view.util.MyJButton;

/**
 *
 * SpglDialog.java:商品管理界面
 * @author czp
 * @time 2013-7-11 上午2:16:34
 * 
 */
public class SpglDialog extends JDialog{

	
	
	private static final long serialVersionUID = -6859884113776890979L;

	
	
	private MyJButton mjbCgjh=new MyJButton("image//cgjh0.png", "image//cgjh0.png", "image//cgjh1.png");
	private MyJButton mjbCgth=new MyJButton("image//cgth0.png", "image//cgth0.png", "image//cgth1.png");
	private MyJButton mjbKcdb=new MyJButton("image//kcdb0.png", "image//kcdb0.png", "image//kcdb1.png");
	private MyJButton mjbBsby=new MyJButton("image//bsby0.png", "image//bsby0.png", "image//bsby1.png");
	
	private JButton jbSpsz=new JButton("商品设置",new ImageIcon("image//bj1.png"));
	private JButton jbGhsxx=new JButton("供货商信息",new ImageIcon("image//bj1.png"));
	private JButton jbCksz=new JButton("仓库设置",new ImageIcon("image//bj1.png"));
	
	
	
	public SpglDialog(AppMainFrame frame,boolean model){
		super(frame,model);
		super.setSize(548,420);
		super.setLocationRelativeTo(null);
		super.setTitle("商品管理");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		addListener();
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	private void addListener(){
		SpglDialogAction spaction = new SpglDialogAction(this);
		mjbCgjh.addActionListener(spaction);
		mjbCgth.addActionListener(spaction);
		mjbKcdb.addActionListener(spaction);
		mjbBsby.addActionListener(spaction);
		jbSpsz.addActionListener(spaction);
		jbGhsxx.addActionListener(spaction);
		jbCksz.addActionListener(spaction);
	}
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		JLabel jlCenterPicture=new JLabel(new ImageIcon("image//spgljm.png"));
		jlCenterPicture.setBounds(151,58,227,180);
		
		JPanel contentOfLeft= contentOfLeft();
		contentOfLeft.setBounds(37,58, 114, 181);
		
		JPanel contentOfRight= contentOfRight();
		contentOfRight.setBounds(378,58, 114, 181);
		
		JPanel contentOfSouth=contentOfSouth();
		contentOfSouth.setBounds(37,285,466,57);
		
		
		jPanel.add(jlCenterPicture);
		jPanel.add(contentOfLeft);
		jPanel.add(contentOfRight);
		jPanel.add(contentOfSouth);
		
		
		return jPanel;
	}
	
	
	public JPanel contentOfLeft(){
		GridLayout gl=new GridLayout(4,1);
		gl.setVgap(27);
		JPanel jPanel=new JPanel(gl);
		jPanel.setPreferredSize(new Dimension(114,181));
		jPanel.setBackground(new Color(236,233,216));
		
		
		
		jPanel.add(mjbCgjh);
		jPanel.add(mjbCgth);
		jPanel.add(mjbKcdb);
		jPanel.add(mjbBsby);
		
		return jPanel;
	}
	
	
	public JPanel contentOfRight(){
		GridLayout gl=new GridLayout(4,1);
		gl.setVgap(27);
		JPanel jPanel=new JPanel(gl);
		jPanel.setPreferredSize(new Dimension(114,181));
		jPanel.setBackground(new Color(236,233,216));
		
		
		MyJButton mjbDjcx=new MyJButton("image//djcx0.png", "image//djcx0.png", "image//djcx1.png");
		MyJButton mjbKccx=new MyJButton("image//kccx0.png", "image//kccx0.png", "image//kccx1.png");
		MyJButton mjbCbfx=new MyJButton("image//cbfx0.png", "image//cbfx0.png", "image//cbfx1.png");
		MyJButton mjbKcbj=new MyJButton("image//kcbj0.png", "image//kcbj0.png", "image//kcbj1.png");
		
		
		jPanel.add(mjbDjcx);
		jPanel.add(mjbKccx);
		jPanel.add(mjbCbfx);
		jPanel.add(mjbKcbj);
		
		return jPanel;
	}
	
	
	public JPanel contentOfSouth(){
		JPanel jPanel=new JPanel();
		jPanel.setPreferredSize(new Dimension(460,57));
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(21,114,182), 2));
		
		/*JLabel jlSpsz=new JLabel("商品设置", new ImageIcon("image//bj1.png"), JLabel.LEFT);
		JLabel jlGhsxx=new JLabel("供货商信息", new ImageIcon("image//bj1.png"), JLabel.LEFT);
		JLabel jlCksz=new JLabel("仓库设置", new ImageIcon("image//bj1.png"), JLabel.LEFT);
		
		jPanel.add(jlSpsz);
		jPanel.add(jlGhsxx);
		jPanel.add(jlCksz);*/
		
		
		jbSpsz.setVerticalTextPosition(JButton.CENTER);
		jbSpsz.setHorizontalTextPosition(JButton.RIGHT);
		jbSpsz.setContentAreaFilled(false);
		jbSpsz.setBorderPainted(false);
		jbSpsz.setFocusPainted(false);
		jbSpsz.setFont(new Font("宋体",Font.BOLD,18));
		jbSpsz.setForeground(new Color(21,114,182));
		
		
		jbGhsxx.setVerticalTextPosition(JButton.CENTER);
		jbGhsxx.setHorizontalTextPosition(JButton.RIGHT);
		jbGhsxx.setContentAreaFilled(false);
		jbGhsxx.setBorderPainted(false);
		jbGhsxx.setFocusPainted(false);
		jbGhsxx.setFont(new Font("宋体",Font.BOLD,18));
		jbGhsxx.setForeground(new Color(21,114,182));
		
		
		
		jbCksz.setVerticalTextPosition(JButton.CENTER);
		jbCksz.setHorizontalTextPosition(JButton.RIGHT);
		jbCksz.setContentAreaFilled(false);
		jbCksz.setBorderPainted(false);
		jbCksz.setFocusPainted(false);
		jbCksz.setFont(new Font("宋体",Font.BOLD,18));
		jbCksz.setForeground(new Color(21,114,182));
		
		
		jPanel.add(jbSpsz);
		jPanel.add(jbGhsxx);
		jPanel.add(jbCksz);
		
		return jPanel;
	}
	
	
	public MyJButton getMjbCgjh() {
		return mjbCgjh;
	}
	public MyJButton getMjbCgth() {
		return mjbCgth;
	}
	public MyJButton getMjbKcdb() {
		return mjbKcdb;
	}
	public MyJButton getMjbBsby() {
		return mjbBsby;
	}
	public JButton getJbSpsz() {
		return jbSpsz;
	}
	public JButton getJbGhsxx() {
		return jbGhsxx;
	}
	public JButton getJbCksz() {
		return jbCksz;
	}
	

}

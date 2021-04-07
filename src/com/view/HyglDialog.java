package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.action.HyglDialogAction;
import com.dao.MemberDao;
import com.dao.MgradeDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;
import com.vo.MgradeVo;

public class HyglDialog extends JDialog{

	
	private static final long serialVersionUID = 2798301001343056092L;

	//会员基本信息维护
	private MyJButton mjbZjHy=new MyJButton("image/zj0.png", "image/zj1.png","image/zj2.png");
	private MyJButton mjbXgHy=new MyJButton("image/xg0.png","image/xg1.png","image/xg2.png");
	private MyJButton mjbScHy=new MyJButton("image/sc0.png","image/sc1.png","image/sc2.png");
	private MyJButton mjbCzHy=new MyJButton("image/cz0.png","image/cz1.png","image/cz2.png");
	private MyJButton mjbZzHy=new MyJButton("image/zz0.png","image/zz1.png","image/zz2.png");
	private MyJButton mjbGmmHy=new MyJButton("image/gmm0.png","image/gmm1.png","image/gmm2.png");
	
	private MyJButton mjbCxHyxx=new MyJButton("查询");
	private MyJButton mjbGlHyxx=new MyJButton("过滤");
	private MyJButton mjbSrcxHyxx=new MyJButton("生日查询");
	private MyJButton mjbDyHyxx=new MyJButton("打印");
	
	private JTable jtHyxx = null;
	
	private JTextField jtfBhxm=new JTextField(6);
	
	//会员消费信息查询
	private JTable jtHyxf= null;
	
	private JPopupMenu jPopupMenu=new JPopupMenu();
	
	
	public HyglDialog(AppMainFrame frame, boolean model) {
		
		super(frame,model);
		super.setSize(748,561);
		super.setLocationRelativeTo(null);
		super.setTitle("会员管理");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		JPanel jp=new JPanel();
		jp.setPreferredSize(new Dimension(621,10));
		jp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp.setBackground(new Color(236,233,216));
		
		container.add(jp, BorderLayout.NORTH);
		
		addListener();
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public void addListener(){
		HyglDialogAction action = new HyglDialogAction(this);
		mjbZjHy.addActionListener(action);
		mjbXgHy.addActionListener(action);
		mjbScHy.addActionListener(action);
		mjbGmmHy.addActionListener(action);
		mjbCxHyxx.addActionListener(action);
		mjbGlHyxx.addActionListener(action);
		mjbSrcxHyxx.addActionListener(action);
		mjbDyHyxx.addActionListener(action);
		
	}
	
	public JPanel content(){
		
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(new Color(236,233,216));
		
		JTabbedPane jTabbedPane=new JTabbedPane();
		jTabbedPane.setBackground(new Color(251,249,231));
		jTabbedPane.setFont(new Font("宋体",Font.PLAIN,12));
		jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(155,172,156)));
		
		
		jTabbedPane.add("会员基本信息维护",contentOfHyjbxxwh());
		jTabbedPane.add("会员消费信息查询",contentOfHyxfxxcx());
		jTabbedPane.add("储值卡转账记录查询",contentOfCzkzzjlcx());
		jTabbedPane.add("储值卡充值记录",contentOfCzkczjl());
		
		
		jPanel.add(jTabbedPane, BorderLayout.CENTER);
		
		
		return jPanel;
	}
	
	
	public JPanel contentOfHyjbxxwh(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		jPanel.add(HyjbxxwhOfNorth());
		jPanel.add(HyjbxxwhOfCenter());
		
		
		return jPanel;
	}
	
	
	
	public JPanel HyjbxxwhOfNorth(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,8,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 8, 734, 37);
		
		
		//---------------------------------------------
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-5));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setPreferredSize(new Dimension(258, 39));
		
	
		
		jp1.add(mjbZjHy);
		jp1.add(mjbXgHy);
		jp1.add(mjbScHy);
		jp1.add(mjbCzHy);
		jp1.add(mjbZzHy);
		jp1.add(mjbGmmHy);
		
		//------------------------------------------------------------
		JLabel jlBhxm=new JLabel("编号/姓名:");
		jlBhxm.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		jtfBhxm.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//--------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,4,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		mjbCxHyxx.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(53, 20));
		mjbCxHyxx.setFont(new Font("宋体", Font.PLAIN, 12));
		mjbGlHyxx.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(53, 20));
		mjbGlHyxx.setFont(new Font("宋体", Font.PLAIN, 12));
		mjbSrcxHyxx.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(55, 20));
		mjbSrcxHyxx.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDcHyxx=new MyJButton("导出").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(53, 20));
		mjbDcHyxx.setFont(new Font("宋体", Font.PLAIN, 12));
		mjbDyHyxx.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(53, 20));
		mjbDyHyxx.setFont(new Font("宋体", Font.PLAIN, 12));
		
		//-----------------------------------------------------------------------------
		MgradeDao mgDao=new MgradeDao();
		try {
			ArrayList<MgradeVo> datas=mgDao.queryData();
			for(final MgradeVo vo:datas){
				JMenuItem jmiHydj=new JMenuItem(vo.getMgname());
				//加监听。。。。。。
				jmiHydj.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						MemberDao mDao=new MemberDao();
						try {
							Vector<Vector> rowdatas=mDao.queryDataByMgid(vo.getMgid());
							DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME));
							jtHyxx.setModel(dtm);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(getParent(), "数据库异常");
							e1.printStackTrace();
						}
					}
				});
				
				jPopupMenu.add(jmiHydj);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		
		jp2.add(mjbCxHyxx);
		jp2.add(mjbGlHyxx);
		jp2.add(mjbSrcxHyxx);
		jp2.add(mjbDcHyxx);
		jp2.add(mjbDyHyxx);
		
		//--------------------------------------------------------------
		
		
		jPanel.add(jp1);
		jPanel.add(jlBhxm);
		jPanel.add(jtfBhxm);
		jPanel.add(jp2);
		
		return jPanel;
	}
	
	
	public JPanel HyjbxxwhOfCenter(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 52, 724,435);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(724, 20));
		jpNorth.setBackground(new Color(181,198,141));
		jpNorth.add(new JLabel("会员信息"));
		
		MemberDao mDao = new MemberDao();
		Vector<Vector> data = null;
		try {
				 data = mDao.queryData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		jtHyxx=new JTable(data,ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME));
		jtHyxx.setAutoCreateRowSorter(true);
		jtHyxx.setFillsViewportHeight(true);
		if(jtHyxx.getRowCount()>0&&(jtHyxx!=null)){
			jtHyxx.addRowSelectionInterval(0, 0);
		}
		jtHyxx.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jtHyxx, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		
		return jPanel;
	}
	
	
	
	public JPanel contentOfHyxfxxcx(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jPanel.add(HyxfxxcxOfNorth());
		jPanel.add(HyxfxxcxOfCenter());
		
		return jPanel;
	}
	
	
	
	public JPanel HyxfxxcxOfNorth(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,8,5));
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBounds(5, 3, 736, 55);
		
		
		//---------------------------------------------
		GridLayout gl=new GridLayout(2,1);
		JPanel jp1=new JPanel(gl);
		jp1.setBackground(new Color(236,233,216));
		jp1.setPreferredSize(new Dimension(218,49));
		
		
		//************************************************
		
		JPanel jpText1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText1.setPreferredSize(new Dimension(90, 20));
		jpText1.setBackground(Color.WHITE);
		
		JTextField jtfQssjHyxf=new JTextField(6);
		jtfQssjHyxf.setBorder(null);
		
		JButton jbRlQssjHyxf=new JButton(new ImageIcon("image/rl.png"));
		
		jbRlQssjHyxf.setContentAreaFilled(false);
		jbRlQssjHyxf.setMargin(new Insets(0, 0, 0, 0));
		jbRlQssjHyxf.setBorderPainted(false);
		
		jpText1.add(jtfQssjHyxf);
		jpText1.add(jbRlQssjHyxf);
		
		//************************************************
		
		JPanel jpText2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText2.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText2.setPreferredSize(new Dimension(90, 20));
		jpText2.setBackground(Color.WHITE);
		
		JTextField jtfZzsjHyxf=new JTextField(6);
		jtfZzsjHyxf.setBorder(null);
		
		JButton jbRlZzsjHyxf=new JButton(new ImageIcon("image/rl.png"));
		jbRlZzsjHyxf.setContentAreaFilled(false);
		jbRlZzsjHyxf.setMargin(new Insets(0, 0, 0, 0));
		jbRlZzsjHyxf.setBorderPainted(false);
		
		jpText2.add(jtfZzsjHyxf);
		jpText2.add(jbRlZzsjHyxf);
		
		//************************************************

		JTextField jtfTimeQssjHyxf=new JTextField("00:00:01",5);
		jtfTimeQssjHyxf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTextField jtfTimeZzsjHyxf=new JTextField("23:59:59",5);
		jtfTimeZzsjHyxf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		
		
		JPanel jp11=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp11.setBackground(null);
		jp11.setOpaque(false);
		jp11.setPreferredSize(new Dimension(200, 24));
		
		jp11.add(new JLabel("起始时间："));
		jp11.add(jpText1);
		jp11.add(jtfTimeQssjHyxf);
		
		
		JPanel jp12=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp12.setBackground(null);
		jp12.setOpaque(false);
		jp12.setPreferredSize(new Dimension(200, 24));
		
		jp12.add(new JLabel("终止时间："));
		jp12.add(jpText2);
		jp12.add(jtfTimeZzsjHyxf);
		
		
		
		jp1.add(jp11);
		jp1.add(jp12);
		
		
		//------------------------------------------------------------
		JLabel jlBhxm=new JLabel("会员编号/姓名:");
		jlBhxm.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JTextField jtfHybhxmHyxf=new JTextField(6);
		jtfHybhxmHyxf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//--------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,4,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		MyJButton mjbGlHyxf=new MyJButton("过滤").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbGlHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbCxHyxf=new MyJButton("查询").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbCxHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbSxHyxf=new MyJButton("刷新").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbSxHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDcHyxf=new MyJButton("导出").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDcHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbLqbHyxf=new MyJButton("列清表").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbLqbHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDyHyxf=new MyJButton("打印").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDyHyxf.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		jp2.add(mjbGlHyxf);
		jp2.add(mjbCxHyxf);
		jp2.add(mjbSxHyxf);
		jp2.add(mjbDcHyxf);
		jp2.add(mjbLqbHyxf);
		jp2.add(mjbDyHyxf);
		
		//--------------------------------------------------------------
		
		
		jPanel.add(jp1);
		jPanel.add(jlBhxm);
		jPanel.add(jtfHybhxmHyxf);
		jPanel.add(jp2);
		
		return jPanel;
	}
	
	
	public JPanel HyxfxxcxOfCenter(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 60, 724,425);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(724, 20));
		jpNorth.setBackground(new Color(181,198,141));
		jpNorth.add(new JLabel("会员消费信息"));
		
		JTable jtHyxf=new JTable(null,ColumnContent.arrayToVector(ColumnContent.HUIYUANXIAOFEI_CLUMN_NAME));
		jtHyxf.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jtHyxf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		
		return jPanel;
	}
	
	
	
	
	
	public JPanel contentOfCzkzzjlcx(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jPanel.add(CzkzzjlcxOfNorth());
		jPanel.add(CzkzzjlcxOfCenter());
		
		return jPanel;
	}
	
	
	public JPanel CzkzzjlcxOfNorth(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		//jPanel.setBackground(Color.BLUE);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBounds(10, 3,690, 55);
		
		
		//---------------------------------------------
		GridLayout gl=new GridLayout(2,2);
		JPanel jp1=new JPanel(gl);
		//jp1.setBackground(Color.pink);
		jp1.setBackground(new Color(236,233,216));
		jp1.setPreferredSize(new Dimension(460,49));
		
		
		//************************************************
		
		JPanel jpText1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText1.setPreferredSize(new Dimension(90, 20));
		jpText1.setBackground(Color.WHITE);
		
		JTextField jtfQssjCzkzz=new JTextField(6);
		jtfQssjCzkzz.setBorder(null);
		
		JButton jbRlQssjCzkzz=new JButton(new ImageIcon("image/rl.png"));
		jbRlQssjCzkzz.setContentAreaFilled(false);
		jbRlQssjCzkzz.setMargin(new Insets(0, 0, 0, 0));
		jbRlQssjCzkzz.setBorderPainted(false);
		
		jpText1.add(jtfQssjCzkzz);
		jpText1.add(jbRlQssjCzkzz);
		
		//************************************************
		
		JPanel jpText2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText2.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText2.setPreferredSize(new Dimension(90, 20));
		jpText2.setBackground(Color.WHITE);
		
		JTextField jtfZzsjCzkzz=new JTextField(6);
		jtfZzsjCzkzz.setBorder(null);
		
		JButton jbRlZzsjCzkzz=new JButton(new ImageIcon("image/rl.png"));
		jbRlZzsjCzkzz.setContentAreaFilled(false);
		jbRlZzsjCzkzz.setMargin(new Insets(0, 0, 0, 0));
		jbRlZzsjCzkzz.setBorderPainted(false);
		
		jpText2.add(jtfZzsjCzkzz);
		jpText2.add(jbRlZzsjCzkzz);
		
		//************************************************

		JTextField jtfTimeQssjCzkzz=new JTextField("00:00:01",5);
		jtfTimeQssjCzkzz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTextField jtfTimeZzsjCzkzz=new JTextField("23:59:59",5);
		jtfTimeZzsjCzkzz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		
		
		JPanel jp11=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp11.setBackground(null);
		jp11.setOpaque(false);
		jp11.setPreferredSize(new Dimension(200, 24));
		
		jp11.add(new JLabel("起始时间："));
		jp11.add(jpText1);
		jp11.add(jtfTimeQssjCzkzz);
		
		
		JPanel jp13=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp13.setBackground(null);
		jp13.setOpaque(false);
		jp13.setPreferredSize(new Dimension(200, 24));
		
		jp13.add(new JLabel("终止时间："));
		jp13.add(jpText2);
		jp13.add(jtfTimeZzsjCzkzz);
		
		
		
		//------------------------------------------------------------
		JPanel jp14=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp14.setBackground(null);
		jp14.setOpaque(false);
		jp14.setPreferredSize(new Dimension(200, 24));
		
		
		JLabel jlBhxm=new JLabel("会员编号/姓名:");
		jlBhxm.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JTextField jtfHybhxmCzkzz=new JTextField(8);
		jtfHybhxmCzkzz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jp14.add(jlBhxm);
		jp14.add(jtfHybhxmCzkzz);
		
		
		//-------------------------------------------------------------
		
		JPanel jp12=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp12.setBackground(null);
		jp12.setOpaque(false);
		jp12.setPreferredSize(new Dimension(200, 24));
		
		
		JLabel jlZzlx=new JLabel("     转账类型:");
		jlZzlx.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JComboBox jcbZzlxCzkzz=new JComboBox();
		jcbZzlxCzkzz.setPreferredSize(new Dimension(89, 20));
		jcbZzlxCzkzz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jcbZzlxCzkzz.setBackground(Color.WHITE);
		
		jp12.add(jlZzlx);
		jp12.add(jcbZzlxCzkzz);
		
		
		//------------------------------------------------------------
		
		jp1.add(jp11);
		jp1.add(jp12);
		jp1.add(jp13);
		jp1.add(jp14);
		
		
		//--------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,4,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		MyJButton mjbCxCzkzz=new MyJButton("查询").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbCxCzkzz.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDcCzkzz=new MyJButton("导出").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDcCzkzz.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDyCzkzz=new MyJButton("打印").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDyCzkzz.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		jp2.add(mjbCxCzkzz);
		jp2.add(mjbDcCzkzz);
		jp2.add(mjbDyCzkzz);
		
		//--------------------------------------------------------------
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		
		return jPanel;
	}
	
	
	public JPanel CzkzzjlcxOfCenter(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 60, 724,425);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(724, 20));
		jpNorth.setBackground(new Color(181,198,141));
		jpNorth.add(new JLabel("储值卡转账记录"));
		
		JTable jtCzkzz=new JTable(null,ColumnContent.arrayToVector(ColumnContent.CHUZHIKAZHUANZHANG_CLUMN_NAME));
		JScrollPane jScrollPane=new JScrollPane(jtCzkzz, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		
		return jPanel;
	}
	
	
	
	
	
	public JPanel contentOfCzkczjl(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jPanel.add(CzkczjlOfNorth());
		jPanel.add(CzkczjlOfCenter());
		
		return jPanel;
	}
	
	
	public JPanel CzkczjlOfNorth(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,8,5));
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBounds(5, 3, 578, 55);
		
		
		//---------------------------------------------
		GridLayout gl=new GridLayout(2,1);
		JPanel jp1=new JPanel(gl);
		jp1.setBackground(new Color(236,233,216));
		jp1.setPreferredSize(new Dimension(218,49));
		
		
		//************************************************
		
		JPanel jpText1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText1.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText1.setPreferredSize(new Dimension(90, 20));
		jpText1.setBackground(Color.WHITE);
		
		JTextField jtfQssjCzkcz=new JTextField(6);
		jtfQssjCzkcz.setBorder(null);
		
		JButton jbRlQssjCzkcz=new JButton(new ImageIcon("image/rl.png"));
		jbRlQssjCzkcz.setContentAreaFilled(false);
		jbRlQssjCzkcz.setMargin(new Insets(0, 0, 0, 0));
		jbRlQssjCzkcz.setBorderPainted(false);
		
		jpText1.add(jtfQssjCzkcz);
		jpText1.add(jbRlQssjCzkcz);
		
		//************************************************
		
		JPanel jpText2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-2));
		jpText2.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpText2.setPreferredSize(new Dimension(90, 20));
		jpText2.setBackground(Color.WHITE);
		
		JTextField jtfZzsjCzkcz=new JTextField(6);
		jtfZzsjCzkcz.setBorder(null);
		
		JButton jbRlZzsjCzkcz=new JButton(new ImageIcon("image/rl.png"));
		jbRlZzsjCzkcz.setContentAreaFilled(false);
		jbRlZzsjCzkcz.setMargin(new Insets(0, 0, 0, 0));
		jbRlZzsjCzkcz.setBorderPainted(false);
		
		jpText2.add(jtfZzsjCzkcz);
		jpText2.add(jbRlZzsjCzkcz);
		
		//************************************************

		JTextField jtfTimeQssjCzkcz=new JTextField("00:00:01",5);
		jtfTimeQssjCzkcz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTextField jtfTimeZzsjCzkcz=new JTextField("23:59:59",5);
		jtfTimeZzsjCzkcz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		
		
		JPanel jp11=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp11.setBackground(null);
		jp11.setOpaque(false);
		jp11.setPreferredSize(new Dimension(200, 24));
		
		jp11.add(new JLabel("起始时间："));
		jp11.add(jpText1);
		jp11.add(jtfTimeQssjCzkcz);
		
		
		JPanel jp12=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp12.setBackground(null);
		jp12.setOpaque(false);
		jp12.setPreferredSize(new Dimension(200, 24));
		
		jp12.add(new JLabel("终止时间："));
		jp12.add(jpText2);
		jp12.add(jtfTimeZzsjCzkcz);
		
		
		
		jp1.add(jp11);
		jp1.add(jp12);
		
		
		//------------------------------------------------------------
		JLabel jlBhxm=new JLabel("会员编号/姓名:");
		jlBhxm.setFont(new Font("宋体", Font.PLAIN, 12));
		
		JTextField jtfHybhxmCzkcz=new JTextField(6);
		jtfHybhxmCzkcz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		//--------------------------------------------------------------
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,4,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		MyJButton mjbCxCzkcz=new MyJButton("查询").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbCxCzkcz.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDcCzkcz=new MyJButton("导出").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDcCzkcz.setFont(new Font("宋体", Font.PLAIN, 12));
		MyJButton mjbDyCzkcz=new MyJButton("打印").set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(49, 20));
		mjbDyCzkcz.setFont(new Font("宋体", Font.PLAIN, 12));
		
		
		jp2.add(mjbCxCzkcz);
		jp2.add(mjbDcCzkcz);
		jp2.add(mjbDyCzkcz);
		
		//--------------------------------------------------------------
		
		
		jPanel.add(jp1);
		jPanel.add(jlBhxm);
		jPanel.add(jtfHybhxmCzkcz);
		jPanel.add(jp2);
		
		return jPanel;
	}
	
	
	public JPanel CzkczjlOfCenter(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5, 60, 724,425);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(724, 20));
		jpNorth.setBackground(new Color(181,198,141));
		jpNorth.add(new JLabel("储值卡充值记录"));
		
		JTable jtCzkcz=new JTable(null,ColumnContent.arrayToVector(ColumnContent.CHUZHIKACHONGZHI_CLUMN_NAME));
		JScrollPane jScrollPane=new JScrollPane(jtCzkcz, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		
		return jPanel;
	}
	
	
	public static void main(String[] args) {
		
	//	new HyglDialog();

	}
	public MyJButton getMjbZjHy() {
		return mjbZjHy;
	}
	public MyJButton getMjbXgHy() {
		return mjbXgHy;
	}
	public MyJButton getMjbScHy() {
		return mjbScHy;
	}
	public MyJButton getMjbCzHy() {
		return mjbCzHy;
	}
	public MyJButton getMjbZzHy() {
		return mjbZzHy;
	}
	public MyJButton getMjbGmmHy() {
		return mjbGmmHy;
	}
	public MyJButton getMjbCxHyxx() {
		return mjbCxHyxx;
	}
	public MyJButton getMjbGlHyxx() {
		return mjbGlHyxx;
	}
	public MyJButton getMjbSrcxHyxx() {
		return mjbSrcxHyxx;
	}
	public JTable getJtHyxx() {
		return jtHyxx;
	}
	public JTextField getJtfBhxm() {
		return jtfBhxm;
	}

	public JTable getJtHyxf() {
		return jtHyxf;
	}

	public JPopupMenu getjPopupMenu() {
		return jPopupMenu;
	}


	public MyJButton getMjbDyHyxx() {
		return mjbDyHyxx;
	}
	
	
}

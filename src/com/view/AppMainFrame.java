package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JToolTip;

import oracle.core.lmx.CoreException;

import com.action.AppMainFrameAction;
import com.action.MjbFjMouseListener;
import com.action.AppMainFramePopupMemuAction;
import com.action.ZjxfDialogAction;
import com.dao.BaojianDao;
import com.thread.Timer;
import com.util.ColumnContent;
import com.view.util.MyJButton;
import com.view.util.MyJPanel;
import com.vo.BaojianVo;

/**
 *
 * AppMainFrame.java: 主界面
 * @author czp
 * @time 2013-7-11 上午1:43:27
 * 
 */
public class AppMainFrame extends JFrame{

	
	private static final long serialVersionUID = -4656989701841585539L;
	
	
	private JLabel jlTime=new JLabel("------------");
	//mjbGkkd 按钮：顾客开单
	private	MyJButton mjbGkkd=new MyJButton("image//gkkd0.png","image//gkkd1.png","image//gkkd2.png");
	//mjbYdgl 按钮：预定管理
	private	MyJButton mjbYdgl=new MyJButton("image//ydgl0.png","image//ydgl1.png","image//ydgl2.png");
	//mjbBkjz 按钮：宾客结账
	private	MyJButton mjbBkjz=new MyJButton("image//bkjz0.png","image//bkjz1.png","image//bkjz2.png");
	//mjbZjxf 按钮：增加消费
	private	MyJButton mjbZjxf=new MyJButton("image//zjxf0.png","image//zjxf1.png","image//zjxf2.png");
	//mjbHygl 按钮：会员管理
	private	MyJButton mjbHygl=new MyJButton("image//hygl0.png","image//hygl1.png","image//hygl2.png");
	//mjbFwsgl 按钮：服务生管理
	private	MyJButton mjbFwsgl=new MyJButton("image//fwsgl0.png","image//fwsgl1.png","image//fwsgl2.png");
	//mjbYycx 按钮：营业查询
	private	MyJButton mjbYycx=new MyJButton("image//yycx0.png","image//yycx1.png","image//yycx2.png");
	//mjbSpgl 按钮：商品管理
	private	MyJButton mjbSpgl=new MyJButton("image//spgl0.png","image//spgl1.png","image//spgl2.png");
	//mjbCwgl 按钮：财务管理
	private	MyJButton mjbCwgl=new MyJButton("image//cwgl0.png","image//cwgl1.png","image//cwgl2.png");
	//mjbHbdr 按钮：换班登入
	private	MyJButton mjbHbdr=new MyJButton("image//hbdr0.png","image//hbdr1.png","image//hbdr2.png");
	//mjbXtsz 按钮：系统设置
	private	MyJButton mjbXtsz=new MyJButton("image//xtsz0.png","image//xtsz1.png","image//xtsz2.png");
	//mjbTcxt 按钮：退出系统
	private	MyJButton mjbTcxt=new MyJButton("image//tcxt0.png","image//tcxt1.png","image//tcxt2.png");

	
	private MyJButton mjbTime=new MyJButton("image//time0.png","image//time1.png","image//time2.png");
	private MyJButton mjbJsq=new MyJButton("image//jsq0.png","image//jsq1.png","image//jsq2.png");
	private MyJButton mjbClear=new MyJButton("image//clear0.png","image/clear1.png","image//clear2.png");
	private JTextArea jta=new JTextArea();
	
	
	private JPanel jpXxbj=new JPanel(new FlowLayout(FlowLayout.LEFT,10,15));
	private JPanel jpZxbj=new JPanel(new FlowLayout(FlowLayout.LEFT,10,15));
	private JPanel jpDxbj=new JPanel(new FlowLayout(FlowLayout.LEFT,10,15));
	private JPanel jpHhbj=new JPanel(new FlowLayout(FlowLayout.LEFT,10,15));
	
	
	private JLabel jlZdxf=new JLabel("");
	private JLabel jlJfbz=new JLabel("");
	private JLabel jlJdsj=new JLabel("");
	private JLabel jlYysj=new JLabel("");
	private JLabel jlYjyj=new JLabel("");
	private JLabel jlXfje=new JLabel("");
	
	private JLabel jlBjzs=new JLabel("0");
	private JLabel jlDqzy=new JLabel("0");
	private JLabel jlDqkg=new JLabel("0");
	private JLabel jlDqyd=new JLabel("0");
	private JLabel jlDqty=new JLabel("0");
	private JLabel jlBjid=new JLabel("", new ImageIcon("image//bj.png"), JLabel.LEFT);
	private JTable jtXf;
	
	//mjbXsqb 按钮：显示全部
	private MyJButton mjbXsqb=new MyJButton("image//xsqb0.png","image//xsqb1.png","image//xsqb2.png");
	//mjbGlzt 按钮：过滤状态
	private MyJButton mjbGlzt=new MyJButton("image//glzt0.png","image//glzt1.png","image//glzt2.png");
	//mjbCkfs 按钮：查看方式
	private MyJButton mjbCkfs=new MyJButton("image//ckfs0.png","image//ckfs1.png","image//ckfs2.png");
	//mjbSxxs 按钮：刷新显示
	private MyJButton mjbSxxs=new MyJButton("image//sxxs0.png","image//sxxs1.png","image//sxxs2.png");
	
	private JTabbedPane jTabbedPane=new JTabbedPane();
	private JPopupMenu jpmGlzt=new JPopupMenu();
	private JPopupMenu jpmCkfs=new JPopupMenu();
	private JMenuItem jmiXskg=new JMenuItem("显示可供");
	private JMenuItem jmiXszy=new JMenuItem("显示占用");
	private JMenuItem jmiXsty=new JMenuItem("显示停用");
	private JMenuItem jmiDtb=new JMenuItem("大图标");
	private JMenuItem jmiZtb=new JMenuItem("中图标");
	private JMenuItem jmiXtb=new JMenuItem("小图标");
	private JMenuItem jmiLb=new JMenuItem("列表");
	
	private JPopupMenu jpmYkjj=new JPopupMenu();
	private JMenuItem jmiBkjz=new JMenuItem("宾客结账");
	private JMenuItem jmiZjxf=new JMenuItem("增加消费");
	private JMenuItem jmiDhsp=new JMenuItem("兑换商品");
	private JMenuItem jmiGkkd=new JMenuItem("顾客开单");
	private JMenuItem jmiXgdj=new JMenuItem("修改登记");
	private JMenuItem jmiGhbj=new JMenuItem("更换包间");
	private JMenuItem jmiBjzt=new JMenuItem("包间状态");
	private JMenuItem jmiBkyd=new JMenuItem("宾客预定");
	
	
	
	public AppMainFrame(){
		super.setSize(865,620);
		super.setTitle("KTV娱乐行业管理系统1.0");
        super.setLocationRelativeTo(null);
		
		Container container=super.getContentPane();
		container.add(addToolBar(),BorderLayout.NORTH);
		final JSplitPane jSplitPane=westJsSplitPane();
		container.add(jSplitPane,BorderLayout.CENTER);
		
		addMenuBar();
		
		addListener();
		
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//实现分隔条的按比例变化。。。setDividerLocation()必须写在setVisible()的后面，否则setDividerLocation(0.*)无效
		jSplitPane.setDividerLocation(0.13);
		//监听窗体，当窗体变化时，分隔条随着变化。
		this.addComponentListener(new ComponentAdapter(){ 
            public void componentResized(ComponentEvent e) { 
            	jSplitPane.setDividerLocation(0.13);
            } 
        }); 
		
		new Timer(this).start();
		
	}
	
	
	public void addListener(){
		AppMainFrameAction action=new AppMainFrameAction(this);
		mjbGkkd.addActionListener(action);
		mjbYdgl.addActionListener(action);
		mjbBkjz.addActionListener(action);
		mjbZjxf.addActionListener(action);
		mjbHygl.addActionListener(action);
		mjbFwsgl.addActionListener(action);
		mjbYycx.addActionListener(action);
		mjbSpgl.addActionListener(action);
		mjbCwgl.addActionListener(action);
		mjbHbdr.addActionListener(action);
		mjbXtsz.addActionListener(action);
		mjbTcxt.addActionListener(action);
		mjbJsq.addActionListener(action);
		mjbClear.addActionListener(action);
		mjbTime.addActionListener(action);
		mjbCkfs.addActionListener(action);
		mjbGlzt.addActionListener(action);
		mjbXsqb.addActionListener(action);
		mjbSxxs.addActionListener(action);
		
		//---------------------------------
		AppMainFramePopupMemuAction pmAction=new AppMainFramePopupMemuAction(this);
		jmiXskg.addActionListener(pmAction);
		jmiXszy.addActionListener(pmAction);
		jmiXsty.addActionListener(pmAction);
		jmiDtb.addActionListener(pmAction);
		jmiZtb.addActionListener(pmAction);
		jmiXtb.addActionListener(pmAction);
		jmiLb.addActionListener(pmAction);
		
		jmiBkjz.addActionListener(pmAction);
		jmiZjxf.addActionListener(pmAction);
		jmiDhsp.addActionListener(pmAction);
		jmiGkkd.addActionListener(pmAction);
		jmiXgdj.addActionListener(pmAction);
		jmiGhbj.addActionListener(pmAction);
		jmiBjzt.addActionListener(pmAction);
		jmiBkyd.addActionListener(pmAction);
		
	}
	
	
	public void addMenuBar(){
		JMenuBar jMenuBar = new JMenuBar();
		//MyJPanel menuPanel=new MyJPanel(new FlowLayout(FlowLayout.LEFT,5,0), "image/jptp2.png", MyJPanel.TILED);
		//jMenuBar.add(menuPanel);
		jMenuBar.setBackground(new Color(236,233,216));
		
		JMenu jmLbdj=new JMenu("来宾登记");
			JMenuItem jmiGkkd=new JMenuItem("顾客开单");
			JMenuItem jmiBtxs=new JMenuItem("吧台销售");
			JMenuItem jmiGhbj=new JMenuItem("更换包间");
			JMenuItem jmiXgdj=new JMenuItem("修改登记");
			JMenuItem jmiBjzt=new JMenuItem("包间状态");
			JMenuItem jmiYdgl=new JMenuItem("预订管理");
			JMenuItem jmiDztx=new JMenuItem("电子提醒");
			JMenuItem jmiTcxt=new JMenuItem("退出系统");
		jmLbdj.add(jmiGkkd);
		jmLbdj.add(jmiBtxs);
		jmLbdj.add(jmiGhbj);
		jmLbdj.add(jmiXgdj);
		jmLbdj.add(jmiBjzt);
		jmLbdj.add(jmiYdgl);
		jmLbdj.add(jmiDztx);
		jmLbdj.add(jmiTcxt);
		//给菜单加分隔条，如下：
		jmLbdj.insertSeparator(5);
		jmLbdj.insertSeparator(8);
		
		JMenu jmSyjs=new JMenu("收银结算");
			JMenuItem jmiBkjz=new JMenuItem("宾客结账");
			JMenuItem jmiHbzd=new JMenuItem("合并账单");
			JMenuItem jmiCfzd=new JMenuItem("拆分账单");
			JMenuItem jmiYgzdjz=new JMenuItem("已挂账单结账");
			//菜单下又嵌套菜单
			JMenu jmBkxfmx=new JMenu("宾客消费明细");
				JMenuItem jmiBkxfmxcx=new JMenuItem("宾客消费明细查询");
				JMenuItem jmiXftdmxcx=new JMenuItem("消费退单明细查询");
				
			jmBkxfmx.add(jmiBkxfmxcx);
			jmBkxfmx.add(jmiXftdmxcx);
			JMenuItem jmiDjqgl=new JMenuItem("代金券管理");
		jmSyjs.add(jmiBkjz);	
		jmSyjs.add(jmiHbzd);	
		jmSyjs.add(jmiCfzd);	
		jmSyjs.add(jmiYgzdjz);	
		jmSyjs.add(jmBkxfmx);	
		jmSyjs.add(jmiDjqgl);
		jmSyjs.insertSeparator(3);
		
		JMenu jmXtwh=new JMenu("系统维护");
			JMenuItem jmiXgdqczymm=new JMenuItem("修改当前操作员密码");
			JMenuItem jmiXtsz=new JMenuItem("系统设置");
			JMenuItem jmiJxssz=new JMenuItem("经销商设置");
		jmXtwh.add(jmiXgdqczymm);
		jmXtwh.add(jmiXtsz);
		jmXtwh.add(jmiJxssz);
		jmXtwh.insertSeparator(2);
		
		
		jMenuBar.add(jmLbdj);
		jMenuBar.add(jmSyjs);
		jMenuBar.add(jmXtwh);
		
		/*menuPanel.add(jmLbdj);
		menuPanel.add(jmSyjs);
		menuPanel.add(jmXtwh);*/
		
		super.setJMenuBar(jMenuBar);
		
	}
	
	
	public JToolBar addToolBar(){
		JToolBar jToolBar=new JToolBar();
		jToolBar.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jToolBar.setFloatable(false);
		
		JPanel toolPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-2));
		toolPanel.setBackground(new Color(239,233,218));
		
		
		
		toolPanel.add(mjbGkkd);
		toolPanel.add(mjbYdgl);
		toolPanel.add(mjbBkjz);
		toolPanel.add(mjbZjxf);
		toolPanel.add(mjbHygl);
		toolPanel.add(mjbFwsgl);
		toolPanel.add(mjbYycx);
		toolPanel.add(mjbSpgl);
		toolPanel.add(mjbCwgl);
		toolPanel.add(mjbHbdr);
		toolPanel.add(mjbXtsz);
		toolPanel.add(mjbTcxt);
		
		jToolBar.add(toolPanel);
		
		return jToolBar;
		
	}
	
	
	public JPanel centerContent(){
		
	
		jTabbedPane.setBackground(new Color(165,239,99));
		jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jp=new JPanel(new BorderLayout());
		jp.setBackground(new Color(230,230,210));
		jp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp.add(jTabbedPane, BorderLayout.CENTER);
		jp.add(centerContentOfSouth(),BorderLayout.SOUTH);
		
		
		
		
		jpXxbj.setPreferredSize(new Dimension(1148, 411));
		JScrollPane jScrollPaneXxbj=new JScrollPane(jpXxbj, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jTabbedPane.add("小型包间", jScrollPaneXxbj);
		jpXxbj.setBackground(Color.WHITE);
		
		
		jpZxbj.setPreferredSize(new Dimension(1148, 411));
		JScrollPane jScrollPaneZxbj=new JScrollPane(jpZxbj, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jTabbedPane.add("中型包间", jScrollPaneZxbj);
		jpZxbj.setBackground(Color.WHITE);
		
		
		jpDxbj.setPreferredSize(new Dimension(1148, 411));
		JScrollPane jScrollPaneDxbj=new JScrollPane(jpDxbj, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jTabbedPane.add("大型包间", jScrollPaneDxbj);
		jpDxbj.setBackground(Color.WHITE);
		
		
		jpHhbj.setPreferredSize(new Dimension(1148, 411));
		JScrollPane jScrollPaneHhbj=new JScrollPane(jpHhbj, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jTabbedPane.add("豪华包间", jScrollPaneHhbj);
		jpHhbj.setBackground(Color.WHITE);
		
		
		BaojianDao bjDao=new BaojianDao();
		try {
			ArrayList<BaojianVo> bjDataList=bjDao.getAllBaojian();
			
			//房间编号的排序处理。。。。。。
			Collections.sort(bjDataList);
			
			for(BaojianVo vo:bjDataList){
				
				String bjlxName=vo.getBaoJianType().getBjtname();
				String bjName=vo.getBjid();
				int state=vo.getState();
				String image="image/";
				
				if(state==1){
					image+="house0.png";
				}else if(state==2){
					image+="house1.png";
				}else if(state==3){
					image+="house2.png";
				}else if(state==4){
					image+="house3.png";
				}
				
				//动态创建房间......
				MyJButton mjbFj=new MyJButton(bjName, image);
				mjbFj.set_Margin(new Insets(0, 0, 0, 0)).set_BorderPainted(false).set_Opaque(false).set_Border(null).set_ContentAreaFilled(false);
				//为房间设置鼠标监听。。。。。。
				mjbFj.addMouseListener(new MjbFjMouseListener(mjbFj,vo,this));
				
				if(bjlxName.equals("小型包间")){
					jpXxbj.add(mjbFj);
				}else if(bjlxName.equals("中型包间")){
					jpZxbj.add(mjbFj);
				}else if(bjlxName.equals("大型包间")){
					jpDxbj.add(mjbFj);
				}else if(bjlxName.equals("豪华包间")){
					jpHhbj.add(mjbFj);
				}
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		return jp;
		
	}
	
	
	
	
	
	
	
	
	
	public JPanel centerContentOfSouth(){
		//JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT,10,-2));
		MyJPanel jp=new MyJPanel(new FlowLayout(FlowLayout.LEFT,10,-2), "image/jptp1.png", MyJPanel.TILED);
		jp.setPreferredSize(new Dimension(1176, 27));
		//jp.setBackground(new Color(191,206,155));
		jp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		
		jpmGlzt.add(jmiXskg);
		jpmGlzt.add(jmiXszy);
		jpmGlzt.add(jmiXsty);
		
		
		jpmCkfs.add(jmiDtb);
		jpmCkfs.add(jmiZtb);
		jpmCkfs.add(jmiXtb);
		jpmCkfs.add(jmiLb);
		
		
		//------右快捷键----------------------
		jpmYkjj.add(jmiBkjz);
		jpmYkjj.add(jmiZjxf);
		jpmYkjj.add(jmiDhsp);
		jpmYkjj.add(jmiGkkd);
		jpmYkjj.add(jmiXgdj);
		jpmYkjj.add(jmiGhbj);
		jpmYkjj.add(jmiBjzt);
		jpmYkjj.add(jmiBkyd);
		
		
		
		jp.add(mjbXsqb);
		jp.add(mjbGlzt);
		jp.add(mjbCkfs);
		jp.add(mjbSxxs);
		
		return jp;
	}
	
	
	public JPanel westContent(){
		JPanel jp=new JPanel(new BorderLayout());
		
		JPanel jpTime=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jpTime.setPreferredSize(new Dimension(170, 20));
		jpTime.setBackground(new Color(181,198,141));
		jlTime.setForeground(Color.WHITE);
		jpTime.add(jlTime);
		
		
		jp.add(jpTime, BorderLayout.NORTH);
		jp.add(westContentOfCenter(),BorderLayout.CENTER);
		jp.add(westContentOfSouth(),BorderLayout.SOUTH);
		
		return jp;
	}
	
	
	public JPanel westContentOfCenter(){
		JPanel jp=new JPanel(new BorderLayout());
		jp.setBackground(new Color(236,233,216));
		
		JTabbedPane jTabbedPane=new JTabbedPane();
		jTabbedPane.setBackground(new Color(188,234,114));
		jp.add(jTabbedPane, BorderLayout.CENTER);
		
		JPanel jpState=new JPanel(new BorderLayout());
		jpState.setBackground(new Color(226,236,201));
		jpState.add(jpStateOfCenter(), BorderLayout.CENTER);
		jpState.add(jpStateOfSouth(), BorderLayout.SOUTH);
		
		JPanel jpRemarks=new JPanel(new BorderLayout());
		jpRemarks.add(jpRemarksContent(), BorderLayout.CENTER);

		jTabbedPane.add("状态", jpState);
		jTabbedPane.add("便签",jpRemarks);
		
		return jp;
		
	}

	
	public JPanel westContentOfSouth(){
		JPanel jp=new JPanel(new BorderLayout());
		
		//JPanel jpKstd=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		MyJPanel jpKstd=new MyJPanel(new FlowLayout(FlowLayout.LEFT,5,0), "image/jptp.png", MyJPanel.TILED);
		jpKstd.setPreferredSize(new Dimension(170, 24));
		//jpKstd.setBackground(new Color(200,215,162));
		JLabel jlXstd=new JLabel("  [F3]  快速通道(Q)", new ImageIcon("image//bj.png"), JLabel.LEFT);
		jpKstd.add(jlXstd);
		
		JTextField jtKstd=new JTextField();
		jtKstd.setPreferredSize(new Dimension(170, 24));
		
		JLabel jlTuPian=new JLabel(new ImageIcon("image//kstd.png"));
		
		jp.add(jpKstd,BorderLayout.NORTH);
		jp.add(jtKstd,BorderLayout.CENTER);
		jp.add(jlTuPian,BorderLayout.SOUTH);
		
		return jp;
	}
	
	
	public JPanel jpStateOfCenter(){
		JPanel jp=new JPanel(new BorderLayout());
		
		//JPanel jpBjid=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		MyJPanel jpBjid=new MyJPanel(new FlowLayout(FlowLayout.LEFT,5,0), "image/jptp.png", MyJPanel.TILED);
		jpBjid.setPreferredSize(new Dimension(170, 24));
		//jpBjid.setBackground(new Color(200,215,162));
		jpBjid.setBorder(BorderFactory.createLineBorder(new Color(108,172,78)));
		jpBjid.add(jlBjid);
		
		
		JPanel jpBjxx=new JPanel(new GridLayout(9,1));
		jpBjxx.setBackground(new Color(226,236,201));
		
		JPanel jp0=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp0.setBackground(new Color(226,236,201));
		jp0.add(new JLabel());
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp1.setBackground(new Color(226,236,201));
		jp1.add(new JLabel("    最低消费:  "));
		jlZdxf.setForeground(Color.BLUE);
		jp1.add(jlZdxf);
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp2.setBackground(new Color(226,236,201));
		jp2.add(new JLabel("    计费标准:  "));
		jlJfbz.setForeground(Color.BLUE);
		jp2.add(jlJfbz);
		
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp3.setBackground(new Color(226,236,201));
		jp3.add(new JLabel("    进店时间:  "));
		jlJdsj.setForeground(Color.BLUE);
		jp3.add(jlJdsj);
		
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp4.setBackground(new Color(226,236,201));
		jp4.add(new JLabel("    已用时间:  "));
		jlYysj.setForeground(Color.BLUE);
		jp4.add(jlYysj);
		
		JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp5.setBackground(new Color(226,236,201));
		jp5.add(new JLabel("    已交押金:  "));
		jlYjyj.setForeground(Color.BLUE);
		jp5.add(jlYjyj);
		
		JPanel jp6=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp6.setBackground(new Color(226,236,201));
		jp6.add(new JLabel("    消费金额:  "));
		jlXfje.setForeground(Color.BLUE);
		jp6.add(jlXfje);
		
		
		jpBjxx.add(jp0);
		jpBjxx.add(jp1);
		jpBjxx.add(jp2);
		jpBjxx.add(jp3);
		jpBjxx.add(jp4);
		jpBjxx.add(jp5);
		jpBjxx.add(jp6);
		
		
		jp.add(jpBjid, BorderLayout.NORTH);
		jp.add(jpBjxx,BorderLayout.CENTER);
		
		return jp;
	}
	
	
	public JPanel jpStateOfSouth(){
		JPanel jp=new JPanel(new BorderLayout());
		
		//JPanel jpBjzzt=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		MyJPanel jpBjzzt=new MyJPanel(new FlowLayout(FlowLayout.LEFT,5,0), "image/jptp.png", MyJPanel.TILED);
		jpBjzzt.setPreferredSize(new Dimension(170, 24));
		//jpBjzzt.setBackground(new Color(200,215,162));
		jpBjzzt.setBorder(BorderFactory.createLineBorder(new Color(108,172,78)));
		JLabel jlBjzzt=new JLabel("  包间总状态", new ImageIcon("image//bj.png"), JLabel.LEFT);
		jpBjzzt.add(jlBjzzt);
		
		
		JPanel jpBjztnr=new JPanel(new GridLayout(6,1));
		jpBjztnr.setBackground(new Color(226,236,201));
		
		JPanel jp0=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp0.setBackground(new Color(226,236,201));
		jp0.add(new JLabel());
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp1.setBackground(new Color(226,236,201));
		jp1.add(new JLabel("    包间总数:  "));
		jlBjzs.setForeground(Color.BLUE);
		jp1.add(jlBjzs);
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp2.setBackground(new Color(226,236,201));
		jp2.add(new JLabel("    当前占用:  "));
		jlDqzy.setForeground(Color.BLUE);
		jp2.add(jlDqzy);
		
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp3.setBackground(new Color(226,236,201));
		jp3.add(new JLabel("    当前可供:  "));
		jlDqkg.setForeground(Color.BLUE);
		jp3.add(jlDqkg);
		
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp4.setBackground(new Color(226,236,201));
		jp4.add(new JLabel("    当前预定:  "));
		jlDqyd.setForeground(Color.BLUE);
		jp4.add(jlDqyd);
		
		JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jp5.setBackground(new Color(226,236,201));
		jp5.add(new JLabel("    当前停用:  "));
		jlDqty.setForeground(Color.BLUE);
		jp5.add(jlDqty);
		
		
		jpBjztnr.add(jp0);
		jpBjztnr.add(jp1);
		jpBjztnr.add(jp2);
		jpBjztnr.add(jp3);
		jpBjztnr.add(jp4);
		jpBjztnr.add(jp5);
		
		
		jp.add(jpBjzzt, BorderLayout.NORTH);
		jp.add(jpBjztnr,BorderLayout.CENTER);
		
		return jp;
	}
	
	
	public JPanel jpRemarksContent(){
		JPanel jp=new JPanel(new BorderLayout());
		
		JPanel jpTuBiao=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-3));
		jpTuBiao.setBackground(new Color(236,233,216));
		jpTuBiao.setPreferredSize(new Dimension(170,40));
		jpTuBiao.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		mjbTime.setToolTipText("加入当前时间");
		mjbJsq.setToolTipText("计算器");
		mjbClear.setToolTipText("清空便签");
		
		
		jpTuBiao.add(mjbTime);
		jpTuBiao.add(mjbJsq);
		jpTuBiao.add(mjbClear);
		
		jta.setLineWrap(true);
		jta.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jp.add(jpTuBiao, BorderLayout.NORTH);
		jp.add(jta,BorderLayout.CENTER);
		return jp;
	}
	
	
	public JSplitPane westJsSplitPane(){
		JSplitPane jSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, westContent(), southJSplitPane());
		
		jSplitPane.setOneTouchExpandable(true);
		jSplitPane.setDividerSize(10);
		jSplitPane.setDividerLocation(0.13);
		
		return jSplitPane;
	}

	
	public JScrollPane jSplitPaneOfBottom(){
		
		jtXf=new JTable(null, ColumnContent.arrayToVector(ColumnContent.XIAOFEI_CLUMN_NAME));
		jtXf.getColumnModel().getColumn(5).setPreferredWidth(150);
		jtXf.getColumnModel().getColumn(6).setPreferredWidth(133);
		jtXf.getColumnModel().getColumn(7).setPreferredWidth(208);
		jtXf.getColumnModel().getColumn(8).setPreferredWidth(308);
		jtXf.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtXf.setFillsViewportHeight(true);
		jtXf.setAutoCreateRowSorter(true);
		
		
		
		JScrollPane jScrollPane = new JScrollPane(jtXf,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		return jScrollPane;
	}
	
	
	public JSplitPane southJSplitPane(){
		final JSplitPane jSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT, centerContent(), jSplitPaneOfBottom());
		
		jSplitPane.setOneTouchExpandable(true);
		jSplitPane.setDividerSize(10);
		jSplitPane.setDividerLocation(480);
		
		this.addComponentListener(new ComponentAdapter(){ 
            public void componentResized(ComponentEvent e) { 
            	jSplitPane.setDividerLocation(480);
            } 
        }); 
		
		return jSplitPane;
	}

	
	
	

	public JLabel getJlTime() {
		return jlTime;
	}


	public MyJButton getMjbGkkd() {
		return mjbGkkd;
	}


	public MyJButton getMjbYdgl() {
		return mjbYdgl;
	}


	public MyJButton getMjbBkjz() {
		return mjbBkjz;
	}


	public MyJButton getMjbZjxf() {
		return mjbZjxf;
	}


	public MyJButton getMjbHygl() {
		return mjbHygl;
	}


	public MyJButton getMjbFwsgl() {
		return mjbFwsgl;
	}


	public MyJButton getMjbYycx() {
		return mjbYycx;
	}


	public MyJButton getMjbSpgl() {
		return mjbSpgl;
	}


	public MyJButton getMjbCwgl() {
		return mjbCwgl;
	}


	public MyJButton getMjbHbdr() {
		return mjbHbdr;
	}


	public MyJButton getMjbXtsz() {
		return mjbXtsz;
	}


	public MyJButton getMjbTcxt() {
		return mjbTcxt;
	}


	public JPanel getJpXxbj() {
		return jpXxbj;
	}


	public JPanel getJpZxbj() {
		return jpZxbj;
	}


	public JPanel getJpDxbj() {
		return jpDxbj;
	}


	public JPanel getJpHhbj() {
		return jpHhbj;
	}


	public MyJButton getMjbTime() {
		return mjbTime;
	}


	public MyJButton getMjbJsq() {
		return mjbJsq;
	}


	public MyJButton getMjbClear() {
		return mjbClear;
	}


	public JTextArea getJta() {
		return jta;
	}


	public JLabel getJlZdxf() {
		return jlZdxf;
	}


	public JLabel getJlJfbz() {
		return jlJfbz;
	}


	public JLabel getJlJdsj() {
		return jlJdsj;
	}


	public JLabel getJlYysj() {
		return jlYysj;
	}


	public JLabel getJlYjyj() {
		return jlYjyj;
	}


	public JLabel getJlXfje() {
		return jlXfje;
	}


	public JLabel getJlBjzs() {
		return jlBjzs;
	}


	public JLabel getJlDqzy() {
		return jlDqzy;
	}


	public JLabel getJlDqkg() {
		return jlDqkg;
	}


	public JLabel getJlDqyd() {
		return jlDqyd;
	}


	public JLabel getJlDqty() {
		return jlDqty;
	}


	public JTable getJtXf() {
		return jtXf;
	}


	public JLabel getJlBjid() {
		return jlBjid;
	}


	public MyJButton getMjbXsqb() {
		return mjbXsqb;
	}


	public MyJButton getMjbGlzt() {
		return mjbGlzt;
	}


	public MyJButton getMjbCkfs() {
		return mjbCkfs;
	}


	public MyJButton getMjbSxxs() {
		return mjbSxxs;
	}


	public JPopupMenu getJpmGlzt() {
		return jpmGlzt;
	}


	public JPopupMenu getJpmCkfs() {
		return jpmCkfs;
	}


	public JMenuItem getJmiXskg() {
		return jmiXskg;
	}


	public JMenuItem getJmiXszy() {
		return jmiXszy;
	}


	public JMenuItem getJmiXsty() {
		return jmiXsty;
	}


	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}


	public JMenuItem getJmiDtb() {
		return jmiDtb;
	}


	public JMenuItem getJmiZtb() {
		return jmiZtb;
	}


	public JMenuItem getJmiXtb() {
		return jmiXtb;
	}


	public JMenuItem getJmiLb() {
		return jmiLb;
	}


	public JPopupMenu getJpmYkjj() {
		return jpmYkjj;
	}


	public JMenuItem getJmiBkjz() {
		return jmiBkjz;
	}


	public JMenuItem getJmiZjxf() {
		return jmiZjxf;
	}


	public JMenuItem getJmiDhsp() {
		return jmiDhsp;
	}


	public JMenuItem getJmiGkkd() {
		return jmiGkkd;
	}


	public JMenuItem getJmiXgdj() {
		return jmiXgdj;
	}


	public JMenuItem getJmiGhbj() {
		return jmiGhbj;
	}


	public JMenuItem getJmiBjzt() {
		return jmiBjzt;
	}


	public JMenuItem getJmiBkyd() {
		return jmiBkyd;
	}
	
	
	
	
	/*public static void main(String[] args) {
		new AppMainFrame();
	}
	*/
}

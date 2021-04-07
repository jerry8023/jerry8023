package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.action.YdglDialogAction;
import com.action.YdglPopupMemuAction;
import com.dao.PreorderDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;


/**
 *
 * YdglDialog.java:预定管理界面
 * @author czp
 * @time 2013-7-11 上午2:17:27
 * 
 */
public class YdglDialog extends JDialog{
	
	
	private static final long serialVersionUID = -7175692808899995087L;
	
	private MyJButton mbjZj=new MyJButton("image//zj0.png","image//zj1.png","image//zj2.png");
	private MyJButton mbjXg=new MyJButton("image//xg0.png","image//xg1.png","image/xg2.png");
	private MyJButton mbjSc=new MyJButton("image//sc0.png","image//sc1.png","image//sc2.png");
	private JTextField jtf=new JTextField(8);
	private JButton jbCx=new JButton("查询");
	private JButton jbGl=new JButton("过滤");
	private JButton jbSx=new JButton("刷新");
	private JButton jbDc=new JButton("导出");
	private JButton jbDy=new JButton("打印");
	private JTable jtYd;
	private JLabel jlbkydgl=new JLabel("宾客预定管理");
	
	private JPopupMenu jpmGl=new JPopupMenu();
	private JMenuItem jmiToday=new JMenuItem("今天预订到达的宾客");
	private JMenuItem jmiTomorrow=new JMenuItem("明天预订到达的宾客");
	private JMenuItem jmiFanwei=new JMenuItem("预订时间范围在...");
	
	
	
	
	public YdglDialog(AppMainFrame owner, boolean model){
		
		super(owner,model);
		super.setSize(709,546);
		super.setLocationRelativeTo(null);
		super.setTitle("预定管理");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	
	public void addListener(){
		
		YdglDialogAction action=new YdglDialogAction(this);
		mbjSc.addActionListener(action);
		jbCx.addActionListener(action);
		jbSx.addActionListener(action);
		jbGl.addActionListener(action);
		mbjZj.addActionListener(action);
		mbjXg.addActionListener(action);
		jbDy.addActionListener(action);
		
		YdglPopupMemuAction itemAction=new YdglPopupMemuAction(this);
		jmiToday.addActionListener(itemAction);
		jmiTomorrow.addActionListener(itemAction);
		jmiFanwei.addActionListener(itemAction);
		
		
	}
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		JPanel northContent=northContent();
		northContent.setBounds(0, 0,709, 52);
		
		JPanel centerContent=centerContent();
		centerContent.setBounds(5,52 ,692,460);

		
		jPanel.add(northContent);
		jPanel.add(centerContent);
		
		
		return jPanel;
		
		
	}
	
	
	public JPanel northContent(){
		JPanel jPanel= new JPanel(new FlowLayout(FlowLayout.LEFT,5,3));
		jPanel.setBackground(new Color(236,233,216));
		
		
		mbjZj.setMargin(new Insets(0, 20, 0, 0));
		
		
		
		jtf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117),1));
		
		
		//jbCx.setFont(new Font("宋体", Font.BOLD, 10));
		jbCx.setBackground(new Color(248,245,229));
		jbCx.setPreferredSize(new Dimension(50,20));
		jbCx.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jbGl.setBackground(new Color(248,245,229));
		jbGl.setPreferredSize(new Dimension(50,20));
		jbGl.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jpmGl.add(jmiToday);
		jpmGl.add(jmiTomorrow);
		jpmGl.add(jmiFanwei);
		
		
		jbSx.setBackground(new Color(248,245,229));
		jbSx.setPreferredSize(new Dimension(50,20));
		jbSx.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jbDc.setBackground(new Color(248,245,229));
		jbDc.setPreferredSize(new Dimension(50,20));
		jbDc.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jbDy.setBackground(new Color(248,245,229));
		jbDy.setPreferredSize(new Dimension(50,20));
		jbDy.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jPanel.add(mbjZj);
		jPanel.add(mbjXg);
		jPanel.add(mbjSc);
		jPanel.add(new JLabel("包间号 / 姓名:"));
		jPanel.add(jtf);
		jPanel.add(jbCx);
		jPanel.add(jbGl);
		jPanel.add(jbSx);
		jPanel.add(jbDc);
		jPanel.add(jbDy);
		
		return jPanel;
	}
	
	
	public JPanel centerContent(){
		JPanel jPanel=new JPanel(new BorderLayout());
		
		JPanel jpTitle=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpTitle.setPreferredSize(new Dimension(709,18));
		
		jpTitle.add(jlbkydgl);
		jpTitle.setBackground(new Color(176,192,136));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		PreorderDao poDao=new PreorderDao();
		Vector<Vector> rowdatasPo=null;
		try {
			rowdatasPo=poDao.queryData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		/*System.out.println(rowdatasPo.get(0).get(7).toString());
		//2013-07-23  01:40:33
		for(int i=0;i<rowdatasPo.size();i++){
			String blsj=rowdatasPo.get(i).get(7).toString();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date dateBlsj=simpleDateFormat.parse(blsj);
				if(dateBlsj.before(new Date())){
					
				}
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "解析異常");
				e.printStackTrace();
			}
		}*/
		
		
		
		
		jtYd=new JTable(rowdatasPo,ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
		jtYd.getColumnModel().getColumn(5).setPreferredWidth(127);
		jtYd.getColumnModel().getColumn(6).setPreferredWidth(145);
		jtYd.getColumnModel().getColumn(7).setPreferredWidth(172);
		jtYd.getColumnModel().getColumn(8).setPreferredWidth(98);
		jtYd.setAutoCreateRowSorter(true);
		jtYd.setFillsViewportHeight(true);
		
		
		jtYd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jsp=new JScrollPane(jtYd,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		jPanel.add(jpTitle,BorderLayout.NORTH);
		jPanel.add(jsp,BorderLayout.CENTER);
		
		return jPanel;
	}


	
	
	public MyJButton getMbjZj() {
		return mbjZj;
	}


	public MyJButton getMbjXg() {
		return mbjXg;
	}


	public MyJButton getMbjSc() {
		return mbjSc;
	}


	public JTextField getJtf() {
		return jtf;
	}


	public JButton getJbCx() {
		return jbCx;
	}


	public JButton getJbGl() {
		return jbGl;
	}


	public JButton getJbSx() {
		return jbSx;
	}


	public JButton getJbDc() {
		return jbDc;
	}


	public JButton getJbDy() {
		return jbDy;
	}


	public JTable getJtYd() {
		return jtYd;
	}

	public JLabel getJlbkydgl() {
		return jlbkydgl;
	}

	public JPopupMenu getJpmGl() {
		return jpmGl;
	}

	public JMenuItem getJmiToday() {
		return jmiToday;
	}

	public JMenuItem getJmiTomorrow() {
		return jmiTomorrow;
	}

	public JMenuItem getJmiFanwei() {
		return jmiFanwei;
	}

	

}

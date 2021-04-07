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
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.action.BkjzDialogAction;
import com.action.BkjzDialogKeyListener;
import com.action.MjbFjMouseListener;
import com.action.ZjxfDialogAction;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.util.MyJButton;
import com.vo.XiaofeiVo;

public class BkjzDialog extends JDialog{
	
	
	private static final long serialVersionUID = 5350592367461216883L;

	
	private JLabel jlJzdh=new JLabel("ZD20130711001");
	private JLabel jlJzbj=new JLabel("T005");
	private JLabel jlZdxf=new JLabel("0");
	private JLabel jlXfje=new JLabel("1111.00");
	private MyJButton mjbHybh=new MyJButton("会员编号").set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(82, 22)).set_Background(new Color(248,245,229)).set_FocusPainted(false);
	private MyJButton mjbJz=new MyJButton("结账[F5]").set_PreferredSize(new Dimension(87, 20)).set_Background(new Color(251,249,231)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);
	private MyJButton mjbLhjz=new MyJButton("联合结账[F9]").set_PreferredSize(new Dimension(87, 20)).set_Background(new Color(251,249,231)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);
	private MyJButton mjbDyqd=new MyJButton("打印清单[F3]").set_PreferredSize(new Dimension(87, 20)).set_Background(new Color(251,249,231)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);
	private MyJButton mjbQx=new MyJButton("取消[F8]").set_PreferredSize(new Dimension(87, 20)).set_Background(new Color(251,249,231)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);
	private JLabel jlHyxm=new JLabel("普通宾客");
	private JLabel jlHydj=new JLabel("无");
	private JLabel jlDqjf=new JLabel("无");
	private JLabel jlDzbl=new JLabel("无");
	private JLabel jlYsje=new JLabel("540.00");
	private JLabel jlYsyj=new JLabel("0.00");
	private JLabel jlYhje=new JLabel("0.00");
	private JTextField jtfSsjr=new JTextField("560.00",7);
	private JTextField jtfBkzf=new JTextField(7);
	private JLabel jlZl=new JLabel("0.00");
	private JTable jtXfqdmx;
	private JLabel jlHj=new JLabel("840.00");
	private JTextField jtfHybh=new JTextField("普通宾客",6);
	
	private JCheckBox jcbQd=new JCheckBox("签单[F6]");
	private JCheckBox jcbGz=new JCheckBox("挂账");
	private JCheckBox jcbMf=new JCheckBox("免费");
	private JCheckBox jcbTd=new JCheckBox("退单");
	
	
	

	public BkjzDialog(AppMainFrame owner,boolean model){
		
		super(owner,model);
		super.setSize(733,519);
		super.setLocationRelativeTo(null);
		super.setTitle("收银结账");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public void addListener(){
		
		BkjzDialogKeyListener keyListener=new BkjzDialogKeyListener(this);
		jtfHybh.addKeyListener(keyListener);
		jtfBkzf.addKeyListener(keyListener);
		
		BkjzDialogAction action =new BkjzDialogAction(this);
		mjbHybh.addActionListener(action);
		mjbJz.addActionListener(action);
		mjbQx.addActionListener(action);
		jcbQd.addActionListener(action);
		jcbGz.addActionListener(action);
		jcbMf.addActionListener(action);
		jcbTd.addActionListener(action);
		
	}
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		
		jPanel.add(jPanel1());
		jPanel.add(jPanel2());
		jPanel.add(jPanel3());
		jPanel.add(jPanel4());
		jPanel.add(jPanel5());
		jPanel.add(jPanel6());
		jPanel.add(jPanel7());
		
		
		return jPanel;
	}
	
	
	public JPanel jPanel1(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,15,8));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setPreferredSize(new Dimension(714, 37));
		jPanel.setBounds(5,5,714, 37);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		
		JLabel jl1=new JLabel("结账单号:");
		jl1.setFont(new Font("宋体",Font.PLAIN,16));
		
		/*//------------------------
		Map<Attribute, Object> map=new HashMap<Attribute, Object>();
		map.put(TextAttribute.FONT, jl1.getFont());//保存原字体
		map.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);//增加属性(这里增加的是下划线属性)
		jl1.setFont(Font.getFont(map));//设置字体属性
		
		//-----------------------------
		*/				
		
		jl1.setForeground(Color.BLUE);
		jp1.add(jl1);
		
		jlJzdh.setPreferredSize(new Dimension(115, 20));
		jlJzdh.setFont(new Font("宋体",Font.PLAIN,14));
		jlJzdh.setForeground(Color.BLUE);
		jp1.add(jlJzdh);
	
		//------------------------------------------------------
		Date date=new Date();
		String jzdh="ZD"+DateUtil.getStrDate(date, DateUtil.DATE_TIME1);
		jlJzdh.setText(jzdh);
		
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JLabel jl2=new JLabel("结账包间:");
		jl2.setFont(new Font("宋体",Font.PLAIN,16));
		jl2.setForeground(Color.BLUE);
		jp2.add(jl2);
		
		jlJzbj.setPreferredSize(new Dimension(85, 20));
		jlJzbj.setFont(new Font("宋体",Font.PLAIN,16));
		jlJzbj.setForeground(Color.BLUE);
		jp2.add(jlJzbj);
		
		//---------------------------------------------------
		jlJzbj.setText(MjbFjMouseListener.getQygVo().getBjid());
		
		
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		JLabel jl3=new JLabel("最低消费:");
		jl3.setFont(new Font("宋体",Font.PLAIN,16));
		jl3.setForeground(Color.BLUE);
		jp3.add(jl3);
		
		jlZdxf.setPreferredSize(new Dimension(85, 20));
		jlZdxf.setFont(new Font("宋体",Font.PLAIN,16));
		jlZdxf.setForeground(Color.RED);
		jp3.add(jlZdxf);
		jlZdxf.setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
		
		
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp4.setBackground(null);
		jp4.setOpaque(false);
		
		JLabel jl4=new JLabel("消费金额:");
		jl4.setFont(new Font("宋体",Font.PLAIN,16));
		jl4.setForeground(Color.BLUE);
		jp4.add(jl4);
		
		jlXfje.setFont(new Font("宋体",Font.PLAIN,16));
		jlXfje.setForeground(Color.BLUE);
		jp4.add(jlXfje);
		//------------------------------------------------------------
		//写在JTable旁边。。。。。。
		
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		jPanel.add(jp4);
		
		
		
		return jPanel;
	}
	
	
	
	public JPanel jPanel2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,8));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5,45,714, 37);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		JPanel jp0=new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
		jp0.setBackground(null);
		jp0.setOpaque(false);
		
		
		
		jtfHybh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp0.add(mjbHybh);
		jp0.add(jtfHybh);
		
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		
		JLabel jl1=new JLabel("会员姓名：");
		jl1.setFont(new Font("宋体",Font.PLAIN,12));
		jp1.add(jl1);
		
		jlHyxm.setPreferredSize(new Dimension(100, 20));
		jlHyxm.setFont(new Font("宋体",Font.PLAIN,12));
		jlHyxm.setForeground(Color.BLUE);
		jp1.add(jlHyxm);
		
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JLabel jl2=new JLabel("会员级别：");
		jl2.setFont(new Font("宋体",Font.PLAIN,12));
		jp2.add(jl2);
		
		jlHydj.setPreferredSize(new Dimension(60, 20));
		jlHydj.setFont(new Font("宋体",Font.PLAIN,12));
		jlHydj.setForeground(Color.BLUE);
		jp2.add(jlHydj);
		
		
		JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp3.setBackground(null);
		jp3.setOpaque(false);
		
		JLabel jl3=new JLabel("当前积分：");
		jl3.setFont(new Font("宋体",Font.PLAIN,12));
		jp3.add(jl3);
		
		jlDqjf.setPreferredSize(new Dimension(60, 20));
		jlDqjf.setFont(new Font("宋体",Font.PLAIN,12));
		jlDqjf.setForeground(Color.BLUE);
		jp3.add(jlDqjf);
		
		
		JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp4.setBackground(null);
		jp4.setOpaque(false);
		
		JLabel jl4=new JLabel("打折比率：");
		jl4.setFont(new Font("宋体",Font.PLAIN,12));
		jp4.add(jl4);
		
		jlDzbl.setFont(new Font("宋体",Font.PLAIN,12));
		jlDzbl.setForeground(Color.RED);
		jp4.add(jlDzbl);
		
		
		
		jPanel.add(jp0);
		jPanel.add(jp1);
		jPanel.add(jp2);
		jPanel.add(jp3);
		jPanel.add(jp4);
		
		
		return jPanel;
		
	}
	
	
	
	public JPanel jPanel3(){
		
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(5,85,714, 133);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		
		//------------------------------------------------------------
		
		JPanel jPanel31=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jPanel31.setBackground(null);
		jPanel31.setOpaque(false);
		jPanel31.setBounds(6,20,475, 20);
		
		
		JPanel jp311=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp311.setBackground(null);
		jp311.setOpaque(false);
		
		JLabel jl11=new JLabel("应收金额:");
		jl11.setFont(new Font("宋体",Font.PLAIN,16));
		jl11.setForeground(Color.BLUE);
		jp311.add(jl11);
		
		jlYsje.setPreferredSize(new Dimension(100, 20));
		jlYsje.setFont(new Font("宋体",Font.PLAIN,16));
		jlYsje.setForeground(Color.RED);
		jp311.add(jlYsje);
		
		
		JPanel jp312=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp312.setBackground(null);
		jp312.setOpaque(false);
		
		JLabel jl12=new JLabel("已收押金:");
		jl12.setFont(new Font("宋体",Font.PLAIN,16));
		jl12.setForeground(Color.BLUE);
		jp312.add(jl12);
		
		jlYsyj.setPreferredSize(new Dimension(94, 20));
		jlYsyj.setFont(new Font("宋体",Font.PLAIN,16));
		jlYsyj.setForeground(Color.RED);
		jp312.add(jlYsyj);
		
		
		JPanel jp313=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp313.setBackground(null);
		jp313.setOpaque(false);
		
		JLabel jl13=new JLabel("优惠金额:");
		jl13.setFont(new Font("宋体",Font.PLAIN,16));
		jl13.setForeground(Color.BLUE);
		jp313.add(jl13);
		
		jlYhje.setFont(new Font("宋体",Font.PLAIN,16));
		jlYhje.setForeground(Color.RED);
		jp313.add(jlYhje);
		
		
		
		jPanel31.add(jp311);
		jPanel31.add(jp312);
		jPanel31.add(jp313);
		
		
		//--------------------------------------------------------------
		
		JPanel jPanel32=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jPanel32.setBackground(null);
		jPanel32.setOpaque(false);
		jPanel32.setBounds(8,60,475, 23);
		
		
		JPanel jp321=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp321.setBackground(null);
		jp321.setOpaque(false);
		jp321.setPreferredSize(new Dimension(170, 23));
		
		JLabel jl21=new JLabel("实收金额：");
		jl21.setFont(new Font("宋体",Font.PLAIN,12));
		jp321.add(jl21);
		
		jtfSsjr.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp321.add(jtfSsjr);
		
		
		JPanel jp322=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp322.setBackground(null);
		jp322.setOpaque(false);
		jp322.setPreferredSize(new Dimension(168, 23));
		
		JLabel jl22=new JLabel("宾客支付(A)：");
		jl22.setFont(new Font("宋体",Font.PLAIN,12));
		jp322.add(jl22);
		
		jtfBkzf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jp322.add(jtfBkzf);
		jtfBkzf.requestFocus();
		
		JPanel jp323=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp323.setBackground(null);
		jp323.setOpaque(false);
		
		JLabel jl23=new JLabel("找零:");
		jl23.setFont(new Font("宋体",Font.PLAIN,16));
		jl23.setForeground(Color.BLUE);
		jp323.add(jl23);
		
		jlZl.setFont(new Font("宋体",Font.PLAIN,14));
		jlZl.setForeground(Color.RED);
		jp323.add(jlZl);
		
		
		
		jPanel32.add(jp321);
		jPanel32.add(jp322);
		jPanel32.add(jp323);
		
		
		//-------------------------------------------------------------------
		
		JPanel jPanel33=new JPanel(new FlowLayout(FlowLayout.LEFT,6,18));
		jPanel33.setBackground(new Color(236,233,216));
		jPanel33.setBounds(1,82,475, 48);
		
		
		JLabel jl31=new JLabel("结账备注:");
		jl31.setFont(new Font("宋体",Font.PLAIN,12));
		
		JTextField jtfJzbz=new JTextField("*",31);
		jtfJzbz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		MyJButton mjbKqx=new MyJButton("开钱箱").set_PreferredSize(new Dimension(59, 21)).set_Background(new Color(248,245,229)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);
		
		jPanel33.add(jl31);
		jPanel33.add(jtfJzbz);
		jPanel33.add(mjbKqx);
		
		//------------------------------------------------------------
		
		JPanel jPanel34=new JPanel(new GridLayout(4, 1));
		jPanel34.setBackground(null);
		jPanel34.setOpaque(false);
		jPanel34.setBounds(488,15,80,109);
		
		
		jcbQd.setFocusPainted(false);
		jcbQd.setBackground(null);
		jcbQd.setOpaque(false);
		
		jcbGz.setFocusPainted(false);
		jcbGz.setBackground(null);
		jcbGz.setOpaque(false);
		
		jcbMf.setFocusPainted(false);
		jcbMf.setBackground(null);
		jcbMf.setOpaque(false);
		
		jcbTd.setFocusPainted(false);
		jcbTd.setBackground(null);
		jcbTd.setOpaque(false);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(jcbQd);
		bg.add(jcbGz);
		bg.add(jcbMf);
		bg.add(jcbTd);
		
		
		jPanel34.add(jcbQd);
		jPanel34.add(jcbGz);
		jPanel34.add(jcbMf);
		jPanel34.add(jcbTd);
		
		
		//----------------------------------------------------------
		
		GridLayout gl=new GridLayout(4, 1);
		JPanel jPanel35=new JPanel(gl);
		gl.setVgap(9);
		jPanel35.setBackground(null);
		jPanel35.setOpaque(false);
		jPanel35.setBounds(565,12,88,111);
		
		
		jPanel35.add(mjbJz);
		jPanel35.add(mjbLhjz);
		jPanel35.add(mjbDyqd);
		jPanel35.add(mjbQx);
		
		//----------------------------------------------------------------------------------
		
		jPanel.add(jPanel31);
		jPanel.add(jPanel32);
		jPanel.add(jPanel33);
		//jPanel.remove(2);
		//jPanel.add(jPanelQd());
		//jPanel.remove(2);
		//jPanel.add(jPanel33);
		jPanel.add(jPanel34);
		jPanel.add(jPanel35);
		
		return jPanel;
		
	}
	
	
	//签单时界面变化的模块
	public JPanel jPanelQd(){
		
		
		JPanel jPanelQd=new JPanel(null);
		jPanelQd.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanelQd.setBackground(new Color(236,233,216));
		jPanelQd.setBounds(6,82,472, 48);
		
		
		//----------------------------------------------------------
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBounds(6,18,465,20);
		
		JTextField jtfDrmc=new JTextField(6);
		jtfDrmc.setPreferredSize(new Dimension(69,20));
		jtfDrmc.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTextField jtfMm=new JTextField(6);
		jtfMm.setPreferredSize(new Dimension(69,20));
		jtfMm.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTextField jtfQdje=new JTextField("0",6);
		jtfQdje.setPreferredSize(new Dimension(69,20));
		jtfQdje.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		MyJButton mjbQd=new MyJButton("确定").set_PreferredSize(new Dimension(57, 20)).set_Background(new Color(251,249,231)).set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false);;
		
		
		jPanel.add(new JLabel("登录名称:"));
		jPanel.add(jtfDrmc);
		jPanel.add(new JLabel("密码:"));
		jPanel.add(jtfMm);
		jPanel.add(new JLabel("签单金额:"));
		jPanel.add(jtfQdje);
		jPanel.add(mjbQd);
		
		//---------------------------------------------
		MyJButton mjbGb=new MyJButton("image/gb0.png", "image/gb1.png", "image/gb2.png").set_Margin(new Insets(0, 0, 0, 0)).set_FocusPainted(false).set_BorderPainted(false);
		mjbGb.setBounds(453,1, 17, 14);
		
		
		jPanelQd.add(jPanel);
		jPanelQd.add(mjbGb);
		
		
		return jPanelQd;
	}

	
	public JPanel jPanel4(){
		JPanel jPanel =new JPanel(new BorderLayout());
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.setBackground(new Color(236,233,216));
		jPanel.setBounds(5, 222, 191, 151);
		
		//---------------------------------------------------------------
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(191, 20));
		jpNorth.setBackground(new Color(186,200,142));
		jpNorth.add(new JLabel("在店宾客"),BorderLayout.NORTH);
		
		//------------------------------------------------------------------
		JPanel jpCenter=new JPanel(new FlowLayout(FlowLayout.CENTER,5,4));
		jpCenter.setBackground(null);
		jpCenter.setOpaque(false);
		jpCenter.setPreferredSize(new Dimension(191, 25));
		
		JTextField jtfZdbj=new JTextField(8);
		jtfZdbj.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		jpCenter.add(new JLabel("指定包间(Q):"));
		jpCenter.add(jtfZdbj);
		
		//-------------------------------------------------------------------------
		JPanel jpSouth=new JPanel();
		jpSouth.setPreferredSize(new Dimension(191, 104));
		jpSouth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpSouth.setBackground(Color.WHITE);
		
		
		jPanel.add(jpNorth,BorderLayout.NORTH);
		jPanel.add(jpCenter,BorderLayout.CENTER);
		jPanel.add(jpSouth,BorderLayout.SOUTH);
		
		return jPanel;
	}
	
	public JPanel jPanel5(){
		JPanel jPanel =new JPanel(new BorderLayout());
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.setBounds(200, 222, 519,267);
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(519, 20));
		jpNorth.setBackground(new Color(186,200,142));
		
		jpNorth.add(new JLabel("结账区内包间      消费清单      合计："));
		jpNorth.add(jlHj);
		
		//--------------------------------------------------------------
		Vector<Vector> rowdatas=ZjxfDialogAction.jtableSx();
		Double xfje=0.0;
		Double hj=0.0;
		Double yhje=0.0;
		for(int i=0;i<rowdatas.size();i++){
			xfje+=Double.parseDouble(rowdatas.get(i).get(2).toString());
			hj+=Double.parseDouble(rowdatas.get(i).get(5).toString());
			rowdatas.get(i).add(4, Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(3).toString()));
			rowdatas.get(i).add(5, Double.parseDouble(rowdatas.get(i).get(2).toString())-Double.parseDouble(rowdatas.get(i).get(4).toString()));
			yhje+=Double.parseDouble(rowdatas.get(i).get(5).toString());
		}
		this.getJlXfje().setText(xfje.toString());
		this.getJlYsje().setText(hj.toString());
		this.getJlHj().setText(hj.toString());
		this.getJlYhje().setText(yhje.toString());
		this.getJtfBkzf().requestFocus();
		
		xiaofeiDao xfDao=new xiaofeiDao();
		try {
			
			XiaofeiVo xfVo=xfDao.getXfByBjid(MjbFjMouseListener.getQygVo().getBjid());
			this.getJlYsyj().setText(xfVo.getYajin().toString());
			this.getJtfSsjr().setText(String.valueOf(hj-xfVo.getYajin()));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		
		jtXfqdmx=new JTable(rowdatas,ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDANMINGXI_CLUMN_NAME));
		jtXfqdmx.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane=new JScrollPane(jtXfqdmx, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jtXfqdmx.setAutoCreateRowSorter(true);
		jtXfqdmx.setFillsViewportHeight(true);
		
		
		
		jPanel.add(jpNorth,BorderLayout.NORTH);
		jPanel.add(jScrollPane,BorderLayout.CENTER);
		
		return jPanel;
		
	}
	
	
	
	public JPanel jPanel6(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,-5));
		jPanel.setBounds(6, 375, 191, 20);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		
		JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT,20,0));
		jp.setBackground(null);
		jp.setOpaque(false);
		MyJButton mjbXx=new MyJButton("image/xx0.png", "image/xx1.png", "image/xx2.png");
		MyJButton mjbXs=new MyJButton("image/xs0.png", "image/xs1.png","image/xs2.png");
		jp.add(mjbXx);
		jp.add(mjbXs);
		
		
		jPanel.add(new JLabel("结账区↓"));
		jPanel.add(jp);
	
		
		return jPanel;
	}
	
	
	public JPanel jPanel7(){
		JPanel jPanel=new JPanel();
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.setBounds(6, 395, 190, 93);
		jPanel.setBackground(Color.WHITE);
		
		return jPanel;
	}


	
	
	
	public JLabel getJlJzdh() {
		return jlJzdh;
	}


	public JLabel getJlJzbj() {
		return jlJzbj;
	}


	public JLabel getJlZdxf() {
		return jlZdxf;
	}


	public JLabel getJlXfje() {
		return jlXfje;
	}


	public MyJButton getMjbHybh() {
		return mjbHybh;
	}


	public MyJButton getMjbJz() {
		return mjbJz;
	}


	public MyJButton getMjbLhjz() {
		return mjbLhjz;
	}


	public MyJButton getMjbDyqd() {
		return mjbDyqd;
	}


	public MyJButton getMjbQx() {
		return mjbQx;
	}


	public JLabel getJlHyxm() {
		return jlHyxm;
	}


	public JLabel getJlHydj() {
		return jlHydj;
	}


	public JLabel getJlDqjf() {
		return jlDqjf;
	}


	public JLabel getJlDzbl() {
		return jlDzbl;
	}


	public JLabel getJlYsje() {
		return jlYsje;
	}


	public JLabel getJlYsyj() {
		return jlYsyj;
	}


	public JLabel getJlYhje() {
		return jlYhje;
	}


	public JTextField getJtfSsjr() {
		return jtfSsjr;
	}


	public JTextField getJtfBkzf() {
		return jtfBkzf;
	}


	public JLabel getJlZl() {
		return jlZl;
	}


	public JTable getJtXfqdmx() {
		return jtXfqdmx;
	}


	public JLabel getJlHj() {
		return jlHj;
	}


	public JTextField getJtfHybh() {
		return jtfHybh;
	}

	public JCheckBox getJcbQd() {
		return jcbQd;
	}

	public JCheckBox getJcbGz() {
		return jcbGz;
	}

	public JCheckBox getJcbMf() {
		return jcbMf;
	}

	public JCheckBox getJcbTd() {
		return jcbTd;
	}
	
	
	
	
	/*public static void main(String[] args) {
		new BkjzDialog();

	}*/

}

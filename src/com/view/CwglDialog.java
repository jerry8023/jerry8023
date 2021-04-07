package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import com.util.ColumnContent;
import com.view.util.MyJButton;
import com.view.util.RiqiAndJTextfield;


/**
 * 
 * CwglDialog.java :财务管理界面
 *  @author TSS
 * @time 2013-7-12 下午9:43:27
 * 
 * */

public class CwglDialog extends JDialog{

	
	
	private static final long serialVersionUID = -7702914225733437580L;
	
	
	private MyJButton mjbzjfycw = new MyJButton("image//zjfy0.png","image//zjfy1.png","image//zjfy2.png");
	private MyJButton mjbzjsrcw = new MyJButton("image//zjsr0.png","image//zjsr1.png","image//zjsr2.png");
	private MyJButton mjbdelcw  = new MyJButton("image//cwsc0.png","image//cwsc1.png","image//cwsc2.png");
	private MyJButton mjbfysrtccw  = new MyJButton("image//fysrtc0.png","image//fysrtc1.png","image//fysrtc2.png");
	private JTextField jtffysrcwgl1 = new JTextField("0.00",10);
	private JTextField jtffysrcwgl2 = new JTextField("0.00",6);
	
	//经营表组件
	private MyJButton mjbjytjbiaotc = new MyJButton("image//fysrtc0.png","image//fysrtc1.png","image//fysrtc2.png");
	private JTextField jtfjybqsrqcw = new JTextField(8);
	private MyJButton  mjbjybqsrqcw = new MyJButton("image/rl.png","image/rl1.png","image/rl2.png");
	private JTextField jtfjybjsrqcw = new JTextField(8);
	private MyJButton  mjbjybjsrqcw = new MyJButton("image//rl.png","image/rl1.png","image/rl2.png");
	private JTextField jtfjybzwmxcw= new JTextField("0.00",10);
	private MyJButton mjbjytjbiaoss = new MyJButton("image//cwsousuo0.png","image//cwsousuo1.png","image//cwsousuo2.png");
	
	//经营图组件
	private MyJButton mjbjytjtubaioss = new MyJButton("image//cwsousuo0.png","image//cwsousuo1.png","image//cwsousuo2.png");
	private JTextField jtfjytqsrqcw = new JTextField(8);
	private MyJButton  mjbjytqsrqcw = new MyJButton("image//rl.png","image/rl1.png","image/rl2.png");
	private JTextField jtfjytjsrqcw = new JTextField(8);
	private MyJButton  mjbjytjsrqcw = new MyJButton("image//rl.png","image/rl1.png","image/rl2.png");
	//private MyJButton mjbjytjtubaioss = new MyJButton("image//cwsousuo0.png","image//cwsousuo1.png","image//cwsousuo2.png");

	//应收应付表组件
	private JTextField jtfysyfqsrqcw = new JTextField(8);
	private MyJButton  mjbysyfqsrqcw = new MyJButton("image//rl.png","image/rl1.png","image/rl2.png");
	private JTextField jtfysyfjsrqcw = new JTextField(8);
	private MyJButton  mjbysyfjsrqcw = new MyJButton("image//rl.png","image/rl1.png","image/rl2.png");
	private JTextField jtfysyfzkcw1= new JTextField("0.00",6);
	private JTextField jtfysyfzkcw2= new JTextField("0.00",6);
	private JTextField jtfysyfzkcw3= new JTextField("0.00",6);
	private JTextField jtfysyfzkcw4= new JTextField("0.00",6);
	private JTextField jtfysyfzkmxcw= new JTextField("0.00",6);	
	private MyJButton mjbysyfss = new MyJButton("image//cwsousuo0.png","image//cwsousuo1.png","image//cwsousuo2.png");
		
	
	
	public CwglDialog(AppMainFrame owner,boolean model){
		super(owner,model);
		super.setSize(707,492);
		super.setLocationRelativeTo(null);
		super.setTitle("财务管理");
		super.setResizable(false);
		
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public JPanel content(){
		
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JTabbedPane jtabbedPane = new JTabbedPane();
		jtabbedPane.setBounds(0, 5, 701, 460);
		jtabbedPane.setBackground(new Color(236,233,216));

		//添加卡片
		jpanel.add(jtabbedPane);
		jtabbedPane.add("费用及收入统计表",fysrtongji());
		jtabbedPane.add("经营统计表",jytongji());
		jtabbedPane.add("应收应付统计表",ysyftongji());
		jtabbedPane.setBackground(new Color(249,246,230));
		jtabbedPane.setFont(new Font("宋体", Font.PLAIN, 12));

		
		return jpanel;
		
	}
	
	public JPanel fysrtongji(){
		JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jp1  =  new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-2));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setPreferredSize(new Dimension(690,54));
		mjbzjfycw.set_FocusPainted(false);
		mjbzjsrcw.set_FocusPainted(false);
		mjbdelcw.set_FocusPainted(false);
		mjbfysrtccw.set_FocusPainted(false);
		jp1.add(mjbzjfycw);
		jp1.add(mjbzjsrcw);
		jp1.add(mjbdelcw);
		jp1.add(mjbfysrtccw);
		
		
		JPanel jpp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jpp1.setPreferredSize(new Dimension(690,192));
		JTable jtcwglfysr1 = new JTable(null,ColumnContent.arrayToVector(ColumnContent.FEIYONGSHOURU1_CLUMN_NAME));
		JScrollPane jscrollPane = new JScrollPane(jtcwglfysr1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setPreferredSize(new Dimension(690,163));
		jscrollPane.setBorder(BorderFactory.createLineBorder(new Color(170,184,181),1));
		
		//将文本框和jscrollPane添加到面板jpp1中
		JPanel jpt1 = new JPanel(new FlowLayout(FlowLayout.CENTER,120,1));
		RiqiAndJTextfield.setUnchangedTextFiled(jtffysrcwgl1, JTextField.RIGHT);
		jpt1.add(jtffysrcwgl1);
		jpp1.setBorder(BorderFactory.createLineBorder(new Color(170,184,181),2));
		jpp1.add(jscrollPane);
		jpp1.add(jpt1);
		
		

		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,1));
		//jp2.setBackground(new Color(238,238,238));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		jp2.setPreferredSize(new Dimension(690,8));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT,1,1));
		jp3.setPreferredSize(new Dimension(690,160));
		JTable jtcwglfysr2 = new JTable(null,ColumnContent.arrayToVector(ColumnContent.FEIYONGSHOURU2_CLUMN_NAME));
		JScrollPane jscrollPane1 = new JScrollPane(jtcwglfysr2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane1.setPreferredSize(new Dimension(690,130));
		
		jscrollPane1.setBorder(BorderFactory.createLineBorder(new Color(170,184,181),2));
		JPanel jpt2 = new JPanel(new FlowLayout(FlowLayout.CENTER,120,1));
		jpt2.setBackground(null);
		jpt2.setOpaque(false);
		RiqiAndJTextfield.setUnchangedTextFiled(jtffysrcwgl2, JTextField.LEFT);
		jp3.add(jscrollPane1);
		jpt2.add(jtffysrcwgl2);
		jp3.add(jpt2);
		jp3.setBorder(BorderFactory.createLineBorder(new Color(170,184,181),2));
		
		
		jpanel.add(jp1);
		jpanel.add(jpp1);
		jpanel.add(jp2);
		jpanel.add(jp3);
		return jpanel;
		
	}
	
	
	public JPanel jytongji(){
		JPanel jpanel = new JPanel(null);
		JTabbedPane jtabbedPane = new JTabbedPane();
		jtabbedPane.setBounds(0,5,707,482);
		jpanel.setBackground(new Color(236,233,216));
		//jtabbedPane.setBackground(new Color(251,249,231));
		jpanel.add(jtabbedPane);
		jtabbedPane.add("经营情况统计表",jyqktongji());
		jtabbedPane.add("经营情况统计图表",jyqktjtu());	
		return jpanel;
	}
	
	public JPanel jyqktongji(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,1,0));
		jp1.setBounds(0, 0, 690, 59);
		jp1.setBackground(new Color(236,233,216));
		mjbjytjbiaotc.set_BorderPainted(false).set_Margin(new Insets(2, 2, 1, 1));
		jp1.add(mjbjytjbiaotc);
		
		JLabel jl1 = new JLabel("起始日期：");
		JPanel jprq = RiqiAndJTextfield.getRiQiJpanel(jtfjybqsrqcw, mjbjybqsrqcw);
		jp1.add(jl1);
		jp1.add(jprq);
		
		JLabel jl2 = new JLabel("  结束日期：");
		JPanel jprq1 = RiqiAndJTextfield.getRiQiJpanel(jtfjybjsrqcw, mjbjybjsrqcw);
		jp1.add(jl2);
		jp1.add(jprq1);
		
		mjbjytjbiaoss.set_BorderPainted(false);
		jp1.add(mjbjytjbiaoss);
		jpanel.add(jp1);
		
		//添加第一个经营统计表
		JPanel jpp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
		jpp1.setBackground(new Color(236,233,216));
		JTable jtjytjbcw1 = new JTable(null,ColumnContent.arrayToVector(ColumnContent.JINGYINGTONGJIBIAO1_CLUMN_NAME));
		JScrollPane jscrollPane1 = new JScrollPane(jtjytjbcw1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane1.setPreferredSize(new Dimension(689,152));	
		jscrollPane1.setBorder(BorderFactory.createLineBorder(new Color(143,142,117),2));
		jpp1.setBounds(5, 60, 689,160);
		jpp1.setBackground(new Color(236,233,216));
		jpp1.add(jscrollPane1);
		jpanel.add(jpp1);
		
		//添加第二个经营统计表
		JPanel jpp2 = new JPanel(new FlowLayout(FlowLayout.LEFT,1,0));
		jpp2.setBackground(new Color(236,233,216));
		JTable jtjytjbcw2 = new JTable(null,ColumnContent.arrayToVector(ColumnContent.JINGYINGTONGJIBIAO2_CLUMN_NAME));
		JScrollPane jscrollPane2 = new JScrollPane(jtjytjbcw2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane2.setPreferredSize(new Dimension(689,152));	
		jscrollPane2.setBorder(BorderFactory.createLineBorder(new Color(143,142,117),1));
		
		jpp2.setBounds(5, 222, 689,173);
		jpp2.setBackground(null);
		jpp2.setOpaque(false);
		jpp2.add(jscrollPane2);
		JPanel jptj = new JPanel(new FlowLayout(FlowLayout.CENTER,360,0));
		jptj.setBackground(new Color(236,233,216));
		jptj.setBounds(5,363, 689, 8);
		RiqiAndJTextfield.setUnchangedTextFiled(jtfjybzwmxcw, JTextField.CENTER);
		jptj.add(jtfjybzwmxcw);
		jpp2.add(jptj);
		jpp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,142,117)), 
				      "财务明细", TitledBorder.LEFT, TitledBorder.TOP, new Font("宋体",Font.PLAIN,12),Color.blue));
		jpanel.add(jpp2);
		
		
		return jpanel;
		
	}
	
	public JPanel jyqktjtu(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		JPanel jptreetj = new JPanel();
		jptreetj.setBounds(0, 0, 173, 406);
		jptreetj.setBackground(Color.white);
		
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jp1.setBounds(176,0,514,47);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		JLabel jl1 = new JLabel("起始日期：");
		JPanel jprq = RiqiAndJTextfield.getRiQiJpanel(jtfjytqsrqcw, mjbjytqsrqcw);
		
		jp1.add(jl1);
		jp1.add(jprq);
		
		JLabel jl2 = new JLabel("  结束日期：");
		JPanel jprq1 = RiqiAndJTextfield.getRiQiJpanel(jtfjytjsrqcw, mjbjytjsrqcw);
		jp1.add(jl2);
		jp1.add(jprq1);
		
		mjbysyfss.set_BorderPainted(false);
		jp1.add(mjbysyfss);
		//jpanel.add(jp1);
		
		
		
		JPanel jpsrtjtu = new JPanel();
		jpsrtjtu.setBounds(176,47,514,361);
		jpsrtjtu.setBackground(Color.white);
		jpanel.add(jptreetj);
		jpanel.add(jp1);
		jpanel.add(jpsrtjtu);
		return jpanel;
		
	}

	
	
	//应收应入统计表
	public JPanel ysyftongji(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		
		//设置起止时间和搜索
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER,1,0));
	
		jp1.setBounds(0,0,693,35);
		jp1.setBackground(null);
		jp1.setOpaque(false);
		JLabel jl1 = new JLabel("       起始日期：");
		JPanel jprq = RiqiAndJTextfield.getRiQiJpanel(jtfysyfqsrqcw, mjbysyfqsrqcw);
		jp1.add(jl1);
		jp1.add(jprq);
		
		JLabel jl2 = new JLabel("     结束日期：");
		JPanel jprq1 = RiqiAndJTextfield.getRiQiJpanel(jtfysyfjsrqcw, mjbysyfjsrqcw);
		jp1.add(jl2);
		jp1.add(jprq1);
		
		mjbjytjtubaioss.set_BorderPainted(false);
		jp1.add(mjbjytjtubaioss);
		//jp1.set
		jpanel.add(jp1);
		
		//设置应收应付账款table
		JPanel jpp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
		jpp1.setBackground(null);
		jpp1.setOpaque(false);
		JTable jtysyfzkcw = new JTable(null,ColumnContent.arrayToVector(ColumnContent.ZHANGKUAIYSYF_CLUMN_NAME));
		JScrollPane jscrollPane = new JScrollPane(jtysyfzkcw,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setPreferredSize(new Dimension(681,135));	
		jscrollPane.setBorder(BorderFactory.createLineBorder(new Color(143,142,117),1));
		
		jpp1.setBounds(3, 40, 690,183);
		jpp1.add(jscrollPane);
		JPanel jptj = new JPanel(new FlowLayout(FlowLayout.CENTER,5,1));
		jptj.setBackground(null);
		jptj.setOpaque(false);
		jptj.setBounds(5,363, 691, 8);
		
		RiqiAndJTextfield.setUnchangedTextFiled(jtfysyfzkcw1,JTextField.RIGHT);
		RiqiAndJTextfield.setUnchangedTextFiled(jtfysyfzkcw2,JTextField.RIGHT);
		RiqiAndJTextfield.setUnchangedTextFiled(jtfysyfzkcw3,JTextField.RIGHT);
		RiqiAndJTextfield.setUnchangedTextFiled(jtfysyfzkcw4,JTextField.RIGHT);
		//jtfysyfzkcw1.setAlignmentX(100);
		jptj.add(jtfysyfzkcw1);
		jptj.add(jtfysyfzkcw2);
		jptj.add(jtfysyfzkcw3);
		jptj.add(jtfysyfzkcw4);
		jpp1.add(jptj);
		jpp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,142,117)), 
			      "应收应付账款", TitledBorder.LEFT, TitledBorder.TOP, new Font("宋体",Font.PLAIN,12),Color.blue));
	
		jpanel.add(jpp1);
		
		//设置应收应付账款明细table
		JPanel jpp2 = new JPanel(new FlowLayout(FlowLayout.LEFT,1,1));
		jpp2.setBackground(null);
		jpp2.setOpaque(false);
		JTable ysyfzkmxcw = new JTable(null,ColumnContent.arrayToVector(ColumnContent.ZHANGKUAIMINGXIYSYF_CLUMN_NAME));
		JScrollPane jscrollPane2 = new JScrollPane(ysyfzkmxcw,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane2.setPreferredSize(new Dimension(681,145));	
		jscrollPane2.setBorder(BorderFactory.createLineBorder(new Color(143,142,117),1));
		
		jpp2.setBounds(5, 232, 691,191);
		jpp2.add(jscrollPane2);
		JPanel jptj1 = new JPanel(new FlowLayout(FlowLayout.RIGHT,360,1));
		jptj1.setBackground(null);
		jptj1.setOpaque(false);
		
		jptj1.setBounds(5,363, 691, 8);
		RiqiAndJTextfield.setUnchangedTextFiled(jtfysyfzkmxcw,JTextField.LEFT);
		jptj1.add(jtfysyfzkmxcw);
		jpp2.add(jptj1);
		jpp2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(143,142,117)), 
			      "应收应付账款详细", TitledBorder.LEFT, TitledBorder.TOP, new Font("宋体",Font.PLAIN,12),Color.blue));
		jpanel.add(jpp2);
		return jpanel;
		
	}
	
	
	/*public static void main(String[] args) {
		new CwglDialog();
	}*/

}

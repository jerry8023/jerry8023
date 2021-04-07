package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.action.MjbFjMouseListener;
import com.action.ZjxfDialogKeyListener;
import com.action.ZjxfDialogAction;
import com.dao.DazheDao;
import com.dao.GoodsDao;
import com.dao.JifeiDao;
import com.dao.MgradeDao;
import com.dao.OperatorDao;
import com.dao.XfdetailDao;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJPanel;
import com.vo.DazheVo;
import com.vo.GoodsVo;
import com.vo.JifeiVo;
import com.vo.MgradeVo;
import com.vo.OperatorVo;
import com.vo.XiaofeiVo;

/**
 *
 * ZjxfDialog.java:�������ѽ���
 * @author czp
 * @time 2013-7-11 ����2:18:03
 * 
 */
public class ZjxfDialog extends JDialog{

	
	private static final long serialVersionUID = -4816566706112692670L;
	
	
	public static int count=1;
	
	private JTextField jtfBjmcXf=new JTextField("",5);
	private JLabel jlBjmcXf=new JLabel("****");
	private JTextField jtfXmbmOrJpXf=new JTextField(7);
	private JTextField jtfXfslXf=new JTextField("1",7);
	private JTextField jtfSsXfxmjc=new JTextField(5);
	private JTable jTableSp;
	private JTable jTableXfqd;
	private JButton jbZjXfslXf=new JButton("����  [F3] ");
	private JButton jbQdgb=new JButton("ȷ���ر�  [F5]  ");
	private MyJButton mjbLbZjxf=new MyJButton("image/lb0.png", "image/lb1.png","image/lb2.png");
	private MyJButton mjbSsZjxf=new MyJButton("image/ss0.png", "image/ss1.png","image/ss2.png");
	private MyJButton mjbJdZjxf=new MyJButton("image/jd0.png", "image/jd1.png","image/jd2.png");
	private MyJButton mjbTdZjxf=new MyJButton("image/td0.png", "image/td1.png","image/td2.png");
	private MyJButton mjbZdZjxf=new MyJButton("image/zd0.png", "image/zd1.png","image/zd2.png");
	private MyJButton mjbZhuandZjxf=new MyJButton("image/zhuand0.png", "image/zhuand1.png","image/zhuand2.png");
	private JTabbedPane jTabbedPane=new JTabbedPane();

	
	
	
	
	public ZjxfDialog(AppMainFrame owner,boolean model){
		super(owner,model);
		super.setSize(747,569);
		super.setLocationRelativeTo(null);
		super.setTitle("��������");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(NorthContent(),BorderLayout.NORTH);
		container.add(centerContent(),BorderLayout.CENTER);

		
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	
	public void addListener(){
		
		ZjxfDialogKeyListener keyListener=new ZjxfDialogKeyListener(this);
		jtfXmbmOrJpXf.addKeyListener(keyListener);
		jtfSsXfxmjc.addKeyListener(keyListener);
		
		ZjxfDialogAction action=new ZjxfDialogAction(this);
		jbZjXfslXf.addActionListener(action);
		jbQdgb.addActionListener(action);
		mjbJdZjxf.addActionListener(action);
		mjbSsZjxf.addActionListener(action);
		mjbLbZjxf.addActionListener(action);
	}
	
	
	public JPanel NorthContent(){
		JPanel jPanel=new MyJPanel(null, "image/zjxf.png", MyJPanel.SCALED);
		jPanel.setPreferredSize(new Dimension(747, 53));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jpLeft=new JPanel(new FlowLayout(FlowLayout.CENTER,-5,-1));
		jpLeft.setBackground(null);
		jpLeft.setOpaque(false);
		jpLeft.setBounds(100, 0, 220, 52);
		
		jpLeft.add(mjbLbZjxf);
		jpLeft.add(mjbSsZjxf);
		jpLeft.add(mjbJdZjxf);
		
		
		JPanel jpRight=new JPanel(new FlowLayout(FlowLayout.CENTER,-5,-1));
		jpRight.setBackground(null);
		jpRight.setOpaque(false);
		jpRight.setBounds(416, 0, 220, 52);
		
		jpRight.add(mjbTdZjxf);
		jpRight.add(mjbZdZjxf);
		jpRight.add(mjbZhuandZjxf);
		
		
		jPanel.add(jpLeft);
		jPanel.add(jpRight);
		
		
		return jPanel;
	}
	
	
	public JPanel centerContent(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		
		JPanel centerContentOfLeft=centerContentOfLeft();
		centerContentOfLeft.setBounds(5, 0, 350, 481);
		
		
		JPanel centerContentOfRight=centerContentOfRight();
		centerContentOfRight.setBounds(365, 0, 370, 478);
		
		jPanel.add(centerContentOfLeft);
		jPanel.add(centerContentOfRight);
		
		
		return jPanel;
	}
	
	public JPanel centerContentOfLeft(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setPreferredSize(new Dimension(350,20));
		jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpNorth.setBackground(new Color(180,196,139));
		jpNorth.add(new JLabel("��Ŀ�嵥"));
		
		
		
		jTabbedPane.add("������Ŀ(�嵥)",jtpXfxmQd());
		jTabbedPane.add("������Ŀ(�б�)",jtpXfxmLb());
		jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jTabbedPane.setBackground(new Color(249,246,230));
		

		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jTabbedPane, BorderLayout.CENTER);
		
		return jPanel;
	}
	
	
	public JPanel jtpXfxmQd(){
		JPanel jPanel=new JPanel(new BorderLayout());
		
		jPanel.setBackground(new Color(236,233,216));
		
		GridBagLayout gbl=new GridBagLayout();
		JPanel jpNorth=new JPanel(gbl);
		jpNorth.setBackground(null);
		jpNorth.setOpaque(false);
		jpNorth.setPreferredSize(new Dimension(350, 82));
		
		GridBagConstraints gbc1=new GBC(0, 0).setInSets(-10,-30, 0, 0);
		JLabel jl= new JLabel("��Ŀ���� / ��ƴ(Q):");
		gbl.setConstraints(jl, gbc1);
		
		GridBagConstraints gbc2=new GBC(1, 0);
		jtfXmbmOrJpXf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		gbl.setConstraints(jtfXmbmOrJpXf, gbc2);
		
		GridBagConstraints gbc3=new GBC(2, 0);
		JLabel jl1=new JLabel("����:");
		jl1.setFont(new Font("����",Font.BOLD,14));
		gbl.setConstraints(jl1, gbc3);
		
		GridBagConstraints gbc4=new GBC(3, 0);
		
		jtfBjmcXf.setFont(new Font("����",Font.BOLD,14));
		jtfBjmcXf.setForeground(new Color(0,0,255));
		jtfBjmcXf.setBorder(null);
		jtfBjmcXf.setBackground(null);
		jtfBjmcXf.setOpaque(false);
		gbl.setConstraints(jtfBjmcXf, gbc4);
		
		GridBagConstraints gbc5=new GBC(0,1).setAnchor(GBC.EAST).setInSets(-10,-30, 0, 0);
		JLabel jl2=new JLabel("��������[F2]:");
		gbl.setConstraints(jl2, gbc5);
		
		GridBagConstraints gbc6=new GBC(1, 1);
		
		jtfXfslXf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		gbl.setConstraints(jtfXfslXf, gbc6);
		
		GridBagConstraints gbc7=new GBC(2, 1, 2, 1).setAnchor(GBC.NORTHWEST);
		jbZjXfslXf.setMargin(new Insets(0, 0, 0, 0));
		jbZjXfslXf.setBackground(new Color(251,249,231));
		jbZjXfslXf.setPreferredSize(new Dimension(64,20));		
		gbl.setConstraints(jbZjXfslXf, gbc7);
		
		
		jpNorth.add(jl);
		jpNorth.add(jtfXmbmOrJpXf);
		jpNorth.add(jl1);
		jpNorth.add(jtfBjmcXf);
		jpNorth.add(jl2);
		jpNorth.add(jtfXfslXf);
		jpNorth.add(jbZjXfslXf);
		
		//----------------------------------------------------------
		Vector<Vector> rowdatasSp=null;
		GoodsDao goodsDao=new GoodsDao();
		try {
			rowdatasSp=goodsDao.queryDate1();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "���ݿ��쳣");
			e.printStackTrace();
		}
		
		jTableSp=new JTable(rowdatasSp, ColumnContent.arrayToVector(ColumnContent.SHANGPIN1_CLUMN_NAME));
		jTableSp.setFillsViewportHeight(true);
		jTableSp.setAutoCreateRowSorter(true);
		JScrollPane jScrollPane1=new JScrollPane(jTableSp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane1, BorderLayout.CENTER);
		
		
		return jPanel;
	}
	
	
	public JPanel jtpXfxmLb(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(Color.WHITE);
		
		
		return jPanel;
	}
	
	
	
	public JPanel centerContentOfRight(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.RIGHT,15,0));
		jpNorth.setPreferredSize(new Dimension(370,20));
		jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpNorth.setBackground(new Color(180,196,139));
		
		
		
		
		jtfSsXfxmjc.setPreferredSize(new Dimension(50, 16));
		jtfSsXfxmjc.setBorder(null);
		
		jpNorth.add(jlBjmcXf);
		jpNorth.add(new JLabel("�����嵥         ����[F]:"));
		jpNorth.add(jtfSsXfxmjc);
		
		//-----------------------------------------------------------------------------
		Vector<Vector> rowdataSx=new Vector<Vector>();
		Vector<Vector> rowdataYl=ZjxfDialog.rowdatasxf();
		rowdataSx.add(rowdataYl.get(0));
		rowdataSx.add(rowdataYl.get(1));
		
		//----------------------------------
		
		XfdetailDao xftDao=new XfdetailDao();
		try {
			
			xiaofeiDao xfDao=new xiaofeiDao();
			GoodsDao goodsDao=new GoodsDao();
			String bjid=MjbFjMouseListener.getQygVo().getBjid();
			XiaofeiVo xfVo=xfDao.getXfByBjid(bjid);
			
			Vector<Vector> rowdataXz=xftDao.queryXfdetailByXfid(xfVo.getXfid());
			DazheDao dzDao=new DazheDao();
			for(int i=0;i<rowdataXz.size();i++){
				Vector addrow=new Vector();
				Vector row=rowdataXz.get(i);
				int gid_row=Integer.parseInt(row.get(1).toString());
				GoodsVo dqVo=goodsDao.getDoodsByGid(gid_row);
				addrow.add(MjbFjMouseListener.getQygVo().getBjid());
				addrow.add(dqVo.getDname());
				//�۸񡣡�������
				addrow.add(dqVo.getPrice());
				
				//���۱���
				ArrayList<DazheVo> dataListDz=dzDao.queryByDzname(dqVo.getDname());
				Double dzbl=1.0;
				if(dataListDz.size()>0){
					dzbl=dataListDz.get(0).getDzremarks();
					if(dzbl==null){
						 dzbl=1.0;
					}
				}
				addrow.add(dzbl);
				addrow.add(row.get(4));
				double money=(Integer.parseInt(row.get(4).toString()))*(dqVo.getPrice())*dzbl;
				addrow.add(money);
				
				//---------------------
				if(Double.parseDouble(rowdataYl.get(1).get(2).toString())>money){
					rowdataYl.get(1).set(2, Double.parseDouble(rowdataYl.get(1).get(2).toString())-money);
				}else{
					rowdataYl.get(1).set(2,0);
				}
				//---------------------
				addrow.add(row.get(5));
				if(row.get(3)==null){
					addrow.add("*");
				}else{
					
				}
				OperatorDao odao=new OperatorDao();
				OperatorVo oVo=odao.getdataById(Integer.parseInt(row.get(6).toString()));
				addrow.add(oVo.getOname());
				
				rowdataSx.add(addrow);
				
				
			}
			
			rowdataYl.get(1).set(5, Double.parseDouble(rowdataYl.get(1).get(2).toString()));
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "���ݿ��쳣");
			e1.printStackTrace();
		}
		
		
		
		//-------------------------------------------------------------------------------
		
		jTableXfqd=new JTable(rowdataSx, ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDAN_CLUMN_NAME));
		jTableXfqd.setFillsViewportHeight(true);
		jTableXfqd.setAutoCreateRowSorter(true);
		jTableXfqd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jScrollPane2=new JScrollPane(jTableXfqd, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jScrollPane2, BorderLayout.CENTER);
		jPanel.add(RightOfSouth(), BorderLayout.SOUTH);
		
		return jPanel;
	}
	
	public JPanel RightOfSouth(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setPreferredSize(new Dimension(370, 76));
		
		
		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jp1.setBackground(null);
		jp1.setOpaque(false);
		jp1.setBounds(20,10, 328, 22);
		
		JCheckBox jcbDydhc=new JCheckBox("��ӡ�����");
		jcbDydhc.setBorder(null);
		jcbDydhc.setBackground(null);
		jcbDydhc.setOpaque(false);
		JLabel jl=new JLabel("ע: Ҫʹ�ô˹�������ϵͳ����������!");
		jl.setFont(new Font("����", Font.PLAIN, 12));
		jl.setForeground(Color.red);
		
		
		jp1.add(jcbDydhc);
		jp1.add(jl);
		
		
		
		JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
		jp2.setBackground(null);
		jp2.setOpaque(false);
		jp2.setBounds(0,40, 328, 22);
		
		JButton jbDyccxf=new JButton("��ӡ�˴�����");
		jbDyccxf.setMargin(new Insets(0, 0, 0, 0));
		jbDyccxf.setPreferredSize(new Dimension(126, 20));
		jbDyccxf.setBackground(new Color(248,245,229));
		jbDyccxf.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jbQdgb.setMargin(new Insets(0, 0, 0, 0));
		jbQdgb.setPreferredSize(new Dimension(126, 20));
		jbQdgb.setBackground(new Color(248,245,229));
		jbQdgb.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jp2.add(jbDyccxf);
		jp2.add(jbQdgb);
		
		
		
		jPanel.add(jp1);
		jPanel.add(jp2);
		
		return jPanel;
	}


	public JTextField getJtfBjmcXf() {
		return jtfBjmcXf;
	}


	public JLabel getJlBjmcXf() {
		return jlBjmcXf;
	}


	public JTextField getJtfXmbmOrJpXf() {
		return jtfXmbmOrJpXf;
	}


	public JTextField getJtfXfslXf() {
		return jtfXfslXf;
	}


	public JTextField getJtfSsXfxmjc() {
		return jtfSsXfxmjc;
	}


	public JTable getjTableSp() {
		return jTableSp;
	}


	public JTable getjTableXfqd() {
		return jTableXfqd;
	}


	public JButton getJbZjXfslXf() {
		return jbZjXfslXf;
	}
	
	
	
	public JButton getJbQdgb() {
		return jbQdgb;
	}

	
	public MyJButton getMjbLbZjxf() {
		return mjbLbZjxf;
	}


	public MyJButton getMjbSsZjxf() {
		return mjbSsZjxf;
	}


	public MyJButton getMjbJdZjxf() {
		return mjbJdZjxf;
	}


	public MyJButton getMjbTdZjxf() {
		return mjbTdZjxf;
	}


	public MyJButton getMjbZdZjxf() {
		return mjbZdZjxf;
	}


	public MyJButton getMjbZhuandZjxf() {
		return mjbZhuandZjxf;
	}
	
	
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}

	
	

	public static Vector<Vector> rowdatasxf(){
		int bjtid=MjbFjMouseListener.getQygVo().getBjtid();
		JifeiDao jfDao=new JifeiDao();
		ArrayList<ArrayList<Number>> datalist=new ArrayList<ArrayList<Number>>();
		Vector<Vector> rowdatasxf=new Vector<Vector>();
		try {
			//�Ʒ�VO
			JifeiVo jfVo=jfDao.getJfByBjtid(bjtid);
			String jfdw=jfVo.getJfdw();
			String [] str=jfdw.split(";");
			for(int i=0;i<str.length;i++){
				int sj=Integer.parseInt(str[i].substring(str[i].indexOf('-')+1, str[i].indexOf('��')));
				int xs=Integer.parseInt(str[i].substring(str[i].indexOf('ÿ')+1, str[i].indexOf('С')));
				double fy=Double.parseDouble(str[i].substring(str[i].indexOf('ʱ')+1, str[i].indexOf('Ԫ')));
				ArrayList<Number> data=new ArrayList<Number>();
				data.add(sj);
				data.add(xs);
				data.add(fy);
				datalist.add(data);
				
			}
			
			//��ǰʱ��
			java.util.Date date=new java.util.Date();
			int dqxs=Integer.parseInt(DateUtil.getStrDate(date, DateUtil.HOUR));
			
			//ѡ��ļƷ�ÿСʱǮ��
			double xzfy=0.0;
			for(int i=0;i<datalist.size();i++){
				if(dqxs<=datalist.get(i).get(0).intValue()){
					xzfy=datalist.get(i).get(2).doubleValue();
				}
			}
			
			String bjid=MjbFjMouseListener.getQygVo().getBjid();
			xiaofeiDao xfDao=new xiaofeiDao();
			//�����嵥��Vo
			XiaofeiVo xfVo=xfDao.getXfByBjid(bjid);
			//ͨ������ŵõ�����ʱ��
			Vector<Vector> rowdata=xfDao.queryXfByBjid(bjid);
			
			//Timestamp���͵�����ʱ��
			java.sql.Timestamp rzsj=new Timestamp(DateUtil.parseDate(rowdata.get(0).get(3).toString(), DateUtil.DATE_TIME).getTime());
			//Date���͵�����ʱ��
			java.util.Date resj=DateUtil.parseDate(rowdata.get(0).get(3).toString(), DateUtil.DATE_TIME);
			double bjf=0.0;
			int hour=(int)((date.getTime()-resj.getTime())/(1000*60*60));
			int minute=(int)(((date.getTime()-resj.getTime())%(1000*60*60))/(1000*60));
			if(jfVo.getBzjf()==1){
				if(minute!=0){
					hour++;
				}
				bjf=hour*xzfy;
			}else if(jfVo.getBzjf()==2){
				bjf=hour*xzfy+Math.ceil(minute/jfVo.getJfsjp())*(xzfy/(60/jfVo.getJfsjp()));
			}
			
			//===================================================================
			DazheDao dzDao=new DazheDao();
			ArrayList<DazheVo> dataListDz=dzDao.queryByDzname(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
			Double dzbl=1.0;
			if(dataListDz.size()>0){
				dzbl=dataListDz.get(0).getDzremarks();
				if(dzbl==null){
					 dzbl=1.0;
				}
			}
			//��һ�����ݡ���������
			Vector data1=new Vector();
			data1.add(xfVo.getBjid());
			data1.add("�����");
			data1.add(bjf);
			//���۱���
			data1.add(dzbl);
			//����
			data1.add(1);
			data1.add(bjf*1*dzbl);
			data1.add(rzsj);
			data1.add('*');
			//�õ�����Ա
			OperatorDao odao=new OperatorDao();
			OperatorVo oVo=odao.getdataById(xfVo.getOid());
			data1.add(oVo.getOname());
			
			//�ڶ������ݡ�������������
			Vector data2=new Vector();
			data2.add(xfVo.getBjid());
			data2.add("������Ѳ���");
			data2.add(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf());
			//���۱���
			data2.add(1.0);
			//����
			data2.add(1);
			data2.add(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf()*1);
			data2.add(rzsj);
			data2.add('*');
			data2.add(oVo.getOname());
			
			
			//=============================================
			
			rowdatasxf.add(data1);
			rowdatasxf.add(data2);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return rowdatasxf;
		
	}
	
	
	
	/*public static void main(String[] args) {
		new ZjxfDialog();
	}*/

}

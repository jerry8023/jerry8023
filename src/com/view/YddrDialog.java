package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.action.YddrDialogAction;
import com.dao.BaojianDao;
import com.dao.BaojiantypeDao;
import com.sunking.swing.JDatePicker;
import com.util.DateUtil;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.BaojianVo;
import com.vo.BaojiantypeVo;

public class YddrDialog extends JDialog{

	private static final long serialVersionUID = -2762413196863007496L;

	public static final int ZENGJIA=1;
	public static final int XIUGAI=2;
	
	public static int yongtu;
	
	
	private MyJButton mjbBc=new MyJButton("保存  [F5]").set_Background(new Color(245,242,224)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0));
	private MyJButton mjbQx=new MyJButton("取消   [F4]").set_Background(new Color(245,242,224)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0));
	private JLabel jlTitle=new JLabel("基本预定信息");
	private JTextField jtfBkxm=new JTextField(13);
	private JTextField jtfLxdh=new JTextField(13);
	private MyJComBoBox mjcbYdgg=new MyJComBoBox();
	private MyJComBoBox mjcbBjbh=new MyJComBoBox();
	private JTextField jtfYdsj=new JTextField(13);
	private JTextField jtfBlsj=new JTextField(13);
	private JTextArea jtaBz=new JTextArea(3, 15);
	private JCheckBox jcbZdqx=new JCheckBox("到达保留时间是否自动取消预订");
	
	
	

	public YddrDialog(YdglDialog owner,boolean model,int yongtu){
		
		super(owner,model);
		this.yongtu=yongtu;
		super.setSize(467,356);
		super.setLocationRelativeTo(null);
		if(this.yongtu==1){
			super.setTitle("预订登记");
		}else if(this.yongtu==2){
			super.setTitle("修改预订登记");
		}
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	public void addListener(){
		
		YddrDialogAction action=new YddrDialogAction(this);
		mjcbYdgg.addActionListener(action);
		mjbBc.addActionListener(action);
		mjbQx.addActionListener(action);
		
	}
	
	
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		
		mjbBc.setBounds(56, 290, 67, 22);
		mjbQx.setBounds(330, 290,67, 22);
		
		
		jPanel.add(contentOfCentre());
		jPanel.add(mjbBc);
		jPanel.add(mjbQx);
		
		
		
		return jPanel;
	}
	
	
	public JPanel contentOfCentre(){
		JPanel jPanel=new JPanel(new BorderLayout());
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(7, 9, 442, 266);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		jpNorth.setBackground(new Color(186,200,142));
		jpNorth.setPreferredSize(new Dimension(442, 20));
		jpNorth.add(jlTitle);
		
		
		jPanel.add(jpNorth, BorderLayout.NORTH);
		jPanel.add(jp(), BorderLayout.CENTER);
		
		
		return jPanel;
	}
	
	public JPanel jp(){
		
		GridBagLayout gbl=new GridBagLayout();
		JPanel jPanel=new JPanel(gbl);
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setPreferredSize(new Dimension(442, 246));
		
		JLabel jlBkxm=new JLabel("宾客姓名:");
		gbl.setConstraints(jlBkxm, new GBC(0, 0).setInSets(0, 10, 0, 5));
		
		
		jtfBkxm.setPreferredSize(new Dimension(137, 21));
		gbl.setConstraints(jtfBkxm, new GBC(1, 0).setInSets(0, 0, 0, 5).setAnchor(GBC.WEST));
		
		JLabel jlLxdh=new JLabel("联系电话:");
		gbl.setConstraints(jlLxdh, new GBC(2, 0).setInSets(0, 0, 0, 5));
		
		
		jtfLxdh.setPreferredSize(new Dimension(137, 21));
		gbl.setConstraints(jtfLxdh, new GBC(3, 0).setInSets(0, 0, 0, 5).setAnchor(GBC.WEST));
		
		
		
		JLabel jlYdgg=new JLabel("预定规格:");
		gbl.setConstraints(jlYdgg, new GBC(0, 1).setInSets(15, 10, 0, 5));
		
		
		
		mjcbYdgg.setBackground(Color.WHITE);
		mjcbYdgg.setPreferredSize(new Dimension(145, 21));
		gbl.setConstraints(mjcbYdgg, new GBC(1, 1).setInSets(15, 0, 0, 5).setAnchor(GBC.WEST));
		
		JLabel jlBjbh=new JLabel("包间编号:");
		gbl.setConstraints(jlBjbh, new GBC(2, 1).setInSets(15, 0, 0, 5));
		
		
		
		mjcbBjbh.setBackground(Color.WHITE);
		mjcbBjbh.setPreferredSize(new Dimension(145, 21));
		gbl.setConstraints(mjcbBjbh, new GBC(3, 1).setInSets(15, 0, 0, 5).setAnchor(GBC.WEST));
		
		
		JLabel jlYdsj=new JLabel("预抵时间:");
		gbl.setConstraints(jlYdsj, new GBC(0, 2).setInSets(15, 10, 0, 5));
		
		
		
		jtfYdsj.setPreferredSize(new Dimension(137, 21));
		gbl.setConstraints(jtfYdsj, new GBC(1, 2).setInSets(15, 0, 0, 5).setAnchor(GBC.WEST));
		
		JLabel jlBlsj=new JLabel("保留时间:");
		gbl.setConstraints(jlBlsj, new GBC(2, 2).setInSets(15, 0, 0, 5));
		
		
		jtfBlsj.setPreferredSize(new Dimension(137, 21));
		gbl.setConstraints(jtfBlsj, new GBC(3, 2).setInSets(15, 0, 0, 5).setAnchor(GBC.WEST));
		
		JLabel jlBz=new JLabel("备注:");
		gbl.setConstraints(jlBz, new GBC(0,3).setInSets(15, 10, 0, 5).setAnchor(GBC.NORTHEAST));
		
		
		jtaBz.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		gbl.setConstraints(jtaBz, new GBC(1,3,3,1).setInSets(15, 0, 0, 5).setFill(GBC.BOTH).setAnchor(GBC.WEST));
		
		
		jcbZdqx.setSelected(true);
		jcbZdqx.setFocusable(false);
		jcbZdqx.setBackground(new Color(236,233,216));
		gbl.setConstraints(jcbZdqx, new GBC(0,4,2,1).setInSets(15, 10, 0, 5));
		
		//-------------------初始化数据---------------------------
		BaojiantypeDao bjtDao=new BaojiantypeDao();
		try {
			ArrayList<BaojiantypeVo> dataList=bjtDao.getAllBaojiantype();
			for(BaojiantypeVo vo:dataList){
				mjcbYdgg.addItem(vo.getBjtname(),vo.getBjtid());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,"数据查找失败");
			e1.printStackTrace();
		}
		
		if(this.yongtu==1){
			
			mjcbBjbh.setEnabled(false);
			
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.HOUR_OF_DAY, 3);
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			jtfYdsj.setText(simpleDateFormat.format(calendar.getTime()));
			
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			jtfBlsj.setText(simpleDateFormat.format(calendar.getTime()));
			
		}else if(this.yongtu==2){
			
			YdglDialog frame=(YdglDialog)this.getParent();
			int index=frame.getJtYd().getSelectedRow();
			jtfBkxm.setText(frame.getJtYd().getValueAt(index, 1).toString());
			jtfLxdh.setText(frame.getJtYd().getValueAt(index, 2).toString());
			mjcbYdgg.setSelectedItem(frame.getJtYd().getValueAt(index, 4).toString());
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			jtfYdsj.setText(simpleDateFormat.format(DateUtil.parseDate(frame.getJtYd().getValueAt(index, 6).toString(),DateUtil.DATE_TIME)));
			jtfBlsj.setText(simpleDateFormat.format(DateUtil.parseDate(frame.getJtYd().getValueAt(index, 7).toString(),DateUtil.DATE_TIME)));
			
			//-----------------------------------------------------
			int index1=mjcbYdgg.getSelectedIndex();
			int bjtid=mjcbYdgg.getValues().get(index1);
			BaojianDao bjDao=new BaojianDao();
			mjcbBjbh.removeAllItems();
			ArrayList<BaojianVo> bjDatas=null;
			try {
				bjDatas=bjDao.getBjByBjtid(bjtid);
				Collections.sort(bjDatas);
				for(BaojianVo vo:bjDatas){
					mjcbBjbh.addItem(vo.getBjid());
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
			int flag=1;
			for(int i=0;i<bjDatas.size();i++){
				if(bjDatas.get(i).getBjid().equals(frame.getJtYd().getValueAt(index, 5).toString())){
					break;
				}
				flag++;
			}
			if(flag>=bjDatas.size()){
				mjcbBjbh.addItem(frame.getJtYd().getValueAt(index, 5).toString());
			}
			mjcbBjbh.setSelectedItem(frame.getJtYd().getValueAt(index, 5).toString());
			
			
		}
		
		//--------------------------------------------
		
		jPanel.add(jlBkxm);
		jPanel.add(jtfBkxm);
		jPanel.add(jlLxdh);
		jPanel.add(jtfLxdh);
		
		jPanel.add(jlYdgg);
		jPanel.add(mjcbYdgg);
		jPanel.add(jlBjbh);
		jPanel.add(mjcbBjbh);
		
		jPanel.add(jlYdsj);
		jPanel.add(jtfYdsj);
		jPanel.add(jlBlsj);
		jPanel.add(jtfBlsj);
		
		jPanel.add(jlBz);
		jPanel.add(jtaBz);
		
		jPanel.add(jcbZdqx);
		
		return jPanel;
	}

	
	

	public MyJButton getMjbBc() {
		return mjbBc;
	}


	public MyJButton getMjbQx() {
		return mjbQx;
	}


	public JLabel getJlTitle() {
		return jlTitle;
	}


	public JTextField getJtfBkxm() {
		return jtfBkxm;
	}


	public JTextField getJtfLxdh() {
		return jtfLxdh;
	}


	public MyJComBoBox getMjcbYdgg() {
		return mjcbYdgg;
	}


	public MyJComBoBox getMjcbBjbh() {
		return mjcbBjbh;
	}


	public JTextField getJtfYdsj() {
		return jtfYdsj;
	}


	public JTextField getJtfBlsj() {
		return jtfBlsj;
	}




	public JTextArea getJtaBz() {
		return jtaBz;
	}


	public JCheckBox getJcbZdqx() {
		return jcbZdqx;
	}
	
	
	
	

}

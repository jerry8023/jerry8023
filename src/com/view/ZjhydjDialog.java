package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.action.ZjhydjAction;
import com.dao.MgradeDao;
import com.sunking.swing.JGroupPanel;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.vo.MgradeVo;


public class ZjhydjDialog extends JDialog {

	
	private static final long serialVersionUID = -2141977697363689805L;
	
	
	public static final int ADD=1;
	public static final int UPDATE=2;
	public  int addOrUpdate=0;
	private XtszDialog  mainframe;
	private MyJButton  mjbsave=new MyJButton("保存");
	private MyJButton  mjbcancel=new MyJButton("取消");
	private JTextField jthydj=new JTextField(5);
	private JTextField jtcsjf=new JTextField(5);
	private JTextField jtqcdz=new JTextField(5);
	private JTextField jtsycs=new JTextField(10);
    
	
	
	public ZjhydjDialog(XtszDialog ower,boolean modl,int addOrUpdate){
		
	    super(ower,modl);
		
		if(addOrUpdate==ADD ||addOrUpdate==UPDATE){
			this.addOrUpdate=addOrUpdate;
			this.mainframe=ower;
			if(addOrUpdate==ADD){
				super.setTitle("增加会员等级");
			}else if(addOrUpdate==UPDATE){
				
				super.setTitle("修改会员等级");
			}
		}
		
		
		super.setSize(242,240);
		Container container=super.getContentPane();
		container.add(Noth(),BorderLayout.NORTH);
		container.add(Center(),BorderLayout.CENTER);
		addListener();
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setVisible(true);
		
	}
	
	
	
	public void addListener(){
		ZjhydjAction  action=new ZjhydjAction(this);
		mjbsave.addActionListener(action);
		mjbcancel.addActionListener(action);
		
	}
	
	
	public JPanel Noth(){
		
		JPanel  jpanel=new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setPreferredSize(new Dimension(234,90));
    	GridBagLayout gbl=new GridBagLayout();
		JPanel jp=new JPanel(gbl);
		jp.setBackground(new Color(236,233,216));

	
		
		JLabel jlhydj=new JLabel("  会员等级:");
		jlhydj.setFont(new Font("宋体",0,12));

	    gbl.setConstraints(jlhydj, new GBC(0,0).setAnchor(GBC.EAST));
		
		jthydj.setPreferredSize(new Dimension(50, 20));
		gbl.setConstraints(jthydj, new GBC(1,0));
		JLabel jljf=new JLabel("  初始积分:");
		jljf.setFont(new Font("宋体",0,12));

		gbl.setConstraints(jljf, new GBC(0,1).setAnchor(GBC.EAST));
		
		jtcsjf.setPreferredSize(new Dimension(50, 20));
		gbl.setConstraints(jtcsjf, new GBC(1,1));
		JLabel jl3=new JLabel("全场打折比例:");
		jl3.setFont(new Font("宋体",0,12));
		gbl.setConstraints(jl3, new GBC(0,2));
		
		jtqcdz.setPreferredSize(new Dimension(50, 18));
		gbl.setConstraints(jtqcdz, new GBC(1,2));
		jp.add(jlhydj);
		jp.add(jthydj);
		jp.add(jljf);
		jp.add(jtcsjf);
		jp.add(jl3);
		jp.add(jtqcdz);
		jp.setBounds(0, 13, 234, 88);
		jpanel.add(jp);
		
		//------------------------------------------
		if(this.addOrUpdate==2){
		   int index=mainframe.getjTableHydj().getSelectedRow();
		   jthydj.setText(mainframe.getjTableHydj().getValueAt(index, 1).toString());
		   jtcsjf.setText(mainframe.getjTableHydj().getValueAt(index, 2).toString());
		   jtqcdz.setText(mainframe.getjTableHydj().getValueAt(index, 3).toString());
		   int mgid=Integer.parseInt(mainframe.getjTableHydj().getValueAt(index, 0).toString());
		   MgradeDao mgDao=new MgradeDao();
		   try {
				MgradeVo mgVo = mgDao.getVoByMgid(mgid);
				if(mgVo.getUsenumber()!=null){
					jtsycs.setText(mgVo.getUsenumber().toString());
				}else{
					jtsycs.setText("");
				}
		   } catch (Exception e) {
				JOptionPane.showMessageDialog(this, "数据库异常");
				e.printStackTrace();
		   }
		
		}
		
		return jpanel;
	}
  
	
	
	public JPanel Center(){
		
		JPanel  jpanel=new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
	    JPanel jp=new JPanel(null);
	    jp.setBackground(new Color(236,233,216));
	    

        JCheckBox jccs=new JCheckBox("限制每天使用");
        jccs.setBackground(new Color(236,233,216));
		jccs.setFont(new Font("宋体", 0, 12));
		jccs.setBounds(60, 4, 100, 18);


		
        jtsycs.setBounds(160, 4, 20, 18);
		JLabel jlb=new JLabel("次");
		jlb.setBounds(185, 4, 20, 18);


		JCheckBox jczdxf=new JCheckBox("此打折比例作用最低消费");
		jczdxf.setBackground(new Color(236,233,216));
		jczdxf.setBounds(60, 30, 200, 18);
		jczdxf.setFont(new Font("宋体",0,12));


		JTextField jtcsjf=new JTextField(5);
		jtcsjf.setPreferredSize(new Dimension(10, 20));

		JLabel jl3=new JLabel("(0.8既为八折，0为免费)");
		jl3.setFont(new Font("宋体",0,12));
		jl3.setBounds(65, 55, 150, 18);
		jl3.setForeground(Color.red);
        
		
       mjbsave.setBounds(45, 85, 60, 18);
       mjbsave.setBackground(new Color(248,245,229));
       mjbcancel.setBounds(150, 85, 60, 18);
       mjbcancel.setBackground(new Color(248,245,229));

		jp.add(mjbcancel);
		jp.add(mjbsave);
		jp.add(jccs);
		jp.add(jtsycs);
		jp.add(jczdxf);
		jp.add(jl3);
		jp.add(jlb);
		jp.setBounds(0, 5, 234, 120);
		jpanel.add(jp);
		return jpanel;
	}
		
		

	public MyJButton getMjbsave() {
		return mjbsave;
	}



	public MyJButton getMjbcancel() {
		return mjbcancel;
	}



	public JTextField getJthydj() {
		return jthydj;
	}



	public JTextField getJtcsjf() {
		return jtcsjf;
	}



	public JTextField getJtqcdz() {
		return jtqcdz;
	}



	public JTextField getJtsycs() {
		return jtsycs;
	}



}

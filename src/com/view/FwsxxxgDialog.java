package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.action.FwsxxxgAction;
import com.dao.BaojiantypeDao;
import com.dao.FuwushengDao;
import com.dao.SgradeDao;
import com.view.util.MyJButton;
import com.view.util.MyJComBoBox;
import com.vo.BaojiantypeVo;
import com.vo.FuwushengVo;
import com.vo.SgradeVo;

/**
 *
 * JFrameDemo2.java:服务生信息修改界面
 * @author ZP
 * @time 2013-7-14 下午11:52:44
 * 
 */
public class FwsxxxgDialog extends JDialog {
	
	public static final int ADD=1;
	public static final int UPDATE=2;
	public static int yongtu;
	
	private static final long serialVersionUID = 7477846411142939240L;
	private JTextField jtfBh=new JTextField(10);//编号文本框
	private JComboBox jcbXb=new JComboBox(new Object[]{"男","女"});//性别文本框
	private JTextField jtfXm=new JTextField(10);//姓名文本框
	private JTextField  jtfLxdh=new JTextField();//联系方式文本框
	private JTextField jtfJp=new JTextField(10);//简拼文本框
	private JTextField jtfSfzh=new JTextField();//身份证号文本框
	private JTextArea jtaMs=new JTextArea(3, 30);//描述文本框
	private MyJComBoBox jcbFwqy=new MyJComBoBox();//服务区域下拉列表
	private MyJComBoBox jcbFwsdj=new MyJComBoBox();//服务生等级下拉列表
	
	private MyJButton mjbBcFws=new MyJButton("保存");
	private MyJButton mjbQxFws=new MyJButton("取消");
	
	
	private  XtszDialog  frame;
	
	public FwsxxxgDialog(XtszDialog owner,boolean  model,int yongtu){
		
	super(owner, model);
	this.frame=owner;
	this.yongtu=yongtu;
	this.setSize(445,360);  
	Container container=this.getContentPane();
	
	container.add(sorthPanel(),BorderLayout.SOUTH);
	container.add(centerPanel(),BorderLayout.CENTER);
	container.add(northPanel(),BorderLayout.NORTH);
	
	addListener();

	this.setLocationRelativeTo(null);//居中
	this.setResizable(false);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setResizable(false);
	if(this.yongtu==1){
		this.setTitle("增加服务生");
	}else{
		this.setTitle("信息修改");
	}
	
   }
	
	 public void addListener(){
		FwsxxxgAction fwsxxxgAction = new FwsxxxgAction(this);
		mjbBcFws.addActionListener(fwsxxxgAction);
		mjbQxFws.addActionListener(fwsxxxgAction); 
		 
	}
	
    public JPanel northPanel(){
    	
    	JPanel  jPanel=new JPanel(new BorderLayout());
    	jPanel.setBackground(new Color(236,233,216));
    	jPanel.setPreferredSize(new Dimension(420,205));
    	jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    	
    		JPanel north=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
    		north.setPreferredSize(new Dimension(421,21));//设置容器大小
    		north.setBackground(new Color(173,189,133));//设置容器背景色
    		north.add(new JLabel("基本情况"));
    		  
    		GridBagLayout gblJbqk=new GridBagLayout();
    		JPanel south=new JPanel(gblJbqk);//创建网格包布局
    		south.setPreferredSize(new Dimension(420,185));
    		south.setBackground(new Color(236,233,216));
    			//第一行第一个组件
    			JLabel  jlBh=new JLabel("编号：");
    			//为其设置约束
    			GridBagConstraints  gbcBh1=new GridBagConstraints();
    			gbcBh1.anchor=GridBagConstraints.EAST;
    			gbcBh1.gridx=0;
    			gbcBh1.gridy=0;
    			gbcBh1.insets=new Insets(15,15,7,0);
    			gblJbqk.setConstraints(jlBh, gbcBh1);
    			//第一行第二个组件
    			//JTextField jtfBh=new JTextField(10);
    			jtfBh.setPreferredSize(new Dimension(118,21));//设置文本框大小
    			jtfBh.setBorder(null);//去边框
    			jtfBh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
    			//jtfBh.setEditable(false);
    			//jtfBh.setEnabled(false);
    			
    			GridBagConstraints gbcBh2=new GridBagConstraints();
    			gbcBh2.anchor=GridBagConstraints.EAST;
    			gbcBh2.gridx=1;
    			gbcBh2.gridy=0;
    			gbcBh2.insets=new Insets(15,0,7,40);
    			
    			gblJbqk.setConstraints(jtfBh, gbcBh2);
    			//第一行第三个组件
    			JLabel jlXb=new JLabel("性别：");
    			GridBagConstraints  gbcXb1=new GridBagConstraints();
    			gbcXb1.anchor=GridBagConstraints.EAST;
    			gbcXb1.gridx=2;
    			gbcXb1.gridy=0;
    			gbcXb1.insets=new Insets(15,0,7,0 );
    			gblJbqk.setConstraints(jlXb, gbcXb1);
    			
    			//第一行第四个组件
    			//Object [] xb=new Object[]{"男","女"};
    			//JComboBox jcbXb=new JComboBox(xb);
    			jcbXb.setBackground(Color.WHITE);
    			jcbXb.setPreferredSize(new Dimension(118,21));
    			jcbXb.setBorder(null);
    			jcbXb.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
    			
    			GridBagConstraints gbcXb2=new GridBagConstraints();
    			gbcXb2.anchor=GridBagConstraints.WEST;
    			gbcXb2.gridx=3;
    			gbcXb2.gridy=0;
    			gbcXb2.insets=new Insets(15,0,7,0);
    			gblJbqk.setConstraints(jcbXb, gbcXb2);
    			
    			//第二行第一个组件
    			JLabel jlXm=new JLabel("姓名：");
    			GridBagConstraints gbcXm1=new GridBagConstraints();
    			gbcXm1.anchor=GridBagConstraints.EAST;
    			gbcXm1.gridx=0;
    			gbcXm1.gridy=1;
    			gbcXm1.insets=new Insets(0,15,7,0);
    			gblJbqk.setConstraints(jlXm, gbcXm1);
    			
    			//第二行第二个组件
    			//JTextField jtfXm=new JTextField(10);
    			jtfXm.setPreferredSize(new Dimension(118,21));//设置文本框大小
    			jtfXm.setBorder(null);//去边框
    			jtfXm.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    			
    			GridBagConstraints gbcXm2=new GridBagConstraints();
    			gbcXm2.anchor=GridBagConstraints.WEST;
    			gbcXm2.gridx=1;
    			gbcXm2.gridy=1;
    			//gbcXm2.insets=new Insets(0,0,7,27);
    			gblJbqk.setConstraints(jtfXm, gbcXm2);
    			
    			//第二行第三个组件
    			JLabel jlLxdh=new JLabel("联系电话：");
    			GridBagConstraints gbcLxdh1=new GridBagConstraints();
    			gbcLxdh1.anchor=GridBagConstraints.EAST;
    			gbcLxdh1.gridx=2;
    			gbcLxdh1.gridy=1;
    			gbcLxdh1.insets=new Insets(0, 0, 7, 0);
    			gblJbqk.setConstraints(jlLxdh, gbcLxdh1);
    			
    			//第二行第四个组件
    			//JTextField  jtfLxdh=new JTextField();
    			jtfLxdh.setPreferredSize(new Dimension(118,21));//设置文本框大小
    			jtfLxdh.setBorder(null);//去边框
    			jtfLxdh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    			
    			GridBagConstraints  gbcLxdh2=new GridBagConstraints();
    			gbcLxdh2.anchor=GridBagConstraints.WEST;
    			gbcLxdh2.gridx=3;
    			gbcLxdh2.gridy=1;
    			gbcLxdh2.insets=new Insets(0, 0, 7, 0);
    			gblJbqk.setConstraints(jtfLxdh, gbcLxdh2);
    			
    			//第三行第一个组件
    			JLabel jlJp=new JLabel("简拼：");
    			GridBagConstraints gbcJp1=new GridBagConstraints();
    			gbcJp1.anchor=GridBagConstraints.EAST;
    			gbcJp1.gridx=0;
    			gbcJp1.gridy=2;
    			gbcJp1.insets=new Insets(0,15,7,0);
    			gblJbqk.setConstraints(jlJp, gbcJp1);
    			
    			//第三行第二个组件
    			//JTextField jtfJp=new JTextField(10);
    			//jtfJp.setPreferredSize(new Dimension(118,21));//设置文本框大小
    			jtfJp.setBorder(null);//去边框
    			jtfJp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    			
    			GridBagConstraints gbcJp2=new GridBagConstraints();
    			gbcJp2.anchor=GridBagConstraints.WEST;
    			gbcJp2.gridx=1;
    			gbcJp2.gridy=2;
    			gbcJp2.insets=new Insets(5,0,2,0);
    			gblJbqk.setConstraints(jtfJp, gbcJp2);
    			
    			//第三行第三个组件
    			JLabel  jlSfzh=new JLabel("身份证号：");
    			GridBagConstraints gbcSfzh1=new GridBagConstraints();
    			gbcSfzh1.anchor=GridBagConstraints.EAST;
    			gbcSfzh1.gridx=2;
    			gbcSfzh1.gridy=2;
    			gblJbqk.setConstraints(jlSfzh, gbcSfzh1);
    			
    			//第三行第四个组件
    			//JTextField jtfSfzh=new JTextField();
    			jtfSfzh.setPreferredSize(new Dimension(118,21));//设置文本框大小
    			jtfSfzh.setBorder(null);//去边框
    			jtfSfzh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    			
    			GridBagConstraints  gbcSfzh2=new GridBagConstraints();
    			gbcSfzh2.anchor=GridBagConstraints.WEST;
    			gbcSfzh2.gridx=3;
    			gbcSfzh2.gridy=2;
    			gblJbqk.setConstraints(jtfSfzh, gbcSfzh2);
    			
    			
    			//第四行第一个组件
    		    JLabel jlMs=new JLabel("描述：");
    		    GridBagConstraints  gbcMs1=new GridBagConstraints();
    		    gbcMs1.anchor=GridBagConstraints.NORTHEAST;
    		    gbcMs1.gridx=0;
    		    gbcMs1.gridy=3;
    		    gblJbqk.setConstraints(jlMs, gbcMs1);
    		    
    		    //JTextArea
    		    //设置第四行第二个组件
    		    //JTextArea jtaMs=new JTextArea(3, 30);
    		    //jtaMs.setPreferredSize(new Dimension(334,57));
    		    jtaMs.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
    		    GridBagConstraints  gbcMs2=new GridBagConstraints();
    		    gbcMs2.anchor=GridBagConstraints.WEST;
    		    gbcMs2.gridx=1;
    		    gbcMs2.gridy=3;
    		    gbcMs2.gridwidth=3;//水平合并单元格数
    		    gbcMs2.gridheight=1;//垂直合并单元格数
    		    gbcMs2.fill=GridBagConstraints.HORIZONTAL;//水平方向扩充
    		    gbcMs2.fill=GridBagConstraints.VERTICAL;//垂直方向扩充 
    		    gbcMs2.insets=new Insets(10,0 , 9,30 );
    		    
    		    gblJbqk.setConstraints(jtaMs, gbcMs2);
    		    
    		    
    			if(this.yongtu==2){
    				int index=frame.getjTableFws().getSelectedRow();
    				jtfBh.setText(frame.getjTableFws().getValueAt(index, 0).toString());
    				jtfXm.setText(frame.getjTableFws().getValueAt(index, 1).toString());
    				jtfJp.setText(frame.getjTableFws().getValueAt(index, 2).toString());
    				jtfLxdh.setText(frame.getjTableFws().getValueAt(index, 7).toString());
    				jcbXb.setSelectedItem(frame.getjTableFws().getValueAt(index, 3));
    				jtfSfzh.setText(frame.getjTableFws().getValueAt(index, 8).toString());
    				FuwushengDao fwsDao=new FuwushengDao();
					try {
						FuwushengVo fwsVo = fwsDao.getVoByFwsid(Integer.parseInt(frame.getjTableFws().getValueAt(index, 0).toString()));
						if(fwsVo.getWfsremarks()==null){
							jtaMs.setText("");
						}else{
							jtaMs.setText(fwsVo.getWfsremarks().toString());
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "数字转换异常");
						e.printStackTrace();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, "数据库异常");
						e.printStackTrace();
					}
					jcbFwqy.setSelectedItem(frame.getjTableFws().getValueAt(index, 4).toString());
					jcbFwsdj.setSelectedItem(frame.getjTableFws().getValueAt(index, 6).toString());
					jtfBh.setEnabled(false);
    			}
    			
    		    south.add(jlBh);
    		    south.add(jtfBh);
    		    south.add(jlXb); 
    		    south.add(jcbXb); 
    		    south.add(jlXm); 
    		    south.add(jtfXm);
    		    south.add(jlLxdh);
    		    south.add(jtfLxdh);
    		    south.add(jlJp);
    		    south.add(jtfJp);
    		    south.add(jlSfzh);
    		    south.add(jtfSfzh);
    		    south.add(jlMs);
    		    south.add(jtaMs);
        
    	jPanel.add(north,BorderLayout.NORTH);
    	jPanel.add(south,BorderLayout.SOUTH);
    	
    	
		return jPanel;
    	
    	
    }    
  
   
    public JPanel centerPanel(){
    	
    	JPanel jPanel=new JPanel(new BorderLayout());
    	jPanel.setBackground(new Color(236,233,216));
    	jPanel.setPreferredSize(new Dimension(421,69));//设置容器大小
    	jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//画边框
    	
    	JPanel north=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
    	north.setBackground(new Color(236,233,216));
    	north.setPreferredSize(new Dimension(420,21));
    	north.setBackground(new Color(186,200,142));
    	north.add(new JLabel("岗位描述"));
    	
    	JPanel south=new JPanel(new FlowLayout(FlowLayout.LEFT,12,10));
    	south.setBackground(new Color(236,233,216));
    	south.add(new JLabel("服务区域："));
    	 
    	BaojiantypeDao bjtDao=new BaojiantypeDao();
    	try {
			ArrayList<BaojiantypeVo> bjtDataList=bjtDao.getAllBaojiantype();
			for(BaojiantypeVo vo:bjtDataList){
				jcbFwqy.addItem(vo.getBjtname(),vo.getBjtid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "數據庫異常");
			e.printStackTrace();
		}
    	
    	
    	jcbFwqy.setPreferredSize(new Dimension(103,23));//设置主键大小
    	jcbFwqy.setBackground(Color.WHITE);
    	south.add(jcbFwqy);
    	
    	
    	SgradeDao sgradeDao=new SgradeDao();
    	ArrayList<SgradeVo> sgDataList;
		try {
			sgDataList = sgradeDao.getAllSgrade();
			for(SgradeVo vo:sgDataList){
				jcbFwsdj.addItem(vo.getSgname(),vo.getSgid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "數據庫異常");
			e.printStackTrace();
		}
    	
    	south.add(new JLabel("服务生等级："));
    	jcbFwsdj.setPreferredSize(new Dimension(103,23));//设置主键大小
    	jcbFwsdj.setBackground(Color.WHITE);
    	south.add(jcbFwsdj);
    	
    	
    	
    	jPanel.add(north,BorderLayout.NORTH);
    	jPanel.add(south,BorderLayout.SOUTH);
		return jPanel;
    	
    	
    }
  
  
    public JPanel sorthPanel(){
    	JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,100,20));
    	jPanel.setBackground(new Color(236,233,216));
    	
    	mjbBcFws.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(67, 22));
    	mjbQxFws.set_Background(new Color(248,245,229)).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(67, 22));
	  	
    		jPanel.add(mjbBcFws);
    		jPanel.add(mjbQxFws);
    		
    	
		return jPanel;
    	
    	
    }
    
    

	public JTextField getJtfBh() {
		return jtfBh;
	}

	public JComboBox getJcbXb() {
		return jcbXb;
	}

	public JTextField getJtfXm() {
		return jtfXm;
	}

	public JTextField getJtfLxdh() {
		return jtfLxdh;
	}

	public JTextField getJtfJp() {
		return jtfJp;
	}

	public JTextField getJtfSfzh() {
		return jtfSfzh;
	}

	public JTextArea getJtaMs() {
		return jtaMs;
	}

	public MyJButton getMjbBcFws() {
		return mjbBcFws;
	}

	public MyJButton getMjbQxFws() {
		return mjbQxFws;
	}

	public MyJComBoBox getJcbFwqy() {
		return jcbFwqy;
	}

	public MyJComBoBox getJcbFwsdj() {
		return jcbFwsdj;
	}
   
	

}

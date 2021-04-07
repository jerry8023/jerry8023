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
 * JFrameDemo2.java:��������Ϣ�޸Ľ���
 * @author ZP
 * @time 2013-7-14 ����11:52:44
 * 
 */
public class FwsxxxgDialog extends JDialog {
	
	public static final int ADD=1;
	public static final int UPDATE=2;
	public static int yongtu;
	
	private static final long serialVersionUID = 7477846411142939240L;
	private JTextField jtfBh=new JTextField(10);//����ı���
	private JComboBox jcbXb=new JComboBox(new Object[]{"��","Ů"});//�Ա��ı���
	private JTextField jtfXm=new JTextField(10);//�����ı���
	private JTextField  jtfLxdh=new JTextField();//��ϵ��ʽ�ı���
	private JTextField jtfJp=new JTextField(10);//��ƴ�ı���
	private JTextField jtfSfzh=new JTextField();//���֤���ı���
	private JTextArea jtaMs=new JTextArea(3, 30);//�����ı���
	private MyJComBoBox jcbFwqy=new MyJComBoBox();//�������������б�
	private MyJComBoBox jcbFwsdj=new MyJComBoBox();//�������ȼ������б�
	
	private MyJButton mjbBcFws=new MyJButton("����");
	private MyJButton mjbQxFws=new MyJButton("ȡ��");
	
	
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

	this.setLocationRelativeTo(null);//����
	this.setResizable(false);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setResizable(false);
	if(this.yongtu==1){
		this.setTitle("���ӷ�����");
	}else{
		this.setTitle("��Ϣ�޸�");
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
    	jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    	
    		JPanel north=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
    		north.setPreferredSize(new Dimension(421,21));//����������С
    		north.setBackground(new Color(173,189,133));//������������ɫ
    		north.add(new JLabel("�������"));
    		  
    		GridBagLayout gblJbqk=new GridBagLayout();
    		JPanel south=new JPanel(gblJbqk);//�������������
    		south.setPreferredSize(new Dimension(420,185));
    		south.setBackground(new Color(236,233,216));
    			//��һ�е�һ�����
    			JLabel  jlBh=new JLabel("��ţ�");
    			//Ϊ������Լ��
    			GridBagConstraints  gbcBh1=new GridBagConstraints();
    			gbcBh1.anchor=GridBagConstraints.EAST;
    			gbcBh1.gridx=0;
    			gbcBh1.gridy=0;
    			gbcBh1.insets=new Insets(15,15,7,0);
    			gblJbqk.setConstraints(jlBh, gbcBh1);
    			//��һ�еڶ������
    			//JTextField jtfBh=new JTextField(10);
    			jtfBh.setPreferredSize(new Dimension(118,21));//�����ı����С
    			jtfBh.setBorder(null);//ȥ�߿�
    			jtfBh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
    			//jtfBh.setEditable(false);
    			//jtfBh.setEnabled(false);
    			
    			GridBagConstraints gbcBh2=new GridBagConstraints();
    			gbcBh2.anchor=GridBagConstraints.EAST;
    			gbcBh2.gridx=1;
    			gbcBh2.gridy=0;
    			gbcBh2.insets=new Insets(15,0,7,40);
    			
    			gblJbqk.setConstraints(jtfBh, gbcBh2);
    			//��һ�е��������
    			JLabel jlXb=new JLabel("�Ա�");
    			GridBagConstraints  gbcXb1=new GridBagConstraints();
    			gbcXb1.anchor=GridBagConstraints.EAST;
    			gbcXb1.gridx=2;
    			gbcXb1.gridy=0;
    			gbcXb1.insets=new Insets(15,0,7,0 );
    			gblJbqk.setConstraints(jlXb, gbcXb1);
    			
    			//��һ�е��ĸ����
    			//Object [] xb=new Object[]{"��","Ů"};
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
    			
    			//�ڶ��е�һ�����
    			JLabel jlXm=new JLabel("������");
    			GridBagConstraints gbcXm1=new GridBagConstraints();
    			gbcXm1.anchor=GridBagConstraints.EAST;
    			gbcXm1.gridx=0;
    			gbcXm1.gridy=1;
    			gbcXm1.insets=new Insets(0,15,7,0);
    			gblJbqk.setConstraints(jlXm, gbcXm1);
    			
    			//�ڶ��еڶ������
    			//JTextField jtfXm=new JTextField(10);
    			jtfXm.setPreferredSize(new Dimension(118,21));//�����ı����С
    			jtfXm.setBorder(null);//ȥ�߿�
    			jtfXm.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    			
    			GridBagConstraints gbcXm2=new GridBagConstraints();
    			gbcXm2.anchor=GridBagConstraints.WEST;
    			gbcXm2.gridx=1;
    			gbcXm2.gridy=1;
    			//gbcXm2.insets=new Insets(0,0,7,27);
    			gblJbqk.setConstraints(jtfXm, gbcXm2);
    			
    			//�ڶ��е��������
    			JLabel jlLxdh=new JLabel("��ϵ�绰��");
    			GridBagConstraints gbcLxdh1=new GridBagConstraints();
    			gbcLxdh1.anchor=GridBagConstraints.EAST;
    			gbcLxdh1.gridx=2;
    			gbcLxdh1.gridy=1;
    			gbcLxdh1.insets=new Insets(0, 0, 7, 0);
    			gblJbqk.setConstraints(jlLxdh, gbcLxdh1);
    			
    			//�ڶ��е��ĸ����
    			//JTextField  jtfLxdh=new JTextField();
    			jtfLxdh.setPreferredSize(new Dimension(118,21));//�����ı����С
    			jtfLxdh.setBorder(null);//ȥ�߿�
    			jtfLxdh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    			
    			GridBagConstraints  gbcLxdh2=new GridBagConstraints();
    			gbcLxdh2.anchor=GridBagConstraints.WEST;
    			gbcLxdh2.gridx=3;
    			gbcLxdh2.gridy=1;
    			gbcLxdh2.insets=new Insets(0, 0, 7, 0);
    			gblJbqk.setConstraints(jtfLxdh, gbcLxdh2);
    			
    			//�����е�һ�����
    			JLabel jlJp=new JLabel("��ƴ��");
    			GridBagConstraints gbcJp1=new GridBagConstraints();
    			gbcJp1.anchor=GridBagConstraints.EAST;
    			gbcJp1.gridx=0;
    			gbcJp1.gridy=2;
    			gbcJp1.insets=new Insets(0,15,7,0);
    			gblJbqk.setConstraints(jlJp, gbcJp1);
    			
    			//�����еڶ������
    			//JTextField jtfJp=new JTextField(10);
    			//jtfJp.setPreferredSize(new Dimension(118,21));//�����ı����С
    			jtfJp.setBorder(null);//ȥ�߿�
    			jtfJp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    			
    			GridBagConstraints gbcJp2=new GridBagConstraints();
    			gbcJp2.anchor=GridBagConstraints.WEST;
    			gbcJp2.gridx=1;
    			gbcJp2.gridy=2;
    			gbcJp2.insets=new Insets(5,0,2,0);
    			gblJbqk.setConstraints(jtfJp, gbcJp2);
    			
    			//�����е��������
    			JLabel  jlSfzh=new JLabel("���֤�ţ�");
    			GridBagConstraints gbcSfzh1=new GridBagConstraints();
    			gbcSfzh1.anchor=GridBagConstraints.EAST;
    			gbcSfzh1.gridx=2;
    			gbcSfzh1.gridy=2;
    			gblJbqk.setConstraints(jlSfzh, gbcSfzh1);
    			
    			//�����е��ĸ����
    			//JTextField jtfSfzh=new JTextField();
    			jtfSfzh.setPreferredSize(new Dimension(118,21));//�����ı����С
    			jtfSfzh.setBorder(null);//ȥ�߿�
    			jtfSfzh.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    			
    			GridBagConstraints  gbcSfzh2=new GridBagConstraints();
    			gbcSfzh2.anchor=GridBagConstraints.WEST;
    			gbcSfzh2.gridx=3;
    			gbcSfzh2.gridy=2;
    			gblJbqk.setConstraints(jtfSfzh, gbcSfzh2);
    			
    			
    			//�����е�һ�����
    		    JLabel jlMs=new JLabel("������");
    		    GridBagConstraints  gbcMs1=new GridBagConstraints();
    		    gbcMs1.anchor=GridBagConstraints.NORTHEAST;
    		    gbcMs1.gridx=0;
    		    gbcMs1.gridy=3;
    		    gblJbqk.setConstraints(jlMs, gbcMs1);
    		    
    		    //JTextArea
    		    //���õ����еڶ������
    		    //JTextArea jtaMs=new JTextArea(3, 30);
    		    //jtaMs.setPreferredSize(new Dimension(334,57));
    		    jtaMs.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
    		    GridBagConstraints  gbcMs2=new GridBagConstraints();
    		    gbcMs2.anchor=GridBagConstraints.WEST;
    		    gbcMs2.gridx=1;
    		    gbcMs2.gridy=3;
    		    gbcMs2.gridwidth=3;//ˮƽ�ϲ���Ԫ����
    		    gbcMs2.gridheight=1;//��ֱ�ϲ���Ԫ����
    		    gbcMs2.fill=GridBagConstraints.HORIZONTAL;//ˮƽ��������
    		    gbcMs2.fill=GridBagConstraints.VERTICAL;//��ֱ�������� 
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
						JOptionPane.showMessageDialog(this, "����ת���쳣");
						e.printStackTrace();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, "���ݿ��쳣");
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
    	jPanel.setPreferredSize(new Dimension(421,69));//����������С
    	jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));//���߿�
    	
    	JPanel north=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
    	north.setBackground(new Color(236,233,216));
    	north.setPreferredSize(new Dimension(420,21));
    	north.setBackground(new Color(186,200,142));
    	north.add(new JLabel("��λ����"));
    	
    	JPanel south=new JPanel(new FlowLayout(FlowLayout.LEFT,12,10));
    	south.setBackground(new Color(236,233,216));
    	south.add(new JLabel("��������"));
    	 
    	BaojiantypeDao bjtDao=new BaojiantypeDao();
    	try {
			ArrayList<BaojiantypeVo> bjtDataList=bjtDao.getAllBaojiantype();
			for(BaojiantypeVo vo:bjtDataList){
				jcbFwqy.addItem(vo.getBjtname(),vo.getBjtid());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "�����쮐��");
			e.printStackTrace();
		}
    	
    	
    	jcbFwqy.setPreferredSize(new Dimension(103,23));//����������С
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
			JOptionPane.showMessageDialog(this, "�����쮐��");
			e.printStackTrace();
		}
    	
    	south.add(new JLabel("�������ȼ���"));
    	jcbFwsdj.setPreferredSize(new Dimension(103,23));//����������С
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

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.action.ZjsplbAction;
import com.dao.GoodstypeDao;
import com.view.util.GBC;
import com.view.util.MyJButton;
import com.vo.GoodstypeVo;


public class ZjsplbDialog extends JDialog{
	
	
	
	private static final long serialVersionUID = 5038971909053603072L;

	JTextField  jtsplb=new JTextField(15);
	JRadioButton jabxy=new JRadioButton("��Ҫ������");
	JRadioButton jabbxy=new JRadioButton("����Ҫ������",true);
	ButtonGroup bg=  new  ButtonGroup();
	XtszDialog  mainframe;
	private MyJButton jbsave;
	private MyJButton jbcancel;
	public static final int ADD=1;
	public static final int UPDATE=2;
	public int addOrUpdate;
	private XtszDialog frame;
	
	public ZjsplbDialog(XtszDialog ower,boolean modl,int addOrUpdate){
		super(ower,modl);
		this.frame=ower;
		if(addOrUpdate==ADD ||addOrUpdate== UPDATE){
			this.addOrUpdate=addOrUpdate;
			mainframe=ower;
		    if(addOrUpdate==ADD){
		    	super.setTitle("�����Ŀ���");
		    }else if(addOrUpdate==UPDATE){
		    	super.setTitle("�޸���Ŀ���");
		    }
		
		super.setSize(335,232);
		super.setLocationRelativeTo(null);
	    Container container=super.getContentPane();
		container.add(North(),BorderLayout.CENTER);
		container.add(South(),BorderLayout.SOUTH);
		addListener();
		super.setResizable(false);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel jpNorth=new JPanel(null);
		jpNorth.setPreferredSize(new Dimension(335, 10));	
		container.add(jpNorth,BorderLayout.NORTH);
		
		super.setVisible(true);
		}else{
			throw new IllegalArgumentException("addOrUpdate��������Ϊ1��2");
		}
		
	}
	
	

	public void addListener(){
		ZjsplbAction   zjlbAction=new ZjsplbAction(this);
		jbsave.addActionListener(zjlbAction);
		jbcancel.addActionListener(zjlbAction);
		jabbxy.addActionListener(zjlbAction);
		jabxy.addActionListener(zjlbAction);
	}
	public JPanel South(){
		
		//JPanel jpanelbig=new JPanel(null);
	JPanel jpanels=new JPanel(null);
	jpanels.setBackground(new Color(236,233,216));
	jpanels.setPreferredSize(new Dimension(332,85));
	 jbsave=new MyJButton("����").set_PreferredSize(new Dimension(65,22)).set_FocusPainted(false)
 		   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));;
	 jbcancel=new MyJButton("ȡ��").set_PreferredSize(new Dimension(65,22)).set_FocusPainted(false)
 		   .set_Border(BorderFactory.createLineBorder(new Color(143,142,117))).set_Background(new Color(248,245,229));;
	//jpanels.setBackground(Color.blue);
	
	
	
	jabxy.setBackground(new Color(236,233,216));
	
	jabbxy.setBackground(new Color(236,233,216));
	
	bg.add(jabxy);
	bg.add(jabbxy);
	
	jabxy.setBounds(60, 0, 100, 20);
	jabbxy.setBounds(160, 0,110, 20);
	
	jbsave.setBounds(50, 40, 50, 20);
	jbcancel.setBounds(200, 40, 50, 20);
	jpanels.add(jbsave);
	jpanels.add(jbcancel);
	
    jpanels.add(jabxy);
   jpanels.add(jabbxy);
	//jpanelbig.add()
		return jpanels;
	}
	public JPanel North(){
	  //  JPanel jpanelbig=new JPanel(null);
	    
		GridBagLayout gbl=new GridBagLayout();
		JPanel jpanel =new JPanel(gbl);
		jpanel.setBackground(new Color(236,233,216));
		//jpanel.setBackground(Color.pink);
		//��һ�е�һ�����
		JLabel jlsplb=new JLabel("   ��Ʒ���:");
		gbl.setConstraints(jlsplb, new GBC(0,0).setAnchor(GBC.WEST));
		
		jtsplb.setPreferredSize(new Dimension(167, 21));
		gbl.setConstraints(jtsplb, new GBC(1,0).setAnchor(GBC.WEST));
		//�ڶ���
		JLabel jlxzdyj=new JLabel("ѡ���ӡ��:");
		gbl.setConstraints(jlxzdyj, new GBC(0,1).setAnchor(GBC.WEST));
		
		String [] arrayxzdyj=new String[]{"����Ŀ����ӡ�����","microsoft XPs Documnet Wri...","Fax"};
		JComboBox jcxzdyj=new JComboBox(arrayxzdyj);
		jcxzdyj.setPreferredSize(new Dimension(167, 21));
		jcxzdyj.setBackground(Color.white);
		
		gbl.setConstraints(jcxzdyj, new GBC(1,1));
		
		//������
		JLabel jldyfm=new JLabel("   ��ӡ����:");
		gbl.setConstraints(jldyfm, new GBC(0,2).setAnchor(GBC.WEST));
		//�����еڶ���
		String [] arraydyfm=new String[]{"    58   ","76    ","100","120","176"};
		JComboBox jcdyfm=new JComboBox(arraydyfm);
		jcdyfm.setPreferredSize(new Dimension(82, 21));
		jcdyfm.setBackground(Color.white);
		gbl.setConstraints(jcdyfm, new GBC(1,2).setAnchor(GBC.WEST));
		JLabel mm=new JLabel("mm");
		gbl.setConstraints(mm, new GBC(2,2).setAnchor(GBC.WEST));
		jpanel.add(jlsplb);
		jpanel.add(jtsplb);
		jpanel.add(jlxzdyj);
		jpanel.add(jcxzdyj);
		
		jpanel.add(jldyfm);
		jpanel.add(jcdyfm);
		
		if(this.addOrUpdate==2){
			jtsplb.setText(frame.getjTableSplx().getValueAt(frame.getjTableSplx().getSelectedRow(), 1).toString());
			GoodstypeDao gtDao=new GoodstypeDao();
			GoodstypeVo gtvo;
			try {
				gtvo = gtDao.getGtByGtid(Integer.parseInt(frame.getjTableSplx().getValueAt(frame.getjTableSplx().getSelectedRow(), 0).toString()));
				if(gtvo.getIsserve()==1){
					jabxy.setSelected(true);
				}else if(gtvo.getIsserve()==2){
					jabbxy.setSelected(true);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return jpanel;
	}
	
	
	
	public JTextField getJtsplb() {
		return jtsplb;
	}



	public JRadioButton getJabxy() {
		return jabxy;
	}



	public JRadioButton getJabbxy() {
		return jabbxy;
	}



	public XtszDialog getMainframe() {
		return mainframe;
	}

   

	public ButtonGroup getBg() {
		return bg;
	}



	public MyJButton getJbsave() {
		return jbsave;
	}
	public MyJButton getJbcancel() {
		return jbcancel;
	}
	

}

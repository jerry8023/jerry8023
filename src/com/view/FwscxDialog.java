package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.table.DefaultTableModel;

import com.action.FwscxAction;
import com.dao.BaojiantypeDao;
import com.dao.FuwushengDao;
import com.util.ColumnContent;
import com.vo.BaojiantypeVo;

/**
 *
 * FwscxDialog.java:服务生查询界面
 * @author czp
 * @time 2013-7-11 上午2:15:16
 * 
 */
public class FwscxDialog extends JDialog{

	
	private static final long serialVersionUID = -3006577972006255791L;

	private JButton jbCx=new JButton("查询");
	private JButton jbSx=new JButton("刷新");
	private JTextField jtf=new JTextField(7);
	private JTable jtfws;
	private JButton jbGl=new JButton("过滤");
	private JPopupMenu jPopupMenu=new JPopupMenu();
	private JButton jbDy=new JButton("打印");
	
	
	public FwscxDialog(AppMainFrame owner,boolean model){
		super(owner,model);
		super.setSize(637,487);
		super.setLocationRelativeTo(null);
		super.setTitle("服务生查询");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		addListener();
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	public void addListener(){
		
		FwscxAction action =new FwscxAction (this);
		jbCx.addActionListener(action);
		jbSx.addActionListener(action);
		jbGl.addActionListener(action);
		jbDy.addActionListener(action);
		
	}
	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		JPanel northContent=northContent();
		northContent.setBounds(0, 0,637, 47);
		
		JPanel centerContent=centerContent();
		centerContent.setBounds(5,47 ,622,408);

		
		jPanel.add(northContent);
		jPanel.add(centerContent);
		
		
		return jPanel;
		
		
	}
	
	
	public JPanel northContent(){
		JPanel jPanel= new JPanel(new FlowLayout(FlowLayout.LEFT,5,15));
		jPanel.setBackground(new Color(236,233,216));
		
		JLabel jl= new JLabel("         服务生编号 / 姓名:");
	
		
		
		jtf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117),1));
		
		
		//jbCx.setFont(new Font("宋体", Font.BOLD, 10));
		jbCx.setBackground(new Color(248,245,229));
		jbCx.setPreferredSize(new Dimension(50,20));
		jbCx.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		
		jbGl.setBackground(new Color(248,245,229));
		jbGl.setPreferredSize(new Dimension(50,20));
		jbGl.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		//----------------------------------------------------------
		BaojiantypeDao bjtDao=new BaojiantypeDao();
		try {
			ArrayList<BaojiantypeVo> datalist=bjtDao.getAllBaojiantype();
			for(final BaojiantypeVo vo:datalist){
				
				JMenuItem jmiBjt=new JMenuItem(vo.getBjtname());
				jmiBjt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						FuwushengDao fwsDao=new FuwushengDao();
						try {
							Vector<Vector> rowdatas=fwsDao.queryDate2ByBjtname(vo.getBjtname());
							DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME));
							jtfws.setModel(dtm);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(getParent(), "数据库异常");
							e1.printStackTrace();
						}
						
					}
				});
				
				jPopupMenu.add(jmiBjt);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "数据库异常");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		jbSx.setBackground(new Color(248,245,229));
		jbSx.setPreferredSize(new Dimension(50,20));
		jbSx.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		JButton jbDc=new JButton("导出");
		jbDc.setBackground(new Color(248,245,229));
		jbDc.setPreferredSize(new Dimension(50,20));
		jbDc.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jbDy.setBackground(new Color(248,245,229));
		jbDy.setPreferredSize(new Dimension(50,20));
		jbDy.setBorder(BorderFactory.createLineBorder(new Color(55,98,6)));
		
		
		jPanel.add(jl);
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
		jpTitle.setPreferredSize(new Dimension(637,18));
		jpTitle.add(new JLabel("服务生信息"));
		jpTitle.setBackground(new Color(176,192,136));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		
		Vector<Vector> rowdatafws=null;
		FuwushengDao   fwscxdao=new FuwushengDao();
		 try {
			 
			rowdatafws=fwscxdao.queryDate2();
			//rowdatacxfus=fwscxdao.q
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	    jtfws=new JTable(rowdatafws,ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME));
		jtfws.setAutoCreateRowSorter(true);
		jtfws.setFillsViewportHeight(true);
		//jtFws.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jsp=new JScrollPane(jtfws,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		jPanel.add(jpTitle,BorderLayout.NORTH);
		jPanel.add(jsp,BorderLayout.CENTER);
		
		return jPanel;
	}

	
	public JButton getJbCx() {
		return jbCx;
	}

	public JButton getJbSx() {
		return jbSx;
	}

	public JTable getJtfws() {
		return jtfws;
	}
    
	public JTextField getJtf() {
		return jtf;
	}

	public JButton getJbGl() {
		return jbGl;
	}

	public JPopupMenu getjPopupMenu() {
		return jPopupMenu;
	}

	public JButton getJbDy() {
		return jbDy;
	}

	
	

}

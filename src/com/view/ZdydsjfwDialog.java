package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dao.PreorderDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;

public class ZdydsjfwDialog extends JDialog {
	
	private JTextField jtfQssj;
	private JTextField jtfZzsj;
	private YdglDialog frame;
	
	public ZdydsjfwDialog(YdglDialog owner,boolean model){
		
		super(owner,model);
		this.frame=owner;
		super.setSize(314,205);
		super.setLocationRelativeTo(null);
		super.setTitle("指定预定时间范围");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}

	
	public JPanel content(){
		JPanel jPanel=new JPanel(null);
		jPanel.setBackground(new Color(236,233,216));
		
		jPanel.add(jp1());
		jPanel.add(jp2());
		jPanel.add(jp3());
		
		return jPanel;
	}
	
	public JPanel jp1(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(20, 34, 264, 22);
		
		jPanel.add(new JLabel("预订时间："));
		jPanel.add(new JLabel("起始 "));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -6);
		String Qssj=simpleDateFormat.format(calendar.getTime());
		jtfQssj=new JTextField(Qssj,13);
		jtfQssj.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.add(jtfQssj);
		
		return jPanel;
	}
	
	public JPanel jp2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(91, 76, 264, 22);
		
		jPanel.add(new JLabel("终止 "));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		Calendar calendar=Calendar.getInstance();
		String Qssj=simpleDateFormat.format(calendar.getTime());
		jtfZzsj=new JTextField(Qssj,13);
		jtfZzsj.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jPanel.add(jtfZzsj);
		
		return jPanel;
	}
	
	
	public JPanel jp3(){
		
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,55,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(0, 130, 264, 22);
		
		MyJButton mjbQd=new MyJButton("确定").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 21));
		MyJButton mjbQx=new MyJButton("取消").set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6))).set_FocusPainted(false).set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 21));

		
		mjbQd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
				SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String qs=jtfQssj.getText();
				String zz=jtfZzsj.getText();
				try {
					String Qssj=simpleDateFormat1.format(simpleDateFormat.parse(qs));
					String Zzsj=simpleDateFormat1.format(simpleDateFormat.parse(zz));
					PreorderDao preoDao=new PreorderDao();
					try {
						Vector<Vector> rowdatas=preoDao.queryByYdsj(Qssj,Zzsj);
						DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
						frame.getJtYd().setModel(dtm);
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
				
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(getParent(), "时间格式不正确，请重新输入");
					e1.printStackTrace();
				}
			}
		});
		
		mjbQx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		jPanel.add(mjbQd);
		jPanel.add(mjbQx);
		
		return jPanel;
	
	}
	
	
	
	
	/*public static void main(String[] args) {
		new ZdydsjfwDialog();
	}*/

}

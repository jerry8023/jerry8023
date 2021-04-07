package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JWindow;

import com.action.CajhDialogWindowAction;
import com.dao.SupplierDao;
import com.util.ColumnContent;
import com.view.util.MyJButton;

public class CajhDialogWindow extends JWindow{
	private MyJButton mjbcajhOk = new MyJButton("确定").set_Background(new Color(236,233,216)).set_Border(BorderFactory.createRaisedBevelBorder()).set_PreferredSize(new Dimension(60, 24)).set_FocusPainted(false);
	private MyJButton mjbcajhCancel = new MyJButton("取消").set_Background(new Color(236,233,216)).set_Border(BorderFactory.createRaisedBevelBorder()).set_PreferredSize(new Dimension(60, 24)).set_FocusPainted(false);
	
	private JTable jtsupplier = null;
	
	public CajhDialogWindow(CgjhDialog frame){
		super(frame);
		this.setSize(290,174);
		JTextField jtf = frame.getJtfghdw();
		int x = jtf.getX();
		int y = jtf.getY();
		this.setLocation(x+frame.getX()+8,y+frame.getY()+93);
		Container container = super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		addListener();
		this.setVisible(true);
	}
	private void addListener(){
		CajhDialogWindowAction action = new CajhDialogWindowAction(this);
		mjbcajhOk.addActionListener(action);
		mjbcajhCancel.addActionListener(action);
	}
	
	private JPanel content(){
		JPanel jpanel = new JPanel(null);
		jpanel.setBackground(new Color(236,233,216));
		jpanel.setPreferredSize(new Dimension(283,170));
		jpanel.setBorder(BorderFactory.createLineBorder(new Color(160,160,160),1));
		SupplierDao dao = new SupplierDao();
		Vector<Vector> vector = null;
		try {
			vector = dao.querysupplierData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jtsupplier = new JTable(vector,ColumnContent.arrayToVector(ColumnContent.SUPPLIER_CLUMN_NAME));
		
		jtsupplier.setAutoCreateRowSorter(true);
		jtsupplier.setFillsViewportHeight(true);
		JScrollPane jScrollPane=new JScrollPane(jtsupplier,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(3,0,285,131);
		jScrollPane.setBorder(BorderFactory.createLineBorder(new Color(160,160,160)));
		
		jpanel.add(jScrollPane);
		JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.CENTER,50,5));
		jpButton.setBackground(null);
		jpButton.setOpaque(false);
		jpButton.setBounds(3, 135, 283, 39);
		jpButton.add(mjbcajhOk);
		jpButton.add(mjbcajhCancel);
		jpanel.add(jpButton);
		
		mjbcajhOk.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mjbcajhOk.set_Border(BorderFactory.createRaisedBevelBorder());
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mjbcajhOk.set_Border(BorderFactory.createLoweredBevelBorder());
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		mjbcajhCancel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mjbcajhCancel.set_Border(BorderFactory.createRaisedBevelBorder());
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mjbcajhCancel.set_Border(BorderFactory.createLoweredBevelBorder());
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		return jpanel;
	}
	public MyJButton getMjbcajhOk() {
		return mjbcajhOk;
	}
	public MyJButton getMjbcajhCancel() {
		return mjbcajhCancel;
	}
	public JTable getJtsupplier() {
		return jtsupplier;
	}
	
}

package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.action.GkkdDialogAction;
import com.action.MjbFjMouseListener;
import com.dao.BaojianDao;
import com.dao.PreorderDao;
import com.view.util.MyJButton;
import com.vo.PreorderVo;

public class GbztDialog extends JDialog{
	
	private AppMainFrame frame;
	
	
	public GbztDialog(AppMainFrame owner,boolean model){
		
		super(owner,model);
		this.frame=owner;
		super.setSize(274,210);
		super.setLocationRelativeTo(null);
		super.setTitle("改变状态");
		super.setResizable(false);
		
		Container container = super.getContentPane();
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
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(60, 15, 165, 20);
		
		JLabel jl1=new JLabel("所选包间：");
		jl1.setFont(new Font("宋体", Font.PLAIN, 16));
		jPanel.add(jl1);
		JLabel jlSxbj=new JLabel(MjbFjMouseListener.getQygVo().getBjid());
		jlSxbj.setFont(new Font("宋体", Font.PLAIN, 16));
		jlSxbj.setForeground(Color.BLUE);
		jPanel.add(jlSxbj);
		
		return jPanel;
	}
	
	
	
	public JPanel jp2(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(60, 50, 165, 20);
		
		
		JLabel jl2=new JLabel("当前状态：");
		jl2.setFont(new Font("宋体", Font.PLAIN, 16));
		jPanel.add(jl2);
		int state=MjbFjMouseListener.getQygVo().getState();
		String str="";
		if(state==1){
			str="可供";
		}else if(state==2){
			str="停用";
		}else if(state==3){
			str="预定";
		}else if(state==4){
			str="占用";
		}
		
		JLabel jlDqzt=new JLabel(str);
		jlDqzt.setFont(new Font("宋体", Font.PLAIN, 16));
		jlDqzt.setForeground(Color.BLUE);
		jPanel.add(jlDqzt);
		
		return jPanel;
	}
	
	
	
	public JPanel jp3(){
		JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBounds(20, 90,274, 70);
		
		MyJButton mjbBwkg=new MyJButton("image/bwkg0.png", "image/bwkg1.png", "image/bwkg2.png");
		MyJButton mjbBwyd=new MyJButton("image/bwyd0.png", "image/bwyd1.png", "image/bwyd2.png");
		MyJButton mjbBwty=new MyJButton("image/bwty0.png", "image/bwty1.png", "image/bwty2.png");
		
		mjbBwkg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BaojianDao bjDao=new BaojianDao();
				if(MjbFjMouseListener.getQygVo().getState()==4){
					JOptionPane.showMessageDialog(getParent(), "没有可寄托的主单，不能改变其状态", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(MjbFjMouseListener.getQygVo().getState()==2){
					bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 1);
					GkkdDialogAction.sxBj(frame);
				}else if(MjbFjMouseListener.getQygVo().getState()==3){
					bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 1);
					PreorderDao preoDao=new PreorderDao();
					try {
						PreorderVo preoVo=preoDao.getdataById(MjbFjMouseListener.getQygVo().getBjid());
						if(preoVo!=null){
							preoDao.updateBlsjByid(MjbFjMouseListener.getQygVo().getBjid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "数据库异常");
						e1.printStackTrace();
					}
					GkkdDialogAction.sxBj(frame);
				}
					
				dispose();
			}
		});
		
		
		mjbBwyd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BaojianDao bjDao=new BaojianDao();
				if(MjbFjMouseListener.getQygVo().getState()==4){
					JOptionPane.showMessageDialog(getParent(), "没有可寄托的主单，不能改变其状态", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(MjbFjMouseListener.getQygVo().getState()==2 || MjbFjMouseListener.getQygVo().getState()==1){
					bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 3);
					GkkdDialogAction.sxBj(frame);
				}					
				dispose();
			}
		});
		
		
		mjbBwty.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BaojianDao bjDao=new BaojianDao();
				if(MjbFjMouseListener.getQygVo().getState()==4){
					JOptionPane.showMessageDialog(getParent(), "没有可寄托的主单，不能改变其状态", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(MjbFjMouseListener.getQygVo().getState()==1){
					bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 2);
					GkkdDialogAction.sxBj(frame);
				}else if(MjbFjMouseListener.getQygVo().getState()==3){
					bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 2);
					PreorderDao preoDao=new PreorderDao();
					try {
						PreorderVo preoVo=preoDao.getdataById(MjbFjMouseListener.getQygVo().getBjid());
						if(preoVo!=null){
							preoDao.updateBlsjByid(MjbFjMouseListener.getQygVo().getBjid());
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "数据库异常");
						e1.printStackTrace();
					}
					GkkdDialogAction.sxBj(frame);
				}
					
				dispose();
			}
		});
		
		
		
		jPanel.add(mjbBwkg);
		jPanel.add(mjbBwyd);
		jPanel.add(mjbBwty);
		
		
		return jPanel;
		
	}
	
	
	
	
	
	
}

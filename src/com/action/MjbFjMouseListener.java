package com.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojianDao;
import com.dao.JifeiDao;
import com.dao.PreorderDao;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.AppMainFrame;
import com.view.GkkdDialog;
import com.view.ZjxfDialog;
import com.view.util.MyJButton;
import com.vo.BaojianVo;
import com.vo.JifeiVo;
import com.vo.PreorderVo;
import com.vo.XiaofeiVo;


public class MjbFjMouseListener implements MouseListener{
	
	private MyJButton dqJButton;
	private BaojianVo dqVo;
	private static MyJButton qygButton;
	private static BaojianVo  qygVo;
	private AppMainFrame frame;
	
	public MjbFjMouseListener(MyJButton myJButton, BaojianVo dqVo,AppMainFrame frame){
		this.dqJButton=myJButton;
		this.dqVo=dqVo;
		this.frame=frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(qygButton!=null){
			
			String image1="image/";
			if(qygVo.getState()==1){
				image1+="house0.png";
			}else if(qygVo.getState()==2){
				image1+="house1.png";
			}else if(qygVo.getState()==3){
				image1+="house2.png";
			}else if(qygVo.getState()==4){
				image1+="house3.png";
			}
			qygButton.setIcon(new ImageIcon(image1));
			
		}
		
		
		String image="image/";
		if(dqVo.getState()==1){
			image+="house4.png";
		}else if(dqVo.getState()==2){
			image+="house5.png";
		}else if(dqVo.getState()==3){
			image+="house6.png";
		}else if(dqVo.getState()==4){
			image+="house7.png";
		}
		dqJButton.setIcon(new ImageIcon(image));
		qygButton=dqJButton;
		qygVo=dqVo;
		
		//-----------------------------------------------------
		if(e.getButton()==MouseEvent.BUTTON1 && e.getClickCount()==2){
			if(dqVo.getState()==1){
				
				GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
				gkkdDialog.getJtBjlx().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
				gkkdDialog.getJtZdbj().setText(MjbFjMouseListener.getQygVo().getBjid().toString());
				gkkdDialog.getJtZdxf().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
				
				JifeiDao jfDao=new JifeiDao();
				try {
					JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
					gkkdDialog.getJlBjjsff().setText(jfVo.getJfname());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				
				//gkkdDialog.setModal(true);
			}else if(dqVo.getState()==3){
				
				String id=dqVo.getBjid();
				PreorderDao poDao=new PreorderDao();
				try {
					//PreorderVo vo=poDao.getdataById(id);
					Vector<Vector> ydDatas=poDao.queryByBjid(id);
					if(ydDatas.size()!=0){
						int val=JOptionPane.showConfirmDialog(frame,  "<html>此包间已被"+"'"+ydDatas.get(0).get(3)+"'"+"预订！<br>预计在"+ydDatas.get(0).get(6)+"到达。<br>确定开单吗？<html>", "提示信息", JOptionPane.OK_CANCEL_OPTION);
						
						if(val==JOptionPane.OK_OPTION){
							
							GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
							gkkdDialog.getJtBjlx().setText(dqVo.getBaoJianType().getBjtname());
							gkkdDialog.getJtZdbj().setText(dqVo.getBjid().toString());
							gkkdDialog.getJtZdxf().setText(dqVo.getBaoJianType().getMinxf().toString());
							
							JifeiDao jfDao=new JifeiDao();
							
							try {
								JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
								gkkdDialog.getJlBjjsff().setText(jfVo.getJfname());
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(frame, "数据库异常");
								e1.printStackTrace();
							}
						}
					}else{
						int val=JOptionPane.showConfirmDialog(frame, "<html>此包间已被预订！<br>预计在到达。<br>确定开单吗？<html>", "提示信息", JOptionPane.OK_CANCEL_OPTION);
						if(val==JOptionPane.OK_OPTION){
							
							GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
							gkkdDialog.getJtBjlx().setText(dqVo.getBaoJianType().getBjtname());
							gkkdDialog.getJtZdbj().setText(dqVo.getBjid().toString());
							gkkdDialog.getJtZdxf().setText(dqVo.getBaoJianType().getMinxf().toString());
							
							JifeiDao jfDao=new JifeiDao();
							try {
								JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
								gkkdDialog.getJlBjjsff().setText(jfVo.getJfname());
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(frame, "数据库异常");
								e1.printStackTrace();
							}
							
							//gkkdDialog.setModal(true);
							
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				
			}else if(dqVo.getState()==4){
				ZjxfDialog zjxfDialog=new ZjxfDialog(frame, false);
				zjxfDialog.getJtfBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
				zjxfDialog.getJlBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
			}
		}
		
		//---------------------------------------------
		
		frame.getJlZdxf().setText(new DecimalFormat("￥#.00").format(dqVo.getBaoJianType().getMinxf()));
		JifeiDao jfDao=new JifeiDao();
		try {
			JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
			frame.getJlJfbz().setText(jfVo.getJfname());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "数据库异常");
			e1.printStackTrace();
		}
		frame.getJlJdsj().setText("");
		frame.getJlYysj().setText("");
		frame.getJlYjyj().setText("");
		frame.getJlXfje().setText("");
		frame.getJlBjid().setText(dqVo.getBaoJianType().getBjtname()+dqVo.getBjid());
		
		
		DefaultTableModel dtm=new DefaultTableModel(null, ColumnContent.arrayToVector(ColumnContent.XIAOFEI_CLUMN_NAME));
		frame.getJtXf().setModel(dtm);
		frame.getJtXf().setFillsViewportHeight(true);
		frame.getJtXf().setAutoCreateRowSorter(true);
		frame.getJtXf().getColumnModel().getColumn(5).setPreferredWidth(150);
		frame.getJtXf().getColumnModel().getColumn(6).setPreferredWidth(133);
		frame.getJtXf().getColumnModel().getColumn(7).setPreferredWidth(208);
		frame.getJtXf().getColumnModel().getColumn(8).setPreferredWidth(308);
		frame.getJtXf().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		
		
		if(dqVo.getState()==4){
			
			Double sumMoney=0.0;
			//将消费清空写入表格中。。。。。。
			Vector<Vector> rowdatas=ZjxfDialogAction.jtableSx();
			for(int i=0;i<rowdatas.size();i++){
				sumMoney+=Double.parseDouble(rowdatas.get(i).get(5).toString());
				rowdatas.get(i).remove(0);
			}
			frame.getJlXfje().setText(sumMoney.toString());
			DefaultTableModel dtm1=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.XIAOFEI_CLUMN_NAME));
			frame.getJtXf().setModel(dtm1);
			frame.getJtXf().setFillsViewportHeight(true);
			frame.getJtXf().setAutoCreateRowSorter(true);
			frame.getJtXf().getColumnModel().getColumn(5).setPreferredWidth(150);
			frame.getJtXf().getColumnModel().getColumn(6).setPreferredWidth(133);
			frame.getJtXf().getColumnModel().getColumn(7).setPreferredWidth(208);
			frame.getJtXf().getColumnModel().getColumn(8).setPreferredWidth(290);
			frame.getJtXf().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			//-----------------------------------------------
			xiaofeiDao xfDao=new xiaofeiDao();
			Vector<Vector> xfDatas;
			try {
				xfDatas = xfDao.queryXfByBjid(dqVo.getBjid());
				Date rzsj=DateUtil.parseDate(xfDatas.get(0).get(3).toString(),DateUtil.DATE_TIME);
				frame.getJlJdsj().setText(DateUtil.getStrDate(rzsj,DateUtil.DATE_TIME2));
				Date dqsj=new Date();
				int hour=(int)((dqsj.getTime()-rzsj.getTime())/(1000*60*60));
				int minute=(int)Math.ceil(((dqsj.getTime()-rzsj.getTime())%(1000*60*60))/(1000*60));
				frame.getJlYysj().setText(hour+"小时"+minute+"分");
				frame.getJlYjyj().setText(xfDatas.get(0).get(4).toString());
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
		}
		
		
		BaojianDao bjDao=new BaojianDao();
		try {
			ArrayList<BaojianVo> bjData = bjDao.getAllBaojian();
			Integer zs=bjData.size();
			Integer yd=0;
			Integer zy=0;
			Integer ty=0;
			for(BaojianVo vo:bjData){
				if(vo.getState()==2){
					ty++;
				}else if(vo.getState()==3){
					yd++;
				}else if(vo.getState()==4){
					zy++;
				}
			}
			Integer kg=zs-ty-yd-zy;
			frame.getJlBjzs().setText(zs.toString());
			frame.getJlDqzy().setText(zy.toString());
			frame.getJlDqkg().setText(kg.toString());
			frame.getJlDqty().setText(ty.toString());
			frame.getJlDqyd().setText(yd.toString());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "数据库异常");
			e1.printStackTrace();
		}
		
		
		
		//----------------------------------------------------------------------
		if(e.getButton()==MouseEvent.BUTTON3 && e.getClickCount()==1){
			//初始化。。。。。。。
			frame.getJmiBkjz().setEnabled(true);
			frame.getJmiZjxf().setEnabled(true);
			frame.getJmiDhsp().setEnabled(true);
			frame.getJmiGkkd().setEnabled(true);
			frame.getJmiXgdj().setEnabled(true);
			frame.getJmiGhbj().setEnabled(true);
			frame.getJmiBjzt().setEnabled(true);
			frame.getJmiBkyd().setEnabled(true);
			
			
			frame.getJpmYkjj().show(dqJButton, 60, 40);
			if(dqVo.getState()==1){
				frame.getJmiBkjz().setEnabled(false);
				frame.getJmiZjxf().setEnabled(false);
				frame.getJmiDhsp().setEnabled(false);
				frame.getJmiXgdj().setEnabled(false);
				frame.getJmiGhbj().setEnabled(false);
				
			}else if(dqVo.getState()==4){
				frame.getJmiGkkd().setEnabled(false);
				frame.getJmiBkyd().setEnabled(false);
			}else if(dqVo.getState()==2){
				frame.getJmiBkjz().setEnabled(false);
				frame.getJmiZjxf().setEnabled(false);
				frame.getJmiDhsp().setEnabled(false);
				frame.getJmiGkkd().setEnabled(false);
				frame.getJmiXgdj().setEnabled(false);
				frame.getJmiGhbj().setEnabled(false);
				frame.getJmiBkyd().setEnabled(false);
			}else if(dqVo.getState()==3){
				frame.getJmiBkjz().setEnabled(false);
				frame.getJmiZjxf().setEnabled(false);
				frame.getJmiDhsp().setEnabled(false);
				frame.getJmiXgdj().setEnabled(false);
				frame.getJmiGhbj().setEnabled(false);
				frame.getJmiBkyd().setEnabled(false);
			}
			
			
			
			
		}
		
		
		
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}


	public static MyJButton getQygButton() {
		return qygButton;
	}

	public static BaojianVo getQygVo() {
		return qygVo;
	}
	
	

}

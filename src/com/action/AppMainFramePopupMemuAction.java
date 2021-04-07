package com.action;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.dao.BaojianDao;
import com.dao.BaojiantypeDao;
import com.dao.xiaofeiDao;
import com.view.AppMainFrame;
import com.view.BkjzDialog;
import com.view.GbztDialog;
import com.view.GhbjDialog;
import com.view.GkkdDialog;
import com.view.YddrDialog;
import com.view.ZjxfDialog;
import com.view.util.MyJButton;
import com.vo.BaojianVo;

public class AppMainFramePopupMemuAction implements ActionListener{
	
	private AppMainFrame frame;
	//public static final int DATUBIAO=1;
	//public static final int ZHONGTUBIAO=2;
	//public static final int XIOTUBIAO=3;
	//public static int tubiaomodel=1;
	
	
	public AppMainFramePopupMemuAction(AppMainFrame frame){
		this.frame=frame;
		//this.tubiaomodel=tubiaomodel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getJmiXskg())){
			xsByState(1);
		}else if(e.getSource().equals(frame.getJmiXsty())){
			xsByState(2);
		}else if(e.getSource().equals(frame.getJmiXszy())){
			xsByState(4);
		}else if(e.getSource().equals(frame.getJmiBkjz())){
			new BkjzDialog(frame, true);
		}else if(e.getSource().equals(frame.getJmiZjxf())){
			
			ZjxfDialog zjxfDialog=new ZjxfDialog(frame, false);
			zjxfDialog.getJtfBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
			zjxfDialog.getJlBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
			
		}else if(e.getSource().equals(frame.getJmiDhsp())){
			
		}else if(e.getSource().equals(frame.getJmiGkkd())){
			GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
			gkkdDialog.getJtBjlx().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
			gkkdDialog.getJtZdbj().setText(MjbFjMouseListener.getQygVo().getBjid());
			gkkdDialog.getJtZdxf().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
			gkkdDialog.getJtSqyj().requestFocus();
			BaojiantypeDao bjtDao=new BaojiantypeDao();
			try {
				Vector<Vector> datas=bjtDao.queryDate();
				for(int i=0;i<datas.size();i++){
					if(datas.get(i).get(0).equals(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname())){
						gkkdDialog.getJlBjjsff().setText(datas.get(i).get(2).toString());
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource().equals(frame.getJmiXgdj())){
			
			GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.XGDJ);
			gkkdDialog.setTitle("修改登记");
			gkkdDialog.getJltitle().setText("开单信息");
			gkkdDialog.getJlBjjsff().setText("");
			gkkdDialog.getJtBjlx().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
			gkkdDialog.getJtZdbj().setText(MjbFjMouseListener.getQygVo().getBjid().toString());
			gkkdDialog.getJtZdxf().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
			
			xiaofeiDao xfDao=new xiaofeiDao();
			try {
				Vector<Vector> xfDatas=xfDao.queryXfByBjid(MjbFjMouseListener.getQygVo().getBjid().toString());
				gkkdDialog.getJtSqyj().setText(xfDatas.get(0).get(4).toString());
				gkkdDialog.getJtSqyj().requestFocus();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource().equals(frame.getJmiGhbj())){
			
			new GhbjDialog(frame, true);
			
		}else if(e.getSource().equals(frame.getJmiBjzt())){
			
			new GbztDialog(frame, false);
			
		}else if(e.getSource().equals(frame.getJmiBkyd())){
			YddrDialog yddrDialog=new YddrDialog(null, false, YddrDialog.ZENGJIA);
			yddrDialog.getMjcbYdgg().setSelectedItem(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
			yddrDialog.getMjcbBjbh().setSelectedItem(MjbFjMouseListener.getQygVo().getBjid());
		}
		
	}
	

	
	
	
	
	private void xsByState(int state){
		
		String bjtname="";
		if(frame.getjTabbedPane().getSelectedIndex()==0){
			frame.getJpXxbj().removeAll();
			frame.getJpXxbj().repaint();
			bjtname="小型包间";
		}else if(frame.getjTabbedPane().getSelectedIndex()==1){
			frame.getJpZxbj().removeAll();
			frame.getJpZxbj().repaint();
			bjtname="中型包间";
		}else if(frame.getjTabbedPane().getSelectedIndex()==2){
			frame.getJpDxbj().removeAll();
			frame.getJpDxbj().repaint();
			bjtname="大型包间";
		}else if(frame.getjTabbedPane().getSelectedIndex()==3){
			frame.getJpHhbj().removeAll();
			frame.getJpHhbj().repaint();
			bjtname="豪华包间";
		}
	
	
		BaojianDao bjDao=new BaojianDao();
		try {
			ArrayList<BaojianVo> bjDataList=bjDao.getAllBaojian();
			
			//房间编号的排序处理。。。。。。
			Collections.sort(bjDataList);
			
			for(BaojianVo vo:bjDataList){
				
				String bjlxName=vo.getBaoJianType().getBjtname();
				String bjName=vo.getBjid();
				int state1=vo.getState();
				if(state1!=state || !(bjlxName.equals(bjtname))){
					continue;
				}
				
				String image="image/";
				
				if(state==1){
					image+="house0.png";
				}else if(state==2){
					image+="house1.png";
				}else if(state==3){
					image+="house2.png";
				}else if(state==4){
					image+="house3.png";
				}
				
				//动态创建房间......
				MyJButton mjbFj=new MyJButton(bjName, image);
				mjbFj.set_Margin(new Insets(0, 0, 0, 0)).set_BorderPainted(false).set_Opaque(false).set_Border(null).set_ContentAreaFilled(false);
				//为房间设置鼠标监听。。。。。。
				mjbFj.addMouseListener(new MjbFjMouseListener(mjbFj,vo,frame));
				
				
				if(frame.getjTabbedPane().getSelectedIndex()==0){
					
					frame.getJpXxbj().add(mjbFj);
					
				}else if(frame.getjTabbedPane().getSelectedIndex()==1){
					
					frame.getJpZxbj().add(mjbFj);
					
				}else if(frame.getjTabbedPane().getSelectedIndex()==2){
					
					frame.getJpDxbj().add(mjbFj);
				}else if(frame.getjTabbedPane().getSelectedIndex()==3){
					
					frame.getJpHhbj().add(mjbFj);
				}
				
			}
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "数据库异常");
			e1.printStackTrace();
		}
	}
	
	
	

}

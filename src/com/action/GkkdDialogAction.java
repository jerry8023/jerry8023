package com.action;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import com.dao.BaojianDao;
import com.dao.PreorderDao;
import com.dao.xiaofeiDao;
import com.util.DateUtil;
import com.view.AppMainFrame;
import com.view.GkkdDialog;
import com.view.util.MyJButton;
import com.vo.BaojianVo;



public class GkkdDialogAction implements ActionListener {
	
	
	private GkkdDialog frame;
	
	public GkkdDialogAction(GkkdDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getJbQd())){
			
			Date date=new Date();
			String xfid="XF"+DateUtil.getStrDate(date, DateUtil.DATE_TIME1);
			
			Object[]values=new Object[]{xfid,MjbFjMouseListener.getQygVo().getBjid(),LoginAction.getDqOid(),new java.sql.Timestamp(date.getTime()),Double.parseDouble(frame.getJtSqyj().getText()),2};
			
			xiaofeiDao xfDao=new xiaofeiDao();
			BaojianDao bjDao=new BaojianDao();
			
			if(GkkdDialog.yongtu==1){
				
				int val=xfDao.insertXf(values);
				int res=bjDao.update(MjbFjMouseListener.getQygVo().getBjid());
				if(val>0 && res>0){
					if(MjbFjMouseListener.getQygVo().getState()==3){
						PreorderDao poDao=new PreorderDao();
						try {
							Vector<Vector> ydDatas=poDao.queryByBjid(MjbFjMouseListener.getQygVo().getBjid());
							if(ydDatas.size()!=0){
								poDao.updateBlsjByid(MjbFjMouseListener.getQygVo().getBjid());
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
							e1.printStackTrace();
						}
						
					}
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(frame, "����ʧ��");
					return;
				}
				//----------------ˢ�°���-------------------------------
				sxBj((AppMainFrame)frame.getParent());
				
			}else if(GkkdDialog.yongtu==2){
				
				try {
					Vector<Vector> xfDatas=xfDao.queryXfByBjid(MjbFjMouseListener.getQygVo().getBjid());
					int val=xfDao.updateYajin(Double.parseDouble(frame.getJtSqyj().getText()), xfDatas.get(0).get(0).toString());
					if(val==0){
						JOptionPane.showMessageDialog(frame, "�޸ĵǼ�ʧ��");
						return;
					}else{
						frame.dispose();
					}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
					e1.printStackTrace();
				}
				
			}
			
			
		}else if(e.getSource().equals(frame.getJbQx())){
			frame.dispose();
		}
		
	}
	
	
	
	
	public static  void sxBj(AppMainFrame appMainFrame){
		
		//AppMainFrame appMainFrame=(AppMainFrame)frame.getParent();
		appMainFrame.getJpXxbj().removeAll();
		appMainFrame.getJpZxbj().removeAll();
		appMainFrame.getJpDxbj().removeAll();
		appMainFrame.getJpHhbj().removeAll();
		
		
		BaojianDao bjDao=new BaojianDao();
		try {
			ArrayList<BaojianVo> bjDataList=bjDao.getAllBaojian();
			
			//�����ŵ�����������������
			Collections.sort(bjDataList);
			
			for(BaojianVo vo:bjDataList){
				
				String bjlxName=vo.getBaoJianType().getBjtname();
				String bjName=vo.getBjid();
				int state=vo.getState();
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
				
				//��̬��������......
				MyJButton mjbFj=new MyJButton(bjName, image);
				mjbFj.set_Margin(new Insets(0, 0, 0, 0)).set_BorderPainted(false).set_Opaque(false).set_Border(null).set_ContentAreaFilled(false);
				//Ϊ��������������������������
				mjbFj.addMouseListener(new MjbFjMouseListener(mjbFj,vo,appMainFrame));
				
				
				if(bjlxName.equals("С�Ͱ���")){
					
					appMainFrame.getJpXxbj().add(mjbFj);
					
				}else if(bjlxName.equals("���Ͱ���")){
					
					appMainFrame.getJpZxbj().add(mjbFj);
					
				}else if(bjlxName.equals("���Ͱ���")){
					
					appMainFrame.getJpDxbj().add(mjbFj);
				}else if(bjlxName.equals("��������")){
					
					appMainFrame.getJpHhbj().add(mjbFj);
				}
				
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(appMainFrame, "���ݿ��쳣");
			e1.printStackTrace();
		}
		
	}

	
	
}

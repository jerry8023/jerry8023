package com.action;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.ws.Response;

import com.dao.JifeiDao;
import com.dao.PreorderDao;
import com.util.DateUtil;
import com.view.AppMainFrame;
import com.view.BkjzDialog;
import com.view.CwglDialog;
import com.view.FwscxDialog;
import com.view.GkkdDialog;
import com.view.HyglDialog;
import com.view.Login;
import com.view.SpglDialog;
import com.view.XtszDialog;
import com.view.YdglDialog;
import com.view.YycxDialog;
import com.view.ZjxfDialog;
import com.vo.JifeiVo;
import com.vo.PreorderVo;

public class AppMainFrameAction implements ActionListener{
	
	private AppMainFrame frame;
	
	public AppMainFrameAction(AppMainFrame frame){
		this.frame=frame;
	}

	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMjbGkkd())){
			
			if(MjbFjMouseListener.getQygButton()==null){
				JOptionPane.showMessageDialog(frame, "��ѡ�����󿪵���");
				return;
			}
			
			if(MjbFjMouseListener.getQygVo().getState()==2||MjbFjMouseListener.getQygVo().getState()==4){
				JOptionPane.showMessageDialog(frame, "�˰��䴦�ڷǿɹ�״̬��");
				return;
			}
			
			if(MjbFjMouseListener.getQygVo().getState()==3){
				String id=MjbFjMouseListener.getQygVo().getBjid();
				PreorderDao poDao=new PreorderDao();
				try {
					PreorderVo vo=poDao.getdataById(id);
					if(vo!=null){
						int val=JOptionPane.showConfirmDialog(frame,  "<html>�˰����ѱ�"+vo.getPoname()+"Ԥ����<br>Ԥ����"+vo.getYdsj()+"���<br>ȷ��������<html>", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
						
					}else{
						int val=JOptionPane.showConfirmDialog(frame, "<html>�˰����ѱ�Ԥ����<br>Ԥ���ڵ��<br>ȷ��������<html>", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
						if(val==JOptionPane.OK_OPTION){
							GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
							gkkdDialog.getJtBjlx().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
							gkkdDialog.getJtZdbj().setText(MjbFjMouseListener.getQygVo().getBjid().toString());
							gkkdDialog.getJtZdxf().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
							
							JifeiDao jfDao=new JifeiDao();
							try {
								JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
								gkkdDialog.getJlBjjsff().setText(jfVo.getJfname());
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
								e1.printStackTrace();
							}
							
							//gkkdDialog.setModal(true);
							
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
					e1.printStackTrace();
				}
				
			}else{
				GkkdDialog gkkdDialog=new GkkdDialog(frame, false,GkkdDialog.GKKD);
				gkkdDialog.getJtBjlx().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtname());
				gkkdDialog.getJtZdbj().setText(MjbFjMouseListener.getQygVo().getBjid().toString());
				gkkdDialog.getJtZdxf().setText(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf().toString());
				
				JifeiDao jfDao=new JifeiDao();
				try {
					JifeiVo jfVo=jfDao.getJfByBjtid(MjbFjMouseListener.getQygVo().getBaoJianType().getBjtid());
					gkkdDialog.getJlBjjsff().setText(jfVo.getJfname());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
					e1.printStackTrace();
				}
				
				//gkkdDialog.setModal(true);
				
			}
			
		}else if(e.getSource().equals(frame.getMjbYdgl())){
			
			new YdglDialog(frame, false);
			
		}else if(e.getSource().equals(frame.getMjbBkjz())){
			
			if(MjbFjMouseListener.getQygButton()==null||MjbFjMouseListener.getQygVo().getState()==1||MjbFjMouseListener.getQygVo().getState()==2||MjbFjMouseListener.getQygVo().getState()==3){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ���˵ı���!", "��ʾ��Ϣ", JOptionPane.NO_OPTION);
				return;
			}
			
			new BkjzDialog(frame, true);
		
		}else if(e.getSource().equals(frame.getMjbZjxf())){
			
			if(MjbFjMouseListener.getQygButton()==null||MjbFjMouseListener.getQygVo().getState()==1||MjbFjMouseListener.getQygVo().getState()==2||MjbFjMouseListener.getQygVo().getState()==3){
				JOptionPane.showMessageDialog(frame, "���ܶԴ��ڷ�ռ��״̬�İ�����д������!", "��ʾ��Ϣ", JOptionPane.NO_OPTION);
				return;
			}
			
			ZjxfDialog zjxfDialog=new ZjxfDialog(frame, false);
			zjxfDialog.getJtfBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
			zjxfDialog.getJlBjmcXf().setText(MjbFjMouseListener.getQygVo().getBjid());
			
			
		}else if(e.getSource().equals(frame.getMjbHygl())){
			new HyglDialog(frame,false);
		}else if(e.getSource().equals(frame.getMjbFwsgl())){
			new FwscxDialog(frame, false);
		}else if(e.getSource().equals(frame.getMjbYycx())){
			new YycxDialog(frame, true);
		}else if(e.getSource().equals(frame.getMjbCwgl())){
			new CwglDialog(frame,true);
		}else if(e.getSource().equals(frame.getMjbHbdr())){
			int response=JOptionPane.showConfirmDialog(frame, "ȷ��������", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
			if(response==JOptionPane.YES_OPTION){
				LoginAction.flag=LoginAction.HUANBAN;
				LoginAction.ylFrame=frame;
				new Login();
				
			}
		}else if(e.getSource().equals(frame.getMjbSpgl())){
			new SpglDialog(frame,false);
		}else if(e.getSource().equals(frame.getMjbXtsz())){
			new XtszDialog(frame,true);
		}else if(e.getSource().equals(frame.getMjbTcxt())){
			int response=JOptionPane.showConfirmDialog(frame, "���Ҫ�˳���ϵͳ��", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
			if(response==JOptionPane.YES_OPTION){
				//frame.dispose();
				System.exit(0);
			}
		}else if(e.getSource().equals(frame.getMjbJsq())){
			Desktop desktop=Desktop.getDesktop();
			try {
				desktop.open(new File("C:\\windows\\system32\\calc.exe"));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "�ܱ�Ǹ��δ�ܴ�ϵͳ�Դ��ļ�����!","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(frame.getMjbClear())){
			int val=JOptionPane.showConfirmDialog(frame, "��ȷ��Ҫ��ձ�ǩ��?", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(val==JOptionPane.OK_OPTION){
				frame.getJta().setText("");
			}
		}else if(e.getSource().equals(frame.getMjbTime())){
			frame.getJta().append("---"+DateUtil.getStrDate(new Date(), DateUtil.DATE_TIME)+"---\n");
		
		}else if(e.getSource().equals(frame.getMjbGlzt())){
			frame.getJpmGlzt().show(frame.getMjbGlzt(), 60,25);
		}else if(e.getSource().equals(frame.getMjbCkfs())){
			frame.getJpmCkfs().show(frame.getMjbCkfs(),60,25);
		}else if(e.getSource().equals(frame.getMjbXsqb()) || e.getSource().equals(frame.getMjbSxxs())){
			GkkdDialogAction.sxBj(frame);
		}
		
		
	}

}

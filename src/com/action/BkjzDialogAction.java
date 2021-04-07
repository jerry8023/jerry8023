package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.dao.BaojianDao;
import com.dao.JiezhangDao;
import com.dao.MemberDao;
import com.dao.xiaofeiDao;
import com.util.DateUtil;
import com.view.AppMainFrame;
import com.view.BkjzDialog;
import com.vo.XiaofeiVo;

public class BkjzDialogAction implements ActionListener{
	
	private BkjzDialog frame;
	
	public BkjzDialogAction(BkjzDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbHybh())){
			JOptionPane.showMessageDialog(frame, "���Ӷ�����ʧ��","��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource().equals(frame.getMjbJz())){
			
			int val=JOptionPane.showConfirmDialog(frame, "ȷ��Ҫ������?", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			
			if(val==JOptionPane.OK_OPTION){
			
				String jzid=frame.getJlJzdh().getText();
				Integer mid=null; 
				if(!frame.getJtfHybh().isEnabled()){
					mid=Integer.parseInt(frame.getJtfHybh().getText());
				}
				xiaofeiDao xfDao=new xiaofeiDao();
				XiaofeiVo xfVo = null;
				try {
					xfVo=xfDao.getXfByBjid(MjbFjMouseListener.getQygVo().getBjid());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "���ݿ��쳣","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				String xfid=xfVo.getXfid();
				Double xfje=Double.parseDouble(frame.getJlXfje().getText());
				Double ysje=Double.parseDouble(frame.getJlYsje().getText());
				Double ssje=Double.parseDouble(frame.getJtfSsjr().getText());
				Double bkzf=0.0;
				if(frame.getJtfBkzf().getText()==null||frame.getJtfBkzf().getText().length()==0){
					 bkzf=0.0;
				}else{
					bkzf=Double.parseDouble(frame.getJtfBkzf().getText());
				}
				
				if(ssje>bkzf &&(!frame.getJcbGz().isSelected()) && (!frame.getJcbMf().isSelected()) && (!frame.getJcbTd().isSelected())){
					JOptionPane.showMessageDialog(frame, "������㣬���ܽ��ˡ���Ҫǩ����ֱ���޸�ʵ�ս��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					frame.getJtfBkzf().requestFocus();
					return;
				}
				
				Integer oid=LoginAction.getDqOid();
				java.sql.Timestamp jzdate=new java.sql.Timestamp(new Date().getTime());
				//���˷�ʽ������������������
				//1����2����3���4�˵�
				Integer jzfs=1;
				if(frame.getJcbGz().isSelected()){
					if(frame.getJtfHybh().isEnabled()){
						JOptionPane.showMessageDialog(frame, "������Ҫ���˵Ļ�Ա��ź���ѡ�����!","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						frame.getJtfHybh().requestFocus();
						frame.getJcbGz().setSelected(false);
						return;
					}
					jzfs=2;
				}else if(frame.getJcbMf().isSelected()){
					jzfs=3;
				}else if(frame.getJcbTd().isSelected()){
					jzfs=4;
				}
				//���˱�ע
				String state=null;
				
				//����˱��������
				Object[] values=new Object[]{jzid,mid,xfid,xfje,ysje,ssje,bkzf,oid,jzdate,jzfs,state};
				JiezhangDao jzDao=new JiezhangDao();
				int res=jzDao.insertJz(values);
				if(res==0){
					JOptionPane.showConfirmDialog(frame, "����ʧ��", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				//���İ��䡣���ѱ��״̬����������
				BaojianDao bjDao=new BaojianDao();
				bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 1);
				//1���㣬2δ���㡣��������
				xfDao.updateState(xfVo.getXfid(), 1);
				
				//ˢ�°��䡣����������������
				GkkdDialogAction.sxBj((AppMainFrame)frame.getParent());
				
				//���ּ��㣨ǰ�᣺�ù˿�Ϊ��Ա��������������������ͨ��ϵͳ���õĻ������õ�ֵ������֡���������������Ĭ�Ͽɻ�����ÿ����100��һ�֡���������
				if(mid!=null){
					Double jfbl=100.0;
					MemberDao mDao=new MemberDao();
					mDao.updateJfAndSb(xfje, mid, jfbl);
				}
				
				
				
				frame.dispose();
				
				
				
			}
			
			
		}else if(e.getSource().equals(frame.getMjbQx())){
			frame.dispose();
		}else if(e.getSource().equals(frame.getJcbMf()) || e.getSource().equals(frame.getJcbGz()) || e.getSource().equals(frame.getJcbTd())){
			
			frame.getJtfSsjr().setText("0.00");
			frame.getJtfSsjr().setEnabled(false);
			frame.getJtfBkzf().setText("0.00");
			frame.getJtfBkzf().setEnabled(false);
			
		}
		
	}

	
	
	
}

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
			JOptionPane.showMessageDialog(frame, "连接读卡器失败","提示信息", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource().equals(frame.getMjbJz())){
			
			int val=JOptionPane.showConfirmDialog(frame, "确定要结账吗?", "提示信息", JOptionPane.OK_CANCEL_OPTION);
			
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
					JOptionPane.showMessageDialog(frame, "数据库异常","提示信息",JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(frame, "付款金额不足，不能结账。若要签单请直接修改实收金额!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					frame.getJtfBkzf().requestFocus();
					return;
				}
				
				Integer oid=LoginAction.getDqOid();
				java.sql.Timestamp jzdate=new java.sql.Timestamp(new Date().getTime());
				//结账方式。。。。。。。。。
				//1结账2挂账3免费4退单
				Integer jzfs=1;
				if(frame.getJcbGz().isSelected()){
					if(frame.getJtfHybh().isEnabled()){
						JOptionPane.showMessageDialog(frame, "请输入要挂账的会员编号后再选择挂账!","提示信息",JOptionPane.INFORMATION_MESSAGE);
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
				//结账备注
				String state=null;
				
				//向结账表插入数据
				Object[] values=new Object[]{jzid,mid,xfid,xfje,ysje,ssje,bkzf,oid,jzdate,jzfs,state};
				JiezhangDao jzDao=new JiezhangDao();
				int res=jzDao.insertJz(values);
				if(res==0){
					JOptionPane.showConfirmDialog(frame, "结账失败", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				//更改包间。消费表的状态。。。。。
				BaojianDao bjDao=new BaojianDao();
				bjDao.updateState(MjbFjMouseListener.getQygVo().getBjid(), 1);
				//1结算，2未结算。。。。。
				xfDao.updateState(xfVo.getXfid(), 1);
				
				//刷新包间。。。。。。。。。
				GkkdDialogAction.sxBj((AppMainFrame)frame.getParent());
				
				//积分计算（前提：该顾客为会员！）。。。。。。。。通过系统设置的积分设置的值计算积分。。。。。。以下默认可积分且每消费100积一分。。。。。
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

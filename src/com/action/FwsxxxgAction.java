package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.FuwushengDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.FwsxxxgDialog;
import com.view.XtszDialog;
import com.vo.FuwushengVo;

public class FwsxxxgAction implements ActionListener {

	private FwsxxxgDialog  frame;
	
	public FwsxxxgAction(FwsxxxgDialog frame){
		this.frame=frame;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Integer fwsBh=0;
		if(e.getSource().equals(frame.getMjbBcFws())){
			if(FwsxxxgDialog.yongtu==1) {
				String bh=frame.getJtfBh().getText();
				if(bh.length()==0||bh==null){
					JOptionPane.showMessageDialog(frame, "编号不能为空!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					frame.getJtfBh().requestFocus();
					return;
				}
				if(!YanZhengUtil.isShuZi(bh)){
					JOptionPane.showMessageDialog(frame, "服务生编号必须为整数!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					frame.getJtfBh().setText("");
					frame.getJtfBh().requestFocus();
					return;
				}else{
					fwsBh=Integer.parseInt(bh);
					FuwushengDao fwsDao=new FuwushengDao();
					try {
						ArrayList<FuwushengVo> fwsDataList=fwsDao.queryAllData();
						for(FuwushengVo vo:fwsDataList){
							if(vo.getFwsid()==fwsBh){
								JOptionPane.showMessageDialog(frame, "此编号已存在,请重新编号!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
								frame.getJtfBh().setText("");
								frame.getJtfBh().requestFocus();
								return;
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
					
				}
			}else if(FwsxxxgDialog.yongtu==2){
				fwsBh=Integer.parseInt(frame.getJtfBh().getText());
			}
			Integer bjtid=frame.getJcbFwqy().getValues().get(frame.getJcbFwqy().getSelectedIndex());
			Integer sgid=frame.getJcbFwsdj().getValues().get(frame.getJcbFwsdj().getSelectedIndex());
			String fwsName=frame.getJtfXm().getText();
			if(fwsName.length()==0){
				JOptionPane.showMessageDialog(frame, "姓名不能为空");
				frame.getJtfXm().requestFocus();
				return;
			}
			String fwsJp=frame.getJtfJp().getText();
			if(fwsJp.length()==0){
				JOptionPane.showMessageDialog(frame, "简拼不能为空");
				frame.getJtfJp().requestFocus();
				return;
			}
			String fwsSex=frame.getJcbXb().getSelectedItem().toString();
			String fwsLxfs=frame.getJtfLxdh().getText();
			if(fwsLxfs.length()==0){
				JOptionPane.showMessageDialog(frame, "联系电话不能为空");
				frame.getJtfLxdh().requestFocus();
				return;
			}
			String fwsSfz=frame.getJtfSfzh().getText();
			if(fwsSfz.length()==0){
				JOptionPane.showMessageDialog(frame, "身份证号不能为空");
				frame.getJtfSfzh().requestFocus();
				return;
			}
			String remarks=frame.getJtaMs().getText();
			if(remarks.length()==0 || remarks==null){
				 remarks=null;
			}
			
			int val=0;
			FuwushengDao fwsDao=new FuwushengDao();
			if(FwsxxxgDialog.yongtu==1){
				Object[] values=new Object[]{fwsBh,sgid,bjtid,fwsName,fwsJp,fwsSex,fwsLxfs,fwsSfz,remarks};
				val=fwsDao.insertData(values);
			}else if(FwsxxxgDialog.yongtu==2){
				Object[] values=new Object[]{sgid,bjtid,fwsName,fwsJp,fwsSex,fwsLxfs,fwsSfz,remarks,fwsBh};
				val=fwsDao.updateData(values);
			}
			if(val<=0){
				if(FwsxxxgDialog.yongtu==1){
					JOptionPane.showMessageDialog(frame, "添加失败", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(FwsxxxgDialog.yongtu==2){
					JOptionPane.showMessageDialog(frame, "修改失败", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}else{
				try {
					Vector<Vector> rowdatas=fwsDao.queryDate();
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.FUWUSHENG1_CLUMN_NAME));
					((XtszDialog)frame.getParent()).getjTableFws().setModel(dtm);
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
			}
			
		}else if(e.getSource().equals(frame.getMjbQxFws())){
			
			frame.dispose();
		}
	
	}
	
}

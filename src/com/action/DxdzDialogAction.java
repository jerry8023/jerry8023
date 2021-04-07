package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.dao.DazheDao;
import com.dao.MgradeDao;
import com.view.DxdzDialog;
import com.view.XtszDialog;
import com.vo.DazheVo;
import com.vo.MgradeVo;

public class DxdzDialogAction implements ActionListener{
	
	private DxdzDialog frame;
	
	public DxdzDialogAction(DxdzDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		XtszDialog xtszDialog=(XtszDialog)frame.getParent();
		MgradeDao mgDao=new MgradeDao();
		DazheDao dzDao=new DazheDao();
		if(e.getSource().equals(frame.getMjbSavedxdz())){
			Double ptbkdzbl;
			if(frame.getJtfdzbldx().getText().toString().equals("无")){
				ptbkdzbl=null;
			}else{
				ptbkdzbl=Double.parseDouble(frame.getJtfdzbldx().getText().toString());
			}
			//int index=xtszDialog.getjTableBjlx().getSelectedRow();
			//String dzname=xtszDialog.getjTableBjlx().getValueAt(index, 0).toString();
			int index=0;
			String dzname="";
			if(DxdzDialog.yongtu==1){
				index=xtszDialog.getjTableBjlx().getSelectedRow();
				dzname=xtszDialog.getjTableBjlx().getValueAt(index, 0).toString();
			}else if(DxdzDialog.yongtu==2){
				index=xtszDialog.getjTableSp().getSelectedRow();
				dzname=xtszDialog.getjTableSp().getValueAt(index, 1).toString();
			}
			Vector<Vector> rowdatas=frame.rowdatas;
			for(Vector vector:rowdatas){
				try {
					int mgid = mgDao.getVoByMgname(vector.get(0).toString()).getMgid();
					ArrayList<DazheVo> datalist=dzDao.getVoByDznameAndMgname(dzname, mgid);
					if(datalist.size()==0){
						if(!vector.get(1).toString().equals("无")){
							dzDao.insertData(new Object[]{dzname,mgid,Double.parseDouble(vector.get(1).toString()),ptbkdzbl});
						}
					}else{
						if(!vector.get(1).toString().equals("无")){
							//更新
							dzDao.updateData(new Object[]{Double.parseDouble(vector.get(1).toString()),ptbkdzbl,frame.getJtfxmmcdx().getText(),mgid});
						}else{
							//删除
							dzDao.deleteData(frame.getJtfxmmcdx().getText(), mgid);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
			}
			frame.dispose();
		}else if (e.getSource().equals(frame.getMjbQcdzdxdz())){
			int index=0;
			String dzname="";
			if(DxdzDialog.yongtu==1){
				index=xtszDialog.getjTableBjlx().getSelectedRow();
				dzname=xtszDialog.getjTableBjlx().getValueAt(index, 0).toString();
			}else if(DxdzDialog.yongtu==2){
				index=xtszDialog.getjTableSp().getSelectedRow();
				dzname=xtszDialog.getjTableSp().getValueAt(index, 1).toString();
			}			
			Vector<Vector> rowdatas=frame.rowdatas;
			for(Vector vector:rowdatas){
				try {
					int mgid = mgDao.getVoByMgname(vector.get(0).toString()).getMgid();
					ArrayList<DazheVo> datalist=dzDao.getVoByDznameAndMgname(dzname, mgid);
					if(datalist.size()!=0){
						dzDao.deleteData(frame.getJtfxmmcdx().getText(), mgid);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
			}
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbExitdxdx())){
			frame.dispose();
		}
		
	}

}

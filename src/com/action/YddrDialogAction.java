package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojianDao;
import com.dao.PreorderDao;
import com.util.ColumnContent;
import com.view.AppMainFrame;
import com.view.YddrDialog;
import com.view.YdglDialog;
import com.vo.BaojianVo;
import com.vo.PreorderVo;

public class YddrDialogAction implements ActionListener{
	
	
	private YddrDialog frame;
	
	public YddrDialogAction( YddrDialog frame){
		this.frame=frame;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMjcbYdgg())){
			
			
			frame.getMjcbBjbh().setEnabled(true);
			int index=frame.getMjcbYdgg().getSelectedIndex();
			int bjtid=frame.getMjcbYdgg().getValues().get(index);
			BaojianDao bjDao=new BaojianDao();
			frame.getMjcbBjbh().removeAllItems();
			try {
				ArrayList<BaojianVo> bjDatas=bjDao.getBjByBjtid(bjtid);
				Collections.sort(bjDatas);
				for(BaojianVo vo:bjDatas){
					frame.getMjcbBjbh().addItem(vo.getBjid());
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource().equals(frame.getMjbBc())){
			String bkxm=frame.getJtfBkxm().getText();
			if(bkxm==null||bkxm.length()==0){
				bkxm="无";
			}
			String lxdh=frame.getJtfLxdh().getText();
			if(lxdh==null||lxdh.length()==0){
				lxdh="无";
			}
			if(frame.getMjcbYdgg().getSelectedIndex()==-1){
				JOptionPane.showMessageDialog(frame, "请选择预定规格!", "提示信息", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(frame.getMjcbBjbh().getSelectedIndex()==-1){
				JOptionPane.showMessageDialog(frame, "请选择包间编号!", "提示信息", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String bjid=frame.getMjcbBjbh().getSelectedItem().toString();
			String bz=frame.getJtaBz().getText();
			if(bz==null ||bz.length()==0){
				bz=null;
			}
			
			
			Date Ydsj=null;
			Date Blsj=null;
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			try {
				Ydsj=simpleDateFormat.parse(frame.getJtfYdsj().getText());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(frame, "时间错误，请检查");
				return;
			}
			
			try {
				Blsj=simpleDateFormat.parse(frame.getJtfBlsj().getText());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(frame, "时间错误，请检查");
				return;
			}
			
			java.sql.Timestamp timeYdsj=new Timestamp(Ydsj.getTime());
			java.sql.Timestamp timeBlsj=new Timestamp(Blsj.getTime());
			
			if(YddrDialog.yongtu==1){
				
				Object[] values=new Object[]{bjid,LoginAction.getDqOid(),bkxm,lxdh,timeYdsj,timeBlsj,bz};
				PreorderDao preoDao=new PreorderDao();
				int res=preoDao.insertData(values);
				if(res<=0){
					JOptionPane.showMessageDialog(frame, "预定失败");
				}else{
					try {
						//刷新表。。。。。
						Vector<Vector> ydDatas=preoDao.queryData();
						DefaultTableModel dtm=new DefaultTableModel(ydDatas, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
						((YdglDialog)frame.getParent()).getJtYd().setModel(dtm);
						
						new BaojianDao().updateState(bjid, 3);
						GkkdDialogAction.sxBj((AppMainFrame)(frame.getParent().getParent()));
						
						frame.dispose();
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
					
				}
				
			}else if(YddrDialog.yongtu==2){
				
				PreorderDao preoDao=new PreorderDao();
				PreorderVo preVo=null;
				YdglDialog ydglDialog=(YdglDialog)frame.getParent();
				int selectedRow=ydglDialog.getJtYd().getSelectedRow();
				BaojianDao bjDao=new BaojianDao();
				try {
					BaojianVo bjVo=bjDao.getBjByBjid(bjid);
					if(bjVo.getState()==2 || bjVo.getState()==4){
						JOptionPane.showMessageDialog(frame,bjid+"处于非空闲状态,不能被预订!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(bjVo.getState()==3){
						preVo=preoDao.getdataById(bjid);
						if(preVo==null){
							JOptionPane.showMessageDialog(frame,bjid+"处于非空闲状态,不能被预订!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				
				Object[] values=new Object[]{bjid,LoginAction.getDqOid(),bkxm,lxdh,timeYdsj,timeBlsj,bz,Integer.parseInt(ydglDialog.getJtYd().getValueAt(selectedRow, 0).toString())};
				int val=preoDao.updateData(values);
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "修改失败");
				}else{
					//刷新。。。。。
					Vector<Vector> ydDatas = null;
					try {
						ydDatas = preoDao.queryData();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
					DefaultTableModel dtm=new DefaultTableModel(ydDatas, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
					((YdglDialog)frame.getParent()).getJtYd().setModel(dtm);
					
					frame.dispose();
				}
				
			}
			
			
		}else if(e.getSource().equals(frame.getMjbQx())){
			frame.dispose();
		}
			
		
	}

	

}

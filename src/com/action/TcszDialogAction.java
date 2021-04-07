package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.SgradeDao;
import com.dao.TichengDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.TcszDialog;
import com.view.XtszDialog;
import com.view.util.MyJButton;
import com.vo.SgradeVo;
import com.vo.TichengVo;

public class TcszDialogAction implements ActionListener{
	
	private TcszDialog frame;
	
	public TcszDialogAction(TcszDialog frame){
		this.frame=frame;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMjbTjTc())){
			 
			String ld=frame.getJtld_ticheng().getText();
			Double ldtc=0.0;
			if(ld.matches("[0-9]*[.]?[0-9]+")){
				ldtc=Double.parseDouble(ld);
			}else{
				JOptionPane.showMessageDialog(frame, "轮单提成必须为数字");
				return;
			}
			
			String dd=frame.getJtdd_ticheng().getText();
			Double ddtc=0.0;
			if(dd.matches("[0-9]*[.]?[0-9]+")){
				ddtc=Double.parseDouble(dd);
			}else{
				JOptionPane.showMessageDialog(frame, "点单提成必须为数字");
				return;
			}
			
			Vector vector=new Vector();
			vector.add(frame.getJcb_ticheng().getSelectedItem().toString());
			vector.add(ldtc);
			vector.add(ddtc);
			
		    Vector<Vector> datas=TcszDialog.rowdatas;
		    boolean flag=false;
			for(int i=0;i<datas.size();i++){
				if(datas.get(i).get(0).toString().equals(frame.getJcb_ticheng().getSelectedItem().toString())){
					datas.get(i).set(1, ldtc);
					datas.get(i).set(2, ddtc);
					flag=true;
				}
			}
			
			if(!flag){
				datas.add(vector);
			}
			
			TcszDialog.rowdatas=  datas;
			DefaultTableModel dtm=new DefaultTableModel(TcszDialog.rowdatas, ColumnContent.arrayToVector(ColumnContent.TICHENG_CLUMN_NAME));
			frame.getJtable_ticheng().setModel(dtm);

		}else if(e.getSource().equals(frame.getMjScTc())){
			int index=frame.getJtable_ticheng().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "请选择要删除的一行", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else{
				String fwsdj=frame.getJtable_ticheng().getValueAt(index, 0).toString();
				  Vector<Vector> datas=TcszDialog.rowdatas;
				  for(int i=0;i<datas.size();i++){
					  if(datas.get(i).get(0).toString().equals(fwsdj)){
						  datas.remove(i);
						  break;
					  }
				  }
				  TcszDialog.rowdatas= datas;
				  DefaultTableModel dtm=new DefaultTableModel(TcszDialog.rowdatas, ColumnContent.arrayToVector(ColumnContent.TICHENG_CLUMN_NAME));
				  frame.getJtable_ticheng().setModel(dtm);
			}
		}else if(e.getSource().equals(frame.getJbsave_ticheng())){
			
			TichengDao tcDao=new TichengDao();
			SgradeDao sgDao=new SgradeDao();
			XtszDialog xtszDialog=(XtszDialog)frame.getParent();
		    int gid=Integer.parseInt(xtszDialog.getjTableSp().getValueAt(xtszDialog.getjTableSp().getSelectedRow(), 0).toString());
		    Vector<Vector> datas=TcszDialog.rowdatas;
		    
		    try {
				ArrayList<SgradeVo> rowdatas=sgDao.getAllSgrade();
				for(int i=0;i<rowdatas.size();i++){
					boolean mark=false;
					  for(int j=0;j<datas.size();j++){
						  if(rowdatas.get(i).getSgname().equals(datas.get(j).get(0).toString())){
							  mark=true;
							  break;
						  }
					  }
					  if(!mark){
						  try {
							tcDao.deleteDataByGidAndSgid(gid,rowdatas.get(i).getSgid());
							mark=false;
						  } catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, "數據庫異常");
							e1.printStackTrace();
						}
					  }
					  
				  }
				  
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e2.printStackTrace();
			}
		    
		  
			  for(int i=0;i<datas.size();i++){
				  try {
					SgradeVo sgVo=sgDao.getVoBySgname(datas.get(i).get(0).toString());
					Integer sgid=sgVo.getSgid();
					ArrayList<TichengVo>  tcDataList=tcDao.getVoByGidAndSgid(gid, sgid);
					if(tcDataList.size()==0){
						//插入
						tcDao.insertData(new Object[]{gid,sgid,Double.parseDouble(datas.get(i).get(1).toString()),Double.parseDouble(datas.get(i).get(2).toString())});
					}else{
						//更新
						tcDao.updateData(new Object[]{Double.parseDouble(datas.get(i).get(1).toString()),Double.parseDouble(datas.get(i).get(2).toString()),gid,sgid});
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				  
			  }
			  frame.dispose();
			  
		}else if(e.getSource().equals(frame.getJbdelete_ticheng())){
			frame.dispose();
		}
		
	}

}

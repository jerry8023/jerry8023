package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.StorehouseDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.CkszDialog;
import com.view.CkszZsgDialog;
import com.view.XtszDialog;
import com.vo.StorehouseVo;

public class CkszZsgAction implements ActionListener{

	private CkszZsgDialog ckszZsgDialog;
	
	private CkszDialog  parent;
	
	private JTable ckszDialogTable;
	
	public CkszZsgAction(CkszZsgDialog ckszZsgDialog){
		
	    this.ckszZsgDialog=ckszZsgDialog;
	    this.parent=(CkszDialog) ckszZsgDialog.getParent();
	}
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource().equals(ckszZsgDialog.getJbQd())){
			
			if(ckszZsgDialog.getAddorUpdate()==CkszZsgDialog.ADD){
				//���������ݽ���֤
				
				StorehouseVo  storehouseVo=new StorehouseVo();
				
				String strshid=ckszZsgDialog.getJtfCkbh().getText();
				if(strshid.length()==0){
					JOptionPane.showMessageDialog(ckszZsgDialog, "�ֿ��Ų���Ϊ��!");
					return;
				}
				if(YanZhengUtil.isShuZi(strshid)){
					int shid=Integer.parseInt(strshid.toString());
					StorehouseDao shDao=new StorehouseDao();
					ArrayList<StorehouseVo> shDataList;
					try {
						shDataList = shDao.queryData();
						for(StorehouseVo shvo:shDataList){
							if(shvo.getShid()==shid){
								JOptionPane.showMessageDialog(ckszZsgDialog, "�ֿ����Ѿ�����!");
								return;
							}
							
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(ckszZsgDialog, "���ݿ��쳣");
					}
						
					storehouseVo.setShid(Integer.parseInt(strshid.toString()));
				
				}else{
					
					JOptionPane.showMessageDialog(ckszZsgDialog, "�ֿ��ű���Ϊ����");
					return;
				}
				
				String strshname=ckszZsgDialog.getJtfCkmc().getText();
				
				storehouseVo.setShname(strshname);
				
				//��������
				StorehouseDao   storehouseDao=new StorehouseDao();
				boolean flag=storehouseDao.addStorehouse(storehouseVo);
				if(flag==true){
					//JOptionPane.showMessageDialog(ckszZsgDialog, "��ӳɹ���");
					ckszZsgDialog.dispose();//��ӳɹ���ر����ҳ��
					parent=(CkszDialog) ckszZsgDialog.getParent();
					
					ckszDialogTable=parent.getJtCk();
					
					Vector<Vector> data=null;
					try {
						data=storehouseDao.queryStoreData();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ckszZsgDialog, "��ѯʧ�ܣ�");
						e1.printStackTrace();
						return;
					}
					
					//ˢ�±��е�ֵ
					DefaultTableModel dtm=new DefaultTableModel(data, ColumnContent.arrayToVector(ColumnContent.CANGKU_CLUMN_NAME));
					
					ckszDialogTable.setModel(dtm);
					 
				}else{
					
					JOptionPane.showMessageDialog(ckszZsgDialog, "���ʧ�ܣ�");
					return;
				}
				
			}else if(ckszZsgDialog.getAddorUpdate()==CkszZsgDialog.UPDATE){
				
				JTable jTable=parent.getJtCk();
				StorehouseVo  storehouseVo=new StorehouseVo();
				
				 int selectedRow=jTable.getSelectedRow();
				 
				 if(selectedRow!=-1){
					 	String strshid=ckszZsgDialog.getJtfCkbh().getText();
						if(YanZhengUtil.isShuZi(strshid)){
							storehouseVo.setShid(Integer.parseInt(strshid.toString()));
						}else{
							JOptionPane.showMessageDialog(ckszZsgDialog, "�ֿ��ű���Ϊ����");
							return;
						}
						String strshname=ckszZsgDialog.getJtfCkmc().getText();
						storehouseVo.setShname(strshname);
					 
				 }else {
					 JOptionPane.showMessageDialog(ckszZsgDialog, "��ѡ��Ҫ�޸ĵ����ݣ�");
					 return;
				 }
				 
				 
				 StorehouseDao  storehouseDao=new StorehouseDao();
				 boolean  flag=storehouseDao.updateStorehouse(storehouseVo);
				 if(flag==true){
					 //JOptionPane.showMessageDialog(ckszZsgDialog, "�޸ĳɹ���");
					 ckszZsgDialog.dispose();
					 
					 CkszDialog  parent=(CkszDialog) ckszZsgDialog.getParent();
					 JTable ckszTable=parent.getJtCk();
					 
					 Vector<Vector> data=null;
					 
					 try {
						data=storehouseDao.queryStoreData();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ckszZsgDialog, "��ѯʧ�ܣ�");
						e1.printStackTrace();
						return;
					}
					  
					 DefaultTableModel dtm = new DefaultTableModel( data, ColumnContent
								.arrayToVector(ColumnContent.CANGKU_CLUMN_NAME));
					 ckszTable.setModel(dtm);
					 
				 }else{
					 
					 JOptionPane.showMessageDialog(ckszZsgDialog, "�޸�ʧ�ܣ�");
				 }
				 
				
			}
			
			
		}else if(e.getSource().equals(ckszZsgDialog.getJbQx())){
			
			ckszZsgDialog.dispose();
			
		}
		
	}

	
}

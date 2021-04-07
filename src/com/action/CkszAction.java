package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.StorehouseDao;
import com.jdbc.util.JdbcTemplate;
import com.util.ColumnContent;
import com.view.BmckszDialog;
import com.view.CkszDialog;
import com.view.CkszZsgDialog;
import com.vo.StorehouseVo;

public class CkszAction implements ActionListener {

	
	private CkszDialog ckszDialog;
	
	public CkszAction(CkszDialog ckszDialog){
		
		this.ckszDialog=ckszDialog;
	}
	 
	public void actionPerformed(ActionEvent e) {
		JTable  storehouseTable= ckszDialog.getJtCk();
		
		if(e.getSource().equals(ckszDialog.getJbTjCk())){
			
			new CkszZsgDialog(ckszDialog,true,CkszZsgDialog.ADD);
			
		}else if(e.getSource().equals(ckszDialog.getJbXgCk())){
			
			int selectedRow=storehouseTable.getSelectedRow();//�õ�ѡ����
			if(selectedRow==-1){
				JOptionPane.showMessageDialog(ckszDialog, "��ѡ��Ҫ�޸ĵ�����");
				return;
			}
			new CkszZsgDialog(ckszDialog,true,CkszZsgDialog.UPDATE);
			
		}else if(e.getSource().equals(ckszDialog.getJbScCk())){
			
			int selectedRow=storehouseTable.getSelectedRow();//��ñ�ѡ���У�δѡ�з���-1��
			if(selectedRow!=-1){
				Object  values1=storehouseTable.getValueAt(selectedRow, 0);
				int val=JOptionPane.showConfirmDialog(ckszDialog, "ȷ��Ҫɾ����������!","��ʾ��Ϣ",JOptionPane.OK_CANCEL_OPTION);
				if(val==JOptionPane.OK_OPTION){
					StorehouseVo  storehouseVo=new StorehouseVo();
					storehouseVo.setShid(Integer.parseInt(values1.toString()));
					StorehouseDao  storehouseDao=new StorehouseDao();
					boolean flag=storehouseDao.deleteStorehouse(storehouseVo);
					if(flag==true){
						
						//JOptionPane.showMessageDialog(ckszDialog, "ɾ���ɹ��� ");
						
						//ˢ�±�������
						
						JTable jTable=ckszDialog.getJtCk();
						
						Vector<Vector> data=null;
						
						try {
							data=storehouseDao.queryStoreData();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(ckszDialog, "��ѯʧ�ܣ�");
							e1.printStackTrace();
							return;
						}
						
						DefaultTableModel dtm=new DefaultTableModel(data, ColumnContent.arrayToVector(ColumnContent.CANGKU_CLUMN_NAME));
						jTable.setModel(dtm);
						
					}else{
						
						JOptionPane.showMessageDialog(ckszDialog, "ɾ��ʧ�ܣ�");
					}
					
				}
			}else{
					
				JOptionPane.showMessageDialog(ckszDialog, "��ѡ����Ҫɾ�������ݣ�");
			}
				
		}else if(e.getSource().equals(ckszDialog.getJbBjssckCk())){
			
			//new BmckszDialog(ckszDialog,true);
		}
	     
	
	}
	 
}

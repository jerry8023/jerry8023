package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.Option;

import com.dao.SgradeDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.XtszDialog;
import com.view.ZjfwsdjDialog;
import com.vo.SgradeVo;

public class ZjfwsdjAction implements ActionListener{

	private ZjfwsdjDialog   zjfwsdjDialog;
	private XtszDialog  parent;
	private  JTable  xtszDialogTable;
	
	public ZjfwsdjAction(ZjfwsdjDialog   zjfwsdjDialog){
		
		this.zjfwsdjDialog=zjfwsdjDialog;
		this.parent=(XtszDialog) zjfwsdjDialog.getParent();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		 
		
		if(e.getSource().equals(zjfwsdjDialog.getMjbBcFwsdj())){ 
		 
			 if(ZjfwsdjDialog.addOrUpdate==ZjfwsdjDialog.ADD){
				 SgradeDao sgDao=new SgradeDao();
				 SgradeVo  sgradeVo=new  SgradeVo();
				 String strSgname=zjfwsdjDialog.getJtfFwsdj().getText();
				 String  strSgid =  zjfwsdjDialog.getJtfDjbh().getText();
				 if(strSgid.matches("[0-9]+")){
					 try {
						ArrayList<SgradeVo> sgdatas=sgDao.getAllSgrade();
						for(SgradeVo vo:sgdatas){
							if(Integer.parseInt(strSgid)==vo.getSgid() || strSgname.equals(vo.getSgname())){
								JOptionPane.showMessageDialog(zjfwsdjDialog, "�˵ȼ���Ż�������ȼ��Ѵ���!","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
								zjfwsdjDialog.getJtfFwsdj().setText("");
								zjfwsdjDialog.getJtfDjbh().setText("");
								zjfwsdjDialog.getJtfDjbh().requestFocus();
								return;
							}
						}
						sgradeVo.setSgid(Integer.parseInt(strSgid));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(zjfwsdjDialog, "���ݿ��쳣");
						e1.printStackTrace();
					}
			
				 }else {
					 JOptionPane.showMessageDialog(zjfwsdjDialog, "Ա����ű���Ϊ����");
					 return;
				 }
		
				 //�������  ����������ݽ���У��
				 sgradeVo.setSgname(strSgname);
		 
				 //��������
		 
				 SgradeDao  sgradeDao=new SgradeDao();
				 boolean flage = sgradeDao.saveSgrade(sgradeVo);	
				 //System.out.println("-------------");
				 if(flage==true){
					 //JOptionPane.showMessageDialog(zjfwsdjDialog, "---------��ӳɹ���");
					 //ˢ�±��е�ֵ
					 parent=(XtszDialog) zjfwsdjDialog.getParent();
					 xtszDialogTable=parent.getjTableFwsdj();
					 Vector<Vector> data=null;
					 try {
						 data=sgradeDao.querySgrade();
					 } catch (Exception e1) {  
						 JOptionPane.showMessageDialog(zjfwsdjDialog, "��ѯʧ�ܣ�");
						 e1.printStackTrace();
						 return;
					 }
					 //ˢ��xtszDialogTable�е�ֵ
					 DefaultTableModel dtm=new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
					 xtszDialogTable.setModel(dtm);
					 zjfwsdjDialog.dispose();
				 }else{
					 JOptionPane.showMessageDialog(zjfwsdjDialog, "���ʧ�ܣ�");
				 }
				 
	   }else if(zjfwsdjDialog.addOrUpdate==ZjfwsdjDialog.UPDATE){
	
	   // JOptionPane.showMessageDialog(zjfwsdjDialog, "��ִ���޸Ĳ�����");
	      
	    JTable jTable=parent.getjTableFwsdj();
	    
	    SgradeVo sgradeVo=new SgradeVo();
	    
	    int selectedRow=jTable.getSelectedRow();
	      
	    if(selectedRow!=-1){
	    	 SgradeDao sgDao=new SgradeDao();
	    	 String strSgname=zjfwsdjDialog.getJtfFwsdj().getText();
	    	 String  strSgid =  zjfwsdjDialog.getJtfDjbh().getText();
			 if(strSgid.matches("[0-9]+")){
				 try {
						ArrayList<SgradeVo> sgdatas=sgDao.getAllSgrade();
						for(SgradeVo vo:sgdatas){
							if( strSgname.equals(vo.getSgname()) && (!strSgname.equals(parent.getjTableFwsdj().getValueAt(parent.getjTableFwsdj().getSelectedRow(), 1).toString()))){
								JOptionPane.showMessageDialog(zjfwsdjDialog, "�˵ȼ���Ż�������ȼ��Ѵ���!","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
								zjfwsdjDialog.getJtfFwsdj().setText(parent.getjTableFwsdj().getValueAt(parent.getjTableFwsdj().getSelectedRow(), 1).toString());
								zjfwsdjDialog.getJtfDjbh().setText(parent.getjTableFwsdj().getValueAt(parent.getjTableFwsdj().getSelectedRow(), 0).toString());
								zjfwsdjDialog.getJtfFwsdj().requestFocus();
								return;
							}
						}
						sgradeVo.setSgid(Integer.parseInt(strSgid));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(zjfwsdjDialog, "���ݿ��쳣");
						e1.printStackTrace();
					}
				//sgradeVo.setSgid(Integer.parseInt(strSgid));
				
			}else {
				JOptionPane.showMessageDialog(zjfwsdjDialog, "Ա����ű���Ϊ����");
			}
			
			//�������  ����������ݽ���У��
			 sgradeVo.setSgname(strSgname);
	    }else{
	    	 
	    	JOptionPane.showMessageDialog(zjfwsdjDialog, "��ѡ��Ҫ�޸ĵ�����");
	    	return;
	    }
	    
	    SgradeDao sgradeDao=new SgradeDao();
	    
	    boolean flag= sgradeDao.updateSgrade(sgradeVo);
	    
	    if(flag==true){

	    	//JOptionPane.showMessageDialog(zjfwsdjDialog, "�޸ĳɹ���");
	    	
	    	
	    	XtszDialog   parent=(XtszDialog) zjfwsdjDialog.getParent();
		    JTable xtszTable=parent.getjTableFwsdj();
		    
		    Vector<Vector> data=null;
		    
		    try {
				data=sgradeDao.querySgrade();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(zjfwsdjDialog, "��ѯʧ�ܣ�");
				e1.printStackTrace();
				return;
				
			}
		    DefaultTableModel dtm = new DefaultTableModel( data, ColumnContent
							.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
			xtszTable.setModel(dtm);
			zjfwsdjDialog.dispose();
			
         }else{
        	 JOptionPane.showMessageDialog(zjfwsdjDialog, "�޸�ʧ�ܣ�");
         }
          
	   }
	 
	    
		
	}	else if(e.getSource().equals(zjfwsdjDialog.getMjbQxFwsdj())){
		
		zjfwsdjDialog.dispose();
		
		
	
	}
		
	}}



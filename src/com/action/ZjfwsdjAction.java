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
								JOptionPane.showMessageDialog(zjfwsdjDialog, "此等级编号或服务生等级已存在!","提示信息",JOptionPane.INFORMATION_MESSAGE);
								zjfwsdjDialog.getJtfFwsdj().setText("");
								zjfwsdjDialog.getJtfDjbh().setText("");
								zjfwsdjDialog.getJtfDjbh().requestFocus();
								return;
							}
						}
						sgradeVo.setSgid(Integer.parseInt(strSgid));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(zjfwsdjDialog, "数据库异常");
						e1.printStackTrace();
					}
			
				 }else {
					 JOptionPane.showMessageDialog(zjfwsdjDialog, "员工编号必须为整数");
					 return;
				 }
		
				 //保存操作  对输入的数据进行校验
				 sgradeVo.setSgname(strSgname);
		 
				 //保存数据
		 
				 SgradeDao  sgradeDao=new SgradeDao();
				 boolean flage = sgradeDao.saveSgrade(sgradeVo);	
				 //System.out.println("-------------");
				 if(flage==true){
					 //JOptionPane.showMessageDialog(zjfwsdjDialog, "---------添加成功！");
					 //刷新表中的值
					 parent=(XtszDialog) zjfwsdjDialog.getParent();
					 xtszDialogTable=parent.getjTableFwsdj();
					 Vector<Vector> data=null;
					 try {
						 data=sgradeDao.querySgrade();
					 } catch (Exception e1) {  
						 JOptionPane.showMessageDialog(zjfwsdjDialog, "查询失败！");
						 e1.printStackTrace();
						 return;
					 }
					 //刷新xtszDialogTable中的值
					 DefaultTableModel dtm=new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
					 xtszDialogTable.setModel(dtm);
					 zjfwsdjDialog.dispose();
				 }else{
					 JOptionPane.showMessageDialog(zjfwsdjDialog, "添加失败！");
				 }
				 
	   }else if(zjfwsdjDialog.addOrUpdate==ZjfwsdjDialog.UPDATE){
	
	   // JOptionPane.showMessageDialog(zjfwsdjDialog, "请执行修改操作！");
	      
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
								JOptionPane.showMessageDialog(zjfwsdjDialog, "此等级编号或服务生等级已存在!","提示信息",JOptionPane.INFORMATION_MESSAGE);
								zjfwsdjDialog.getJtfFwsdj().setText(parent.getjTableFwsdj().getValueAt(parent.getjTableFwsdj().getSelectedRow(), 1).toString());
								zjfwsdjDialog.getJtfDjbh().setText(parent.getjTableFwsdj().getValueAt(parent.getjTableFwsdj().getSelectedRow(), 0).toString());
								zjfwsdjDialog.getJtfFwsdj().requestFocus();
								return;
							}
						}
						sgradeVo.setSgid(Integer.parseInt(strSgid));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(zjfwsdjDialog, "数据库异常");
						e1.printStackTrace();
					}
				//sgradeVo.setSgid(Integer.parseInt(strSgid));
				
			}else {
				JOptionPane.showMessageDialog(zjfwsdjDialog, "员工编号必须为整數");
			}
			
			//保存操作  对输入的数据进行校验
			 sgradeVo.setSgname(strSgname);
	    }else{
	    	 
	    	JOptionPane.showMessageDialog(zjfwsdjDialog, "请选择要修改的数据");
	    	return;
	    }
	    
	    SgradeDao sgradeDao=new SgradeDao();
	    
	    boolean flag= sgradeDao.updateSgrade(sgradeVo);
	    
	    if(flag==true){

	    	//JOptionPane.showMessageDialog(zjfwsdjDialog, "修改成功！");
	    	
	    	
	    	XtszDialog   parent=(XtszDialog) zjfwsdjDialog.getParent();
		    JTable xtszTable=parent.getjTableFwsdj();
		    
		    Vector<Vector> data=null;
		    
		    try {
				data=sgradeDao.querySgrade();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(zjfwsdjDialog, "查询失败！");
				e1.printStackTrace();
				return;
				
			}
		    DefaultTableModel dtm = new DefaultTableModel( data, ColumnContent
							.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
			xtszTable.setModel(dtm);
			zjfwsdjDialog.dispose();
			
         }else{
        	 JOptionPane.showMessageDialog(zjfwsdjDialog, "修改失败！");
         }
          
	   }
	 
	    
		
	}	else if(e.getSource().equals(zjfwsdjDialog.getMjbQxFwsdj())){
		
		zjfwsdjDialog.dispose();
		
		
	
	}
		
	}}



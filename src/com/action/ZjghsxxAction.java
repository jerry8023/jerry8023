package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.GhsxxDao;
import com.util.ColumnContent;
import com.view.GhsxxDialog;
import com.view.ZjghsxxDialog;
import com.vo.SupplierVo;


public class ZjghsxxAction implements ActionListener {
     
	private ZjghsxxDialog dialog;
	private GhsxxDialog parent;
	
	GhsxxDao dao=new GhsxxDao();
	public ZjghsxxAction(ZjghsxxDialog dialog){
		this.dialog=dialog;
        this.parent=(GhsxxDialog)dialog.getParent();
}
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource().equals(dialog.getJbsave())){
			 if(dialog.addOrUpdate==ZjghsxxDialog.ADD){
				 
				 SupplierVo vo=this.getSupplierVo();
				// System.out.println(vo);
		    	boolean flage=dao.insertGhsxx(vo);
			if(flage==true){
				JOptionPane.showMessageDialog(dialog, "数据添加成功");
				
				 Vector<Vector> data=null;
				JTable jtable=parent.getJtGhsxx();
				   try {
					data=dao.querGhsxx();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				 DefaultTableModel dtm=new DefaultTableModel(data,
						 ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
				   jtable.setModel(dtm);

		}else{
				JOptionPane.showMessageDialog(dialog, "数据添加失败");
			}

	 
			 }else if(dialog.addOrUpdate==ZjghsxxDialog.UPDATE){
				 
				 SupplierVo vo=this.getSupplierVo();
					 System.out.println(vo);
			    	boolean flage=dao.upadateGhsxx(vo);
				if(flage==true){
					JOptionPane.showMessageDialog(dialog, "修改添加成功");
					
					 Vector<Vector> data=null;
					JTable jtable=parent.getJtGhsxx();
					   try {
						data=dao.querGhsxx();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					 DefaultTableModel dtm=new DefaultTableModel(data,
							 ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
					   jtable.setModel(dtm);

			}else{
					JOptionPane.showMessageDialog(dialog, "数据添修改失败");
				}
				 
				 
			 }
			 
			 
			 
		 }else if(e.getSource().equals(dialog.getJbcancel())){
			 
			 dialog.dispose();
		 }
		
		 
		 
		 
	}

	
	
	
	
	
	
	public SupplierVo getSupplierVo(){
		
		SupplierVo vo=new SupplierVo();
		String strbh=dialog.getJtbh().getText();//1
		if(strbh.matches("[0-9]{1,4}")){
			vo.setSid(Integer.parseInt(strbh));
			
		}else{
			JOptionPane.showMessageDialog(dialog, "单位编号请输入数字，O(∩_∩)O谢谢");
			return null;
		}
		 
		 
		 String strqc=dialog.getJtqc().getText();//2
		 vo.setSname(strqc);
		 String strjp=dialog.getJtjp().getText();//3
		 vo.setSjc(strjp);
		 
		 String strjtr=dialog.getJtr().getText();
		 if(strjtr!=null){
			 vo.setContact(strjtr);
		 }else{
			 
			 vo.setContact(null);
		 }
		 
		 String strjtdh=dialog.getJtdh().getText();
		 if(strjtdh!=null){
		 if(strjtdh.matches("[0-9]{1,11}")){
			 vo.setPhone(Integer.parseInt(strjtdh));
				
			}else{
				//JOptionPane.showMessageDialog(dialog, "电话请输入数字，O(∩_∩)O谢谢");
			}
		 } else{
			 vo.setPhone(null);
		 }
		 String  strdz=dialog.getJtdz().getText();
		 if(strdz!=null){
			 
			 vo.setAddress(strdz);
		 }else {
			 vo.setAddress(null);
		 }
		 
		 String strfs=dialog.getJtfs().getText();
		 if(strfs!=null){
		 if(strfs.matches("[1-2]{1}")){
			 vo.setIsmr(Integer.parseInt(strfs));
		 }else{
			 
			 JOptionPane.showConfirmDialog(dialog, "默认方式只有输入1或2中的一位数，才会显示出Y或N (*^__^*) 嘻嘻……");
		 }
		 }else{
			 vo.setIsmr(null);
		 }
		 
		 String strbz=dialog.getJtabz().getText();
		 if(strbz!=null){
			 vo.setRemarks(strbz);
		 }else{
			 vo.setRemarks(null);
		 }
		
		return vo;
	}
	
	
	
}

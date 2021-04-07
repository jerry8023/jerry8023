package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.GhsxxDao;
import com.dao.MemberDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.GhsxxDialog;
import com.view.ZjghsxxDialog;
import com.view.util.PrintJPanel;
import com.vo.SupplierVo;

public class GhsxxAction implements ActionListener{

	private GhsxxDialog dialog;
	
	public GhsxxAction(GhsxxDialog dialog){
		
		this.dialog=dialog;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(dialog.getMjbZjGhsxx())){
			 new ZjghsxxDialog(dialog,true,ZjghsxxDialog.ADD);
			
		}else if(e.getSource().equals(dialog.getMjbXgGhsxx())){
			
			ZjghsxxDialog zd =	new ZjghsxxDialog(dialog,false,ZjghsxxDialog.UPDATE);
			JTable  jt=dialog.getJtGhsxx();
			int selectedRow=jt.getSelectedRow();
			if(selectedRow!=-1){
			Object  bh=jt.getValueAt(selectedRow, 0);//1
			
			zd.getJtbh().setText(bh.toString());
			Object qc=jt.getValueAt(selectedRow, 1);//2
			zd.getJtqc().setText(qc.toString());
			Object jp=jt.getValueAt(selectedRow, 2);//3
			zd.getJtjp().setText(jp.toString());
			
			Object r=jt.getValueAt(selectedRow, 3);
			if(r!=null){
			zd.getJtr().setText(r.toString());
			}else{
				zd.getJtr().setText(null);
			}
			Object lx=jt.getValueAt(selectedRow, 4);
			if(lx!=null){
				zd.getJtdh().setText(lx.toString());
				}else{
					zd.getJtdh().setText(null);
				}
			
			Object dz=jt.getValueAt(selectedRow, 5);
			if(dz!=null){
				zd.getJtdz().setText(dz.toString());
				}else{
					zd.getJtdz().setText(null);
				}
			
			Object fs=jt.getValueAt(selectedRow, 6);
			if(fs!=null){
				zd.getJtfs().setText(fs.toString());
				}else{
					zd.getJtfs().setText(null);
				}
			
			Object xx=jt.getValueAt(selectedRow, 7);
			if(xx!=null){
				zd.getJtabz().setText(xx.toString());
				}else{
					zd.getJtabz().setText(null);
				}
			
			
			}else{
				JOptionPane.showMessageDialog(dialog, "请选择你要修改的数据，O(∩_∩)O");
				
				zd.dispose();
			}
			
		}else if(e.getSource().equals(dialog.getMjbScGhsxx())){
			JTable  jt=dialog.getJtGhsxx();
			int selectedRow=jt.getSelectedRow();
			if(selectedRow==-1){
				JOptionPane.showMessageDialog(dialog, "请选择你要删除的数据(^_^)");
				return;
			}
			int val=JOptionPane.showConfirmDialog(dialog, "真的要删除?删除后不能恢复数据!", "提示信息", JOptionPane.OK_CANCEL_OPTION);
			if(val==JOptionPane.OK_OPTION){
				SupplierVo vo =new SupplierVo();
				GhsxxDao dao=new GhsxxDao();
				
				Object bh=jt.getValueAt(selectedRow, 0);
				vo.setSid(Integer.parseInt(bh.toString()));
				
				boolean falge=dao.deleteGhsxx(vo);
				if(falge==true){
					JOptionPane.showMessageDialog(dialog, "数据删除成功O(∩_∩)O~");
					
					 Vector<Vector> data=null;
					//JTable jtable=parent.getJtGhsxx();
					   try {
						data=dao.querGhsxx();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					 DefaultTableModel dtm=new DefaultTableModel(data,
							 ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
					   jt.setModel(dtm);
	
				}else{
					JOptionPane.showMessageDialog(dialog, "数据删除改失败");
				}
			}
				
			
			
			
			
			
		}else if(e.getSource().equals(dialog.getMjbCxGhsxx())){

			GhsxxDao dao= new GhsxxDao();
			SupplierVo vo =new SupplierVo();
			JTable jt=dialog.getJtGhsxx();
			String strjt=dialog.getJtfDwbhjc().getText();
			
			boolean flage=YanZhengUtil.isShuZi(strjt);
			if(flage==true){
				vo.setSid(Integer.parseInt(strjt));
				System.out.println(vo);
				try {
					dao.querGhsxxsz(vo);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				Vector<Vector> data=null;
				try {
					 data=dao.querGhsxxsz(vo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel dtm=new DefaultTableModel(data,
						 ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
				   jt.setModel(dtm);

				
				
			}else {
				vo.setSjc(strjt);
				try {
					dao.querGhsxxjp(vo);
				} catch (Exception e1) {
					System.out.println("jp"+vo);
					e1.printStackTrace();
				}
				
				Vector<Vector> data=null;
				try {
					data=dao.querGhsxxjp(vo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel dtm=new DefaultTableModel(data,
						 ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME));
				   jt.setModel(dtm);

				
			}
			
			
			
		}else if(e.getSource().equals(dialog.getMjbDyGhsxx())){
			Vector<Vector> data=null;
			GhsxxDao  gdao=new GhsxxDao();
			try {
				data=gdao.querGhsxx();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JFrame jf=new JFrame();
			jf.setSize(1365,767);
			jf.setTitle("打印预览");
			jf.getContentPane().add(new PrintJPanel(data,ColumnContent.arrayToVector(ColumnContent.GONGHUOSHANGXINXI_CLUMN_NAME), 0, 0, 1150));
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
		}
		
		
		
		
		
		
		
		
	}

}

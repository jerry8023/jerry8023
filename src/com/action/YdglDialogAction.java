package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.PreorderDao;
import com.jdbc.util.JdbcTemplate;
import com.util.ColumnContent;
import com.view.YddrDialog;
import com.view.YdglDialog;
import com.view.util.PrintJPanel;
import com.vo.PreorderVo;

public class YdglDialogAction implements ActionListener{
	
	private YdglDialog frame;
	
	public YdglDialogAction(YdglDialog frame){
		this.frame=frame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMbjSc())){
			
			int val=JOptionPane.showConfirmDialog(frame, "删除后将不能恢复，真的要删除？", "提示信息", JOptionPane.OK_CANCEL_OPTION);
			if(val==JOptionPane.OK_OPTION){
				
				int selectRow=frame.getJtYd().getSelectedRow();
				if(selectRow==-1){
					JOptionPane.showMessageDialog(frame, "请选择要删除的一行");
				}else{
					
					Object poid=frame.getJtYd().getValueAt(selectRow, 0);
					PreorderDao poDao=new PreorderDao();
					
					int res=poDao.deleteDataByPoid(Integer.parseInt(poid.toString()));
					
					if(res>0){
						JOptionPane.showMessageDialog(frame, "删除成功");
						
						DefaultTableModel dtm=null;
						try {
							dtm = new DefaultTableModel(poDao.queryData(), ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, "数据库异常");
							e1.printStackTrace();
						}
						frame.getJtYd().setModel(dtm);
						
					}else{
						JOptionPane.showMessageDialog(frame, "删除失败");
					}
				}
				
				
			}
		
		
		}else if(e.getSource().equals(frame.getJbCx())){
			String cxxm=frame.getJtf().getText();
			if(cxxm==null||cxxm.length()==0){
				cxxm=null;
			}
			PreorderDao poDao=new PreorderDao();
			DefaultTableModel dtm=null;
			try {
				Vector<Vector>  rowdatasSelected=poDao.queryDataByName(cxxm);
				dtm = new DefaultTableModel(rowdatasSelected, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
			frame.getJtYd().setModel(dtm);
			
		}else if(e.getSource().equals(frame.getJbSx())){
			PreorderDao poDao=new PreorderDao();
			DefaultTableModel dtm=null;
			try {
				dtm = new DefaultTableModel(poDao.queryData(), ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			frame.getJtYd().setModel(dtm);
		}else if(e.getSource().equals(frame.getJbGl())){
			
			frame.getJpmGl().show(frame.getJbGl(), 30, 20);
			
			
		}else if(e.getSource().equals(frame.getMbjZj())){
			new YddrDialog(frame, true,YddrDialog.ZENGJIA);
		}else if(e.getSource().equals(frame.getMbjXg())){
			int index=frame.getJtYd().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "请选择要修改的一行!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			new YddrDialog(frame, true,YddrDialog.XIUGAI);
	
		}else if(e.getSource().equals(frame.getJbDy())){			
			PreorderDao poDao=new PreorderDao();
			Vector<Vector> rowdatasPo=null;
			try {
				rowdatasPo=poDao.queryData();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JFrame jf=new JFrame();
			jf.setSize(1365,767);
			jf.setTitle("打印预览");
			jf.getContentPane().add(new PrintJPanel(rowdatasPo,ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME), 0, 0, 1278));
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
		}
		
		
	}

}

package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.PreorderDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.YdglDialog;
import com.view.ZdydsjfwDialog;

public class YdglPopupMemuAction implements ActionListener{
	
	private YdglDialog frame;
	
	public YdglPopupMemuAction(YdglDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		PreorderDao preoDao=new PreorderDao();
		
		if(e.getSource().equals(frame.getJmiToday())){
			Calendar calendar=Calendar.getInstance();
			String ydsjQs=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00";
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String ydsjZz=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00";
			
			try {
				Vector<Vector> rowdatas=preoDao.queryByYdsj(ydsjQs,ydsjZz);
				DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
				frame.getJtYd().setModel(dtm);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource().equals(frame.getJmiTomorrow())){
			
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String ydsjQs=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00";
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String ydsjZz=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00";
			
			try {
				Vector<Vector> rowdatas=preoDao.queryByYdsj(ydsjQs,ydsjZz);
				DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME));
				frame.getJtYd().setModel(dtm);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
		}else if (e.getSource().equals(frame.getJmiFanwei())){
			
			new ZdydsjfwDialog(frame, true);
			
		}
			
			
		
		
	}

}

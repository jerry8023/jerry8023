package com.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.DazheDao;
import com.dao.GoodsDao;
import com.dao.OperatorDao;
import com.dao.XfdetailDao;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.view.ZjxfDialog;
import com.vo.DazheVo;
import com.vo.GoodsVo;
import com.vo.OperatorVo;
import com.vo.XiaofeiVo;

public class ZjxfDialogKeyListener implements KeyListener{
	
	private ZjxfDialog frame;
	
	public ZjxfDialogKeyListener(ZjxfDialog frame){
		this.frame=frame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(frame.getJtfXmbmOrJpXf())){
			
			if((e.getKeyCode()>=65 && e.getKeyCode()<=90) || (e.getKeyCode()>=97 && e.getKeyCode()<=122)|| (e.getKeyCode()>=48 && e.getKeyCode()<=57)){
				
				String str=frame.getJtfXmbmOrJpXf().getText()+e.getKeyChar();
				GoodsDao goodsDao=new GoodsDao();
				try {
					Vector<Vector> rowdatas=goodsDao.queryDateByJcOrBh(str);
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.SHANGPIN1_CLUMN_NAME));
					frame.getjTableSp().setModel(dtm);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				
			}else if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				
				String str="";
				if(frame.getJtfXmbmOrJpXf().getText().length()<=1){
					str="";
				}else{
					str=frame.getJtfXmbmOrJpXf().getText().substring(0, frame.getJtfXmbmOrJpXf().getText().length()-1);
				}
				GoodsDao goodsDao=new GoodsDao();
				try {
					Vector<Vector> rowdatas=goodsDao.queryDateByJcOrBh(str);
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.SHANGPIN1_CLUMN_NAME));
					frame.getjTableSp().setModel(dtm);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
			}
			
			
		}else if(e.getSource().equals(frame.getJtfSsXfxmjc())){
			
			if((e.getKeyCode()>=65 && e.getKeyCode()<=90) || (e.getKeyCode()>=97 && e.getKeyCode()<=122)|| (e.getKeyCode()>=48 && e.getKeyCode()<=57)){
				
				String str=frame.getJtfSsXfxmjc().getText()+e.getKeyChar();
				ss(str);
				
			}else if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				
				String str="";
				if(frame.getJtfXmbmOrJpXf().getText().length()<=1){
					str="";
				}else{
					str=frame.getJtfSsXfxmjc().getText().substring(0, frame.getJtfSsXfxmjc().getText().length()-1);
				}
				ss(str);
			
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void ss(String str){
		
		Vector<Vector> rowdataSx=new Vector<Vector>();
		
		XfdetailDao xftDao=new XfdetailDao();
		try {
			
			xiaofeiDao xfDao=new xiaofeiDao();
			GoodsDao goodsDao=new GoodsDao();
			String bjid=MjbFjMouseListener.getQygVo().getBjid();
			XiaofeiVo xfVo=xfDao.getXfByBjid(bjid);
			
			Vector<Vector> rowdataXz=xftDao.queryXfdetailByXfid(xfVo.getXfid());
			DazheDao dzDao=new DazheDao();
			for(int i=0;i<rowdataXz.size();i++){
				Vector addrow=new Vector();
				Vector row=rowdataXz.get(i);
				int gid_row=Integer.parseInt(row.get(1).toString());
				GoodsVo dqVo=goodsDao.getDoodsByGid(gid_row);
				if(!dqVo.getJp().contains(str.toLowerCase())){
					continue;
				}
				addrow.add(MjbFjMouseListener.getQygVo().getBjid());
				addrow.add(dqVo.getDname());
				//价格
				addrow.add(dqVo.getPrice());
				//打折比例。。。。。
				ArrayList<DazheVo> dataListDz=dzDao.queryByDzname(dqVo.getDname());
				double dzbl=1.0;
				if(dataListDz.size()>0){
					dzbl=dataListDz.get(0).getDzremarks();
				}
				addrow.add(dzbl);
				addrow.add(row.get(4));
				addrow.add((Integer.parseInt(row.get(4).toString()))*(dqVo.getPrice())*dzbl);
				addrow.add(row.get(5));
				if(row.get(3)==null){
					addrow.add("*");
				}else{
					
				}
				OperatorDao odao=new OperatorDao();
				OperatorVo oVo=odao.getdataById(Integer.parseInt(row.get(6).toString()));
				addrow.add(oVo.getOname());
				
				rowdataSx.add(addrow);
				
				
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "数据库异常");
			e1.printStackTrace();
		}
		
		DefaultTableModel dtm=new DefaultTableModel(rowdataSx, ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDAN_CLUMN_NAME));
		frame.getjTableXfqd().setModel(dtm);
		
	}
	

}

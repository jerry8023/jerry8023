package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.DazheDao;
import com.dao.GoodsDao;
import com.dao.GoodstypeDao;
import com.dao.OperatorDao;
import com.dao.XfdetailDao;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.ZjxfDialog;
import com.vo.DazheVo;
import com.vo.GoodsVo;
import com.vo.GoodstypeVo;
import com.vo.OperatorVo;
import com.vo.XiaofeiVo;

public class ZjxfDialogAction implements ActionListener{
	
	private ZjxfDialog frame;
	
	public ZjxfDialogAction(ZjxfDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getJbZjXfslXf()) || e.getSource().equals(frame.getMjbJdZjxf())){
			int rowindex=frame.getjTableSp().getSelectedRow();
			if(rowindex==-1){
				JOptionPane.showMessageDialog(frame, "请现在要添加的商品");
			}else{
				int kucun=Integer.parseInt(frame.getjTableSp().getValueAt(rowindex, 3).toString());
				if(kucun<=0){
					JOptionPane.showMessageDialog(frame, "很抱歉！"+frame.getjTableSp().getValueAt(rowindex, 1).toString()+"现在没货，请选择其他商品.", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int gid=Integer.parseInt(frame.getjTableSp().getValueAt(rowindex, 0).toString());
				GoodsDao goodsDao=new GoodsDao();
				String bjid=MjbFjMouseListener.getQygVo().getBjid();
				xiaofeiDao xfDao=new xiaofeiDao();
				GoodstypeDao gtDao=new GoodstypeDao();
				XiaofeiVo xfVo=null;
				GoodsVo gVo=null;
				GoodstypeVo gtVo=null;
				try {
					xfVo=xfDao.getXfByBjid(bjid);
					gVo=goodsDao.getDoodsByGid(gid);
					gtVo=gtDao.getGtByGtid(gVo.getGtid());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object[] values = null;
				if(gtVo.getGtname().equals("服务类")){
					
				}else{
					
					values=new Object[]{gid,xfVo.getXfid(),null,Integer.parseInt(frame.getJtfXfslXf().getText()),new java.sql.Timestamp(new Date().getTime()),LoginAction.getDqOid()};
					
				}
				
				XfdetailDao xfdDao=new XfdetailDao();
				int val=xfdDao.insertdata(values);
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "增加消费失败");
				}else{
					//改变库存量。。。。
					GoodsDao gDao=new GoodsDao();
					gDao.updateDataById(gid, Integer.parseInt(frame.getJtfXfslXf().getText()), 1);
					
					
					Vector<Vector> rowdatasSp=null;
					try {
						rowdatasSp=gDao.queryDate1();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
					
					DefaultTableModel dtm1=new DefaultTableModel(rowdatasSp, ColumnContent.arrayToVector(ColumnContent.SHANGPIN1_CLUMN_NAME));
					frame.getjTableSp().setModel(dtm1);
					
					
					//刷新。。。。。。。。。
					DefaultTableModel dtm=new DefaultTableModel(jtableSx(), ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDAN_CLUMN_NAME));
					frame.getjTableXfqd().setModel(dtm);
					
				}
				
			}	
			
		}else if(e.getSource().equals(frame.getJbQdgb())){
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbSsZjxf())){
			if(frame.getjTabbedPane().getSelectedIndex()==1){
				JOptionPane.showMessageDialog(frame, "Connot focus a disabled or invisible window","mpok",JOptionPane.ERROR_MESSAGE);
				return;
			}
			frame.getJtfXmbmOrJpXf().requestFocus();
		}else if(e.getSource().equals(frame.getMjbLbZjxf())){
			frame.getjTabbedPane().setSelectedIndex(ZjxfDialog.count);
			if(ZjxfDialog.count==1){
				ZjxfDialog.count=0;
			}else if(ZjxfDialog.count==0){
				ZjxfDialog.count=1;
			}
		}
		
	}
	
	
	public static Vector<Vector> jtableSx(){
		
		//刷新。。。。。。。。
		Vector<Vector> rowdataSx=new Vector<Vector>();
		Vector<Vector> rowdataYl=ZjxfDialog.rowdatasxf();
		rowdataSx.add(rowdataYl.get(0));
		rowdataSx.add(rowdataYl.get(1));
		
		//----------------------------------
		
		XfdetailDao xftDao=new XfdetailDao();
		try {
			xiaofeiDao xfDao=new xiaofeiDao();
			GoodsDao goodsDao=new GoodsDao();
			XiaofeiVo xfVo=xfDao.getXfByBjid(MjbFjMouseListener.getQygVo().getBjid());
			Vector<Vector> rowdataXz=xftDao.queryXfdetailByXfid(xfVo.getXfid());
			DazheDao dzDao=new DazheDao();
			for(int i=0;i<rowdataXz.size();i++){
				Vector addrow=new Vector();
				Vector row=rowdataXz.get(i);
				int gid_row=Integer.parseInt(row.get(1).toString());
				GoodsVo dqVo=goodsDao.getDoodsByGid(gid_row);
				addrow.add(MjbFjMouseListener.getQygVo().getBjid());
				addrow.add(dqVo.getDname());
				//价格。。。。
				addrow.add(dqVo.getPrice());
				
				//打折比例。。。。
				ArrayList<DazheVo> dataListDz=dzDao.queryByDzname(dqVo.getDname());
				Double dzbl=1.0;
				if(dataListDz.size()>0){
					dzbl=dataListDz.get(0).getDzremarks();
					if(dzbl==null){
						dzbl=1.0;
					}
				}
				addrow.add(dzbl);
				addrow.add(row.get(4));
				double money=(Integer.parseInt(row.get(4).toString()))*(dqVo.getPrice())*dzbl;
				addrow.add(money);
				//------------------
				if(Double.parseDouble(rowdataYl.get(1).get(2).toString())>money){
					rowdataYl.get(1).set(2, Double.parseDouble(rowdataYl.get(1).get(2).toString())-money);
				}else{
					rowdataYl.get(1).set(2,0);
				}
				//------------------
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
			
			rowdataYl.get(1).set(5, Double.parseDouble(rowdataYl.get(1).get(2).toString()));
		} catch (Exception e1) {
			//JOptionPane.showMessageDialog(frame, "数据库异常");
			e1.printStackTrace();
		}
		
		return rowdataSx;
		
		
	}

}

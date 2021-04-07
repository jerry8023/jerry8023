package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojiantypeDao;
import com.dao.JieriDao;
import com.dao.JifeiDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.XgbjlxDialog;
import com.view.XtszDialog;
import com.vo.BaojiantypeVo;
import com.vo.JieriVo;
import com.vo.JifeiVo;

public class XgbjlxDialogAction implements ActionListener{
	
	private XgbjlxDialog frame;
	
	public XgbjlxDialogAction(XgbjlxDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getJcbzdbzjfbjlx())){
			if(frame.getJcbzdbzjfbjlx().isSelected()){
				frame.getJcmzdbzjfbjlx().setEnabled(true);
				JifeiDao jfDao=new JifeiDao();
				try {
					ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
					for(JifeiVo vo:datas){
						frame.getJcmzdbzjfbjlx().addItem(vo.getJfname(), vo.getJfid());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
				
			}else{
				frame.getJcmzdbzjfbjlx().removeAllItems();
				frame.getJcmzdbzjfbjlx().setEnabled(false);
			}
			
			
		}else if(e.getSource().equals(frame.getJcbbtjr1bjlx())){
			
			if(frame.getJcbbtjr1bjlx().isSelected()){
				frame.getJcmbtjr1bjlx().setEnabled(true);
				JifeiDao jfDao=new JifeiDao();
				try {
					ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
					for(JifeiVo vo:datas){
						frame.getJcmbtjr1bjlx().addItem(vo.getJfname(), vo.getJfid());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
				
			}else{
				frame.getJcmbtjr1bjlx().removeAllItems();
				frame.getJcmbtjr1bjlx().setEnabled(false);
			}
			
		}else if(e.getSource().equals(frame.getJcbbtjr2bjlx())){
			
			if(frame.getJcbbtjr2bjlx().isSelected()){
				frame.getJcmbtjr2bjlx().setEnabled(true);
				JifeiDao jfDao=new JifeiDao();
				try {
					ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
					for(JifeiVo vo:datas){
						frame.getJcmbtjr2bjlx().addItem(vo.getJfname(), vo.getJfid());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
				
			}else{
				frame.getJcmbtjr2bjlx().removeAllItems();
				frame.getJcmbtjr2bjlx().setEnabled(false);
			}
			
		}else if(e.getSource().equals(frame.getJcbtsjrbjlx())){
			
			if(frame.getJcbtsjrbjlx().isSelected()){
				frame.getJcmtsjrbjlx().setEnabled(true);
				JifeiDao jfDao=new JifeiDao();
				try {
					ArrayList<JifeiVo> datas=jfDao.queryAllDatas();
					for(JifeiVo vo:datas){
						frame.getJcmtsjrbjlx().addItem(vo.getJfname(), vo.getJfid());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
				
			}else{
				frame.getJcmtsjrbjlx().removeAllItems();
				frame.getJcmtsjrbjlx().setEnabled(false);
			}
			
		}else if(e.getSource().equals(frame.getMjbSavexgbjlx())){
			String bjlx=frame.getJtfnamebjlx().getText();
			if(bjlx.length()==0||bjlx==null){
				JOptionPane.showMessageDialog(frame, "包间类型不能为空!");
				return;
			}
			BaojiantypeDao bjtDao1=new BaojiantypeDao();
			BaojiantypeVo voBjt;
			if(XgbjlxDialog.yongtu==1){
				try {
					voBjt = bjtDao1.getVoByBjtname(bjlx);
					if(voBjt!=null){
						JOptionPane.showMessageDialog(frame, "此包间类型已存在!");
						frame.getJtfnamebjlx().setText("");
						frame.getJtfnamebjlx().requestFocus();
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e2.printStackTrace();
				}
			}else{
				try {
					XtszDialog xtszd=(XtszDialog)frame.getParent();
					int index=xtszd.getjTableBjlx().getSelectedRow();
					String baojxlname=xtszd.getjTableBjlx().getValueAt(index, 0).toString();
					voBjt = bjtDao1.getVoByBjtname(bjlx);
					if(voBjt!=null && (!(bjlx.equals(baojxlname)))){
						JOptionPane.showMessageDialog(frame, "此包间类型已存在!");
						frame.getJtfnamebjlx().setText("");
						frame.getJtfnamebjlx().requestFocus();
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e2.printStackTrace();
				}
			}
			
			DecimalFormat decimalFormat=new DecimalFormat("￥#.00");
			Double zdxf=0.0;
			try {
				zdxf=decimalFormat.parse(frame.getJtfzdxfbjlx().getText().toString()).doubleValue();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(frame, "格式不正確，請重新輸入");
				frame.getJtfzdxfbjlx().setText("￥0.00");
				frame.getJtfzdxfbjlx().requestFocus();
				return;
			}
			
			String rnrs=frame.getJtfrnrsbjlx().getText();
			Integer rnrsBjlx;
			if(YanZhengUtil.isShuZi(rnrs)){
				rnrsBjlx=Integer.parseInt(rnrs);
			}else{
				JOptionPane.showMessageDialog(frame, "格式不正確，請重新輸入");
				frame.getJtfrnrsbjlx().setText("");
				frame.getJtfrnrsbjlx().requestFocus();
				return;
			}
			
			
			
			Integer jrid=null;
			if(frame.getJcmzdbzjfbjlx().getSelectedIndex()!=-1){
				int jfid=frame.getJcmzdbzjfbjlx().getValues().get(frame.getJcmzdbzjfbjlx().getSelectedIndex());
				JieriDao jrDao=new JieriDao();
				try {
					ArrayList<JieriVo> jrlist=jrDao.getVoByJfidAndJrname(jfid, "指定标准计费方式");
					if(jrlist==null||jrlist.size()==0){
						jrDao.insertData(new Object[]{jfid,"指定标准计费方式",null});
					}
					jrlist=jrDao.getVoByJfidAndJrname(jfid, "指定标准计费方式");
					jrid=jrlist.get(0).getJrid();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
			}
			
			if(jrid==null){
				JOptionPane.showMessageDialog(frame, "指定标准计费方式不能为空!");
				return;
			}
			
			
			//-------------------------------------------
			Integer jrid1=null;
			if(frame.getJcmbtjr1bjlx().getSelectedIndex()!=-1){
				int jfid=frame.getJcmbtjr1bjlx().getValues().get(frame.getJcmbtjr1bjlx().getSelectedIndex());
				JieriDao jrDao=new JieriDao();
				try {
					ArrayList<JieriVo> jrlist=jrDao.getVoByJfidAndJrname(jfid, "普通节日1计费方式");
					if(jrlist==null||jrlist.size()==0){
						jrDao.insertData(new Object[]{jfid,"普通节日1计费方式",null});
					}
					jrlist=jrDao.getVoByJfidAndJrname(jfid, "普通节日1计费方式");
					jrid1=jrlist.get(0).getJrid();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
			}
			
			
			//-------------------------------------------
			Integer jrid2=null;
			if(frame.getJcmbtjr2bjlx().getSelectedIndex()!=-1){
				int jfid=frame.getJcmbtjr2bjlx().getValues().get(frame.getJcmbtjr2bjlx().getSelectedIndex());
				JieriDao jrDao=new JieriDao();
				try {
					ArrayList<JieriVo> jrlist=jrDao.getVoByJfidAndJrname(jfid, "普通节日2计费方式");
					if(jrlist==null||jrlist.size()==0){
						jrDao.insertData(new Object[]{jfid,"普通节日2计费方式",null});
					}
					jrlist=jrDao.getVoByJfidAndJrname(jfid, "普通节日2计费方式");
					jrid2=jrlist.get(0).getJrid();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
			}
			
			
			//-------------------------------------------
			Integer jridt=null;
			if(frame.getJcmtsjrbjlx().getSelectedIndex()!=-1){
				int jfid=frame.getJcmtsjrbjlx().getValues().get(frame.getJcmtsjrbjlx().getSelectedIndex());
				JieriDao jrDao=new JieriDao();
				try {
					ArrayList<JieriVo> jrlist=jrDao.getVoByJfidAndJrname(jfid, "特殊节日计费方式");
					if(jrlist==null||jrlist.size()==0){
						jrDao.insertData(new Object[]{jfid,"特殊节日计费方式",null});
					}
					jrlist=jrDao.getVoByJfidAndJrname(jfid, "特殊节日计费方式");
					jridt=jrlist.get(0).getJrid();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
			}
			int val = 0;
			BaojiantypeDao bjtDao=new BaojiantypeDao();
			
			if(XgbjlxDialog.yongtu==1){
				Object[] values=new Object[]{jrid,bjlx,zdxf,rnrsBjlx,jrid1,jrid2,jridt};
				val=bjtDao.insertData(values);
			}else if(XgbjlxDialog.yongtu==2){
				
				XtszDialog xtszd=(XtszDialog)frame.getParent();
				int index=xtszd.getjTableBjlx().getSelectedRow();
				String baojxlname=xtszd.getjTableBjlx().getValueAt(index, 0).toString();
				Integer bjtid = null;
				try {
					voBjt = bjtDao1.getVoByBjtname(baojxlname);
					bjtid=voBjt.getBjtid();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
				Object[] values=new Object[]{jrid,bjlx,zdxf,rnrsBjlx,jrid1,jrid2,jridt,bjtid};
				val=bjtDao.updateData(values);
			}
			if(val==0){
				JOptionPane.showMessageDialog(frame, "數據庫異常");
			}else{
				try {
					Vector<Vector> rowdatas=bjtDao.queryDate();
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.BAOJIANLEIXING_CLUMN_NAME));
					((XtszDialog)frame.getParent()).getjTableBjlx().setModel(dtm);
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "數據庫異常");
					e1.printStackTrace();
				}
			}
			
			
		}else if(e.getSource().equals(frame.getMjbExitxgbjlx())){
			
			frame.dispose();
		}
		
		
	}

	
	
}

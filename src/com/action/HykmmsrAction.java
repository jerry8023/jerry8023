package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.MemberDao;
import com.dao.xiaofeiDao;
import com.util.ColumnContent;
import com.view.BkjzDialog;
import com.view.HykmmsrDialog;
import com.vo.MemberVo;
import com.vo.XiaofeiVo;

public class HykmmsrAction implements ActionListener{
	
	private HykmmsrDialog frame;
	
	public HykmmsrAction(HykmmsrDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMjbQd())){
			BkjzDialog bkjzDialog=(BkjzDialog)frame.getParent();
			String password=new String(frame.getJpfPassword().getPassword());
			
			int hybh=Integer.parseInt(bkjzDialog.getJtfHybh().getText());
			MemberDao mDao=new MemberDao();
			try {
				MemberVo mVo=mDao.getMemberVoByHyid(hybh);
				if(mVo.getPassword().equals(password)){
					bkjzDialog.getJlHyxm().setText(mVo.getMname());
					bkjzDialog.getJlHydj().setText(mVo.getMgradeVo().getMgname());
					bkjzDialog.getJlDqjf().setText(mVo.getJf().toString());
					if(mVo.getMgradeVo().getRebate()==1.0){
						bkjzDialog.getJlDzbl().setText("无");
					}else{
						bkjzDialog.getJlDzbl().setText(mVo.getMgradeVo().getRebate().toString());
					}
					bkjzDialog.getJtfHybh().setEnabled(false);
					bkjzDialog.getJtfBkzf().requestFocus();
					
					
					//-----------刷新表格...修改打折比例和最低消费补差---------------
					Vector<Vector> rowdatas=ZjxfDialogAction.jtableSx();
					DecimalFormat decimalFormat=new DecimalFormat("#0.00");
					Double xfje=0.0;
					Double hj=0.0;
					Double yhje=0.0;
					Double sumMoney=0.0;
					for(int i=2;i<rowdatas.size();i++){
						if(Double.parseDouble(rowdatas.get(i).get(3).toString())>mVo.getMgradeVo().getRebate()){
							rowdatas.get(i).set(3, mVo.getMgradeVo().getRebate());
							rowdatas.get(i).set(5, decimalFormat.format(Double.parseDouble(mVo.getMgradeVo().getRebate().toString())*Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(4).toString())));
						}
						rowdatas.get(i).add(4,decimalFormat.format( Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(3).toString())));
						rowdatas.get(i).add(5,decimalFormat.format( Double.parseDouble(rowdatas.get(i).get(2).toString())-Double.parseDouble(rowdatas.get(i).get(4).toString())));
						sumMoney+=Double.parseDouble(rowdatas.get(i).get(7).toString());
						xfje+=Double.parseDouble(rowdatas.get(i).get(2).toString());
						hj+=Double.parseDouble(rowdatas.get(i).get(7).toString());
						yhje+=Double.parseDouble(rowdatas.get(i).get(5).toString());
					}
					//修改第一行。。。。。。
					rowdatas.get(0).add(4,decimalFormat.format( Double.parseDouble(rowdatas.get(0).get(2).toString())*Double.parseDouble(rowdatas.get(0).get(3).toString())));
					rowdatas.get(0).add(5,decimalFormat.format( Double.parseDouble(rowdatas.get(0).get(2).toString())-Double.parseDouble(rowdatas.get(0).get(4).toString())));
					//修改第二行。。。。。。。
					if(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf()-sumMoney>0){
						rowdatas.get(1).set(2, decimalFormat.format(MjbFjMouseListener.getQygVo().getBaoJianType().getMinxf()-sumMoney));
					}else{
						rowdatas.get(1).set(2, decimalFormat.format(0));
					}
					rowdatas.get(1).set(5, rowdatas.get(1).get(2));
					rowdatas.get(1).add(4,decimalFormat.format( Double.parseDouble(rowdatas.get(1).get(2).toString())*Double.parseDouble(rowdatas.get(1).get(3).toString())));
					rowdatas.get(1).add(5,decimalFormat.format( Double.parseDouble(rowdatas.get(1).get(2).toString())-Double.parseDouble(rowdatas.get(1).get(4).toString())));
					
					for(int i=0;i<2;i++){
						xfje+=Double.parseDouble(rowdatas.get(i).get(2).toString());
						hj+=Double.parseDouble(rowdatas.get(i).get(7).toString());
						yhje+=Double.parseDouble(rowdatas.get(i).get(5).toString());
					}
					
					bkjzDialog.getJlXfje().setText(xfje.toString());
					bkjzDialog.getJlYsje().setText(hj.toString());
					bkjzDialog.getJlHj().setText(hj.toString());
					bkjzDialog.getJlYhje().setText(String.valueOf(decimalFormat.format(yhje)));
					bkjzDialog.getJtfSsjr().setText(String.valueOf(decimalFormat.format(hj-Double.parseDouble(bkjzDialog.getJlYsyj().getText()))));
					bkjzDialog.getJlZl().setText(String.valueOf(0-Double.parseDouble(bkjzDialog.getJtfSsjr().getText())));
					
					
					DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDANMINGXI_CLUMN_NAME));
					bkjzDialog.getJtXfqdmx().setModel(dtm);
					
					
					frame.dispose();
					//-------------------------------
				}else{
					JOptionPane.showMessageDialog(frame, "密码错误，请重新输入!","提示信息",JOptionPane.INFORMATION_MESSAGE);
					frame.getJpfPassword().setText("");
					frame.getJpfPassword().requestFocus();
					return;
				
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据库异常");
				e1.printStackTrace();
			}
			
		}else if(e.getSource().equals(frame.getMjbQx())){
			frame.dispose();
			BkjzDialog bkjzDialog=(BkjzDialog)frame.getParent();
			bkjzDialog.getJtfHybh().setText("普通宾客");
			bkjzDialog.getJtfBkzf().requestFocus();
		}
		
		
		
	}
	
	

}

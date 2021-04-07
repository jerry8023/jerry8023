package com.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojianDao;
import com.dao.DazheDao;
import com.dao.MemberDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.BkjzDialog;
import com.view.HykmmsrDialog;
import com.vo.BaojianVo;
import com.vo.DazheVo;
import com.vo.MemberVo;

public class BkjzDialogKeyListener implements KeyListener{
	
	private BkjzDialog frame;
	int countPoint=0;
	
	public BkjzDialogKeyListener(BkjzDialog frame){
		this.frame=frame;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(frame.getJtfHybh())){
			if(e.getKeyChar()==KeyEvent.VK_ENTER){
				
				String strHybh=frame.getJtfHybh().getText();
				if(strHybh.length()==0||strHybh==null||(!YanZhengUtil.isShuZi(strHybh))){
					JOptionPane.showMessageDialog(frame, "没有此会员或此会员卡已经停用，查看会员输入是否有误!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					frame.getJtfHybh().setText("普通宾客");
					frame.getJtfHybh().requestFocus();
					return;
				}
				
				
				
				int hybh=Integer.parseInt(strHybh);
				MemberDao mDao=new MemberDao();
				MemberVo mVo=null;
				try {
					mVo=mDao.getMemberVoByHyid(hybh);
					if(mVo!=null){
						if(mVo.getPassword()==null){
							frame.getJlHyxm().setText(mVo.getMname());
							frame.getJlHydj().setText(mVo.getMgradeVo().getMgname());
							frame.getJlDqjf().setText(mVo.getJf().toString());
							if(mVo.getMgradeVo().getRebate()==1.0){
								frame.getJlDzbl().setText("无");
							}else{
								frame.getJlDzbl().setText(mVo.getMgradeVo().getRebate().toString());
							}
							frame.getJtfHybh().setEnabled(false);
							frame.getJtfBkzf().requestFocus();
							
							//-------刷新----------------------------------
							Vector<Vector> rowdatas=ZjxfDialogAction.jtableSx();
							DecimalFormat decimalFormat=new DecimalFormat("#0.00");
							Double xfje=0.0;
							Double hj=0.0;
							Double yhje=0.0;
							Double sumMoney=0.0;
							DazheDao dzDao=new DazheDao();
							for(int i=2;i<rowdatas.size();i++){
								
								
								/*if(Double.parseDouble(rowdatas.get(i).get(3).toString())>mVo.getMgradeVo().getRebate()){
									rowdatas.get(i).set(3, mVo.getMgradeVo().getRebate());
									rowdatas.get(i).set(5, decimalFormat.format(Double.parseDouble(mVo.getMgradeVo().getRebate().toString())*Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(4).toString())));
								}*/
								
								Double dzbl=1.0;
								Double dzbl1=Double.parseDouble(rowdatas.get(i).get(3).toString());
								Double dzbl2=mVo.getMgradeVo().getRebate();
								Double dzbl3=1.0;
								ArrayList<DazheVo> dzVo=dzDao.getVoByDznameAndMgname(rowdatas.get(i).get(1).toString(),mVo.getMgid());
								if(dzVo.size()==0){
									 dzbl3=1.0;
								}else{
									 dzbl3=dzVo.get(0).getDzbl();
								}
								
								
								if(dzbl1<dzbl2){
									dzbl=dzbl1;
								}else{
									dzbl=dzbl2;
								}
								if(dzbl1<dzbl3){
									dzbl=dzbl1;
								}else{
									dzbl=dzbl3;
								}
								if(dzbl2<dzbl3){
									dzbl=dzbl2;
								}else{
									dzbl=dzbl3;
								}
								
								rowdatas.get(i).set(3,dzbl);
								rowdatas.get(i).set(5, decimalFormat.format(dzbl*Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(4).toString())));
								
								
								
								rowdatas.get(i).add(4,decimalFormat.format( Double.parseDouble(rowdatas.get(i).get(2).toString())*Double.parseDouble(rowdatas.get(i).get(3).toString())));
								rowdatas.get(i).add(5,decimalFormat.format( Double.parseDouble(rowdatas.get(i).get(2).toString())-Double.parseDouble(rowdatas.get(i).get(4).toString())));
								sumMoney+=Double.parseDouble(rowdatas.get(i).get(7).toString());
								xfje+=Double.parseDouble(rowdatas.get(i).get(2).toString());
								hj+=Double.parseDouble(rowdatas.get(i).get(7).toString());
								yhje+=Double.parseDouble(rowdatas.get(i).get(5).toString());
							}
							
							
							//修改第一行。。。。。。
							Double dzbl=1.0;
							Double dzbl1=Double.parseDouble(rowdatas.get(0).get(3).toString());
							Double dzbl3=1.0;
							BaojianDao bjDao=new BaojianDao();
							BaojianVo bjVo=bjDao.getVoByBjid(rowdatas.get(0).get(0).toString());
							ArrayList<DazheVo> dzVo=dzDao.getVoByDznameAndMgname(bjVo.getBaoJianType().getBjtname(),mVo.getMgid());
							if(dzVo.size()==0){
								 dzbl3=1.0;
							}else{
								 dzbl3=dzVo.get(0).getDzbl();
							}
							
							if(dzbl1<dzbl3){
								dzbl=dzbl1;
							}else{
								dzbl=dzbl3;
							}
							
							rowdatas.get(0).set(3,dzbl);
							rowdatas.get(0).set(5, decimalFormat.format(dzbl*Double.parseDouble(rowdatas.get(0).get(2).toString())*Double.parseDouble(rowdatas.get(0).get(4).toString())));
							
							
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
							
							frame.getJlXfje().setText(xfje.toString());
							frame.getJlYsje().setText(hj.toString());
							frame.getJlHj().setText(hj.toString());
							frame.getJlYhje().setText(String.valueOf(decimalFormat.format(yhje)));
							frame.getJtfSsjr().setText(String.valueOf(decimalFormat.format(hj-Double.parseDouble(frame.getJlYsyj().getText()))));
							frame.getJlZl().setText(String.valueOf(0-Double.parseDouble(frame.getJtfSsjr().getText())));
							
							
							DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.XIAOFEIQINGDANMINGXI_CLUMN_NAME));
							frame.getJtXfqdmx().setModel(dtm);
							
							//--------------------------------------------
							
						}else{
							new HykmmsrDialog(frame,false);
							
						}
					}else{
						JOptionPane.showMessageDialog(frame, "没有此会员或此会员卡已经停用，查看会员输入是否有误!","提示信息",JOptionPane.INFORMATION_MESSAGE);
						frame.getJtfHybh().setText("普通宾客");
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
				
				
				
				
			}
		}else if(e.getSource().equals(frame.getJtfBkzf())){
		
			if(e.getKeyChar()>=KeyEvent.VK_0 && e.getKeyChar()<=KeyEvent.VK_9 || e.getKeyCode()==46||e.getKeyChar()<=KeyEvent.VK_BACK_SPACE){
				if(e.getKeyCode()==46){
					countPoint++;
					if(countPoint>=2){
						JOptionPane.showMessageDialog(frame, "'"+frame.getJtfBkzf().getText()+e.getKeyChar()+"'"+"is not a valid floating point value.","提示信息",JOptionPane.INFORMATION_MESSAGE);
						countPoint=0;
						frame.getJtfBkzf().setText("");
						frame.getJlZl().setText(String.valueOf(0-Double.parseDouble(frame.getJtfSsjr().getText())));
						return;
					}
				}
				String str="";
				if(e.getKeyChar()<=KeyEvent.VK_BACK_SPACE){
					
					if(frame.getJtfBkzf().getText().length()<=1){
						str="";
					}else{
						str=frame.getJtfBkzf().getText().substring(0, frame.getJtfBkzf().getText().length()-1);
					}
					
				}else{
					
					str=frame.getJtfBkzf().getText()+e.getKeyChar();
				}
				double ssjr=0.0;
				if(frame.getJtfSsjr().getText().length()==0||frame.getJtfSsjr().getText()==null){
					ssjr=0.0;
				}else{
					ssjr=Double.parseDouble(frame.getJtfSsjr().getText());
				}
				
				if(str.length()==0){
					frame.getJlZl().setText(String.valueOf(0-ssjr));
				}else{
					frame.getJlZl().setText(String.valueOf(Double.parseDouble(str)-ssjr));
				}
				
				
				
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.ColumnContent;
import com.view.CgjhDialog;
import com.view.ZjspCgjhDialog;

public class ZjspCgjhDialogAction implements ActionListener{

	private Vector<Vector> vector = new Vector<Vector>();
	private ZjspCgjhDialog frame;
	private Double  sum=0.0;
	private int CCKB;
	
	private CgjhDialog parent ;
	public ZjspCgjhDialogAction(ZjspCgjhDialog frame,int CCKB){
		parent = (CgjhDialog) frame.getParent();
		this.frame = frame;
		this.CCKB = CCKB;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getJbCgZjsp())){
			if(frame.getjTableSp().getSelectedRowCount()>0){
				if(!frame.getJtfPricezjsp().getText().equals("")){
					if(!frame.getJtfXfslXf().getText().equals("")){
						
						int selected = frame.getjTableSp().getSelectedRow();
						Vector<Object> data = new Vector<Object>();
						Object spbh = frame.getjTableSp().getValueAt(selected, 0);
						int i = 0;
						
						for(i=0;i<vector.size();i++){
							Object vectorSpbh = vector.get(i).get(0);
							if(spbh.equals(vectorSpbh)){
								break;
							}
							//System.out.println("商品："+vectorSpbh);
						}
						
						String spName = (String)(frame.getjTableSp().getValueAt(selected, 1));
						Object spChengBen = frame.getjTableSp().getValueAt(selected, 2);
						Object spKunCun = frame.getjTableSp().getValueAt(selected, 3);
						Object spCount = frame.getJtfXfslXf().getText();
						Object spPrice = frame.getJtfPricezjsp().getText();
						Double spMoney = Double.parseDouble(spPrice.toString())*Integer.parseInt(spCount.toString());
						
						
						if((CCKB==1)||(CCKB==2)){
							Integer XinkunCun = Integer.parseInt(spKunCun.toString())-Integer.parseInt(spCount.toString());
							if(XinkunCun<0){
								JOptionPane.showMessageDialog(frame, "库存不足，请重新选择！");
								return;
							}
							frame.getjTableSp().setValueAt(XinkunCun,selected, 3);
							//System.out.println("修改之后的库存："+frame.getjTableSp().getValueAt(selected, 3));
						}
							
						
						//判断该商品是否添加到商品清单中，如果添加到了，其价格以最开始出售的单价为准
						if(i==vector.size()){
							// (Integer)spCount;//*spPrice;
							data.add(spbh);
							data.add(spName);
							data.add("*");
							data.add(spPrice);
							data.add(spCount);
							data.add(spMoney);
							
							//System.out.println(spbh+"-"+spName+"-"+spChengBen+"-"+spCount+"-"+spPrice+"-"+spMoney);
							vector.add(data);
						}else{
							data = vector.get(i);
							
							spCount = Integer.parseInt(data.get(4).toString())+Integer.parseInt(spCount.toString());
							spMoney = Double.parseDouble(spPrice.toString())*Integer.parseInt(spCount.toString());
							
							data.setElementAt(spCount, 4);
							data.setElementAt(spMoney, 5);
							//System.out.println("Count:"+data);
						}
						
						
						DefaultTableModel model = new DefaultTableModel(vector,ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
						frame.getjTableXfqd().setModel(model);
						
						
					}else{
						JOptionPane.showMessageDialog(frame, "请输入该商品数量！");
					}
				}else{
					JOptionPane.showMessageDialog(frame, "请输入该商品价格！");
				}
			}else{
				JOptionPane.showMessageDialog(frame, "请选中一种商品！");
			}
		}else if(e.getSource().equals(frame.getMjbSaveZjsp())){
			//得到jtable中的值：先将其转化为DefaultTableModel类型然后调用getDataVector得到Vector类型
			CgjhDialog parent = (CgjhDialog) frame.getParent();
			parent.getJbdeletesp().setEnabled(true);
			parent.getJbupdatesp().setEnabled(true);
			JTable jtParent = parent.getjTableCgjh();
			DefaultTableModel dtm = (DefaultTableModel) jtParent.getModel();
			Vector<Vector> cgjhVector = dtm.getDataVector();
			Vector<Object> data = new Vector<Object>();
			
			//同商品清单一样
			int i ,j;
			for(j = 0 ;j<vector.size();j++){
				Object objSpbh = vector.get(j).get(0);
				//System.out.println("spbh:"+objSpbh);
			
				for(i=0;i<cgjhVector.size();i++){
					Object vectorSpbh = cgjhVector.get(i).get(0);
					//System.out.println("parentspbh:"+vectorSpbh);
					if(objSpbh.equals(vectorSpbh)){
						Object count = vector.get(j).get(4);
						Object objcount = cgjhVector.get(i).get(4);
						Object spPrice = vector.get(j).get(3);
						sum-=Double.parseDouble(cgjhVector.get(i).get(5).toString());
						Integer spCount = Integer.parseInt(count.toString())+Integer.parseInt(objcount.toString());
						Double spMoney = Double.parseDouble(spPrice.toString())*spCount;
						sum+=spMoney*spCount;
						cgjhVector.get(i).setElementAt(spCount, 4);
						cgjhVector.get(i).setElementAt(spMoney, 5);
						
						
						break;
					}
					//System.out.println("商品："+vectorSpbh);
				}
				
				if(i==cgjhVector.size()){
					cgjhVector.add(vector.get(j));
					sum+=Double.parseDouble(vector.get(j).get(5).toString());
				}
			}
			DefaultTableModel model = new DefaultTableModel(cgjhVector,ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
			jtParent.setModel(model);
			parent.getJtfyfzk().setText(sum.toString());
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbCancelZjsp())){
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbDeleteZjsp())){
			int selected = frame.getjTableXfqd().getSelectedRow();
			if(selected!=-1){
				int select = JOptionPane.showConfirmDialog(frame, "确定要删除该商品吗");
				if(select == 0){
					//设置商品项目中的库存
					DefaultTableModel sModel = (DefaultTableModel) frame.getjTableSp().getModel();
					for(int i = 0 ;i<sModel.getDataVector().size();i++){
						if(frame.getjTableSp().getValueAt(i, 0).equals(vector.get(selected).get(0))){
							Integer sCount = Integer.parseInt(frame.getjTableSp().getValueAt(i, 3).toString());
							if(CCKB==1){
								sCount = sCount + Integer.parseInt(vector.get(selected).get(4).toString());
								frame.getjTableSp().setValueAt(sCount, i, 3);
							}
							break;
						}
					}
					int selectedRow = frame.getjTableXfqd().getSelectedRow();
					vector.remove(selectedRow);
					DefaultTableModel model = new DefaultTableModel(vector,ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
					frame.getjTableXfqd().setModel(model);
				}else {
					return;
				}
			}else{
				JOptionPane.showMessageDialog(frame, "请选中要删除的商品！");
			}
		}
		
	}
	/*public void ZjspToCgjh(){
		int i ,j;
		DefaultTableModel dModel  = (DefaultTableModel) frame.getJbCgZjsp().getModel();
		Vector<Vector> zjVector = dModel.getDataVector();
		Vector<Vector> cgVector = parent.getVecZjsp();
		for(j = 0 ;j<zjVector.size();j++){
			Object objSpbh = zjVector.get(j).get(0);
			System.out.println("spbh:"+objSpbh);
		
			for(i=0;i<cgVector.size();i++){
				Object vectorSpbh = cgVector.get(i).get(0);
				System.out.println("parentspbh:"+vectorSpbh);
				if(objSpbh.equals(vectorSpbh)){
					Object count = vector.get(j).get(4);
					Object objcount = cgjhVector.get(i).get(4);
					Object spPrice = vector.get(j).get(3);
					sum-=Double.parseDouble(cgjhVector.get(i).get(5).toString());
					Integer spCount = Integer.parseInt(count.toString())+Integer.parseInt(objcount.toString());
					Double spMoney = Double.parseDouble(spPrice.toString())*spCount;
					sum+=spMoney*spCount;
					cgjhVector.get(i).setElementAt(spCount, 4);
					cgjhVector.get(i).setElementAt(spMoney, 5);
					
					
					break;
				}
				//System.out.println("商品："+vectorSpbh);
			}
			
			if(i==cgjhVector.size()){
				cgjhVector.add(vector.get(j));
				sum+=Double.parseDouble(vector.get(j).get(5).toString());
			}
		}
	}
	*/

}

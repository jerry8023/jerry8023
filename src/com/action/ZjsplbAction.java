package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodstypeDao;
//import com.util.ColumnConstant;
import com.util.ColumnContent;
import com.view.AppMainFrame;
import com.view.XtszDialog;
import com.view.ZjsplbDialog;
import com.vo.GoodstypeVo;

public class ZjsplbAction implements ActionListener{
	
	
	
	
    private ZjsplbDialog frame;
    private XtszDialog parent;
    private JTable xtszTable;
	public ZjsplbAction(ZjsplbDialog frame){
		this.frame=frame;
		
		this.parent = (XtszDialog)frame.getParent();
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getJbsave())){
			
			
			
			if(frame.addOrUpdate==ZjsplbDialog.ADD){
				
				
				
			GoodstypeVo vo=new GoodstypeVo();
			
			String strgtname=frame.getJtsplb().getText();
			if(strgtname.length()==0){
				JOptionPane.showMessageDialog(frame, "商品类别不能为空！！！");
				return;
			}else{
				GoodstypeDao gtDao=new GoodstypeDao();
				try {
					GoodstypeVo gtvo=gtDao.getVoByGtname(strgtname);
					if(gtvo!=null){
						JOptionPane.showMessageDialog(frame, "此商品类别已存在!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "数据库异常");
					e1.printStackTrace();
				}
			}
			
			
			vo.setGtname(strgtname);
				
			if(frame.getJabxy().isSelected()==true){
				vo.setIsserve(1);
				
			}else if(frame.getJabbxy().isSelected()==true){
				vo.setIsserve(2);
				
			}
			
			GoodstypeDao  gtdao=new GoodstypeDao();	
			boolean flage=gtdao.saveGoodstype(vo);
			if (flage == true) {
				//JOptionPane.showMessageDialog(frame, "添加成功");
				// 添加成功后，再查询一次数据库，刷新JTable中的值
				 parent = (XtszDialog)frame.getParent();
				 xtszTable = parent.getjTableSplx();

				Vector<Vector> data = null;
				try {
					data = gtdao.queryDate();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "查询失败");
					e1.printStackTrace();
                  return;
				}

				// 如何刷新JTable中的数据/
				DefaultTableModel dtm = new DefaultTableModel(
						data,
						ColumnContent
								.arrayToVector(ColumnContent.SHANGPINLEIBIE_CLUMN_NAME));
				xtszTable.setModel(dtm);
				
				frame.dispose();

			} else {
				JOptionPane.showMessageDialog(frame, "商品类别不能为空！！！");

			}
			
			
			}else if(frame.addOrUpdate==ZjsplbDialog.UPDATE){
			    	
			   JTable jTable=parent.getjTableSplx();
			   GoodstypeVo vo=new GoodstypeVo();
			   int selectedRow=jTable.getSelectedRow();
				
				if(selectedRow!=-1){
					
				    Object values = jTable.getValueAt(selectedRow, 0);	
					vo.setGtid(Integer.parseInt(values.toString()));
					//System.out.println(vo);
					
				}else {
					
					
					JOptionPane.showMessageDialog(frame, "请选择要修改的数据");
					return;
					
				}


				String strgtname=frame.getJtsplb().getText();
				if(strgtname.length()==0){
					JOptionPane.showMessageDialog(frame, "商品类别不能为空！！！");
					return;
				}else{
					GoodstypeDao gtDao=new GoodstypeDao();
					try {
						GoodstypeVo gtvo=gtDao.getVoByGtname(strgtname);
						if(gtvo!=null && !strgtname.equals(parent.getjTableSplx().getValueAt(parent.getjTableSplx().getSelectedRow(), 1).toString())){
							JOptionPane.showMessageDialog(frame, "此商品类别已存在!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
				}
				
				    vo.setGtname(strgtname);
					
					
				if(frame.getJabxy().isSelected()==true){
					vo.setIsserve(1);
					
				}else if(frame.getJabbxy().isSelected()==true){
					vo.setIsserve(2);
					
				}
				//System.out.println("-------"+vo);
				GoodstypeDao  gtdao=new GoodstypeDao();	
				boolean flage=gtdao.updateGoodstype(vo);
				if (flage == true) {
					
					//JOptionPane.showMessageDialog(frame, "修改成功");
					// 添加成功后，再查询一次数据库，刷新JTable中的值
					XtszDialog parent = (XtszDialog)frame.getParent();
					JTable xtszTable = parent.getjTableSplx();

					Vector<Vector> data = null;
					try {
						data = gtdao.queryDate();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "查询失败");
						e1.printStackTrace();
						return;
					}

					// 如何刷新JTable中的数据/
					DefaultTableModel dtm = new DefaultTableModel(
							data,
							ColumnContent
									.arrayToVector(ColumnContent.SHANGPINLEIBIE_CLUMN_NAME));
					xtszTable.setModel(dtm);
					
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(frame, "修改失败");

				}
			
			      }
			
			}else if(e.getSource().equals(frame.getJbcancel())){
				
				frame.dispose();
			}
		
}

	
}

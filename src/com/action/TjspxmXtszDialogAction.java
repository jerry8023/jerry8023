package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import oracle.net.nt.NTAdapter;

import com.dao.GoodsDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.TjspxmXtszDialog;
import com.view.XtszDialog;
import com.vo.GoodsVo;

public class TjspxmXtszDialogAction implements ActionListener{
	
	private TjspxmXtszDialog frame;
	
	public TjspxmXtszDialogAction( TjspxmXtszDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getMjbSaveTjsp())){
			
			String strGid=frame.getJtfxmbmTjsp().getText();
			Integer gid=null;
			if(strGid==null || strGid.length()==0){
				JOptionPane.showMessageDialog(frame, "项目编码不能为空!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			GoodsDao gDao=new GoodsDao();
			if(YanZhengUtil.isShuZi(strGid)){
				gid=Integer.parseInt(strGid);
				if(TjspxmXtszDialog.yongtu==1){
					try {
						GoodsVo gVo = gDao.getDoodsByGid(gid);
						if(gVo!=null){
							JOptionPane.showMessageDialog(frame, "此商品或编码已存在!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(frame, "项目编码必须为整数!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
				
			Integer gtid=frame.getMjbxmlbTjsp().getValues().get(frame.getMjbxmlbTjsp().getSelectedIndex());
			Double price=0.0;
			if(frame.getMjbjffsTjsp().getSelectedItem().equals("预设单价")){
				String strPrice=frame.getJtfysdjTjsp().getText();
				if(strPrice.length()==0 || strPrice==null){
					JOptionPane.showMessageDialog(frame, "预设单价不能为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(strPrice.matches("[0-9]*[.]?[0-9]+")){
					price=Double.parseDouble(strPrice);
				}else{
					JOptionPane.showMessageDialog(frame, "预设单价格式不正确", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}/*else{
				
			}*/
			
			Integer jfid=frame.getMjbjffsTjsp().getValues().get(frame.getMjbjffsTjsp().getSelectedIndex());
			
			
			Integer oid=LoginAction.getDqOid();
			String gname=frame.getJtfxmmcTjsp().getText();
			if(gname.length()==0){
				JOptionPane.showMessageDialog(frame, "项目名称不能为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else{
				if(TjspxmXtszDialog.yongtu==1){
					try {
						if(gDao.getVoByGname(gname)!=null){
							JOptionPane.showMessageDialog(frame, "此商品或编码已存在!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
				}else if(TjspxmXtszDialog.yongtu==2){
					try {
						XtszDialog xtszDialog=(XtszDialog)frame.getParent();
						if(gDao.getVoByGname(gname)!=null && (!gDao.getVoByGname(gname).getDname().equals(xtszDialog.getjTableSp().getValueAt(xtszDialog.getjTableSp().getSelectedRow(), 1).toString()))){
							JOptionPane.showMessageDialog(frame, "此商品或编码已存在!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常");
						e1.printStackTrace();
					}
				}
			}
			
			
			String jp=frame.getJtfxmjpTjsp().getText();
			if(jp.length()==0){
				JOptionPane.showMessageDialog(frame, "项目简拼不能为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			String jjdw=frame.getJtfjjdwTjsp().getText();
			
			Double cost=0.0;
			String strCost=frame.getJtfdwcbTjsp().getText();
			if(strCost.length()==0 || strCost==null){
				JOptionPane.showMessageDialog(frame, "单位成本不能为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(strCost.matches("[0-9]*[.]?[0-9]+")){
				cost=Double.parseDouble(strCost);
			}else{
				JOptionPane.showMessageDialog(frame, "单位成本格式不正确", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Integer warnstock=0;
			String strwarnstock=frame.getJtfbjkcTjsp().getText();
			if(strwarnstock!=null && strwarnstock.length()!=0){
				warnstock=Integer.parseInt(strwarnstock);
			}
			
			Integer dhjf=null;
			if(frame.getJcbthspTjsp().isSelected()){
				String strdhjf=frame.getJtfdhjfTjsp().getText();
				if(strdhjf.length()==0||strdhjf==null){
					JOptionPane.showMessageDialog(frame, "兑换积分不能为空", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				dhjf=Integer.parseInt(strdhjf);
			}else{
				dhjf=null;
			}
			
			Integer iszdskc=null;
			if(frame.getJcbzdskcTjsp().isSelected()){
				iszdskc=1;
			}else{
				iszdskc=2;
			}
			
			Integer isdh=null;
			if(frame.getJcbthspTjsp().isSelected()){
				isdh=1;
			}else{
				isdh=2;
			}
			
			if(TjspxmXtszDialog.yongtu==1){
				Object[] values=new Object[]{gid,gtid,oid,gname,jp,jjdw,price,cost,0,iszdskc,warnstock,isdh,dhjf,jfid};
				GoodsDao goodsDao=new GoodsDao();
				int val=goodsDao.insertData(values);
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "添加失败", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					try {
						Vector<Vector> rowdatesSp=goodsDao.queryDate();
						DefaultTableModel dtm=new DefaultTableModel(rowdatesSp,  ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
						((XtszDialog)frame.getParent()).getjTableSp().setModel(dtm);
						frame.dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			}else if(TjspxmXtszDialog.yongtu==2){
				Object[] values=new Object[]{gtid,oid,gname,jp,jjdw,price,cost,0,iszdskc,warnstock,isdh,dhjf,jfid,gid};
				GoodsDao goodsDao=new GoodsDao();
				int val=goodsDao.updateDataByGid(values);
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "修改失败", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					try {
						Vector<Vector> rowdatesSp=goodsDao.queryDate();
						DefaultTableModel dtm=new DefaultTableModel(rowdatesSp,  ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
						((XtszDialog)frame.getParent()).getjTableSp().setModel(dtm);
						frame.dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据库异常", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
			
		}else if(e.getSource().equals(frame.getMjbCancelTjsp())){
			
			frame.dispose();
			
		}else if(e.getSource().equals(frame.getMjbtjxmTjsp())){
			
			
		}
		
	}

	
}

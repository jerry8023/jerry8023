package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodsDao;
import com.dao.GoodsstoreDao;
import com.dao.HuowuDao;
import com.dao.HwdetailDao;
import com.jdbc.util.JdbcUtil;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.CajhDialogWindow;
import com.view.CgjhDialog;
import com.view.UpdateCgjhDialog;
import com.view.ZjspCgjhDialog;
import com.vo.GoodsstoreVo;
import com.vo.HuowuVo;
import com.vo.HwdetailVo;

public class CgjhDialogAction implements ActionListener,ComponentListener{

	private CgjhDialog frame;
	private CajhDialogWindow window = null;
	private Double money = 0.0 ;
	
	private int CCKB;
	public CgjhDialogAction(CgjhDialog frame,int CCKB){
		this.frame = frame;
		this.CCKB = CCKB;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbghdw())){
			window = new CajhDialogWindow(frame);
		}else if(e.getSource().equals(frame.getJbaddsp())){
			if(CCKB==0||CCKB==1){
				if(frame.getJtfghdw().getText().equals("")){
					JOptionPane.showMessageDialog(frame, "请选择供货单位！");
					return;
				}
			}
			new ZjspCgjhDialog(frame,false,CCKB);
		}else if(e.getSource().equals(frame.getJbupdatesp())){
			if(frame.getjTableCgjh().getSelectedRowCount()>0){
				new UpdateCgjhDialog(frame,false);
			}else{
				JOptionPane.showMessageDialog(frame, "请选中要修改的商品！");
			}
		}else if(e.getSource().equals(frame.getJbdeletesp())){
			int selected = frame.getjTableCgjh().getSelectedRow();
			if(selected!=-1){
				int select = JOptionPane.showConfirmDialog(frame, "确定要删除该商品吗");
				if(select == 0){
					DefaultTableModel m = (DefaultTableModel) frame.getjTableCgjh().getModel();
					Vector<Vector> vector = m.getDataVector();
					money = Double.parseDouble(frame.getJtfyfzk().getText())-Double.parseDouble(vector.get(selected).get(5).toString());
					vector.remove(selected);
					DefaultTableModel model = new DefaultTableModel(vector,ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
					frame.getjTableCgjh().setModel(model);
					frame.getJtfyfzk().setText(money.toString());
				}
			}else{
				JOptionPane.showMessageDialog(frame, "请选中要删除的商品！");
			}
		}else if(e.getSource().equals(frame.getJbsave())){
			if(frame.getjTableCgjh()!=null){
				
				//得到货单编号
				String hdbh = frame.getJtfhdbh().getText();
				
				//得到仓库的编号
				int selectedc = frame.getJcmxzck().getSelectedIndex();
				HashMap<Integer, Integer> cMap = frame.getJcmxzck().getValues();
				Integer xzck = cMap.get(selectedc);
				
				
				//得到操作员的编号
				int selectedo = frame.getJcmxzck().getSelectedIndex();
				HashMap<Integer, Integer> oMap = frame.getJcmxzck().getValues();
				Integer ygbh = oMap.get(selectedo);
				
				
				java.sql.Date tdrq = null;
				try {
					tdrq = new Date(frame.getJdptdrq().getSelectedDate().getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println("填单日期："+tdrq);
				
				String hdbz = frame.getJtfhdbz().getText();
				
				HuowuDao hwDao = new HuowuDao();
				HuowuVo hwVo = new HuowuVo();
				
				if((CCKB==CgjhDialog.CGJH)||(CgjhDialog.CGTH==CCKB)){
					boolean flag = false;
					if(Double.parseDouble(frame.getJtfsfzk().getText())>=Double.parseDouble(frame.getJtfyfzk().getText())){
						flag=true;
					}else{
						int selected = JOptionPane.showConfirmDialog(frame, "实际付款小于应付账款，确定要结账吗？");
						if(selected==0){
							flag = true;
						}
					}
						
					if(flag){	
					
						//得到供货单位的编号
						int selectedWindow = window.getJtsupplier().getSelectedRow();
						DefaultTableModel ghModel = (DefaultTableModel) window.getJtsupplier().getModel();
						Vector<Vector> ghVector = ghModel.getDataVector();
						Integer ghdw = Integer.parseInt(ghVector.get(selectedWindow).get(0).toString());
					
						
						hwVo.setHid(hdbh);
						hwVo.setOid(ygbh);
						hwVo.setSid(ghdw);
						hwVo.setYfzk(Double.parseDouble(frame.getJtfyfzk().getText()));
						hwVo.setSfzk(Double.parseDouble(frame.getJtfsfzk().getText()));
						hwVo.setRemarks(hdbz);
						hwVo.setTddate(tdrq);
						
						boolean hwflag = false;
						if(CCKB==0){
							hwVo.setState(1);
							hwVo.setDrsh(xzck);
						}else if(CCKB==1){
							hwVo.setState(2);
							hwVo.setDcsh(xzck);
						}
						
						hwflag =   hwDao.insertHw(hwVo,CCKB);
						if(hwflag){
							//System.out.println(":货单表数据添加成功！");
						}
						
						
						DefaultTableModel model = (DefaultTableModel) frame.getjTableCgjh().getModel();
						Vector<Vector> vector = model.getDataVector();
						Double sum=0.0; //计算总金额
						for(int i = 0 ;i<vector.size();i++){
							
							//表中得到商品的编号及价格跟数量
							Integer id = Integer.parseInt(vector.get(i).get(0).toString());
							Double price = Double.parseDouble(vector.get(i).get(3).toString());
							Integer count = Integer.parseInt(vector.get(i).get(4).toString());
							sum += Double.parseDouble(vector.get(i).get(4).toString());
							GoodsDao gDao = new GoodsDao();
							boolean gflag =  gDao.updateDataById(id, count,CCKB);
							if(gflag){
								//System.out.println(id+":商品表数据添加成功！");
							}
							
							
							HwdetailVo hwdVo = new HwdetailVo();
							hwdVo.setGid(id);
							hwdVo.setHid(hdbh);
							hwdVo.setPrice(price);
							hwdVo.setNumbers(count);
							HwdetailDao hwdDao = new HwdetailDao();
							boolean hwdflag = hwdDao.insertHwdData(hwdVo);
							if(hwdflag){
								//System.out.println(id+":货单详情表数据添加成功！");
							}
							
							//当添加仓库时需要将商品仓库表中的数据插入，将商品表中属于商品类的数据与仓库表对应库存置0
							GoodsstoreVo gsVo = new GoodsstoreVo();
							gsVo.setGid(id);
							gsVo.setShid(xzck);
							gsVo.setKucun(count);
							GoodsstoreDao gsDao = new GoodsstoreDao();
							boolean gsflag = gsDao.updateGsData(gsVo,CCKB);
							if(gsflag){
								//System.out.println(id+":商品库存表数据更新成功！");
							}else{
								gsflag = gsDao.insertGsData(gsVo);
								//System.out.println(id+":商品库存表数据添加成功！");
							}
						}
						frame.getJtfyfzk().setText(sum.toString());
						frame.dispose();
						
					}
				
				}else if((CCKB==2)||(CCKB==3)){
					Integer drck = null;
					if(CCKB==2){
						//得到调入仓库的编号
						int selectedr = frame.getMjbdrck().getSelectedIndex();
						HashMap<Integer, Integer> rMap = frame.getMjbdrck().getValues();
						drck = rMap.get(selectedr);
						hwVo.setDrsh(drck);
						hwVo.setState(3);
						
						
					}else if(CCKB==3){
						int selected = frame.getMjbbsby().getSelectedIndex();
						HashMap<Integer, Integer> map = frame.getMjbbsby().getValues();
						int idbs = map.get(selected);
						//System.out.println("状态："+idbs);
						hwVo.setState(idbs+4);
						hwVo.setYfzk(Double.parseDouble(frame.getJtfyfzk().getText()));	
					}
					
					hwVo.setHid(hdbh);
					hwVo.setOid(ygbh);
					hwVo.setDcsh(xzck);
					hwVo.setRemarks(hdbz);
					hwVo.setTddate(tdrq);
					
					boolean hwflag = false;
					hwflag =   hwDao.insertHw(hwVo,CCKB);
					if(hwflag){
						//System.out.println(":货单表数据添加成功！");
					}
					
					
					DefaultTableModel model = (DefaultTableModel) frame.getjTableCgjh().getModel();
					Vector<Vector> vector = model.getDataVector();
					Double sum=0.0; //计算总金额
					for(int i = 0 ;i<vector.size();i++){
						
						//表中得到商品的编号及价格跟数量
						Integer id = Integer.parseInt(vector.get(i).get(0).toString());
						Double price = Double.parseDouble(vector.get(i).get(3).toString());
						Integer count = Integer.parseInt(vector.get(i).get(4).toString());
						sum += Double.parseDouble(vector.get(i).get(4).toString());
						
						
						HwdetailVo hwdVo = new HwdetailVo();
						hwdVo.setGid(id);
						hwdVo.setHid(hdbh);
						hwdVo.setPrice(price);
						hwdVo.setNumbers(count);
						HwdetailDao hwdDao = new HwdetailDao();
						boolean hwdflag = hwdDao.insertHwdData(hwdVo);
						if(hwdflag){
							//System.out.println(id+":货单详情表数据添加成功！");
						}
						
						//当添加仓库时需要将商品仓库表中的数据插入，将商品表中属于商品类的数据与仓库表对应库存置0
						if(CCKB==2){
							GoodsstoreVo gsVo = new GoodsstoreVo();//调出仓库的Vo
							GoodsstoreVo gsVoc = new GoodsstoreVo();//调入仓库的Vo
							
							gsVo.setGid(id);
							gsVoc.setGid(id);
							gsVo.setShid(drck);
							gsVoc.setShid(xzck);
							gsVo.setKucun(count);
							gsVoc.setKucun(count);
							GoodsstoreDao gsDao = new GoodsstoreDao();
							//System.out.println("gid:"+id+"shid:"+drck+"kucun:"+count);
							//System.out.println("gid"+id+"cshid:"+xzck+"kucun:"+count);
							boolean gsrflag = gsDao.updateGsData(gsVoc,1);
							//if(gsrflag)
								//System.out.println(id+":商品出库表更新成功！");
							boolean gsflag = gsDao.updateGsData(gsVo,0);
							if(gsflag){
								//System.out.println(id+":商品库存表数据更新成功！");
							}else{
								gsflag = gsDao.insertGsData(gsVo);
								//System.out.println(id+":商品库存表数据添加成功！");
							}
						}
						
					}
					if(CCKB==3){
						frame.getJtfyfzk().setText(money.toString());
					}
					frame.dispose();
				}
			
				
			}else{
				JOptionPane.showMessageDialog(frame, "采购数据不能为空！");
				return;
			}
		}else if(e.getSource().equals(frame.getJbclose())){
			frame.dispose();
		}
		
		
	}
	
	public void move(){
		JTextField jtf = frame.getJtfghdw(); 
		int x = jtf.getX();
		int y = jtf.getY();
		//System.out.println("文本框在CgihDialog中的X值为:"+(x+frame.getX()) +" Y："+(y+frame.getY()));
		if(window!=null){
			window.setLocation(x+frame.getX()+8,y+frame.getY()+93);
		}
		
	}

	
	public void componentMoved(ComponentEvent e) {
		move();
	}

	
	public void componentResized(ComponentEvent e) {
		move();
		
	}

	
	public void componentHidden(ComponentEvent e) {
		
		
	}

	public void componentShown(ComponentEvent e) {
		
		move();
	}

	
	

}

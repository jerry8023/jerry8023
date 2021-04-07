package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojianDao;
import com.dao.BaojiantypeDao;
import com.dao.FuwushengDao;
import com.dao.GoodsDao;
import com.dao.GoodstypeDao;
import com.dao.MgradeDao;
import com.dao.SgradeDao;
import com.util.ColumnContent;
import com.view.DxdzDialog;
import com.view.FwsxxxgDialog;
import com.view.PlzjbjDialog;
import com.view.TcszDialog;
import com.view.TjspxmXtszDialog;
import com.view.XgbjlxDialog;
import com.view.XtszDialog;
import com.view.ZjbjDialog;
import com.view.ZjfwsdjDialog;
import com.view.ZjhydjDialog;
import com.view.ZjsplbDialog;
import com.vo.BaojianVo;
import com.vo.BaojiantypeVo;
import com.vo.GoodstypeVo;
import com.vo.MgradeVo;
import com.vo.SgradeVo;

public class XtszAction implements ActionListener{

	private XtszDialog frame;
	public XtszAction(XtszDialog frame){
		this.frame = frame;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JTable jtbj = frame.getjTableBj();
		if(e.getSource()==frame.getJbDgtjBj()){
			new ZjbjDialog(frame,true,ZjbjDialog.ADD);
		}else if(e.getSource()==frame.getJbPltjBj()){
			new PlzjbjDialog(frame,true);
		}else if(e.getSource()==frame.getJbXgBj()){
			int selectedCount = jtbj.getSelectedRowCount();
			if(selectedCount==1){
				ZjbjDialog zjbjDialog = new ZjbjDialog(frame,false,ZjbjDialog.UPDATE);
				int selectedRow = jtbj.getSelectedRow();
				
				Object bjbh = jtbj.getValueAt(selectedRow, 0);
				Object bjlx = jtbj.getValueAt(selectedRow, 1);
				
			    Object szqy = jtbj.getValueAt(selectedRow, 3);
			    zjbjDialog.getJcmBjlxzjbj().setSelectedItem(bjlx);
			    zjbjDialog.getJtfbjbhzjbj().setText(bjbh.toString());
			    
			    zjbjDialog.getJtfszqyzjzb().setText(szqy.toString());
			}else{
				JOptionPane.showMessageDialog(frame, "��ѡ��һ��Ҫ�޸ĵ����ݡ�");
			}
		}else if(e.getSource()==frame.getJbScbj()){
			
			int selectedRow = jtbj.getSelectedRow();
			if(selectedRow!=-1){
				JOptionPane.showMessageDialog(frame, "ɾ���󽫲��ָܻ������Ҫɾ����");
				Object values = jtbj.getValueAt(selectedRow, 0);
				//System.out.println("��"+(selectedRow+1)+"��,��1�е�ֵΪ:"+values);
				BaojianDao dao = new BaojianDao();
				if(dao.deleteId(values)==1){
					//System.out.println("ɾ���ɹ�");
					JTable  jtMainFrame  = frame.getjTableBj();
					Vector<Vector> data = null;
					try{
						data = dao.queryDate();
					}catch(Exception e1){
						
						e1.printStackTrace();
						return ;
					}
					DefaultTableModel model = new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.BAOJIAN_CLUMN_NAME));
					jtMainFrame.setModel(model);
				}else{
					JOptionPane.showConfirmDialog(frame, "ɾ��δ�ɹ�");
				}
			}else{
				JOptionPane.showConfirmDialog(frame, "��ѡ��Ҫɾ�������ݣ�");
			}
			
		}else if(e.getSource()==frame.getMjcbBjlx()){
			BaojianDao baojianDao = new BaojianDao();
			int selected = frame.getMjcbBjlx().getSelectedIndex();
			//System.out.println("�����������ƣ�"+bjlxName);
			HashMap<Integer, Integer> hashMap = frame.getMjcbBjlx().getValues();
			int bjtid = hashMap.get(selected);
			//System.out.println("�������ͱ�ţ�"+bjtid);
			JTable  jtMainFrame  = frame.getjTableBj();
			Vector<Vector> dataVector = null;
			try{
				if(bjtid==(-2)){
					dataVector = baojianDao.queryDate();
				}else{
					dataVector = baojianDao.queryDataById(bjtid);
				}
			}catch(Exception e1){
				
				e1.printStackTrace();
				return ;
			}
			
			DefaultTableModel model = new DefaultTableModel(dataVector,ColumnContent.arrayToVector(ColumnContent.BAOJIAN_CLUMN_NAME));
			jtMainFrame.setModel(model);
		}else if(e.getSource().equals(frame.getJbTjSplx())){
			
			ZjsplbDialog zld=new ZjsplbDialog (frame,true,ZjsplbDialog.ADD);
			
		}else if(e.getSource().equals(frame.getJbXgSplx())){
			JTable jTable=frame.getjTableSplx();
			int selectedRow=jTable.getSelectedRow();
			if(selectedRow!=-1){
				new ZjsplbDialog (frame,true,ZjsplbDialog.UPDATE);
			
			}else {
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ�޸ĵ�����");
				return;
			}
			
		}else if(e.getSource().equals(frame.getJbScSplx())){
			JTable jTable=frame.getjTableSplx();
			int selectedRow=jTable.getSelectedRow();
			if (selectedRow!=-1){
				//��ñ�ѡ�е����е�ĳһ�е�ֵ			
				Object values = jTable.getValueAt(selectedRow, 0);
				int val=JOptionPane.showConfirmDialog(frame, "ɾ���󽫲��ָܻ������Ҫɾ��?","��ʾ��Ϣ",JOptionPane.OK_CANCEL_OPTION);
				if(val==JOptionPane.OK_OPTION){
			        GoodstypeVo vo=new GoodstypeVo();
	                vo.setGtid(Integer.parseInt(values.toString()));	
			        GoodstypeDao  gtdao=new GoodstypeDao();	
					boolean flage=gtdao.deleteGoodstype(vo);
						if (flage == true) {
						//JOptionPane.showMessageDialog(frame, "ɾ���ɹ�");
	             		// ��ӳɹ����ٲ�ѯһ�����ݿ⣬ˢ��JTable�е�ֵ
						//frame.getjTableSplx()
						//XtszDialog parent = (XtszDialog)frame.getParent();
						JTable xtszTable = frame.getjTableSplx();
			            Vector<Vector> data = null;
						try {
							data = gtdao.queryDate();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, "��ѯʧ��");
							e1.printStackTrace();
		        			return;
						}
	         			// ���ˢ��JTable�е�����/
						DefaultTableModel dtm = new DefaultTableModel(
								data,
								ColumnContent
										.arrayToVector(ColumnContent.SHANGPINLEIBIE_CLUMN_NAME));
						xtszTable.setModel(dtm);
						
						
	
					} else {
						JOptionPane.showMessageDialog(frame, "ɾ��ʧ��");
	
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫɾ��������");
			}
			
		}else if(e.getSource().equals(frame.getJbTcszSp())){
			
			int index=frame.getjTableSp().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ��ɵ�һ��!","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			String splb=frame.getjTableSp().getValueAt(index, 5).toString();
			GoodstypeDao gtDao=new GoodstypeDao();
			try {
				GoodstypeVo gtvo=gtDao.getVoByGtname(splb);
				if(gtvo.getIsserve()==2){
					JOptionPane.showMessageDialog(frame, "��ǰ��������Ŀ����������Ŀ���!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					new TcszDialog(frame, true);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
				e1.printStackTrace();
			}
			
		}else if(e.getSource().equals(frame.getJbTjHydj())){
			
			new ZjhydjDialog(frame,true,ZjhydjDialog.ADD);
			
		}else if(e.getSource().equals(frame.getJbXgHydj())){
			
			JTable  jp=frame.getjTableHydj();
			int selectRow=jp.getSelectedRow();
			if(selectRow!=-1){
				ZjhydjDialog zd =new ZjhydjDialog(frame,true,ZjhydjDialog.UPDATE);
			}else {
				JOptionPane.showMessageDialog(frame, "��ѡ����Ҫ�޸ĵ�����");
			}
			
		}else if(e.getSource().equals(frame.getJbScHydj())){
			
			MgradeVo vo=new MgradeVo();
			MgradeDao dao=new MgradeDao();
			JTable jtable=frame.getjTableHydj();
			int selectedRow=jtable.getSelectedRow();
			if(selectedRow!=-1){
				Object values=jtable.getValueAt(selectedRow, 0);
				vo.setMgid(Integer.parseInt(values.toString()));
				
			}else{
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫɾ��������");
				return;
			}
			int val=JOptionPane.showConfirmDialog(frame, "�h���󌢲��ܻ֏ͣ����Ҫ�h��?","��ʾ��Ϣ",JOptionPane.OK_CANCEL_OPTION);
		
			if(val==JOptionPane.OK_OPTION){
				boolean falge=dao.deleteMgrdae(vo);
				if(falge==true){
					
					//JOptionPane.showMessageDialog(frame, "����ɾ���ɹ�");
					Vector<Vector> data=null;
					
					try {
						data=dao.queryDate();
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					DefaultTableModel dtm=new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
					jtable.setModel(dtm);
					
					
				}else{
					JOptionPane.showMessageDialog(frame,"����ɾ��ʧ��");
				}
			}
			
		}else if(e.getSource().equals(frame.getJbGbHydj())){
			
			frame.dispose();
			
		}else if(e.getSource().equals(frame.getJbTjFwsdj())){
		
			new ZjfwsdjDialog(frame, true, ZjfwsdjDialog.ADD);
			
		}else if(e.getSource().equals(frame.getJbXgFwsdj())){
			
			 JTable fwsdjTable=frame.getjTableFwsdj();
			 int selectedRow=fwsdjTable.getSelectedRow();
			 
			 if(selectedRow!=-1){
				 ZjfwsdjDialog  zjfwsdjDialog= new ZjfwsdjDialog(frame,true, ZjfwsdjDialog.UPDATE);
			 }else{
				 JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ�޸ĵ����ݣ�");
				 return;
			 }
			
			 
		}else if(e.getSource().equals(frame.getJbScFwsdj())){
			
				JTable fwsdjTable=frame.getjTableFwsdj();
				int selectedRow=fwsdjTable.getSelectedRow();//��ñ�ѡ���У�δѡ�з���-1��
				if(selectedRow!=-1){
				Object  values1=fwsdjTable.getValueAt(selectedRow, 0);
				//Object  values2=fwsdjTable.getValueAt(selectedRow, 1);
				//JOptionPane.showMessageDialog(frame, "ȷ��Ҫɾ���������ݣ�");
				int val=JOptionPane.showConfirmDialog(frame, "ȷ��Ҫɾ���������ݣ�", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
				if(val==JOptionPane.OK_OPTION){
					SgradeVo  sgradeVo=new SgradeVo();
					sgradeVo.setSgid(Integer.parseInt(values1.toString()));
					//sgradeVo.setSgname(values2.toString());
					
					SgradeDao sgradeDao=new SgradeDao();
					
					boolean flag=sgradeDao.deleteSgrade(sgradeVo);
					
					if(flag==true){
						//JOptionPane.showMessageDialog(frame, "ɾ���ɹ���");
						//ˢ�±�������
						JTable jTable  = frame.getjTableFwsdj();
						
						Vector<Vector> data=null;
						
						try {
							data=sgradeDao.querySgrade();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame, "��ѯʧ�ܣ�");
							e1.printStackTrace();
							return;
						}
						DefaultTableModel dtm=new DefaultTableModel(data, ColumnContent.arrayToVector(ColumnContent.FUWUSHENGDENGJI_CLUMN_NAME));
						jTable.setModel(dtm);
						
					}else{
						
						JOptionPane.showMessageDialog(frame, "ɾ��ʧ�ܣ�");
					}
				}
				//---------------------------
			}else{
				JOptionPane.showMessageDialog(frame, "��ѡ����Ҫɾ�������ݣ�");
			}
				
			
		}else if(e.getSource().equals(frame.getJbTjFws())){
			
			new FwsxxxgDialog(frame, true,FwsxxxgDialog.ADD);
			
		}else if(e.getSource().equals(frame.getJbXgFws())){
			int index=frame.getjTableFws().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "Ո�x��Ҫ�޸ĵ�һ��");
				return;
			}
			
			new FwsxxxgDialog(frame, true,FwsxxxgDialog.UPDATE);
			
		}else if(e.getSource().equals(frame.getJbScFws())){
			int index=frame.getjTableFws().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "Ո�x��Ҫɾ����һ��");
				return;
			}
			int res=JOptionPane.showConfirmDialog(frame, "ɾ���󽫲��ָܻ�,���Ҫɾ��?", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(res==JOptionPane.OK_OPTION){
				int fwsid=Integer.parseInt(frame.getjTableFws().getValueAt(index, 0).toString());
				FuwushengDao fwsDao=new FuwushengDao();
				int val=fwsDao.deleteData(fwsid);
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "ɾ��ʧ��!");
				}else{
					try {
						Vector<Vector> rowdatas=fwsDao.queryDate();
						DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.FUWUSHENG1_CLUMN_NAME));
						frame.getjTableFws().setModel(dtm);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "���ݿ��쳣");
						e1.printStackTrace();
					}
				}
			}
			
		}else if(e.getSource().equals(frame.getJbTjBjlx())){
			
			new XgbjlxDialog(frame, true, XgbjlxDialog.TIANJIA);
			
		}else if(e.getSource().equals(frame.getJbXgBjlx())){
			int index=frame.getjTableBjlx().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "Ո�x��Ҫ�޸ĵ�һ��");
				return;
			}
			new XgbjlxDialog(frame, true, XgbjlxDialog.XIUGAI);

			
		}else if(e.getSource().equals(frame.getJbScBjlx())){
			
			int val=JOptionPane.showConfirmDialog(frame, "ɾ���˰���ϵ���ͽ���ͬ���ڴ˰������͵İ���ȫ��ɾ�������Ҫɾ����", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			
			if(val==JOptionPane.OK_OPTION){
				
				int index=frame.getjTableBjlx().getSelectedRow();
				if(index==-1){
					JOptionPane.showMessageDialog(frame, "Ո�x��Ҫɾ����һ��");
					return;
				}
				
				String bjtyname=frame.getjTableBjlx().getValueAt(index, 0).toString();
				BaojiantypeDao bjtDao=new BaojiantypeDao();
				BaojianDao bjDao=new BaojianDao();
				BaojiantypeVo voBjt;
				try {
					voBjt = bjtDao.getVoByBjtname(bjtyname);
					int bjtid=voBjt.getBjtid();
					ArrayList<BaojianVo> bjDatas=bjDao.getAllBjByBjtid(bjtid);
					for(BaojianVo vo:bjDatas){
						bjDao.deleteId(vo.getBjid());
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "�����쮐��");
					e1.printStackTrace();
				}
				
				int res=bjtDao.deleteDataByBtyname(bjtyname);
				if(res<=0){
					JOptionPane.showMessageDialog(frame, "ɾ��ʧ��");
				}else{
					
					try {
						Vector<Vector> rowdatas=bjtDao.queryDate();
						DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.BAOJIANLEIXING_CLUMN_NAME));
						frame.getjTableBjlx().setModel(dtm);
						
						Vector<Vector> rowdataBj=bjDao.queryDate();
						DefaultTableModel dtmBj=new DefaultTableModel(rowdataBj, ColumnContent.arrayToVector(ColumnContent.BAOJIAN_CLUMN_NAME));
						frame.getjTableBj().setModel(dtmBj);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "�����쮐��");
						e1.printStackTrace();
					}
				}
				
			}
			
			
		}else if(e.getSource().equals(frame.getJbBjfdzBjlx())){
			
			int index=frame.getjTableBjlx().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ���۵�һ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			new DxdzDialog(frame, true,DxdzDialog.BAOJIANLXDZ);
			
		}else if(e.getSource().equals(frame.getMjcbSplx())){
			int index=frame.getMjcbSplx().getSelectedIndex();
			GoodsDao goodsDao=new GoodsDao();
			Vector<Vector> rowdatas = null;
			if(index!=0){
				int gtid=frame.getMjcbSplx().getValues().get(index);
				try {
					rowdatas = goodsDao.getDatasByGtid(gtid);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "�����쮐��");
					e1.printStackTrace();
				}
			}else{
				try {
					rowdatas=goodsDao.queryDate();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "�����쮐��");
					e1.printStackTrace();
				}
			}
			DefaultTableModel dtm=new DefaultTableModel(rowdatas, ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
			frame.getjTableSp().setModel(dtm);
		}else if(e.getSource().equals(frame.getJbDzszSp())){
			int index=frame.getjTableSp().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ���۵�һ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			new DxdzDialog(frame, true, DxdzDialog.SHANGPINDZ);
			
		}else if(e.getSource().equals(frame.getJbTjSp())){
			
			new TjspxmXtszDialog(frame, true,TjspxmXtszDialog.ADD);
			
		}else if(e.getSource().equals(frame.getJbXgSp())){
			
			int index=frame.getjTableSp().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ�޸ĵ�һ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			new TjspxmXtszDialog(frame, true,TjspxmXtszDialog.UPDATE);
			
		}else if(e.getSource().equals(frame.getJbScSp())){
			int index=frame.getjTableSp().getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫɾ����һ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			int res=JOptionPane.showConfirmDialog(frame, "ɾ���󽫲��ָܻ������Ҫɾ��?", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(res==JOptionPane.OK_OPTION){
				GoodsDao gDao=new GoodsDao();
				int val=gDao.deleteDataByGid(Integer.parseInt(frame.getjTableSp().getValueAt(index, 0).toString()));
				if(val<=0){
					JOptionPane.showMessageDialog(frame, "ɾ��ʧ��", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					try {
						Vector<Vector> rowdatesSp = gDao.queryDate();
						DefaultTableModel dtm=new DefaultTableModel(rowdatesSp,  ColumnContent.arrayToVector(ColumnContent.SHANGPIN_CLUMN_NAME));
						frame.getjTableSp().setModel(dtm);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "���ݿ��쳣", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
			
		}
	
		
		
	}
	
}

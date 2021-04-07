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
					JOptionPane.showMessageDialog(frame, "��ѡ�񹩻���λ��");
					return;
				}
			}
			new ZjspCgjhDialog(frame,false,CCKB);
		}else if(e.getSource().equals(frame.getJbupdatesp())){
			if(frame.getjTableCgjh().getSelectedRowCount()>0){
				new UpdateCgjhDialog(frame,false);
			}else{
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫ�޸ĵ���Ʒ��");
			}
		}else if(e.getSource().equals(frame.getJbdeletesp())){
			int selected = frame.getjTableCgjh().getSelectedRow();
			if(selected!=-1){
				int select = JOptionPane.showConfirmDialog(frame, "ȷ��Ҫɾ������Ʒ��");
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
				JOptionPane.showMessageDialog(frame, "��ѡ��Ҫɾ������Ʒ��");
			}
		}else if(e.getSource().equals(frame.getJbsave())){
			if(frame.getjTableCgjh()!=null){
				
				//�õ��������
				String hdbh = frame.getJtfhdbh().getText();
				
				//�õ��ֿ�ı��
				int selectedc = frame.getJcmxzck().getSelectedIndex();
				HashMap<Integer, Integer> cMap = frame.getJcmxzck().getValues();
				Integer xzck = cMap.get(selectedc);
				
				
				//�õ�����Ա�ı��
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
				//System.out.println("����ڣ�"+tdrq);
				
				String hdbz = frame.getJtfhdbz().getText();
				
				HuowuDao hwDao = new HuowuDao();
				HuowuVo hwVo = new HuowuVo();
				
				if((CCKB==CgjhDialog.CGJH)||(CgjhDialog.CGTH==CCKB)){
					boolean flag = false;
					if(Double.parseDouble(frame.getJtfsfzk().getText())>=Double.parseDouble(frame.getJtfyfzk().getText())){
						flag=true;
					}else{
						int selected = JOptionPane.showConfirmDialog(frame, "ʵ�ʸ���С��Ӧ���˿ȷ��Ҫ������");
						if(selected==0){
							flag = true;
						}
					}
						
					if(flag){	
					
						//�õ�������λ�ı��
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
							//System.out.println(":������������ӳɹ���");
						}
						
						
						DefaultTableModel model = (DefaultTableModel) frame.getjTableCgjh().getModel();
						Vector<Vector> vector = model.getDataVector();
						Double sum=0.0; //�����ܽ��
						for(int i = 0 ;i<vector.size();i++){
							
							//���еõ���Ʒ�ı�ż��۸������
							Integer id = Integer.parseInt(vector.get(i).get(0).toString());
							Double price = Double.parseDouble(vector.get(i).get(3).toString());
							Integer count = Integer.parseInt(vector.get(i).get(4).toString());
							sum += Double.parseDouble(vector.get(i).get(4).toString());
							GoodsDao gDao = new GoodsDao();
							boolean gflag =  gDao.updateDataById(id, count,CCKB);
							if(gflag){
								//System.out.println(id+":��Ʒ��������ӳɹ���");
							}
							
							
							HwdetailVo hwdVo = new HwdetailVo();
							hwdVo.setGid(id);
							hwdVo.setHid(hdbh);
							hwdVo.setPrice(price);
							hwdVo.setNumbers(count);
							HwdetailDao hwdDao = new HwdetailDao();
							boolean hwdflag = hwdDao.insertHwdData(hwdVo);
							if(hwdflag){
								//System.out.println(id+":���������������ӳɹ���");
							}
							
							//����Ӳֿ�ʱ��Ҫ����Ʒ�ֿ���е����ݲ��룬����Ʒ����������Ʒ���������ֿ���Ӧ�����0
							GoodsstoreVo gsVo = new GoodsstoreVo();
							gsVo.setGid(id);
							gsVo.setShid(xzck);
							gsVo.setKucun(count);
							GoodsstoreDao gsDao = new GoodsstoreDao();
							boolean gsflag = gsDao.updateGsData(gsVo,CCKB);
							if(gsflag){
								//System.out.println(id+":��Ʒ�������ݸ��³ɹ���");
							}else{
								gsflag = gsDao.insertGsData(gsVo);
								//System.out.println(id+":��Ʒ����������ӳɹ���");
							}
						}
						frame.getJtfyfzk().setText(sum.toString());
						frame.dispose();
						
					}
				
				}else if((CCKB==2)||(CCKB==3)){
					Integer drck = null;
					if(CCKB==2){
						//�õ�����ֿ�ı��
						int selectedr = frame.getMjbdrck().getSelectedIndex();
						HashMap<Integer, Integer> rMap = frame.getMjbdrck().getValues();
						drck = rMap.get(selectedr);
						hwVo.setDrsh(drck);
						hwVo.setState(3);
						
						
					}else if(CCKB==3){
						int selected = frame.getMjbbsby().getSelectedIndex();
						HashMap<Integer, Integer> map = frame.getMjbbsby().getValues();
						int idbs = map.get(selected);
						//System.out.println("״̬��"+idbs);
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
						//System.out.println(":������������ӳɹ���");
					}
					
					
					DefaultTableModel model = (DefaultTableModel) frame.getjTableCgjh().getModel();
					Vector<Vector> vector = model.getDataVector();
					Double sum=0.0; //�����ܽ��
					for(int i = 0 ;i<vector.size();i++){
						
						//���еõ���Ʒ�ı�ż��۸������
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
							//System.out.println(id+":���������������ӳɹ���");
						}
						
						//����Ӳֿ�ʱ��Ҫ����Ʒ�ֿ���е����ݲ��룬����Ʒ����������Ʒ���������ֿ���Ӧ�����0
						if(CCKB==2){
							GoodsstoreVo gsVo = new GoodsstoreVo();//�����ֿ��Vo
							GoodsstoreVo gsVoc = new GoodsstoreVo();//����ֿ��Vo
							
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
								//System.out.println(id+":��Ʒ�������³ɹ���");
							boolean gsflag = gsDao.updateGsData(gsVo,0);
							if(gsflag){
								//System.out.println(id+":��Ʒ�������ݸ��³ɹ���");
							}else{
								gsflag = gsDao.insertGsData(gsVo);
								//System.out.println(id+":��Ʒ����������ӳɹ���");
							}
						}
						
					}
					if(CCKB==3){
						frame.getJtfyfzk().setText(money.toString());
					}
					frame.dispose();
				}
			
				
			}else{
				JOptionPane.showMessageDialog(frame, "�ɹ����ݲ���Ϊ�գ�");
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
		//System.out.println("�ı�����CgihDialog�е�XֵΪ:"+(x+frame.getX()) +" Y��"+(y+frame.getY()));
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

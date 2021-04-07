package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.MemberDao;
import com.util.ColumnContent;
import com.util.DateUtil;
import com.view.HyglDialog;
import com.view.HyglZjhyDialog;
import com.vo.MemberVo;

public class HyglZjhyDialogAction implements ActionListener {

	private HyglZjhyDialog frame;
	private int addOrUpdate;
	private MemberDao mDao = new MemberDao();
	public HyglZjhyDialogAction(HyglZjhyDialog frame,int addOrUpdate){
		this.frame = frame;
		this.addOrUpdate =addOrUpdate;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbSaveZjhy())){
			if(frame.getJtfhybhZjhy().getText().equals("")){
				JOptionPane.showMessageDialog(frame, "��Ա��Ų���Ϊ��");
				return;
			}
			
			HyglDialog parent = (HyglDialog) frame.getParent();
			JTable jtable = parent.getJtHyxx();
			DefaultTableModel model = (DefaultTableModel) jtable.getModel();
			Vector<Vector> vData = model.getDataVector();
			MemberVo vo = new MemberVo();
			Integer mid = Integer.parseInt(frame.getJtfhybhZjhy().getText());
			String cardType = frame.getMjbklxZjhy().getSelectedItem().toString();
			String hyxm = frame.getJtfhyxmZjhy().getText();
			String sex = frame.getMjbhyxbZjhy().getSelectedItem().toString();
			Integer dqjf = Integer.parseInt(frame.getJtfdqjfZjhy().getText());
			String phone = frame.getJtflxdhZjhy().getText();
			String bz = frame.getJtabzZjhy().getText();
			
			vo.setMid(mid);
			vo.setCardtype(cardType);
			if(!hyxm.equals("")){
				vo.setMname(hyxm);
			}else{
				vo.setMname("��");
				hyxm = "��";
			}
			vo.setMgid(frame.getMjbhydjZjhy().getValues().get(frame.getMjbhydjZjhy().getSelectedIndex()));
			vo.setSex(sex);
			vo.setJf(dqjf);
			try {
				vo.setBirthday(new java.sql.Date(frame.getJdpcsrqZjhy().getSelectedDate().getTime()));
				vo.setUsedate(new java.sql.Date(frame.getJdpyxqZjhy().getSelectedDate().getTime()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!phone.equals("")){
				vo.setPhone(phone);
			}else{
				vo.setPhone("��");
				phone = "��";
			}
			vo.setState(frame.getMjbdqztZjhy().getValues().get(frame.getMjbdqztZjhy().getSelectedIndex()));
			//System.out.println("zen:"+bz+"sd");
			if(!bz.equals("")){
				vo.setRemarks(bz);
			}else{
				vo.setRemarks("��");
				bz = "��";
				
			}
			if(!frame.getJtfszkmmZjhy().getText().equals("")){
				if(frame.getJtfszkmmZjhy().getText().equals(frame.getJtfqrkmmZjhy().getText())){
					vo.setPassword(frame.getJtfszkmmZjhy().getText());
				}else{
					
					JOptionPane.showMessageDialog(frame, "���ÿ�������ȷ�Ͽ����벻һ�£������䣡");
					frame.getJtfqrkmmZjhy().setText("");
					frame.getJtfszkmmZjhy().setText("");
					return;
				}
			}
			
			
			
			boolean flag = false;
			//System.out.println("addOrUpdate"+addOrUpdate);
			if(addOrUpdate==HyglZjhyDialog.ADD){
				if(isEqual(Integer.parseInt(frame.getJtfhybhZjhy().getText()))){
					JOptionPane.showMessageDialog(frame, "�û�Ա����Ѵ��ڣ������䣡");
					return;
				}
				//System.out.println(isEqual(vo.getMid()));
				//if(isEqual(vo.getMid())){
				
				vo.setBalance(0.0);
				vo.setSumbalance(0.0);
				vo.setRegisterdate(new java.sql.Date(new java.util.Date().getTime()));
				flag = mDao.insertData(vo);
				/*if(flag){
					System.out.println("������ӳɹ���");
				}*/
				

				Vector<Object>  vector = new Vector<Object>();
				vector.add(mid);
				vector.add(hyxm);
				vector.add(sex);
				vector.add(cardType);
				vector.add(0.0);
				vector.add(frame.getMjbhydjZjhy().getSelectedItem());
				vector.add(dqjf);
				vector.add(0);
				
				try {
					vector.add(DateUtil.getStrDate(frame.getJdpcsrqZjhy().getSelectedDate(),DateUtil.DATE_TIME));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vector.add(phone);
				try {
					String date = DateUtil.getStrDate(frame.getJdpyxqZjhy().getSelectedDate(),DateUtil.DATE_TIME);
					//System.out.println("date�Ǽ����ڣ�"+date);
					SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATE_TIME);
					date = ((Integer)(Integer.parseInt(date.substring(0,date.indexOf("-")))-1)).toString()+date.substring(date.indexOf("-"),date.length());
					vector.add(sdf.format(new Date()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vector.add(frame.getMjbdqztZjhy().getSelectedItem());
				vector.add(bz);
				vData.add(vector);
			
			}else if(addOrUpdate==HyglZjhyDialog.UPDATE){
				flag = mDao.updateDate(vo);
				/*if(flag){
					
					System.out.println("���ݸ��³ɹ���");
				}*/
				
				
				for(int i = 0;i<vData.size();i++){
					//System.out.println(vData.get(i).get(0)+"-"+mid+"�Ƿ����:"+vData.get(i).get(0).equals(mid));
					if(Integer.parseInt(vData.get(i).get(0).toString())==mid){
						vData.get(i).setElementAt(hyxm, 1);
						vData.get(i).setElementAt(sex, 2);
						vData.get(i).setElementAt(cardType, 3);
						vData.get(i).setElementAt(frame.getMjbhydjZjhy().getSelectedItem(), 5);
						vData.get(i).setElementAt(dqjf, 6);    
						try {
							vData.get(i).setElementAt(DateUtil.getStrDate(frame.getJdpcsrqZjhy().getSelectedDate(),DateUtil.DATE_TIME), 8);
							/*String date = DateUtil.getStrDate(frame.getJdpyxqZjhy().getSelectedDate(),DateUtil.DATE_TIME);
							String date1 = ((Integer)(Integer.parseInt(date.substring(0,date.indexOf("-")))-1)).toString()+date.substring(date.indexOf("-")-1,date.length());
							System.out.println("�Ǽ����ڣ�"+date1);
							
							//vData.get(i).setElementAt(date1,10);
*/						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						vData.get(i).setElementAt(phone, 9);
						
						vData.get(i).setElementAt(frame.getMjbdqztZjhy().getSelectedItem(),11);
						vData.get(i).setElementAt(bz,12);
						
						break;
					}
				}
			}
			DefaultTableModel dtm = new DefaultTableModel(vData,ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME));
			jtable.setModel(dtm);
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbCancelZjhy())){
			frame.dispose();
		}

	}
	
	//�жϻ�Ա����Ƿ����
	public boolean isEqual(Integer id){
		ArrayList<MemberVo> dataList = null;
		try {
			dataList = mDao.queryAllData();
			 for(MemberVo vo:dataList){
				 if(Integer.parseInt(vo.getMid().toString())==id){
					// System.out.println("�����"+vo.getMid()+"-"+id+"="+vo.getMid().equals(id));
					 return true;
				 }
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

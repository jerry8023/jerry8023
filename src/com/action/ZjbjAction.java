package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BaojianDao;
import com.util.ColumnContent;
import com.view.XtszDialog;
import com.view.ZjbjDialog;
import com.vo.BaojianVo;

public class ZjbjAction implements ActionListener{

	private ZjbjDialog frame ;
	private ArrayList<BaojianVo> data ;
	private int size=0;
	private BaojianDao dao = new BaojianDao();
	 
	public ZjbjAction(ZjbjDialog frame){
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==frame.getMjbSavezjzb()){
			try {
					
				    BaojianVo vo = this.getBaojianVo();
				    //System.out.println("size:"+size+"dataSize:"+data.size());
					if(frame.getAddOrUpdate()==frame.ADD){
					  if(vo.getBjtid()!=null){
						if(vo.getBjid()!=null&&(!vo.getBjid().equals(""))){
							//System.out.println("vo:"+vo);
							boolean flag = dao.saveBaojian(vo);
							//System.out.println("flag:"+flag);
							if(flag==true){
								sxshuju();
								//System.out.println("������ӳɹ�");			
							}
							else{
								JOptionPane.showMessageDialog(frame, "���ʧ�ܣ�");
							}
						 }else{
							 if(data.size()==size&&vo.getBjid().equals("")){
						    	JOptionPane.showMessageDialog(frame, "�����������","��ʾ��Ϣ",JOptionPane.NO_OPTION);
						 
							 }
						 }
					}else{
							JOptionPane.showMessageDialog(frame, "������������������ѡ��","��ʾ��Ϣ",JOptionPane.CANCEL_OPTION);
					}	
				
				
				}else if(frame.getAddOrUpdate()==frame.UPDATE){
					if(vo.getBjid()!=null&&(!vo.getBjid().equals(""))){
						//System.out.println("vo:"+vo);
						boolean flag = dao.updateBaojian(vo);
						//System.out.println("flag:"+flag);
						if(flag==true){
							sxshuju();
							//System.out.println("�����޸ĳɹ�");
						}
						else{
							//System.out.println("���ݸ���ʧ�ܣ�");
						}
					}else{
							if(data.size()==size&&vo.getBjid().equals("")){
						    	JOptionPane.showMessageDialog(frame, "�����������","��ʾ��Ϣ",JOptionPane.NO_OPTION);
						 
							 }
						}
					
				} 
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==frame.getMjbExitzjzb()){
			frame.dispose();
		}
	}
	public BaojianVo getBaojianVo() throws Exception{
		boolean flag = true; //��flag�����ж���Ӻ��޸�����ʱ��������û���ظ�
		
		//�õ�ϵͳ����XtszDialog�а�����ֵ
		XtszDialog mainFrame = (XtszDialog) frame.getParent();
		JTable  jtMainFrame  = mainFrame.getjTableBj();
		String csbjbh ="";
		
		BaojianVo vo = new BaojianVo();
		BaojianDao baojianDao = new BaojianDao();
		String bjbh = frame.getJtfbjbhzjbj().getText();
		//��ѯ������е���������
		data  =  baojianDao.queryData();
		//System.out.println("���ݳ���:"+data.size());
		size = 0;
		//System.out.println("bjbh:"+frame.getJtfbjbhzjbj().getText());
		
		//���ѡ�����޸ģ���������Ƿ��ظ���ע�⣺�ظ�������ѡ����һ�е�ԭʼ���ݣ�
		if(frame.getAddOrUpdate()==frame.UPDATE){
			int selectedRow = jtMainFrame.getSelectedRow();
			csbjbh = jtMainFrame.getValueAt(selectedRow, 0).toString();
			vo.setBjname(csbjbh);
			//System.out.println("csBjname:"+csbjbh);
			//vo.setBjid(csbjbh);
			for(BaojianVo bjVo :data){
				size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"�Ƿ���ȣ�"+flag);
				if(bjbh.equals(bjVo.getBjid())&&((!csbjbh.equals(bjbh))&&frame.getAddOrUpdate()==frame.UPDATE)){
					break;
				}
				
			}
		}else if(frame.getAddOrUpdate()==frame.ADD){
			for(BaojianVo bjVo :data){
				size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"�Ƿ���ȣ�"+flag);
				if(bjbh.equals(bjVo.getBjid())){
					break;
				}
				
			}
		}
		if(size==data.size()){
			flag=false;
		}
		//System.out.println("size:"+size);
		if(!flag){
			vo.setBjid(bjbh); 
			if(frame.getAddOrUpdate()==frame.ADD){
				vo.setBjname(bjbh);
			}
		}else{
			
			JOptionPane.showMessageDialog(frame, "�˱���Ѵ��ڣ������±��","��ʾ��Ϣ",JOptionPane.NO_OPTION);
			
		}
		String bjlxName = frame.getJcmBjlxzjbj().getSelectedItem().toString();
		//System.out.println("�����������ƣ�"+bjlxName);
		String bjtid = baojianDao.querryBjtName(bjlxName).toString();
		bjtid=bjtid.substring(bjtid.lastIndexOf("[")+1,bjtid.indexOf("]]"));
		//System.out.println("�������ͱ�ţ�"+bjtid);
		vo.setBjtid(Integer.parseInt(bjtid));
		String szqy = frame.getJtfszqyzjzb().getText();
		if(szqy==null)
			szqy="��";
		vo.setState(1);
		vo.setArea(szqy);
		//System.out.println(bjbh+"-"+bjtid+"-"+szqy);

		return vo;
		
	}
	//����ˢ������
	public void sxshuju(){
		XtszDialog mainFrame = (XtszDialog) frame.getParent();
		JTable  jtMainFrame  = mainFrame.getjTableBj();
		Vector<Vector> dataVector = null;
		try{
			dataVector = dao.queryDate();
		}catch(Exception e1){
			
			e1.printStackTrace();
			return ;
		}
		
		DefaultTableModel model = new DefaultTableModel(dataVector,ColumnContent.arrayToVector(ColumnContent.BAOJIAN_CLUMN_NAME));
		jtMainFrame.setModel(model);
		frame.dispose();
	}

}

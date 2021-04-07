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
import com.util.YanZhengUtil;
import com.view.PlzjbjDialog;
import com.view.XtszDialog;
import com.vo.BaojianVo;

public class PlzjbjAction implements ActionListener {

	private ArrayList<BaojianVo> data ;
	
	private PlzjbjDialog frame;
	private BaojianDao dao = new BaojianDao();
	public PlzjbjAction(PlzjbjDialog frame){
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==frame.getMjbSaveplzj()){
		if(!frame.getJtfStartbjfwplzj().getText().equals("")){
			if(!frame.getJtfEndbjfwplzj().getText().equals("")){
				
				
				String end = frame.getJtfEndbjfwplzj().getText();
				String start = frame.getJtfStartbjfwplzj().getText();
				
				int eslength = Integer.parseInt(end)-Integer.parseInt(start)+1;
				//System.out.println("start:"+start+"end:"+end+"cha:"+eslength);
				if(eslength>0){
					String bjbh[] = new String[eslength];
					//System.out.println("length:"+bjbh.length);
					String bj="";
					if(frame.getJtfbjzfplzj()!=null){
						bj = frame.getJtfbjzfplzj().getText();
						//System.out.println("����ַ���"+bj);
					}
					for(int i=0;i<eslength;i++){
						//��Ҫ�õ����ֵ���ų�����ߺ���ģ�
						Integer  s1 = (Integer.parseInt(start)+i) ;
						String s = s1.toString();
						//System.out.println("s1:"+s1.toString());
						if(frame.getJrbzqplzj().isSelected()&&(!frame.getJrbzhplzj().isSelected())){
							//�������Ϊ0��Ԫ�ؼӽ���,��ȡ�Ӵ��ķ�������
							bjbh[i] = bj+start.substring(0,(start.length()-s.length()) )+s;
							//System.out.println(bjbh[i]);
						}else if((!frame.getJrbzqplzj().isSelected())&&frame.getJrbzhplzj().isSelected()){
							bjbh[i] = start.substring(0,(start.length()-s.length()) )+s+bj;
							//System.out.println(bjbh[i]);
						}
						BaojianVo vo;
						try {
							vo = this.getBaojianVo(bjbh[i]);
							if(vo.getBjid()!=null&&(!vo.getBjid().equals(""))){
								boolean flag = dao.saveBaojian(vo);
								//System.out.println("bjbh:"+bjbh[i]+"flag:"+flag);
								if(flag == true){
									//System.out.println("bjbh:"+bjbh[i]+"������ӳɹ���");
								}else{
									//System.out.println("�������ʧ�ܣ�");
								}
							 }
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
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
				
				}else{
					JOptionPane.showMessageDialog(frame, "��ʼ�����Ų��ܴ�����ֹ�����ţ�","��ʾ��Ϣ",JOptionPane.NO_OPTION);

				}
				
				
			}else{
				JOptionPane.showMessageDialog(frame, "�����������ֹ��ţ�");
			}
		}else{
			JOptionPane.showMessageDialog(frame, "�����������ʼ��ţ�");
		}
	  }else{
		  frame.dispose();
	  }

	}
	public BaojianVo getBaojianVo(String bjbh) throws Exception{
		boolean flag = true; //��flag�����ж���Ӻ��޸�����ʱ��������û���ظ�
		
		//�õ�ϵͳ����XtszDialog�а�����ֵ
		BaojianVo vo = new BaojianVo();
		BaojianDao baojianDao = new BaojianDao();
		
		//��ѯ������е���������
		data  =  baojianDao.queryData();
		//System.out.println("���ݳ���:"+data.size());
		int size = 0;
		for(BaojianVo bjVo :data){
			size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"�Ƿ���ȣ�"+flag);
			if(bjbh.equals(bjVo.getBjid())){
				break;
			}
		
		}
		if(size==data.size()){
			flag=false;
		}
		//System.out.println("size:"+size);
		if(!flag){
			vo.setBjid(bjbh); 
			vo.setBjname(bjbh);
		}else{
			
			//System.out.println("�˱���Ѵ���!");
			
		}
		String bjlxName = frame.getJcmBjlxplzj().getSelectedItem().toString();
		//System.out.println("�����������ƣ�"+bjlxName);
		String bjtid = baojianDao.querryBjtName(bjlxName).toString();
		bjtid=bjtid.substring(bjtid.lastIndexOf("[")+1,bjtid.indexOf("]]"));
		//System.out.println("�������ͱ�ţ�"+bjtid);
		vo.setBjtid(Integer.parseInt(bjtid));
		String szqy = frame.getJtfszqyplzj().getText();
		if(szqy==null){
			szqy="��";
		}
		vo.setState(1);
		vo.setArea(szqy);
		//System.out.println(bjbh+"-"+bjtid+"-"+szqy);
		return vo;
		
	}
	
}

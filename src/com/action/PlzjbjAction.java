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
						//System.out.println("标记字符："+bj);
					}
					for(int i=0;i<eslength;i++){
						//先要得到序号值（排除最左边含零的）
						Integer  s1 = (Integer.parseInt(start)+i) ;
						String s = s1.toString();
						//System.out.println("s1:"+s1.toString());
						if(frame.getJrbzqplzj().isSelected()&&(!frame.getJrbzhplzj().isSelected())){
							//把最左边为0的元素加进来,用取子串的方法连接
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
									//System.out.println("bjbh:"+bjbh[i]+"数据添加成功！");
								}else{
									//System.out.println("数据添加失败！");
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
					JOptionPane.showMessageDialog(frame, "起始包间编号不能大于终止包间编号！","提示信息",JOptionPane.NO_OPTION);

				}
				
				
			}else{
				JOptionPane.showMessageDialog(frame, "请输入包间终止编号！");
			}
		}else{
			JOptionPane.showMessageDialog(frame, "请输入包间起始编号！");
		}
	  }else{
		  frame.dispose();
	  }

	}
	public BaojianVo getBaojianVo(String bjbh) throws Exception{
		boolean flag = true; //此flag用于判断添加和修改数据时包间编号有没有重复
		
		//得到系统设置XtszDialog中包间表的值
		BaojianVo vo = new BaojianVo();
		BaojianDao baojianDao = new BaojianDao();
		
		//查询包间表中的所有数据
		data  =  baojianDao.queryData();
		//System.out.println("数据长度:"+data.size());
		int size = 0;
		for(BaojianVo bjVo :data){
			size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"是否相等："+flag);
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
			
			//System.out.println("此编号已存在!");
			
		}
		String bjlxName = frame.getJcmBjlxplzj().getSelectedItem().toString();
		//System.out.println("包间类型名称："+bjlxName);
		String bjtid = baojianDao.querryBjtName(bjlxName).toString();
		bjtid=bjtid.substring(bjtid.lastIndexOf("[")+1,bjtid.indexOf("]]"));
		//System.out.println("包间类型编号："+bjtid);
		vo.setBjtid(Integer.parseInt(bjtid));
		String szqy = frame.getJtfszqyplzj().getText();
		if(szqy==null){
			szqy="无";
		}
		vo.setState(1);
		vo.setArea(szqy);
		//System.out.println(bjbh+"-"+bjtid+"-"+szqy);
		return vo;
		
	}
	
}

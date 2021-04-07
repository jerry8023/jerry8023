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
								//System.out.println("数据添加成功");			
							}
							else{
								JOptionPane.showMessageDialog(frame, "添加失败！");
							}
						 }else{
							 if(data.size()==size&&vo.getBjid().equals("")){
						    	JOptionPane.showMessageDialog(frame, "请输入包间编号","提示信息",JOptionPane.NO_OPTION);
						 
							 }
						 }
					}else{
							JOptionPane.showMessageDialog(frame, "包间类型有误，请重新选择！","提示信息",JOptionPane.CANCEL_OPTION);
					}	
				
				
				}else if(frame.getAddOrUpdate()==frame.UPDATE){
					if(vo.getBjid()!=null&&(!vo.getBjid().equals(""))){
						//System.out.println("vo:"+vo);
						boolean flag = dao.updateBaojian(vo);
						//System.out.println("flag:"+flag);
						if(flag==true){
							sxshuju();
							//System.out.println("数据修改成功");
						}
						else{
							//System.out.println("数据更新失败！");
						}
					}else{
							if(data.size()==size&&vo.getBjid().equals("")){
						    	JOptionPane.showMessageDialog(frame, "请输入包间编号","提示信息",JOptionPane.NO_OPTION);
						 
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
		boolean flag = true; //此flag用于判断添加和修改数据时包间编号有没有重复
		
		//得到系统设置XtszDialog中包间表的值
		XtszDialog mainFrame = (XtszDialog) frame.getParent();
		JTable  jtMainFrame  = mainFrame.getjTableBj();
		String csbjbh ="";
		
		BaojianVo vo = new BaojianVo();
		BaojianDao baojianDao = new BaojianDao();
		String bjbh = frame.getJtfbjbhzjbj().getText();
		//查询包间表中的所有数据
		data  =  baojianDao.queryData();
		//System.out.println("数据长度:"+data.size());
		size = 0;
		//System.out.println("bjbh:"+frame.getJtfbjbhzjbj().getText());
		
		//如果选的是修改，看包间号是否重复（注意：重复不包括选中那一行的原始数据）
		if(frame.getAddOrUpdate()==frame.UPDATE){
			int selectedRow = jtMainFrame.getSelectedRow();
			csbjbh = jtMainFrame.getValueAt(selectedRow, 0).toString();
			vo.setBjname(csbjbh);
			//System.out.println("csBjname:"+csbjbh);
			//vo.setBjid(csbjbh);
			for(BaojianVo bjVo :data){
				size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"是否相等："+flag);
				if(bjbh.equals(bjVo.getBjid())&&((!csbjbh.equals(bjbh))&&frame.getAddOrUpdate()==frame.UPDATE)){
					break;
				}
				
			}
		}else if(frame.getAddOrUpdate()==frame.ADD){
			for(BaojianVo bjVo :data){
				size++;
				//System.out.println(bjbh+"-"+bjVo.getBjid()+"是否相等："+flag);
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
			
			JOptionPane.showMessageDialog(frame, "此编号已存在，请重新编号","提示信息",JOptionPane.NO_OPTION);
			
		}
		String bjlxName = frame.getJcmBjlxzjbj().getSelectedItem().toString();
		//System.out.println("包间类型名称："+bjlxName);
		String bjtid = baojianDao.querryBjtName(bjlxName).toString();
		bjtid=bjtid.substring(bjtid.lastIndexOf("[")+1,bjtid.indexOf("]]"));
		//System.out.println("包间类型编号："+bjtid);
		vo.setBjtid(Integer.parseInt(bjtid));
		String szqy = frame.getJtfszqyzjzb().getText();
		if(szqy==null)
			szqy="无";
		vo.setState(1);
		vo.setArea(szqy);
		//System.out.println(bjbh+"-"+bjtid+"-"+szqy);

		return vo;
		
	}
	//用于刷新数据
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

package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.FuwushengDao;
import com.dao.MemberDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.FwscxDialog;
import com.view.util.PrintJPanel;
import com.vo.FuwushengVo;

public class FwscxAction implements ActionListener{
	
    private FwscxDialog frame;
	public FwscxAction(FwscxDialog frame){
		
		this.frame=frame;
		
	}
    FuwushengDao   fwsdao=new FuwushengDao();
    FuwushengVo    vo=new FuwushengVo();
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getJbCx())){
			
			
			String strjbcx=frame.getJtf().getText();
			//System.out.println(strjbcx);
			if(strjbcx!=null){
				
				boolean flag=YanZhengUtil.isShuZi(strjbcx);
				
				if(flag==true){
					vo.setFwsid(Integer.parseInt(strjbcx));
					try {
						fwsdao.queryDateSz(vo);
					//	System.out.println("vo-->"+vo.getFwsjp());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					JTable jTable=frame.getJtfws();
					Vector<Vector> data=null;
					try {
						data=fwsdao.queryDateSz(vo);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据查询失败");
						e1.printStackTrace();
						return;
					}
					
					DefaultTableModel  dtm=new DefaultTableModel(data,
							ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME));
					        jTable.setModel(dtm);
					      //  System.out.println("-------------");
				}else{
					vo.setFwsname(strjbcx);
					try {
						fwsdao.queryDateXm(vo);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JTable jTable=frame.getJtfws();
					Vector<Vector> data=null;
					try {
						data=fwsdao.queryDateXm(vo);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, "数据查询失败");
						e1.printStackTrace();
						return;
					}
					
					DefaultTableModel  dtm=new DefaultTableModel(data,
							ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME));
					        jTable.setModel(dtm);
					     //   System.out.println("-------------");
					
				}
			
			}else{
				
				JOptionPane.showMessageDialog(frame, "请输入按条件输入你要查询的内容：比如服务生编号或姓名");
			}
		
		}else if(e.getSource().equals(frame.getJbSx())){
			JTable jTable=frame.getJtfws();
			Vector<Vector> data=null;
			try {
				data=fwsdao.queryDate2();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "数据查询失败");
				e1.printStackTrace();
				return;
			}
			DefaultTableModel  dtm=new DefaultTableModel(data,
					ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME));
			        jTable.setModel(dtm);
			
		}else if(e.getSource().equals(frame.getJbGl())){
			
			frame.getjPopupMenu().show(frame.getJbGl(),30,20);
		}else if(e.getSource().equals(frame.getJbDy())){
			Vector<Vector> rowdatafws=null;
			FuwushengDao fwscxdao=new FuwushengDao();
			try {
				rowdatafws=fwscxdao.queryDate2();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JFrame jf=new JFrame();
			jf.setSize(1365,767);
			jf.setTitle("打印预览");
			jf.getContentPane().add(new PrintJPanel(rowdatafws,ColumnContent.arrayToVector(ColumnContent.FUWUSHENG_CLUMN_NAME), 150, 0, 1020));
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
		}
		
	}

}

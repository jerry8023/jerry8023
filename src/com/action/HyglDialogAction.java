package com.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodsDao;
import com.dao.MemberDao;
import com.dao.MgradeDao;
import com.dao.PreorderDao;
import com.util.ColumnContent;
import com.view.HyglDialog;
import com.view.HyglXghymmDialog;
import com.view.HyglZjhyDialog;
import com.view.util.PrintJPanel;
import com.vo.MemberVo;
import com.vo.MgradeVo;

public class HyglDialogAction implements ActionListener {

	private HyglDialog frame;
	public HyglDialogAction(HyglDialog frame){
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		int selected = frame.getJtHyxx().getSelectedRow(); 
		if(e.getSource().equals(frame.getMjbZjHy())){
			new HyglZjhyDialog(frame,false,HyglZjhyDialog.ADD);
			
		}else if(e.getSource().equals(frame.getMjbXgHy())){
			if(selected!=-1){
				String hybh = frame.getJtHyxx().getValueAt(selected, 0).toString();
				HyglZjhyDialog xghyDialog = new HyglZjhyDialog(frame,false,HyglZjhyDialog.UPDATE);
				xghyDialog.getJtfhybhZjhy().setText(hybh);
				xghyDialog.getJtfhybhZjhy().setEditable(false);
				xghyDialog.getJtfhyxmZjhy().setText(frame.getJtHyxx().getValueAt(selected, 1).toString());
				
				xghyDialog.getMjbhyxbZjhy().setSelectedItem(frame.getJtHyxx().getValueAt(selected, 2).toString());
				xghyDialog.getMjbklxZjhy().setSelectedItem(frame.getJtHyxx().getValueAt(selected, 3).toString());
				xghyDialog.getMjbhydjZjhy().setSelectedItem(frame.getJtHyxx().getValueAt(selected, 5).toString());
				xghyDialog.getJtfdqjfZjhy().setText(frame.getJtHyxx().getValueAt(selected, 6).toString());
				xghyDialog.getJdpcsrqZjhy().setSelectedItem(frame.getJtHyxx().getValueAt(selected, 8).toString());
				xghyDialog.getJtflxdhZjhy().setText(frame.getJtHyxx().getValueAt(selected, 9).toString());
				xghyDialog.getMjbdqztZjhy().setSelectedItem(frame.getJtHyxx().getValueAt(selected, 11).toString());
				MemberDao dao = new MemberDao();
				Object yxq = null;
				try {
					yxq = dao.queryDataById(Integer.parseInt(hybh),1);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				String kyxq = yxq.toString();
				kyxq = yxq.toString().substring(kyxq.indexOf("[[")+2,kyxq.indexOf("]"));
				xghyDialog.getJdpyxqZjhy().setSelectedItem(kyxq);
				//System.out.println("有效日期至："+kyxq);
				
			}else{
				JOptionPane.showMessageDialog(frame, "请选中一行要修改的会员信息！");
			}
			
		}else if(e.getSource().equals(frame.getMjbScHy())){
			
			if(selected!=-1){
				int option = JOptionPane.showConfirmDialog(frame, "确定要删除该会员信息吗？","提示信息",JOptionPane.OK_CANCEL_OPTION);
				if(option==JOptionPane.OK_OPTION){
					Object id = frame.getJtHyxx().getValueAt(frame.getJtHyxx().getSelectedRow(),0);
					//System.out.println("选中的行："+selected);
					boolean flag = new MemberDao().deleteData(Integer.parseInt(id.toString()));
					DefaultTableModel model = (DefaultTableModel) frame.getJtHyxx().getModel();
					Vector<Vector> vector = model.getDataVector();
					vector.remove(selected);
					DefaultTableModel dtm = new DefaultTableModel( vector,ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME));
					frame.getJtHyxx().setModel(dtm);
					/*if(flag){
						System.out.println("数据删除成功！");
					}*/
				}
			}else{
				JOptionPane.showMessageDialog(frame, "请选中一行要删除的会员信息！");
			}
			
			
		}else if(e.getSource().equals(frame.getMjbGmmHy())){
			if(selected!=-1){
				HyglXghymmDialog gmmDialog = new HyglXghymmDialog(frame,false);
				Object objId = frame.getJtHyxx().getValueAt(selected, 0);
				gmmDialog.getJtfhybhXghy().setText(objId.toString());
				gmmDialog.getJtfhybhXghy().setEditable(false);
				gmmDialog.getJtfhybhXghy().setBackground(Color.white);
				
			}else{
				JOptionPane.showMessageDialog(frame, "请选中一行要修改的会员信息！");
			}
			
			
		}else if(e.getSource().equals(frame.getMjbCxHyxx())){
			MemberDao dao = new MemberDao();
			Vector<Vector> dataList = null;
			try {
				if(frame.getJtfBhxm().getText().equals("")){
					dataList = dao.queryData();
				}else if(frame.getJtfBhxm().getText().matches("[0-9]+")){
					//dataList = dao.qreryAllDataById(Integer.parseInt(frame.getJtfBhxm().getText()));
					dataList = dao.qreryAllDataByStrid(frame.getJtfBhxm().getText());
				}else{
					dataList = dao.qreryAllDataByName(frame.getJtfBhxm().getText());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			DefaultTableModel model = new DefaultTableModel(dataList,ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME));
			frame.getJtHyxx().setModel(model);
		}else if(e.getSource().equals(frame.getMjbGlHyxx())){
			
			frame.getjPopupMenu().show(frame.getMjbGlHyxx(), 30, 20);
			
			/*JPopupMenu jpm = null;
			if(jpm==null){
				jpm = new JPopupMenu();
			}
			ArrayList<MgradeVo> arrayList = null;
			try {
				arrayList = new MgradeDao().queryData();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i = 0 ;
			for(MgradeVo vo:arrayList){
				JMenuItem jti = new JMenuItem(vo.getMgname());
				//System.out.println("名字："+vo.getMgname().toString());
				Integer mgid = vo.getMgid();
				jti.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
			//			Integer mgid = vo.getMgid();
						
						
					}
				});
				jti.setBackground(null);
				jti.setOpaque(false);
				jpm.add(jti);
			
			}
			jpm.setVisible(true);
			frame.getJtfBhxm().add(jpm);
			int x =frame.getJtfBhxm().getX()+frame.getX();
			int y = frame.getJtfBhxm().getY()+frame.getY();
			//System.out.println("x:"+x+"  y:"+y);
			jpm.setPopupSize(new Dimension(86,68));
			jpm.setLocation(x+160, y+87);
			jpm.setBackground(new Color(217,217,225));*/
			
		}else if(e.getSource().equals(frame.getMjbSrcxHyxx())){
			
		}else if(e.getSource().equals(frame.getMjbDyHyxx())){
			MemberDao mDao=new MemberDao();
			Vector<Vector> rowdatas=null;
			try {
				rowdatas= mDao.queryData();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JFrame jf=new JFrame();
			jf.setSize(1365,767);
			jf.setTitle("打印预览");
			jf.getContentPane().add(new PrintJPanel(rowdatas,ColumnContent.arrayToVector(ColumnContent.HUIYUAN_CLUMN_NAME), 0, 0, 1278));
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jf.setVisible(true);
		}

	}

	

}

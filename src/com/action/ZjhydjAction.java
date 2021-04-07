package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.MgradeDao;
import com.util.ColumnContent;
import com.util.YanZhengUtil;
import com.view.XtszDialog;
import com.view.ZjhydjDialog;
import com.vo.MgradeVo;

public class ZjhydjAction implements ActionListener {

	private ZjhydjDialog dialog;
	private XtszDialog parent;
	
	public ZjhydjAction(ZjhydjDialog dialog){
		this.dialog=dialog;
		this.parent= (XtszDialog)dialog.getParent();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(dialog.getMjbsave())) {
			
			if (dialog.addOrUpdate == ZjhydjDialog.ADD) {
				MgradeVo vo = new MgradeVo();
				MgradeDao mdao = new MgradeDao();
				String strmgname = dialog.getJthydj().getText();
				if(strmgname.length()==0||strmgname==null){
					JOptionPane.showMessageDialog(dialog, "��Ա�ȼ�����Ϊ��", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				try {
					ArrayList<MgradeVo> mgDataList=mdao.queryData();
					for(MgradeVo mgvo:mgDataList){
						if(mgvo.getMgname().equals(strmgname)){
							JOptionPane.showMessageDialog(dialog, "�˻�Ա�ȼ��Ѵ���", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(dialog, "���ݿ��쳣");
					e2.printStackTrace();
				}
				vo.setMgname(strmgname);
				String strcsjf = dialog.getJtcsjf().getText();
				if (YanZhengUtil.isShuZi(strcsjf)) {
					vo.setCsjf(Integer.parseInt(strcsjf));
				}else{
					JOptionPane.showMessageDialog(dialog, "��ʼ���ֱ���Ϊ����");
					return;
				}
				String strrebate = dialog.getJtqcdz().getText();

				if (strrebate.matches("[0-9]*[.]?[0-9]+")) {
					vo.setRebate(Double.parseDouble(strrebate));
				} else {
					JOptionPane.showMessageDialog(dialog, "��������۱�����ʽ����ȷ������������");
					return;
				}
				String strusenubmer = dialog.getJtsycs().getText();
				if (strusenubmer.length()!=0) {
					if (strusenubmer.matches("[0-9]+")) {
						vo.setUsenumber(Integer.parseInt(strusenubmer));
					}else{
						JOptionPane.showMessageDialog(dialog, "ÿ��ʹ�ô�������Ϊ����");
						return;
					}

					boolean falge = mdao.insertMgradeAll(vo);
					if (falge == true) {
						
						//JOptionPane.showMessageDialog(dialog, "��ӳɹ�");
						JTable jtable = parent.getjTableHydj();

						Vector<Vector> data = null;
						try {
							data = mdao.queryDate();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(dialog, "���ݲ�ѯʧ��");
							e1.printStackTrace();
						}
						DefaultTableModel dtm = new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
						jtable.setModel(dtm);
						dialog.dispose();

					} else {

						JOptionPane.showMessageDialog(dialog, "���ʧ��");
					}

				}else{
					MgradeDao mdao1 = new MgradeDao();
					vo.setUsenumber(null);
					boolean falge1 = mdao.insertMgradeAll(vo);
					if (falge1 == true) {
						//JOptionPane.showMessageDialog(dialog, "��ӳɹ�");

						JTable jtable = parent.getjTableHydj();

						Vector<Vector> data = null;
						try {
							data = mdao1.queryDate();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(dialog, "���ݲ�ѯʧ��");
							e1.printStackTrace();
						}
						DefaultTableModel dtm = new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
						jtable.setModel(dtm);
						dialog.dispose();
						// ���۴���Ϊ��
					}

				}

			}else if(dialog.addOrUpdate==ZjhydjDialog.UPDATE){
				MgradeVo vo = new MgradeVo();
				MgradeDao mdao = new MgradeDao();
				  JTable jtb=parent.getjTableHydj();
				  Integer mgid=Integer.parseInt(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
				  vo.setMgid(mgid);
                    String strmgname = dialog.getJthydj().getText();
					vo.setMgname(strmgname);
					String strcsjf = dialog.getJtcsjf().getText();
					if (YanZhengUtil.isShuZi(strcsjf)) {
						vo.setCsjf(Integer.parseInt(strcsjf));
					}else{
						JOptionPane.showMessageDialog(dialog, "��ʼ���ֱ���Ϊ����!");
						return;
					}
					String strrebate = dialog.getJtqcdz().getText();

					if (strrebate.matches("[0-9]*[.]?[0-9]+")) {
						vo.setRebate(Double.parseDouble(strrebate));
					} else {
						JOptionPane.showMessageDialog(dialog, "������Ĵ��۱�����ʽ����ȷ������������");
						return;
					}
					String strusenubmer = dialog.getJtsycs().getText();
					if (strusenubmer.length()!=0) {
						if (strusenubmer.matches("[0-9]+")) {
							vo.setUsenumber(Integer.parseInt(strusenubmer));
						}
                        // System.out.println("vo----->"+vo);
						boolean falge = mdao.updateMgradeAll(vo);
						if (falge == true) {
							//JOptionPane.showMessageDialog(dialog, "�޸ĳɹ�");
							JTable jtable = parent.getjTableHydj();

							Vector<Vector> data = null;
							try {
								data = mdao.queryDate();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(dialog, "���ݲ�ѯʧ��");
								e1.printStackTrace();
							}
							DefaultTableModel dtm = new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
							jtable.setModel(dtm);
							dialog.dispose();
							
						} else {

							JOptionPane.showMessageDialog(dialog, "���ʧ��");
						}

					} else {

						MgradeDao mdao1 = new MgradeDao();
						vo.setUsenumber(null);
						boolean falge1 = mdao1.updateMgradeAll(vo);
						if (falge1 == true) {
							
							//JOptionPane.showMessageDialog(dialog, "��ӳɹ�");
							JTable jtable = parent.getjTableHydj();

							Vector<Vector> data = null;
							try {
								data = mdao.queryDate();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(dialog, "���ݲ�ѯʧ��");
								e1.printStackTrace();
							}
							DefaultTableModel dtm = new DefaultTableModel(data,ColumnContent.arrayToVector(ColumnContent.HUIYUANDENGJI_CLUMN_NAME));
							jtable.setModel(dtm);
							dialog.dispose();
							// ���۴���Ϊ��
						}

					}

				
			}

		}else if(e.getSource().equals(dialog.getMjbcancel())){
			dialog.dispose();
			
		}

	}
}

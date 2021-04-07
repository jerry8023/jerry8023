package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dao.OperatorDao;
import com.jdbc.util.JdbcTemplate;
import com.thread.Timer;
import com.util.YanZhengUtil;
import com.view.AppMainFrame;
import com.view.Login;
import com.view.util.ChineseCodePanel;
import com.vo.OperatorVo;

public class LoginAction implements ActionListener {
	
	public static final int LOGIN=1;
	public static final int HUANBAN=2;
	
	
	private static int dqOid;
	private static String dqOname;
	private Login frame;
	public static int flag=1;
	public static JFrame ylFrame;
	
	public LoginAction(Login frame){
		this.frame=frame;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(frame.getJbLogin())){
			String yzm=frame.getJtfYz().getText();
			if(yzm.length()==0){
				JOptionPane.showMessageDialog(frame, "��֤�벻��Ϊ��!");
				return;
			}
			HashMap<Integer, Integer> hashMap=frame.getMjcbName().getValues();
			int values=hashMap.get(frame.getMjcbName().getSelectedIndex());
			OperatorDao dao=new OperatorDao();
			try {
				OperatorVo vo=dao.getdataById(values);
				Integer password=vo.getPassword();
				String strPassword=new String(frame.getJpfPassword().getPassword());
				if(YanZhengUtil.isShuZi(strPassword)){
					if(Integer.parseInt(strPassword)==password){
						if(yzm.equals(ChineseCodePanel.num)|| true){
							frame.setTitle("���ڵ�¼�����Ժ�...");
							new AppMainFrame();
							dqOid=vo.getOid();
							dqOname=vo.getOname();
							if(flag==2){
								ylFrame.dispose();
							}
							frame.dispose();
						}else{
							JOptionPane.showMessageDialog(frame, "��֤���������������!");
							frame.setJpYz(new ChineseCodePanel(110,35));
							frame.getJpYz().repaint();
							frame.getJp5().repaint();
							frame.getJtfYz().setText("");
							frame.getJtfYz().requestFocus();
							return;
						}
						
					}else{
						JOptionPane.showMessageDialog(frame, "��������û���������������飡");
						return;
					}
				}else{
					JOptionPane.showMessageDialog(frame, "�������Ϊ����!");
					return;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(frame, "ϵͳ�쳣!");
			}
			
		}else if(e.getSource().equals(frame.getJbExit())){
			frame.dispose();
		}else if(e.getSource().equals(frame.getMjbHyz())){
			frame.setJpYz(new ChineseCodePanel(110,35));
			frame.getJpYz().repaint();
			frame.getJp5().repaint();
		}
		
	}

	public static int getDqOid() {
		return dqOid;
	}

	public static String getDqOname() {
		return dqOname;
	}

	
	

}

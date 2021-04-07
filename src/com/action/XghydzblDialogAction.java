package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.util.YanZhengUtil;
import com.view.DxdzDialog;
import com.view.XghydzblDialog;

public class XghydzblDialogAction implements ActionListener{
	
	private XghydzblDialog frame;
	
	public XghydzblDialogAction(XghydzblDialog frame){
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getJcbDzlx())){
			if(frame.getJcbDzlx().getSelectedItem().toString().equals("不打折")){
				frame.getJtfDzbl().setText("1.0");
				frame.getJtfDzbl().setEnabled(false);
			}else if(frame.getJcbDzlx().getSelectedItem().toString().equals("打折")){
				frame.getJtfDzbl().setText("无");
				frame.getJtfDzbl().setEnabled(true);
			}
		}else if(e.getSource().equals(frame.getMjbQd())){
			String dzbl=frame.getJtfDzbl().getText();
			if(YanZhengUtil.isShuZi(dzbl)||YanZhengUtil.isXiaoShu(dzbl)||dzbl.equals("无")){
				if(!dzbl.endsWith("无")){
					if(YanZhengUtil.isShuZi(dzbl)){
						if(Integer.parseInt(dzbl)!=1 && Integer.parseInt(dzbl)!=0){
							JOptionPane.showMessageDialog(frame, "打折比率有误");
							frame.getJtfDzbl().setText("无");
							frame.getJtfDzbl().requestFocus();
							return;
						}
					}else if(YanZhengUtil.isXiaoShu(dzbl)){
						if(Double.parseDouble(dzbl)>1||Double.parseDouble(dzbl)<0){
							JOptionPane.showMessageDialog(frame, "打折比率有误");
							frame.getJtfDzbl().setText("无");
							frame.getJtfDzbl().requestFocus();
							return;
						}
					}
				}
			}else{
				JOptionPane.showMessageDialog(frame, "打折比率有误");
				frame.getJtfDzbl().setText("无");
				frame.getJtfDzbl().requestFocus();
				return;
			}
			
			DxdzDialog dxdzDialog=((DxdzDialog)frame.getParent());
			int index=dxdzDialog.getJtdxdzdxdz().getSelectedRow();
			DxdzDialog.rowdatas.get(index).set(1, dzbl);
			frame.dispose();
			
			
		}else if(e.getSource().equals(frame.getMjbQx())){
			frame.dispose();
		}
		
	}
	
	
}

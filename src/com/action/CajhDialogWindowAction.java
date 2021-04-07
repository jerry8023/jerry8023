package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.view.CajhDialogWindow;
import com.view.CgjhDialog;

public class CajhDialogWindowAction implements ActionListener{
	private CajhDialogWindow frame;
	public CajhDialogWindowAction(CajhDialogWindow frame){
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbcajhOk())){
			int selected = frame.getJtsupplier().getSelectedRow();
			if(selected!=-1){
				String ghdwName = frame.getJtsupplier().getValueAt(selected, 1).toString();
				//System.out.println(ghdwName);
				CgjhDialog parent = (CgjhDialog) frame.getParent();
				parent.getJtfghdw().setText(ghdwName);
				frame.dispose();
			}else{
					JOptionPane.showMessageDialog(frame, "请选中一行数据！");
			}
		}else if(e.getSource().equals(frame.getMjbcajhCancel())){
			frame.dispose();
		}
		
	}
}

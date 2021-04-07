package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.view.CgjhDialog;
import com.view.CkszDialog;
import com.view.GhsxxDialog;
import com.view.SpglDialog;
import com.view.SpszDialog;

public class SpglDialogAction implements ActionListener {

	private SpglDialog frame;
	public SpglDialogAction(SpglDialog frame){
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbCgjh())){
			new CgjhDialog(frame,true,CgjhDialog.CGJH);
		}else if(e.getSource().equals(frame.getMjbCgth())){
			new CgjhDialog(frame,true,CgjhDialog.CGTH);
		}else if(e.getSource().equals(frame.getMjbKcdb())){
			new CgjhDialog(frame,true,CgjhDialog.KCDB);
		}else if(e.getSource().equals(frame.getMjbBsby())){
			new CgjhDialog(frame,true,CgjhDialog.BSBY);
		}else if(e.getSource().equals(frame.getJbSpsz())){
			new SpszDialog(frame, true);
		}else if(e.getSource().equals(frame.getJbGhsxx())){
			new GhsxxDialog(frame, false);
		}else if(e.getSource().equals(frame.getJbCksz())){
			new CkszDialog(frame, true);
		}

	}

}

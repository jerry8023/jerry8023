package com.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.view.DxdzDialog;
import com.view.XghydzblDialog;

public class DxdzDialogMouseListener implements MouseListener {
	
	private DxdzDialog frame;
	
	public DxdzDialogMouseListener(DxdzDialog frame){
		this.frame=frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton()==MouseEvent.BUTTON1 && e.getClickCount()==2){
			new XghydzblDialog(frame,true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}

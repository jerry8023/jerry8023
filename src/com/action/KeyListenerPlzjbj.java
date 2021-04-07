package com.action;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class KeyListenerPlzjbj implements KeyListener {

	private String str="";
	public void keyPressed(KeyEvent e) {
		
	}

	
	public void keyReleased(KeyEvent e) {
		//e.
		
		JTextField jtf = (JTextField) e.getSource();
	//	String value = jtf.getText();
		
		//System.out.println(e.getKeyCode());
		
		if((e.getKeyCode()>=KeyEvent.VK_0)&&(e.getKeyCode()<=KeyEvent.VK_9)){
			str+=e.getKeyChar();
			
			jtf.setText(str);
			
		}else if(e.getKeyCode()==8){
			str = str.substring(0,str.length()-1);
			//System.out.println("str:"+str);
			jtf.setText(str);
		}else{
			jtf.setText(str);
			return;
		}

		
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

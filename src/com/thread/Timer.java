package com.thread;

import java.util.Date;

import com.util.DateUtil;
import com.view.AppMainFrame;

public class Timer extends Thread{
	
	private AppMainFrame frame;
	
	public Timer(AppMainFrame frame){
		this.frame=frame;
	}
	
	public void run(){
		
		while(true){
			
			Date date=new Date();
			String strTime=DateUtil.getStrDate(date, DateUtil.DATE_TIME);
			frame.getJlTime().setText(strTime);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

package com.view.util;

import java.util.HashMap;

import javax.swing.JComboBox;

public class MyJComBoBox extends JComboBox{
	
	
	
	private static final long serialVersionUID = -8647308696337945582L;



	private HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
	
	
	private int size=0;
	

	/**
	 * @param itemName 做为JComboBox中要显示到界面的内容
	 * @param no  保存itemName的所在表的编号
	 */
	public void addItem(String itemName,int no){
		this.addItem(itemName);	
		values.put(size, no);
		size++;
	}

	
	
	public HashMap<Integer, Integer> getValues() {
		return values;
	}


}

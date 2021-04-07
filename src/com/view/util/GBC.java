package com.view.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * GBC.java:重写GridBagConstraints类，功能1.简化包布局约束；功能2.可以无限级联
 * @author czp
 * @time 2013-7-11 上午12:46:41
 * 
 */
public class GBC extends GridBagConstraints{
	
	
	private static final long serialVersionUID = 5795042715379200624L;


	/**
	 * @param gridx：X轴的位置
	 * @param gridy：Y轴的位置
	 */
	public GBC(int gridx,int gridy){
		super.gridx = gridx;
		super.gridy = gridy;
		super.insets =  new Insets(0, 5, 10, 0);
	}
	
	
	/**
	 * @param gridx：X轴的位置
	 * @param gridy：Y轴的位置
	 * @param gridWidth：水平方向合并的单元格数，默认为1
	 * @param gridheight：竖直方向合并的单元格数，默认为1
	 */
	public GBC(int gridx,int gridy,int gridWidth,int gridheight){
		super.gridx = gridx;
		super.gridy = gridy;
		super.gridwidth = gridWidth;
		super.gridheight = gridheight;
		super.insets =  new Insets(0, 5, 5, 0);
	}
	
	
	//设置合并单元格的填充，可以级联即GBC().setfill().setinsets().....
	public GBC setFill(int fill){
		super.fill = fill;
		return this;
	}
	
    //设置组件和容器的前后左右方向的相对位置，可以级联
	public GBC setInSets(int top,int left,int bottom,int right){
		super.insets =  new Insets(top, left, bottom, right);
		return this;
	} 
	
	//设置组件的对齐方式
	public GBC setAnchor(int anchor){
		super.anchor = anchor;
		return this;
	}
	
	
	
	
}

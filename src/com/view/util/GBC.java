package com.view.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * GBC.java:��дGridBagConstraints�࣬����1.�򻯰�����Լ��������2.�������޼���
 * @author czp
 * @time 2013-7-11 ����12:46:41
 * 
 */
public class GBC extends GridBagConstraints{
	
	
	private static final long serialVersionUID = 5795042715379200624L;


	/**
	 * @param gridx��X���λ��
	 * @param gridy��Y���λ��
	 */
	public GBC(int gridx,int gridy){
		super.gridx = gridx;
		super.gridy = gridy;
		super.insets =  new Insets(0, 5, 10, 0);
	}
	
	
	/**
	 * @param gridx��X���λ��
	 * @param gridy��Y���λ��
	 * @param gridWidth��ˮƽ����ϲ��ĵ�Ԫ������Ĭ��Ϊ1
	 * @param gridheight����ֱ����ϲ��ĵ�Ԫ������Ĭ��Ϊ1
	 */
	public GBC(int gridx,int gridy,int gridWidth,int gridheight){
		super.gridx = gridx;
		super.gridy = gridy;
		super.gridwidth = gridWidth;
		super.gridheight = gridheight;
		super.insets =  new Insets(0, 5, 5, 0);
	}
	
	
	//���úϲ���Ԫ�����䣬���Լ�����GBC().setfill().setinsets().....
	public GBC setFill(int fill){
		super.fill = fill;
		return this;
	}
	
    //���������������ǰ�����ҷ�������λ�ã����Լ���
	public GBC setInSets(int top,int left,int bottom,int right){
		super.insets =  new Insets(top, left, bottom, right);
		return this;
	} 
	
	//��������Ķ��뷽ʽ
	public GBC setAnchor(int anchor){
		super.anchor = anchor;
		return this;
	}
	
	
	
	
}

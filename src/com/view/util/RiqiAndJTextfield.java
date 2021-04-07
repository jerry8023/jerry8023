package com.view.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RiqiAndJTextfield {

	//用于将文本框的边去掉及同时将其与日历按钮加面板中
	public static JPanel getRiQiJpanel(JTextField jtextField,MyJButton myJButton){
		JPanel jpRiQi = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,-2));
		jpRiQi.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		jpRiQi.setBackground(Color.WHITE);
		jpRiQi.setPreferredSize(new Dimension(120,20));
		jtextField.setBorder(null);
		jpRiQi.add(jtextField);
		jpRiQi.add(myJButton);
		
		return jpRiQi;
	}
	public static void setUnchangedTextFiled(JTextField jTextFiled,int alignment){
		jTextFiled.setBackground(null);
		jTextFiled.setOpaque(false);
		jTextFiled.setEditable(false);
		jTextFiled.setForeground(Color.red);
		jTextFiled.setHorizontalAlignment(alignment);
	}
}

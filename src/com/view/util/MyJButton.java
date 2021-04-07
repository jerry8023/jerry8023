package com.view.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * MyJButton.java:重写JButton类，功能1.通过传入三张按钮的默认，鼠标移入，鼠标按下的图片，生成只有图片的可随鼠标变化而变化的按钮
 * 功能2.通过传入按钮的名称和按钮的图片，生成按钮。默认为文字在图片的最下方。
 * 功能3.可以级联
 * @author czp
 * @time 2013-7-11 上午12:59:32
 * 注意：要实现各个按钮的无间隙排列，需在按钮当下的布局（流布局）
 * 设置水平组件间距为-5（经验哈。。。）如：
 * JPanel toolPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-2));
 */
public class MyJButton extends JButton {
	
    
	private static final long serialVersionUID = 3133398806064974115L;

	
	//通过传入三张按钮的默认，鼠标移入，鼠标按下的图片，生成只有图片的可随鼠标变化而变化的按钮
	public MyJButton(String defaultImagePath,String rolloverImagePath,String pressImagePath){
		
		//默认图标
		super(new ImageIcon(defaultImagePath));
		//按下时的图标。
		super.setPressedIcon(new ImageIcon(pressImagePath));
		//鼠标经过时的图标。
		super.setRolloverIcon(new ImageIcon(rolloverImagePath));
		//super.setRolloverSelectedIcon(new ImageIcon(rolloverImagePath));
		
		super.setBorderPainted(false);
		super.setFocusPainted(false);
		super.setContentAreaFilled(false);
		super.setMargin(new Insets(0, 0, 0, 0));
		
	}
	
	
	//通过传入按钮的名称和按钮的图片，生成按钮。默认为文字在图片的最下方。
	public MyJButton(String text,String imagePath){
		super(text, new ImageIcon(imagePath));
		super.setHorizontalTextPosition(JButton.CENTER);
		super.setVerticalTextPosition(JButton.BOTTOM);
	}
	
	
	//只有文字的按钮
	public MyJButton(String text){
		super(text);
	}
	
	
	
	public MyJButton set_HorizontalTextPosition(int textPosition){
		super.setHorizontalTextPosition(textPosition);
		return this;
	}
	
	
	public MyJButton set_VerticalTextPosition(int textPosition){
		super.setVerticalTextPosition(textPosition);
		return this;
	}
	
	
	//改变边距，如果 borderPainted 和 contentAreaFilled 都设成了 false，建议把边距都调为 0：new Insets(0, 0, 0, 0)。
	public MyJButton set_Margin(Insets m ){
		super.setMargin(m);
		return this;
	}

	
	//是否画边框，如果用自定义图片做按钮背景可以设为 false。
	public MyJButton set_BorderPainted(boolean b){
		super.setBorderPainted(b);
		return this;
	}
	
	//是否填充，如果你的自定义图片不是矩形或存在空白边距，可以设为 false 使按钮看起来透明。
	public MyJButton set_ContentAreaFilled(boolean b){
		super.setContentAreaFilled(b);
		return this;
	}
	
	
	//是否绘制焦点（例如浅色虚线框或者加粗的边框表明按钮当前有焦点）。
	public MyJButton set_FocusPainted(boolean b)	{
		super.setFocusPainted(b);
		return this;
	}
	
	
	
	public MyJButton set_Background(Color bg){
		super.setBackground(bg);
		return this;
	}
	
	
	public MyJButton set_Opaque(boolean isOpaque){
		super.setBackground(null);
		super.setOpaque(isOpaque);
		return this;
	}
	
	
	public MyJButton set_PreferredSize(Dimension preferredSize){
		super.setPreferredSize(preferredSize);
		return this;
	}
	
	public MyJButton set_Border(Border border){
		super.setBorder(border);
		return this;
	}
	
	
}

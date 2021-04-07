package com.view.util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

public class ChineseCodePanel extends JPanel{
	
	public static String num="";
	private int width;
	private int height;
	
	public ChineseCodePanel(int width, int height){
		//super(new FlowLayout(FlowLayout.LEFT,0,0));
		this.width=width;
		this.height=height;
	}
	
	public void paint(Graphics g){
		
		String hanzi="编程思想算法导论疯狂讲义类对象继承派生中信中南数学计算机流包多态封装反射数据结构集合数组设计模式接电话手机卡科技大厦可动可设计师等级考试了教科书小明星阿卡电视剧收到了卡拉胶偶尔啊加快了卡讲道理欧文现金科比卡卡龙卡乐极哀来西门子往前看厦门哪里可能看来就是啦小侄女什么的那些算啦看大理石都上升到金额学派是";
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gs=image.getGraphics();
		if(num.length()!=0 && num!=null){
			num="";
		}
		gs.setFont(new Font("黑体",Font.BOLD,18));
		//填充一个矩形。。。。。
		gs.fillRect(0, 0, width, height);
		
		for(int i=0;i<4;i++){
			Random random=new Random();
			int index=random.nextInt(hanzi.length());
			String ctmp=hanzi.substring(index, index+1);
			num+=ctmp;
			gs.setColor(new Color(20+random.nextInt(120),20+random.nextInt(120),20+random.nextInt(120)));
			Graphics2D gs2d=(Graphics2D)gs;
			AffineTransform trans=new AffineTransform();
			//旋转字体
			trans.rotate(random.nextInt(45)*3.14/180, 22*i+8,7);
			Float scaleSize=random.nextFloat()+0.8f;
			if(scaleSize>1f){
				scaleSize=1f;
			}
			//缩放字体
			trans.scale(scaleSize, scaleSize);
			gs2d.setTransform(trans);
			gs.drawString(ctmp, width/6*i+28,height/2);
		}
		
		g.drawImage(image, 0, 0, null);
	}

}

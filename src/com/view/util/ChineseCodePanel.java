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
		
		String hanzi="���˼���㷨���۷���������̳���������������ѧ�����������̬��װ�������ݽṹ�����������ģʽ�ӵ绰�ֻ����Ƽ����ÿɶ������ʦ�ȼ������˽̿���С���ǰ������Ӿ��յ��˿�����ż�����ӿ��˿�������ŷ���ֽ�Ʊȿ��������ּ�������������ǰ������������ܿ���������СֶŮʲô����Щ����������ʯ�����������ѧ����";
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gs=image.getGraphics();
		if(num.length()!=0 && num!=null){
			num="";
		}
		gs.setFont(new Font("����",Font.BOLD,18));
		//���һ�����Ρ���������
		gs.fillRect(0, 0, width, height);
		
		for(int i=0;i<4;i++){
			Random random=new Random();
			int index=random.nextInt(hanzi.length());
			String ctmp=hanzi.substring(index, index+1);
			num+=ctmp;
			gs.setColor(new Color(20+random.nextInt(120),20+random.nextInt(120),20+random.nextInt(120)));
			Graphics2D gs2d=(Graphics2D)gs;
			AffineTransform trans=new AffineTransform();
			//��ת����
			trans.rotate(random.nextInt(45)*3.14/180, 22*i+8,7);
			Float scaleSize=random.nextFloat()+0.8f;
			if(scaleSize>1f){
				scaleSize=1f;
			}
			//��������
			trans.scale(scaleSize, scaleSize);
			gs2d.setTransform(trans);
			gs.drawString(ctmp, width/6*i+28,height/2);
		}
		
		g.drawImage(image, 0, 0, null);
	}

}

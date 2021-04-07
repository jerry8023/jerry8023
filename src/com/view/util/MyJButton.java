package com.view.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * MyJButton.java:��дJButton�࣬����1.ͨ���������Ű�ť��Ĭ�ϣ�������룬��갴�µ�ͼƬ������ֻ��ͼƬ�Ŀ������仯���仯�İ�ť
 * ����2.ͨ�����밴ť�����ƺͰ�ť��ͼƬ�����ɰ�ť��Ĭ��Ϊ������ͼƬ�����·���
 * ����3.���Լ���
 * @author czp
 * @time 2013-7-11 ����12:59:32
 * ע�⣺Ҫʵ�ָ�����ť���޼�϶���У����ڰ�ť���µĲ��֣������֣�
 * ����ˮƽ������Ϊ-5����������������磺
 * JPanel toolPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,-5,-2));
 */
public class MyJButton extends JButton {
	
    
	private static final long serialVersionUID = 3133398806064974115L;

	
	//ͨ���������Ű�ť��Ĭ�ϣ�������룬��갴�µ�ͼƬ������ֻ��ͼƬ�Ŀ������仯���仯�İ�ť
	public MyJButton(String defaultImagePath,String rolloverImagePath,String pressImagePath){
		
		//Ĭ��ͼ��
		super(new ImageIcon(defaultImagePath));
		//����ʱ��ͼ�ꡣ
		super.setPressedIcon(new ImageIcon(pressImagePath));
		//��꾭��ʱ��ͼ�ꡣ
		super.setRolloverIcon(new ImageIcon(rolloverImagePath));
		//super.setRolloverSelectedIcon(new ImageIcon(rolloverImagePath));
		
		super.setBorderPainted(false);
		super.setFocusPainted(false);
		super.setContentAreaFilled(false);
		super.setMargin(new Insets(0, 0, 0, 0));
		
	}
	
	
	//ͨ�����밴ť�����ƺͰ�ť��ͼƬ�����ɰ�ť��Ĭ��Ϊ������ͼƬ�����·���
	public MyJButton(String text,String imagePath){
		super(text, new ImageIcon(imagePath));
		super.setHorizontalTextPosition(JButton.CENTER);
		super.setVerticalTextPosition(JButton.BOTTOM);
	}
	
	
	//ֻ�����ֵİ�ť
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
	
	
	//�ı�߾࣬��� borderPainted �� contentAreaFilled ������� false������ѱ߾඼��Ϊ 0��new Insets(0, 0, 0, 0)��
	public MyJButton set_Margin(Insets m ){
		super.setMargin(m);
		return this;
	}

	
	//�Ƿ񻭱߿�������Զ���ͼƬ����ť����������Ϊ false��
	public MyJButton set_BorderPainted(boolean b){
		super.setBorderPainted(b);
		return this;
	}
	
	//�Ƿ���䣬�������Զ���ͼƬ���Ǿ��λ���ڿհױ߾࣬������Ϊ false ʹ��ť������͸����
	public MyJButton set_ContentAreaFilled(boolean b){
		super.setContentAreaFilled(b);
		return this;
	}
	
	
	//�Ƿ���ƽ��㣨����ǳɫ���߿���߼Ӵֵı߿������ť��ǰ�н��㣩��
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

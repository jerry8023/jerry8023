package com.view.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * MyJPanel.java:��дJpanel,ʹ�����б���ͼƬ��Jpanel������ͼƬ������ģʽ��ʾ�����У�ƽ�̺����졣
 * @author czp
 * @time 2013-7-11 ����1:28:48
 * 
 */
public class MyJPanel extends JPanel{
	
	
	private static final long serialVersionUID = -3975024462956144044L;
	
	
	//����
	public final static int CENTRE=1;
	//ƽ��
	public final static int TILED=2;
	//����
	public final static int SCALED=3;
	
	
	private String imagePath;
	private int model;
	
	
	/**
	 * ���췽��
	 * @param layoutManager ���ֹ�����
	 * @param imagePath ����ͼƬ��·��
	 * @param model ��ʾģʽ�����У�MyJPanel.CENTRE��ƽ�̣�MyJPanel.TILED,���죺MyJPanel.SCALED
	 */
	public MyJPanel(LayoutManager layoutManager,String imagePath,int model){
		super(layoutManager);
		this.imagePath=imagePath;
		this.model=model;
	}

	
	
	
	//ʵ�ֵĴ���
	protected void paintComponent(Graphics g){
		//super.paintComponent(g);
		
		 //��������˱���ͼƬ����ʾ
        if(imagePath != null){
        	Image iamge = new ImageIcon(imagePath).getImage();
            int width = this.getWidth();
            int height = this.getHeight();
            int imageWidth = iamge.getWidth(this);
            int imageHeight = iamge.getHeight(this);

            switch(model){
            
                //����
                case 1:{
                    int x = (width - imageWidth) / 2;
                    int y = (height - imageHeight) / 2;
                    g.drawImage(iamge, x, y, this);
                    break;
                }
                
                //ƽ��
                case 2:{
                    for(int ix = 0; ix < width; ix += imageWidth){
                    	
                        for(int iy = 0; iy < height; iy += imageHeight){
                            g.drawImage(iamge, ix, iy, this);
                        }
                    }
                    
                    break;
                }
                
                //����
                case 3:{
                    g.drawImage(iamge, 0, 0, width, height, this);
                    break;
                }
                
            }
            
        }
        
	}
	
	

}

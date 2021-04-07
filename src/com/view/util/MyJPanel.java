package com.view.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * MyJPanel.java:重写Jpanel,使生成有背景图片的Jpanel。并且图片以三种模式显示：居中，平铺和拉伸。
 * @author czp
 * @time 2013-7-11 上午1:28:48
 * 
 */
public class MyJPanel extends JPanel{
	
	
	private static final long serialVersionUID = -3975024462956144044L;
	
	
	//居中
	public final static int CENTRE=1;
	//平铺
	public final static int TILED=2;
	//拉伸
	public final static int SCALED=3;
	
	
	private String imagePath;
	private int model;
	
	
	/**
	 * 构造方法
	 * @param layoutManager 布局管理器
	 * @param imagePath 背景图片的路径
	 * @param model 显示模式，居中：MyJPanel.CENTRE；平铺：MyJPanel.TILED,拉伸：MyJPanel.SCALED
	 */
	public MyJPanel(LayoutManager layoutManager,String imagePath,int model){
		super(layoutManager);
		this.imagePath=imagePath;
		this.model=model;
	}

	
	
	
	//实现的代码
	protected void paintComponent(Graphics g){
		//super.paintComponent(g);
		
		 //如果设置了背景图片则显示
        if(imagePath != null){
        	Image iamge = new ImageIcon(imagePath).getImage();
            int width = this.getWidth();
            int height = this.getHeight();
            int imageWidth = iamge.getWidth(this);
            int imageHeight = iamge.getHeight(this);

            switch(model){
            
                //居中
                case 1:{
                    int x = (width - imageWidth) / 2;
                    int y = (height - imageHeight) / 2;
                    g.drawImage(iamge, x, y, this);
                    break;
                }
                
                //平铺
                case 2:{
                    for(int ix = 0; ix < width; ix += imageWidth){
                    	
                        for(int iy = 0; iy < height; iy += imageHeight){
                            g.drawImage(iamge, ix, iy, this);
                        }
                    }
                    
                    break;
                }
                
                //拉伸
                case 3:{
                    g.drawImage(iamge, 0, 0, width, height, this);
                    break;
                }
                
            }
            
        }
        
	}
	
	

}

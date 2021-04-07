package com.view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.view.util.MyJButton;
import com.view.util.MyJPanel;

/**
 *
 * YycxDialog.java:营业查询界面
 * @author czp
 * @time 2013-7-11 上午2:17:44
 * 
 */
public class YycxDialog extends JDialog{
	
	
	private static final long serialVersionUID = 1769836771562528042L;


	public YycxDialog(AppMainFrame owner,boolean model){
		super(owner,model);
		super.setSize(625,436);
		super.setLocationRelativeTo(null);
		super.setTitle("营业查询");
		super.setResizable(false);
		Container container=super.getContentPane();
		container.add(content(),BorderLayout.CENTER);
		
 		super.setVisible(true);
		super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	
	public JPanel content(){
		JPanel jPanel=new MyJPanel(null, "image/yycx.png",MyJPanel.SCALED);
		jPanel.setBounds(5,23,616,408);
		
		JPanel contentOfLeft=contentOfLeft();
		contentOfLeft.setBounds(8,23,289,375);
		
		JPanel contentOfRight=contentOfRight();
		contentOfRight.setBounds(317,23,289,375);
		
		
		jPanel.add(contentOfLeft);
		jPanel.add(contentOfRight);
		
		return jPanel;
	}
	
	
	public JPanel contentOfLeft(){
		GridLayout gl=new GridLayout(3,2);
		gl.setVgap(-40);
		gl.setHgap(0);
		JPanel jPanel=new JPanel(gl);
		jPanel.setPreferredSize(new Dimension(289,375));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBorder(BorderFactory.createEtchedBorder());
		
		MyJButton mjbLbxxcx=new MyJButton("image//lbxxcx0.png", "image//lbxxcx1.png", "image//lbxxcx1.png");
		MyJButton mjbBkxfmx=new MyJButton("image//bkxfmx0.png", "image//bkxfmx1.png", "image//bkxfmx1.png");
		MyJButton mjbXfmxcx=new MyJButton("image//xfmxcx0.png", "image//xfmxcx1.png", "image/xfmxcx1.png");
		MyJButton mjbSymxcx=new MyJButton("image//symxcx0.png", "image//symxcx1.png", "image//symxcx1.png");
		MyJButton mjbJzdcx=new MyJButton("image//jzdcx0.png", "image//jzdcx1.png", "image//jzdcx1.png");
		MyJButton mjbFwstccx=new MyJButton("image//fwstccx0.png", "image//fwstccx1.png", "image//fwstccx1.png");
		
		
		jPanel.add(mjbLbxxcx);
		jPanel.add(mjbSymxcx);
		jPanel.add(mjbBkxfmx);
		jPanel.add(mjbJzdcx);
		jPanel.add(mjbXfmxcx);
		jPanel.add(mjbFwstccx);
		
		return jPanel;
	}
	
	
	
	public JPanel contentOfRight(){
		GridLayout gl=new GridLayout(4,2);
		gl.setVgap(-40);
		gl.setHgap(0);
		JPanel jPanel=new JPanel(gl);
		jPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jPanel.setPreferredSize(new Dimension(289,375));
		jPanel.setBackground(null);
		jPanel.setOpaque(false);
		jPanel.setBorder(BorderFactory.createEtchedBorder());
		
		MyJButton mjbYybb=new MyJButton("image//yybb0.png", "image//yybb1.png", "image//yybb1.png");
		mjbYybb.setMargin(new Insets(58, 0, 0, 0));
		MyJButton mjbZhtjbb=new MyJButton("image//zhtjbb0.png", "image//zhtjbb1.png", "image//zhtjbb1.png");
		MyJButton mjbYytjph=new MyJButton("image//yytjph0.png", "image//yytjph1.png", "image/yytjph1.png");
		mjbYytjph.setMargin(new Insets(58, 0, 0, 0));
		MyJButton mjbAzdtj=new MyJButton("image//azdtj0.png", "image//azdtj1.png", "image//azdtj1.png");
		MyJButton mjbTjyyt=new MyJButton("image//tjyyt0.png", "image//tjyyt1.png", "image//tjyyt1.png");
		mjbTjyyt.setMargin(new Insets(58, 0, 0, 0));
		MyJButton mjbAxfxmtj=new MyJButton("image//axfxmtj0.png", "image//axfxmtj1.png", "image//axfxmtj1.png");
		MyJButton mjbAbmtj=new MyJButton("image//abmtj0.png", "image//abmtj1.png", "image//abmtj1.png");
		
		
		jPanel.add(mjbZhtjbb);
		jPanel.add(mjbYybb);
		jPanel.add(mjbAzdtj);
		jPanel.add(mjbYytjph);
		jPanel.add(mjbAxfxmtj);
		jPanel.add(mjbTjyyt);
		jPanel.add(mjbAbmtj);
		
		
		return jPanel;
	}
	

	/*public static void main(String[] args) {
		new YycxDialog();
	}*/

}

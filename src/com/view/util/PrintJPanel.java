package com.view.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.dao.PreorderDao;
import com.util.ColumnContent;


public class PrintJPanel extends JPanel{
	
	private Vector<String> colname;
	private Vector<Vector> printRs;
	private int x;
	private int y;
	private int w;
	
	
	public PrintJPanel(Vector<Vector> printRs,Vector<String> colname, int x,int y,int w){
		super.setSize(1365,767);
		this.printRs=printRs;
		this.colname=colname;
		this.x=x;
		this.y=y;
		this.w=w;
	}
	
	
	public void paint(Graphics g){
		//g.setColor(Color.RED);
		Graphics gs=g.create();
		Graphics2D g2=(Graphics2D)gs;
		y=y+80;
		int y1=y;
		
		g2.drawString("ÐòºÅ", x+30, y);
		g2.drawLine(x+20, y-20,x+20+w, y-20);
		for(Integer i=0;i<colname.size();i++){
			g2.drawString(colname.get(i), x+131*(i+1), y);
		}
		
		
		
		for(Integer i=0;i<printRs.size();i++){
			y=y+30;
			g2.drawLine(x+20, y-20,x+20+w, y-20);
			g2.drawString(i.toString(), x+30, y);
			
			for(Integer j=0;j<printRs.get(i).size();j++){
				String str="";
				if(printRs.get(i).get(j)!=null){
					str=printRs.get(i).get(j).toString();
				}
				g2.drawString(str, x+131*(j+1), y);
			}
			
		}
		
		
		g2.drawLine(x+20, y+30-20,x+20+w, y+30-20);
		
		g2.drawLine(x+20, y1-20, x+20, y+10);
		for(int i=0;i<=printRs.get(0).size();i++){
			g2.drawLine(x+130*(i+1), y1-20, x+130*(i+1), y+10);
		}
		
	}
	
	
	/*public static void main(String[] args){
		PreorderDao poDao=new PreorderDao();
		Vector<Vector> rowdatasPo=null;
		try {
			rowdatasPo=poDao.queryData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame jf=new JFrame();
		jf.setSize(1365,767);
		jf.getContentPane().add(new PrintJPanel(rowdatasPo,ColumnContent.arrayToVector(ColumnContent.YUDING_CLUMN_NAME), 0, 0, 1278));
		jf.setVisible(true);
	}*/
	
	
	
}

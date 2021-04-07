package com.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.action.ZjspCgjhDialogAction;
import com.dao.GoodsDao;
import com.util.ColumnContent;
import com.view.util.GBC;
import com.view.util.MyJButton;


public class ZjspCgjhDialog extends JDialog{
	
		
		private static final long serialVersionUID = -4816566706112692670L;
		
		
		//简拼/编码
		private JTextField jtfspxmjpZjsp=new JTextField(8);
		//单价
		private JTextField jtfPricezjsp=new JTextField(5);
		//数量
		private JTextField jtfXfslXf=new JTextField("1",5);
		
		private JButton jbCgZjsp=new JButton("采购  [F3] ");
		
		private MyJButton mjbSaveZjsp = new MyJButton("保存");
		private MyJButton mjbDeleteZjsp = new MyJButton("删除");
		private MyJButton mjbCancelZjsp = new MyJButton("取消");
		
		//商品采购清单表
		private JTable jTableXfqd= null;
		
		//当前商品清单
		private JTable jTableSp = null;
		
		private CgjhDialog frame ;
		private int CCKB;
		public ZjspCgjhDialog(CgjhDialog frame,boolean model,int CCKB){
			super(frame,model);
			this.frame = frame;
			this.CCKB = CCKB;
			
			super.setSize(695,495);
			super.setLocationRelativeTo(null);
			super.setTitle("增加商品");
			super.setResizable(false);
			Container container=super.getContentPane();
			container.add(centerContent(),BorderLayout.CENTER);	
			
			addListener();
	 		super.setVisible(true);
			super.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
		
		public void addListener(){
			
			//为供货单位注册键值监听器
			jtfspxmjpZjsp.addKeyListener(new KeyListener() {
				
				String str = "";
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
				public void keyReleased(KeyEvent e) {
					System.out.println("键值："+e.getKeyCode());
					JTextField jtf = (JTextField) e.getSource();
					Integer id = frame.getJcmxzck().getValues().get(frame.getJcmxzck().getSelectedIndex());
					if(e.getKeyCode()==16){
						
					}else if(e.getKeyCode()==8){
						str = str.substring(0,str.length()-1);
					}else{
						str += e.getKeyChar();
					}
					System.out.println(str);
					jtf.setText(str);
					
					GoodsDao dao = new GoodsDao();
					Vector<Vector> dataList = null;
					try {
						if(jtf.getText().equals("")){
							dataList = dao.queryDataSp(id,CCKB);
						}else if(str.matches("[0-9]+")){
							dataList = dao.queryDataSpById(str,id,CCKB);
						}else{
							dataList = dao.queryDataSpByName(str,id,CCKB);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DefaultTableModel model = new DefaultTableModel(dataList,ColumnContent.arrayToVector(ColumnContent.SHANGPIN1_CLUMN_NAME));
					jTableSp.setModel(model);
					
				}
				
				
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			ZjspCgjhDialogAction  action = new ZjspCgjhDialogAction(this,CCKB);
			
			jbCgZjsp.addActionListener(action);
			mjbSaveZjsp.addActionListener(action);
			mjbCancelZjsp.addActionListener(action);
			mjbDeleteZjsp.addActionListener(action);
			
			
		}
		public JPanel centerContent(){
			JPanel jPanel=new JPanel(null);
			jPanel.setBackground(new Color(236,233,216));
			
			
			JPanel centerContentOfLeft=centerContentOfLeft();
			centerContentOfLeft.setBounds(3, 5, 330, 456);
			
			
			JPanel centerContentOfRight=centerContentOfRight();
			centerContentOfRight.setBounds(338, 5, 348, 456);
			
			jPanel.add(centerContentOfLeft);
			jPanel.add(centerContentOfRight);
			
			
			return jPanel;
		}
		
		public JPanel centerContentOfLeft(){
			JPanel jPanel=new JPanel(new BorderLayout());
			jPanel.setBackground(null);
			jPanel.setOpaque(false);
			jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			
			JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
			jpNorth.setPreferredSize(new Dimension(347,20));
			jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			jpNorth.setBackground(new Color(180,196,139));
			jpNorth.add(new JLabel("商品清单"));
			
			
			JTabbedPane jTabbedPane=new JTabbedPane();
			jTabbedPane.add("商品项目(清单)",jtpXfxmQd());
			jTabbedPane.add("商品项目(列表)",jtpXfxmLb());
			jTabbedPane.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			jTabbedPane.setBackground(new Color(249,246,230));
			

			jPanel.add(jpNorth, BorderLayout.NORTH);
			jPanel.add(jTabbedPane, BorderLayout.CENTER);
			
			return jPanel;
		}
		
		
		public JPanel jtpXfxmQd(){
			JPanel jPanel=new JPanel(new BorderLayout());
			
			jPanel.setBackground(new Color(236,233,216));
			
			GridBagLayout gbl=new GridBagLayout();
			JPanel jpNorth=new JPanel(gbl);
			jpNorth.setBackground(null);
			jpNorth.setOpaque(false);
			jpNorth.setPreferredSize(new Dimension(350, 82));
			
			GridBagConstraints gbc1=new GBC(0, 0,2,1).setInSets(0,0, 0, 0);
			JLabel jl= new JLabel("项目编码 / 简拼(Q):");
			gbl.setConstraints(jl, gbc1);
			jpNorth.add(jl);
			
			
			
			GridBagConstraints gbc2=new GBC(2, 0,2,1);
			jtfspxmjpZjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			gbl.setConstraints(jtfspxmjpZjsp, gbc2);
			jpNorth.add(jtfspxmjpZjsp);
			
			
			GridBagConstraints gbc3=new GBC(0,1).setAnchor(GBC.EAST).setInSets(5,0, 0, 5);
			JLabel jl2=new JLabel("单价:");
			gbl.setConstraints(jl2, gbc3);
			jpNorth.add(jl2);
			
			GridBagConstraints gbc4=new GBC(1, 1).setInSets(5, 0, 0, 0);
			jtfPricezjsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			gbl.setConstraints(jtfPricezjsp, gbc4);
			jpNorth.add(jtfPricezjsp);
			
			JLabel jl3 = new JLabel("数量:");
			GridBagConstraints gbc5=new GBC(2,1).setAnchor(GBC.EAST).setInSets(5,0, 0, 5);
			gbl.setConstraints(jl3, gbc5);
			jpNorth.add(jl3);
			
			
			GridBagConstraints gbc6=new GBC(3,1).setInSets(5, 0, 0, 0);
			jtfXfslXf.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			gbl.setConstraints(jtfXfslXf, gbc6);
			jpNorth.add(jtfXfslXf);
			
			GridBagConstraints gbc7=new GBC( 4,1).setAnchor(GBC.NORTHWEST).setInSets(5, 5, 0, 0);
			if(CCKB==1){
				jbCgZjsp.setText("退货 [F3] ");
			}else if(CCKB==2){
				jbCgZjsp.setText(" 调拨 [F3] ");
			}else if(CCKB==3){
				int selected = frame.getMjbbsby().getSelectedIndex();
				HashMap<Integer, Integer> map = frame.getMjbbsby().getValues();
				int id = map.get(selected);
				if(id==0){
					jbCgZjsp.setText("报损 [F3] ");
					
				}else if(id==1){
					jbCgZjsp.setText("报溢 [F3] ");
				}
			}
			jbCgZjsp.setMargin(new Insets(0, 0, 0, 0));
			jbCgZjsp.setBackground(new Color(251,249,231));
			jbCgZjsp.setPreferredSize(new Dimension(64,20));		
			gbl.setConstraints(jbCgZjsp, gbc7);
			jpNorth.add(jbCgZjsp);
			
			
			//----------------------------------------------------------
			GoodsDao dao = new GoodsDao();
			
			Integer id = frame.getJcmxzck().getValues().get(frame.getJcmxzck().getSelectedIndex());
			Vector<Vector> dataList = null;
			try{
				dataList = dao.queryDataSp(id,CCKB);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jTableSp=new JTable(dataList, ColumnContent.arrayToVector(ColumnContent.SHANGPINXIANGMU_CLUMN_NAME));
			JScrollPane jScrollPane1=new JScrollPane(jTableSp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jTableSp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTableSp.setFillsViewportHeight(true);
			
			jPanel.add(jpNorth, BorderLayout.NORTH);
			jPanel.add(jScrollPane1, BorderLayout.CENTER);
			
			
			return jPanel;
		}
		
		
		public JPanel jtpXfxmLb(){
			JPanel jPanel=new JPanel(new BorderLayout());
			jPanel.setBackground(Color.WHITE);
			
			
			return jPanel;
		}
		
		
		
		public JPanel centerContentOfRight(){
			JPanel jPanel=new JPanel(new BorderLayout());
			jPanel.setBackground(null);
			jPanel.setOpaque(false);
			jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			
			JPanel jpNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
			jpNorth.setPreferredSize(new Dimension(370,20));
			jpNorth.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
			jpNorth.setBackground(new Color(180,196,139));
			
			if(CCKB==0){
				jpNorth.add(new JLabel("商品采购清单"));
			}else if(CCKB==1){
				jpNorth.add(new JLabel("商品退货清单"));
			}
			
			
			//----------------------------------------------------------------------
			jTableXfqd=new JTable(null, ColumnContent.arrayToVector(ColumnContent.SHANGPINCAIGOULIST_CLUMN_NAME));
			jTableXfqd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTableXfqd.setFillsViewportHeight(true);
			JScrollPane jScrollPane2=new JScrollPane(jTableXfqd, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			
			
			jPanel.add(jpNorth, BorderLayout.NORTH);
			jPanel.add(jScrollPane2, BorderLayout.CENTER);
			jPanel.add(RightOfSouth(), BorderLayout.SOUTH);
			
			return jPanel;
		}
		
		public JPanel RightOfSouth(){
			JPanel jPanel=new JPanel(null);
			jPanel.setBackground(null);
			jPanel.setOpaque(false);
			jPanel.setPreferredSize(new Dimension(370, 76));
			
			
			JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
			jp1.setBackground(null);
			jp1.setOpaque(false);
			jp1.setBounds(20,10, 328, 22);
			
			
			
			JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
			jp2.setBackground(null);
			jp2.setOpaque(false);
			jp2.setBounds(0,40, 328, 22);
			
			
			mjbSaveZjsp.set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 20))
				.set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6)));
			
			mjbDeleteZjsp.set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 20))
			.set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6)));
			
			mjbCancelZjsp.set_Margin(new Insets(0, 0, 0, 0)).set_PreferredSize(new Dimension(66, 20))
			.set_Background(new Color(248,245,229)).set_Border(BorderFactory.createLineBorder(new Color(55,98,6)));
		
			
			jp2.add(mjbSaveZjsp);
			jp2.add(mjbDeleteZjsp);
			jp2.add(mjbCancelZjsp);
			
			
			
			
			jPanel.add(jp1);
			jPanel.add(jp2);
			
			return jPanel;
		}

		public JTextField getJtfspxmjpZjsp() {
			return jtfspxmjpZjsp;
		}

		public JTextField getJtfPricezjsp() {
			return jtfPricezjsp;
		}

		public JTextField getJtfXfslXf() {
			return jtfXfslXf;
		}

		
		public JButton getJbCgZjsp() {
			return jbCgZjsp;
		}

		public MyJButton getMjbSaveZjsp() {
			return mjbSaveZjsp;
		}

		public MyJButton getMjbDeleteZjsp() {
			return mjbDeleteZjsp;
		}

		public MyJButton getMjbCancelZjsp() {
			return mjbCancelZjsp;
		}

		public JTable getjTableXfqd() {
			return jTableXfqd;
		}

		public JTable getjTableSp() {
			return jTableSp;
		}

		
		
}

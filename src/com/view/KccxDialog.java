package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.util.ColumnContent;
import com.view.util.MyJButton;


public class KccxDialog extends JFrame{
	
	
	
	private static final long serialVersionUID = -4413505848484114261L;



	public KccxDialog(){
		
		 super.setSize(751, 546);
		 Container  container=super.getContentPane();
		 container.add(jPanelNorth(),BorderLayout.NORTH);
		 container.add(jPanelSouth(),BorderLayout.CENTER);
		 
		 super.setLocationRelativeTo(null);
		 super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 super.setResizable(false);
		 super.setVisible(true);
		 super.setTitle("��ǰ����ѯ");
		
		  
		  
		 
	 }
	
	  //����
	 public JPanel jPanelNorth(){
		 
		 JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		 jPanel.setPreferredSize(new Dimension(646, 73));
		 jPanel.setBackground(Color.pink);
		 
		 GridLayout gl1=new  GridLayout(2,1);
		 JPanel jp1=new JPanel(gl1);
		 jp1.setBackground(Color.pink);
		 jp1.setPreferredSize(new Dimension(300, 46));
		 
		 //-------------------------------------------------------
		 JPanel  firstPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		 firstPanel.setBackground(Color.pink);
		 firstPanel.setPreferredSize(new Dimension(300, 22));
		 firstPanel.add(new JLabel("��ʼʱ��:"));
		 
		 
		 JPanel jPanel1_1=new JPanel(new FlowLayout(FlowLayout.LEFT,0, 0));
		 jPanel1_1.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));//���ñ߿���ɫ
		 jPanel1_1.setPreferredSize(new Dimension(85, 22));//������������
		 jPanel1_1.setBackground(Color.WHITE);
		 
		  
		 		JTextField jtfQssj=new JTextField(6);
		     	jtfQssj.setBorder(null);
		 		jPanel1_1.add(jtfQssj);
		 
		 		JButton jbQssj=new JButton(new  ImageIcon("image/rl.png"));
		 		jbQssj.setRolloverIcon(new ImageIcon("image/rl1.png"));//��꾭����ͼƬ
		 		jbQssj.setRolloverSelectedIcon(new ImageIcon("image/rl2.png"));//��갴��ʱ��ͼƬ
		 		
		 		jbQssj.setMargin(new Insets(0, 0, 0, 0));//���ֳ�����ť
		 		jbQssj.setBorder(null);//ȥ�߿�
		 		jPanel1_1.add(jbQssj);
		 
		 firstPanel.add(jPanel1_1);
		 
		 
		 JTextField jtfQsqsj=new JTextField(5);
		 jtfQsqsj.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));
		 jtfQsqsj.setPreferredSize(new Dimension(60, 22));
		 
		 firstPanel.add(jtfQsqsj);
		 
		 //-------------------------------------------------------------------
		 JPanel  secondPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		 secondPanel.setPreferredSize(new Dimension(300, 22));
		 secondPanel.add(new JLabel("��ֹʱ��:"));
		 
		 		JPanel jPanel2_1=new JPanel(new FlowLayout(FlowLayout.LEFT,0, 0));
		 		jPanel2_1.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));//���ñ߿���ɫ
		 		jPanel2_1.setPreferredSize(new Dimension(85, 22));//������������
		 		
			 		  JTextField jtfZzsj=new JTextField(6);
			 		  jtfZzsj.setBorder(null);
			 		  jPanel2_1.add(jtfZzsj);
			 		  
			 		 
			 		  JButton jbZzsj=new JButton(new ImageIcon("image/rl.png"));
			 		  jbZzsj.setRolloverIcon(new ImageIcon("image/rl1.png"));//��꾭����ͼƬ
			 		  jbZzsj.setRolloverSelectedIcon(new ImageIcon("image/rl2.png"));//��꾭����ͼƬ
			 		  jbZzsj.setMargin(new Insets(0, 0, 0, 0));//���ֳ�����ť
			 		  jbZzsj.setBorder(null);
			 		  jPanel2_1.add(jbZzsj);
			 	
		 secondPanel.add(jPanel2_1);
		 
		 
	 	JTextField jtfZzjqsj=new JTextField(5);
	 	jtfZzjqsj.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));//���ñ߿����ɫ
	 	jtfZzjqsj.setPreferredSize(new Dimension(60,22));
	 	
	 	secondPanel.add(jtfZzjqsj);
	 		
		 
		 
		 
		 jp1.add(firstPanel);
		 jp1.add(secondPanel);
		 //---------------------------------------------------------------
		 
		 GridLayout gl2=new  GridLayout(3,2);
		 gl2.setHgap(0);
		 gl2.setVgap(5);
		 JPanel jp2=new JPanel(gl2);
		 jp2.setBackground(Color.BLUE);
		 jp1.setPreferredSize(new Dimension(157,74));
		 
		 
		 //----------------------------------------------------------------------
		
		 
		 jp2.add(new JLabel("ѡ��ֿ⣺"));
		 
		 Object[] xzck=new Object[]{"���вֿ�","�ֿܲ�"};
		 JComboBox jcbXzck =new JComboBox(xzck);
		 
		 
		 jcbXzck.setPreferredSize(new Dimension(89,22));//���ô�С
		 jcbXzck.setBorder(null);
		 jcbXzck.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));//���߿�
		 jcbXzck.setBackground(Color.WHITE);
		 
		 jp2.add(jcbXzck);
		
			 
		 		
		 jp2.add(new JLabel("��Ŀ����:"));
		 
		 Object [] xmlx=new Object[]{"������Ŀ","�ײ�","������","��Ʒ��","�Զ�����"};
		 JComboBox jcbXmlx=new JComboBox(xmlx);
		 jcbXmlx.setBorder(BorderFactory.createLineBorder(new Color(188,207,152) ));
		 jcbXmlx.setPreferredSize(new Dimension(89,22));
		 jcbXmlx.setBorder(null);
		 jcbXmlx.setBackground(Color.WHITE);
		 
		 jp2.add(jcbXmlx);
		 
		 
		 jp2.add(new JLabel("���/��ƴ��"));
		 
		 JTextField jtfBhjp=new JTextField(8);
		 jtfBhjp.setBorder(BorderFactory.createLineBorder(new Color(188,207,152)));//���ñ߿���ɫ
		 jtfBhjp.setPreferredSize(new Dimension(88,20));
		 
		 
		 
		 jp2.add(jtfBhjp);
		 
		 //------------------------------------------------------------
		 
		 JPanel jp3=new JPanel(new  FlowLayout(FlowLayout.LEFT,15,5));
		 
		 MyJButton mjbCx=new MyJButton("��ѯ").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(60, 21));
		 MyJButton mjbDc=new MyJButton("����").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(60, 21));
		 MyJButton mjbDy=new MyJButton("��ӡ").set_Margin(new Insets(0, 0, 0, 0)).set_Background(new Color(248,245,229)).set_PreferredSize(new Dimension(60, 21));
		 
		 
		 jp3.add(mjbCx);		 
		 jp3.add(mjbDc);			
		 jp3.add(mjbDy);			
		 		
		
		 
		 
		 jPanel.add(jp1);
		 jPanel.add(jp2);
		 jPanel.add(jp3);
		 
		 
		 return jPanel;
	 
		 
	 }
	
	 
	 
	 //�ϱ�
	 public JPanel jPanelSouth(){
		
		 JPanel jPanel=new JPanel(new BorderLayout());
		 jPanel.setBounds(13,117,724,413);
		 jPanel.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		 //����  ---------------------------
		 JPanel northPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		 northPanel.setPreferredSize(new Dimension(723,19));//����������С
		 northPanel.setBackground(new Color(173, 189, 133));//����������ɫ
		 	JLabel jlz=new JLabel("ע��ʱ�������ֻ������ͳ������Ч                                        ");
		 	 jlz.setForeground(Color.RED);//����������ɫ
		 	 
		 	JLabel jlkcspxx=new JLabel("�����Ʒ��Ϣ");
		
		 	northPanel.add(jlz);
		 	northPanel.add(jlkcspxx);
		 
		 //�в�---------------	
		 JPanel centerPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,8));
		 centerPanel.setPreferredSize(new Dimension(722,24));
		 JLabel jlbTjxm=new JLabel("ͳ����Ŀ��");
		 jlbTjxm.setForeground(Color.BLUE);//����������ɫ
		 centerPanel.add(jlbTjxm);
		 
		 JTextField jftTjxm=new JTextField(9);
		 jftTjxm.setBorder(BorderFactory.createLineBorder(Color.RED));
		 centerPanel.add(jftTjxm);
		 
		 
		 JLabel jlDqkc=new JLabel("��ǰ��� ��");
		 jlDqkc.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlDqkc);
		 
		 JTextField jtfDqkc=new JTextField(7);
		 jtfDqkc.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿���
		 centerPanel.add(jtfDqkc);
		 
		 JLabel jlJh=new JLabel("������");
		 jlJh.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlJh);
		 
		 JTextField jtfJh=new JTextField(4);
		 jtfJh.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿�
		 centerPanel.add(jtfJh);
		 
		 JLabel jlTh=new JLabel("�˻���");
		 jlTh.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlTh);
		 
		 JTextField jtfTh=new JTextField(4);
		 jtfTh.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿�
		 centerPanel.add(jtfTh);
		 
		 JLabel jlDb=new JLabel("������");
		 jlDb.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlDb);
		 
		 JTextField jtfDb=new JTextField(4);
		 jtfDb.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿�
		 centerPanel.add(jtfDb);
		 
		 JLabel jlBy=new JLabel("���磺");
		 jlBy.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlBy);
		 
		 JTextField jtfBy=new JTextField(4);
		 jtfBy.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿�
		 centerPanel.add(jtfBy);
		 
		 
		 JLabel jlBs=new JLabel("����");
		 jlBs.setForeground(Color.RED);//����������ɫ
		 centerPanel.add(jlBs);
		 
		 JTextField jtfBs=new JTextField(4);
		 jtfBs.setBorder(BorderFactory.createLineBorder(Color.RED));//���߿�
		 centerPanel.add(jtfBs);
		 
		 
		 
	     
		 jPanel.add(northPanel,BorderLayout.NORTH);
		 jPanel.add(centerPanel,BorderLayout.CENTER);
		 jPanel.add(southPanel(),BorderLayout.SOUTH);
		 
		 return jPanel;
		 
	 }
	
	 
	 public JScrollPane  southPanel(){
		 
		 
		 JTable  jtKcspxx=new JTable(null, ColumnContent.arrayToVector(ColumnContent.SHANGPINKUCUN_CLUMN_NAME));
		
		 
		 JScrollPane jsp=new JScrollPane(jtKcspxx, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//ˮƽ����ʹ�ֱ������Ĺ�������Ϊ��Ҫʱ���
		 jsp.setPreferredSize(new Dimension(722,368));
		 jsp.setBorder(BorderFactory.createLineBorder(new Color(143,172,117)));
		 
		 
		return jsp;
	  
	 }
		
	

	
	 
	public static void main(String[] args) {
		 
        new KccxDialog();
	}

}

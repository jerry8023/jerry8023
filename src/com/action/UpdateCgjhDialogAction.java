package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.util.ColumnContent;
import com.view.CgjhDialog;
import com.view.UpdateCgjhDialog;

public class UpdateCgjhDialogAction implements ActionListener {

	private UpdateCgjhDialog frame;
	private Double money = 0.0;
	public UpdateCgjhDialogAction(UpdateCgjhDialog frame){
		this.frame =  frame;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(frame.getMjbSaveucd())){
			if(!frame.getJtfSpslucd().getText().equals("")){
				JTable jTable = frame.getjTable();
				int selected = jTable.getSelectedRow();
				
				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
				Vector<Vector> vector = model.getDataVector();
				CgjhDialog parent = (CgjhDialog) frame.getParent();
				money = Double.parseDouble(parent.getJtfyfzk().getText())-Double.parseDouble(vector.get(selected).get(5).toString());
				vector.get(selected).setElementAt(frame.getJtfSpslucd().getText(), 4);
				Double spMoney = Double.parseDouble(frame.getJtfSppricecd().getText())*Integer.parseInt(frame.getJtfSpslucd().getText());
				//System.out.println("总额"+spMoney);
				
				money += spMoney;
				vector.get(selected).setElementAt(spMoney,5);
				DefaultTableModel dtm = new DefaultTableModel(vector,ColumnContent.arrayToVector(ColumnContent.CAIGOUSHANGPIN_CLUMN_NAME));
				jTable.setModel(dtm);
				parent.getJtfyfzk().setText(money.toString());
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(frame, "请输入商品数量！");
			}
		}else if(e.getSource().equals(frame.getMjbExitucd())){
			frame.dispose();
		}

	}

}

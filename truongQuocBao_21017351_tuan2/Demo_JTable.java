package deMoJFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Demo_JTable extends JFrame implements ActionListener{
	JButton btAdd,btRemove,btExit;
	JLabel lbHo,lbTen;
	JTextField txtHo,txtTen;
	DefaultTableModel model;
	JTable table;
	public Demo_JTable() {
		setTitle("Table Demo");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createGUI();
		setVisible(true);
	}
	private void createGUI() {
		JPanel p = new JPanel();
		lbHo = new JLabel("Ho ");
		txtHo = new JTextField(20);
		p.add(lbHo);
		p.add(txtHo);
		
		lbTen = new JLabel("Ten ");
		txtTen = new JTextField(20);
		p.add(lbTen);
		p.add(txtTen);
		
		add(p,BorderLayout.NORTH);
		
		String[] columns = {"Ho sinh vien","Ten sinh vien"};
		model = new DefaultTableModel(columns,0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		btAdd = new JButton("Them");
		btRemove = new JButton("Xoa");
		btExit = new JButton("Thoat");
		south.add(btAdd);
		south.add(btRemove);
		south.add(btExit);
		
		add(south,BorderLayout.SOUTH);
		
		btAdd.addActionListener(this);
		btRemove.addActionListener(this);
		btExit.addActionListener(this);
	}
	public static void main(String[] args) {
		new Demo_JTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o.equals(btExit))
			System.exit(0);
		else if(o.equals(btRemove)) {
			if(table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Ban phai chon dong can xoa.");
			else {
				if(JOptionPane.showConfirmDialog(this, "Ban co muon xoa dong nay khong?","Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					model.removeRow(table.getSelectedRow());
			}
		}
		else {
			if(txtTen.getText().equals("") || txtHo.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Phai nhap du lieu.");
			else {
				Object[] obj = new Object[2];
					obj[0] = txtHo.getText();
					obj[1] = txtTen.getText();
					model.addRow(obj);
					this.txtHo.setText("");
					this.txtTen.setText("");
			}
		}
		
	}
}

package truongQuocBao_21017351_tuan4_5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI_QLSach extends JFrame{
	private JLabel lbMaSach,lbTuaSach,lbTacGia,lbNamSX,lbNXB,lbSoTrang,lbDonGia,lbISBN,lbTim;
	private JTextField txtMaSach,txtTuaSach,txtTacGia,txtNamSX,txtNXB,txtSoTrang,txtDonGia,txtISBN;
	private JButton btThem,btXoaRong,btSua,btXoa;
	private JTable table;
	private DefaultTableModel model;
	
	public GUI_QLSach() {
		setTitle("Quản lí sách");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		create_GUI();
		setVisible(true);
	}
	
	public void create_GUI() {
		JPanel border = new JPanel();
		border.setLayout(new BorderLayout());
		add(border,BorderLayout.CENTER);
		
		Box b = Box.createVerticalBox();

		//header
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		
		//mã sách
		lbMaSach = new JLabel("Mã sách:");
		lbMaSach.setBounds(3,20,80,30);
		txtMaSach = new JTextField();
		txtMaSach.setBounds(85,25,270,20);
		header.add(lbMaSach);
		header.add(txtMaSach);
		
		// tựa sách
		lbTuaSach = new JLabel("Tựa sách:");
		lbTuaSach.setBounds(3,50,80,30);
		txtTuaSach = new JTextField();
		txtTuaSach.setBounds(85,55,370,20);
		header.add(lbTuaSach);
		header.add(txtTuaSach);
		
		// nam sản xuất
		lbNamSX = new JLabel("Năm xuất bản:");
		lbNamSX.setBounds(3,80,80,30);
		txtNamSX = new JTextField();
		txtNamSX.setBounds(85,85,370,20);
		header.add(lbNamSX);
		header.add(txtNamSX);
		
		//số trang
		lbSoTrang = new JLabel("Số trang:");
		lbSoTrang.setBounds(3,110,80,30);
		txtSoTrang = new JTextField();
		txtSoTrang.setBounds(85,115,370,20);
		header.add(lbSoTrang);
		header.add(txtSoTrang);
		
		//ISBN
		lbISBN = new JLabel("International Standard Book Number (ISBN):");
		lbISBN.setBounds(2,140,300,30);
		txtISBN = new JTextField();
		txtISBN.setBounds(255,145,200,20);
		header.add(lbISBN);
		header.add(txtISBN);
		
		//tác giả
		lbTacGia = new JLabel("Tác Giả:");
		lbTacGia.setBounds(500,50,50,30);
		txtTacGia = new JTextField();
		txtTacGia.setBounds(580,55,300,20);
		header.add(lbTacGia);
		header.add(txtTacGia);
		
		lbNXB = new JLabel("Nhà xuất bản:");
		lbNXB.setBounds(500,80,80,30);
		txtNXB = new JTextField();
		txtNXB.setBounds(580,85,300,20);
		header.add(lbNXB);
		header.add(txtNXB);
		
		lbDonGia = new JLabel("Đơn giá:");
		lbDonGia.setBounds(500,110,80,30);
		txtDonGia = new JTextField();
		txtDonGia.setBounds(580,115,300,20);
		header.add(lbDonGia);
		header.add(txtDonGia);
		
		b.add(header);
			
		
		// center
//		JPanel center = new JPanel();
//		center.setLayout(null);
//		
//		btThem = new JButton("Thêm");
//		btThem.setBounds(150,10,70,25);
//		btXoaRong = new JButton("Xóa rỗng");
//		btXoaRong.setBounds(225,10,90,25);
//		btSua = new JButton("Sửa");
//		btSua.setBounds(320,10,60,25);
//		btXoa = new JButton("Xóa");
//		btXoa.setBounds(385,10,60,25);
//		center.add(btThem);
//		center.add(btXoaRong);
//		center.add(btSua);
//		center.add(btXoa);
//		
//		lbTim = new JLabel("Tìm theo mã sách");
//		lbTim.setBounds(550,15,100,25);
//		center.add(lbTim);
//		
//		JComboBox combobox = new JComboBox();
//		combobox.addItem("A001");
//		combobox.addItem("J002");
//		combobox.addItem("H003");
//		combobox.setBounds(655,15,70,25);
//		center.add(combobox);
//		
//		b.add(center);
		
		
		// table
		JPanel tab = new JPanel();
		tab.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã sách");
		model.addColumn("Tựa sách");
		model.addColumn("Tác giả");
		model.addColumn("Năm xuất bản");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Số trang");
		model.addColumn("Đơn giá");
		model.addColumn("ISBN");
		
		TableColumn tableColumn = new TableColumn();
		tableColumn.setPreferredWidth(100);
		
		DefaultTableCellRenderer table_right = new DefaultTableCellRenderer();
		table_right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		table.getColumnModel().getColumn(3).setCellRenderer(table_right);
		table.getColumnModel().getColumn(5).setCellRenderer(table_right);
		table.getColumnModel().getColumn(6).setCellRenderer(table_right);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(850,20));
		tab.add(scroll);
		
		b.add(tab);
		
		this.add(b);
		
	}
	public static void main(String[] args) {
		new GUI_QLSach();
	}
}

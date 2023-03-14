package truongQuocBao_21017351_tuan4_5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class test extends JFrame implements ActionListener{
	private JLabel lbMaSach,lbTuaSach,lbTacGia,lbNamSX,lbNXB,lbSoTrang,lbDonGia,lbISBN,lbTim;
	private JTextField txtMaSach,txtTuaSach,txtTacGia,txtNamSX,txtNXB,txtSoTrang,txtDonGia,txtISBN;
	private JButton btThem,btXoaRong,btSua,btXoa,btLuu;
	private JTable table;
	private DefaultTableModel model;
	private dsSach ds;
	private Database data;
	
	public test() {
		setTitle("Quản lí sách");
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		ds = new dsSach();
		create_GUI();
		data = new Database();
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	public void create_GUI() {
		JPanel border = new JPanel();
		border.setLayout(new BorderLayout());
		//add(border,BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(40));
		b.add(b2);

		//header
		JPanel header = new JPanel();
		header.setLayout(null);
		b1.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		
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
		lbTacGia.setBounds(550,50,50,30);
		txtTacGia = new JTextField();
		txtTacGia.setBounds(630,55,350,20);
		header.add(lbTacGia);
		header.add(txtTacGia);
		
		lbNXB = new JLabel("Nhà xuất bản:");
		lbNXB.setBounds(550,80,80,30);
		txtNXB = new JTextField();
		txtNXB.setBounds(630,85,350,20);
		header.add(lbNXB);
		header.add(txtNXB);
		
		lbDonGia = new JLabel("Đơn giá:");
		lbDonGia.setBounds(550,110,80,30);
		txtDonGia = new JTextField();
		txtDonGia.setBounds(630,115,350,20);
		header.add(lbDonGia);
		header.add(txtDonGia);
		
		b1.add(header);
		border.add(b,BorderLayout.CENTER);	
		

		// button
		btThem = new JButton("Thêm");
		btThem.setBounds(110,220,70,25);
		btXoaRong = new JButton("Xóa rỗng");
		btXoaRong.setBounds(185,220,90,25);
		btSua = new JButton("Sửa");
		btSua.setBounds(280,220,60,25);
		btXoa = new JButton("Xóa");
		btXoa.setBounds(345,220,60,25);
		btLuu = new JButton("Lưu");
		btLuu.setBounds(410,220,60,25);
		add(btThem);
		add(btXoaRong);
		add(btSua);
		add(btXoa);
		add(btLuu);
		
		lbTim = new JLabel("Tìm theo mã sách");
		lbTim.setBounds(550,220,100,25);
		add(lbTim);
		
		JComboBox combobox = new JComboBox();
		combobox.addItem("A001");
		combobox.addItem("J002");
		combobox.addItem("H003");
		combobox.setBounds(655,220,70,25);
		add(combobox);
		add(b);
		
		
		
		// table
		JPanel tab = new JPanel();
		b2.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		
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
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		
		DefaultTableCellRenderer table_right = new DefaultTableCellRenderer();
		table_right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		table.getColumnModel().getColumn(3).setCellRenderer(table_right);
		table.getColumnModel().getColumn(5).setCellRenderer(table_right);
		table.getColumnModel().getColumn(6).setCellRenderer(table_right);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(850,100));
		b2.add(scroll);
		
		this.add(b);
		
		
		btThem.addActionListener(this);
		btLuu.addActionListener(this);
		btXoa.addActionListener(this);
		btXoaRong.addActionListener(this);
	}
	public static void main(String[] args) {
		new test();
	}
	
	private void loadData() throws Exception{
		ds = (dsSach)data.readFile("Sach.dat");
		if(ds == null)
			ds = new dsSach();
		else {
			for (Sach s : ds.getDsSach()) {
				String[] row = {s.getMaSach(), s.getTuaSach(),
								s.getTacGia(), s.getNamSX()+"",
								s.getnXB(), s.getSoTrang()+"",
								s.getDonGia()+"",s.getiSBN()};
					model.addRow(row);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btThem)) {
			if(btThem.getText().equals("Thêm")) {
				xoaTrang();
				txtMaSach.requestFocus();
				
				btXoa.setEnabled(false);
				btThem.setText("Hủy");
			}else {
				btThem.setText("Thêm");
				btXoa.setEnabled(true);
			}
		}else if(o.equals(btLuu)) {
			if(txtMaSach.getText().equals("") || txtTuaSach.getText().equals("") || txtTacGia.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
			else {
				try {
					luu();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			xoaTrang();
			this.btThem.setText("Thêm");
			this.btXoa.setEnabled(true);
		}else if(o.equals(btXoa)) {
			try {
				xoaDong();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(o.equals(btXoaRong))
			xoaTrang();
			
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaSach.setText(model.getValueAt(row, 0).toString());
				txtTuaSach.setText(model.getValueAt(row, 1).toString());
				txtTacGia.setText(model.getValueAt(row, 2).toString());
				txtNamSX.setText(model.getValueAt(row, 3).toString());
				txtNXB.setText(model.getValueAt(row, 4).toString());
				txtSoTrang.setText(model.getValueAt(row, 5).toString());
				txtDonGia.setText(model.getValueAt(row, 6).toString());
				txtISBN.setText(model.getValueAt(row, 7).toString());
			}
		});
	}
	
	private void xoaDong() throws Exception{
		int r = table.getSelectedRow();
		if(r != -1) {
			int thongBao = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dòng này không?","Delete",JOptionPane.YES_NO_OPTION);
			if(thongBao == JOptionPane.YES_OPTION) {
				ds.xoaViTri(r);
				model.removeRow(r);
				xoaTrang();
				data.saveFile("Sach.dat", ds);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
		}
		
		
	}

	private void luu() throws Exception{
		String msach = txtMaSach.getText();
		String tuasach = txtTuaSach.getText();
		String tacgia = txtTacGia.getText();
		String namxb = txtNamSX.getText();
		String nxb = txtNXB.getText();
		String sotrang = txtSoTrang.getText();
		String dongia = txtDonGia.getText();
		String isbn = txtISBN.getText();
		
		Sach s = new Sach(msach, tuasach, tacgia, Integer.parseInt(namxb), nxb, Integer.parseInt(sotrang), Integer.parseInt(dongia),isbn);
		
		if(ds.add(s)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			String [] row = {msach, tuasach, tacgia,namxb, nxb, sotrang, dongia,isbn};
			model.addRow(row);
			data.saveFile("Sach.dat", ds);
		}else {
			JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại");
			txtMaSach.setText("");
		}
	}

	public void xoaTrang() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamSX.setText("");
		txtNXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
	}
}

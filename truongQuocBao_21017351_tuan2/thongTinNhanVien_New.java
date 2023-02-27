package truongQuocBao_21017351_tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class thongTinNhanVien_New extends JFrame implements ActionListener{
	private JTextField txtMaNV,txtHo,txtTen,txtTuoi,txtLuong,txtMaso;
	private JButton buttonTim,buttonThem,buttonXoa,buttonXoaTrang,buttonLuu;
	private JPanel panelCenter;
	private DefaultTableModel model;
	private JTable table;
	
	public thongTinNhanVien_New() {
		setTitle("^-^");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createGUI();
		setVisible(true);
	}
	
	public void createGUI() {
		JPanel panelBorder = new JPanel();
		panelBorder.setLayout(new BorderLayout());
		//Title
		JPanel panelNorth = new JPanel();
		JLabel title = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font font = new Font("Arial", Font.BOLD, 25);
		title.setFont(font);
		title.setForeground(Color.BLUE);
		panelNorth.add(title);
		panelBorder.add(panelNorth,BorderLayout.NORTH);
		
		
		//center
		panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(20));
		b.add(b2);
		b.add(Box.createVerticalStrut(30));
		b.add(b3);
		b.add(Box.createVerticalStrut(20));
		b.add(b4);
		b.add(Box.createVerticalStrut(20));
		
		panelCenter.add(b);
		panelCenter.add(Box.createVerticalStrut(0));
		
		JLabel lbMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField();
		b1.add(lbMaNV);
		b1.add(txtMaNV);
		
		JLabel lbHo = new JLabel("Họ: ");
		txtHo = new JTextField();
		b2.add(lbHo);
		b2.add(txtHo);
		lbHo.setPreferredSize(lbMaNV.getPreferredSize());
		
		JLabel lbTen = new JLabel("Tên nhân viên: ");
		txtTen = new JTextField();
		b2.add(lbTen);
		b2.add(txtTen);
		
		JLabel lbTuoi = new JLabel("Tuổi: ");
		txtTuoi = new JTextField();
		b3.add(lbTuoi);
		b3.add(txtTuoi);
		
		JLabel lbPhai = new JLabel("Phái: ");
		JRadioButton nam = new JRadioButton("Nam",true);
		JRadioButton nu = new JRadioButton("Nữ");
		nam.setEnabled(true);
		ButtonGroup group = new ButtonGroup();
		group.add(nam);group.add(nu);
		b3.add(lbPhai);
		b3.add(nam);
		b3.add(nu);
		
		JLabel lbLuong = new JLabel("Tiền lương: ");
		txtLuong = new JTextField();
		b4.add(lbLuong);
		b4.add(txtLuong);
		
		lbTuoi.setPreferredSize(lbMaNV.getPreferredSize());
		lbPhai.setPreferredSize(lbMaNV.getPreferredSize());
		lbLuong.setPreferredSize(lbMaNV.getPreferredSize());
		
		createTable();
		panelBorder.add(panelCenter,BorderLayout.CENTER);
		
		//chuc nang
		JSplitPane split;
		panelBorder.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),BorderLayout.SOUTH);
		split.setResizeWeight(0.5);
		
		JPanel panelTimKiem = new JPanel();
		JLabel lbTimKiem = new JLabel("Nhap ma so can tim: ");
		txtMaso = new JTextField(10);
		buttonTim = new JButton("Tim");
		panelTimKiem.add(lbTimKiem);
		panelTimKiem.add(buttonTim);
		panelTimKiem.add(txtMaso);
		split.add(panelTimKiem);
		
		
		JPanel panelChucNang = new JPanel();
		buttonThem = new JButton("Them");
		buttonXoa = new JButton("Xoa");
		buttonXoaTrang = new JButton("Xoa trang");
		buttonLuu = new JButton("Luu");
		panelChucNang.add(buttonThem);
		panelChucNang.add(buttonXoaTrang);
		panelChucNang.add(buttonXoa);
		panelChucNang.add(buttonLuu);
		split.add(panelChucNang);
		
		Border cnBorder = BorderFactory.createLineBorder(Color.GRAY);
		panelChucNang.setBorder(cnBorder);
		panelTimKiem.setBorder(cnBorder);
		
		this.add(panelBorder);
	}
	private void createTable() {
		JPanel panelTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		
		TableColumn phaiColumn = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn colum = new TableColumn();
		colum.setPreferredWidth(100);
		
		//can chinh chu
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(right);
		table.getColumnModel().getColumn(4).setCellRenderer(right);
		table.getColumnModel().getColumn(5).setCellRenderer(right);
		
		JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(650,250));
		panelCenter.add(sp);
	
	}

	public static void main(String[] args) {
		new thongTinNhanVien_New();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		if(o.equals(buttonXoa))
//			System.exit(0);
//		else if(o.equals(buttonXoaTrang)) {
//			txtMaNV.setText("");
//			txtHo.setText("");
//			txtTen.setText("");
//			txtTuoi.setText("");
//			txtLuong.setText("");
//			txtMaso.setText("");
//			txtMaNV.requestFocus();
//		}
//		
	}
	
}

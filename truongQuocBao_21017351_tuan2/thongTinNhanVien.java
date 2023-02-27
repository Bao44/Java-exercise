package truongQuocBao_21017351_tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class thongTinNhanVien extends JFrame implements ActionListener{
	private JTextField txtMaNV,txtHo,txtTen,txtTuoi,txtLuong,txtMaso;
	private JButton buttonTim,buttonThem,buttonXoa,buttonXoaTrang,buttonLuu;
	
	public thongTinNhanVien() {
		setTitle("^-^");
		setSize(900,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createGUI();
		setVisible(true);
	}
	
	public void createGUI() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(null);
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.setBorder(BorderFactory.createTitledBorder(" "));
		panelCenter.setPreferredSize(new Dimension(100, 100));
		
		Font font = new Font("Arial",Font.BOLD,25);
		JLabel title = new JLabel("THÔNG TIN NHÂN VIÊN");
		panelCenter.add(title);
		title.setBounds(300, -30, 1000, 100);
		title.setFont(font);
		title.setForeground(Color.BLUE);
			
		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		panelCenter.add(lblMaNV);
		lblMaNV.setBounds(0, 50, 100, 20);
		panelCenter.add(txtMaNV = new JTextField(10));
		txtMaNV.setBounds(85, 50, 795, 25);
		
		JLabel lblHo = new JLabel("Họ: ");
		panelCenter.add(lblHo);
		lblHo.setBounds(0, 95, 100, 20);
		panelCenter.add(txtHo = new JTextField(10));
		txtHo.setBounds(85, 93, 350, 25);

		JLabel lblTen = new JLabel("Tên nhân viên: ");
		panelCenter.add(lblTen);
		lblTen.setBounds(440, 95, 100, 20);
		panelCenter.add(txtTen = new JTextField(10));
		txtTen.setBounds(527, 93, 355, 25);
		
		JLabel lblTuoi = new JLabel("Tuổi: ");
		panelCenter.add(lblTuoi);
		lblTuoi.setBounds(0, 143, 100, 20);
		panelCenter.add(txtTuoi = new JTextField(10));
		txtTuoi.setBounds(85, 140, 600, 25);
		
		JLabel lblPhai = new JLabel("Phái: ");
		panelCenter.add(lblPhai);
		lblPhai.setBounds(690, 143, 100, 20);
		JRadioButton phai = new JRadioButton("Nữ");
		panelCenter.add(phai);
		phai.setBounds(820, 143, 50, 20);
		
		JLabel lblLuong = new JLabel("Tiền lương: ");
		panelCenter.add(lblLuong);
		lblLuong.setBounds(0, 188, 100, 20);
		panelCenter.add(txtLuong = new JTextField(10));
		txtLuong.setBounds(85, 185, 795, 25);
		
		
//		String[][] data = {
//                { "Kundan Kumar Jha", "4031", "CSE" },
//                { "Anand Jha", "6014", "IT" }
//        };
//		String[] columnNames = {"Name", "Roll Number", "Department"};
//		JTable jTable = new JTable(data, columnNames);
//		panelCenter.add(jTable);
//		jTable.setBounds(5, 300, 875, 100);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder(""));
		panelSouth.setLayout(null);
		panelSouth.setPreferredSize(new Dimension(50, 50));
		
		
		JLabel lblMaSo = new JLabel("Nhập mã số cần tìm: ");
		panelSouth.add(lblMaSo);
		lblMaSo.setBounds(5, 16, 200, 20);
		panelSouth.add(txtMaso = new JTextField(10));
		txtMaso.setBounds(125, 15, 150, 25);
		panelSouth.add(buttonTim = new JButton("Tìm"));
		buttonTim.setBounds(280, 15, 70, 25);
		
		panelSouth.add(buttonThem = new JButton("Thêm"));
		buttonThem.setBounds(480, 15, 70, 25);
		panelSouth.add(buttonXoaTrang = new JButton("Xóa trắng"));
		buttonXoaTrang.setBounds(555, 15, 90, 25);
		panelSouth.add(buttonXoa = new JButton("Xóa"));
		buttonXoa.setBounds(650, 15, 70, 25);
		panelSouth.add(buttonLuu = new JButton("Lưu"));
		buttonLuu.setBounds(725, 15, 70, 25);
		
		buttonXoa.addActionListener(this);
		buttonXoaTrang.addActionListener(this);
	}
	public static void main(String[] args) {
		new thongTinNhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonXoa))
			System.exit(0);
		else if(o.equals(buttonXoaTrang)) {
			txtMaNV.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
			txtMaso.setText("");
			txtMaNV.requestFocus();
		}
		
	}
	
}

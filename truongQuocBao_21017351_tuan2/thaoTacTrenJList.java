package truongQuocBao_21017351_tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class thaoTacTrenJList extends JFrame{
	private JTextField txt;
	private JButton btNhap,btToDenChan,btToDenLe,btToDenSoNguyen,btBoToDen,btXoa,btTong,btDong;
	public thaoTacTrenJList() {
		setTitle("Thao tác trên JList");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		createGUI();
		setVisible(true);
	}
	private void createGUI() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(null);
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		Font font = new Font("Arial",Font.BOLD,25);
		JLabel title = new JLabel("Thao tác trên JList-Checkbox");
		title.setFont(font);
		panelCenter.add(title);
		title.setBounds(130, -30, 1000, 100);
		title.setForeground(Color.BLUE);
		
		
		
	}
	public static void main(String[] args) {
		new thaoTacTrenJList();
	}
}

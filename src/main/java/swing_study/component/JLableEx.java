package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class JLableEx extends JFrame {

	private JPanel contentPane;
	private String path = System.getProperty("user.dir") + File.separator + "images" + File.separator;

	public JLableEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lb1 = new JLabel("");
		lb1.setIcon(new ImageIcon(path+"un2.jpg"));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lb1, BorderLayout.NORTH);
		
		JLabel lb2 = new JLabel("보고싶으면 전화하세요.");
		lb2.setIcon(new ImageIcon(path+"un1.jpg"));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lb2, BorderLayout.CENTER);
		
		JLabel lb3 = new JLabel("사랑합니다.");
		lb3.setIcon(new ImageIcon(path+"un3.jpg"));
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lb3, BorderLayout.SOUTH);
	}

}

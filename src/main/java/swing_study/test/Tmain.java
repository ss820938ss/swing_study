package swing_study.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.AbstractListModel;

public class Tmain extends JFrame {

	private JPanel contentPane;
	private JTextField m01_Search_TF01;
	private JTextField m01_Search_TF02;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tmain frame = new Tmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tmain() {
		initialize();
	}
	private void initialize() {
		setTitle("도서관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 437);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel main_01 = new JPanel();
		main_01.setBackground(Color.WHITE);
		contentPane.add(main_01, BorderLayout.NORTH);
		main_01.setLayout(new BorderLayout(0, 0));
		
		JPanel p_m01_btn = new JPanel();
		p_m01_btn.setBackground(Color.WHITE);
		FlowLayout fl_p_m01_btn = (FlowLayout) p_m01_btn.getLayout();
		fl_p_m01_btn.setHgap(10);
		fl_p_m01_btn.setAlignment(FlowLayout.LEFT);
		main_01.add(p_m01_btn, BorderLayout.NORTH);
		
		JButton btn_m_rental = new JButton("대출하기");
		btn_m_rental.setForeground(SystemColor.windowBorder);
		p_m01_btn.add(btn_m_rental);
		
		JButton btn_m_return = new JButton("반납하기");
		btn_m_return.setForeground(SystemColor.windowBorder);
		p_m01_btn.add(btn_m_return);
		
		JPanel p_m01_scmb = new JPanel();
		p_m01_scmb.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) p_m01_scmb.getLayout();
		flowLayout.setHgap(10);
		main_01.add(p_m01_scmb, BorderLayout.SOUTH);
		
		JLabel m01_Search_L01 = new JLabel("빠른회원검색 :");
		m01_Search_L01.setHorizontalAlignment(SwingConstants.LEFT);
		p_m01_scmb.add(m01_Search_L01);
		
		JComboBox m01_Search_COM01 = new JComboBox();
		p_m01_scmb.add(m01_Search_COM01);
		
		m01_Search_TF01 = new JTextField();
		p_m01_scmb.add(m01_Search_TF01);
		m01_Search_TF01.setColumns(10);
		
		JLabel m01_Search_L02 = new JLabel("빠른도서검색 :");
		p_m01_scmb.add(m01_Search_L02);
		
		JComboBox m01_Search_COM02 = new JComboBox();
		p_m01_scmb.add(m01_Search_COM02);
		
		m01_Search_TF02 = new JTextField();
		p_m01_scmb.add(m01_Search_TF02);
		m01_Search_TF02.setColumns(10);
		
		JPanel main_02 = new JPanel();
		main_02.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(main_02, BorderLayout.SOUTH);
		main_02.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		main_02.add(lblNewLabel_2);
		
		JList list_2 = new JList();
		list_2.setLayoutOrientation(JList.VERTICAL_WRAP);
		main_02.add(list_2);
		
		JPanel main_03 = new JPanel();
		main_03.setBackground(Color.WHITE);
		contentPane.add(main_03, BorderLayout.CENTER);
		main_03.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		main_03.add(panel_2);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"12001 홍길동 "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		String[] columnNames = {"회원번호", "이름", "전화번호", "휴대전화"};
		panel_2.add(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		main_03.add(panel_3);
		
		JList list_1 = new JList();
		panel_3.add(list_1);
	}

}

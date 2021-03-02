package swing_study.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameLayout extends JFrame {

	private JPanel contentPane;
	private LayoutGuBun gubun;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLayout frame = new FrameLayout(LayoutGuBun.FLOW);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameLayout(LayoutGuBun gubun) {
		this.gubun = gubun;
		initialize();
	}
	private void initialize() {
		setTitle("레이아웃 종류");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pSwitch = null;
		switch(gubun) {
		case FLOW:
			pSwitch = new PanelFlow();
			break;
		}
		
		contentPane.add(pSwitch, BorderLayout.CENTER);
	}

}

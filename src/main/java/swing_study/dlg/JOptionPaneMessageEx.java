package swing_study.dlg;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JOptionPaneMessageEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn;

	public JOptionPaneMessageEx() {
		initialize();
	}
	private void initialize() {
		setTitle("message Dialog 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 101);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRes = new JLabel("New label");
		contentPane.add(lblRes, BorderLayout.CENTER);
		
		btn = new JButton("클릭");
		btn.addActionListener(this);
		contentPane.add(btn, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			actionPerformedBtn(e);
		}
	}
	protected void actionPerformedBtn(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "icon3.png");
		
		JOptionPane.showMessageDialog(
				null, 
				"조심하세요", 
				"조심", 
				JOptionPane.WARNING_MESSAGE, 
				icon);
	}
}
package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JBoxradiobutton extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox apple;

	public JBoxradiobutton() {
		initialize();
	}
	private void initialize() {
		setTitle("체크박스예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		apple = new JCheckBox("New check box");
		apple.addItemListener(this);
		panel.add(apple);
		
		JCheckBox pear = new JCheckBox("New check box");
		panel.add(pear);
		
		JCheckBox cherry = new JCheckBox("New check box");
		panel.add(cherry);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == apple) {
			itemStateChangedApple(e);
		}
	}
	protected void itemStateChangedApple(ItemEvent e) {
	}
}

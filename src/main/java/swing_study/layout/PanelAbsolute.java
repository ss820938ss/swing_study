package swing_study.layout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelAbsolute extends JPanel {
	private JTextField textField;

	public PanelAbsolute() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(340, 39, 57, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 252, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(184, 132, 97, 23);
		add(btnNewButton);
	}
}

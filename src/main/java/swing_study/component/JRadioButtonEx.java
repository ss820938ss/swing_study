package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JRadioButtonEx extends JFrame implements ItemListener{
	private JPanel contentPane;
	private String imgPath= System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "apple.jpg"),
			new ImageIcon(imgPath + "pear.jpg"),
			new ImageIcon(imgPath + "cherry.jpg")
	};
	private JLabel lblImg;
	
	public JRadioButtonEx() {
		initialize();
	}
	
	private void initialize() {
		setTitle("라디오 버튼 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "간단한 라디오버튼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton pRadio = new CustomRadioButton();
		pLeft.add(pRadio);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "응용 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton panel = new CustomRadioButton();
		pRight.add(panel, BorderLayout.NORTH);
		
		lblImg = new JLabel();
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblImg, BorderLayout.CENTER);
		
		for(JRadioButton r : panel.getRdBtns()) {
			r.addItemListener(this);
		}
		
		panel.getRdbtnApple().setSelected(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton rd = (JRadioButton) e.getSource();
		
		if (e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rd.getText());
			String text = rd.getText();
			switch(text) {
			case "사과":
				lblImg.setIcon(icons[0]);
				break;
			case "배":
				lblImg.setIcon(icons[1]);
				break;
			default:
				lblImg.setIcon(icons[2]);
			}
		}
	}

}

package swing_study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JListEx extends JFrame implements ActionListener {
	private JPanel contentPane;
	private String imgPath= System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "icon1.png"),
			new ImageIcon(imgPath + "icon2.png"),
			new ImageIcon(imgPath + "icon3.png"),
			new ImageIcon(imgPath + "icon4.png")
	};
	private String[] fruits = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	private JButton btn01;
	private JList<String> strList;
	
	
	public JListEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JList 예제1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		strList = new JList<>();
		strList.setListData(fruits);
		contentPane.add(strList);
		
		JList<ImageIcon> list = new JList<>();
		list.setListData(icons);
		contentPane.add(list);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btn01 = new JButton("첫리스트선택확인");
		btn01.addActionListener(this);
		pBtns.add(btn01);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	
	protected void actionPerformedBtn01(ActionEvent e) {
		int idx = strList.getSelectedIndex();
		String selStr = strList.getSelectedValue();
		List<String> selededList = strList.getSelectedValuesList();
		
		String message = 
				String.format("index : %d%n selectedValue : %s%n selectedList : %s", 
				idx, selStr, selededList);
		
		JOptionPane.showMessageDialog(null, message);
	}
}

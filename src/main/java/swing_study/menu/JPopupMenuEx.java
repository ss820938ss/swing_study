package swing_study.menu;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JPopupMenuEx extends JFrame {

	private JPanel contentPane;
	private JLabel imgLabel = new JLabel();
	
	public JPopupMenuEx() {
		initialize();
	}
	
	private void initialize() {
		setTitle("팝업메뉴");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.setComponentPopupMenu(createPopupMenu());
		
		contentPane.add(imgLabel, BorderLayout.CENTER);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(listener);
		popupMenu.add(mntmLoad);
		
		JMenuItem mntmHide = new JMenuItem("Hide");
		mntmHide.addActionListener(listener);
		popupMenu.add(mntmHide);
		
		JMenuItem mntmReShow = new JMenuItem("ReShow");
		mntmReShow.addActionListener(listener);
		popupMenu.add(mntmReShow);
		
		JSeparator separator = new JSeparator();
		popupMenu.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(listener);
		popupMenu.add(mntmExit);
		
		return popupMenu;
	}

	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Load")) {
				String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
				ImageIcon icon = new ImageIcon(imgPath + "flower.jpg");
				
				Image changeImg = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
				imgLabel.setIcon(new ImageIcon(changeImg));
			}
			
			if (e.getActionCommand().equals("Hide")) {
				imgLabel.setVisible(false);
			}
			
			if (e.getActionCommand().equals("ReShow")) {
				imgLabel.setVisible(true);
			}
			
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
		}
	};
	
}
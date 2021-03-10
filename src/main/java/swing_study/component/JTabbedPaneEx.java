package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import swing_study.panel.EmployeePanel;
import swing_study.panel.Title;
import swing_study.panel.TitlePanel;

@SuppressWarnings("serial")
public class JTabbedPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnConfirm;
	private JTabbedPane tabbedPane;

	public JTabbedPaneEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JTabbedPane 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		DeptPanel pDept = new DeptPanel();
		tabbedPane.addTab("부서", null, pDept, "부서관리");

		TitlePanel pTitle = new TitlePanel();
		tabbedPane.addTab("직책", null, pTitle, "직책관리");

		EmployeePanel pEmp = new EmployeePanel();
		tabbedPane.addTab("사원", null, pEmp, "사원관리");

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);

		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtn.add(btnConfirm);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
	}

	protected void actionPerformedBtnConfirm(ActionEvent e) {
		// 선택된 탭가져와서
		Component comp = tabbedPane.getSelectedComponent();

//		System.out.println(comp);
		Object obj = null;
		// getXX()
		if (comp instanceof DeptPanel) {
			DeptPanel deptPanel = (DeptPanel) comp;
			obj = deptPanel.getDepartment();
		}
		if (comp instanceof TitlePanel) {
			TitlePanel titlePanel = (TitlePanel) comp;
			obj = titlePanel.getTitle();
		}
		JOptionPane.showMessageDialog(null, obj);
	}
}

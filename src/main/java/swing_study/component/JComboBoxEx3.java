package swing_study.component;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import swing_study.panel.DeptPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JComboBoxEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private List<Department> deptList;
	private JComboBox<Department> cmbDept;
	private JButton btnOk;
	private JButton btnAdd;
	private DeptPanel pDept;

	public JComboBoxEx3() {
		deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "기획", 8));
		deptList.add(new Department(2, "영업", 18));
		deptList.add(new Department(3, "개발", 28));
		
		initialize();
		
		cmbDept.setModel(new DefaultComboBoxModel<Department>(new Vector<>(deptList)));
		cmbDept.setSelectedIndex(-1);
	}
	
	private void initialize() {
		setTitle("JComboBox 실전 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pDept = new DeptPanel();
		pLeft.add(pDept, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pLeft.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pCmb = new JPanel();
		pRight.add(pCmb);
		
		cmbDept = new JComboBox<>();
		pCmb.add(cmbDept);
		
		JPanel pBtns = new JPanel();
		pRight.add(pBtns);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pBtns.add(btnOk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		Department selDept = (Department) cmbDept.getSelectedItem();
		String message = String.format("%s %s %s%n", selDept.getDeptNo(), selDept.getDeptName(), selDept.getFloor());
		JOptionPane.showMessageDialog(null, message);
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department addDept = pDept.getDepartment();
		
		if (deptList.contains(addDept)) {
			JOptionPane.showMessageDialog(null, "중복 아이템");
			return;
		}
		
		DefaultComboBoxModel<Department> model = (DefaultComboBoxModel<Department>) cmbDept.getModel();
		model.addElement(addDept);
		
		pDept.clearTf();
		JOptionPane.showMessageDialog(null, "추가 되었습니다.");
	}
}

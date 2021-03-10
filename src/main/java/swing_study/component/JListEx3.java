package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

@SuppressWarnings("serial")
public class JListEx3 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnAdd;
	private DeptPanel pLeftCenter;
	private JList<Department> deptList;
	private DefaultListModel<Department> model;
	private JPanel pBtns;
	private JButton btnConfirm;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	public JListEx3() {
		initialize();
		
		model.addElement(new Department(1, "기획", 8));
		model.addElement(new Department(2, "영업", 18));
		model.addElement(new Department(3, "개발", 28));
	}
	private void initialize() {
		setTitle("JList응용");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pLeftCenter = new DeptPanel();
		pLeft.add(pLeftCenter, BorderLayout.CENTER);
		
		JPanel pLeftSouth = new JPanel();
		pLeft.add(pLeftSouth, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pLeftSouth.add(btnAdd);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uBD80\uC11C \uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		
		deptList = new JList<>();
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultListModel<Department>();
		pRight.setLayout(new BorderLayout(0, 0));
		deptList.setModel(model);
		pRight.add(deptList);
		
		pBtns = new JPanel();
		pRight.add(pBtns, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtns.add(btnConfirm);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pBtns.add(btnDelete);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnAdd) {
			if (btnAdd.getText().equals("추가"))
				actionPerformedBtnAdd(e);
			else
				actionPerformedUpdate(e);
		}
	}
	
	private void actionPerformedUpdate(ActionEvent e) {
		Department updateDept = pLeftCenter.getDepartment();
		int idx = deptList.getSelectedIndex();
//		model.remove(idx);
//		model.add(idx, updateDept);
		model.set(idx, updateDept);
		pLeftCenter.clearTf();
		if (btnAdd.getText().equals("수정")) {
			btnAdd.setText("추가");
		}
		JOptionPane.showMessageDialog(null, "수정 되었습니다.");
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department dept = pLeftCenter.getDepartment();
		pLeftCenter.clearTf();
		
		model.addElement(dept);
		JOptionPane.showMessageDialog(null, "추가 되었습니다.");
	}
	
	protected void actionPerformedBtnConfirm(ActionEvent e) {
//		int idx = deptList.getSelectedIndex();//선택된 인덱스
//		Department selDept = model.get(idx);
//		String message1 = String.format("%d %s %d", selDept.getDeptNo(), selDept.getDeptName(), selDept.getFloor());
		
		Department dept = deptList.getSelectedValue();
		String message = String.format("%d %s %d", dept.getDeptNo(), dept.getDeptName(), dept.getFloor());
		JOptionPane.showMessageDialog(null, message/* + "\n" + message1 */);
	}
	
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Department dept = deptList.getSelectedValue();
		pLeftCenter.setDepartment(dept);
		
		if (btnAdd.getText().equals("추가")) {
			btnAdd.setText("수정");
		}
	}
	
	protected void actionPerformedBtnDelete(ActionEvent e) {
		Department dept = deptList.getSelectedValue();
		model.removeElement(dept);
		JOptionPane.showMessageDialog(null, "삭제 되었습니다");
	}
}

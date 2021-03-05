package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class JListEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnadd;
	private DeptPanel pCenter;
	private JList<Department> list;
	private DefaultListModel<Department> model;
	private JPanel pbtns;
	private JButton btnConfirn;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	
	public JListEx3() {
		initialize();
		
		model.addElement(new Department(1,"기획",8));
		model.addElement(new Department(2,"영업",18));
		model.addElement(new Department(3,"개발",28));
	}
	private void initialize() {
		setTitle("List응용");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pSouth = new JPanel();
		pLeft.add(pSouth, BorderLayout.SOUTH);
		
		btnadd = new JButton("추가");
		btnadd.addActionListener(this);
		pSouth.add(btnadd);
		
		pCenter = new DeptPanel();
		pLeft.add(pCenter, BorderLayout.CENTER);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBD80\uC11C\uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		
		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultListModel<Department>();
		pRight.setLayout(new BorderLayout(0, 0));
		list.setModel(model);
		pRight.add(list);
		
		pbtns = new JPanel();
		pRight.add(pbtns, BorderLayout.SOUTH);
		
		btnConfirn = new JButton("확인");
		btnConfirn.addActionListener(this);
		pbtns.add(btnConfirn);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pbtns.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pbtns.add(btnDelete);
	}

	private ListModel<Department> getDeptModel() {
		DefaultListModel<Department> model = new DefaultListModel<Department>();
		
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnConfirn) {
			actionPerformedBtnConfirn(e);
		}
		if (e.getSource() == btnadd) {
			if (btnadd.getText().equals("추가"))
				actionPerformedBtnadd(e);
			else
				actionPerformedUpdate(e);
		}
	}
	private void actionPerformedUpdate(ActionEvent e) {
		Department updateDept = pCenter.getDepartment();
		int idx = list.getSelectedIndex();
		model.set(idx, updateDept);
		pCenter.clearTf();
		if (btnadd.getText().equals("수정")) {
			btnadd.setText("추가");
		}
		JOptionPane.showMessageDialog(null, "수정 되었습니다.");
		
	}
	protected void actionPerformedBtnadd(ActionEvent e) {
		Department dept = pCenter.getDepartment();
		pCenter.clearTf();
		model.addElement(dept);
		JOptionPane.showMessageDialog(null, "추가완료");
	}
	protected void actionPerformedBtnConfirn(ActionEvent e) {
		int idx = list.getSelectedIndex();
		Department selDept = model.get(idx);
		String message1 = String.format("%s(%d) %d층", selDept.getDeptName(),selDept.getDeptNo(), selDept.getFloor());
		
		Department dept = list.getSelectedValue();
		String message = String.format("%s(%d) %d층", dept.getDeptName(),dept.getDeptNo(), dept.getFloor());
		JOptionPane.showMessageDialog(null, message /*+ "\n" + message1*/);
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Department idx = list.getSelectedValue();
		pCenter.setDepartment(idx);
		
		if(btnadd.getText().equals("추가")) {
			btnadd.setText("수정");
		}
		
		
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
//		Department dept = list.getSelectedValue();
//		model.removeElement(dept);
		int idx = list.getSelectedIndex();
		model.remove(idx);
		JOptionPane.showMessageDialog(null, "삭제완료");
	}
}

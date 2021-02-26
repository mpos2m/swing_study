package swing_study.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

public class JPanelEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSetDept;
	private JButton btnGetDept;
	private DeptPanel pDept;
	private JButton btnClear;
	
	
	
	public JPanelEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 450, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pDept = new DeptPanel();
		contentPane.add(pDept, BorderLayout.CENTER);
		
		JPanel pbtn = new JPanel();
		contentPane.add(pbtn, BorderLayout.SOUTH);
		
		btnSetDept = new JButton("부서 설정");
		btnSetDept.addActionListener(this);
		pbtn.add(btnSetDept);
		
		btnGetDept = new JButton("부서 가져오기");
		btnGetDept.addActionListener(this);
		pbtn.add(btnGetDept);
		
		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);
		pbtn.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnGetDept) {
			actionPerformedBtnGetDept(e);
		}
		if (e.getSource() == btnSetDept) {
			actionPerformedBtnSetDept(e);
		}
	}
	protected void actionPerformedBtnSetDept(ActionEvent e) {
		Department dept = new Department(2, "기획", 6);
		pDept.setDepartment(dept);
	}
	protected void actionPerformedBtnGetDept(ActionEvent e) {
		Department dept = pDept.getDepartment();
		JOptionPane.showMessageDialog(null, dept);
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		pDept.clearTf();
	}
}

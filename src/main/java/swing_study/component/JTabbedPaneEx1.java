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
import swing_study.panel.Title;
import swing_study.panel.TitlePanel;
import swing_study.panel.EmployeePanel;

public class JTabbedPaneEx1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTabbedPane tabbedPane;
	private DeptPanel pDept;
	private TitlePanel pTitle;

	public JTabbedPaneEx1() {
		initialize();
	}
	private void initialize() {
		setTitle("JTabbedPane 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pDept = new DeptPanel();
		tabbedPane.addTab("부서", null, pDept, "부서관리");
		
		pTitle = new TitlePanel();
		tabbedPane.addTab("직책", null, pTitle, "직책관리");
		
		EmployeePanel pEmp = new EmployeePanel();
		tabbedPane.addTab("사원", null, pEmp, "사원관리");
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(this);
		pBtn.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		//선택된 탭 가져와서 getxx()
		
		Component comp = tabbedPane.getSelectedComponent();
			DeptPanel deptPanel = (DeptPanel) comp;
			Department department = deptPanel.getDepartment();
			JOptionPane.showMessageDialog(null, department);
			pDept.clearTf();
		
	}
}

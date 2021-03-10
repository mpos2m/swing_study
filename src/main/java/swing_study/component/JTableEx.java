package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import swing_study.component.table.DeptTablePanel;
import swing_study.component.table.EmpTablePanel;
import swing_study.component.table.MyTablePanel;
import swing_study.component.table.Student;
import swing_study.component.table.TitleTablePanel;
import swing_study.panel.Department;
import swing_study.panel.Employee;
import swing_study.panel.Title;

public class JTableEx extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private List<Student> stdList = new ArrayList<>();
	private List<Department> deptList = new ArrayList<>();
	private List<Title> titleList = new ArrayList<>();
	private List<Employee> empList = new ArrayList<>();
	private List<Employee> empList2 = new ArrayList<>();
	
	public JTableEx() {
		stdList.add(new Student(1, "김인환", 50, 60, 60));
		stdList.add(new Student(2, "이태훈", 70, 71, 70));
		stdList.add(new Student(3, "김상건", 90, 92, 100));
		stdList.add(new Student(4, "전수린", 60, 63, 67));
		
		deptList.add(new Department(1,"개발",8));
		deptList.add(new Department(2,"인사",18));
		deptList.add(new Department(3,"총무",28));
		
		titleList.add(new Title(1,"사장"));
		titleList.add(new Title(2,"부장"));
		titleList.add(new Title(3,"과장"));
		titleList.add(new Title(4,"대리"));
		
		empList.add(new Employee(1, "김상건",titleList.get(0), null, 1500000,deptList.get(0)));
		empList.add(new Employee(2, "이성래",titleList.get(1), new Employee(1,"김상건"),1500000,new Department(2,"총무",8)));
		empList.add(new Employee(3, "이태훈",titleList.get(2), new Employee(1,"김상건"),1500000,new Department(2,"총무",8)));
		
		
		initialize();
	}

	private void initialize() {
		setTitle("JTable예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pTable1 = new JPanel();
		contentPane.add(pTable1);
		pTable1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane1 = new JScrollPane();
		pTable1.add(scrollPane1, BorderLayout.CENTER);

		table1 = new JTable();
		table1.setModel(getModel());

		scrollPane1.setViewportView(table1);

		JPanel pTable2 = new JPanel();
		pTable2.setBorder(new TitledBorder(null, "CustomTable", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTable2);
		pTable2.setLayout(new BorderLayout(0, 0));

		MyTablePanel pCustomTable2 = new MyTablePanel();
		pCustomTable2.setList(stdList);
		pTable2.add(pCustomTable2, BorderLayout.CENTER);

		JPanel pTable3 = new JPanel();
		contentPane.add(pTable3);
		pTable3.setLayout(new BorderLayout(0, 0));
		
		DeptTablePanel pDeptTable3 = new DeptTablePanel();
		// deptlist 추가
		pDeptTable3.setList(deptList);
		pTable3.add(pDeptTable3, BorderLayout.NORTH);

		JPanel pTable4 = new JPanel();
		contentPane.add(pTable4);
		pTable4.setLayout(new BorderLayout(0, 0));
		
		TitleTablePanel pTitleTable4 = new TitleTablePanel();
		pTitleTable4.setList(titleList);
		pTable4.add(pTitleTable4, BorderLayout.CENTER);
		
		JPanel pTable5 = new JPanel();
		
		contentPane.add(pTable5);
		pTable5.setLayout(new BorderLayout(0, 0));
		
		EmpTablePanel pEmpTable5 = new EmpTablePanel();
		pEmpTable5.setList(empList);
		pTable5.add(pEmpTable5, BorderLayout.CENTER);
		
		JPanel pTable6 = new JPanel();
		contentPane.add(pTable6);
		pTable6.setLayout(new BorderLayout(0, 0));
		
		JPanel pEmpTable6 = new JPanel();
		
		pTable6.add(pEmpTable6, BorderLayout.CENTER);
	}

	private DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	class CustomTableModel extends DefaultTableModel {

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {

			return false;
		}

	}

	private Object[][] getData() {
		return new Object[][] { { 1, "박유진", 10, "여자" }, { 2, "이태훈", 11, "남자" }, };
	}

	private String[] getColumnNames() {
		return new String[] { "학생번호", "학생명", "나이", "성별" };
	}

}

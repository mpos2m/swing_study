package swing_study.layout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class PanelGrid extends JPanel {
	private JTextField txtName;
	private JTextField txtNo;
	private JTextField txtClass;
	private JTextField txtSubject;

	public PanelGrid() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("이름");
		add(lblName);
		
		txtName = new JTextField();
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNo = new JLabel("학번");
		add(lblNo);
		
		txtNo = new JTextField();
		add(txtNo);
		txtNo.setColumns(10);
		
		JLabel lblClass = new JLabel("학과");
		add(lblClass);
		
		txtClass = new JTextField();
		add(txtClass);
		txtClass.setColumns(10);
		
		JLabel lblSubject = new JLabel("과목");
		add(lblSubject);
		
		txtSubject = new JTextField();
		add(txtSubject);
		txtSubject.setColumns(10);
	}

}

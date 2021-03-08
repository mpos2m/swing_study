package swing_study.component;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComboBoxEx1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> combocmd1;
	private JComboBox<String> combocmd2;
	private JComboBox<String> combocmd3;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	public JComboBoxEx1() {
		initialize();

		addDatacombocmd1();
		addDatacombocmd2();
		addDatacombocmd3();

	}

	private void addDatacombocmd1() {
		String [] fruits = {"apple", "banana", "kiwi"};
		
		for(String f : fruits) {
			combocmd1.addItem(f);
		}
		
	}
		
	private void addDatacombocmd2() {
		String [] fruits = {"apple", "banana", "kiwi"};
		
		DefaultComboBoxModel<String> cbm = (DefaultComboBoxModel) combocmd2.getModel();
		
		for(String f : fruits) {
			cbm.addElement(f);
		}
	}

	private void addDatacombocmd3() {
		List<String> fruits = Arrays.asList("apple", "banana", "kiwi");
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new Vector<>(fruits));
		combocmd3.setModel(model);

	}

	

	private void initialize() {
		setTitle("JComboBox기본예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));

		JPanel pcmd1 = new JPanel();
		pcmd1.setBorder(new TitledBorder(null, "\uAE30\uBCF8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pcmd1);

		combocmd1 = new JComboBox<>();
		pcmd1.add(combocmd1);
		
		tf1 = new JTextField();
		tf1.addActionListener(this);
		pcmd1.add(tf1);
		tf1.setColumns(10);

		JPanel pcmd2 = new JPanel();
		contentPane.add(pcmd2);

		combocmd2 = new JComboBox<>();
		pcmd2.add(combocmd2);
		
		tf2 = new JTextField();
		tf2.addActionListener(this);
		pcmd2.add(tf2);
		tf2.setColumns(10);

		JPanel pcmd3 = new JPanel();
		contentPane.add(pcmd3);

		combocmd3 = new JComboBox<>();
		pcmd3.add(combocmd3);
		
		tf3 = new JTextField();
		tf3.addActionListener(this);
		pcmd3.add(tf3);
		tf3.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf1) {
			actionPerformedTf1(e);
		}
		if (e.getSource() == tf2) {
			actionPerformedTf2(e);
		}
		if (e.getSource() == tf3) {
			actionPerformedTf3(e);
		}
	}
	protected void actionPerformedTf1(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, tf1);
		String item = tf1.getText().trim();
		combocmd1.addItem(item);
		tf1.setText("");
	}
	protected void actionPerformedTf2(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, tf2);
		String item = tf2.getText().trim();
		combocmd2.addItem(item);
		tf2.setText("");
	}
	protected void actionPerformedTf3(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, tf3);
		String item = tf3.getText().trim();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>)combocmd3.getModel();  
		model.addElement(item);
		tf3.setText("");
	}
}

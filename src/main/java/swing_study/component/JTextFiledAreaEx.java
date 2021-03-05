package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

public class JTextFiledAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pass;
	private JPasswordField pass2;
	private JTextArea ta;
	private JLabel lblConfirm;
	private JDateChooser dateChooser;
	private JButton btnadd;
	private JButton btncancel;

	public JTextFiledAreaEx() {
		initialize();
	}

	private void initialize() {
		setTitle("텍스트 필드");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pCenter.add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);

		JPanel pNorth = new JPanel();
		pNorth.setPreferredSize(new Dimension(450, 250));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblName);

		tfName = new JTextField();
		pNorth.add(tfName);
		tfName.setColumns(10);

		JLabel lblPass1 = new JLabel("비밀번호");
		lblPass1.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass1);

		pass = new JPasswordField();
		pass.getDocument().addDocumentListener(listener);
		pNorth.add(pass);

		JLabel lblPass2 = new JLabel("비밀번호 확인");
		lblPass2.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass2);

		pass2 = new JPasswordField();
		pass2.getDocument().addDocumentListener(listener);
		pNorth.add(pass2);

		JPanel panel = new JPanel();
		pNorth.add(panel);

		lblConfirm = new JLabel("");
		lblConfirm.setForeground(new Color(220, 20, 60));
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 12));
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblConfirm);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblBirth);

		dateChooser = new JDateChooser(new Date());
		pNorth.add(dateChooser);

		btnadd = new JButton("추가");
		btnadd.addActionListener(this);
		pNorth.add(btnadd);

		btncancel = new JButton("취소");
		btncancel.addActionListener(this);
		pNorth.add(btncancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncancel) {
			actionPerformedBtncancel(e);
		}
		if (e.getSource() == btnadd) {
			actionPerformedBtnadd(e);
		}
	}

	protected void actionPerformedBtnadd(ActionEvent e) {
		
		if (lblConfirm.getText().equals("일치")) {
			Date d = dateChooser.getDate();
			String msg = String.format("%s - %tF%n", tfName.getText(), d);
			ta.append(msg);
			clearTf();
			tfName.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			pass.requestFocus();
			pass2.setText("");
			pass.selectAll();
		}

	}

	private void clearTf() {
		tfName.setText("");
		pass.setText("");
		pass2.setText("");
		dateChooser.setDate(new Date());
		lblConfirm.setText("");
	}

	protected void actionPerformedBtncancel(ActionEvent e) {
		clearTf();
	}
	
	DocumentListener listener = new DocumentListener() {
		@Override
		public void removeUpdate(DocumentEvent e) {
			getMessage();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			getMessage();
		}
		@Override
		public void changedUpdate(DocumentEvent e) {
			getMessage();
		}
		private void getMessage() {
			String pw1 = new String(pass.getPassword());
			String pw2 = String.valueOf(pass2.getPassword());
			if (pw1.equals(pw2)) {
				lblConfirm.setText("일치");
			} else {
				lblConfirm.setText("불일치");
			}
		}
	};
}

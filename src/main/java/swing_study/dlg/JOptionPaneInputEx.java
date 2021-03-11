package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JOptionPaneInputEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JLabel lblres;
	private JButton btn2;
	private JLabel lblres2;
	private JLabel lbl3;
	private JButton btn3;
	private JLabel lblres3;
	private JLabel lbl4;
	private JButton btn4;
	private JLabel lblres4;

	public JOptionPaneInputEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Input Pane");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lbl1 = new JLabel("JOptionPane.showInputDialog(Object message)");
		contentPane.add(lbl1);
		
		btn1 = new JButton("InputBtn01");
		btn1.addActionListener(this);
		contentPane.add(btn1);
		
		lblres = new JLabel("");
		lblres.setHorizontalAlignment(SwingConstants.CENTER);
		lblres.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblres);
		
		JLabel lbl2 = new JLabel("JOptionPane.showInputDialog(\"이름을 입력\", \"유한솔\")");
		contentPane.add(lbl2);
		
		btn2 = new JButton("InputBtn02");
		btn2.addActionListener(this);
		contentPane.add(btn2);
		
		lblres2 = new JLabel("");
		lblres2.setHorizontalAlignment(SwingConstants.CENTER);
		lblres2.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblres2);
		
		lbl3 = new JLabel("showMessageDialog(Component parentComponent, Object message, String title, int messageType)");
		contentPane.add(lbl3);
		
		btn3 = new JButton("InputBtn03");
		btn3.addActionListener(this);
		contentPane.add(btn3);
		
		lblres3 = new JLabel("");
		lblres3.setHorizontalAlignment(SwingConstants.CENTER);
		lblres3.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblres3);
		
		lbl4 = new JLabel("(Component parentComponent,Object message,String title,int messageType,Icon icon)");
		contentPane.add(lbl4);
		
		btn4 = new JButton("InputBtn04");
		btn4.addActionListener(this);
		contentPane.add(btn4);
		
		lblres4 = new JLabel("");
		lblres4.setHorizontalAlignment(SwingConstants.CENTER);
		lblres4.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblres4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			actionPerformedBtn4(e);
		}
		if (e.getSource() == btn3) {
			actionPerformedBtn3(e);
		}
		try {
			if (e.getSource() == btn2) {
				actionPerformedBtn2(e);
			}
			if (e.getSource() == btn1) {
				actionPerformedBtn1(e);
			}
		}catch(NullPointerException e1) {
			System.err.println(e1.getMessage());
			e1.printStackTrace();
		}
	}
	protected void actionPerformedBtn1(ActionEvent e) {
		String res = JOptionPane.showInputDialog("이름을 입력");
		if(res.length() ==0) {
			lblres.setText("입력값은  없음");
		}else {
			lblres.setText("입력값은 ? " + res);
		}
	}
	protected void actionPerformedBtn2(ActionEvent e) {
		String res = JOptionPane.showInputDialog("이름을 입력", "유한솔");
		lblres2.setText("입력값은 ? " + res);
	}
	protected void actionPerformedBtn3(ActionEvent e) {
		/*
		ERROR_MESSAGE, 
		INFORMATION_MESSAGE, 
		WARNING_MESSAGE, 
		QUESTION_MESSAGE,
		PLAIN_MESSAGE
		*/
		
		String res = JOptionPane.showInputDialog(null, "이름을 입력1", "제목", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력2", "제목", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력3", "제목", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력4", "제목", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showInputDialog(null, "이름을 입력5", "제목", JOptionPane.PLAIN_MESSAGE);
		lblres3.setText("입력값은 ? " + res);
	}
	protected void actionPerformedBtn4(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "Home.png");
		
		String[] selectionValues = {"박유진","유한솔","송명훈","이나연","우정아"};
		String initialSelectionValue = "박유진";
		
		Object res = JOptionPane.showInputDialog(
				null, 
				"이름을 선택하세요.",
				"이름 선택", 
				JOptionPane.QUESTION_MESSAGE, 
				icon , 
				selectionValues , 
				initialSelectionValue);
		lblres4.setText("선택한 이름은 ? " + res);
		
	}
}

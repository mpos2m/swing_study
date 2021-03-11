package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class JOptionPaneMessageEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;

	public JOptionPaneMessageEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Message Pane");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btn1 = new JButton("New button");
		btn1.addActionListener(this);
		contentPane.add(btn1, BorderLayout.EAST);
		
		JLabel lblres = new JLabel("New label");
		contentPane.add(lblres, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "KEY.png");
		
		JOptionPane.showMessageDialog(null, "확인하세요", "확인", JOptionPane.WARNING_MESSAGE, icon);
	}
}

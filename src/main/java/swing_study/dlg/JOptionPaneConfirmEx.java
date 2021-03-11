package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JOptionPaneConfirmEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblres;

	public JOptionPaneConfirmEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Confirm Pane");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblres = new JLabel("New label");
		lblres.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblres);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "Home.png");
		/*
		DEFAULT_OPTION 
		•YES_NO_OPTION 
		•YES_NO_CANCEL_OPTION 
		•OK_CANCEL_OPTION
		*/ 

		
		int res = JOptionPane.showConfirmDialog(
				null,
				"계속 할것입니까?", 
				"Confirm", 
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				icon);
		if(res == JOptionPane.YES_OPTION) {
			lblres.setText("YES");
		}
		if(res == JOptionPane.NO_OPTION) {
			lblres.setText("NO");
		}
		if(res == JOptionPane.CANCEL_OPTION) {
			lblres.setText("CANCEL");
		}
		if(res == -1) {
			lblres.setText("선택하지 않음");
		}
	}
}

package swing_study.dlg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FileChooserEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnopen;
	private JLabel lblimg;
	private JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
	
	public FileChooserEx() {
		initialize();
	}
	private void initialize() {
		setTitle("FileChooser");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblimg, BorderLayout.CENTER);
		
		btnopen = new JButton("불러오기");
		btnopen.addActionListener(this);
		contentPane.add(btnopen, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnopen) {
			if(e.getActionCommand().equals("불러오기")) {
				actionPerformedBtnopen(e);
			}else {
				actionPerformedBtnsave(e);
			}
		}
	}
	private void actionPerformedBtnsave(ActionEvent e) {
		//download 폴더에 저장되도록 하세요.
		
		
	}
	protected void actionPerformedBtnopen(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & GIF images", "jpg","png", "gif");
		
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if(res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		String chooseFilePath = chooser.getSelectedFile().getPath();
		lblimg.setIcon(new ImageIcon(chooseFilePath));
		
		if(btnopen.getText().equals("불러오기")) {
			btnopen.setText("저장하기");
		}
	}
}

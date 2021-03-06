package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.JLabel;

public class JLabelEx1 extends JFrame {

	private JPanel contentPane;

	
	public JLabelEx1() {
		initialize();
	}
	private void initialize() {
		setTitle("이미지불러오기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "flower.jpg");
		
		JLabel lblImg1 = new JLabel(icon);
		contentPane.add(lblImg1);
		
		//레이블의 사이즈에 맞춰 이미지 변경
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JLabel lblImg2 = new JLabel(changeIcon);
		contentPane.add(lblImg2);
	}

}

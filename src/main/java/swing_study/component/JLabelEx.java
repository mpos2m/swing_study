package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JLabelEx extends JFrame implements MouseListener {

	private JPanel contentPane;
	private String path = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JLabel lblTop;
	private JLabel lblCenter;
	private JLabel lblBottom;

	public JLabelEx() {
		System.out.println(path + "iu.jpg");
		initialize();
	}
	private void initialize() {
		setTitle("JLable");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblTop = new JLabel("사랑합니다.");
		lblTop.addMouseListener(this);
		lblTop.setOpaque(true);
		lblTop.setBackground(Color.PINK);
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTop, BorderLayout.NORTH);
		
		lblCenter = new JLabel("");
		lblCenter.setIcon(new ImageIcon(path + "iu.jpg"));
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCenter, BorderLayout.CENTER);
		
		lblBottom = new JLabel("보고싶으면 전화하세요.");
		lblBottom.setOpaque(true);
		lblBottom.setBackground(Color.GREEN);
		lblBottom.setIcon(new ImageIcon(path + "lyy.jpg"));
		lblBottom.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBottom, BorderLayout.SOUTH);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblTop) {
			mouseClickedLblTop(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblTop(MouseEvent e) {
		lblCenter.setIcon(new ImageIcon(path + "iu2.jpg"));
		lblBottom.setText("010-1234-1234");
		JOptionPane.showMessageDialog(null, "변경완료");
	}
}

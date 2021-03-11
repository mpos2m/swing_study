package swing_study.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class JmenuEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmLoad;
	private JMenuItem mntmHide;
	private JMenuItem mntmReShow;
	private JMenuItem mntmExit;
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JLabel imgLabel = new JLabel();
	
	public JmenuEx() {
		initialize();
	}
	private void initialize() {
		setTitle("J메뉴");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnScreen = new JMenu("Screen");
		menuBar.add(mnScreen);
		
		mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(this);
		mnScreen.add(mntmLoad);
		
		JSeparator separator = new JSeparator();
		mnScreen.add(separator);
		
		mntmHide = new JMenuItem("Hide");
		mntmHide.addActionListener(this);
		mnScreen.add(mntmHide);
		
		JSeparator separator_1 = new JSeparator();
		mnScreen.add(separator_1);
		
		mntmReShow = new JMenuItem("ReShow");
		mntmReShow.addActionListener(this);
		mnScreen.add(mntmReShow);
		
		JSeparator separator_2 = new JSeparator();
		mnScreen.add(separator_2);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(this);
		mnScreen.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(imgLabel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmExit) {
			actionPerformedMntmExit(e);
		}
		if (e.getSource() == mntmReShow) {
			actionPerformedMntmReShow(e);
		}
		if (e.getSource() == mntmHide) {
			actionPerformedMntmHide(e);
		}
		if (e.getSource() == mntmLoad) {
			actionPerformedMntmLoad(e);
		}
	}
	protected void actionPerformedMntmLoad(ActionEvent e) {
		if(imgLabel.getIcon()!=null)
			return ;
		ImageIcon icon = new ImageIcon(imgPath + "flower.jpg");
		Image changeImg = icon.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
		imgLabel.setIcon(new ImageIcon(changeImg));
	}
	protected void actionPerformedMntmHide(ActionEvent e) {
		if(imgLabel.getIcon() == null)
			return; 
		imgLabel.setVisible(false);
	}
	protected void actionPerformedMntmReShow(ActionEvent e) {
		if(imgLabel.getIcon() == null)
			return; 
		imgLabel.setVisible(true);
	}
	protected void actionPerformedMntmExit(ActionEvent e) {
		System.exit(0);
	}
}

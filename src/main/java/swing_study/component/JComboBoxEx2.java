package swing_study.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class JComboBoxEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cmb;
	private JLabel lblcmb;

	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	
	private Map<String, ImageIcon> map = new HashMap<String, ImageIcon>();
	private ImageIcon[] icons = { new ImageIcon(imgPath + "Apple.jpg"), new ImageIcon(imgPath + "Pear.jpg"),
			new ImageIcon(imgPath + "Cherry.jpg") };
	
	private String[] fruits = {"apple", "pear", "cherry"};
	private JPanel panel;
	
	public JComboBoxEx2() {
		for(int i=0; i<icons.length; i++) {
			map.put(fruits[i], icons[i]);
		}
		initialize();

	}



	

	private void initialize() {
		setTitle("JComboBox 이벤트 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));

		lblcmb = new JLabel("");
		lblcmb.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblcmb);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		cmb = new JComboBox<>();
		panel.add(cmb);
		cmb.setModel(new DefaultComboBoxModel<String>(fruits));
		cmb.setSelectedIndex(-1);
		cmb.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmb) {
			actionPerformedCmb1(e);
		}
	}

	protected void actionPerformedCmb1(ActionEvent e) {
		Object obj = cmb.getSelectedItem();
		lblcmb.setIcon(map.get(obj));
	}
}

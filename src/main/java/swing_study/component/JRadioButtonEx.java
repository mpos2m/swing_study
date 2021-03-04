package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JRadioButtonEx extends JFrame implements ItemListener{

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "Apple.jpg"), 
			new ImageIcon(imgPath + "Pear.jpg"), 
			new ImageIcon(imgPath + "Cherry.jpg") 
	};
	private JLabel lblimg;
	
	public JRadioButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("라디오 버튼");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pLeftRadio = new JPanel();
		pLeftRadio.setBorder(new TitledBorder(null, "간단한 라디오 버튼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeftRadio);
		pLeftRadio.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton pRadio = new CustomRadioButton();
		pLeftRadio.add(pRadio);
		
		JPanel pRightRadio = new JPanel();
		pRightRadio.setBorder(new TitledBorder(null, "응용 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRightRadio);
		pRightRadio.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton panel = new CustomRadioButton();
		pRightRadio.add(panel, BorderLayout.NORTH);
		
		lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		pRightRadio.add(lblimg, BorderLayout.CENTER);
		
		for(JRadioButton r : panel.getRdBtns()) {
			r.addItemListener(this);
		}
		pRadio.getRdbtnPear().setSelected(true);
		
		panel.getRdbtnApple().setSelected(true);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton rd = (JRadioButton) e.getSource();
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rd.getText());
			String text = rd.getText();
			switch(text) {
			case "사과":
				lblimg.setIcon(icons[0]);
				break;
			case "배":
				lblimg.setIcon(icons[1]);
				break;
			default:
				lblimg.setIcon(icons[2]);
				
			}
		}
	}

}

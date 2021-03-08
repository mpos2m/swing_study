package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSliderEx extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider sliderBlue;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JLabel lblColor;

	public JSliderEx() {
		initialize();

		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
	}

	private void initialize() {
		setTitle("JSlider 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 20, 0, 20));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));

		sliderRed = new JSlider();
		sliderRed.setPaintLabels(true);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setForeground(Color.RED);
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setMaximum(255);
		sliderRed.setValue(128);
		sliderRed.setPaintTicks(true);
		pCenter.add(sliderRed);

		sliderGreen = new JSlider();
		sliderGreen.setMaximum(255);
		sliderGreen.setValue(128);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setForeground(Color.GREEN);
		pCenter.add(sliderGreen);

		sliderBlue = new JSlider();
		sliderBlue.setMaximum(255);
		sliderBlue.setValue(128);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setForeground(Color.BLUE);
		pCenter.add(sliderBlue);

		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);

		lblColor = new JLabel("New label");
		lblColor.setForeground(Color.WHITE);
		lblColor.setOpaque(true);
		pSouth.add(lblColor);
	}

	public void stateChanged(ChangeEvent e) {

		int green = sliderGreen.getValue();
		int red = sliderRed.getValue();
		int blue = sliderBlue.getValue();

		String message = String.format("Red(%d) Green(%d) Blue(%d)", red, green, blue);
		lblColor.setText(message);
		lblColor.setBackground(new Color(red, green, blue));
	}

}

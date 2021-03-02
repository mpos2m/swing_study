package swing_study.layout;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelBorder extends JPanel {

	public PanelBorder() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(10, 10));
		
		JLabel lblNorth = new JLabel("West");
		lblNorth.setBackground(Color.RED);
		lblNorth.setOpaque(true);
		add(lblNorth, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Center");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setOpaque(true);
		add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("North");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.ORANGE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("East");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setOpaque(true);
		add(lblNewLabel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel_4 = new JLabel("South");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBackground(Color.PINK);
		lblNewLabel_4.setOpaque(true);
		add(lblNewLabel_4, BorderLayout.SOUTH);
	}

}

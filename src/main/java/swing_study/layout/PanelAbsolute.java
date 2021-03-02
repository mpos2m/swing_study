package swing_study.layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelAbsolute extends JPanel {
	private JTextField textField;

	public PanelAbsolute() {
		
		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(310, 46, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(52, 210, 97, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(173, 162, 116, 21);
		add(textField);
		textField.setColumns(10);
	}
}

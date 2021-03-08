package swing_study.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class TitlePanel extends JPanel {
	private JTextField tfTitleName;
	private JTextField tfTitleNo;


	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		setBorder(new TitledBorder(new EmptyBorder(20, 20, 20, 20), "\uC9C1\uCC45\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 20));
		
		JLabel lblTitleName = new JLabel("직책 이름");
		lblTitleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleName);
		
		tfTitleName = new JTextField();
		add(tfTitleName);
		tfTitleName.setColumns(10);
		
		JLabel lblTitleNo = new JLabel("직책 번호");
		lblTitleNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleNo);
		
		tfTitleNo = new JTextField();
		add(tfTitleNo);
		tfTitleNo.setColumns(10);
	}
	
	public void setTitle(Title title) {
		tfTitleName.setText(title.gettName());
		tfTitleNo.setText(title.gettNo()+"");
	}

	public Title getTitle() {
		String titleName = tfTitleName.getText().trim();
		int titleNo = Integer.parseInt(tfTitleNo.getText().trim());
		
		return new Title(titleNo,titleName);
	}
	public void clearTf() {
		tfTitleName.setText("");
		tfTitleNo.setText("");
	}
}

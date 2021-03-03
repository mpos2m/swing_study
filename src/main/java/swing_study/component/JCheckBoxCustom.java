package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JCheckBoxCustom extends JFrame implements ItemListener{

	private JPanel contentPane;
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblTitle;
	private JLabel lblRes;
	
	
	
	public JCheckBoxCustom(ArrayList<Fruit> list) {
		this.list = list;
		initialize();
//		list.forEach(s->System.out.println(s));
	}
	private void initialize() {
		setTitle("실전 체크박스");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		lblTitle = new JLabel("New label");
		pNorth.add(lblTitle);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		String title = "사과 100원, 배 500원, 체리 2000원, 바나나 1000원, 파인애플 5000원";
		for(Fruit f : list) {
			JCheckBox ck = new JCheckBox(f.getName());
			pCenter.add(ck);
			ck.addItemListener(this);
		}
		lblTitle.setText(title);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblRes = new JLabel("0");
		pSouth.add(lblRes);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();
		
		Fruit selectFruit = list.get(list.indexOf(new Fruit(cb.getText())));
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += selectFruit.getPrice();
//			JOptionPane.showMessageDialog(null, selectFruit);
		}else {
			sum -= selectFruit.getPrice();
		}
		
		lblRes.setText(sum + "원");
	}

}

package swing_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.component.FrameComponentEx;
import swing_study.component.Fruit;
import swing_study.component.JButtonEx;
import swing_study.component.JCheckBoxCustom;
import swing_study.component.JCheckEx;
import swing_study.component.JComboBoxEx1;
import swing_study.component.JComboBoxEx2;
import swing_study.component.JComboBoxEx3;
import swing_study.component.JLabelEx;
import swing_study.component.JLabelEx1;
import swing_study.component.JListEx;
import swing_study.component.JListEx2;
import swing_study.component.JListEx3;
import swing_study.component.JRadioButtonEx;
import swing_study.component.JSliderEx;
import swing_study.component.JSpinner;
import swing_study.component.JTabbedPaneEx1;
import swing_study.component.JTableEx;
import swing_study.component.JTextFiledAreaEx;
import swing_study.component.listener.AnonymousClassListener;
import swing_study.component.listener.IndepClassListener;
import swing_study.component.listener.InnerClassListener;
import swing_study.component.listener.MouseListenerEx;
import swing_study.dlg.FileChooserEx;
import swing_study.dlg.JOptionPaneConfirmEx;
import swing_study.dlg.JOptionPaneInputEx;
import swing_study.dlg.JOptionPaneMessageEx;
import swing_study.frame.ContentPaneEx;
import swing_study.frame.JPanelEx;
import swing_study.layout.FrameLayout;
import swing_study.layout.LayoutGuBun;
import swing_study.menu.JPopupMenuEx;
import swing_study.menu.JmenuEx;

@SuppressWarnings("serial")
public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn02;
	private JPanel pLayout;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnAbsoluteLayout;
	private JButton btnGridLayout;
	private JButton btnNewButton;
	private JPanel pComponent1;
	private JButton btn04;
	private JButton btn05;
	private JPanel pCheackRadio;
	private JButton btn06;
	private JButton btn07;
	private JPanel pText;
	private JButton btn08;
	private JPanel pList;
	private JButton btn09;
	private JButton btn10;
	private JButton btn11;
	private JPanel pComdoBox;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JPanel pSliderSpinner;
	private JPanel pSlider;
	private JPanel pSpinner;
	private JButton btn15;
	private JButton btn16;
	private JPanel pTabbedPane;
	private JButton btn17;
	private JButton btnlabel;
	private JButton btn18;
	private JPanel panel_1;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JPanel panel;
	private JButton btn24;
	private JButton btn25;
	private JButton btn23;
	private JPanel panel_2;
	private JButton btn27;
	private JButton btn26;
	private JButton btn28;
	private JPanel panel_3;
	private JButton btn29;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SwingMain() {
		initialize();
	}
	private void initialize() {
		setTitle("스윙스터디");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 720, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 5, 10, 10));
		
		btn01 = new JButton("jframe 예");
		btn01.addActionListener(this);
		contentPane.add(btn01);
		
		btn02 = new JButton("jpanel");
		btn02.addActionListener(this);
		contentPane.add(btn02);
		
		pLayout = new JPanel();
		pLayout.setBorder(new TitledBorder(null, "레이아웃", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLayout);
		pLayout.setLayout(new GridLayout(0, 1, 0, 10));
		
		btnFlowLayout = new JButton("플로우 레이아웃");
		btnFlowLayout.addActionListener(this);
//		btnFlowLayout.addActionListener(e -> new FrameLayout(LayoutGuBun.FLOW));
		pLayout.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("보더 레이아웃");
		btnBorderLayout.addActionListener(this);
		pLayout.add(btnBorderLayout);
		
		btnGridLayout = new JButton("그리드 레이아웃");
		btnGridLayout.addActionListener(this);
		pLayout.add(btnGridLayout);
		
		btnAbsoluteLayout = new JButton("절대 레이아웃");
		btnAbsoluteLayout.addActionListener(this);
		pLayout.add(btnAbsoluteLayout);
		
		btnNewButton = new JButton("JComponent");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		pComponent1 = new JPanel();
		pComponent1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JLable,JButton,JToggle", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 10));
		
		btn04 = new JButton("JLable");
		btn04.addActionListener(this);
		pComponent1.add(btn04);
		
		btn05 = new JButton("Jbutton && JtoggleButton");
		btn05.addActionListener(this);
		pComponent1.add(btn05);
		
		btnlabel = new JButton("JLableSize");
		btnlabel.addActionListener(this);
		pComponent1.add(btnlabel);
		
		pCheackRadio = new JPanel();
		pCheackRadio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Check&&Radio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pCheackRadio);
		pCheackRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn06 = new JButton("Check");
		btn06.addActionListener(this);
		pCheackRadio.add(btn06);
		
		btn07 = new JButton("JRadio");
		btn07.addActionListener(this);
		pCheackRadio.add(btn07);
		
		pText = new JPanel();
		pText.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD14D\uC2A4\uD2B8\uD544\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pText);
		
		btn08 = new JButton("텍스트 필드");
		btn08.addActionListener(this);
		pText.add(btn08);
		
		pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "\uB9AC\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pList);
		pList.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn09 = new JButton("JList예1");
		btn09.addActionListener(this);
		pList.add(btn09);
		
		btn10 = new JButton("JList예2");
		btn10.addActionListener(this);
		pList.add(btn10);
		
		btn11 = new JButton("JList예3");
		btn11.addActionListener(this);
		pList.add(btn11);
		
		pComdoBox = new JPanel();
		pComdoBox.setBorder(new TitledBorder(null, "jCombo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pComdoBox);
		pComdoBox.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn12 = new JButton("JComboBox예1");
		btn12.addActionListener(this);
		pComdoBox.add(btn12);
		
		btn13 = new JButton("JComboBox예2");
		btn13.addActionListener(this);
		pComdoBox.add(btn13);
		
		btn14 = new JButton("JComboBox예3");
//		btn14.addActionListener(this);
		btn14.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JComboBoxEx3 frame = new JComboBoxEx3();
				frame.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		pComdoBox.add(btn14);
		
		pSliderSpinner = new JPanel();
		contentPane.add(pSliderSpinner);
		pSliderSpinner.setLayout(new GridLayout(0, 1, 0, 0));
		
		pSlider = new JPanel();
		pSlider.setBorder(new TitledBorder(null, "Slider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSlider);
		pSlider.setLayout(new BorderLayout(0, 0));
		
		btn15 = new JButton("JSlider");
		btn15.addActionListener(this);
		pSlider.add(btn15, BorderLayout.CENTER);
		
		pSpinner = new JPanel();
		pSpinner.setBorder(new TitledBorder(null, "Spinner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSpinner);
		pSpinner.setLayout(new BorderLayout(0, 0));
		
		btn16 = new JButton("JSpinner");
		btn16.addActionListener(this);
		pSpinner.add(btn16, BorderLayout.CENTER);
		
		pTabbedPane = new JPanel();
		pTabbedPane.setBorder(new TitledBorder(null, "TabbedPaneAndJTable", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTabbedPane);
		
		btn17 = new JButton("Tabbedpane");
		btn17.addActionListener(this);
		pTabbedPane.setLayout(new GridLayout(0, 1, 0, 0));
		pTabbedPane.add(btn17);
		
		btn18 = new JButton("Jtable");
		btn18.addActionListener(this);
		pTabbedPane.add(btn18);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC774\uBCA4\uD2B8\uB9AC\uC2A4\uB108", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn19 = new JButton("독립클래스");
		btn19.addActionListener(this);
		panel_1.add(btn19);
		
		btn20 = new JButton("내부클래스");
		btn20.addActionListener(this);
		panel_1.add(btn20);
		
		btn21 = new JButton("익명클래스");
		btn21.addActionListener(this);
		panel_1.add(btn21);
		
		btn22 = new JButton("마우스 리스너");
		btn22.addActionListener(this);
		panel_1.add(btn22);
		
		btn23 = new JButton("마우스 어뎁터");
		panel_1.add(btn23);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "J\uBA54\uB274 and J\uCEE4\uBC84\uBA54\uB274", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn24 = new JButton("메뉴바");
		btn24.addActionListener(this);
		panel.add(btn24);
		
		btn25 = new JButton("팝업메뉴");
		btn25.addActionListener(this);
		panel.add(btn25);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "JOptionPane", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn26 = new JButton("InputDlg");
		btn26.addActionListener(this);
		panel_2.add(btn26);
		
		btn27 = new JButton("ConfirmDlg");
		btn27.addActionListener(this);
		panel_2.add(btn27);
		
		btn28 = new JButton("MessageDlg");
		btn28.addActionListener(this);
		panel_2.add(btn28);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "FileChooser", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_3);
		
		btn29 = new JButton("FileChooser");
		btn29.addActionListener(this);
		panel_3.add(btn29);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn29) {
			actionPerformedBtn29(e);
		}
		if (e.getSource() == btn28) {
			actionPerformedBtn28(e);
		}
		if (e.getSource() == btn27) {
			actionPerformedBtn27(e);
		}
		if (e.getSource() == btn26) {
			actionPerformedBtn26(e);
		}
		if (e.getSource() == btn25) {
			actionPerformedBtn25(e);
		}
		if (e.getSource() == btn24) {
			actionPerformedBtn24(e);
		}
		if (e.getSource() == btn22) {
			actionPerformedBtn22(e);
		}
		if (e.getSource() == btn21) {
			actionPerformedBtn21(e);
		}
		if (e.getSource() == btn20) {
			actionPerformedBtn20(e);
		}
		if (e.getSource() == btn19) {
			actionPerformedBtn19(e);
		}
		if (e.getSource() == btn18) {
			actionPerformedBtn18(e);
		}
		if (e.getSource() == btnlabel) {
			actionPerformedBtnlabel(e);
		}
		if (e.getSource() == btn17) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btn16) {
			actionPerformedBtn16(e);
		}
		if (e.getSource() == btn15) {
			actionPerformedBtn15(e);
		}
		
		if (e.getSource() == btn13) {
			actionPerformedBtn13(e);
		}
		if (e.getSource() == btn12) {
			actionPerformedBtn12(e);
		}
		if (e.getSource() == btn11) {
			actionPerformedBtn11(e);
		}
		if (e.getSource() == btn10) {
			actionPerformedBtn10(e);
		}
		if (e.getSource() == btn09) {
			actionPerformedBtn09(e);
		}
		if (e.getSource() == btn08) {
			actionPerformedBtn08(e);
		}
		if (e.getSource() == btn07) {
			actionPerformedBtn07(e);
		}
		if (e.getSource() == btn06) {
			actionPerformedBtn06(e);
		}
		if (e.getSource() == btn05) {
			actionPerformedBtn05(e);
		}
		if (e.getSource() == btn04) {
			actionPerformedBtn04(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			actionPerformedBtnAbsoluteLayout(e);
		}
		if (e.getSource() == btnGridLayout) {
			actionPerformedBtnGridLayout(e);
		}
		if (e.getSource() == btnBorderLayout) {
			actionPerformedBtnBorderLayout(e);
		}
		if (e.getSource() == btnFlowLayout) {
			actionPerformedBtnFlowLayout(e);
		}
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		ContentPaneEx frame = new ContentPaneEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn02(ActionEvent e) {
		JPanelEx frame = new JPanelEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnFlowLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.FLOW);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnBorderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.BORDER);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnGridLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.GRID);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.ABSOLUTE);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		FrameComponentEx frame = new FrameComponentEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn04(ActionEvent e) {
		JLabelEx frame = new JLabelEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn05(ActionEvent e) {
		JButtonEx frame = new JButtonEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn06(ActionEvent e) {
		JCheckEx frame = new JCheckEx();
		frame.setVisible(true);
		
		ArrayList<Fruit> list = new ArrayList<>();
		list.add(new Fruit("사과",100));
		list.add(new Fruit("배",500));
		list.add(new Fruit("체리",2000));
		list.add(new Fruit("바나나",1000));
		list.add(new Fruit("파인애플",5000));
		
		JCheckBoxCustom frame1 = new JCheckBoxCustom(list);
		frame1.setVisible(true);
	}
	protected void actionPerformedBtn07(ActionEvent e) {
		JRadioButtonEx frame = new JRadioButtonEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn08(ActionEvent e) {
		JTextFiledAreaEx frame = new JTextFiledAreaEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn09(ActionEvent e) {
		JListEx frame = new JListEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn10(ActionEvent e) {
		JListEx2 frame = new JListEx2();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn11(ActionEvent e) {
		JListEx3 frame = new JListEx3();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn12(ActionEvent e) {
		JComboBoxEx1 frame = new JComboBoxEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn13(ActionEvent e) {
		JComboBoxEx2 frame = new JComboBoxEx2();
		frame.setVisible(true);
	}
	
	protected void actionPerformedBtn15(ActionEvent e) {
		JSliderEx frame = new JSliderEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn16(ActionEvent e) {
		JSpinner frame = new JSpinner();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		JTabbedPaneEx1 frame = new JTabbedPaneEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnlabel(ActionEvent e) {
		JLabelEx1 frame = new JLabelEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn18(ActionEvent e) {
		JTableEx frame = new JTableEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn19(ActionEvent e) {
		IndepClassListener frame = new IndepClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn20(ActionEvent e) {
		InnerClassListener frame = new InnerClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn21(ActionEvent e) {
		AnonymousClassListener frame = new AnonymousClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn22(ActionEvent e) {
		MouseListenerEx frame = new MouseListenerEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn24(ActionEvent e) {
		JmenuEx frame = new JmenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn25(ActionEvent e) {
		JPopupMenuEx frame = new JPopupMenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn26(ActionEvent e) {
		JOptionPaneInputEx frame = new JOptionPaneInputEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn27(ActionEvent e) {
		JOptionPaneConfirmEx frame = new JOptionPaneConfirmEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn28(ActionEvent e) {
		JOptionPaneMessageEx frame = new JOptionPaneMessageEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn29(ActionEvent e) {
		FileChooserEx frame = new FileChooserEx();
		frame.setVisible(true);
	}
}

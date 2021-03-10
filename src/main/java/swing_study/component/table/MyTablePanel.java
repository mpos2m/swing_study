package swing_study.component.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyTablePanel extends JPanel {
	private JTable table;

	public MyTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 데이터 하나만 선택할수있도록 함.
		table.setModel(getModel());
		scrollPane.setViewportView(table);
	}

	private DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	private Object[][] getData() {

		Object[][] datas = new Object[1][7];
		datas[0] = new Object[] { null, null, null, null, null, null, null };
		return datas;
	}

	private String[] getColumnNames() {
		return new String[] { "학생번호", "학생명", "국어", "영어", "수학", "총점", "평균" };
	}

	public void setList(List<Student> stdList) {
		Object[][] datas = new Object[stdList.size()][];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = toArray(stdList.get(i));
		}
		CustomTableModel model = new CustomTableModel(datas, getColumnNames());
		table.setModel(model);

		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);

		// 컬럼별 너비 조정
		setTableCellWidth(100, 150, 80, 80, 80, 100, 100);

		// 조건에 맞는 셀 색조절(총점이 200미만은 빨강)
		setTableCellCondition(0, 1, 2, 3, 4, 5, 6);
		
		//테이블 컬럼 헤드 안움직이게
		table.getTableHeader().setReorderingAllowed(false);

	}

	private void setTableCellCondition(int... idx) {
		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
		}
	}

	private void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private Object[] toArray(Student std) {
		Object[] data = new Object[] { std.getStdNo(), std.getStdName(), std.getKor(), std.getEng(), std.getMath(),
				std.getTotal(), String.format("%.2f", std.getAvg()) };
		return data;
	}

	private class CustomTableModel extends DefaultTableModel {

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	private class ConditionTableCellRenderer extends JLabel implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value == null ? "" : value.toString());
			setOpaque(true);
			int total = (int) table.getValueAt(row, 5);
			if (total < 200) {
				setBackground(Color.RED);
				setForeground(Color.WHITE);
			} else {
				setBackground(Color.WHITE);
				setForeground(Color.BLACK);
			}
			setHorizontalAlignment(SwingConstants.RIGHT);
			return this;
		}

	}
}

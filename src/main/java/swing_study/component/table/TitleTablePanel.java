package swing_study.component.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import swing_study.panel.Title;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
//		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250);

		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellRenderer(ctcr);
		tcm.getColumn(1).setCellRenderer(ctcr);
		
	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] { t.gettNo(), t.gettName() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "직책번호", "직책명" };
	}

	private class ConditionTableCellRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value==null?"":value.toString());
			setOpaque(true);
			String tname =  table.getValueAt(row, 1).toString();
			if (tname.equals("사장")) {
				setBackground(Color.ORANGE);
			}else {
				setBackground(Color.WHITE);
			}
			if (isSelected) {
				setBackground(Color.PINK);
			}
			setHorizontalAlignment(SwingConstants.CENTER);
			return this;
		}
		
	}
}
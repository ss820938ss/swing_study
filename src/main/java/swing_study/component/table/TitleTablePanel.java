package swing_study.component.table;

import javax.swing.SwingConstants;

import swing_study.panel.Title;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250);
	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] { t.gettNo(), t.gettName() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "직책번호", "직책명" };
	}

}
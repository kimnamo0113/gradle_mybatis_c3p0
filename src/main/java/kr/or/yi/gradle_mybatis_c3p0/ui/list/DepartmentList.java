package kr.or.yi.gradle_mybatis_c3p0.ui.list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@SuppressWarnings("serial")
public class DepartmentList extends AbstractList<Department>{
	
	
	public DepartmentList(String title) {
		super(title);
	}
	
	@Override
	protected void tableAlignmentAndWidth() {
		// 직책번호, 직책명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 200, 200);
	}
	@Override
	protected Object[] toArray(int idx) {
		Department department = itemList.get(idx);
		return department.toArray();
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "부서번호", "부서명","층"};
	}
}

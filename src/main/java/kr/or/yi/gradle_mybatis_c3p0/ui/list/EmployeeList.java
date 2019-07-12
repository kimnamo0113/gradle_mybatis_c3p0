package kr.or.yi.gradle_mybatis_c3p0.ui.list;

import javax.swing.SwingConstants;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;

@SuppressWarnings("serial")
public class EmployeeList extends AbstractList<Employee> {

	public EmployeeList() {
		super("사원");
	}
	
	@Override
	protected Object[] toArray(int idx) {
		Employee employee =itemList.get(idx);
		return employee.toArray();
	}

	@Override
	protected void tableAlignmentAndWidth() {
		// 사원번호(0),사원명(1),급여(2),부서(3),성별(4),입사일(5),직책(6) 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 3,4,5,6);
		tableCellAlignment(SwingConstants.RIGHT, 2);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 150 ,150,100,50,100,100);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "사원번호", "사원명","급여","부서","성별","입사일","직책"};
	}

	
}

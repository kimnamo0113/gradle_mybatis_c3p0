package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
	
	//소속 부서별 사원
	List<Employee> selectEmployeeByDno(int dno);
}

package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
//	int insertEmployee(Employee Employee);
//	int deleteEmployee(Employee Employee);
//	int updateEmployee(Employee Employee);
//	Employee selectEmployeeByCode(Employee Employee);
	
}

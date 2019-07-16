package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.State;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
	Employee selectEmployeeByCode(Employee employee);
	
	Map<String, Object> getSalaryByDepartment(Map<String,Object> param);
	State getStateSalaryByDepartment(Map<String,Object> param);
}

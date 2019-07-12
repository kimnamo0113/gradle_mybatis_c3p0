package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final String namespace="kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao";
	@Override
	public List<Employee> selectEmployeeByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectEmployeeByAll");
		}
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectEmployeeByNo");
		}
	}

	@Override
	public int insertEmployee(Employee employee) {
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		return 0;
	}

	@Override
	public List<Employee> selectEmployeeByDno(int dno) {
		return null;
	}

}

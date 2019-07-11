package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;

public class DepartmentDaoImpl implements DepartmentDao{
//	private static final String namespace="mappers.DepartmentMapper";
	private static final String namespace="kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao";
	@Override
	public List<Department> selectDepartmentByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectDepartmentByAll");
		}
	}

	@Override
	public Department selectDepartmentByNo(Department dept) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectDepartmentByNo",dept);
		}
	}

	@Override
	public int insertDepartment(Department dept) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".insertDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteDepartment(Department dept) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace+".deleteDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateDepartment(Department dept) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace+".updateDepartment", dept);
			sqlSession.commit();
			return res;
		}
	}
	
}
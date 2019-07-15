package kr.or.yi.gradle_mybatis_c3p0.service;

import org.junit.Test;

import kr.or.yi.gradle_mybatis_c3p0.AbstractTest;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

public class TransactionServiceTest extends AbstractTest {
	private static TransactionService service=new TransactionService();
	
	@Test(expected=RuntimeException.class)
	public void test1Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(1);
		title.setTitleName("사원");
		Department department = new Department(6,"H/W개발",6);
		service.addTitleDepartment(title, department);
	}
	@Test(expected=RuntimeException.class)
	public void test2Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(1,"개발",6);//에러
		service.addTitleDepartment(title, department);
	}
	@Test
	public void test3Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("사원");
		Department department = new Department(6,"H/W개발",6);
		service.addTitleDepartment(title, department);
	}
	@Test(expected=RuntimeException.class)
	public void test4DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(8);
		title.setTitleName("사원");
		Department department = new Department(6,"H/W개발",6);//에러
		service.removeTitleDepartment(title, department);
	}
	@Test(expected=RuntimeException.class)
	public void test5DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(10,"H/W개발",6);//에러
		service.removeTitleDepartment(title, department);
	}
	
	@Test
	public void test6DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(6,"H/W개발",6);//에러
		service.removeTitleDepartment(title, department);
	}
	
}

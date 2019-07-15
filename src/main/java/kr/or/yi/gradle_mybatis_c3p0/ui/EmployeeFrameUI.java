package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.service.EmployeeUIService;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelEmployee;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.AbstractList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.EmployeeList;

@SuppressWarnings("serial")
public class EmployeeFrameUI extends AbstractFrameUI<Employee> {
	private EmployeeUIService service;
	
	public EmployeeFrameUI(String title) {
		super(title);
		setBounds(100, 100, 550, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	@Override
	protected void initDao() {
		service=new EmployeeUIService();
	}

	@Override
	protected AbstractList<Employee> createListPanel() {
		EmployeeList empList = new EmployeeList();
		empList.setItemList(service.selectEmpAll());
		empList.reloadData();
		return empList;
	}

	@Override
	protected AbstractPanel<Employee> createContentPanel() {
		PanelEmployee empPanel=new PanelEmployee();
		empPanel.setDeptList(service.selectDeptAll());
		empPanel.setTitleList(service.selectTitleAll());
		return empPanel;
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size()==0?1:itemList.size()+1);
	}

	@Override
	protected List<Employee> getListAll() {
		return service.selectEmpAll();
	}

	@Override
	protected int updateItem(Employee item) {
		return service.updateEmployee(item);
	}

	@Override
	protected int insertItem(Employee item) {
		return service.createItem(item);
	}

	@Override
	protected int deleteItem(Employee item) {
		return service.deleteEmp(item);
	}

}

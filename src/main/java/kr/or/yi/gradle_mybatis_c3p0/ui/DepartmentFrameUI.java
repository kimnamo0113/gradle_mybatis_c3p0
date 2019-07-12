package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.util.List;

import javax.swing.JOptionPane;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelDepartment;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.AbstractList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList;

@SuppressWarnings("serial")
public class DepartmentFrameUI extends AbstractFrameUI<Department> {
	private DepartmentDao dao;

	public DepartmentFrameUI(String title) {
		super(title);
	}
	protected void initDao() {
		dao=new DepartmentDaoImpl();
	}
	
	@Override
	protected AbstractList<Department> createListPanel(){
		return new DepartmentList("부서");
	};
	@Override
	protected AbstractPanel<Department> createContentPanel(){
		return new PanelDepartment("부서");
	};
	

	public void refreshUI(Department item, int res) {
		String message = res==1?"성공":"실패";
		JOptionPane.showMessageDialog(null, item+message);
		reloadList();
		clearContent();
	}

	@Override
	protected List<Department> getListAll() {
		return dao.selectDepartmentByAll();
	}
	@Override
	protected int updateItem(Department item) {
		return dao.updateDepartment(item);
	}
	@Override
	protected int insertItem(Department item) {
		return dao.insertDepartment(item);
	}
	@Override
	protected int deleteItem(Department item) {
		return dao.deleteDepartment(item);
	}
	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size()==0?1:itemList.size()+1);
	}


	
}

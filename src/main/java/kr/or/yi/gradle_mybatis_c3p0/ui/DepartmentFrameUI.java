package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelDepartment;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList;

@SuppressWarnings("serial")
public class DepartmentFrameUI extends JFrame implements ActionListener {
	private DepartmentDao dao;
	private JButton btnAdd;
	private PanelDepartment pContent;
	private List<Department> deptList;
	private DepartmentList pList;
	private JButton btnCancel;
	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	
	public DepartmentFrameUI() {
		dao=new DepartmentDaoImpl();
		deptList=dao.selectDepartmentByAll();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책관리");
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = new PanelDepartment("부서");
		clearContent();
		
		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = new DepartmentList("부서");
				
		getContentPane().add(pList, BorderLayout.SOUTH);
		
		reloadList();
	
		popupMenu = new JPopupMenu();
		pList.add(popupMenu, BorderLayout.NORTH);
		
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);
		
		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		
		pList.setPopupMenu(popupMenu);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDelete) {
			actionPerformedMntmDelete(e);
		}
		if (e.getSource() == mntmUpdate) {
			actionPerformedMntmUpdate(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("추가"))
				actionPerformedBtnAdd(e);
			if(e.getActionCommand().equals("수정"))
				actionPerformedBtnUpdate(e);
		}
	}
	private void actionPerformedMntmUpdate(ActionEvent e) {
		Department updateDept = pList.getSelectedItem();
		pContent.setItem(updateDept);
		btnAdd.setText("수정");
		
	}

	private void actionPerformedMntmDelete(ActionEvent e) {
		Department delDept= pList.getSelectedItem();
		int res=dao.deleteDepartment(delDept);
		refreshUI(delDept, res);
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		Department updateTitle=pContent.getItem();
		int res=dao.updateDepartment(updateTitle);
		refreshUI(updateTitle, res);
		btnAdd.setText("추가");
	}
	public void refreshUI(Department item, int res) {
		String message = res==1?"성공":"실패";
		JOptionPane.showMessageDialog(null, item+message);
		reloadList();
		clearContent();
	}
	public void clearContent() {
		pContent.clearComponent(deptList.size()==0?1:deptList.size()+1);
	}

	public void reloadList() {
		deptList=dao.selectDepartmentByAll();
		pList.setItemList(deptList);
		pList.reloadData();
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department insertDept=pContent.getItem();
		int res=dao.insertDepartment(insertDept);
		refreshUI(insertDept, res);
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearContent();
	}
	
}

package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@SuppressWarnings("serial")
public class PanelEmployee extends AbstractPanel<Employee> {
	private JTextField tfEmpNo;
	private JTextField tfEmpName;
	private JLabel lblSalary;
	private JSpinner spinSalary;
	private JLabel lblDno;
	private JComboBox<Department> cmbDno;
	private JLabel lblGender;
	private JLabel lblJoin;
	private JTextField tfJoin;
	private JLabel lblTitle;
	private JComboBox<Title> cmbTitle;
	private JRadioButton rdbMale;
	private JRadioButton rdbFeMale;
	
	public PanelEmployee() {
		super("사원");
	}

	@Override
	public void initComponents(String title) {
		setSize(450,300);
		setBorder(new TitledBorder(null, title + " 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblEmpNo = new JLabel("사원 번호");
		lblEmpNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpNo);

		tfEmpNo = new JTextField();
		add(tfEmpNo);
		tfEmpNo.setColumns(10);

		JLabel lblEmpName = new JLabel("사원명");
		lblEmpName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpName);

		tfEmpName = new JTextField();
		tfEmpName.setColumns(10);
		add(tfEmpName);
		
		lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSalary);
		
		spinSalary = new JSpinner();
		spinSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		add(spinSalary);
		
		lblDno = new JLabel("부서");
		lblDno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDno);
		
		cmbDno = new JComboBox<>();
		add(cmbDno);
		
		lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblGender);
		
		JPanel pGender = new JPanel();
		add(pGender);
		pGender.setLayout(new BoxLayout(pGender, BoxLayout.X_AXIS));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		rdbMale = new JRadioButton("남");
		buttonGroup.add(rdbMale);
		rdbMale.setSelected(true);
		pGender.add(rdbMale);
		
		rdbFeMale = new JRadioButton("여");
		buttonGroup.add(rdbFeMale);
		pGender.add(rdbFeMale);
		
		lblJoin = new JLabel("입사일");
		lblJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblJoin);
		
		tfJoin = new JTextField();
		tfJoin.setColumns(10);
		add(tfJoin);
		
		lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		cmbTitle = new JComboBox<>();
		add(cmbTitle);
	}

	public void setTitleList(List<Title> titleList) {
		DefaultComboBoxModel<Title> titleModels = new DefaultComboBoxModel<Title>(new Vector<Title>(titleList));
		cmbTitle.setModel(titleModels);
		cmbTitle.setSelectedIndex(-1);
	}

	public void setDeptList(List<Department> deptList) {
		DefaultComboBoxModel<Department> deptModels = new DefaultComboBoxModel<Department>(new Vector<Department>(deptList));
		cmbDno.setModel(deptModels);
		cmbDno.setSelectedIndex(-1);
	}
	
	@Override
	public void setItem(Employee item) {
		tfEmpNo.setText(String.format("E%06d", item.geteNo()));
		tfEmpName.setText(item.geteName());
		cmbTitle.setSelectedItem(item.getTitle());
		cmbDno.setSelectedItem(item.getDno());
		spinSalary.setValue(item.getSalary());
		if(item.isGender()) {
			rdbMale.setSelected(true);
		}else {
			rdbFeMale.setSelected(true);
		}
		
		tfJoin.setText(String.format("%tF", item.getJoinDate()));
	}

	@Override
	public Employee getItem() {
		int eNo = Integer.parseInt(tfEmpNo.getText().trim().substring(1)); 
		String eName = tfEmpName.getText().trim();
		int salary = (Integer) spinSalary.getValue();
		Department dno = (Department) cmbDno.getSelectedItem();
		boolean gender = rdbMale.isSelected()?true:false;
		
		Date joinDate = null;
		try {
			joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(tfJoin.getText().trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Title title = (Title) cmbTitle.getSelectedItem();
		return new Employee(eNo, eName, salary, dno, gender, joinDate, title);
	}

	@Override
	public void clearComponent(int nextNo) {
		tfEmpNo.setText(String.format("E%06d", nextNo));
		tfEmpName.setText("");
		cmbTitle.setSelectedIndex(-1);
		cmbDno.setSelectedIndex(-1);
		spinSalary.setValue(new Integer(1500000));
		rdbMale.setSelected(true);
		tfJoin.setText(String.format("%tF", new Date()));
		tfEmpNo.setEditable(false);
	}

}

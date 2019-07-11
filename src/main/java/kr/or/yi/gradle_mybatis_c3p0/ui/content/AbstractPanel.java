package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;

@SuppressWarnings("serial")
public abstract class AbstractPanel<T> extends JPanel {
	
	public AbstractPanel(String title) {
		initComponents(title);
	}

	public abstract void initComponents(String title);

	public abstract void setItem(T item);

	public abstract T getItem();

	public abstract void clearComponent(int nextNo);

}

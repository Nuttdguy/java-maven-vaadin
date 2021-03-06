package com.app.ui.students;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.ui.common.UniversityMainUI;
import com.app.utils.StudentStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutFactory.NAME, ui = UniversityMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {

	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	
	@Autowired
	private AddStudentMainLayoutFactory mainLayoutFactory;
	
	@Autowired
	private ShowAllStudentsLayoutFactory showAllStudentsLayoutFactory;

	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

	private void addLayout() {
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = mainLayoutFactory.createComponent();
		Component showStudentsTab = showAllStudentsLayoutFactory.createComponent();
		
		
		tabSheet.addTab(addStudentMainTab, StudentStringUtils.MAIN_MENU.getString());
		tabSheet.addTab(showStudentsTab, StudentStringUtils.SHOW_ALL_STUDENTS.getString());
		
		
		addComponent(tabSheet);
		
	}

}

package com.app.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.entity.Student;
import com.app.service.getallstudents.ShowAllStudentsService;
import com.app.ui.common.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;


@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder {

	@Autowired
	private ShowAllStudentsService showAllStudentsService;
	
	private List<Student> students;
	private BeanItemContainer<Student> container;
	
	private class ShowAllStudentsLayout extends VerticalLayout {
			
		private Grid studentsTable;
		
		public ShowAllStudentsLayout init() {
			setMargin(true);
			
			container = new BeanItemContainer<Student>(Student.class, students);
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName", "lastName", "age", "gender");
			studentsTable.removeColumn("id");
			studentsTable.setImmediate(true);
			
			return this;
		}

		public ShowAllStudentsLayout load() {
			students = showAllStudentsService.getAllStudents();
			return this;
		}
		
		public ShowAllStudentsLayout layout() {
			addComponent(studentsTable);
			return this;
		}
		
	}
	
	public Component createComponent() {
		return new ShowAllStudentsLayout().load().init().layout();
	}

}

package com.app.ui.common;


import com.app.ui.navigator.UniversityNavigator;
import com.app.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder {

	private class UniversityMenu extends VerticalLayout implements Property.ValueChangeListener {
		
		private Tree mainMenu;
		
		public UniversityMenu init() {
			mainMenu = new Tree();
			mainMenu.addValueChangeListener(this);
			return this;
		}
		
		public UniversityMenu layout() {
			setWidth("100%");
			setHeightUndefined();
			
			mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
			mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());
			
			mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
			mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());
			
			mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
			mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(),  false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(),  false);
			mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
			mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
			
			mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(),  false);
			mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());
			
			addComponent(mainMenu);		
			return this;
			
		}

		public void valueChange(ValueChangeEvent event) {
			String selectedItemPath = (String) event.getProperty().getValue();
			if ( selectedItemPath == null ) return;
			
			String path = selectedItemPath.toLowerCase().replaceAll("\\s+", "");
			System.out.println(path);
			UniversityNavigator.navigate(path);
		}
		
	}
	
	public Component createComponent() {
		return new UniversityMenu().init().layout();
	}
	
}

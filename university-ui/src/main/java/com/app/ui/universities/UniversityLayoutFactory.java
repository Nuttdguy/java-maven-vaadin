package com.app.ui.universities;

import com.app.ui.common.UniversityMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=UniversityLayoutFactory.NAME, ui=UniversityMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View {

	public static final String NAME = "operations";

	public void enter(ViewChangeEvent event) {
		addComponent(new Label("University layout ... "));
		
	}
}

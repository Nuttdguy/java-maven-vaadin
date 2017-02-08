package com.app.ui.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.app.ui.navigator.UniversityNavigator;
import com.app.ui.students.StudentLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=UniversityMainUI.URI)
@Title("UNIVERSITY HOME")
@Theme("valo")
public class UniversityMainUI extends UI {
	
	public static final String URI = "/ui";
	private Panel changeTab = new Panel();
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SpringViewProvider viewProvider;
	
	@Autowired
	private UniversityLogoLayoutFactory universityLogoLayoutFactory;
	
	@Autowired
	private UniversityMenuFactory universityMenuFactory;
	
	@Override
	protected void init(VaadinRequest request) {
				
		changeTab.setHeight("100%");
		
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");
		
		Panel logoPanel = new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeightUndefined();
		
		HorizontalLayout uiLayout = new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(true);
		
		Component logo = universityLogoLayoutFactory.createComponent();
		Component menu = universityMenuFactory.createComponent();
		
		uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTab);
		
		uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(menu,  Alignment.TOP_CENTER);
		
		uiLayout.setExpandRatio(menu,  1);
		uiLayout.setExpandRatio(changeTab, 2);
		
		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);
		
		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);
		
		initNavigator();	
		setContent(rootLayout);
		
	}
	
	private void initNavigator() {
		UniversityNavigator navigator = new UniversityNavigator(this, changeTab);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
		navigator.addProvider(viewProvider);
		navigator.navigateTo(StudentLayoutFactory.NAME);
	}

}

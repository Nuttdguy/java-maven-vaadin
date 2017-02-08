package com.app.ui.navigator;


import com.google.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UniversityNavigator extends Navigator {


	public UniversityNavigator(UI ui, SingleComponentContainer container) {
		super(ui, container);
	}
	
	private static UniversityNavigator getNavigator() {
		UI ui = UI.getCurrent();
		Navigator navigator = ui.getNavigator();
		return (UniversityNavigator) navigator;
	}
	
	public static void navigate(String path) {
		try {
			System.out.println(path);
			UniversityNavigator.getNavigator().navigateTo(path);
		} catch (Exception e) {
			return;
		}
	}
	
	@Override
	public void navigateTo(String viewName) {
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
	
	
}







package com.sagar.restgwt.client;

import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Map extends Widget {
	public Map() {
		FormPanel formPanel = new FormPanel();
		formPanel.setWidth("500px");
		formPanel.setHeight("650px");

		RootPanel.get().add(formPanel);


	}
}
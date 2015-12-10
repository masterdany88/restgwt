package com.sagar.restgwt.client;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RestGWT implements EntryPoint {
	public void onModuleLoad() {
		Button button = new Button("Click Me to test testing service");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().getInfo(
						new MethodCallback<TestPojo>() {
							@Override
							public void onSuccess(Method method,TestPojo response) {
								RootPanel.get().add(new Label(response.toString()));
							}

							@Override
							public void onFailure(Method method,
									Throwable exception) {
								GWT.log("Error");
							}
						});
			}
		});
		RootPanel.get().add(button);
	}
}
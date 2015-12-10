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
		Button getButton = new Button("Click Me to get test entity from testing service");
		Button setButton = new Button("Click Me to send test entity to testing service");
		
		getButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().getInfo(
						new MethodCallback<TestPojo>() {
							@Override
							public void onSuccess(Method method, TestPojo response) {
								RootPanel.get().add(new Label(
										response.id + " " +
												response.test + " " +
												response.test2 + " "
										));
								
							}
							@Override
							public void onFailure(Method method, Throwable exception) {
								RootPanel.get().add(new Label("Error getting"));
							}
						});
			}
		});
		setButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().setInfo(
					new MethodCallback<Integer>() {
						@Override
						public void onSuccess(Method method, Integer response) {
							RootPanel.get().add(
								new Label("Succefully set info. status code: " + response)
							);
						}
						@Override
						public void onFailure(Method method, Throwable exception) {
							RootPanel.get().add(new Label("Error setting"));
						}
				});
			}
		});
		RootPanel.get().add(getButton);
		RootPanel.get().add(setButton);
	}
}
package com.sagar.restgwt.client;

import gwt.material.design.client.resources.MaterialResources;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialSplashScreen;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RestGWT implements EntryPoint {
	public void onModuleLoad() {

		MaterialDatePicker dataPicker = new MaterialDatePicker();
		Button getButton = new Button("Click Me to get test entity from testing service");
		Button setButton = new Button("Click Me to send test entity to testing service2");
		final TestPojo test = new TestPojo(22L, "test1", "test2");
		
		getButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().getInfo(
						new MethodCallback<TestPojo>() {
							@Override
							public void onSuccess(Method method, TestPojo response) {
								RootPanel.get().add(
										new Label(
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
		RootPanel.get().add(new Label("about to add: " + test.id + " " +  test.test + " " + test.test2));
		setButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TestService.Util.getService().setInfo(
					test, new MethodCallback<Integer>() {
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
		
		RootPanel.get().add(dataPicker);
		


	}

}
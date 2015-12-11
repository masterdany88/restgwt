package com.sagar.restgwt.client;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.hibernate.cfg.annotations.SetBinder;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Rest {

	public static void test() {
		MaterialButton getButton = new MaterialButton(ButtonType.RAISED, "Click Me to get test entity from testing service", null);
		MaterialButton setButton = new MaterialButton(ButtonType.RAISED, "Click Me to send test entity to testing service2",null);
		final TestPojo test = new TestPojo(null, "test1", "test2");
		
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
		
		getButton.setWaves(WavesType.DEFAULT);
		setButton.setWaves(WavesType.DEFAULT);
		
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
				
	}

}

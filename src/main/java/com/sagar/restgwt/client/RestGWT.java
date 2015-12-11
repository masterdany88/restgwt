package com.sagar.restgwt.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.ui.MaterialButton;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class RestGWT implements EntryPoint {

	interface Driver extends SimpleBeanEditorDriver<TestPojo, TestEditor> {}

	Driver driver = GWT.create(Driver.class);
	TestPojo test = new TestPojo(3L, "test", "test2");
	
	
	public void onModuleLoad() {
		
		TestEditor editor = new TestEditor();
		driver.initialize(editor);
		driver.edit(test);
		
		editor.edit(test);
		RootPanel.get().add(editor);
		MaterialButton s = new MaterialButton(ButtonType.RAISED, "Send to server", null);
		RootPanel.get().add(s);
		
		
		
		s.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().add(new Label());
				save();
			}
			
		});
		Rest.test();
		
		
	}
	
	 // Called by some UI action
	  void save() {
	    TestPojo edited = driver.flush();
	    if (driver.hasErrors()) {
	      // A sub-editor reported errors
	    }
	    doSomethingWithEditedPerson(edited);
	  }

	private void doSomethingWithEditedPerson(TestPojo edited) {
		TestService.Util.getService().setInfo(
				edited, new MethodCallback<Integer>() {
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
}

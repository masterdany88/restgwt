package com.sagar.restgwt.client;


import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialTextBox;

import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestForm {
	interface Driver extends SimpleBeanEditorDriver<TestPojo, TestEditor> {}
    private static final TestService testService = GWT.create(TestService.class);

	Driver driver = GWT.create(Driver.class);
	TestPojo test = new TestPojo(3L, "test", "test2");
		
	public TestForm() {
		
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
		testService.setInfo(
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

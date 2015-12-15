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

	@Override
	public void onModuleLoad() {
		new TestForm();
		new TestForm();
		
	}

	
}

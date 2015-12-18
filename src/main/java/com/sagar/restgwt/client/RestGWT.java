package com.sagar.restgwt.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialSplashScreen;
import gwt.material.design.client.ui.MaterialTitle;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.sagar.restgwt.client.ui.ApplicationView2;
import com.sagar.restgwt.client.ui.ConfirmModal;
import com.sagar.restgwt.client.ui.MaterialLogin;




public class RestGWT implements EntryPoint {

	@Override
	public void onModuleLoad() {
		final MaterialSplashScreen ss = new MaterialSplashScreen();
		RootPanel.get().add(ss);
		
		
		MaterialTitle mt = new MaterialTitle("Grupa Supra CMS", "This is a default cms system for company");
		mt.setTextColor("white");
		ss.add(new MaterialImage("https://grupasupra.pl/images/GrupaSupra-2014_logo.png"));
		ss.add(mt);
		ss.setBackgroundColor("blue");
		ss.setTextAlign(TextAlign.CENTER);
		ss.show();
		//new TestForm();
		//RootPanel.get().add(new ApplicationView());   
		Timer t = new Timer() {
			@Override
			public void run() {
				ss.hide();
				RootPanel.get().add(new ApplicationView2());
				//RootPanel.get().add(new MaterialLogin());
				//RootPanel.get().add(new Map());
			}
		};
		t.schedule(1000);

		
		

		

		
	}	
}

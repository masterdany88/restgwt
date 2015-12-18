package com.sagar.restgwt.client.ui;

import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.Header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationView2 extends Composite {

	private static ApplicationView2UiBinder uiBinder = GWT
			.create(ApplicationView2UiBinder.class);

	interface ApplicationView2UiBinder extends
			UiBinder<Widget, ApplicationView2> {
	}

	@UiField MaterialSideNav sideNav;
	@UiField MaterialContainer container;
	
	public ApplicationView2() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialAnimator.animate(Transition.SHOW_STAGGERED_LIST, sideNav, 0);
		MaterialAnimator.animate(Transition.SHOW_STAGGERED_LIST, container, 0);
	}

}

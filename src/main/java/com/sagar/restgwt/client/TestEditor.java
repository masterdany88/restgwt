package com.sagar.restgwt.client;


import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialTextBox;

import java.util.logging.Logger;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestEditor extends Composite implements Editor<TestPojo> {
	LongBox id = new LongBox();
	MaterialTextBox test = new MaterialTextBox();
	MaterialTextBox test2 = new MaterialTextBox();

	MaterialButton rb = new MaterialButton(ButtonType.RAISED, "Reset", null);
	
	public TestEditor() {
		test.setPlaceholder("test placeholder");

        VerticalPanel widget = new VerticalPanel();
        initWidget(widget);
        widget.add(id);
		widget.add(test);
		widget.add(test2);
		widget.add(rb);
		rb.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				id.setValue(null);
				test.setValue("");
				test.setError("ERROR");
				
				test2.setValue("");
			}
		});

	}
	public void edit(TestPojo test) {
		RootPanel.get().add(new Label(test.toString()));
	}

}

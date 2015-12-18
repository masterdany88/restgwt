package com.sagar.restgwt.client.ui;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialModalFooter;
import gwt.material.design.client.ui.MaterialTitle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ConfirmModal extends MaterialModal {

/*	
 * 					EXAMPLE USAGE
	ConfirmModal.open("Header title", "Some description text", new ConfirmModal.ConfirmCallback() {
        @Override
        public void onConfirm(boolean confirmed) {
            if (confirmed) {
                Window.alert("Yes was clicked!");
            }
            else {
                Window.alert("No was clicked!");
            }
        }
    });
	*/
	
/*    public void open(String titleText, String descriptionText, CloseHandler<MaterialModal> closeHandler) {

        MaterialButton yesButton = new MaterialButton(ButtonType.FLAT);
        yesButton.setText("Yes");
        yesButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                close(ConfirmModal.this, false);
            }
        });

        MaterialButton noButton = new MaterialButton(ButtonType.FLAT);
        noButton.setText("No");
        noButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                close(ConfirmModal.this, true);
            }
        });

        MaterialTitle title = new MaterialTitle();
        title.setTitle(titleText);
        title.setDescription(descriptionText);

        MaterialModalFooter footer = new MaterialModalFooter();
        footer.add(yesButton);
        footer.add(noButton);

        MaterialModalContent content = new MaterialModalContent();
        content.add(title);
        content.add(footer);

        add(content);

        addCloseHandler(closeHandler);

        RootPanel.get().add(this);
        openModal();
    }

    private static void close(MaterialModal modal, boolean autoClosed) {
        modal.closeModal(autoClosed);
        RootPanel.get().remove(modal);
    }*/

}
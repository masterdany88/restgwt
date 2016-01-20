/*
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.sagar.restgwt.client.application.settings;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

/**
 * The view implementation for {@link com.sagar.restgwt.client.application.settings.SettingsPresenter} .
 */
public class SettingsView extends ViewWithUiHandlers<SettingsUiHandlers> implements SettingsPresenter.MyView {
    interface Binder extends UiBinder<Widget, SettingsView> {
    }

    @UiField
    InlineLabel userPrivileges;
    @UiField
    Button togglePrivileges;

    @Inject
    SettingsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setAdmin(boolean isAdmin) {
        if (isAdmin) {
            userPrivileges.setText("Admin");
            togglePrivileges.setText("Toggle to non-admin user");
        } else {
            userPrivileges.setText("Non-admin");
            togglePrivileges.setText("Toggle to admin user");
        }
        togglePrivileges.setVisible(true);
    }

    @UiHandler("togglePrivileges")
    void onSwitchSecurityClicked(ClickEvent event) {
        getUiHandlers().togglePrivileges();
    }
}

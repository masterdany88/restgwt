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

package com.sagar.restgwt.client.application.dialog;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.ViewImpl;
import com.sagar.restgwt.client.application.ui.tabs.SimpleTabPanel;

/**
 * The view implementation for {@link com.sagar.restgwt.client.application.dialog.DialogSamplePresenter}.
 */
public class DialogSampleView extends ViewImpl implements DialogSamplePresenter.MyView {
    interface Binder extends UiBinder<Widget, DialogSampleView> {
    }

    @UiField(provided = true)
    SimpleTabPanel tabPanel;

    @Inject
    DialogSampleView(
            Binder uiBinder,
            SimpleTabPanel tabPanel) {
        this.tabPanel = tabPanel;

        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Tab addTab(TabData tabData, String historyToken) {
        return tabPanel.addTab(tabData, historyToken);
    }

    @Override
    public void removeTab(Tab tab) {
        tabPanel.removeTab(tab);
    }

    @Override
    public void removeTabs() {
        tabPanel.removeTabs();
    }

    @Override
    public void setActiveTab(Tab tab) {
        tabPanel.setActiveTab(tab);
    }

    @Override
    public void changeTab(Tab tab, TabData tabData, String historyToken) {
        tabPanel.changeTab(tab, tabData, historyToken);
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == DialogSamplePresenter.SLOT_TAB_CONTENT) {
            tabPanel.setPanelContent(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}

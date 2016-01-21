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

package com.sagar.restgwt.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.sagar.restgwt.client.application.adminarea.AdminAreaPresenter;
import com.sagar.restgwt.client.application.adminarea.AdminAreaView;
import com.sagar.restgwt.client.application.dialog.DialogSamplePresenter;
import com.sagar.restgwt.client.application.dialog.DialogSampleView;
import com.sagar.restgwt.client.application.globaldialog.GlobalDialogPresenterWidget;
import com.sagar.restgwt.client.application.globaldialog.GlobalDialogSubTabPresenter;
import com.sagar.restgwt.client.application.globaldialog.GlobalDialogSubTabView;
import com.sagar.restgwt.client.application.globaldialog.GlobalDialogView;
import com.sagar.restgwt.client.application.home.HomePresenter;
import com.sagar.restgwt.client.application.home.HomeView;
import com.sagar.restgwt.client.application.homeinfo.HomeInfoPresenter;
import com.sagar.restgwt.client.application.homeinfo.HomeInfoView;
import com.sagar.restgwt.client.application.homenews.HomeNewsPresenter;
import com.sagar.restgwt.client.application.homenews.HomeNewsView;
import com.sagar.restgwt.client.application.infopopup.InfoPopupPresenterWidget;
import com.sagar.restgwt.client.application.infopopup.InfoPopupView;
import com.sagar.restgwt.client.application.localdialog.LocalDialogPresenterWidget;
import com.sagar.restgwt.client.application.localdialog.LocalDialogSubTabPresenter;
import com.sagar.restgwt.client.application.localdialog.LocalDialogSubTabView;
import com.sagar.restgwt.client.application.localdialog.LocalDialogView;
import com.sagar.restgwt.client.application.settings.SettingsPresenter;
import com.sagar.restgwt.client.application.settings.SettingsView;
import com.sagar.restgwt.client.application.ui.UiModule;

/**
 * @author Brandon Donnelson
 */
public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new UiModule());

        // Applicaiton Presenters
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(DialogSamplePresenter.class, DialogSamplePresenter.MyView.class, DialogSampleView.class, DialogSamplePresenter.MyProxy.class);
        bindPresenter(LocalDialogSubTabPresenter.class, LocalDialogSubTabPresenter.MyView.class, LocalDialogSubTabView.class, LocalDialogSubTabPresenter.MyProxy.class);
        bindPresenter(GlobalDialogSubTabPresenter.class, GlobalDialogSubTabPresenter.MyView.class, GlobalDialogSubTabView.class, GlobalDialogSubTabPresenter.MyProxy.class);
        bindPresenter(SettingsPresenter.class, SettingsPresenter.MyView.class, SettingsView.class, SettingsPresenter.MyProxy.class);
        bindPresenter(AdminAreaPresenter.class, AdminAreaPresenter.MyView.class, AdminAreaView.class, AdminAreaPresenter.MyProxy.class);
        bindPresenter(HomeNewsPresenter.class, HomeNewsPresenter.MyView.class, HomeNewsView.class, HomeNewsPresenter.MyProxy.class);
        bindPresenter(HomeInfoPresenter.class, HomeInfoPresenter.MyView.class, HomeInfoView.class, HomeInfoPresenter.MyProxy.class);
        bindSingletonPresenterWidget(InfoPopupPresenterWidget.class, InfoPopupPresenterWidget.MyView.class, InfoPopupView.class);
        bindSingletonPresenterWidget(LocalDialogPresenterWidget.class, LocalDialogPresenterWidget.MyView.class, LocalDialogView.class);
        bindSingletonPresenterWidget(GlobalDialogPresenterWidget.class, GlobalDialogPresenterWidget.MyView.class, GlobalDialogView.class);
    }
}

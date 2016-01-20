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

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ChangeTabHandler;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ChangeTab;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.AsyncCallFailEvent;
import com.gwtplatform.mvp.client.proxy.AsyncCallFailHandler;
import com.gwtplatform.mvp.client.proxy.AsyncCallStartEvent;
import com.gwtplatform.mvp.client.proxy.AsyncCallStartHandler;
import com.gwtplatform.mvp.client.proxy.AsyncCallSucceedEvent;
import com.gwtplatform.mvp.client.proxy.AsyncCallSucceedHandler;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.sagar.restgwt.client.security.CurrentUserChangedEvent;
import com.sagar.restgwt.client.security.CurrentUserChangedHandler;

/**
 * The main {@link com.gwtplatform.mvp.client.Presenter} of the application. It contains a number of tabs allowing
 * access to the various parts of the application. Tabs are refreshed whenever the current user's privileges change in
 * order to hide areas that cannot be accessed.
 */
public class ApplicationPresenter
        extends TabContainerPresenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>
        implements CurrentUserChangedHandler, AsyncCallStartHandler, AsyncCallFailHandler, AsyncCallSucceedHandler {
    /**
     * {@link ApplicationPresenter}'s proxy.
     */
    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    /**
     * {@link ApplicationPresenter}'s view.
     */
    public interface MyView extends TabView {
        void refreshTabs();

        void setTopMessage(String string);
    }

    /**
     * This will be the event sent to our "unknown" child presenters, in order for them to register their tabs.
     */
    @RequestTabs
    public static final Type<RequestTabsHandler> SLOT_REQUEST_TABS = new Type<>();

    /**
     * Fired by child proxie's when their tab content is changed.
     */
    @ChangeTab
    public static final Type<ChangeTabHandler> SLOT_CHANGE_TAB = new Type<>();

    /**
     * Use this in leaf presenters, inside their {@link #revealInParent} method.
     */
    public static final NestedSlot SLOT_TAB_CONTENT = new NestedSlot();

    @Inject
    ApplicationPresenter(EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, SLOT_TAB_CONTENT, SLOT_REQUEST_TABS, SLOT_CHANGE_TAB, RevealType.Root);
    }

    @ProxyEvent
    @Override
    public void onCurrentUserChanged(CurrentUserChangedEvent event) {
        getView().refreshTabs();
    }

    @ProxyEvent
    @Override
    public void onAsyncCallStart(AsyncCallStartEvent event) {
        getView().setTopMessage("Loading...");
    }

    @ProxyEvent
    @Override
    public void onAsyncCallFail(AsyncCallFailEvent event) {
        getView().setTopMessage("Oops, something went wrong...");
    }

    @ProxyEvent
    @Override
    public void onAsyncCallSucceed(AsyncCallSucceedEvent event) {
        getView().setTopMessage(null);
    }
}

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

package com.sagar.restgwt.client.gin;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.annotations.GaAccount;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.sagar.restgwt.client.application.ApplicationModule;
import com.sagar.restgwt.client.place.NameTokens;
import com.sagar.restgwt.client.security.CurrentUser;
import com.sagar.restgwt.client.security.IsAdminGatekeeper;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .defaultPlace(NameTokens.homeNewsPage)
                .errorPlace(NameTokens.homeNewsPage)
                .unauthorizedPlace(NameTokens.homeNewsPage)
                .build());
        install(new ApplicationModule());

        bind(CurrentUser.class).in(Singleton.class);
        bind(IsAdminGatekeeper.class).in(Singleton.class);

        // Google Analytics
        bindConstant().annotatedWith(GaAccount.class).to("UA-8319339-6");

        // Load and inject CSS resources
        bind(ResourceLoader.class).asEagerSingleton();
    }
}

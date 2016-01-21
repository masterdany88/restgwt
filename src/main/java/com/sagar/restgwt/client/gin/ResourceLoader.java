/*
 * Copyright 2015 ArcBees Inc.
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

import javax.inject.Inject;

import com.sagar.restgwt.client.resources.AppResources;
import com.sagar.restgwt.client.resources.DialogResources;
import com.sagar.restgwt.client.resources.TabsResources;

public class ResourceLoader {
    @Inject
    ResourceLoader(
            AppResources resources,
            TabsResources tabsResources,
            DialogResources dialogResources) {
        resources.normalize().ensureInjected();
        resources.style().ensureInjected();
        tabsResources.style().ensureInjected();
        dialogResources.style().ensureInjected();

        // Inject more css into the document here on boot
    }
}
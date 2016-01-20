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

package com.sagar.restgwt.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface TabsResources extends ClientBundle {
    interface Style extends CssResource {
        String tab();

        String inactive();

        @ClassName("tab_inner")
        String tabInner();

        String active();

        String horizontalBar();

        String container();

        String bar();

        String panel();

        String title();

        String titlebar();

        String rounded();
    }

    @Source({"css/variables.gss", "css/tabs.gss"})
    Style style();
}

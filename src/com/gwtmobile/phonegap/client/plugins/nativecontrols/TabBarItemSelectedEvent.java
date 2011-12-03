package com.gwtmobile.phonegap.client.plugins.nativecontrols;

import com.google.gwt.event.shared.GwtEvent;

/* Copyright (c) 2011 Smithimage (Robert Wallström)
 *
 * author: Robert Wallström
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
public class TabBarItemSelectedEvent extends GwtEvent<TabBarItemSelectedEventHandler> {

    private String id;
	private static final Type<TabBarItemSelectedEventHandler> TYPE = new Type<TabBarItemSelectedEventHandler>();

    public TabBarItemSelectedEvent(String id){
        this.id = id;
    }

	public static Type<TabBarItemSelectedEventHandler> getType() {
		return TYPE;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TabBarItemSelectedEventHandler> getAssociatedType() {
		return TYPE;
	}

    @Override
    protected void dispatch(TabBarItemSelectedEventHandler handler) {
        handler.onSelect(this);
    }

    public String getId() {
        return id;
    }
}
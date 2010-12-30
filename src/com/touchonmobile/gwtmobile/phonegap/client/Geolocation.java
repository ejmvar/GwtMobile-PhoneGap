/*
 * Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.touchonmobile.gwtmobile.phonegap.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class Geolocation {
	
	public static native void getCurrentPosition(Callback callback) /*-{
		$wnd.navigator.geolocation.getCurrentPosition(function(position) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Callback::onSuccess(Lcom/touchonmobile/gwtmobile/phonegap/client/Geolocation$Position;)(position);
	    }, function(error) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Callback::onError(Lcom/touchonmobile/gwtmobile/phonegap/client/Geolocation$PositionError;)(error);
	    });
	}-*/;

    public static String watchPosition(Callback callback) {
    	return watchPosition(callback, (JavaScriptObject)null);
	}
	
    public static String watchPosition(Callback callback, Options options) {
    	return watchPosition(callback, options.getOptions());
	}
	
    private static native String watchPosition(Callback callback, JavaScriptObject options) /*-{
	    var id = $wnd.navigator.geolocation.watchPosition(function(position) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Callback::onSuccess(Lcom/touchonmobile/gwtmobile/phonegap/client/Geolocation$Position;)(position);
	    }, function(error) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Geolocation.Callback::onError(Lcom/touchonmobile/gwtmobile/phonegap/client/Geolocation$PositionError;)(error);
	    }, options);
	    return id;
	}-*/;

	public static native void clearWatch(String watchId) /*-{
		$wnd.navigator.geolocation.clearWatch(watchId);
	}-*/;
        

    public interface Callback {
    	void onSuccess(Position position);
    	void onError(PositionError error);
    }
    
    public static class Position extends JavaScriptObject {
    	protected Position() {};
    	
    	public native final Coordinates getCoords() /*-{
			return this.coords;
		}-*/;
	
    	@SuppressWarnings("deprecation")
		public final Date getTimestamp() {
			return new Date(getTimestampNative());
		}	
    	
    	private native final String getTimestampNative() /*-{
			return this.timestamp;
		}-*/;	
    }

    public static class Coordinates extends JavaScriptObject {
    	protected Coordinates() {};
    	
    	public native final double getLatitude() /*-{
			return this.latitude;
		}-*/;
	
    	public native final double getLongitude() /*-{
			return this.longitude;
		}-*/;	

    	public native final double getAltitude() /*-{
			return this.altitude;
		}-*/;	

    	public native final float getAccuracy() /*-{
			return this.accuracy;
		}-*/;	
    	
    	public native final float getAltitudeAccuracy() /*-{
			return this.altitudeAccuracy;
		}-*/;	
    	
    	public native final float getHeading() /*-{
			return this.heading;
		}-*/;	
    	
    	public native final double getSpeed() /*-{
			return this.speed;
		}-*/;	
    }

    public static class PositionError extends JavaScriptObject {
    	protected PositionError() {};
    	
    	public native final String getCode() /*-{
			return this.code;
		}-*/;
	
    	public native final String getMessage() /*-{
			return this.message;
		}-*/;	
    }


    public static class Options {
    	JavaScriptObject options = JavaScriptObject.createObject();
    	
    	public Options frequency(int f) {
    		setFrequency(f, options);
    		return this;
    	}
    	
    	public Options enableHighAccuracy(boolean b) {
    		setEnableHighAccuracy(b, options);
    		return this;
    	}
    	
    	public Options timeout(int t) {
    		setTimeout(t, options);
    		return this;
    	}
    	
    	public Options maximumAge(int a) {
    		setMaximumAge(a, options);
    		return this;
    	}
    	
    	private native JavaScriptObject setFrequency(int f, JavaScriptObject options) /*-{
			options.frequency = f;			
		}-*/;

    	private native JavaScriptObject setEnableHighAccuracy(boolean b, JavaScriptObject options) /*-{
			options.enableHighAccuracy = b;			
		}-*/;

    	private native JavaScriptObject setTimeout(int t, JavaScriptObject options) /*-{
			options.timeout = t;			
		}-*/;

    	private native JavaScriptObject setMaximumAge(int a, JavaScriptObject options) /*-{
			options.maximumAge = a;			
		}-*/;

		private JavaScriptObject getOptions() {
			return options;    		
    	}
    	
    }

}
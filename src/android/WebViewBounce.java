package com.practicegenius.webviewbounce;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.webkit.WebView;

import android.util.Log;
/**
 * Plugin that enables bouncing (rubber band effect iOS like) WebView
 * 
 * @author 
 * 
 */
public class WebViewBounce extends CordovaPlugin 
{
	private static final String TAG = "WebViewBounce";
	
	/**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        Log.v(TAG, "Checking SDK Version: " + Build.VERSION.SDK_INT);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        	if ( 0 != (cordova.getActivity().getApplication().getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE ) ) {
        		Log.v(TAG, "Attempting to enable WebView.setWebContentsDebuggingEnabled");
        		
        		WebView.setWebContentsDebuggingEnabled(true);
            }
        }
    }
}

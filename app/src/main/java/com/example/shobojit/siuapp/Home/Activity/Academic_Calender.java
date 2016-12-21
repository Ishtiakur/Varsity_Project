package com.example.shobojit.siuapp.Home.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aapbd.appbajarlib.notification.BusyDialog;
import com.example.shobojit.siuapp.R;
import com.roger.catloadinglibrary.CatLoadingView;

public class Academic_Calender extends AppCompatActivity {
    WebView wv;
    String url="http://siu.edu.bd/academic-calendar/";
    private Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic__calender);
        wv= (WebView) findViewById(R.id.acwebview);
        cn=this;
        startWebView(url);

    }
    //WebView wv;
    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        wv.setWebViewClient(new WebViewClient() {
            /*ProgressDialog progressDialog;*/
             BusyDialog bd;
            CatLoadingView mView;
            boolean dailogLoading =false;
            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
              /*  if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(cn);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();

                }*/
                if(dailogLoading==false) {
                    /*if (bd == null) {*/
                        if(mView==null){

                        mView = new CatLoadingView();
                        mView.show(getSupportFragmentManager(),"Loading.........");

                        // in standard case YourActivity.this
                      /*  bd = new BusyDialog(cn, true, "Loading.....");
                        bd.show();*/
                        dailogLoading=true;
                    }
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                 /*   if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }*/

                    if(mView!=null){
                        mView.dismiss();
                    }

               /*    bd.dismis();
                    bd=null;*/
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        wv.getSettings().setJavaScriptEnabled(true);

        // Other webview options

	    wv.getSettings().setLoadWithOverviewMode(true);
	    wv.getSettings().setUseWideViewPort(true);
	    wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	    wv.setScrollbarFadingEnabled(false);
	    wv.getSettings().setBuiltInZoomControls(true);


	    /*
	     String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);
	     */

        //Load url in webview
        wv.loadUrl(url);


    }

    // Open previous opened link from history on webview when back button pressed

    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(wv.canGoBack()) {
            wv.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }

    }
}

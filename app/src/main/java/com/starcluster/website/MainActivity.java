package com.starcluster.website;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView;
        MainActivity activity ;

        final ProgressDialog progDailog;

        activity = this;

        progDailog = ProgressDialog.show(activity, "Yükleniyor","Lütfen bekleyin...", true);
        progDailog.setCancelable(false);

        webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        //Gosterilecek websitesinin url sini ekliyoruz
        //Uzantinin http ya da https olduguna dikkat edilmeli
        webView.loadUrl("http://www.ulkeralihan.com");
    }

    //Geri tusuna basildiginda bir onceki sayfaya donmeyi saglar
    @Override
    public void onBackPressed(){
        WebView wv = (WebView)findViewById(R.id.webview);
        if(wv.canGoBack()){
            wv.goBack();
        } else {
            super.onBackPressed();
        }
    }
}



package com.keiko.zodiac;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ZodiacActivity extends AppCompatActivity {


    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);
       // WebView webview = new WebView(this);
        //setContentView(webview);

        String name = getIntent().getStringExtra("Name");


        webview = (WebView)findViewById(R.id.webView);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setInitialScale(150);
        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("http://www.horoskopy.cz/"+name);

    }
}

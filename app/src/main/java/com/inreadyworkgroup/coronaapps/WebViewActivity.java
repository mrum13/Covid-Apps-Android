package com.inreadyworkgroup.coronaapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {
    ProgressBar progressBar;
//    ConstraintLayout webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

//        webView = findViewById(R.id.web_view_root);
//        webView.setVisibility(View.GONE);

        progressBar = findViewById(R.id.webBar);
//        progressBar.setVisibility(View.GONE);

        progressBar.setVisibility(View.VISIBLE);


        WebView web = (WebView) findViewById(R.id.web_view);
        web.setVisibility(View.GONE);
        web.loadUrl("https://kawalcorona.com/");
        web.setWebViewClient(new WebViewClient());

                progressBar.setVisibility(View.GONE);
//        webView.setVisibility(View.VISIBLE);
        web.setVisibility(View.VISIBLE);


    }
}
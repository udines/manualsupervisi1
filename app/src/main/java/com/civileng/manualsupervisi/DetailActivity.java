package com.civileng.manualsupervisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class DetailActivity extends AppCompatActivity {

    private WebView webView;
    private ImageButton homeButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        homeButton = (ImageButton)findViewById(R.id.detail_home);
        backButton = (ImageButton)findViewById(R.id.detail_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(DetailActivity.this, new Intent(getApplicationContext(), StartActivity.class));
            }
        });
        webView = (WebView)findViewById(R.id.detail_webview);
        String url = "file:///android_asset/" + getIntent().getStringExtra("id") + ".html";
        webView.loadUrl(url);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

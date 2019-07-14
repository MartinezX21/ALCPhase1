package com.martin.alc4phase1;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import com.martin.alc4phase1.utils.WebClient;

public class About extends AppCompatActivity {
    private static final String ALC_ABOUT_PAGE_URL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.app_toolbar_about);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        setTitle(R.string.str_about);
        setSupportActionBar(toolbar);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(About.this, R.color.colorBlueSky));

        WebView aboutALCWebView = findViewById(R.id.webview_about);
        aboutALCWebView.getSettings().setJavaScriptEnabled(true);
        aboutALCWebView.getSettings().setAppCacheEnabled(true);
        aboutALCWebView.getSettings().setSupportZoom(true);
        aboutALCWebView.getSettings().setBuiltInZoomControls(true);

        aboutALCWebView.setWebViewClient(new WebClient());
        aboutALCWebView.loadUrl(ALC_ABOUT_PAGE_URL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

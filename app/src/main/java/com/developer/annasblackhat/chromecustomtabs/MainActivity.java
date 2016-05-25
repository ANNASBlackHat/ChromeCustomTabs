package com.developer.annasblackhat.chromecustomtabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGo_Click(View v){
        String url = "https://facebook.com/annas685";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

//        CustomTabsIntent customTabsIntent = builder.build();
//        customTabsIntent.launchUrl(this, Uri.parse(url));

        builder.setToolbarColor(Color.parseColor("#3F51B5"));

        CustomTabsIntent customTabsIntent = builder.build();
        CustomTabActivityHelper.openCustomTab(this, customTabsIntent, Uri.parse(url),
                new CustomTabActivityHelper.CustomTabFallback() {
                    @Override
                    public void openUri(Activity activity, Uri uri) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
    }
}

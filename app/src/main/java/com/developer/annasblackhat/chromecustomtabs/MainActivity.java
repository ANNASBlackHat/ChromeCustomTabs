package com.developer.annasblackhat.chromecustomtabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText edtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = findViewById(R.id.edtUrl);
    }

    public void btnGo_Click(View v) {
        String url = edtUrl.getText().toString().trim();
        if (url.length() > 0) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
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
        } else {
            edtUrl.setError(getString(R.string.hint_enter_website));
            edtUrl.requestFocus();
        }

    }
}

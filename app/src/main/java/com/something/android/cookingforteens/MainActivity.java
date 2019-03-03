package com.something.android.cookingforteens;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
    // времето за което се пуска нашето интро. 2000 = 2 секунди
private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Поставяме съдържанието на MainActivity да използва activity_main.xml като layout file
        setContentView(R.layout.activity_main);

        // този код ни прехвърля към главната страница след като изтече времето = SPLASH_TIME_OUT.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
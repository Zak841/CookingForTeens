package com.something.android.cookingforteens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Поставяме съдържанието на HomeActivity да използва activity_home.xml като layout file
        setContentView(R.layout.activity_home);
    }
    // Всико това се случва при OnClick на някой от заглавияата на нашите раздели
    // Тук се отваря HealthyActivity (страницата със рецептите във Здравословната кухня)
    public void beHealthy (View view) {
        // създаваме Intent, който ни докарва до страницата със Здравословната кухня
        Intent intent = new Intent(this, HealthyActivity.class);
        // раздела се отваря
        startActivity(intent);
    }
    // Тук се отваря  ItalianActivity (страницата със рецептите във Италианската кухня)
    public void beItalian (View view) {
        // създаваме Intent, който ни докарва до страницата със Италианската кухня
        Intent intent = new Intent(this, ItalianActivity.class);
        // раздела се отваря
        startActivity(intent);
    }
    // Тук се отваря AsianActivity (страницата със рецептите във Азиатската кухня)
    public void beAsian (View view) {
        // създаваме Intent, който ни докарва до страницата със Азиатската кухня
        Intent intent = new Intent(this, AsianActivity.class);
        // раздела се отваря
        startActivity(intent);
    }
    // Тук се отваря FrenchActivity (страницата със рецептите във Френската кухния)
    public void beFrench (View view) {
        // създаваме Intent, който ни докарва до страницата със Френската кухния
        Intent intent = new Intent(this, FrenchActivity.class);
        // раздела се отваря
        startActivity(intent);
    }
}

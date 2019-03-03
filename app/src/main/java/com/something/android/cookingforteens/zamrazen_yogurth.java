package com.something.android.cookingforteens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class zamrazen_yogurth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamrazen_yogurth);
    }
    //изпълнява се този код при натискането на бутона "СГОТВИ"
    public void cookingovesenakasha (View view) {
        //води до класа CookingOvesenaKasha, където е нашич списък със задачи.
        Intent intent = new Intent(this, CookingZamrazenYogurth.class);
        startActivity(intent);
    }
}
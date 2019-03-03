package com.something.android.cookingforteens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class supas_aromat_naiztok extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supas_aromat_naiztok);
    }
    //изпълнява се този код при натискането на бутона "СГОТВИ"
    public void cookingovesenakasha (View view) {
        //води до класа CookingOvesenaKasha, където е нашич списък със задачи.
        Intent intent = new Intent(this, CookingSupasAromatnaIztok.class);
        startActivity(intent);
    }
}

package com.something.android.cookingforteens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class shokoladovo_sushi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shokoladovo_sushi);
    }
    //изпълнява се този код при натискането на бутона "СГОТВИ"
    public void cookingovesenakasha (View view) {
        //води до класа, където е нашия списък със задачи.
        Intent intent = new Intent(this, CookingShokoladovoSushi.class);
        startActivity(intent);
    }
}

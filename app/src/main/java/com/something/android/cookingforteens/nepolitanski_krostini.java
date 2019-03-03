package com.something.android.cookingforteens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class nepolitanski_krostini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nepolitanski_krostini);
    }
    public void cookingovesenakasha (View view) {
        //води до класа Cooking(страницата на която сте), където е нашия списък със задачи.
        Intent intent = new Intent(this, CookingNepolitanskiKrostini.class);
        startActivity(intent);
    }
}

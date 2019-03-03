package com.something.android.cookingforteens;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CookingChizkeikAsia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking_chizkeik_asia);
    }
    int RightAnswers = 0;
    // при натискане на бутона започва да проверява дали всчко едно квадратче е отметнато
    public void checkQestion (View view) {
        CheckBox answer1 = (CheckBox) findViewById(R.id.answer1);
        boolean answer = answer1.isChecked();
        CheckBox answer2 = (CheckBox) findViewById(R.id.answer2);
        boolean answer22 = answer2.isChecked();
        CheckBox answer3 = (CheckBox) findViewById(R.id.answer3);
        boolean answer33 = answer3.isChecked();
        CheckBox answer4 = (CheckBox) findViewById(R.id.answer4);
        boolean answer44 = answer4.isChecked();
        CheckBox answer5 = (CheckBox) findViewById(R.id.answer5);
        boolean answer55 = answer5.isChecked();
        CheckBox answer6 = (CheckBox) findViewById(R.id.answer6);
        boolean answer66 = answer6.isChecked();
        CheckBox answer7 = (CheckBox) findViewById(R.id.answer7);
        boolean answer77 = answer7.isChecked();
        CheckQeustions(answer, answer22, answer33, answer44, answer55, answer66, answer77);

        CheckTrueAnswers(RightAnswers);
    }
    //тук става самата проверка
    private void CheckQeustions (boolean answer, boolean answer2, boolean answer3, boolean answer4, boolean answer5, boolean answer6, boolean answer7) {
        if (answer) {
            RightAnswers += 1;
        }
        if (answer2) {
            RightAnswers += 1;
        }
        if (answer3) {
            RightAnswers += 1;
        }
        if (answer4) {
            RightAnswers += 1;
        }
        if (answer5) {
            RightAnswers += 1;
        }
        if (answer6) {
            RightAnswers += 1;
        }
        if (answer7) {
            RightAnswers += 1;
        }
    }
    //тук след като се проверени има различни случай при които могат да попаднат
    private void CheckTrueAnswers (int answer) {
        // първи случай, ако всички квадратчета са отметнати
        if (answer >= 7) {
            // ако този случай е изпълнен, тогава ще даде съобщението "Бон Апети!" и ще те върне отново на рецептата.
            Context context = getApplicationContext();
            CharSequence text = "Бон Апети!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //ето тук става връщането обратно към рецептата
            Intent intent = new Intent(this, chizkeik_asia.class);
            startActivity(intent);
        }
        //втори случай ако едно, две квадратчета не са отметнати
        else if (answer <= 6) {
            // ако този случай е изпълнен, тогава ще даде съобщението "Не си направил всички стъпки!"
            Context context = getApplicationContext();
            CharSequence text = "Не си направил всички стъпки!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            RightAnswers = 0;
        }
    }
}

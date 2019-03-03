package com.something.android.cookingforteens;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AsianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        // Поставяме съдържанието на AsianActivity да използва activity_asian.xml като layout file
        setContentView(R.layout.activity_asian);

        // създаваме ViewPager за нашите рецепти
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Създаваме специален FragmentPagerAdapter(SimpleAsianFragmentAdapter), който ще знае кой Fragment да бъде показан на всяка страница
        SimpleAsianFragmentAdapter adapter = new SimpleAsianFragmentAdapter(getSupportFragmentManager());
        // пъхваме Adapter-а във ViewPgaer-а
        viewPager.setAdapter(adapter);

        // създаване на нашето триразделно меню
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // съединяване на нашето триразделно меню със ViewPager-а
        tabLayout.setupWithViewPager(viewPager);
    }
}
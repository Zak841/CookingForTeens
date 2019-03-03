package com.something.android.cookingforteens;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFrenchFragmentAdapter extends FragmentPagerAdapter {
    public SimpleFrenchFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    // триразделното ни меню
    private String tabTitles[] = new String[]{"Предястие", "Основно ястие", "Десерти"};

    // този код взима позията на страницата на TabLayout
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // и зависимост от позицияата на TabLayout-а се променя и Fragment-а
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FrenchStartCourseFragment();
        } else if (position == 1) {
            return new FrenchMiddleCourseFragment();
        } else {
            return new FrenchEndCourseFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
package com.something.android.cookingforteens;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    public RecipeAdapter(Activity context, ArrayList<Recipe> recipes) {
        // Тук създаваме нашия къстом адаптер с заглавие и снимка
        // Втория параматер е използван, защото имаме само един TextView и ImageView във Recipe.
        // Тъй като ние ще имаме един TextView и ImageView няма да използваме втори аргумент.
        // Така че може да приема всякакви стойности. Тук аз използвах нула.
        super(context, 0, recipes);
    }
    // с този код свързвам информацията от всички Recipe във RecipeAdapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
        }
        // както обясних за всеки един елемент от Recipe ще бъде изполван по един TextView и ImageView
        Recipe currentRecipe = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.text);
        miwokTextView.setText(currentRecipe.getmDefaultTranslation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.img);
        // проверяваме дали има снимка
        if (currentRecipe.hasImage()) {
            iconView.setImageResource(currentRecipe.getImageMiwok());
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            iconView.setVisibility(GONE);
        }
        // тук връщаме информацичта към listItemView за да може да се покажат на ListView
        return listItemView;
    }

}


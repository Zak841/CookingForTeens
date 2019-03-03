package com.something.android.cookingforteens;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ItalianEndCourseFragment extends Fragment{
    public ItalianEndCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.kantuchini_ottoskana),R.drawable.kantuchiniottoskana,new Intent(getActivity(),kantuchini_toskana.class)));
        recipes.add(new Recipe(getString(R.string.panna_cotta),R.drawable.panna_cotta,new Intent(getActivity(),panna_cotta.class)));
        recipes.add(new Recipe(getString(R.string.klasika_tiramisu),R.drawable.klasik_tiramisu,new Intent(getActivity(),klasik_tiramisu.class)));
        recipes.add(new Recipe(getString(R.string.keks_rikota),R.drawable.keks_rikota,new Intent(getActivity(),keks_rikota.class)));
        recipes.add(new Recipe(getString(R.string.torta_kinderpinguin),R.drawable.torta_kinder,new Intent(getActivity(),torta_kinder.class)));
        // вкарваме нашиите recipes във специален RecipeAdapter
        RecipeAdapter adapter = new RecipeAdapter(getActivity(), recipes);

        // ListView за нашите рецепти
        ListView listViewRecipes = (ListView) rootView.findViewById(R.id.list);

        // отогоре е написан код, който за всеки Recipe ще показва по една рецепта в първата страница
        listViewRecipes.setAdapter(adapter);

        listViewRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // ако един от тези Recipe бъде кликнат ще стане това:
                Recipe recipe = recipes.get(position);
                Intent intent = recipe.hasIntent();
                startActivity(intent);
            }
        });
        return rootView;
    }
}
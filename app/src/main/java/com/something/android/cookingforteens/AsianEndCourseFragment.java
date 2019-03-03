package com.something.android.cookingforteens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AsianEndCourseFragment extends Fragment{

    public AsianEndCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.iaponska_torta),R.drawable.aponska_torta,new Intent(getActivity(),iaponska_torta.class)));
        recipes.add(new Recipe(getString(R.string.iaponski_buhtichki),R.drawable.qponski_buhti,new Intent(getActivity(),iaponski_buhtichki.class)));
        recipes.add(new Recipe(getString(R.string.domashni_sladki),R.drawable.qposnki_sladki,new Intent(getActivity(),qponski_sladki.class)));
        recipes.add(new Recipe(getString(R.string.shokoladovo_sushi),R.drawable.shokoladovo_sushi,new Intent(getActivity(),shokoladovo_sushi.class)));
        recipes.add(new Recipe(getString(R.string.cheese_keik_asia),R.drawable.chiizkeik_asian,new Intent(getActivity(),chizkeik_asia.class)));
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


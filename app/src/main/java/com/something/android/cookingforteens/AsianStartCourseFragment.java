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

public class AsianStartCourseFragment extends Fragment{

    public AsianStartCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.aziatsko_zele),R.drawable.aziatsko_zele,new Intent(getActivity(),aziatsko_zele.class)));
        recipes.add(new Recipe(getString(R.string.azistaski_nudul),R.drawable.asiatskanudelsupa,new Intent(getActivity(),aziatska_nudul_supa.class)));
        recipes.add(new Recipe(getString(R.string.aziatska_supa_tikva),R.drawable.asian_soup_tikva,new Intent(getActivity(),asiansoup_tikva.class)));
        recipes.add(new Recipe(getString(R.string.supaaromatnaiztok),R.drawable.supasaromatnaiztrok,new Intent(getActivity(),supas_aromat_naiztok.class)));
        recipes.add(new Recipe(getString(R.string.zeleva_salata),R.drawable.zeleva_slata,new Intent(getActivity(),zeleva_salata.class)));

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


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

public class ItalianStartCourseFragment extends Fragment{
    public ItalianStartCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.nepolitanski_krostini),R.drawable.nepolitanski_krostini,new Intent(getActivity(),nepolitanski_krostini.class)));
        recipes.add(new Recipe(getString(R.string.burzi_brusketi),R.drawable.burzi_brusketi,new Intent(getActivity(),burzi_brusketi.class)));
        recipes.add(new Recipe(getString(R.string.neapolitanska_supa),R.drawable.nepolietanskasupa,new Intent(getActivity(),nepolitanska_supa.class)));
        recipes.add(new Recipe(getString(R.string.pecheni_topki),R.drawable.pecheni_topki,new Intent(getActivity(),pecheni_topki.class)));
        recipes.add(new Recipe(getString(R.string.salata_ot_rukola),R.drawable.salata_rukola,new Intent(getActivity(),salata_rukola.class)));

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
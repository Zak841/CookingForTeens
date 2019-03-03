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

public class AsianMiddleCourseFragment extends Fragment{

    public AsianMiddleCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.aziastski_diuner),R.drawable.aziastski_diuner,new Intent(getActivity(),aziastski_diuner.class)));
        recipes.add(new Recipe(getString(R.string.teriaki_shishcheta),R.drawable.teriaki_shishcheta,new Intent(getActivity(),teriaki_shishcheta.class)));
        recipes.add(new Recipe(getString(R.string.avtentichno_pilevkiselsos),R.drawable.pilevsladkokislesos,new Intent(getActivity(),avtentichno_pile.class)));
        recipes.add(new Recipe(getString(R.string.pile_zelenchuci),R.drawable.pile_sus_zelenchuci,new Intent(getActivity(),pile_zelenchuci.class)));
        recipes.add(new Recipe(getString(R.string.skaridi_purjen_oriz),R.drawable.skaradi_oriz,new Intent(getActivity(),skaridi_purjenoriz.class)));

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

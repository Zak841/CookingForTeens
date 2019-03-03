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

public class EndHealthyFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static StartHealthyFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        StartHealthyFragment fragment = new StartHealthyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public EndHealthyFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.zdravosloven_sladkish),R.drawable.zdravosloven_sladkish,new Intent(getActivity(),zdravosloven_sladkish.class)));
        recipes.add(new Recipe(getString(R.string.barcheta),R.drawable.barcheta_mnogozarnesti,new Intent(getActivity(),barcheta_mnogozarnesti.class)));
        recipes.add(new Recipe(getString(R.string.zdravosloven_keks),R.drawable.zdravosloven_qbolkov_keks,new Intent(getActivity(),qbolkov_keks.class)));
        recipes.add(new Recipe(getString(R.string.zdravoslovni_bonboni),R.drawable.zdravoslovni_bonboni,new Intent(getActivity(),zdravoslovni_bonboni.class)));
        recipes.add(new Recipe(getString(R.string.plodov_proteinov_sladkish),R.drawable.plodov_sladkish,new Intent(getActivity(),proteinov_sladkish.class)));
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



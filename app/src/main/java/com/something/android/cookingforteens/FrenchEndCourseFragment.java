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

public class FrenchEndCourseFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static StartHealthyFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        StartHealthyFragment fragment = new StartHealthyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FrenchEndCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.leko_briule),R.drawable.leko_briule,new Intent(getActivity(),leko_briule.class)));
        recipes.add(new Recipe(getString(R.string.frenski_makaroni),R.drawable.frenski_makaroni,new Intent(getActivity(),frenski_makaroni.class)));
        recipes.add(new Recipe(getString(R.string.briosh),R.drawable.briosh,new Intent(getActivity(),briosh.class)));
        recipes.add(new Recipe(getString(R.string.galet_s_iabulki),R.drawable.galets_iabulki,new Intent(getActivity(),galet_iabulki.class)));
        recipes.add(new Recipe(getString(R.string.sorbegorski_plodove),R.drawable.sorbe_gorski_plodove,new Intent(getActivity(),sorbe_gorskiplodove.class)));

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


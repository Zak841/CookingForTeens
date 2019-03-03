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

public class MiddleHealthyFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static StartHealthyFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        StartHealthyFragment fragment = new StartHealthyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MiddleHealthyFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.bogatomletsusspanak),R.drawable.bogat_omlet,new Intent(getActivity(),bogat_omlet.class)));
        recipes.add(new Recipe(getString(R.string.file_siomga),R.drawable.filesiomga,new Intent(getActivity(),file_siomga.class)));
        recipes.add(new Recipe(getString(R.string.proletnasalata_portokal),R.drawable.proletna_salata,new Intent(getActivity(),proletna_salata.class)));
        recipes.add(new Recipe(getString(R.string.lefer_furna),R.drawable.lefer_na_furna,new Intent(getActivity(),lefer_furna.class)));
        recipes.add(new Recipe(getString(R.string.pechenhek_bqlovino),R.drawable.pechen_hek,new Intent(getActivity(),pechen_hek.class)));
        recipes.add(new Recipe(getString(R.string.zapekanka_kinoa),R.drawable.zapekanka,new Intent(getActivity(),zapekanka.class)));

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


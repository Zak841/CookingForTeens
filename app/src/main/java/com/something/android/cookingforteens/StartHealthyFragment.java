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

public class StartHealthyFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static StartHealthyFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        StartHealthyFragment fragment = new StartHealthyFragment();
        fragment.setArguments(args);
        return fragment;
    }

        public StartHealthyFragment() {
            // Нуждаем се от празен конструктор
        }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.word_list, container, false);
            final ArrayList<Recipe> recipes = new ArrayList();
            recipes.add(new Recipe(getString(R.string.ovesena_kasha),R.drawable.ovesena_kasha,new Intent(getActivity(),ovesena_kasha.class)));
            recipes.add(new Recipe(getString(R.string.kasha_ot_proso),R.drawable.kasha_ot_proso,new Intent(getActivity(),kasha_ot_proso.class)));
            recipes.add(new Recipe(getString(R.string.zamrazenjoghyrt_bezzahar),R.drawable.zamrazen_joghurty,new Intent(getActivity(),zamrazen_yogurth.class)));
            recipes.add(new Recipe(getString(R.string.solena_torta),R.drawable.solena_torta_kafiol_parmezan1,new Intent(getActivity(),solena_torta.class)));

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


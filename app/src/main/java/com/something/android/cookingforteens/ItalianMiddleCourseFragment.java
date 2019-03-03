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

public class ItalianMiddleCourseFragment extends Fragment{
    public ItalianMiddleCourseFragment() {
        // Нуждаем се от празен конструктор
    }

    // създаваме custom ArrayList, който съдържа заглавие(String), снимка (int) и OnCliclListener(Intent)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Recipe> recipes = new ArrayList();
        recipes.add(new Recipe(getString(R.string.zapecheno_pile_florenski),R.drawable.zapecheno_pile_florenski,new Intent(getActivity(),zapecheno_pile_florenski.class)));
        recipes.add(new Recipe(getString(R.string.qica_florentinski),R.drawable.qica_florentinski,new Intent(getActivity(),qica_florentinski.class)));
        recipes.add(new Recipe(getString(R.string.ravioli_s_kartofi),R.drawable.ravioliskartofi,new Intent(getActivity(),ravioli_kartofi.class)));
        recipes.add(new Recipe(getString(R.string.rizoto_shafran),R.drawable.rizoto_s_shafran,new Intent(getActivity(),rizoto_shafran.class)));
        recipes.add(new Recipe(getString(R.string.lazanq_gotovi_kori),R.drawable.lazaniq,new Intent(getActivity(),lazanq_gotovikori.class)));

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
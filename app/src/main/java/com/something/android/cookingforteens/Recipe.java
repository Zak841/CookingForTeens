package com.something.android.cookingforteens;

import android.content.Intent;

public class Recipe {
    // това екода за моя къстом Recipe
    // създаваме нашите три атрибута, които искаме да вакараме в една рецепта
    private Intent buttonche;
    private String TitleRecipe;
    // този код го използваме за да знаем дали има снимка
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED = -1;

    // конструкторa
    public Recipe(String RealTitleRecipe, int imageResourceId, Intent buttonche2) {
        TitleRecipe = RealTitleRecipe;
        mImageResourceId = imageResourceId;
        buttonche = buttonche2;
    }

    // код, които ще ни трабва за да вграждаме цялата информация от Recipe във RecipeAdapter
    public Intent hasIntent() {return buttonche;}
    public int getImageMiwok() {
        return mImageResourceId;
    }

    public String getmDefaultTranslation() {return TitleRecipe;}


    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
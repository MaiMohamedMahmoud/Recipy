package com.example.mac_os.dailyrecipes.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mac-os on 4/21/18.
 */

public class RecipesRespond {

    @SerializedName("recipes")
    private List<Recipe> recipes;

    public RecipesRespond(List<Recipe> recipes) {

        this.recipes = recipes;
    }

    public List<Recipe> getResults() {
        return recipes;
    }

    public void setResults(List<Recipe> results) {
        this.recipes = results;
    }
}

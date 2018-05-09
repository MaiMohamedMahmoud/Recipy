package com.example.mac_os.dailyrecipes.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mac-os on 4/21/18.
 */

public class Category {

    @SerializedName("name")
    private String name;

    @SerializedName("recipes")
    private List<Recipe> recipes;

    public Category(String name, List<Recipe> recipes) {
        this.name= name;
        this.recipes = recipes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getResults() {
        return recipes;
    }

    public void setResults(List<Recipe> results) {
        this.recipes = results;
    }
}

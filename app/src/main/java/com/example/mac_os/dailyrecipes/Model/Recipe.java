package com.example.mac_os.dailyrecipes.Model;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mac-os on 4/21/18.
 */

public class  Recipe
{
    @SerializedName("title")
    private String tilte;
    @SerializedName("description")
    private String description;
    @SerializedName("category")
    private String category;
    @SerializedName("preparation_time")
    private String preparationTime;
    @SerializedName("cooking_time")
    private String cookingTime;
    @SerializedName("main_image")
    private String mainImage;



    public Recipe(String tilte, String description, String category, String preparationTime, String cookingTime, String mainImage) {
        this.tilte = tilte;
        this.description = description;
        this.category = category;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.mainImage = mainImage;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }



}

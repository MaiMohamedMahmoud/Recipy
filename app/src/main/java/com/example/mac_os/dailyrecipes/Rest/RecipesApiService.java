package com.example.mac_os.dailyrecipes.Rest;

import com.example.mac_os.dailyrecipes.Model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mac-os on 4/21/18.
 */

public interface RecipesApiService {
    @GET("bins/hh12a")
    Call<List<Recipe>> getRecipes();
}

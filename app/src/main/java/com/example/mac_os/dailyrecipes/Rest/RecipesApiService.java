package com.example.mac_os.dailyrecipes.Rest;

import com.example.mac_os.dailyrecipes.Model.Recipe;
import com.example.mac_os.dailyrecipes.Model.RecipesRespond;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mac-os on 4/21/18.
 */

public interface RecipesApiService {

    @GET("bins/16nrpt")
    Call<RecipesRespond> getRecipes();
}

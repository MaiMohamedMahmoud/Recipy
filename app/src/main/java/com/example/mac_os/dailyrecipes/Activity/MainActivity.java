package com.example.mac_os.dailyrecipes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mac_os.dailyrecipes.Adapters.RecipesAdapter;
import com.example.mac_os.dailyrecipes.Model.Recipe;
import com.example.mac_os.dailyrecipes.Model.RecipesRespond;
import com.example.mac_os.dailyrecipes.R;
import com.example.mac_os.dailyrecipes.Rest.RecipesApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "https://api.myjson.com/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;
    private final static String API_KEY = "9684e8c38d4fdd3e869d83a6df191baa";
    List<Recipe> recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectAndGetApiData();
    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        RecipesApiService recipeApiService = retrofit.create(RecipesApiService.class);
        Call<RecipesRespond> call = recipeApiService.getRecipes();
        call.enqueue(new Callback<RecipesRespond>(){

            @Override
            public void onResponse(Call<RecipesRespond> call, Response<RecipesRespond> response) {
                recipes = response.body().getResults();

                recyclerView.setAdapter(new RecipesAdapter(recipes, R.layout.list_item_recipe, getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + recipes.size());
            }

            @Override
            public void onFailure(Call<RecipesRespond> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        } );



    }
}


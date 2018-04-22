package com.example.mac_os.dailyrecipes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mac_os.dailyrecipes.Adapters.RecipesAdapter;
import com.example.mac_os.dailyrecipes.Model.MyDeserializer;
import com.example.mac_os.dailyrecipes.Model.Recipe;
import com.example.mac_os.dailyrecipes.Model.RecipesRespond;
import com.example.mac_os.dailyrecipes.R;
import com.example.mac_os.dailyrecipes.Rest.RecipesApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

            Gson gson= new GsonBuilder()
                     .registerTypeAdapter(List.class, new MyDeserializer<List<Recipe>>())
                     .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        RecipesApiService recipeApiService = retrofit.create(RecipesApiService.class);
        Call<List<Recipe>> call = recipeApiService.getRecipes();
        call.enqueue(new Callback<List<Recipe>>(){

            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                recipes = response.body();

                recyclerView.setAdapter(new RecipesAdapter(recipes, R.layout.list_item_recipe, getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + recipes.size());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        } );



    }
}


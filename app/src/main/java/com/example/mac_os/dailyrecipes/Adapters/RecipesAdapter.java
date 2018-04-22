package com.example.mac_os.dailyrecipes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mac_os.dailyrecipes.Model.Recipe;
import com.example.mac_os.dailyrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by mac-os on 4/21/18.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {
    private ArrayList<Recipe> recipesArray;
    private List<Recipe> recipes;
    private int rowLayout;
    private Context context;
    public RecipesAdapter(List<Recipe> recipes, int rowLayout, Context context) {
        this.recipes = recipes;
        this.rowLayout = rowLayout;
        this.context = context;
        this.recipesArray = new ArrayList<Recipe>();
        this.recipesArray.addAll(recipes);
    }
    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        LinearLayout recipesLayout;
        TextView recipeTitle;
        TextView preparationDate;
        TextView recipeDescription;
        //TextView rating;
        ImageView getMainImage;
        public RecipeViewHolder(View v) {
            super(v);
            recipesLayout = (LinearLayout) v.findViewById(R.id.recipe_layout);
            getMainImage = (ImageView) v.findViewById(R.id.recipe_image);
            recipeTitle = (TextView) v.findViewById(R.id.title);
            preparationDate = (TextView) v.findViewById(R.id.date);
            recipeDescription = (TextView) v.findViewById(R.id.description);
           // rating = (TextView) v.findViewById(R.id.rating);
        }
    }
    @Override
    public RecipesAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RecipeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        String image_url =  recipes.get(position).getMainImage();
        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.getMainImage);
        holder.recipeTitle.setText(recipes.get(position).getTilte());
//        holder.preparationDate.setText(recipes.get(position).getPreparationTime());
//        holder.recipeDescription.setText(recipes.get(position).getDescription());
        //holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }
    @Override
    public int getItemCount() {
        return recipes.size();
    }


    public List<Recipe> filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        recipes.clear();
        if (charText.length() == 0) {
            recipes.addAll(recipesArray);
        } else {
            for (Recipe wp : recipesArray) {
                if (wp.getTilte().toLowerCase(Locale.getDefault()).contains(charText)) {
                    recipes.add(wp);
                }
            }
        }
        notifyDataSetChanged();
        return recipes;
    }
}

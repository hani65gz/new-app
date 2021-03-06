package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import android.text.TextUtils;
import android.view.View;


public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView ingredientsIv = findViewById(R.id.image_iv);
        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }
        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }
        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);
        setTitle(sandwich.getMainName());
    }
    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {

        TextView mainNameTv  = findViewById(R.id.main_name_tv);
        mainNameTv.setText(sandwich.getMainName());
        TextView alsoknownTv  = findViewById(R.id.also_known_tv);
        TextView alsoknownas  = findViewById(R.id.also_known_as);
        String rd = TextUtils.join(",", sandwich.getAlsoKnownAs());
        if (TextUtils.isEmpty(rd)) {
            alsoknownas.setVisibility(View.GONE);
            alsoknownTv.setVisibility(View.GONE);
        }
        alsoknownTv  .setText(rd);

        TextView originTv  = findViewById(R.id.origin_tv);
        TextView placeoforigin  = findViewById(R.id.place_of_origin);
        if (TextUtils.isEmpty(sandwich.getPlaceOfOrigin())) {
            originTv  .setVisibility(View.GONE);
            placeoforigin  .setVisibility(View.GONE);}
        originTv      .setText(sandwich.getPlaceOfOrigin());

        TextView descriptionTv  = findViewById(R.id.description_tv);
        descriptionTv.setText(sandwich.getDescription());

        TextView ingredientsTv  = findViewById(R.id.ingredients_tv);
            for (int i = 1; i < sandwich.getIngredients().size(); i++) {
                ingredientsTv.append("\n" + i + " - " + sandwich.getIngredients().get(i) + " .");
            }
    }
}






package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json)   {

        try {


        JSONObject jsonObject = new JSONObject(json);

        JSONObject jsonName = jsonObject.getJSONObject("name");

        String mainName = jsonName.getString("mainName");

        List<String> alsoKnownAs = new ArrayList<>();
        JSONArray jsonAlsoKnownAs = jsonName.getJSONArray("alsoKnownAs");

        for (int i = 0; i < jsonAlsoKnownAs.length(); i++) {
            alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
        }

        JSONObject jsonplaceOfOrigin = jsonObject.getJSONObject("placeOfOrigin");
        String placeOfOrigin = jsonName.getString("placeOfOrigin");

        JSONObject jsondescription =  jsonObject.getJSONObject("description");
        String description = jsonName.getString("description");

        JSONObject jsonimage =  jsonObject.getJSONObject("image");
        String image = jsonName.getString("image");

        List<String> ingredients = new ArrayList<>();
        JSONArray jsoningredients = jsonName.getJSONArray("ingredients");

        for (int i = 0; i < jsoningredients.length(); i++) {
            ingredients.add(jsoningredients.getString(i));
        }}

    catch (JSONException e){e.printStackTrace();

    } return Sandwich; }
        }





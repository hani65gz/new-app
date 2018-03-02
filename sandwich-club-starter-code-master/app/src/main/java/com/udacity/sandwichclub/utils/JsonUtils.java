package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
public class JsonUtils {
    public static final String NAME = "name";
    public static final String INGREDIENTS = "ingredients";
    public static final String ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String MAIN_NAME = "mainName";
    public static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static Sandwich parseSandwichJson(String json)   {
        Sandwich sandwich = null;
        try {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject jsonName = jsonObject.getJSONObject("name");
        String mainName = jsonName.getString("mainName");
        List<String> alsoKnownAs = new ArrayList<>();
        JSONArray jsonAlsoKnownAs = jsonName.getJSONArray("alsoKnownAs");
        for (int i = 0; i < jsonAlsoKnownAs.length(); i++) {
            alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
        }
        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        List<String> ingredients = new ArrayList<>();
        JSONArray jsoningredients = jsonObject.getJSONArray("ingredients");
        for (int i = 0; i < jsoningredients.length(); i++) {
            ingredients.add(jsoningredients.getString(i));
            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }}
    catch (JSONException e){e.printStackTrace();
    }
 return  sandwich;
        }
}





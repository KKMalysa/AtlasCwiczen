package com.example.atlascwiczen;

import android.content.Context;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Locale;

public class AtlasCwiczenObject implements Serializable {

    //3 pola obowiązkowe
    private String name;
    private String text;
    private String image;
    //2 pola opcjonalne
    private String video;
    private AtlasCwiczenObject[] przyrzady;

    public AtlasCwiczenObject(String name) {
        this.name = name;
    }

    public AtlasCwiczenObject(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        image = String.format("images/%s.jpg", name.toLowerCase()); //name.toLowerCase(Locale.ROOT)
        text = String.format("texts/%s.jpg", name.toLowerCase()); //name.toLowerCase(Locale.ROOT)
        video = jsonObject.optString("video");
        JSONArray przyrzady = jsonObject.optJSONArray("przyrzady");
        if(przyrzady !=null){
            this.przyrzady = getAtlasCwiczenObjectsFromJsonArray(przyrzady);
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public AtlasCwiczenObject[] getPrzyrzady() {
        return przyrzady;
    }

    public void setPrzyrzady(AtlasCwiczenObject[] przyrzady) {
        this.przyrzady = przyrzady;
    }

    /**
     * ładuje plik json
     * przetwarza jeden po drugim obiekty jsonowe w atlasCwiczenObjects
     * @param context
     * @param type
     * @return tablice obiektow, a jak sie nie uda, to pustą tablice
     */
    public static AtlasCwiczenObject[] loadArrayFromJson(Context context, String type) {
        try {
            String json = loadStringFromAssets(context, "atlasCwiczen.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(type);

      //      AtlasCwiczenObject[] atlasCwiczenObjects = getAtlasCwiczenObjectsFromJsonArray(jsonArray);

            return getAtlasCwiczenObjectsFromJsonArray(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new AtlasCwiczenObject[0];
    }

    @NonNull
    private static AtlasCwiczenObject[] getAtlasCwiczenObjectsFromJsonArray(JSONArray jsonArray) throws JSONException {
        AtlasCwiczenObject[] atlasCwiczenObjects = new AtlasCwiczenObject[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++){
            AtlasCwiczenObject atlasCwiczenObject = new AtlasCwiczenObject(jsonArray.getJSONObject(i));
            atlasCwiczenObjects[i] = atlasCwiczenObject;
        }
        return atlasCwiczenObjects;
    }

    /**
     * metoda wczytuje cały plik i zwraca go jako Stringa w UTF-8, żeby obsłużył polskie znaki
     * @param context
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String loadStringFromAssets(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];

        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer, "UTF-8");

    }

    public boolean hasPrzyrzad() {
        return przyrzady != null && przyrzady.length >0;
    }
}

package com.json;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    private static OkHttpClient client = new OkHttpClient();

    /**
     *
     * @Return String
     */
    public static void main(String args[]) {
        for(String str : getUserData()){
            System.out.println(str);
        }
    }

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    /**
     * Get user data
     * @return string
     */
    public static String[] getUserData() {
        String json = null;
        try {
            json = getJSON("http://www.fotocourtesy.com/rest/country/countryList");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        CountryDetails country = gson.fromJson(json, CountryDetails.class);
        Country[] c = country.getCountry();
        for(int i=0;i<c.length;i++)
            System.out.println("+" + c[i].getCountryCode() + " " + c[i].getCountryName());
        return new String[]{
                "Code : " + country.getCode(),
                "Count : " + country.getCount(),

        };
    }


}

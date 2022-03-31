package com.inreadyworkgroup.coronaapps.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://covid19.kuningankab.go.id/api/";
//    public static final String BASE_URL = "http://blynk-cloud.com/pS-jNmv5TdZPIVTEi6TXPKkHf_4j1-fu/get/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

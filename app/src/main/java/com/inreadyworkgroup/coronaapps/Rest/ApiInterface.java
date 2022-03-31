package com.inreadyworkgroup.coronaapps.Rest;

import com.inreadyworkgroup.coronaapps.Model.Covid;
import com.inreadyworkgroup.coronaapps.Model.GetCovid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("latest")
    Call<Covid[]> getCovidIndonesia();

    @GET("malaysia")
    Call<Covid[]> getCovidMalaysia();

    @GET("v2")
    Call<List<String>> getSingleData();
}

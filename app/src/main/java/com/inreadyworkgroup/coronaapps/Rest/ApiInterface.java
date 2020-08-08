package com.inreadyworkgroup.coronaapps.Rest;

import com.inreadyworkgroup.coronaapps.Model.Covid;
import com.inreadyworkgroup.coronaapps.Model.GetCovid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("indonesia")
    Call<Covid[]> getCovid();
}

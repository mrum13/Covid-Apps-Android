package com.inreadyworkgroup.coronaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.coronaapps.Model.Covid;
import com.inreadyworkgroup.coronaapps.Model.Covid;
import com.inreadyworkgroup.coronaapps.Rest.ApiClient;
import com.inreadyworkgroup.coronaapps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnCari;
    ApiInterface mApiInterface;
    TextView postif,meniggal,sembuh,dirawat;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        postif = findViewById(R.id.tv_positif);
        meniggal = findViewById(R.id.tv_meninggal);
        sembuh = findViewById(R.id.tv_sembuh);
        dirawat = findViewById(R.id.tv_dirawat);
        progressBar = findViewById(R.id.indeterminateBar);
        progressBar.setVisibility(View.GONE);

        btnCari = (Button) findViewById(R.id.btn_cari);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    public void refresh() {
        progressBar.setVisibility(View.VISIBLE);
        Call<Covid[]> kontakCall = mApiInterface.getCovid();
        kontakCall.enqueue(new Callback<Covid[]>() {
            @Override
            public void onResponse(Call<Covid[]> call, Response<Covid[]> response) {
               Covid[] gc =  response.body();

                postif.setText(gc[0].getPositif());
                meniggal.setText(gc[0].getMeninggal());
                sembuh.setText(gc[0].getSembuh());
                dirawat.setText(gc[0].getDirawat());
//                List<Covid> KontakList = response.body().getListDataKontak();
//                Log.d("Retrofit Get", "Jumlah data Kontak: " +
//                        String.valueOf(KontakList.size()));
//
//                mAdapter = new KontakAdapter(KontakList);
//                mRecyclerView.setAdapter(mAdapter);

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Covid[]> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
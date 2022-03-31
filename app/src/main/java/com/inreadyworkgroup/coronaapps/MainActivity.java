package com.inreadyworkgroup.coronaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.coronaapps.Model.Covid;
import com.inreadyworkgroup.coronaapps.Model.GetCovid;
import com.inreadyworkgroup.coronaapps.Rest.ApiClient;
import com.inreadyworkgroup.coronaapps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Button btnCari,btnWebView;
    ApiInterface mApiInterface;
    TextView postif,meniggal,sembuh,dirawat,tvJudul;
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
        tvJudul = findViewById(R.id.judul);

        progressBar.setVisibility(View.GONE);


        btnCari = (Button) findViewById(R.id.btn_cari);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });

        btnWebView = (Button) findViewById(R.id.btn_webView);
        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keWeb = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(keWeb);
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
////        new Handler().postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                refresh();
////            }
////        }, 1000);
//
//    }

    public void refresh() {
        progressBar.setVisibility(View.VISIBLE);
        Call<Covid[]> kontakCall = mApiInterface.getCovidIndonesia();
        kontakCall.enqueue(new Callback<Covid[]>() {
            @Override
            public void onResponse(Call<Covid[]> call, Response<Covid[]> response) {
              Covid[] gc =  response.body();
                postif.setText(gc[0].getPositif());
                meniggal.setText(gc[0].getMeninggal());
                sembuh.setText(gc[0].getSembuh());
//                dirawat.setText(gc[0].getDirawat());
//                List<Covid> KontakList = response.body().getListDataKontak();
//                Log.d("Retrofit Get", "Jumlah data Kontak: " +
//                        String.valueOf(KontakList.size()));
//
//                mAdapter = new KontakAdapter(KontakList);
//                mRecyclerView.setAdapter(mAdapter);

                Toast.makeText(MainActivity.this, "get berhasil", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Covid[]> call, Throwable t) {
                tvJudul.setText("Get Data Gagal");
                Toast.makeText(MainActivity.this, "get gagal", Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Get", t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
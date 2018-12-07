package com.reynaldiwijaya.googlenews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.reynaldiwijaya.googlenews.adapter.AdapterBerita;
import com.reynaldiwijaya.googlenews.network.ApiService;
import com.reynaldiwijaya.googlenews.network.ConfigRetrofit;
import com.reynaldiwijaya.googlenews.responseapi.ArticlesItem;
import com.reynaldiwijaya.googlenews.responseapi.ResponseBerita;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tampilBerita();
    }

    private void tampilBerita() {
        final ProgressDialog dialog = ProgressDialog.show(this, "Get Data", "Loading");

        ConfigRetrofit config = new ConfigRetrofit();
        ApiService api = config.service;

        api.getBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                Log.i("Debug", response.message());

                if (response.isSuccessful()){
                    String status = response.body().getStatus();
                    dialog.dismiss();

                    if (status.equals(status)){
                        ResponseBerita dataSemua = response.body();

                        List<ArticlesItem> dataBerita = dataSemua.getArticles();

                        AdapterBerita adapterBerita = new AdapterBerita(MainActivity.this, dataBerita);

                        recyclerview.setHasFixedSize(true);
                        recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerview.setAdapter(adapterBerita);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Debug", t.getMessage());

            }
        });
    }
}

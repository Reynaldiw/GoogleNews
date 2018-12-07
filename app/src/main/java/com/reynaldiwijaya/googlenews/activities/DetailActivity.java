package com.reynaldiwijaya.googlenews.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reynaldiwijaya.googlenews.R;
import com.reynaldiwijaya.googlenews.model.BeritaModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_OBJ = "obj";
    @BindView(R.id.imgGambarBerita)
    ImageView imgGambarBerita;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.txtTanggalTerbit)
    TextView txtTanggalTerbit;
    @BindView(R.id.txtPenulis)
    TextView txtPenulis;
    @BindView(R.id.txtBerita)
    TextView txtBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BeritaModel beritaModel = getIntent().getParcelableExtra(EXTRA_OBJ);

        String judul = beritaModel.getJudul();
        String penulis = beritaModel.getPenulis();
        String tanggalPosting = beritaModel.getTanggalPosting();
        String isiBerita = beritaModel.getIsiBerita();
        String fotoBerita = beritaModel.getFotoBerita();

        getSupportActionBar().setTitle(judul);

        txtPenulis.setText(penulis);
        txtTanggalTerbit.setText(tanggalPosting);
        txtBerita.setText(isiBerita);

        Glide.with(this).load(fotoBerita).into(imgGambarBerita);
    }
}

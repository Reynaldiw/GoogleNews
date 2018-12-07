package com.reynaldiwijaya.googlenews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reynaldiwijaya.googlenews.MainActivity;
import com.reynaldiwijaya.googlenews.R;
import com.reynaldiwijaya.googlenews.activities.DetailActivity;
import com.reynaldiwijaya.googlenews.model.BeritaModel;
import com.reynaldiwijaya.googlenews.responseapi.ArticlesItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> {
    Context context;
    List<ArticlesItem> berita;

    public AdapterBerita(Context context, List<ArticlesItem> berita) {
        this.context = context;
        this.berita = berita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.berita_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtPenulis.setText(berita.get(i).getAuthor());
        viewHolder.txtJuduBerita.setText(berita.get(i).getTitle());
        viewHolder.txtTanggal.setText(berita.get(i).getPublishedAt());
        viewHolder.txtDeskripsi.setText(berita.get(i).getDescription());
        Glide.with(context).load(berita.get(i).getUrlToImage()).into(viewHolder.imgGambarBerita);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);

                BeritaModel beritaModel = new BeritaModel();

                beritaModel.setJudul(berita.get(i).getTitle());
                beritaModel.setPenulis(berita.get(i).getAuthor());
                beritaModel.setTanggalPosting(berita.get(i).getPublishedAt());
                beritaModel.setFotoBerita(berita.get(i).getUrlToImage());
                beritaModel.setIsiBerita(berita.get(i).getContent());

                pindah.putExtra(DetailActivity.EXTRA_OBJ, beritaModel);
                context.startActivity(pindah);
            }
        });



    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgGambarBerita)
        ImageView imgGambarBerita;
        @BindView(R.id.txtJuduBerita)
        TextView txtJuduBerita;
        @BindView(R.id.txtTanggal)
        TextView txtTanggal;
        @BindView(R.id.txtPenulis)
        TextView txtPenulis;
        @BindView(R.id.txtDeskripsi)
        TextView txtDeskripsi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

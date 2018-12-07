package com.reynaldiwijaya.googlenews.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeritaModel implements Parcelable {

    String judul;
    String penulis;
    String tanggalPosting;
    String isiBerita;
    String fotoBerita;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTanggalPosting() {
        return tanggalPosting;
    }

    public void setTanggalPosting(String tanggalPosting) {
        this.tanggalPosting = tanggalPosting;
    }

    public String getIsiBerita() {
        return isiBerita;
    }

    public void setIsiBerita(String isiBerita) {
        this.isiBerita = isiBerita;
    }

    public String getFotoBerita() {
        return fotoBerita;
    }

    public void setFotoBerita(String fotoBerita) {
        this.fotoBerita = fotoBerita;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    String deskripsi;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.penulis);
        dest.writeString(this.tanggalPosting);
        dest.writeString(this.isiBerita);
        dest.writeString(this.fotoBerita);
        dest.writeString(this.deskripsi);
    }

    public BeritaModel() {
    }

    protected BeritaModel(Parcel in) {
        this.judul = in.readString();
        this.penulis = in.readString();
        this.tanggalPosting = in.readString();
        this.isiBerita = in.readString();
        this.fotoBerita = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<BeritaModel> CREATOR = new Creator<BeritaModel>() {
        @Override
        public BeritaModel createFromParcel(Parcel source) {
            return new BeritaModel(source);
        }

        @Override
        public BeritaModel[] newArray(int size) {
            return new BeritaModel[size];
        }
    };
}

package com.example.joao.prova1listagemcinema.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joao on 12/09/2017.
 */

public class Ator implements Parcelable {

    private int imageId;

    private String nome;

    public Ator() {

    }

    public Ator(int imageId, String nome) {
        this.imageId = imageId;
        this.nome = nome;
    }

    private Ator(Parcel in) {
        imageId = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Ator> CREATOR = new Creator<Ator>() {
        @Override
        public Ator createFromParcel(Parcel in) {
            return new Ator(in);
        }

        @Override
        public Ator[] newArray(int size) {
            return new Ator[size];
        }
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Ator: " + nome + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ator ator = (Ator) o;

        if (imageId != ator.imageId) return false;
        return nome.equals(ator.nome);

    }

    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + nome.hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(nome);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

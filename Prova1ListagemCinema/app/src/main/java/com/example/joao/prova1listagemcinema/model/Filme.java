package com.example.joao.prova1listagemcinema.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joao on 12/09/2017.
 */
public class Filme implements Parcelable {

    private int imageId;

    private String nomeDiretor;

    private String genero;

    private String nacionalidade;

    private String sinopse;

    private List<Ator> elenco;

    public Filme(int imageId, String nomeDiretor, String genero, String nacionalidade, String sinopse) {
        this.imageId = imageId;
        this.nomeDiretor = nomeDiretor;
        this.genero = genero;
        this.nacionalidade = nacionalidade;
        this.sinopse = sinopse;
    }

    private Filme(Parcel in) {
        imageId = in.readInt();
        nomeDiretor = in.readString();
        genero = in.readString();
        nacionalidade = in.readString();
        sinopse = in.readString();
        elenco = new ArrayList<>();
        in.readTypedList(elenco, Ator.CREATOR);
    }

    public static final Creator<Filme> CREATOR = new Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(nomeDiretor);
        dest.writeString(genero);
        dest.writeString(nacionalidade);
        dest.writeString(sinopse);
        dest.writeTypedList(elenco);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }

}

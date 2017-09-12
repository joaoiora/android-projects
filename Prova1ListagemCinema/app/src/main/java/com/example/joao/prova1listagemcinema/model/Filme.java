package com.example.joao.prova1listagemcinema.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joao on 12/09/2017.
 */
public class Filme implements Parcelable {

    /**
     *
     */
    private final int imageId;

    /**
     *
     */
    private final String nomeDiretor;

    /**
     *
     */
    private final String genero;

    /**
     *
     */
    private final String nacionalidade;

    /**
     *
     */
    private final String sinopse;

    /**
     *
     */
    private List<Ator> elenco;

    /**
     * Construtor padrão para um Filme.
     *
     * @param imageId       Identificador da capa do filme
     * @param nomeDiretor   Nome do Diretor
     * @param genero        Gênero do filme
     * @param nacionalidade Nacionalidade do filme
     * @param sinopse       Breve descrição do enredo do filme
     */
    public Filme(int imageId, String nomeDiretor, String genero, String nacionalidade, String sinopse) {
        this.imageId = imageId;
        this.nomeDiretor = nomeDiretor;
        this.genero = genero;
        this.nacionalidade = nacionalidade;
        this.sinopse = sinopse;
    }

    /**
     *
     */
    private Filme(Parcel source) {
        imageId = source.readInt();
        nomeDiretor = source.readString();
        genero = source.readString();
        nacionalidade = source.readString();
        sinopse = source.readString();
        elenco = new ArrayList<>();
        source.readTypedList(elenco, Ator.CREATOR);
    }

    /**
     * {@inheritDoc}
     */
    public static final Creator<Filme> CREATOR = new Creator<Filme>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(nomeDiretor);
        dest.writeString(genero);
        dest.writeString(nacionalidade);
        dest.writeString(sinopse);
        dest.writeTypedList(elenco);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Filme filme = (Filme) o;

        if (imageId != filme.imageId) {
            return false;
        }
        if (!nomeDiretor.equals(filme.nomeDiretor)) {
            return false;
        }
        return genero != null ? genero.equals(filme.genero) : filme.genero == null;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + nomeDiretor.hashCode();
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        return result;
    }

    public int getImageId() {
        return imageId;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public String getGenero() {
        return genero;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }

}

package com.example.joao.prova1listagemcinema.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joao on 12/09/2017.
 */
public class Ator implements Parcelable {

    /**
     *
     */
    private final int imageId;

    /**
     *
     */
    private final String nome;

    /**
     * Construtor padrão para um Ator.
     *
     * @param imageId Identificador para a foto do ator.
     * @param nome Nome do ator.
     */
    public Ator(int imageId, String nome) {
        this.imageId = imageId;
        this.nome = nome;
    }

    /**
     * {@inheritDoc}
     */
    private Ator(Parcel source) {
        imageId = source.readInt();
        nome = source.readString();
    }

    public static final Creator<Ator> CREATOR = new Creator<Ator>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public Ator createFromParcel(Parcel in) {
            return new Ator(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Ator[] newArray(int size) {
            return new Ator[size];
        }

    };

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return nome;
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
        Ator ator = (Ator) o;
        return imageId == ator.imageId && nome.equals(ator.nome);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + nome.hashCode();
        return result;
    }

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
        dest.writeString(nome);
    }

    public int getImageId() {
        return imageId;
    }

    public String getNome() {
        return nome;
    }

}

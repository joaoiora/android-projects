package br.ucb.desafioacademia.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by João Carlos Iora on 31/08/17.
 */
public class Treino implements Parcelable {

    private String dia;
    private String nome;
    private String membro;

    /**
     *
     * @param dia
     * @param nome
     * @param membro
     */
    public Treino(String dia, String nome, String membro) {
        this.dia = dia;
        this.nome = nome;
        this.membro = membro;
    }

    /**
     *
     * @param source
     */
    private Treino(Parcel source) {
        dia = source.readString();
        nome = source.readString();
        membro = source.readString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     * @see #CONTENTS_FILE_DESCRIPTOR
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dia);
        dest.writeString(nome);
        dest.writeString(membro);
    }

    /**
     */
    public static final Creator<Treino> CREATOR = new Creator<Treino>() {

        /**
         *
         * @param source
         * @return
         */
        @Override
        public Treino createFromParcel(Parcel source) {
            return new Treino(source);
        }

        /**
         *
         * @param size
         * @return
         */
        @Override
        public Treino[] newArray(int size) {
            return new Treino[size];
        }

    };

    /**
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Treino treino = (Treino) o;
        return dia.equals(treino.dia);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return dia.hashCode();
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }

}

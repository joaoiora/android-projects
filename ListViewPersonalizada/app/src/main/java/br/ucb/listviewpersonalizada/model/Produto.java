package br.ucb.listviewpersonalizada.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Representação singela de um produto.
 * <p>
 * Created by João Carlos Iora on 06/09/17
 */
public class Produto implements Parcelable {

    /**
     * Nome para um produto qualquer.
     */
    private final String nome;

    /**
     * Descrição simples do tipo de produto.
     */
    private final String tipo;

    /**
     * Construtor básico para um Produto.
     *
     * @param nome Nome do Produto
     * @param tipo Tipo do Produto
     */
    public Produto(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    /**
     * {@inheritDoc}
     */
    private Produto(Parcel source) {
        nome = source.readString();
        tipo = source.readString();
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
        dest.writeString(nome);
        dest.writeString(tipo);
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public Produto createFromParcel(Parcel source) {
            return new Produto(source);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

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
        Produto produto = (Produto) o;
        return nome.equals(produto.nome) && tipo.equals(produto.tipo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + tipo.hashCode();
        return result;
    }

    /**
     * @return Nome do Produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Tipo do Produto
     */
    public String getTipo() {
        return tipo;
    }

}

package br.ucb.listviewpersonalizada.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by João Carlos Iora on 06/09/17.
 */
public class Produto implements Parcelable {

    private String nome;

    private String tipo;

    public Produto() {

    }

    public Produto(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    private Produto(Parcel in) {
        nome = in.readString();
        tipo = in.readString();
    }

    /**
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(tipo);
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {

        /**
         *
         * @param in
         * @return
         */
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        /**
         *
         * @param size
         * @return
         */
        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encontrei um " + tipo + " para você.\n");
        sb.append("É um " + nome + " de altíssima qualidade.\n");
        sb.append("Clique no link para mais informações: https://www.ucb.br\n");
        return sb.toString();
    }

    /**
     *
     * @param o
     * @return
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
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + tipo.hashCode();
        return result;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

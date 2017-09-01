package br.ucb.desafioacademia.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by João Carlos Iora on 31/08/17.
 */
public class Usuario implements Parcelable {

    private String codigo;
    private String senha;
    private String nome;
    private String telefone;
    private String email;

    /**
     * @param codigo
     * @param senha
     */
    public Usuario(String codigo, String senha) {
        this.codigo = codigo;
        this.senha = senha;
        this.nome = "Birineu da Silva";
        this.telefone = "35456555";
        this.email = "birineu.fodao@bol.com.br";
    }

    /**
     * @param source
     */
    private Usuario(Parcel source) {
        codigo = source.readString();
        senha = source.readString();
        nome = source.readString();
        telefone = source.readString();
        email = source.readString();
    }

    /**
     *
     */
    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {

        /**
         * Create a new instance of the Parcelable class, instantiating it
         * from the given Parcel whose data had previously been written by
         * {@link Parcelable#writeToParcel Parcelable.writeToParcel()}.
         *
         * @param source The Parcel to read the object's data from.
         * @return Returns a new instance of the Parcelable class.
         */
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        /**
         * Create a new array of the Parcelable class.
         *
         * @param size Size of the array.
         * @return Returns an array of the Parcelable class, with every entry
         * initialized to null.
         */
        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(senha);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario[" + codigo + "]\n";
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
        Usuario usuario = (Usuario) o;
        return codigo.equals(usuario.codigo);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


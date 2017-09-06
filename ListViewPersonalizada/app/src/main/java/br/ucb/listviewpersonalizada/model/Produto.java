package br.ucb.listviewpersonalizada.model;

/**
 * Created by João Carlos Iora on 06/09/17.
 */
public class Produto {

    private String nome;

    private String tipo;

    public Produto() {

    }

    public Produto(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Produto[").append(nome).append(", ").append(tipo).append("]\n");
        return sb.toString();
    }

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

package com.example.joao.desafiocotacao;

import java.util.Date;

/**
 *
 */
public class Cotacao {

    private String nome;
    private Double valor;
    private Date dataConsulta;
    private String fonte;

    public Cotacao() {

    }

    public Cotacao(String nome, Double valor, Date dataConsulta, String fonte) {
        this.nome = nome;
        this.valor = valor;
        this.dataConsulta = dataConsulta;
        this.fonte = fonte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cotacao cotacao = (Cotacao) o;
        return nome.equals(cotacao.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
}

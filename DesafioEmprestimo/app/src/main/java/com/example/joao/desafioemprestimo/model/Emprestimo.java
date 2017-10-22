package com.example.joao.desafioemprestimo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.joao.desafioemprestimo.utils.Dates;

import java.util.Date;

/**
 * Created by Joao on 21/10/2017.
 */
public class Emprestimo implements Parcelable {

    private Integer id;
    private String nomeObjeto;
    private String nomeIndividuo;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo() {

    }

    private Emprestimo(String nomeObjeto, String nomeIndividuo, Date dataEmprestimo, Date dataDevolucao) {
        this.nomeObjeto = nomeObjeto;
        this.nomeIndividuo = nomeIndividuo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Integer id, String nomeObjeto, String nomeIndividuo, Date dataEmprestimo, Date dataDevolucao) {
        this(nomeObjeto, nomeIndividuo, dataEmprestimo, dataDevolucao);
        this.id = id;
    }

    public String getMensagemCobranca() {
        return String.format("Olá %s\nVEu lhe emprestei o objeto %s na data %s, espero que seja " +
                "devolvido até o dia %s.\n", nomeIndividuo, nomeObjeto, getDataEmprestimoString(), getDataDevolucaoString());
    }

    private Emprestimo(Parcel in) {
        id = in.readInt();
        nomeObjeto = in.readString();
        nomeIndividuo = in.readString();
        long tmpDate = in.readLong();
        dataEmprestimo = tmpDate == -1 ? null : new Date(tmpDate);
        tmpDate = in.readLong();
        dataDevolucao = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Creator<Emprestimo> CREATOR = new Creator<Emprestimo>() {
        @Override
        public Emprestimo createFromParcel(Parcel in) {
            return new Emprestimo(in);
        }

        @Override
        public Emprestimo[] newArray(int size) {
            return new Emprestimo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nomeObjeto);
        dest.writeString(nomeIndividuo);
        dest.writeLong(dataEmprestimo != null ? dataEmprestimo.getTime() : -1);
        dest.writeLong(dataDevolucao != null ? dataDevolucao.getTime() : -1);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "nomeObjeto='" + nomeObjeto + '\'' +
                ", nomeIndividuo='" + nomeIndividuo + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprestimo that = (Emprestimo) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeObjeto() {
        return nomeObjeto;
    }

    public void setNomeObjeto(String nomeObjeto) {
        this.nomeObjeto = nomeObjeto;
    }

    public String getNomeIndividuo() {
        return nomeIndividuo;
    }

    public void setNomeIndividuo(String nomeIndividuo) {
        this.nomeIndividuo = nomeIndividuo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataEmprestimoString() {
        return Dates.format(dataEmprestimo);
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataDevolucaoString() {
        return Dates.format(dataDevolucao);
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
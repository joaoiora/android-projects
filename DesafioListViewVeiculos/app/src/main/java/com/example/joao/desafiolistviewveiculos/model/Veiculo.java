package com.example.joao.desafiolistviewveiculos.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

/**
 * Created by Joao on 15/08/2017.
 */
public class Veiculo implements Parcelable {

    private String modelo;
    private String cor;
    private Integer ano;
    private Double quilometragem;
    private Double valor;
    private int imageId; // gambira alert TODO descobrir como desacoplar isso

    public Veiculo() {

    }

    public Veiculo(String modelo, String cor, Integer ano, int imageId) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.quilometragem = random(); // pura preguiça de colocar os valores na mão...
        this.valor = random();
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modelo: " + modelo + "\n");
        sb.append("Cor: " + cor + "\n");
        sb.append("Ano: " + ano + "\n");
        sb.append("Quilometragem: " + quilometragem + "\n");
        sb.append("Valor: " + valor + "\n");
        return sb.toString();
    }

    /**
     *
     * @return
     */
    private Double random() {
        double start = 10000;
        double end = 100000;
        double random = new Random().nextDouble();
        return start + (end - start) * random;
    }

    private Veiculo(Parcel in) {
        modelo = in.readString();
        cor = in.readString();
        imageId = in.readInt();
        ano = in.readInt();
        quilometragem = in.readDouble();
        valor = in.readDouble();
    }

    public static final Creator<Veiculo> CREATOR = new Creator<Veiculo>() {
        @Override
        public Veiculo createFromParcel(Parcel in) {
            return new Veiculo(in);
        }

        @Override
        public Veiculo[] newArray(int size) {
            return new Veiculo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(modelo);
        dest.writeString(cor);
        dest.writeInt(imageId);
        dest.writeInt(ano);
        dest.writeDouble(quilometragem);
        dest.writeDouble(valor);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}

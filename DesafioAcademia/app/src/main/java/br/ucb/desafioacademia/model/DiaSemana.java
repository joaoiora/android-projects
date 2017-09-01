package br.ucb.desafioacademia.model;

/**
 * Created by João Carlos Iora on 01/09/17.
 */
public enum DiaSemana {

    SEGUNDA_FEIRA(1, "Segunda-Feira"),
    TERCA_FEIRA(2, "Terça-Feira"),
    QUARTA_FEIRA(3, "Quarta-Feira"),
    QUINTA_FEIRA(4, "Quinta-Feira"),
    SEXTA_FEIRA(5, "Sexta-Feira"),
    SABADO(6, "Sábado");

    /**
     *
     */
    private int codigo;

    /**
     *
     */
    private String descricao;

    /**
     * @param codigo
     * @param descricao
     */
    private DiaSemana(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * @param codigo
     * @return
     */
    public static DiaSemana findByCodigo(final int codigo) {
        for (DiaSemana dia : values()) {
            if (dia.codigo == codigo) {
                return dia;
            }
        }
        return null;
    }

    /**
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
}

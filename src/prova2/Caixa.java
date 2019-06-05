package prova2;

import java.util.Objects;

public class Caixa implements Comparable<Caixa> {
    private String descricao;
    private String personalizacao;
    private Formato formato;
    private final double PRECO_POR_CM_QUADRADO = 0.1;

    public Caixa(String descricao, String personalizacao, Formato formato) {
        this.descricao = descricao;
        this.personalizacao = personalizacao;
        this.formato = formato;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPersonalizacao() {
        return personalizacao;
    }

    public void setPersonalizacao(String personalizacao) {
        this.personalizacao = personalizacao;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public double getPreco() {
        return this.calculaPreco();
    }

    private double calculaPreco() {
        return this.PRECO_POR_CM_QUADRADO * this.formato.getArea();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caixa caixa = (Caixa) o;
        return Objects.equals(descricao, caixa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    @Override
    public String toString() {
        return "Caixa com " + this.personalizacao + " custa R$" + this.getPreco() + ". Formato: "
                + this.getFormato().formato() + ".";
    }

    @Override
    public int compareTo(Caixa caixa) {
        return this.getDescricao().compareTo(caixa.getDescricao());
    }
}

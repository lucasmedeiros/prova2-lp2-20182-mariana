package prova2;

import java.util.*;

public class ControllerCaixas {

    private Map<String, Caixa> caixas;

    public ControllerCaixas() {
        this.caixas = new HashMap<>();
    }

    public boolean cadastraCaixaPentagonal(String descricao, String personalizacao, double lado) {
        Formato formato = new Pentagonal(lado);
        Caixa caixa = new Caixa(descricao, personalizacao, formato);
        return this.caixas.put(descricao, caixa) != null;
    }

    public boolean cadastraCaixaRetangular(String descricao, String personalizacao, double lado1, double lado2) {
        Formato formato = new Retangular(lado1, lado2);
        Caixa caixa = new Caixa(descricao, personalizacao, formato);
        return this.caixas.put(descricao, caixa) != null;
    }

    public boolean cadastraCaixaCircular(String descricao, String personalizacao, double raio) {
        Formato formato = new Circular(raio);
        Caixa caixa = new Caixa(descricao, personalizacao, formato);
        return this.caixas.put(descricao, caixa) != null;
    }

    public void modificaPersonalizacao(String descricao, String novaPersonalizacao) {
        this.caixas.get(descricao).setPersonalizacao(novaPersonalizacao);
    }

    public boolean removeCaixa(String descricao) {
        if(this.caixas.containsKey(descricao)) {
            this.caixas.remove(descricao);
            return true;
        } else {
            return false;
        }
    }

    public int totalDeCaixas() {
        return this.caixas.size();
    }

    public boolean consultaEstoque(String descricao, String personalizacao, String formato) {
        if(this.caixas.get(descricao).getPersonalizacao().equals(personalizacao)) {
            if((this.caixas.get(descricao).getFormato().formato().equals(formato))) {
                return true;
            }
        }

        return false;
    }

    public String getCaixasOrdenadas() {
        List<Caixa> caixasOrdenadas = new ArrayList<>(this.caixas.values());
        return this.getCaixasOrdenadasAPartirDeLista(caixasOrdenadas);
    }

    public String getCaixasPorFormatoOrdenadas(String formato) {
        List<Caixa> caixasPorFormato = new ArrayList<>();

        for (Caixa caixa: this.caixas.values()) {
            if(caixa.getFormato().formato().equals(formato)) {
                caixasPorFormato.add(caixa);
            }
        }

        return this.getCaixasOrdenadasAPartirDeLista(caixasPorFormato);
    }

    private String getCaixasOrdenadasAPartirDeLista(List<Caixa> caixas) {
        Collections.sort(caixas);
        return Arrays.toString(caixas.toArray());
    }

    public double rendimentoTotal() {
        double acumulador = 0;

        for(Caixa caixa: this.caixas.values()) {
            acumulador += caixa.getPreco();
        }

        return acumulador;
    }
}

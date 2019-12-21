package aula13.ex1_2;

import java.util.ArrayList;
import java.util.Objects;

public class Pais {
    private String nome;
    private Cidade capital;
    private ArrayList<Regiao> rg;

    public Pais(String nome, Cidade capital) {
        this.nome = nome;
        this.capital=capital;
        this.rg = new ArrayList<>();
    }

    public int totalPopulacao(){
       return  rg.stream().mapToInt(f -> f.getPopulacao()).sum();
    }

    public Pais(String nome) {
        this.nome = nome;
        this.capital = null;
        this.rg = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCapital() {
        return capital;
    }

    public void setCapital(Cidade capital) {
        this.capital = capital;
    }

    public ArrayList<Regiao> getRg() {
        return rg;
    }

    public boolean addRegiao(Regiao est1) {
        return rg.add(est1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nome, pais.nome) &&
                Objects.equals(capital, pais.capital) &&
                rg.equals(pais.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, capital, rg);
    }

    @Override
    public String toString() {
       if(capital==null)
        return "Pais: " + nome +
                " População: " + totalPopulacao() +
                " (Capital " + "*inexistente*"
                + " )";
        else
            return "Pais: " + nome +
                    " População: " + totalPopulacao() +
                    " (Capital " + capital + " )";
    }
}

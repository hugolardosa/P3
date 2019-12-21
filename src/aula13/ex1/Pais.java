package aula13.ex1;

import java.util.ArrayList;
import java.util.Objects;

public class Pais {
    private String nome;
    private Localidade capital;
    private ArrayList<Regiao> rg;

    public Pais(String nome, Localidade capital) {
        this.nome = nome;
        if(capital.getType() == TipoLocalidade.Cidade)this.capital=capital;
        else throw new IllegalArgumentException("Capital Invalida");
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

    public Localidade getCapital() {
        return capital;
    }

    public void setCapital(Localidade capital) {
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

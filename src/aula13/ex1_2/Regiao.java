package aula13.ex1_2;

import java.util.Objects;

public class Regiao {
    private String nome;
    private int populacao;

    public Regiao(String nome, int populacao) {
        this.nome=nome;
        this.populacao=populacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }


    public int getPopulacao() {
        return populacao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regiao regiao = (Regiao) o;
        return populacao == regiao.populacao &&
                nome.equalsIgnoreCase(regiao.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, populacao);
    }

    @Override
    public String toString() {
        return " "+ nome +
                ", população : " + populacao;
    }
}

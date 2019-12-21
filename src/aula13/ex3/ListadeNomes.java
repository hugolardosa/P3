package aula13.ex3;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class ListadeNomes {
    private ArrayList<String> nomes;

    public ListadeNomes(ListadeNomes l){this.nomes = l.nomes;}

    public ListadeNomes(ArrayList<String> nomes) {
        this.nomes = new ArrayList<String>(nomes);
    }

    public ListadeNomes(){
        this.nomes = new ArrayList<String>();
    }

    public boolean addNome(String nome){
        return nomes.add(nome);
    }

    public boolean removeNome(String nome){
        return nomes.remove(nome);
    }

    public boolean existsNome(String nome){
        return nomes.contains(nome);
    }

    public String getRandomEmployee(){
        Random index = new Random();
        int n = index.nextInt(nomes.size());
        return nomes.get(n);
    }

    public ArrayList<String> getNomes() {
        return nomes;
    }

    public List<String> getdiferentNamesList(){
        return nomes.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListadeNomes that = (ListadeNomes) o;
        return Objects.equals(nomes, that.nomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomes);
    }

    @Override
    public String toString() {
       String r = "Nome de funcionarios: \n";

       for(String s : nomes){
           r+= s + "\n";
       }
       return r;
    }
}

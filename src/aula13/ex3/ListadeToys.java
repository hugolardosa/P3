package aula13.ex3;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListadeToys {
    private ArrayList<String> nomes;

    public ListadeToys(ListadeToys l){this.nomes = l.nomes;}

    public ListadeToys(ArrayList<String> nomes) {
        this.nomes = new ArrayList<String>(nomes);
    }

    public ListadeToys(){
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

    public String getRandomToy(){
        int index = (int) Math.random()*nomes.size();
        return nomes.get(index);
    }

    public void giveToyNames(ListadeNomes l){
        List<String> lista = l.getdiferentNamesList();
        lista.stream().forEach(f  -> nomes.add(f));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListadeToys that = (ListadeToys) o;
        return Objects.equals(nomes, that.nomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomes);
    }

    @Override
    public String toString() {
       String r = "Brinquedos: \n";

       for(String s : nomes){
           r+= s + "\n";
       }
       return r;
    }
}

package aula13.ex3;

import java.util.TreeMap;

public class GivingToys {
   private TreeMap<String,String > givetoys;

    public GivingToys(TreeMap<String, String> givetoys){
        this.givetoys = givetoys;

    }

    public GivingToys(){
        this.givetoys = new TreeMap<>();
    }

    public void addName(String nome){
        givetoys.put(nome,null);
    }

    public void addNameandToy(String nome,String toy){
        if(givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        }
        else {
            givetoys.put(nome, toy);
        }
    }

    public void addToytoRandom(ListadeNomes l, String toy){
        String nome = l.getRandomEmployee();
        if(givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        }
        else {
            givetoys.put(nome, toy);
        }
    }

    public void addRandomToyRandomName(ListadeNomes l, ListadeToys t){
        String nome = l.getRandomEmployee();
        String toy = t.getRandomToy();
        if(givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        }
        else {
            givetoys.put(nome, toy);
        }
    }

}

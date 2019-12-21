package aula13.ex3;

import java.util.Objects;
import java.util.TreeMap;

public class GivingToys {
    private TreeMap<String, String> givetoys;

    public GivingToys(TreeMap<String, String> givetoys) {
        this.givetoys = givetoys;

    }

    public GivingToys() {
        this.givetoys = new TreeMap<>();
    }

    public void addName(String nome) {
        givetoys.put(nome, null);
    }

    public void addNameandToy(String nome, String toy) {
        if (givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        } else {
            givetoys.put(nome, toy);
        }
    }

    public void addToytoRandom(ListadeNomes l, String toy) {
        String nome = l.getRandomEmployee();
        if (givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        } else {
            givetoys.put(nome, toy);
        }
    }

    public void addRandomToyRandomName(ListadeNomes l, ListadeToys t) {
        String nome = l.getRandomEmployee();
        String toy = t.getRandomToy();
        if (givetoys.containsKey(nome)) {
            givetoys.replace(nome, toy);
        } else {
            givetoys.put(nome, toy);
        }
    }

    public boolean conatinsName(String nome) {
        return givetoys.containsKey(nome);
    }

    public boolean containsToy(String toy) {
        return givetoys.containsValue(toy);
    }

    public boolean containsPair(String nome, String toy) {
        if (givetoys.containsKey(nome)) {
            if (givetoys.get(nome).equalsIgnoreCase(toy)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean removeNome(String nome) {
        if (givetoys.containsKey(nome)) {
            givetoys.remove(nome);
            return true;
        } else {
            return false;
        }
    }

    public boolean removePair(String nome, String toy) {
        if (givetoys.containsValue(toy)) {
            givetoys.remove(nome, toy);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GivingToys that = (GivingToys) o;
        return Objects.equals(givetoys, that.givetoys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(givetoys);
    }



    @Override
    public String toString() {
        String r = "Lista de brinquedos: \n";
        for (String key : givetoys.keySet()) {
            r += key + " -> " + givetoys.get(key) + "\n";
        }

        return r;
    }
}

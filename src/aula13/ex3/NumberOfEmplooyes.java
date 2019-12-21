package aula13.ex3;

import java.time.temporal.JulianFields;
import java.util.*;

public class NumberOfEmplooyes {
    private TreeMap<String, Integer> nomes;
    private ArrayList<String> sorted;

    public NumberOfEmplooyes(TreeMap<String, Integer> nomes) {
        this.nomes = nomes;
        this.sorted = new ArrayList<>();
    }


    public NumberOfEmplooyes() {
        this.nomes = new TreeMap<>();
        this.sorted = new ArrayList<>();
    }

    public void addList(ListadeNomes n) {
        n.getNomes().stream()
                .forEach(f -> {
                    if (nomes.containsKey(f)) nomes.put(f, nomes.get(f) + 1);
                    else nomes.put(f, 1);
                });

    }


    private void sortedName() {
        nomes.keySet().stream().forEach(f -> sorted.add(f));
        Collections.sort(sorted, new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                return nomes.get(t1) - nomes.get(t);
            }
        });
        System.out.println(sorted.toString());
    }

    public void fillToyList(ListadeToys l, int numt){
        sortedName();
        for (int i = 0; i<numt; i++){
                l.addNome(sorted.get(i));
            }
        }

    public String getMorePopular() {
        int pop = Integer.MAX_VALUE;
        String funcionario = "";
        for (String key : nomes.keySet()) {
            if (pop > nomes.get(key)) {
                pop = nomes.get(key);
                funcionario = key;
            }
        }
        return funcionario;
    }

    public int getPopularity(String nome) {
        return nomes.get(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfEmplooyes that = (NumberOfEmplooyes) o;
        return Objects.equals(nomes, that.nomes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomes);
    }

    @Override
    public String toString() {
        String r = "Popularity: \n";
        for (String kk : nomes.keySet()) {
            r += (kk + "=" + nomes.get(kk).toString() + "\n");
        }
        return r;
    }
}
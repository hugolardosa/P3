package aula13.ex3;

import java.util.TreeMap;

public class NumberOfEmplooyes {
    TreeMap<String, Integer> nomes;

    public NumberOfEmplooyes(TreeMap<String, Integer> nomes) {
        this.nomes = nomes;
    }

    public NumberOfEmplooyes() {
        this.nomes = new TreeMap<>();
    }

    public void addList(ListadeNomes n) {
        n.getNomes().stream()
                .forEach(f -> {
                    if (nomes.containsKey(f)) nomes.put(f, nomes.get(f) + 1);
                    else nomes.put(f, 1);
                });

    }

    public String getMorePopular(){
        int pop = Integer.MAX_VALUE;
        String funcionario = "";
        for(String key : nomes.keySet()){
            if(pop > nomes.get(key)){
                pop = nomes.get(key);
                funcionario = key;
            }
        }
        return funcionario;
    }

    public int getPopularity(String nome){
        return nomes.get(nome);
    }


}

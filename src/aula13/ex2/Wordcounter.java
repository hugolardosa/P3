package aula13.ex2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Wordcounter {
    private TreeMap<String, TreeMap<String, Integer>> found_words;

    public Wordcounter() {
        this.found_words = new TreeMap<>();
    }

    public void read(String filepath) {
        Path p = Paths.get(filepath);
        List<String> frases = new LinkedList<String>();
        try {
            frases = Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("ERROR: File not found!");
        }
        for (String f : frases) {
            //fazemos o split das palavras
            String[] words = f.toLowerCase().split("[\t\n\\.\\,\\:\\'\\‘\\’\\;\\?\\!\\-\\*\\{\\}\\=\\+\\&\\/\\(\\)\\[\\]\\”\\“\\\\\"\\\\\'\\s]+");
            //criamos um novo array que so contem as palavras com tamanho superiror a 2 ou seja ignorar as maiores que 3
            String[] temp = Arrays.stream(words).filter(x -> x.length() > 2).collect(Collectors.toList()).toArray(new String[0]);
            System.out.println(Arrays.toString(temp));
            //depois para cada palavra
            for (int i = 0; i < temp.length - 1; i++) {
                //se o treemap found words contem a palavra 1 do par
                if (found_words.containsKey(temp[i])) {
                    //ver se contem a palavra 2 do par, se sim
                    if (found_words.get(temp[i]).containsKey(temp[i + 1])) {
                        //adicionar mais um ao valor de vezes encontrada
                        found_words.get(temp[i]).put(temp[i + 1], found_words.get(temp[i]).get(temp[i + 1]) + 1);
                    } else
                        //se não adicionar a palavra 2 ao treemap
                        found_words.get(temp[i]).put(temp[i + 1], 1);
                } else {
                    //
                    TreeMap<String, Integer> tree_temp = new TreeMap<>();
                    tree_temp.put(temp[i + 1], 1);
                    found_words.put(temp[i], tree_temp);
                }
            }
        }

    }

    public void print() {
        Object[] keys = found_words.keySet().toArray();
        for (Object kk : keys) {
            System.out.println(kk + "=" + found_words.get(kk).toString());
        }
    }

    public void write() {
        PrintWriter fout = null;
        try {
            fout = new PrintWriter("src/aula13/ex2/output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File was not found!");
        }
        Object[] keys = found_words.keySet().toArray();
        for (Object kk : keys) {
            fout.println(kk + "=" + found_words.get(kk).toString());
        }
        fout.close();
    }

}

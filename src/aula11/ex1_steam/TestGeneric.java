package aula11.ex1_steam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TestGeneric {

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("src/aula11/ex1/bad.txt");
        List<String> lines = Files.readAllLines(p);
        al_b(lines);
        System.out.println();
        al_c(lines);
        System.out.println();
        al_d(lines);

    }

    public static void al_d(List<String> lines) {
        TreeMap<String, Integer> mapw = new TreeMap<>(new StringComparator());

        lines.stream().flatMap(line -> {
            return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+"));
        }).forEach(word -> {
            if (!mapw.containsKey(word)) {
                mapw.putIfAbsent(word, 1);
            } else {
                mapw.put(word, mapw.get(word) + 1);
            }


        });


        for (String key : mapw.keySet()) {
            System.out.println(key + " : " + mapw.get(key));
        }
    }

    public static void al_c(List<String> lines) {
        HashMap<String, Integer> mapw = new HashMap<>();

        lines.stream().flatMap(line -> {
            return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+"));
        }).forEach(word -> {
            if (!mapw.containsKey(word)) {
                mapw.putIfAbsent(word, 1);
            } else {
                mapw.put(word, mapw.get(word) + 1);
            }


        });

        for (String key : mapw.keySet()) {
            System.out.println(key + " : " + mapw.get(key));
        }
    }

    public static void al_b(List<String> lines) {

        List<String> l = lines.stream().flatMap(line -> {
            return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+"));
        }).collect(Collectors.toList());


        ArrayList<String> totalwords = new ArrayList<>(l);
        HashSet<String> difwords = new HashSet<>(l);

        System.out.printf("Número Total de Palavras: %d \n" +
                "Número de Diferentes Palavras: %d \n\n", totalwords.size(), difwords.size());
    }

    public static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    }
}

package aula11.ex1;

import javax.print.attribute.IntegerSyntax;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public abstract class TestGeneric {

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("src/aula11/ex1/bad.txt");
        List<String> lines= Files.readAllLines(p);
        al_b(lines);
        al_c(lines);
        al_d(lines);

    }

    public static void al_d(List<String> lines){
        TreeMap<String,Integer> mapw = new TreeMap<>(new StringComparator());
        VectorGeneric<String> totalwords = new VectorGeneric<>();
        HashSet<String> difwords = new HashSet<>();
        for(String l:lines) {
            String word[] = l.toLowerCase().split("[\\'\\[\\]\\t\\(\\)\\-\\+\\.\\^\\:\\,\\;\\s\\!\\?]+");
            totalwords.addArray(word);
        }
        for (String b: totalwords) {
            if(!mapw.containsKey(b)){
                mapw.putIfAbsent(b,1);
            }
            else{
                mapw.put(b,mapw.get(b)+1);
            }
        }
        for (String key :mapw.keySet()) {
            System.out.println(key + " : " + mapw.get(key));
        }
    }

    public static void al_c(List<String> lines){
        HashMap<String,Integer> mapw = new HashMap<>();
        VectorGeneric<String> totalwords = new VectorGeneric<>();
        HashSet<String> difwords = new HashSet<>();
        for(String l:lines) {
            String word[] = l.toLowerCase().split("[\\'\\[\\]\\t\\(\\)\\-\\+\\.\\^\\:\\,\\;\\s\\!\\?]+");
            totalwords.addArray(word);
        }
        for (String b: totalwords) {
            if(!mapw.containsKey(b)){
                mapw.putIfAbsent(b,1);
            }
            else{
                mapw.put(b,mapw.get(b)+1);
            }
        }
        for (String key :mapw.keySet()) {
            System.out.println(key + " : " + mapw.get(key));
        }
    }

    public static void al_b(List<String> lines){
        VectorGeneric<String> totalwords = new VectorGeneric<>();
        HashSet<String> difwords = new HashSet<>();
        for(String l:lines) {
            String word[] = l.toLowerCase().split("[\\'\\[\\]\\t\\(\\)\\-\\+\\.\\^\\:\\,\\;\\s\\!\\?]+");
            totalwords.addArray(word);
        }
        for (String b: totalwords) {
            difwords.add(b);
        }
        System.out.printf("Número Total de Palavras: %d \n" +
                "Número de Diferentes Palavras: %d \n\n",totalwords.totalElem(),difwords.size());
    }

    public static class StringComparator implements Comparator<String>{

        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    }
}

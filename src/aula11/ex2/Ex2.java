package aula11.ex2;

import aula1.Retangulo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        LinkedList<Figura> figlist = new LinkedList<Figura>();
        figlist.add(new Circulo(1,2,3));
        figlist.add(new Quadrado(1,1,1));
        figlist.add(new Rectangulo(2,3));
        figlist.add(new Circulo(1,2,3));
        figlist.add(new Circulo(1,1,1));
        figlist.add(new Circulo(2,3,6));
        figlist.add(new Quadrado(3,1,7));
        figlist.add(new Rectangulo(2,5));
        figlist.add(new Quadrado(1,1,9));
        figlist.add(new Rectangulo(2,12));
        System.out.println("maior figura J8: ");
        System.out.println(maiorFiguraJ8(figlist));
        System.out.println("maior figura por perimetro");
        System.out.println(maiorFiguraPerimetroJ8(figlist));
        System.out.println("area total");
        System.out.println(areaTotalJ8(figlist));
        System.out.println(areaTotalJ8(figlist,"Circulo"));
    }
    private static Figura maiorFiguraJ8(List<Figura> figs) {
        Comparator<? super Figura> comparator = new Comparator<Figura>() {
            @Override
            public int compare(Figura figura, Figura t1) {
                return figura.compareTo(t1);
            }
        };
        return figs.stream().max(comparator).get();
    }

    private static Figura maiorFiguraPerimetroJ8(List<Figura> figs) {
        Comparator<? super Figura> comparator = new Comparator<Figura>() {
            @Override
            public int compare(Figura figura, Figura t1) {
                return (int)(figura.perimetro() - t1.perimetro());
            }
        };
        return figs.stream().max(comparator).get();
    }

    private static  double areaTotalJ8(List<Figura> figs){
        return  figs.stream().mapToDouble(f -> f.area()).sum();
    }

    private static double areaTotalJ8(List<Figura> figs,String subtipoNome) {
        return figs.stream()
                .filter(t -> t.getClass().getSimpleName().equals(subtipoNome))
                .mapToDouble(f -> f.area()).sum();
    }

}

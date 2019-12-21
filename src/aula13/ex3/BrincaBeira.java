package aula13.ex3;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.TreeMap;

public class BrincaBeira {
    public static void main(String[] args) {
        //lista de nomes
        ListadeNomes nomes = new ListadeNomes();
        nomes.addNome("Jorge");
        nomes.addNome("Jorge");
        nomes.addNome("Jorge");
        nomes.addNome("Jaime");
        nomes.addNome("André");
        nomes.addNome("Ana");
        nomes.addNome("Lopes");
        nomes.addNome("Maria");
        nomes.addNome("Sofia");
        nomes.addNome("Cristina");
        nomes.addNome("Luísa");
        nomes.addNome("Cristina");
        nomes.addNome("Ana");
        nomes.addNome("Lopes");
        //===========================//
        System.out.println(nomes);
        System.out.println("Nomes diferentes");
        System.out.println();
        System.out.println(nomes.getdiferentNamesList().toString());
        System.out.println();
        System.out.println(nomes.existsNome("Luísa"));
        System.out.println();
        System.out.println(nomes.removeNome("Ana"));
        //===========================//
        ListadeToys toys = new ListadeToys();
        toys.addNome("Tamagochi");
        toys.addNome("Carrinho Java");
        toys.addNome("Boneca Ruby");
        toys.addNome("Bola Kotlin");
        System.out.println();
        System.out.println(toys.existsNome("Tamagochi"));
        System.out.println();
        toys.giveToyNames(nomes);
        System.out.println(toys);
        //==========================//
        System.out.println();
        GivingToys give = new GivingToys();
        give.addRandomToyRandomName(nomes,toys,12);
        System.out.println(give);
        //=========================//
        NumberOfEmplooyes rank = new NumberOfEmplooyes();
        rank.addList(nomes);
        ListadeToys novatoys = new ListadeToys();
        rank.fillToyList(novatoys,4);
        System.out.println("Teste de brinquedos: \n");
        System.out.println(novatoys);
        rank.getMorePopular();
        rank.getPopularity("Luísa");
        System.out.println(rank);
        //=========================//
        BilhetesWork tickets = new BilhetesWork(nomes.getdiferentNamesList().toArray(new String[0]));
        System.out.println(tickets.giveTickets(12));
    }


}

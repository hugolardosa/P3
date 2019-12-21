package aula13.ex2;

public class ex2 {
    public static void main(String[] args) {
        Wordcounter word = new Wordcounter();
        word.read("src/aula13/ex2/teste.txt");
        word.write();
        word.print();
        System.out.println("---policarpo---");
        Wordcounter poli = new Wordcounter();
        poli.read("src/aula13/ex2/Policarpo.txt");
        poli.write();
        poli.print();
    }
}

package aula11.ex3;

import java.io.*;
import java.util.Scanner;

public class Test implements Serializable {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");

        Prato[] pratos = new Prato[10];
        System.out.println("Do you want to read from file (s/n)");
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("s")) {
            ementa = load();
            if (ementa == null) {
                System.out.println("Corra o programa primerio e serialize o ficheiro");
                System.exit(0);
            }
            System.out.println("\n" + ementa);
            System.exit(0);
        } else {

            for (int i = 0; i < pratos.length; i++) {
                pratos[i] = randPrato(i);
                int cnt = 0;

                while (cnt < 2) { // Adicionar 2 Ingredientes a cada Prato
                    Alimento aux = randAlimento();
                    if (pratos[i].addIngrediente(aux))
                        cnt++;
                    else
                        System.out.println("ERRO: Não é possivel adicionar '" +
                                aux + "' ao -> " + pratos[i]);
                }
                ementa.addPrato(pratos[i], DiaSemana.rand()); // Dia Aleatório
            }
            System.out.println("\n" + ementa);
            save(ementa);
        }

    }

    // Retorna um Alimento Aleatoriamente
    public static Alimento randAlimento() {
        switch ((int) (Math.random() * 4)) {
            default:
            case 0:
                return new Carne(VariedadeCarne.frango, 22.3, 345.3, 300);
            case 1:
                return new Peixe(TipoPeixe.congelado, 31.3, 25.3, 200);
            case 2:
                return new Legume("Couve Flor", 21.3, 22.4, 150);
            case 3:
                return new Cereal("Milho", 19.3, 32.4, 110);
        }
    }

    // Retorna um Tipo de Prato Aleatoriamente
    public static Prato randPrato(int i) {
        switch ((int) (Math.random() * 3)) {
            default:
            case 0:
                return new Prato("Prato N." + i);
            case 1:
                return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
            case 2:
                return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
        }
    }

    private static void save(Ementa e) {
        try {
            System.out.println("Saving info to file");
            FileOutputStream fileOut =
                    new FileOutputStream("./ementa.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Info was saved to file ./ementa.ser");
        } catch (IOException i) {
            i.printStackTrace();
            System.out.println("Something went wrong, Try Again");
            System.out.println("Make sure you have permition to save the file");
        }
    }

    private static Ementa load() {

        try {
            System.out.println("Loading info from file");
            FileInputStream fileIn = new FileInputStream("./ementa.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Ementa em = (Ementa) in.readObject();
            in.close();
            fileIn.close();
            return em;
        } catch (IOException i) {
            System.out.println("Something went wrong, Try Again");
            System.out.println("Make sure you have permission to access the file");
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Ementa class was not found");
            return null;
        }

    }
}

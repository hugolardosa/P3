package aula1;
import java.util.*;
import java.time.LocalDate;

public class Ex2 {
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Pessoa> p = new ArrayList<Pessoa>();
		while(true) {
			menu(p);
		}
		
	}
	public static void menu(ArrayList<Pessoa> p) {
		System.out.println("");
		System.out.println("Menu:");
		System.out.println("1 - Adicionar pessoas");
		System.out.println("2 - Remover pessoas");
		System.out.println("3 - Mostrar Lista");
		System.out.println("4 - Ordenar lista de pessoas por nome");
		System.out.println("5 - Ordenar lista de pessoas por cc");
		System.out.println("6 - Sair do Programa");
		int op;
		do {
			try {
				op = kb.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.print("A opção tem que ser um numero");
				kb.nextLine();
				
			}
		}while(true);
		switch (op) {
		case 1:
			addItem(p);
			break;
		case 2:
			removeItem(p);
			break;
		case 3:
			printList(p);
			break;
		case 4:
			SortbyName(p);
			break;
		case 5:
			SortbyCC(p);
			break;
		case 6:
			System.exit(0);
			break;
		default:
			menu(p);
			break;
		}
	}
	public static void addItem(ArrayList<Pessoa> p) {
		kb.nextLine();
		System.out.println("Introduza o nome");
		String name = kb.nextLine();
		System.out.println("Introduza o CC");
		int cc;
		do {
			try {
				cc = kb.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("Introduzio um CC valido");
				kb.nextLine();
			}
		}while(true);
		
		System.out.println("Introduza Data de Nascimento");
		Data temp;
		do {
			try {
				int dia = kb.nextInt();
				int mes = kb.nextInt();
				int ano = kb.nextInt();
				
				temp = new Data(dia,mes,ano);
				break;
			}catch (IllegalArgumentException e) {
				System.out.println("Introduzio uma Data de Nascimento invalida");
				kb.nextLine();
			}
		}while(true);

		Pessoa temp2  = new Pessoa(name, cc, temp);
		p.add(temp2);
		kb.nextLine(); //Avoid Scanner errors
	}
	public static void removeItem(ArrayList<Pessoa> p) {
		System.out.println("Indique o indice do elemento a remover");
		int indice = kb.nextInt();
		p.remove(indice);
		kb.nextLine(); //Avoid Scanner errors
	}
	public static void printList(ArrayList<Pessoa> p) {
		System.out.println("i | ");
		for (int i = 0; i < p.size(); i++) {
			System.out.printf("%d | %s \n",i,p.get(i).toString());
		}
		System.out.println("");
	}

	public static void SortbyName(ArrayList<Pessoa> p) {
		ArrayList<Pessoa> temp = new ArrayList<Pessoa>();
		String[] nomes= new String[p.size()];
		for (int i = 0; i < nomes.length; i++) {
			nomes[i] = p.get(i).getName();
			
		}
		//Sort By Names
		Arrays.sort(nomes);
		for (int i = 0; i < nomes.length; i++) {
			for (int j = 0; j < p.size(); j++) {
				if(p.get(j).getName().equals(nomes[i])) {
					temp.add(p.get(j));
				}
			}
		}
		p.removeAll(p); //remove todos os elementos da lista p
		p.addAll(temp); //são adicionados todos os elementos da Lista já ordenada para p
	}
	
	public static void SortbyCC(ArrayList<Pessoa> p) {
		ArrayList<Pessoa> temp = new ArrayList<Pessoa>();
		int[] temcc= new int[p.size()];
		for (int i = 0; i < temcc.length; i++) {
			temcc[i] = p.get(i).getCC();
		}
		//Sort By CC
		Arrays.sort(temcc);
		
		for (int i = 0; i < temcc.length; i++) {
			for (int j = 0; j < p.size(); j++) {
				if(p.get(j).getCC() == temcc[i]) {
					temp.add(p.get(j));
				}
			}
		}
		p.removeAll(p); //remove todos os elementos da lista p
		p.addAll(temp); //são adicionados todos os elementos da Lista já ordenada para p
	}
}

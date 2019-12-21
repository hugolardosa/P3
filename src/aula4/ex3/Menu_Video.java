package aula4.ex3;

import java.util.*;

public class Menu_Video {
	static int idv = 0;
	static int ns = 0;
	static int Nmax = 5;
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Que valor maximo de filmes podem ser emprestados?");
		int n = 0;
		try {
			n = kb.nextInt();
			kb.nextLine();
		}
		catch(Exception e){
			n = 5;
		}
		Nmax = n;
		ListClient cl = new ListClient();
		ListVideo vd = new ListVideo();
		Loans base = new Loans();		
		
		ini(cl,vd,base);
		while(true) {
			menu(cl,vd,base);
		}
	}
	
	public static void menu(ListClient cl, ListVideo vd, Loans ld) {
		System.out.println("Bem-vido - VideoClube");
		System.out.println("");
		System.out.println("1 - Introduzir um novo utilizador a base de dados");
		System.out.println("2 - Remover um utilizador da base de dados");
		System.out.println("3 - Introduzir um video na base de dados");
		System.out.println("4 - Remover um video da base de dados");
		System.out.println("5 - Listar videos disponiveis");
		System.out.println("6 - Pesquisar um video na base da dados");
		System.out.println("7 - Efetuar o empréstimo de um video(checkout)");
		System.out.println("8 - Efectuar a devolução de um video(checkin)");
		System.out.println("9 - Consultar estado de um video");
		System.out.println("10 - Historico de emprestimos");
		System.out.println("11 - Lista de videos por ranking");
		System.out.println("12 - Lista clientes");
		System.out.println("13 - Sair");
		System.out.println();
		System.out.println("Escolha o numero da opção pertendida");
		int op;
		do {
			try {
				System.out.println("Opção:");
				op = kb.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("Opção Invalida");
				kb.nextLine();
			}
		}while(true);
		kb.nextLine();
		switch (op) {
		case 1:
			addUser(cl);
			break;
		case 2:
			removeUser(cl);
			break;
		case 3:
			addMovie(vd);
			break;
		case 4:
			removeVideo(vd);
			break;
		case 5:
			vd.PrintList();
			break;
		case 6:
			searchvid(vd);
			break;
		case 7:
			checkout(vd,cl,ld);
			break;
		case 8:
			checkin(vd,cl,ld);
			break;
		case 9:
			State(vd,cl,ld);
			break;
		case 10:
			ListVid(ld);
			break;
		case 11:
			ListRM(vd);
			break;
		case 12:
			cl.PrintListCL();
			break;
		case 13:
			System.exit(1);
			break;	
		default:
			menu(cl,vd,ld);
			break;
		}
	}
	
	public static void addUser(ListClient cl) {
		System.out.println("Estudante ou Funcionario(e/f)");
		String op = kb.next();
		if (op.equalsIgnoreCase("e")) {
			System.out.println("Num. Mecc:");
			int Nmecc = kb.nextInt();
			kb.nextLine();
			System.out.println("Curso:");
			String Curso = kb.nextLine();
			Data Datadeins = new Data(); 
			System.out.println("Nome: ");
			String Nome = kb.nextLine(); 
			System.out.println("CC:");
			int NumCC = kb.nextInt(); 
			kb.nextLine();
			System.out.println("Introduza Data de Nascimento");
			Data Born;
			do {
				try {
					System.out.println("Dia?:");
					int dia = kb.nextInt();
					System.out.println("Mês?:");
					int mes = kb.nextInt();
					System.out.println("Ano?:");
					int ano = kb.nextInt();
					
					Born = new Data(dia,mes,ano);
					break;
				}catch (IllegalArgumentException e) {
					System.out.println("Introduziu uma Data de Nascimento invalida");
					kb.nextLine();
				}
			}while(true);
			Cliente e = new Estudante(Nmecc, Curso, ns++, Datadeins, Nome, NumCC, Born);
			cl.addClient(e);
		}
		else {
			System.out.println("Num. Func:");
			int Nfunc = kb.nextInt();
			kb.nextLine();
			System.out.println("NIF:");
			int NIF = kb.nextInt();
			kb.nextLine();
			Data Datadeins = new Data(); 
			System.out.println("Nome: ");
			String Nome = kb.nextLine(); 
			System.out.println("CC:");
			int NumCC = kb.nextInt(); 
			kb.nextLine();
			System.out.println("Introduza Data de Nascimento");
			Data Born;
			do {
				try {
					System.out.println("Dia?:");
					int dia = kb.nextInt();
					System.out.println("Mês?:");
					int mes = kb.nextInt();
					System.out.println("Ano?:");
					int ano = kb.nextInt();
					
					Born = new Data(dia,mes,ano);
					break;
				}catch (IllegalArgumentException e) {
					System.out.println("Introduziu uma Data de Nascimento invalida");
					kb.nextLine();
				}
			}while(true);
			ns = ns++;
			Cliente f = new Funcionario(Nfunc, NIF, ns, Datadeins, Nome, NumCC, Born);
			cl.addClient(f);
		}
	}
	
	public static void removeUser(ListClient cl) {
		System.out.println("Numero de Socio do cliente a ser removido?");
		int n = kb.nextInt();
		cl.removeCliente(n);
	}
	
	public static void addMovie(ListVideo vd) {
		System.out.println("Titulo");
		String titulo = kb.nextLine();
		System.out.println("Categoria: ");
		String Categoria = kb.nextLine();
		System.out.println("Idade: ");
		String idade = kb.nextLine();
		idv = idv++;
		Video v = new Video(idv, titulo, Categoria, idade);
		vd.addVideo(v);	
	}
	
	public static void removeVideo(ListVideo vd) {
		System.out.println("Qual é o ID do filme a remover");
		int id = kb.nextInt();
		vd.removeVideo(id);
	}
	
	public static void searchvid(ListVideo vd) {
		System.out.println("Quer procurar por id ou por Nome [i,n]");
		String op = kb.nextLine();
		if(op.equalsIgnoreCase("i")) {
			System.out.println("ID?:");
			int id = kb.nextInt();
			if(vd.searchVideobyID(id)!=null) {
				System.out.println(vd.searchVideobyID(id));
			}
			else {
				System.out.println("Filme não foi encontrado");
			}
		}
		else {
			System.out.println("Titulo ou parte dele:");
			String tl = kb.nextLine();
			if(vd.searchVideobyTitle(tl)!=null) {
				for (int i = 0; i < vd.searchVideobyTitle(tl).size(); i++) {
					System.out.println(vd.searchVideobyTitle(tl).get(i));
				}
			}
			else {
				System.out.println("Filme não foi encontrado");
			}
		}
	}
	public static void checkout(ListVideo vl, ListClient cl, Loans base) {
		System.out.println("ID do Filme:");
		int id = kb.nextInt();
		System.out.println("Numero de Socio:");
		int ns = kb.nextInt();
		kb.nextLine();
		base.CheckOut(id,ns,vl,cl,Nmax);
	}
	
	public static void checkin(ListVideo vl, ListClient cl, Loans base) {
		System.out.println("ID do Filme:");
		int id = kb.nextInt();
		System.out.println("Numero de Socio:");
		int ns = kb.nextInt();
		kb.nextLine();
		System.out.println("Ranking?:");
		int r = kb.nextInt();
		kb.nextLine();
		base.CheckIn(id,ns,vl,cl,r);
	}
	
	public static void State(ListVideo vl, ListClient cl, Loans base) {
		System.out.println("ID do Filme:");
		int id = kb.nextInt();
		if(vl.searchVideobyID(id).check() == true) {
			System.out.println("O video está alugado");
		}
		else {System.out.println("O video não está alugado");}
	}
	
	public static void ListVid(Loans ld) {
		System.out.println("Por Cliente ou por video? [c/v]");
		String op = kb.nextLine();
		if (op.equalsIgnoreCase("v")) {
			System.out.println("ID?");
			int id = kb.nextInt();
			System.out.println(ld.search(id));
		}
		else {
			System.out.println("Num.Socio?");
			int ns = kb.nextInt();
			System.out.println(ld.searchbyClient(ns));
		}
	}
	
	public static void ListRM(ListVideo vl) {
		System.out.println("Ranking?");
		int r = kb.nextInt();
		System.out.println(vl.searchVideobyRanking(r));
	}
	
	public static void ini(ListClient lc, ListVideo lv, Loans ld) {
		lv.addVideo(new Video(idv, "Mickey Mouse", "Animação", "ALL")); 
        idv++;
        lv.addVideo(new Video(idv, "Matrix", "Sci-fi", "M16"));
        idv++; 
        lv.addVideo(new Video(idv, "Inspetor Megret", "Policial", "M18"));
        idv++;
        lv.addVideo(new Video(idv, "A Branca de neve e os sete anões", "Animação", "M6"));
        idv++;
        lv.addVideo(new Video(idv, "MIB", "Alians", "ALL"));
        idv++;
        lc.addClient(new Estudante(888888, "NTC", ns, new Data(), "Jorge Paiva", 1898999,new Data(13,11,1995)));
        ns++;
        lc.addClient(new Estudante(940303, "EET", ns, new Data(), "Carla Esteves", 1600232,new Data(01,12,2001)));
        ns++;
        lc.addClient(new Funcionario(111111, 122221, ns,new Data() , "Amy Esteves", 1700732,new Data(01,12,1965)));
        ns++;
	}
}

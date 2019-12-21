package aula7.ex1;

public class TesteHora {

	public static void main(String[] args) {
		Hora h1 = new Hora(11,00);
		Hora h2 = new Hora(11,59);
		Hora h3 = new Hora(23,59);
		Hora h4 = new Hora(23,00);
		
		System.out.println("1h30");
		System.out.println("-------");
		System.out.println(h1.hatraso(new Hora(1,30)));
		System.out.println(h2.hatraso(new Hora(1,30)));
		System.out.println(h3.hatraso(new Hora(1,30)));
		System.out.println(h4.hatraso(new Hora(1,30)));
		System.out.println("-------");
		System.out.println("0h59");
		System.out.println("-------");
		System.out.println(h1.hatraso(new Hora(0,59)));
		System.out.println(h2.hatraso(new Hora(0,59)));
		System.out.println(h3.hatraso(new Hora(0,59)));
		System.out.println(h4.hatraso(new Hora(0,59)));
		System.out.println("-------");
		System.out.println("0h30m");
		System.out.println("-------");
		System.out.println(h1.hatraso(new Hora(0,30)));
		System.out.println(h2.hatraso(new Hora(0,30)));
		System.out.println(h3.hatraso(new Hora(0,30)));
		System.out.println(h4.hatraso(new Hora(0,30)));
		System.out.println("-------");
	}

}

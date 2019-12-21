package aula3.Ex3;

import aula3.Data;

public class Teste3 {

	public static void main(String[] args) {
		Condutor a1 = new Condutor("Hugo Leal", 19999, new Data(1,12,2000), 'B');
		Condutor a2 = new Condutor("Maria Cunha", 43232, new Data(4,9,2000), 'C');
		Condutor a3 = new Condutor("Jorge Esteve", 33423, new Data(1,12,1968), 'D');
		Condutor a4 = new Condutor("George Michael", 12323, new Data(1,12,1998), 'A');
		Ligeiro l = new Ligeiro(120, 72, 4, 1200);
		Motociclo m = new Motociclo(95, 77, 2, 800);
		PesadoMerc p = new PesadoMerc(322, 88, 2, 3800);
		PesadoPass pp = new PesadoPass(322, 90, 12, 4500);
	
		System.out.println("Testar que tipo de veiculos cada condutor pode conduzir");
		System.out.println("-------");
		System.out.println("Ligeiro");
		System.out.println(a1.getLicence() + " -> "+ l.CanDrive(a1));
		System.out.println(a2.getLicence() + " -> "+ l.CanDrive(a2));
		System.out.println(a3.getLicence() + " -> "+ l.CanDrive(a3));
		System.out.println(a4.getLicence() + " -> "+ l.CanDrive(a4));
		System.out.println("Motociclo");
		System.out.println(a1.getLicence() + " -> "+ m.CanDrive(a1));
		System.out.println(a2.getLicence() + " -> "+ m.CanDrive(a2));
		System.out.println(a3.getLicence() + " -> "+ m.CanDrive(a3));
		System.out.println(a4.getLicence() + " -> "+ m.CanDrive(a4));
		System.out.println("Pessado de Mercadoria");
		System.out.println(a1.getLicence() + " -> "+ p.CanDrive(a1));
		System.out.println(a2.getLicence() + " -> "+ p.CanDrive(a2));
		System.out.println(a3.getLicence() + " -> "+ p.CanDrive(a3));
		System.out.println(a4.getLicence() + " -> "+ p.CanDrive(a4));	
		System.out.println("Pessado de Passageiros");
		System.out.println(a1.getLicence() + " -> "+ pp.CanDrive(a1));
		System.out.println(a2.getLicence() + " -> "+ pp.CanDrive(a2));
		System.out.println(a3.getLicence() + " -> "+ pp.CanDrive(a3));
		System.out.println(a4.getLicence() + " -> "+ pp.CanDrive(a4));	
		System.out.println();
		System.out.println("-------");
		System.out.println();
		System.out.println("Testar entrada e saida de passageiros");
		System.out.println("------");
		System.out.println();
		l.addPassageiro();
		l.addPassageiro();
		l.addPassageiro();
		l.addPassageiro();
		l.addPassageiro();
		l.addPassageiro();
		l.removePassageiro();
	}

}

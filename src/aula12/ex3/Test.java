package aula12.ex3;

import aula12.ex3.plugins.CSV;
import aula12.ex3.plugins.Nokia;
import aula12.ex3.plugins.vCard;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		Agenda ag = new Agenda();
		
		System.out.println("Teste do Nokia");
		ag.load("src/aula12/ex3/File1.txt");
		ag.loadCon(new Pessoa[] {new Pessoa("Jorge",911593233, new Data(1,12,1994))});
		ag.write("src/aula12/ex3/OutputFile1.txt", new Nokia());
		System.out.println("A agenda #1 tem "+ag.getNumContacts()+" contactos:");
		System.out.println(ag);
		System.out.println();

		System.out.println("Teste do CSV");
				ag = new Agenda();
				ag.load("src/aula12/ex3/File3.txt");
				ag.loadCon(new Pessoa[] {
						new Pessoa("Ana",913533433, new Data(14,12,1999)),
						new Pessoa("Paulo",931523133, new Data(1,2,1993))});
				ag.write("src/aula12/ex3/OutputFile3.txt", new CSV());
				System.out.println("A agenda #3 tem "+ag.getNumContacts()+" contactos:");
				System.out.println(ag);
				System.out.println();


		System.out.println("Teste do vCard");
		ag = new Agenda();ag.load("src/aula12/ex3/File2.txt");
		ag.loadCon(new Pessoa[] {
				new Pessoa("Michael",911592222, new Data(5,3,1933)),
				new Pessoa("Mariah",912324541, new Data(4,4,2001)),
				new Pessoa("Britney",932443232, new Data(11,5,1982)),
				new Pessoa("Mick",931533222, new Data(12,3,1943)),
		});
		ag.loadCon(new Pessoa[] {new Pessoa("Stevie",924543211, new Data(1,12,1974))});
		ag.write("src/aula12/ex3/OutputFile2.txt",new vCard());
		System.out.println("A agenda #2 tem "+ag.getNumContacts()+" contactos:");
		System.out.println(ag);
		System.out.println();
		
		
	}

}

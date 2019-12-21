package aula7.ex1;

import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) throws IOException{
		ReadVooFile a = new ReadVooFile();
		a.read("/mnt/sda3/Users/HMLL/OneDrive - Universidade de Aveiro/UNI/2ano/PIII/pratica_wokspace/p3/src/aula7/ex1/voos.txt","/mnt/sda3/Users/HMLL/OneDrive - Universidade de Aveiro/UNI/2ano/PIII/pratica_wokspace/p3/src/aula7/ex1/companhias.txt");
		a.printVoos();
		System.out.println();
		a.printDelayTable();
		System.out.println();
		a.NumberofFlights();
		System.out.println();
		a.writeToFileCities("/mnt/sda3/Users/HMLL/OneDrive - Universidade de Aveiro/UNI/2ano/PIII/pratica_wokspace/p3/src/aula7/ex1/cidades.txt");
		a.writeToFile("/mnt/sda3/Users/HMLL/OneDrive - Universidade de Aveiro/UNI/2ano/PIII/pratica_wokspace/p3/src/aula7/ex1/Infopublico.txt");
		
		if(a.writoToBinaryFile("Infopublico.bin")) 
			System.out.println("Sucesso!\n");
		else
			System.out.println("Erro \n");
		
		if(a.readFromBinaryPrint("Infopublico.bin")) 
			System.out.println("Sucess!\n");
		else
			System.out.println("Erro\n");
	
		System.out.println("Done!");
	}

}

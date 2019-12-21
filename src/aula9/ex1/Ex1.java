package aula9.ex1;

import java.io.File;

public class Ex1 {

	public static void main(String[] args) {
		File f = new File("test.txt");
		ScannerAbeirense s = new ScannerAbeirense(f);
		System.out.println(s.next());
		while(s.hasNext()) {
			System.out.println(s.nextLine());
		}
	}

}

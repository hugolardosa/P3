
package aula9.ex1;

import java.io.*;
import java.util.*;

public class ScannerAbeirense implements Closeable, Iterator<String> {
	private Scanner read;
	
	public ScannerAbeirense(File f) {
		try {
			read = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The file was not found");
		}
	}
	@Override
	public void close() throws IOException {
		read.close();
	}

	@Override
	public boolean hasNext() {
		// 
		return read.hasNext();
	}

	@Override
	public String next() {
		return LetterSwapSantiago(read.next());
	}
	
	public String LetterSwapSantiago(String s) {
		s = s.replaceAll("V", "B");
		s = s.replaceAll("v", "b");
		return s;
	}
	
	public String nextLine() {
		return (LetterSwapSantiago(read.nextLine()));
	}
	

}

package aula5.ex3;
import java.io.*;
public interface FileType {
	public Pessoa[] InfoFromFile(String filen) throws IOException;
	public void InfoToFile(String filen, Pessoa[] p) throws IOException;
}

package aula12.ex3;

import java.io.IOException;

public interface IPlugin {
	public boolean verifyclass(String name);
	public Pessoa[] InfoFromFile(String filen) throws IOException;
	public void InfoToFile(String filen, Pessoa[] p) throws IOException;
}

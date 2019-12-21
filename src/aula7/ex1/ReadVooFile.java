package aula7.ex1;

import java.nio.file.*;
import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadVooFile {
	private ArrayList<Voo> f = new ArrayList<>();
	private HashMap<String,String> d = new HashMap<>();
	
	public void read(String pathname, String CompFilename) throws IOException{
		Path p = Paths.get(pathname);
		List<String> lines = Files.readAllLines(p);
		
		Path c = Paths.get(CompFilename);
		List<String> clines = Files.readAllLines(c);
		
		//ler companhias do ficheiro
		for (int i = 0; i < clines.size(); i++) {
			if(i==0)continue;
			String[] l = clines.get(i).split("\t");
			d.put(l[0], l[1]);
		}
		
		//ler VOOS do ficheiro
		for (int i = 0; i < lines.size(); i++) {
			if(i==0)continue;
			String[] l = lines.get(i).split("\t");
			String Company = d.get(l[1].substring(0, 2));
			if(Company == null) continue;
			Hora delay;
			if(l.length < 4) delay = new Hora(0,0);
			else {
				delay = new Hora(Integer.parseInt(l[3].substring(0, 2)),Integer.parseInt(l[3].substring(3, 5)));
			}
			f.add(new Voo(new Hora(Integer.parseInt(l[0].substring(0, 2)),Integer.parseInt(l[0].substring(3, 5))),l[1],Company,l[2],delay, "help"));
			
		}
		
	}
	
	public void printVoos() {
		System.out.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObs");
		for(Voo v: f) {
			System.out.println(v);
		}
	}
	
	private String VoostoString() {
		String r = "Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObs\n";
		for(Voo v: f) {
			r = r + v + "\n" ;
		}
		return r;
	}
	
	public void printDelayTable() {
		List<VooAtraso> t = new ArrayList<>();	
		System.out.println("Companhia\t\tAtraso em Minutos");
		for(String cp : d.values().toArray(new String[0])) {
			int sum = 0;
			int count = 0;
			for(Voo voo : f.toArray(new Voo[0])) {
				if(voo.getCompanhia().equalsIgnoreCase(cp)) {
					sum += voo.getDelayM();
					count++;
				}
			}
			t.add(new VooAtraso(cp,(int)(sum/count)));
		}
		
		Collections.sort(t,new Comparator<VooAtraso>() {

			@Override
			public int compare(VooAtraso a0, VooAtraso a1) {
				return a0.getAtraso() - a1.getAtraso();
			}
		});
		
		for(VooAtraso fly : t) {
			System.out.printf(String.format("%-18s\t%s\n", fly.getCompanhia(), fly.getAtraso()));
		}
	}
	
	
	public String NumberofFlights() {
		String end="";
		HashMap<String,Integer> r = new HashMap<String,Integer>();
		Voo[] cp = f.toArray(new Voo[0]);
		for (Voo v : cp) {
			if(r.containsKey(v.getOrigem())) {
				r.put(v.getOrigem(), (r.get(v.getOrigem()) + 1));
			}
			else {
				r.put(v.getOrigem(), 1);
			}
		}
		
		end+= "Origem	Voo\n";
		
		String[] sortedOrigens = r.keySet().toArray(new String[0]);
		Arrays.sort(sortedOrigens, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return r.get(o1)-r.get(o2);
			}
			
		});
		for(String og : sortedOrigens) {
			end+=(String.format("%-18s\t%s\n", og, r.get(og)));
		}
		
		return end;
	}
	
	public boolean writeToFile(String pathname) throws IOException {
		Files.write(Paths.get(pathname),VoostoString().getBytes());
		return true;
	}
	
	public boolean writeToFileCities(String pathname) throws IOException {
		Files.write(Paths.get(pathname),NumberofFlights().getBytes());
		return true;
	}
	
	public boolean writoToBinaryFile(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path, "rw");
		file.write(VoostoString().getBytes());
		file.close();
		return true;
	}
	
	public boolean readFromBinaryPrint(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path, "rw");
		byte[] info = new byte[(int)file.length()];
		file.readFully(info);
		file.close();
		System.out.println(new String(info));
		return true;
	}
}

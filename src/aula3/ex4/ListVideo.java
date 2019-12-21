package aula3.ex4;
import java.util.*;

public class ListVideo { 
	private ArrayList<Video> v;
	public ListVideo() {
		this.v = new ArrayList<Video>();
	}
	
	public void addVideo(Video vide) {
		this.v.add(vide);
	}
	
	public void removeVideo(int ID) {
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i).getID() == ID) {
				this.v.remove(i);
			}
		}
	}
	
	public void PrintList() {
		for (int i = 0; i < this.v.size(); i++) {
			System.out.println(v.get(i));
		}		
	}
	
	public Video searchVideobyID(int id) {
		for (int i = 0; i < this.v.size(); i++) {
			if(v.get(i).getID() == id) {
				return v.get(i);
			}
		}
		return null;
	}
	
	
	public ArrayList<Video> searchVideobyTitle(String Title) {
		ArrayList<Video> search = new ArrayList<Video>();
		for (int i = 0; i < this.v.size(); i++) {
			if(v.get(i).getTitulo().toLowerCase().contains(Title.toLowerCase())) {
				search.add(v.get(i));
			}
		}
		return search;
	}
	
	public ArrayList<Video> searchVideobyRanking(int RM){
		ArrayList<Video> search = new ArrayList<Video>();
		for (int i = 0; i < this.v.size(); i++) {
			if(v.get(i).getRM() == (RM)) {
				search.add(v.get(i));
			}
		}
		return search;
	}
	
}

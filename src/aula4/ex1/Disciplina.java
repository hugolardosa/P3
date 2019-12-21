package aula4.ex1;

import java.util.ArrayList;

public class Disciplina {
	private String NomedoCurso;
	private String AreaCientifica;
	private int ECTS;
	private Professor prof;
	private ArrayList<Estudante> e;
	
	public Disciplina(String NomedCurso, String ac, int ects, Professor p) {
		this.NomedoCurso=NomedCurso;
		this.AreaCientifica=ac;
		this.ECTS=ects;
		this.prof=p;
		e = new ArrayList<Estudante>();
	}
	
	public boolean addAluno(Estudante est) {
		if (alunoInscrito(est.nMec())) {
			return false;
		}
		return e.add(est);
	}
	
	public boolean delAluno(int nMec) {
		if(e.isEmpty()) {
			return false;
		}
		else {
			for (int i = 0; i < this.e.size(); i++) {
				if(e.get(i).nMec() == nMec) {
					return e.remove(e.get(i));
				}
			}
		}
		return false;
	}
	public boolean alunoInscrito(int nMec) {
		for (int i = 0; i < e.size(); i++) {
			if (e.get(i).nMec() == nMec) {
				return true;
			}
		}
		return false;
	}
	
	public int numAlunos() {
		return e.size();
	}
	
	@Override
	public String toString() {
		return String.format("Disciplina: %s ( %d ECTS) da Area de %s\n RESPONSAVEL: Professor: %s \n Existem %d alunos inscritos", this.NomedoCurso, this.ECTS,this.AreaCientifica,this.prof,this.numAlunos());
	}

	public Estudante[] getAlunos() {
		return e.toArray(new Estudante[0]);
	}
	
	public Estudante[] getAlunos(String tipo) {
		ArrayList<Estudante> tmp = new ArrayList<Estudante>();
		for (int i = 0; i < e.size(); i++) {
			if (e.get(i).getClass().getSimpleName().equalsIgnoreCase(tipo)) {
				tmp.add(e.get(i));
			}
		}
		return tmp.toArray(new Estudante[0]);
	}

}

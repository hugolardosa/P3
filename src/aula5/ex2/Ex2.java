package aula5.ex2;


public class Ex2 {

	public static void main(String[] args) {
		
		Veiculo v1 = new Moto(2,"Rosa",1999,120,13,"12-FR-60",false);
		Veiculo v2 = new MotoPolicia(2,"Preta",2006,171,210,"AC-45-CT",false);
		Veiculo v3 = new Automovel(4,"cinzento",1997,180,300,"MF-34-EI",5);
		Veiculo v4 = new Moto(2, "preto", 2003, 150, 150,"LH-77-34",true);
		
		Automovel a1 = new Automovel(4,"preto",2001,150,400,"AA-54-BF",5);
		Moto m1 = new Moto(2,"preto", 2015,130, 125,"BH-87-34",false);
		Bicicleta b1 = new Bicicleta(2,"azul",2013,"Trek");
		
		CarroPolicia a2 = new CarroPolicia(4,"branco",2010,160, 300,"AH-42-GK", 7);
		MotoPolicia m2 = new MotoPolicia(2, "preto", 2004, 140, 200, "43-GJ-54",false);
		BicicletaPolicia b2 = new BicicletaPolicia(2,"branca",2011,"Trek");
		
		System.out.println("TESTE VEICULO");
		System.out.println(v1 + " ID: " + v1.getId());
		System.out.println();
		
		System.out.println("TESTE AUTOMOVEL");
		System.out.println(a1 + " Lotação: " + a1.getLotacao() + " Matrícula: " +a1.getMatricula() + " Ano: " + a1.getAno());
		System.out.println();
		
		System.out.println("TESTE MOTO");
		System.out.println(m1 +" Ano: " + m1.getAno());
		if (m1.hasSidecar()) System.out.println("Mota com Sidecar");
		System.out.println();
		
		System.out.println("TESTE BICICLETA");
		System.out.println(b1 + " Marca: " +b1.getMarca() + " Cor: " + b1.getColor());
		System.out.println();
		
		System.out.println("TESTE POLICIA");
		System.out.println(a2 + " Matrícula: " + a2.getMatricula() + " ID: " + a2.getID() + " TIPO: " + a2.getTipo());
		System.out.println(m2 + " Matrícula: " + m2.getMatricula() + " ID: " + m2.getID() + " TIPO: " + m2.getTipo());
		System.out.println(b2 + " ID: " + b2.getID() + " TIPO: " + b2.getTipo());
		System.out.println();
		
		System.out.println("TESTE SORT");
		Veiculo[] lista = new Veiculo[4];
		lista[0] = v1;
		lista[1] = v2;
		lista[2] = v3;
		lista[3] = v4;
		UtilCompare.sortArray(lista);
		
		for (Veiculo v : lista) {
			System.out.println(v);
		}
		
	}

}

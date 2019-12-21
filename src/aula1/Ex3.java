package aula1;

public class Ex3 {

	public static void main(String[] args) {
			Circulo c1 = new Circulo(1.0,1.0,25.0);
			Ponto raio2 = new Ponto(2.0,1.0);
			Circulo c2 = new Circulo(raio2, 6.0);
			System.out.println(c1.area());
			System.out.println(c1.toString());
			System.out.println(c2.toString());
			Retangulo r1 = new Retangulo(3.0,4.0);
			System.out.println(r1.perimetro());
			System.out.println(c1.intersect(c2));
			System.out.println(c1.equals(c2));
			Quadrado q1 = new Quadrado(2.0);
			System.out.println(r1.toString());
			System.out.println(q1.toString());
			

	}

}

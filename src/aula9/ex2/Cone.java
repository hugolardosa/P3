package aula9.ex2;

public class Cone extends Decorator{
    public Cone(Gelado ice) {
        super(ice);
    }

    public void base(int i){
        g.base(i);
        System.out.println(" em cone");
    }
}

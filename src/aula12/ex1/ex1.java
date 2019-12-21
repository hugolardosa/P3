package aula12.ex1;

public class ex1 {
    public static void main(String[] args) {
        Circulo c = new Circulo(2, 2, 2);
        ClassReader.class_dumper(c);
        //ClassReader.createObject(c.getClass());
        System.out.println(ClassReader.createObject(c.getClass()).toString());

    }


}

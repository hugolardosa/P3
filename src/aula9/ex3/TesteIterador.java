package aula9.ex3;

public abstract class TesteIterador {
    public static void main(String[] args) {
        VectorPessoas vp = new VectorPessoas();
        Data d = Data.today();
        for (int i=0; i<10; i++)
            vp.addPessoa(new Pessoa("Bebé no Vector "+i,
                    1000+i, Data.today()));
        Iterator vec = vp.iterator();
        while ( vec.hasNext() )
            System.out.println( vec.next() );
        ListaPessoas lp = new ListaPessoas();
        for (int i=0; i<10; i++)
            lp.addPessoa(new Pessoa("Bebé na Lista "+i,
                    2000+i, Data.today()));
        Iterator lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );
    }
}

package aula9.ex3;

public class VectorPessoas {
    private Pessoa[] vetor;
    private int size;
    private int n_pessoas;

    public VectorPessoas(int size){
        this.size=size;
        vetor = new Pessoa[size];
        n_pessoas = 0;
    }
    public VectorPessoas(){
        this(50);
    }

    public boolean addPessoa(Pessoa p){
        if(p == null)return false;
        if(n_pessoas + 1 > size){
            size+=20;
            Pessoa[] temp = new Pessoa[size];
            System.arraycopy(vetor,0,temp,0,n_pessoas);
            vetor = temp;
            vetor[n_pessoas++] = p;
            return true;
        }
        vetor[n_pessoas++] = p;
        return true;
    }
    public boolean removePessoa(Pessoa p){
        for (int i = 0; i <n_pessoas; i++) {
            if (vetor[i] == p) {
                n_pessoas--;
                for (int j = i; j < n_pessoas; j++) {
                    vetor[j] = vetor[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public int totalPessoas(){
        return n_pessoas;
    }

    public Iterator iterator(){
        return new VectorIterator();
    }

    public BFIterator BFiterator(){
        return new BFVectorIterator();
    }

    private class VectorIterator implements Iterator {
        private int i;
        @Override
        public boolean hasNext() {
            return (i < n_pessoas);
        }

        @Override
        public Object next() {
            if(hasNext()){
                Object r = vetor[i];
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ n_pessoas +" elements");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Nao suportada");
        }
    }

    private class BFVectorIterator implements BFIterator {
        private int i;

        @Override
        public boolean hasPrevious() {
            return (i >= n_pessoas);
        }

        @Override
        public Object previous() {
            if(hasPrevious()){
                Object r = vetor[i];
                i--;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ n_pessoas +" elements");
        }

        @Override
        public boolean hasNext() {
            return (i < n_pessoas);
        }

        @Override
        public Object next() {
            if(hasNext()){
                Object r = vetor[i];
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ n_pessoas +" elements");
        }
    }


}


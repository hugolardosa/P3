package aula9.ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaPessoas {

    private List<Pessoa> pessoas = new LinkedList<>();

    public boolean addPessoa(Pessoa p){
        return pessoas.add(p);
    }
    public boolean removePessoa(Pessoa p){
        return pessoas.remove(p);
    }
    public int totalPessoas(){
        return pessoas.size();
    }

    public Iterator iterator(){
        return new ListaIterator();
    }

    public BFIterator BFiterator(){
        return new BFListaIterator();
    }

    private class ListaIterator implements Iterator {
        private int i;
        @Override
        public boolean hasNext() {
            return (i < pessoas.size());
        }

        @Override
        public Object next() {
            if(hasNext()){
                Object r = pessoas.get(i);
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ pessoas.size() +" elements");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Nao suportada");
        }
    }

    private class BFListaIterator implements BFIterator {
        private int i;

        @Override
        public boolean hasPrevious() {
            return (i >= pessoas.size());
        }

        @Override
        public Object previous() {
            if (hasPrevious()) {
                if(i < 0)
                    throw new NoSuchElementException();
                Object n = pessoas.get(i);
                i--;
                return n;
            }
            throw new IndexOutOfBoundsException("only "+pessoas.size()+" elements");
        }

        @Override
        public boolean hasNext() {
            return (i < pessoas.size());
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object r = pessoas.get(i);
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only " + pessoas.size() + " elements");
        }
    }


}

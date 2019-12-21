package aula11.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VectorGeneric<T> implements Iterable<T>{

    private List<T> objects = new ArrayList<>();
    //private ListaIterator iterador = new ListaIterator();

    public boolean addElem(T p){
        return objects.add(p);
    }
    public boolean addArray(T[] p){
        if (p == null)return false;
        for( T elem : p){
            objects.add(elem);
        }
        return true;

    }
    public boolean removeElem(T p){
        return objects.remove(p);
    }
    public int totalElem(){
        return objects.size();
    }

    @Override
    public Iterator iterator() {
        return new ListaIterator();
    }


    /*public BFIterator BFiterator(){
        return new BFListaIterator();
    }*/

    private class ListaIterator implements Iterator<T> {
        private int i;
        @Override
        public boolean hasNext() {
            return (i < objects.size());
        }

        @Override
        public T next() {
            if(hasNext()){
                T r = objects.get(i);
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ objects.size() +" elements");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Nao suportada");
        }
    }

    /*private class BFListaIterator implements BFIterator {
        private int i;

        @Override
        public boolean hasPrevious() {
            return (i >= objects.size());
        }

        @Override
        public java.lang.Object previous() {
            if (hasPrevious()) {
                if(i < 0)
                    throw new NoSuchElementException();
                java.lang.Object n = objects.get(i);
                i--;
                return n;
            }
            throw new IndexOutOfBoundsException("only "+ objects.size()+" elements");
        }

        @Override
        public boolean hasNext() {
            return (i < objects.size());
        }

        @Override
        public java.lang.Object next() {
            if (hasNext()) {
                java.lang.Object r = objects.get(i);
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only " + objects.size() + " elements");
        }
    }*/


}

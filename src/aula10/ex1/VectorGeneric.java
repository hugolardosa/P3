package aula10.ex1;

import java.util.Iterator;

public class VectorGeneric<T> implements Iterable<T>{
    private T[] vetor;
    private int size;
    private int used;
    Iterator iterador = new VectorIterator();

    public VectorGeneric(int size){
        this.size=size;
        vetor = (T[]) new Object[size];
        used = 0;
    }
    public VectorGeneric(){
        this(50);
    }

    public boolean addElem(T p){
        if(p == null)return false;
        if(used + 1 > size){
            size+=20;
            T[] temp = (T[]) new Object[size];
            System.arraycopy(vetor,0,temp,0, used);
            vetor = temp;
            vetor[used++] = p;
            return true;
        }
        vetor[used++] = p;
        return true;
    }
    public boolean removeElem(T p){
        for (int i = 0; i < used; i++) {
            if (vetor[i] == p) {
                used--;
                for (int j = i; j < used; j++) {
                    vetor[j] = vetor[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public int totalElem(){
        return used;
    }

    @Override
    public Iterator iterator() {
        return iterador;
    }

    private class VectorIterator implements Iterator<T> {
        private int i=0;
        @Override
        public boolean hasNext() {
            return (i < used);
        }

        @Override
        public T next() {
            if(hasNext()){
                T r = vetor[i];
                i++;
                return r;
            }
            throw new IndexOutOfBoundsException("only "+ used +" elements");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Nao suportada");
        }
    }

}


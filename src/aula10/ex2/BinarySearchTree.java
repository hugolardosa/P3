
package aula10.ex2;

import java.util.Iterator;
import java.lang.Comparable;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>>
        implements Iterable<T> {
    // o elemento do tipo T deve ser comparável para efectuar pesquisas
    // mas como pode herdar a implementação de compareTo() é mais correcto
    // usar <? super T>
    private static class BSTNode<T> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T theElement) {
            element = theElement;
            left = right = null;
        }
    }

    private BSTNode<T> root;
    private int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;
    }

    public void insert(T value) {
        root = insert(value, root);
    }

    private BSTNode<T> insert(T value, BSTNode<T> root){
        if (root == null) {
            return new BSTNode<T>(value);
        }

        if (value.compareTo(root.element)<0) {
            root.left = insert(value, root.left);
        } else if (value.compareTo(root.element) > 0) {
            root.right = insert(value, root.right);
        } else {
            // value already exists
            return root;
        }

        return root;
    }

    public void remove(T value) {
        root = remove(value, root);
    }

    private BSTNode<T> remove(T value, BSTNode<T> root){
        if (root == null) {
            return new BSTNode<T>(value);
        }

        if(value.equals(root.element)){
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }
            else{
                T s = findSmall(root.right);
                root.element = s;
                root.right = remove(s, root.right);
                return root;
            }
        }

        if (value.compareTo(root.element)<0) {
            root.left = remove(value, root.left);
        } else if (value.compareTo(root.element) > 0) {
            root.right = remove(value, root.right);
        } else {
            // value already exists
            return root;
        }

        return root;
    }

    private T findSmall(BSTNode<T> root) {
        if(root.left == null) return root.element;
        findSmall(root.left);
        return null;
    }

    public boolean contains(T value) {
        return valueOf(find(value, root)) != null;
    }

    private Object valueOf(Object o) {
        return o;
    }

    public boolean find(T value, BSTNode<T> root) {
        return contains(value, root);
    }

    private boolean contains(T value, BSTNode<T> root) {
        if (root == null) {
            return false;
        }
        if (value == root.element) {
            return true;
        }
        if (value.compareTo(root.element) <0){
            return contains(value, root.left);
        }
        return contains(value, root.right);
    }

    public Iterator<T> iterator() {
        return new treeIterador(root);
    }

    public class treeIterador implements Iterator<T>{
        Stack<BSTNode<T>> s;

        //carragamos para a Stack a Tree
        public treeIterador(BSTNode<T> root) {
            s = new Stack<BSTNode<T>>();
            while (root != null) {
                s.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !s.isEmpty();
        }

        @Override
        public T next() {
            BSTNode<T> n = s.pop();
            T top = n.element;
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    s.push(n);
                    n = n.left;
                }
            }
            return top;
        }
    }


}

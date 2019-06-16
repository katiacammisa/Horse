package TpHashTable;

import Interfaces.Hashable;
import Lists.DynamicList;
import TpBinaryTreeSearch.SearchBinaryTree;

public class ClosedHashTable<T extends Hashable> {

    private int capacity;
    private Object[] t;

    public ClosedHashTable(int M) {
        if (!Prime.isPrime(M))
            M = Prime.proxPrime(M);
        capacity = M;
        t = new DynamicList[M];
    }

    private void insert (T x) {
        double counter = 0;
        for (Object aT : t)
            if (aT != null)
                counter++;

        if(counter/capacity >= 0.8)
            rehash();

        int k =(x).hash(capacity);
        if(t[k] != null){
            for (int i = k; i < capacity; i++) {
                if(t[i] == null){
                    k = i;
                    break;
                }
            }

        }
        t[k] = x;
    }

    public Object search (int x) {
        return t[x];
    }

    public boolean exists(T x){
        int k = x.hash(capacity);
        for (int i = k; i < capacity; i++) {
            if(t[i] == null){
                return false;
            }
            if(t[i] == x){
                return true;
            }
        }

        return false;
    }

    public SearchBinaryTree getBinarySearchTree () {
        SearchBinaryTree a = new SearchBinaryTree();
        for (int i = 0; i < capacity; i++ ) {
            a.insert((Comparable) t[i]);
        }
        return a;
    }


    private void rehash(){

        capacity = Prime.proxPrime(capacity*2);
        Object[] aux = t;
        t = new Object[capacity];

        for (int i = 0; i < t.length; i++) {
            if(aux[i] != null){
                insert((T)aux[i]);
            }
        }
    }
}

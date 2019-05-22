package TpHashTable;

import Interfaces.Comparable;
import Interfaces.Hashable;
import Lists.DynamicList;
import TpBinaryTreeSearch.SearchBinaryTree;

public class ClosedHashTable<T extends Hashable> {

    private int capacity;
    private Object[] t;
    private Function op2;

    public ClosedHashTable(int M) {
        if (!Prime.isPrime(M))
            M = Prime.proxPrime(M);
        capacity = M;
        t = new DynamicList[M];
    }

    public void insert (T x) {
        int k =(x).hash(capacity);
        if(t[k] != null){

        }
        t[k] = x;
    }

    public Object search (T x) {
        int k = x.hash(capacity);
        return t[k];
    }

    public SearchBinaryTree getBinarySearchTree () {
        SearchBinaryTree a = new SearchBinaryTree();
        for (int i = 0; i < capacity; i++ ) {
            a.insert((Comparable) t[i]);
        }
        return a;
    }
}

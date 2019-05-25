package TpHashTable;


import Interfaces.Hashable;
import Lists.DynamicList;
import TpBinaryTreeSearch.SearchBinaryTree;

public class OpenHashTable<T extends Hashable> {

    private DynamicList[] t;
    private int capacity;

    public OpenHashTable(int M) {
        if (!Prime.isPrime(M))
            M = Prime.proxPrime(M);
        capacity = M;
        t = new DynamicList[M];
        for(int i = 0; i < M ; i++)
            t[i] = new DynamicList();
    }

    public void insert (T x) {
        int k = x.hash(capacity);
        t[k].insertNext(x);
    }
    public Object search (T x) {
        int k = x.hash(capacity);
        t[k].first();
        int l = t[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].getActual())== 0)
                return t[k].getActual();
        return x;
    }
    public SearchBinaryTree<Comparable> getBinarySearchTree () {
        SearchBinaryTree<Comparable> a = new SearchBinaryTree<>();
        for (int i = 0; i < capacity; i++ ) {
            if (!t[i].isVoid()) {
                t[i].first();
                for (int j = 0; j < t[i].size() ; j++) {
                    a.insert((Comparable)t[i].getActual());
                    t[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }

    public int getCapacity() {
        return capacity;
    }
}

package TpHashTable;

import Interfaces.Hashable;
import Lists.DynamicList;

public class ClosedHashTable<T extends Hashable> {

    private int capacity;
    private Object[] t;

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
}

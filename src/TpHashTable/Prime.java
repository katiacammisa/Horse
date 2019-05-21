package TpHashTable;

public class Prime {

    public static boolean isPrime(int n) {
        if (n == 1 || n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        else {
            int k = 3;
            while (k <= Math.sqrt(n)) {
                if (n % k == 0)
                    return false;
                k = k +2;
            }
        }
        return true;
    }
    public static int proxPrime(int n) {
        if (n % 2 == 0)
            n++;
        while (!isPrime(n))
            n = n + 2;
        return n;
    }
}

package EjEstresDeTiempo;

import java.util.ArrayList;
import java.util.List;

public class Ej1 {

    public static void main(String[] args) {
        sort(5, 9, 8, 2);
    }

    public static void sort(int a, int b, int c, int d){
        List<Integer> order = new ArrayList();
        order.add(a);
        order.add(b);
        order.add(c);
        order.add(d);
        int i = 0;
        while(order.get(i) > order.get(i+1)){
            if(order.get(i) > order.get(i+1)){
                int aux = order.get(i);
                order.set(i, order.get(i+1));
                order.set(i+1, aux);
            }
            ++i;
        }
        System.out.println(order.toString());
    }
}

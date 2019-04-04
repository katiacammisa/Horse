package Cola;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest{

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(5);

    @Test
    public void xxxx() {
       queue.add(56, 1);
       queue.add(7, 2);
        queue.add(72, 2);
        queue.add(92, 2);
       queue.add(40, 2);
        System.out.println(queue.peek());
        System.out.println(queue.peek(2));
        queue.dequeue();
        System.out.println(queue.peek());
    }
}
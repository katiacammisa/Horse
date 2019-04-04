package Cola;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest{

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(5);

    @Test
    public void peek() {
       queue.add(56, 1);
       queue.add(7, 1);
       queue.add(40, 2);
        System.out.println(queue.peek());
        System.out.println(queue.peek(2));
    }

    @Test
    public void peek1() {
    }

    @Test
    public void add() {
    }

    @Test
    public void dequeue() {
    }
}
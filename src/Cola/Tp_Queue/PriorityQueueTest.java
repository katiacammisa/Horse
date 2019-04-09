package Cola.Tp_Queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);

    @Test
    public void self() {
        priorityQueue.add(1, 1);
        priorityQueue.add(2, 2);
        priorityQueue.add(3, 3);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek(2));
        priorityQueue.dequeue();
        System.out.println(priorityQueue.peek());
    }
}

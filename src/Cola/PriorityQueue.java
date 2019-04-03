package Cola;


import Queue.DynamicQueue;

public class PriorityQueue<T> {
    private DynamicQueue<T>[] queues;

    public PriorityQueue(int minimumPriority) {
        queues = new DynamicQueue[minimumPriority];
    }

    public T peek() {
        return (T) queues[0].peek();
    }

    public T peek(int priority) {
        return (T) queues[priority].peek();
    }

    public void add(T element, int priority) {
        for (int i = 0; i < queues.length; i++) {
            if(i == (priority - 1)) {
                queues[i].enqueue(element);
            }
        }
    }

    public void dequeue() {
        for (int i = 0; i < queues.length; i++) {
            if(!queues[i].isEmpty()) {
                queues[i].dequeue();
            }
        }
    }
}

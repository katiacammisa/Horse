package Cola;


import Queue.DynamicQueue;

public class PriorityQueue<T> {

    private DynamicQueue<T>[] queues;

    public PriorityQueue(int minimumPriority) {
        queues = new DynamicQueue[minimumPriority];
        for (int i = 0; i < minimumPriority ; i++) {
            queues[i] = new DynamicQueue<T>();
        }
    }

    public T peek() {
        return (T) queues[0].peek();
    }

    public T peek(int priority) {
        return (T) queues[--priority].peek();
    }

    public void add(T element, int priority) {

        queues[--priority].enqueue(element);

    }

    public void dequeue() {
        for (int i = 0; i < queues.length; i++) {
            if(!queues[i].isEmpty()) {
                queues[i].dequeue();
                break;
            }
        }
    }
}

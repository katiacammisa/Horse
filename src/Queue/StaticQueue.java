package Queue;

public class StaticQueue<T> implements Queue<T> {

    private T[] array;
    private int front;
    private int back;
    private int size;
    private int amount;

    public StaticQueue(int size){
        this.size = size;
        front = 0;
        back = 0;
        amount = 0;
        array = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T t) {
        increment();
        amount++;
        array[back-1] = t;
    }

    @Override
    public T dequeue() {
        T element = array[front];
        front++;
        amount--;
        return element;
    }

    public T peek() {
        return (T) array[front];
    }

    @Override
    public boolean isEmpty() {
        return (amount != size);
    }

    @Override
    public int length() {
        return amount;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        front = 0;
        back = 0;
        amount = 0;
    }

    private void increment(){
        if (back != size) back++;
        else {
            if (amount < size) back = 0;
            else throw new IllegalStateException("Queue is full.");
        }
    }
}

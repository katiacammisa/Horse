package Queue;

public class DynamicQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private int amount;
    private int size;

    public DynamicQueue(int size){
        this.size  = size;
        this.amount = 0;
        front = null;
        back = null;
    }

    public DynamicQueue() {
        this.size = 1000000000;
        this.amount = 0;
        front = null;
        back = null;
    }

    public T peek() {
        return (T) front;
    }


    @Override
    public void enqueue(T t) {
        Node newNode = new Node();
        newNode.data = t;
        newNode.next = null;
        if (amount < size){
            if (isEmpty()){
                front = newNode;
                back = newNode;
            }
            else{
                back.next = newNode;
                back = newNode;
            }
            amount++;
        }
        else{
            throw new IllegalStateException("Queue is already full.");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()){
            T data = front.data;
            if (front == back){
                front = null;
                back = null;
            }
            else{
                front = front.next;
            }
            amount--;
            return data;
        }
        else{
            throw new RuntimeException("Cannot remove elements from empty queue.");
        }
    }

    @Override
    public boolean isEmpty() {
        return (amount == 0)? true : false;
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
        front = null;
        back = null;
        amount = 0;
    }
}

package Queue;

import Nodes.Node;

public class DynamicQueue<T> {

    Node<T> first;
    Node<T> last;

    public DynamicQueue(){}


    public void enqueue(T x){
        Node next = new Node();
        next.data = x;
        if(first == null){
            first = next;
        }
        if(last != null){
            last.next = next;
        }
        last = next;
    }

    public void dequeue(){
        if(!isEmpty()) {
            first = first.next;
        }
    }

    public T peek(){
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

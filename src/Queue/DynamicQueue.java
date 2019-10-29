package Queue;
import Nodes.Node;

public class DynamicQueue<T> {

    Node<T> first;
    Node<T> last;
    int size;

    public DynamicQueue(){}


    public void enqueue(T x){
        ++size;
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
            --size;
        }
    }

    public T peek(){
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size(){
        return size;
    }
}

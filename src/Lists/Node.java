package Lists;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(){
        data = null;
        next = null;
    }

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node(T data, Node<T> next){
        this(data);
        this.next = next;
    }
}

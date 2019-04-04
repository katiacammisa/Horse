package Stack;

public class DynamicStack<T> {

    Node<T> top;

    public DynamicStack() {}

    public void push(T element){
       Node<T> aux = new Node<T>();
       aux.next = top;
       aux.data = element;
       top = aux;
    }

    public void pop(){
         top = top.next;
    }

    public T peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        int counter = 0;
        Node<T> aux = new Node<T>();
        while(top != null){
            ++counter;
            aux = top.next;
            pop();
        }
        top = aux;
        return counter;
    }

    public void empty(){
        top = null;
    }

}

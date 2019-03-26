package Stack;

public class StackD<T> {

    Node<T> top;

    public StackD() {}

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
        if(top == null){
            return true;
        }
        return false;
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

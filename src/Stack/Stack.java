package Stack;

public class Stack<T> {

    private int length;
    private int capacity;
    private Object[] pile;

    public Stack(int capacity) {

        length = -1;
        this.capacity = capacity;
        pile = new Object[capacity];
    }

    public void pop(){
        length--;

    }
    public void push(T element){
        if (length == pile.length-1){
            extend();
        }
        length++;
        pile[length] = element;
    }

    private void extend() {
        Object[] pileAux = new Object[2*capacity];
        for (int i = 0; i < capacity; i++) {
            pileAux[i] = pile[i];
        }
        pile = pileAux;
    }

    public T peek(){
        if (!isEmpty()){
            return (T) pile[length];
        }
        return null;
    }

    public boolean isEmpty(){
        if(length == -1){
            return true;
        }
        return false;
    }

    public int size(){
        return length;
    }

    public void empty(){
        length = -1;
    }
}

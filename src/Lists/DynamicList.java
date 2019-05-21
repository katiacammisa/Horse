package Lists;

public class DynamicList<T> implements List<T> {
    private Node<T> first, actual, sentinel;
    private int size;

    public DynamicList() {
        this.first = new Node<>();
        this.actual = new Node<>();
        first.next = sentinel;
        this.actual = first;
        this.size = 0;
    }

    @Override
    public void insertNext(T obj) {
        actual.next = new Node<>(obj, actual.next);
        actual = actual.next;
        actual.next = null;
        size++;
    }

    @Override
    public void insertPrev(T obj) {
        if(!isVoid()){
            goBack();
        }
        insertNext(obj);
    }

    @Override
    public void remove() {
        if(isVoid()){
            throw new RuntimeException("This list is empty");
        }
        goBack();
        actual.next = actual.next.next;
        actual = actual.next;
        if(actual == sentinel){
            goBack();
        }
        size--;
    }

    @Override
    public void goNext() {
        if(actual.next == null){
            throw new RuntimeException("End of the list");
        }
        actual = actual.next;
    }

    public void first(){
        actual = first;
    }

    @Override
    public void goPrev() {
        if(actual == first.next){
            throw new RuntimeException("Beginning of the list");
        }
        goBack();
    }

    private void goBack(){
        Node<T> aux = first;
        while (actual != aux.next){
            aux = aux.next;
        }
        actual = aux;
    }

    @Override
    public void goTo(int index) {
        actual = first.next;
        for (int i = 0; i < index; i++) {
            actual = actual.next;
        }
    }

    @Override
    public T getActual() {
        return actual.data;
    }

    @Override
    public int getActualPosition() {
        int pos = 0;
        if(!isVoid()){
            Node<T> aux = first;
            for(;aux.next != actual; pos++){
                aux = aux.next;
            }
        }
        return pos;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isVoid() {
        return first.next == sentinel;
    }

    @Override
    public boolean endList() {
        return actual.next == sentinel;
    }

    @Override
    public GeneralList clone() {
        return null;
    }
}
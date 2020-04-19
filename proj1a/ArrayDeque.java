public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        length = 8;
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int minusOne(int index){
        return (index-1+length)%length;
    }
    private int plusOne(int index){
        return (index+1+length)%length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        length = capacity;
        for (int i = nextFirst+1, j = 0; i<nextLast; i=plusOne(i), j++){
            a[j]=items[i];
        }
        items = a;
    }
    public void addFirst(T x) {
        if (size == length) {
            resize(size * 2);
        }

        items[nextFirst] = x;
        size = size + 1;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T x) {
        if (size == length) {
            resize(size * 2);
        }

        items[nextLast] = x;
        size = size + 1;
        nextLast = plusOne(nextLast);
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = nextFirst+1; i<nextLast; i=plusOne(i)){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public T removeFirst(){
        nextFirst = plusOne(nextFirst);
        T re = items[nextFirst];
        items[nextFirst]=null;
        return re;
    }

    public T removeLast(){
        nextLast = minusOne(nextLast);
        T re = items[nextLast];
        items[nextLast]=null;
        return re;
    }

    public T get(int index){
        T p = items[plusOne(nextFirst)];
        return p;
    }
}
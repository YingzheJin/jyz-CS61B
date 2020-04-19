public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** PlusOne method*/
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /** MinusOne method*/
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** add an isFull method*/
    private boolean isFull() {
        return size == items.length;
    }

    /** add an isSparse method*/
    private  boolean isSparse() {
        return items.length >= 16 && size <= items.length * 0.25;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int p = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[p];
            p = plusOne(p);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Add an addFirst method, O(1)*/
    public void addFirst(T item) {
        if (isFull()) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    /** Add an addLast method, O(1)*/
    public void addLast(T item) {
        if (isFull()) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    /** check if LinkedListDeque is empty*/
    public boolean isEmpty() {
        return size == 0;
    }

    /** return size of the LinkedListDeque*/
    public int size() {
        return size;
    }

    /** print all item from the LinkedListDeque*/
    public void printDeque() {
        int p = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[p] + " ");
            p = plusOne(p);
        }
    }

    /** remove and return the front of the LinkedListDeque, return null if size==0*/
    public T removeFirst() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return removedItem;
    }

    /** remove and return the back of the LinkedListDeque, return null if size==0*/
    public T removeLast() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T removedItem = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return removedItem;
    }

    /** return the index th item*/
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int getIndex = plusOne(nextFirst + index);
        return items[getIndex];
    }
}

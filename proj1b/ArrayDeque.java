public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private  boolean isSparse() {
        return items.length >= 16 && size <= items.length * 0.25;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }
    private int plusOne(int index) {
        return (index + 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0, j = plusOne(nextFirst); i < size; i++, j = plusOne(j)) {
            a[i] = items[j];
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextFirst] = x;
        size = size + 1;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = x;
        size = size + 1;
        nextLast = plusOne(nextLast);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0, j = plusOne(nextFirst); i < size; i++, j = plusOne(j)) {
            System.out.print(items[j] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T re = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        if (isSparse()) {
            resize(items.length / 2);
        }
        return re;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T re = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        if (isSparse()) {
            resize(items.length / 2);
        }
        return re;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        return items[plusOne(nextFirst + index)];

    }
}

public class ArrayDeque<T> {
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
        for (int i = nextFirst + 1, j = 0; i < nextLast; i = plusOne(i), j++) {
            a[j] = items[i];
        }
        items = a;
    }
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextFirst] = x;
        size = size + 1;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = x;
        size = size + 1;
        nextLast = plusOne(nextLast);
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i < nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T re = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        return re;
    }

    public T removeLast() {
        if (isSparse()) {
            resize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T re = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        return re;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

         return items[plusOne(nextFirst + index)];

    }
}

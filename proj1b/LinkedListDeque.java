public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        /** Construct */
        private T item;
        private Node next;
        private Node prev;

        Node(Node p, T i, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /** declare sentinel & size instance*/
    private Node sentinel;
    private int size;

    /** Construct empty */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Construct with first variable*/
//    public LinkedListDeque(T x) {
//        sentinel = new Node(null, null, null);
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        sentinel.next = new Node(sentinel, x, sentinel);
//        sentinel.prev = sentinel.next;
//        size = 1;
//    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new Node(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev.next = new Node(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
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
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T current = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return current;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T re = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return re;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        Node p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }
   /** return the index th item, using recursive*/
    private T getRecursive(int index, Node curr) {

        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }
}


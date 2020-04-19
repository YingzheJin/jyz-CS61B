public class LinkedListDeque<T> {
    private class Node {
        /** Construct Intlist*/
        private T item;
        private Node next;
        private Node prev;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    /** declare sentinel & size instance*/
    private Node sentinel;
    private int size;

    /** Construct empty DLList*/
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Add an addFirst method, O(1)*/
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Add an addLast method, O(1)*/
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /** check if LinkedListDeque is empty*/
    public boolean isEmpty() {
        return sentinel.next == sentinel && sentinel.prev == sentinel;
    }

    /** return size of the LinkedListDeque*/
    public int size() {
        return size;
    }

    /** print all item from the LinkedListDeque*/
    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** remove and return the front of the LinkedListDeque, return null if size==0*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T frontItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return  frontItem;
        }
    }

    /** remove and return the back of the LinkedListDeque, return null if size==0*/
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T backItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return backItem;
        }
    }

    /** return the index th item*/
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            Node p = sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }
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

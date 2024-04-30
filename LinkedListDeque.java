package Project1_DataStructures;

public class LinkedListDeque<T> implements Deque<T>{
    public class Node {
        public T item;
        public Node next;
        public Node previous;
        public Node(T t, Node p, Node n) {
            item = t;
            previous = p;
            next = n;
        }
    }
    private int size;
    private Node sentinel;
    // create null Deque
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }
    // create deque with first node
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        Node first = new Node(x, sentinel, sentinel);
        sentinel.next = first;
        sentinel.previous = first;
        size = 1;
    }
    @Override
    public void addFirst(T item) {
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.previous = first;
        sentinel.next = first;
        size++;
    }
    @Override
    public void addLast(T item) {
        Node last = new Node(item, sentinel.previous, sentinel);
        sentinel.previous.next = last;
        sentinel.previous = last;
        size++;
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
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T t = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size--;
        return t;
    }
    @Override
    public T removeLast() {
        if (size == 0) return null;
        T t = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size--;
        return t;
    }
    @Override
    public T get(int index) {
        if (index >= size) return null;
        Node p = sentinel;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }
    // return ith deque using recursion
    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }
    // helper method of getRecursive
    public T getRecursive(Node p, int i) {
        if (i == 0) return p.item;
        if (i >= size || i < 0) return null;
        return getRecursive(p.next, i - 1);
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> a = new LinkedListDeque();
        a.addFirst(10);
        a.addFirst(9);
        a.addLast(11);
        a.addFirst(8);
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        a.printDeque();
        System.out.println();
        System.out.println(a.getRecursive(4));
    }
}

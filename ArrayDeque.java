package Project1_DataStructures;

public class ArrayDeque<T> implements Deque<T>{
    public int size;
    public T[] items;
    public int first;
    public int last;
    public int nextFirst;
    public int nextLast;
    public int preFirst;
    public int preLast;
    // creates an empty ArrayDeque
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 4;
        nextFirst = first;
        last = 5;
        nextLast = last;
    }
    // helper method, returns nextFirst
    private int nextFirst() {
        if (first == 0) nextFirst = items.length - 1;
        else nextFirst = first - 1;
        return nextFirst;
    }
    // // helper method, returns nextLast
    private int nextLast() {
        if (last == items.length - 1) nextLast = 0;
        else nextLast = last + 1;
        return nextLast;
    }
    // resize deque
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, first, a, size / 2, size - first);
        System.arraycopy(items, 0, a, size / 2 + size - first, first);
        first = size / 2;
        nextFirst = nextFirst();
        last = size / 2 + size - 1;
        nextLast = nextLast();
        items = a;
    }
    // adds an T type item to the front of the deque, the deque is a circle
    @Override
    public void addFirst(T x) {
        if (size == items.length) resize(size * 2);
        preFirst = first;
        first = nextFirst;
        items[first] = x;
        nextFirst();
        size++;
    }
    // adds an T type item to the back of the deque
    @Override
    public void addLast(T x) {
        if (size == items.length) resize(size * 2);
        preLast = last;
        last = nextLast;
        items[last] = x;
        nextLast();
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // returns the size of the deque
    @Override
    public int size() {
        return size;
    }
    // prints the deque by sequence
    @Override
    public void printDeque() {
        if (items.length - first < size) {
            for (int i = first; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i <= last; i++) {
                System.out.print(items[i] + " ");
            }
        }
        else {
            for (int i = first; i <= last; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }
    // removes the first item
    @Override
    public T removeFirst() {
        T p = items[first];
        items[first] = null;
        nextFirst = first;
        first = preFirst;
        return p;
    }
    // remove the last item
    @Override
    public T removeLast() {
        T p = items[last];
        items[last] = null;
        nextLast = last;
        last = preLast;
        return p;
    }
    // returns the ith item
    @Override
    public T get(int index) {
        index = first + index;
        return items[index];
    }
    public static void main(String[] args) {
        ArrayDeque<Character> a = new ArrayDeque();
        a.addLast('a');
        a.addLast('b');
        a.addFirst('c');
        a.printDeque();
        System.out.println();
        a.addLast('d');
        a.addLast('e');
        a.addFirst('f');
        a.addLast('g');
        a.addLast('h');
        a.printDeque();
        a.addLast('Z');
        a.printDeque();
    }
}

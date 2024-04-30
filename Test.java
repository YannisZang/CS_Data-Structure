package Project1_DataStructures;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> a = new LinkedListDeque<>();
        a.addLast(10);
        a.addLast(11);
        a.addFirst(9);
        a.addFirst(8);
        a.addLast(12);
        a.printDeque();
    }
}

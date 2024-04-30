package Project1_DataStructures;

public class Palindrome {

    private int n; // offset number corresponding to OffByN
    public Palindrome(int n) {
        this.n = n;
    }
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    // using recursion
    private Deque<Character> wordToDequeR(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        return wToD(word, 0, deque);
    }
    // helper method
    private Deque<Character> wToD(String word, int n, Deque<Character> deque) {
        if (n == word.length() - 1) return deque;
        deque.addLast(word.charAt(n));
        return wToD(word, n + 1, deque);
    }
    public boolean isPalindrome(String word) {
        OffByN cc = new OffByN(n);

        return isPalindrome(wordToDeque(word), cc);
    }
    // helper function for palindrome, cc is higher order function
    private boolean isPalindrome(Deque<Character> word, CharacterComparator cc) {
        cc = new OffByN(n); // could dismiss in this function
        if (word.size() <= 1) return true;

        Character first = word.removeFirst();
        Character last = word.removeLast();

        return cc.equalChars(first, last) && isPalindrome(word, cc);
    }

    public static void main(String[] args) {
        Palindrome a = new Palindrome(2);
        a.wordToDeque("noon").printDeque();
        a.wordToDequeR("palindrome").printDeque();
        System.out.println(a.isPalindrome("obo"));
        System.out.println(a.isPalindrome("flake"));
    }
}

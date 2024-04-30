package Project1_DataStructures;

public class OffByOne implements CharacterComparator {

    public OffByOne() {
    }
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }

    public static void main(String[] args) {
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));
        System.out.println(obo.equalChars('r', 'q'));
        System.out.println(obo.equalChars('a', 'e'));
        System.out.println(obo.equalChars('z', 'a'));
        System.out.println(obo.equalChars('a', 'a'));
        System.out.println(obo.equalChars('&', '%'));
    }
}

package club.nullbyte3.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new FibonacciSequence(10);
        Iterator<Integer> iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

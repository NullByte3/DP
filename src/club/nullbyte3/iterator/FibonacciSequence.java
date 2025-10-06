package club.nullbyte3.iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    private final int count;

    public FibonacciSequence(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this.count);
    }
}

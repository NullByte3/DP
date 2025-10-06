package club.nullbyte3.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private final int limit;
    private int position = 0;
    private int previous = 0;
    private int current = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return position < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        position++;
        int result;
        if (position <= 1) {
            result = 1;
        } else {
            result = current + previous;
            previous = current;
            current = result;
        }
        return result;
    }
}

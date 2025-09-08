package club.nullbyte3.strategy;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        SortingStrategy[] strategies = {
                new BubbleSortStrategy(),
                new QuickSortStrategy(),
                new MergeSortStrategy()
        };

        System.out.println("Sorting 30 elements (very fast)");
        runTest(sorter, strategies, 30);

        System.out.println("Sorting 100,000 elements (takes time)");
        runTest(sorter, strategies, 100_000);
    }

    private static void runTest(Sorter sorter, SortingStrategy[] strategies, int size) {
        int[] data = createRandomArray(size);

        for (SortingStrategy strategy : strategies) {
            int[] dataCopy = Arrays.copyOf(data, data.length);
            sorter.setStrategy(strategy);
            sorter.sortArray(dataCopy);
        }
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}

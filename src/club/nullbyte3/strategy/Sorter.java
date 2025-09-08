package club.nullbyte3.strategy;

public class Sorter {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        long startTime = System.nanoTime();
        strategy.sort(array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println(strategy.getName() + " took " + duration + " ms");
    }
}

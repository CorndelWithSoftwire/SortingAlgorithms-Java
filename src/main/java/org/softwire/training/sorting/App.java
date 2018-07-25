package org.softwire.training.sorting;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    private static final long RANDOM_NUMBER_SEED = 1234L;

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("Selection Sort should take four times as long if you double the input length");
        timeSort(new SelectionSort(), pseudoRandomNumbers(20000).toArray());
        timeSort(new SelectionSort(), pseudoRandomNumbers(40000).toArray());
        System.out.println();

        System.out.println("Insertion Sort should take getting on for four times as long if you double the input length");
        timeSort(new InsertionSort(), pseudoRandomNumbers(20000).toArray());
        timeSort(new InsertionSort(), pseudoRandomNumbers(40000).toArray());
        System.out.println();

        System.out.println("Insertion Sort should only take twice as long if you double the input length but the inputs are sorted");
        timeSort(new InsertionSort(), pseudoRandomNumbers(200000).sorted().toArray());
        timeSort(new InsertionSort(), pseudoRandomNumbers(400000).sorted().toArray());
        System.out.println();

        System.out.println("Insertion Sort should take four times as long if you double the input length and the inputs are reverse-sorted");
        timeSort(new InsertionSort(), pseudoRandomNumbers(20000).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray());
        timeSort(new InsertionSort(), pseudoRandomNumbers(40000).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray());
        System.out.println();

        System.out.println("Merge Sort shouldn't take much more than twice as long if you double the input length");
        timeSort(new MergeSort(), pseudoRandomNumbers(200000).toArray());
        timeSort(new MergeSort(), pseudoRandomNumbers(400000).toArray());
        System.out.println();

        System.out.println("Merge Sort shouldn't take much more than 100 times as long if you multiply the input length by 100");
        timeSort(new MergeSort(), pseudoRandomNumbers(200000).toArray());
        timeSort(new MergeSort(), pseudoRandomNumbers(200000 * 100).toArray());
        System.out.println();
    }

    private void timeSort(SortAlgorithm sortAlgorithm, int[] input) {
        long start = System.nanoTime();
        sortAlgorithm.sort(input);
        long elapsedTimeMillis = (System.nanoTime() - start) / 1000;

        System.out.println(MessageFormat.format(
                "{0} took {1}ms to sort {2} numbers",
                sortAlgorithm.getClass().getSimpleName(),
                Long.toString(elapsedTimeMillis),
                Integer.toString(input.length)));
    }

    private IntStream pseudoRandomNumbers(int size) {
        Random random = new Random(RANDOM_NUMBER_SEED); // Fixed seed so the numbers are the same every time on this run
        return random.ints().limit(size);
    }
}

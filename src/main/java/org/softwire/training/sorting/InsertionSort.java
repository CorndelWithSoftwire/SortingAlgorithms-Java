package org.softwire.training.sorting;

public class InsertionSort implements SortAlgorithm {
    public int[] sort(int[] input) {
        int topOfSortedList = 0;

        while (topOfSortedList < input.length - 1) {
            int elementToInsert = topOfSortedList - 1;

            while (elementToInsert > 0 && input[elementToInsert - 1] > input[elementToInsert]) {
                int temp = input[elementToInsert];
                input[elementToInsert] = input[elementToInsert - 1];
                input[elementToInsert - 1] = temp;

                elementToInsert--;
            }

            topOfSortedList++;
        }

        return input;
    }
}

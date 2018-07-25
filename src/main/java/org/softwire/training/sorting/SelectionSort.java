package org.softwire.training.sorting;

public class SelectionSort implements SortAlgorithm {
    public int[] sort(int[] input) {
        int topOfSortedList = -1;

        while (topOfSortedList < input.length - 1) {
            int smallestElementIndex = topOfSortedList + 1;

            for (int i = topOfSortedList + 2; i < input.length; i++) {
                if (input[i] < input[smallestElementIndex]) {
                    smallestElementIndex = i;
                }
            }

            int temp = input[topOfSortedList + 1];
            input[topOfSortedList + 1] = input[smallestElementIndex];
            input[smallestElementIndex] = temp;

            topOfSortedList = topOfSortedList + 1;
        }

        return input;
    }
}

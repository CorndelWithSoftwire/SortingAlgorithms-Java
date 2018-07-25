package org.softwire.training.sorting;

public class MergeSort implements SortAlgorithm {
    public int[] sort(int[] input) {
        int lengthOfSortedLists = 1;

        while (lengthOfSortedLists < input.length) {
            int leftListStart = 0;

            while (leftListStart < input.length) {
                int rightListStart = leftListStart + lengthOfSortedLists;
                Merge(input, leftListStart, rightListStart, lengthOfSortedLists);

                leftListStart = rightListStart + lengthOfSortedLists;
            }

            lengthOfSortedLists *= 2;
        }

        return input;
    }

    private void Merge(int[] input, int leftListStart, int rightListStart, int lengthOfSortedLists) {
        int leftListIndex = leftListStart;
        int rightListIndex = rightListStart;
        int leftListEnd = Math.min(rightListStart, input.length);
        int rightListEnd = Math.min(rightListStart + lengthOfSortedLists, input.length);
        int[] working = new int[rightListEnd - leftListStart];
        int workingIndex = 0;

        while (leftListIndex < leftListEnd || rightListIndex < rightListEnd) {
            if (leftListIndex == leftListEnd || rightListIndex < rightListEnd && input[rightListIndex] < input[leftListIndex]) {
                working[workingIndex] = input[rightListIndex];
                rightListIndex++;
            } else {
                working[workingIndex] = input[leftListIndex];
                leftListIndex++;
            }

            workingIndex++;
        }

        System.arraycopy(working, 0, input, leftListStart, working.length);
    }
}

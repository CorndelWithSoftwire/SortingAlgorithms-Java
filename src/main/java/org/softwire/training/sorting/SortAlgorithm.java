package org.softwire.training.sorting;

public interface SortAlgorithm {
    /**
     * Sort the input array into numerical order
     * Note that the input may be modified by the algorithm - the return value may or may not point to the same object
     * as the input.
     */
    int[] sort(int[] input);
}

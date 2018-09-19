package com.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysTest {


    @Test
    public void mergeSort_emptyArray_keepsEmpty() {
        int[] emptyArray = {};
        int[] expected = {};

        Arrays.mergeSort(emptyArray);
        assertThat(emptyArray).isEqualTo(expected);
    }

    @Test
    public void mergeSort_oneElement_keepsOneElement() {
        int[] oneElementArray = {4};
        int[] expected = {4};

        Arrays.mergeSort(oneElementArray);
        assertThat(oneElementArray).isEqualTo(expected);
    }

    @Test
    public void mergeSort_twoElements_sortsArray() {
        int[] unsorted = {5, 3};
        int[] sorted = {3, 5};

        Arrays.mergeSort(unsorted);
        assertThat(unsorted).isEqualTo(sorted);
    }

    @Test
    public void mergeSort_multipleElementsWithDuplicates_sortsArray() {
        int[] unsorted = {3, 5, 7, 4, 1, 6, 8, 20, 45, 2, 11, 32, 6, 4};
        int[] sorted = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};

        Arrays.mergeSort(unsorted);
        assertThat(unsorted).isEqualTo(sorted);
    }

    @Test
    public void mergeSort_sortedArray_keepsSorted() {
        int[] expected = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};
        int[] sorted = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};

        Arrays.mergeSort(sorted);
        assertThat(sorted).isEqualTo(expected);
    }

    @Test
    public void quicksort_emptyArray_keepsEmpty() {
        int[] emptyArray = {};
        int[] expected = {};

        Arrays.quicksort(emptyArray);
         assertThat(emptyArray).isEqualTo(expected);
    }

    @Test
    public void quicksort_oneElement_keepsOneElement() {
        int[] oneElementArray = {4};
        int[] expected = {4};

        Arrays.quicksort(oneElementArray);
        assertThat(oneElementArray).isEqualTo(expected);
    }

    @Test
    public void quicksort_twoElements_sortsArray() {
        int[] unsorted = {5, 3};
        int[] sorted = {3, 5};

        Arrays.quicksort(unsorted);
        assertThat(unsorted).isEqualTo(sorted);
    }

    @Test
    public void quicksort_multipleElementsWithDuplicates_sortsArray() {
        int[] unsorted = {3, 5, 7, 4, 1, 6, 8, 20, 45, 2, 11, 32, 6, 4};
        int[] sorted = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};

        Arrays.quicksort(unsorted);
        assertThat(unsorted).isEqualTo(sorted);
    }

    @Test
    public void quicksort_sortedArray_keepsSorted() {
        int[] expected = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};
        int[] sorted = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 11, 20, 32, 45};

        Arrays.quicksort(sorted);
        assertThat(sorted).isEqualTo(expected);
    }

}

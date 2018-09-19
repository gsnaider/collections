package com.collections;

import java.util.Random;

public final class Arrays {

    private Arrays() {}

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end - 1) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] merged = new int[end - start];
        int i = start;
        int j = mid;
        int nextMergePos = 0;
        while (i < mid || j < end) {
            int nextElemToMerge;
            if (i == mid) {
                nextElemToMerge = array[j++];
            } else if (j == end) {
                nextElemToMerge = array[i++];
            } else {
                if (array[i] < array[j]) {
                    nextElemToMerge = array[i++];
                } else {
                    nextElemToMerge = array[j++];
                }
            }
            merged[nextMergePos++] = nextElemToMerge;
        }
        for (int mergeIdx = 0; mergeIdx < merged.length; mergeIdx++) {
            array[start + mergeIdx] = merged[mergeIdx];
        }
    }



    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length);
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start < end - 1) {
            int pivotPos = partition(array, start, end);
            quicksort(array, start, pivotPos);
            quicksort(array, pivotPos + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        Random random = new Random();
        int pivotPos = start + random.nextInt(end - start);
        swap(array, pivotPos, end - 1);
        int pivot = array[end - 1];
        int finalPivotPos = start;
        for (int i = start; i < end - 1; i++) {
            if (array[i] < pivot) {
                swap(array, finalPivotPos, i);
                finalPivotPos++;
            }
        }
        swap(array, finalPivotPos, end - 1);
        return finalPivotPos;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

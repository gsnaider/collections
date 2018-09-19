package com.collections;

import java.util.Random;

public final class Arrays {

    private Arrays() {}

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

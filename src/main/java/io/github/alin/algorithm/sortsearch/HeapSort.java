package io.github.alin.algorithm.sortsearch;

import javax.swing.*;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 28, 10, 29, 3, 1, 5, 7, 7, 4, 9};
        heapSort(array);
        System.out.println(SortHelper.printInt(array));
    }

    /**
     * 构建一个heap
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        int length = array.length;
        for (int i = length - 1; i > 0; i--) {
            int t = array[0];
            array[0] = array[i];
            array[i] = t;

            length--;
            heapify(array, 0, length);
        }

    }

    /**
     * 30
     * 20     10
     * 15 18   5   8
     * <p>
     * 30,20,10,15,18,5,8
     */
    public static void heapify(int[] array, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largestIndex = i;
        if (left > length) {
            return;
        }
        if (left < length && array[left] > array[largestIndex]) {
            largestIndex = left;
        }
        if (right < length && array[right] > array[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            int t = array[i];
            array[i] = array[largestIndex];
            array[largestIndex] = t;
            heapify(array, largestIndex, length);
        }
    }


}

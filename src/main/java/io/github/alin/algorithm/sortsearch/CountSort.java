package io.github.alin.algorithm.sortsearch;

public class CountSort {

    public static void main(String[] args) {
        //不适合有负数场景
        //int[] array = new int[]{-1,-1,-2,9, 0, 0, 2, 2, 3, 3, 1, 1};
        int[] array = new int[]{9, 0, 0, 2, 2, 3, 3, 1, 1};
        countSort(array);
        System.out.println(SortHelper.printInt(array));
    }

    /**
     * 2,2,1,1,4,4,5,5
     */
    public static void countSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] tmp = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            tmp[index]++;  // 0,2,2,0,2,2,
        }

        int k = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = tmp[i]; j > 0; j--) {
                array[k++] = i;
            }
        }
    }
}

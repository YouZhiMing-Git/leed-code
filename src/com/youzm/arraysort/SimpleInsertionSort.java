package com.youzm.arraysort;

/**
 * 简单插入排序
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class SimpleInsertionSort {
    public int[] insertionSort(int[] arrs) {
        int n = arrs.length;
        if (arrs == null || n < 2) return arrs;
        for (int i = 1; i < n; i++) {
            int cur = arrs[i];
            int j = i - 1;
            while (j >= 0 && arrs[j] > cur) {
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j+1]=cur;
        }
        return arrs;
    }

    public static void main(String[] args) {
        SimpleInsertionSort simpleInsertionSort=new SimpleInsertionSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        System.out.println(simpleInsertionSort.insertionSort(arrs));
    }
}

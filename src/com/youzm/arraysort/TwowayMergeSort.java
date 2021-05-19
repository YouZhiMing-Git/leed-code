package com.youzm.arraysort;

/**
 * 二路归并排序
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 */
public class TwowayMergeSort {
    public int[] mergeSort(int[] arrs) {
        int n = arrs.length;
        if (arrs == null || n < 2) return arrs;
        arrs = sort(arrs, 0, n - 1);
        return arrs;
    }

    public int[] sort(int[] arrs, int left, int right) {
        if (left == right) return arrs;
        int mid = left + (right - left) / 2;
        sort(arrs, left, mid);
        sort(arrs, mid + 1, right);
        merge(arrs, left, mid, right);
        return arrs;
    }

    public void merge(int[] arrs, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arrs[i] < arrs[j]) {
                temp[t++] = arrs[i++];
            } else {
                temp[t++] = arrs[j++];
            }
        }
        while (i <= mid)
            temp[t++] = arrs[i++];

        while (j <= right)
            temp[t++] = arrs[j++];
        for (int k = 0; k < right - left + 1; k++) {
            arrs[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        TwowayMergeSort twowayMergeSort = new TwowayMergeSort();
        int[] arrs = {45, 5, 68, 6, 59, 755, 69, 21, 456};
        arrs = twowayMergeSort.mergeSort(arrs);
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}

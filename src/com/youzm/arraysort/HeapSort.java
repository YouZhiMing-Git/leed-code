package com.youzm.arraysort;

/**
 * 堆排序
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * <p>
 * 1将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * 　　2将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * 　　3重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 */
public class HeapSort {
    public int[] heapSort(int[] arrs) {
        int n = arrs.length;
        if (arrs == null || n < 2) return arrs;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arrs, i, n);
        }
        for (int j = n - 1; j > 0; j--) {
            swap(arrs, 0, j);
            adjustHeap(arrs, 0, j);
        }
        return arrs;
    }

    public void adjustHeap(int[] arrs, int i, int len) {
        int temp = arrs[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arrs[k] < arrs[k + 1]) {
                k++;
            }
            if (arrs[k] > temp) {
                arrs[i] = arrs[k];
                i = k;
            } else {
                break;
            }
        }
        arrs[i] = temp;
    }

    private void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        heapSort.heapSort(arrs);
    }
}

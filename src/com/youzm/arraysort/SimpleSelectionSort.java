package com.youzm.arraysort;

/**
 * 简单选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SimpleSelectionSort {
    public  int[] selectionSort(int[] arrs){
        int n=arrs.length;
        if(arrs==null||n<2)return arrs;
        for (int i=0;i<n;i++){
            int minIdx=i;
            for(int j=i;j<n;j++){
                if(arrs[j]<arrs[minIdx])minIdx=j;
            }
            swap(arrs,i,minIdx);
        }
        return arrs;
    }
    private void swap(int[] arrs,int i,int j){
        int temp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=temp;
    }

    public static void main(String[] args) {
        SimpleSelectionSort simpleSelectionSort=new SimpleSelectionSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        System.out.println(simpleSelectionSort.selectionSort(arrs));
    }
}

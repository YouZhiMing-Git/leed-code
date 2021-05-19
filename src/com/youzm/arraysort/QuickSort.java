package com.youzm.arraysort;

/**
 * 快速排序
 * 快速排序的基本思想：
 *      通过一趟排序将待排记录分隔成独立的两部分，
 *      其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort {
    public int[] quickSort(int[] arrs){
        arrs=  quickSort(arrs,0,arrs.length-1);
        return arrs;
    }
    private int[] quickSort(int[] arrs,int low,int hight){
        if(low<hight){
            int mid=partition(arrs,low,hight);
            quickSort(arrs,low,mid-1);
            quickSort(arrs,mid+1,hight);
        }
        return arrs;
    }
    private int partition (int [] arrs,int low,int hight){
        int midValue=arrs[low];
        int i=low+1;
        int j=hight;
        while (true){
            //找到左侧第一个比midValue大的数
            while (i<=j&&arrs[i]<=midValue) i++;
            //找到右侧第一个比midValue小的数
            while (i<=j&&arrs[j]>=midValue) j--;
            if(i>=j)
                break;
            swap(arrs,i,j);
        }
        arrs[low]=arrs[j];
        arrs[j]=midValue;
        return j;
    }
    private void swap(int[] arrs,int i,int j){
        int temp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        System.out.println(quickSort.quickSort(arrs));
    }
}

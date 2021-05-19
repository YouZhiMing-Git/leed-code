package com.youzm.arraysort;

/**
 * 希尔排序
 * 是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {
    public int[] shellSort(int[] arrs){
        int n=arrs.length;
        if(arrs==null||n<2)return arrs;
        //进行分组 初始分组长度为n/2,依次为上一次的1/2
        int d=n;
        while (d>0){
            d/=2;
            //循环插入排序d组
            for(int i=0;i<d;i++){
                //插入排序
                for(int j=i+d;j<n;j+=d){
                   int temp=arrs[j];
                   int t=j-d;
                   while (t>=0&&arrs[t]>temp){
                       arrs[t+d]=arrs[t];
                       t-=d;
                   }
                   arrs[t+d]=temp;
                }
            }
        }
        return arrs;
    }


    public static void main(String[] args) {
        ShellSort shellSort=new ShellSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        System.out.println(shellSort.shellSort(arrs));
    }
}

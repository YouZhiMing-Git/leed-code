package com.youzm.arraysort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class RadixSort {
    public int[] radoxSort(int[] arrs){
        if(arrs==null||arrs.length<2)return arrs;
        int max=arrs[0];
        int mod=10;
        int div=1;
        //获取最大值
        for(int v:arrs){
            max=max>v?max:v;
        }
        int maxDigit=0;
        while (max>0){
            max/=10;
            maxDigit++;
        }
        //初始化桶
        List<List<Integer>> buckets=new ArrayList<>(10);
        for(int i=0;i<10;i++) buckets.add(new ArrayList<>());
        for(int i=0;i<maxDigit;i++,mod*=10,div*=10){
            for(int v:arrs){
                int idx=(v%mod)/div;
                buckets.get(idx).add(v);
            }
            int j=0;
            for(List<Integer> bucket:buckets){
                for(int val:bucket){
                    arrs[j++]=val;
                }
                bucket.clear();
            }

        }
        return arrs;
    }

    public static void main(String[] args) {
        RadixSort radixSort=new RadixSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        radixSort.radoxSort(arrs);
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}

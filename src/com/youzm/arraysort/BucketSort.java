package com.youzm.arraysort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *将数据分段放入不同的桶中
 *对桶中元素进行排序
 * 根据桶顺序依次输入
 * 需要额外的空间
 */
public class BucketSort {
    public  int[] bucketSort(int[] arrs){
        if(arrs==null||arrs.length<2)return arrs;
        bucketSort0(arrs,10);
        return arrs;
    }
    public void bucketSort0(int[] arrs,int bucketSize){
        //1.获取数组最大值和最小值
        int max=arrs[0],min=arrs[0];
        for(int v:arrs){
            max=max>v?max:v;
            min=min<v?min:v;
        }
        //确定桶的划分
        int bucketCount=(max-min)/bucketSize+1;
        //构造桶
        List<List<Integer>> buckets=new ArrayList<>(bucketCount);
        for(int i=0;i<bucketCount;i++){
            buckets.add(new ArrayList<>());
        }
        //将数组数据映射到不同的桶中
        for(int v:arrs){
            int idx=(v-min)/bucketSize;
            buckets.get(idx).add(v);
        }
        //对各桶进行排序
        for(List bucket:buckets){
            if(bucket.size()>0){
                Collections.sort(bucket);
            }
        }
        //将桶中数据依次写回；
        int j=0;
        for(List<Integer> bucket:buckets){
            for(Integer value:bucket){
                arrs[j++]=value;
            }
        }
    }

    public static void main(String[] args) {
        BucketSort bucketSort=new BucketSort();
        int[] arrs={-7, 51, 3, 121, -3, 32, 21, 43, 4, 25, 56, 77, 16, 22, 87, 56, -10, 68, 99, 70};
        bucketSort.bucketSort(arrs);
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}

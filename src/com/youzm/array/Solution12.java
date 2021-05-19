package com.youzm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topKList=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int count=map.getOrDefault(num,0)+1;
            map.put(num,count);
        }

        int i=0;
        int minIndex=0;
        Map.Entry[] entries=new Map.Entry[k];
        for(Map.Entry e:map.entrySet()){
            if(i<k){
                entries[i]=e;
                if((Integer)e.getValue()<(Integer)entries[minIndex].getValue())
                    minIndex=i;
                i++;
            }else {
                if((Integer)entries[minIndex].getValue()<(Integer) e.getValue()){
                    entries[minIndex]=e;
                    minIndex=findMinIndex(entries,0,k-1);
                    System.out.println(minIndex);
                }

            }
        }
        for(int j=0;j<k;j++){
            topKList[j]=(Integer)entries[j].getKey();
        }
        return topKList;

    }
    public int findMinIndex(Map.Entry[] entries,int begin ,int end){
        if(end-begin<=1){
            return (Integer)entries[begin].getValue()<(Integer)entries[end].getValue()?begin:end;
        }
        int middle=(begin+end)/2;
        int leftMin=findMinIndex(entries,begin,middle);
        int rightMin=findMinIndex(entries,middle+1,end);
        return (Integer)entries[leftMin].getValue()<(Integer)entries[rightMin].getValue()?leftMin:rightMin;

    }
    public int findMinIndex(int[] nums,int begin ,int end){

        if(end-begin<=1){
            return nums[begin]<nums[end]?begin:end;
        }
        int middle=(begin+end)/2;
       int leftMin=findMinIndex(nums,begin,middle);
       int rightMin=findMinIndex(nums,middle+1,end);
       return nums[leftMin]<nums[rightMin]?leftMin:rightMin;

    }

    public static void main(String[] args) {
        Solution12 solution12=new Solution12();
        int[] nums= {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        int [] result=solution12.topKFrequent(nums,6);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}

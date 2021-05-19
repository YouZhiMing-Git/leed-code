package com.youzm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution6 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0 || m == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result=new int[Math.min(n,m)];
        int i = 0, j = 0,index=0;
        while (i < n && j < m) {
            if(nums1[i]>nums2[j])j++;
            else if(nums1[i]<nums2[j])i++;
            else {
                result[index]=nums1[i];
                i++;
                j++;
                index++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }


    /**
     * @param nums1
     * @param nums2
     * @return
     * 哈希
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect1(nums2,nums1);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            int count=map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int [] intersection=new int[nums1.length];
        int index=0;
        for(int num:nums2){
            int count=map.getOrDefault(num,0);
            if(count>0){

                intersection[index]=num;
                index++;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }

            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}

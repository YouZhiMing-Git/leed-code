package com.youzm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 给定一个整数数组，判断是否存在重复元素。
 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class Solution4 {
    //先排序
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
        if(n<2) return false;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1])return true;
        }
        return false;
    }
    //使用set
    public boolean containsDuplicate1(int[] nums) {
        int n=nums.length;
        if(n<2) return false;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
           if(!set.add(num))return true;
        }
        return false;
    }
}

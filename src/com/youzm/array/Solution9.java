package com.youzm.array;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class Solution9 {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}

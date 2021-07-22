package com.youzm.array;

import java.util.Arrays;

/***
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class Solution16 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        int min=nums[0];
        int max=Integer.MAX_VALUE;
        for (int cur : nums) {
            if(cur>max){
                return true;
            }else if(cur>min){
                max=cur;
            }else {
                min=cur;
            }
        }
        return false;
    }
}

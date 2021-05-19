package com.youzm.dynamic;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 结果应为Max{Si(0<=i<n)}
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int pre=0,res=nums[0];
        for(int i=0;i<len;i++){
            pre=Math.max(nums[i],pre+nums[i]);
            res=Math.max(pre,res);
        }
        return res;
    }
}

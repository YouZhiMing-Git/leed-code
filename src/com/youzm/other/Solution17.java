package com.youzm.other;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class Solution17 {
    /**
     * @param nums
     * @return
     * 数学方式
     */
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=((n+1)*n)/2;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return total-sum;
    }

    /**
     * @param nums
     * @return
     * 位操作
     */
    public int missingNumber1(int[] nums){
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

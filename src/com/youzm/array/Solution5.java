package com.youzm.array;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Solution5 {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        Arrays.sort(nums);
        for(int i=0,j=1;i<n-2&&j<n-1;i+=2,j+=2){
            if(nums[i]!=nums[j])return nums[i];
        }
        return nums[n-1];
    }

    /**
     * @param nums
     * @return
     *
     *位运算
     * 0^A=A  A^A=0 且满足交换律
     */
    public int singleNumber1(int[] nums){
        int single=0;
        for(int n:nums){
            single=single^n;
        }
        return single;
    }
}

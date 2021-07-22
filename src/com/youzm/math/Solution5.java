package com.youzm.math;

import java.util.HashMap;
import java.util.Map;

/***
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 */

public class Solution5 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans=0;
        int length=nums.length;

        int i=0,j=0;
        int currentCount=0;
        for ( i = 0; i <length ; i++) {

            if(ans>0&&nums[i]==0){
                ans++;
                continue;
            }
            for (; j <length ; j++) {
                currentCount+=nums[j];
                if(currentCount==goal){
                    ans++;
                }
            }

        }
        return ans;
    }
}

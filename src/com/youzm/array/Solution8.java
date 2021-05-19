package com.youzm.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 */
public class Solution8 {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int zeroIndex=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0&&zeroIndex<0)zeroIndex=i;
            else if(nums[i]!=0&&zeroIndex>=0){
                nums[zeroIndex]= nums[i];
                nums[i]=0;
                zeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Solution8 solution8=new Solution8();
        int[] nums={0,1,0,3,12};
        solution8.moveZeroes(nums);
        System.out.println(Arrays.asList(nums));
    }
}

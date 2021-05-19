package com.youzm.design;

import java.util.Random;

/**
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 */
public class Solution1 {
    private int[] nums;
    private  int [] origin;
    public Solution1(int[] nums) {
        this.nums=nums;
        this.origin = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return  origin;
    }

    /** Returns a random shuffling of the array.
     *  打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * */
    public int[] shuffle() {
        int n=nums.length;
        int rand;
        for(int i=0;i<n-1;i++){
            rand=random(i,n);
            swap(i,rand);
        }
        return nums;
    }
    private  void  swap(int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    Random rand;
    private  int random(int min,int max){
       return rand.nextInt(max - min)+min;
    }
}

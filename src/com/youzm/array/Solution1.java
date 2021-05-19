package com.youzm.array;

import com.youzm.other.Solution;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int index=0;

        int resultLength=1;
        int length=nums.length;
        for(int i=1;i<length;i++){
            if(nums[i]!=nums[index]){
                nums[resultLength]=nums[i];
                index=i;
                resultLength++;
            }
        }
        return resultLength;
    }

    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        int[] nums={1,1,2};
        System.out.println(solution1.removeDuplicates(nums));
    }
}

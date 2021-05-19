package com.youzm.stack;

import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
public class Solution33 {
    public int[] nextGreaterElements(int[] nums) {
        int length=nums.length;
        int[] largers=new int[length];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<length;i++){
            while (!stack.empty()&&nums[i]>nums[stack.peek()]){
                largers[stack.pop()]=nums[i];
            }
            stack.push(i);
        }
        for(int i=0;i<length;i++){
            while (!stack.empty()&&nums[i]>nums[stack.peek()]){
                largers[stack.pop()]=nums[i];
            }
        }
        while (!stack.empty()){
            largers[stack.pop()]=-1;
        }
        return largers;
    }

    public static void main(String[] args) {
        Solution33 solution33=new Solution33();
        int[] nums={1,1,1};
        System.out.println(solution33.nextGreaterElements(nums));
    }
}

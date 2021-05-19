package com.youzm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int minSum=nums[first] + nums[first+1] + nums[first+2] + nums[first+3];
            if(minSum>target){
                break;
            }
            int maxSum= nums[first] + nums[length-3] + nums[length-2] + nums[length-1];
            if(maxSum<target){
                continue;
            }
            int fourth = length - 1;
            while (fourth > first + 2) {

                if ( fourth < length - 1 && nums[fourth] == nums[fourth + 1] ) {
                    fourth--;
                    continue;
                }
                int second = first + 1;
                int third = fourth - 1;
                while (second < third) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third--;
                        second++;
                        while (nums[second] == nums[second - 1] && second <= third) {
                            second++;
                        }
                        while (nums[third] == nums[third + 1] && second <= third) {
                            third--;
                        }
                    } else if (sum > target) {
                        third--;
                    } else {
                        second++;
                    }
                }
                fourth--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();



        int[] nums = {0,-6,-6,5,7,-7,5,8,-2,9,2,-5,4,-5};
        int target = -24;
        System.out.println(solution5.fourSum(nums, target));
    }
}

package com.youzm.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。*/
public class Solution20 {


    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i < 1 << n; i++) {
            int m = i;
            //构造子序列
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((m & 1) != 0) {
                    temp.add(nums[j]);
                }
                m >>= 1;
            }
            //判断是否符合条件
            int min = Integer.MIN_VALUE;
            boolean flag = true;
            if(temp.size()>1){
                for (int t = 0; t < temp.size(); t++) {
                    if (temp.get(t) < min) {
                        flag = false;
                        break;
                    }
                    min = temp.get(t);
                }

                if (flag) {
                    result.add(temp);
                }
            }


        }
        return result;


    }


}

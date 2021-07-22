package com.youzm.array;

import java.util.HashMap;

/***
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 */
public class Solution17 {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > length / 2) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {

        int ans = 0;
        int x = -1;
        for (int num : nums) {
            if (ans == 0) {
                x = num;
                ans++;
            } else {
                if (x == num) ans++;
                else ans--;
            }
        }
        int n = nums.length;
        ans=0;
        for (int num : nums) {
            if (num == x) ans++;
        }
        return ans > n / 2 ? x : -1;
    }
}

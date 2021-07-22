package com.youzm.array;

import java.util.Arrays;
import java.util.HashMap;

/***
 *  给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *  数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *  你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *  在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * */
public class Solution18 {
    int MOD = 1000000007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum = 0, max = 0;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {

            int value = Math.abs(nums1[i] - nums2[i]);
            if (value == 0) continue;
            sum += value;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (sorted[mid] > nums2[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int mValue = Math.abs(sorted[r] - nums2[i]);
            if (r + 1 < n) {
                mValue = Math.min(mValue, Math.abs(sorted[r + 1] - nums2[i]));
            }
            if (mValue < value) {
                max = Math.max(max, value - mValue);
            }


        }

        return (sum - max) % MOD;

    }

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};

        int result = solution.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(result);
    }
}

package com.youzm.array;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/***
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了
 * */
public class Solution22 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] flags = new int[51];
        //使用数组标记各个区间的覆盖情况
        //数组大于0位覆盖，
        for (int[] range : ranges) {
            flags[range[0]]++;
            flags[range[1] + 1]--;
        }
        for (int i = 1; i < flags.length; i++) {
            flags[i] += flags[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (flags[i] <= 0) {
                return false;
            }
        }
        return true;

    }

    public boolean isCovered2(int[][] ranges, int left, int right) {
        BitSet bitSet = new BitSet();
        for (int[] range : ranges) {
            bitSet.set(range[0], range[1] + 1);
        }
        int i = bitSet.nextClearBit(left);

        return i > right;

    }

    public static void main(String[] args) {
        int[][] ranges = {{1, 3}};
        Solution22 solution22 = new Solution22();
        solution22.isCovered2(ranges,1,2);

    }
}

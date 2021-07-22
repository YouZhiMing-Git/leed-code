package com.youzm.math;

import javax.management.modelmbean.ModelMBean;
import java.util.HashMap;
import java.util.Map;

/***
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 */

public class Solution4 {
    public int countPairs(int[] deliciousness) {

        int MOD = 1000000007;
        int max = 1 << 22;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int current : deliciousness) {
            for (int sum = 1; sum < max; sum <<= 1) {
                int other = sum - current;
                if(map.containsKey(other)){
                    int otherCount = map.get(other);
                    ans = (ans + otherCount) % MOD;
                }


            }
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] param={1048576,1048576};
        Solution4 solution = new Solution4();
        System.out.println(solution.countPairs(param));
    }
}

package com.youzm.other;

/***
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 */
public class Solution19 {
    public int numSquares(int n) {
        //动态规划

        int[] f=new int[n+1];

        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;i>=j*j;j++){
                min=Math.min(min,f[i-j*j]);
            }
            f[i]=min+1;
            
        }
        return f[n];
    }
}

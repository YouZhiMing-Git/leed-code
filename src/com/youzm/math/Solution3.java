package com.youzm.math;

/**
 *
 统计所有小于非负整数 n 的质数的数量。
 示例:
 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution3 {
    public int countPrimes(int n) {
      int res=0;
      int sqrt_n=(int)Math.sqrt(n);
      if(n>2)res++;
      boolean[] flag=new boolean[n];
      for(int i=3;i<n;i+=2){
          if(!flag[i]){
              if(i<sqrt_n){
                  for(int j=i;i*j<n;j+=2){
                      flag[i*j]=true;
                  }
              }
              res++;
          }
      }
      return res;
    }
}

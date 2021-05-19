package com.youzm.math;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class Solution2 {
    //递归方式
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if (n < 3) return false;
        else if (n % 3 == 0) {
            if (n / 3 == 1) return true;
            else {
                return isPowerOfThree(n / 3);
            }

        } else {
            return false;
        }
    }
    //换底公式
    /*
    * log3(n)=log10(n)/log10(3)
    * */
    public boolean isPowerOfThree1(int n){
        double res=Math.log10(n)/Math.log10(3);
        return res>(int)res?false:true;
    }
}

package com.youzm.other;

/**
 * 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class Solution13 {
    public int hammingWeight(int n) {
        int res=0;
        if(n<0)res++;
        for(int i=0;i<31;i++){
            res+=n&1;
            n>>=1;
        }
        return res;
    }
}

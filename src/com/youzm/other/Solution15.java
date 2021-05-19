package com.youzm.other;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class Solution15 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<31;i++){
            res+=n&1;
            res<<=1;
            n>>=1;
        }
        return res;
    }
}

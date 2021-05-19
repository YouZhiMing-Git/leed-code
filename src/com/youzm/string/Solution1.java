package com.youzm.string;

public class Solution1 {
    public void reverseString(char[] s) {
        int n=s.length;
        int begin=0,end=n-1;
        while (begin<end){
            char temp=s[begin];
            s[begin]=s[end];
            s[end]=temp;
            begin++;
            end--;
        }
    }
}

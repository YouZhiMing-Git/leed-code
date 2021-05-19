package com.youzm.stack;

public class Solution18 {
    public int countSubstrings(String s) {
        char[] chars=s.toCharArray();
        int result=0;
        int length=chars.length;
        if(length<2) return length;
        for(int i=0;i<length;i++){
            int j=i;
            int k=i;
            int m=i;
            int n=i+1;
            while (j>=0&&k<length){
                if(chars[j]!=chars[k]){
                    break;
                }
                result++;
                j--;
                k++;
            }

            while (m>=0&&n<length){
                if(chars[m]!=chars[n]){
                    break;
                }
                result++;
                m--;
                n++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution18 solution18=new Solution18();
        String str="aaa";
        System.out.println(solution18.countSubstrings(str));
    }
}

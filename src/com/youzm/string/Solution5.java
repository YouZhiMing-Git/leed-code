package com.youzm.string;

public class Solution5 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        int hayLength=haystack.length();
        int needleLength=needle.length();
        int n=hayLength-needleLength+1;
        int index=-1;
        for(int i=0;i<n;i++){
            boolean flag=true;
            for (int j=0;j<needleLength;j++){
                if(needle.charAt(j)!=haystack.charAt(j+i)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                index=i;
                break;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        String str1="hello";
        String str2="ll";

    }
}

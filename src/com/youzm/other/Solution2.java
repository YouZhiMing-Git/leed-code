package com.youzm.other;

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        for (String s : strs) {
            if (s.length() == 0) return "";
        }
        String temp = "";
        int index = 1;
        boolean flag = true;


        while (flag) {
            if (index > strs[0].length()) {
                return temp;
            }
            temp = strs[0].substring(0, index);
            for (String s : strs) {
                if (s.indexOf(temp) != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                index++;
            }
        }
        if(index>1){
            temp=strs[0].substring(0,index-1);
        }else {
            temp="";
        }
        return temp;

    }
    public String longestCommonPrefix1(String[] strs){
        if(strs == null || strs.length == 0) return "";

        for(int i=0;i<strs.length;i++){
            while (strs[i].indexOf(strs[0])!=0){
                strs[0]=strs[0].substring(0,strs[0].length()-1);
                if(strs[0].length()<=0){
                    return "";
                }
            }
        }
        return strs[0];


    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestCommonPrefix(strs));

    }
}

package com.youzm.string;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] sCount=new int[26];
        int[] tCount=new int[26];

        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(sCount[i]!=tCount[i])return false;
        }
        return true;

    }
}

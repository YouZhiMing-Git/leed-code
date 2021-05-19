package com.youzm.string;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class Solution2 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar_1(String s){
        int result=Integer.MAX_VALUE;
        for(char c='a';c<='z';c++){
            int index=s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                result=Math.min(result,index);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}

package com.youzm.array;

import java.util.*;

public class Solution14 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> listMap=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!listMap.containsKey(key)) {
                listMap.put(key, new ArrayList<>());
            }
            listMap.get(key).add(str);
        }
        listMap.forEach((k,v)->{
            result.add(v);
        });
        return result;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution14.groupAnagrams(strs);
        System.out.println(lists);
    }
}

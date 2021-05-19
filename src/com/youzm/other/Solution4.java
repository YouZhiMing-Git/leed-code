package com.youzm.other;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public List<String> letterCombinations(String digits) {
        String[] dataOrigin = {" ", " ", "abc", "def", "fhi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        char[] digitList = digits.toCharArray();
        for (char digit : digitList) {
            int index = digit - '0';
            String stringValue = dataOrigin[index];
            char[] charValues = stringValue.toCharArray();
            List<String> temp = new ArrayList<>();
            if (result.size() == 0) {
                for (char value : charValues) {
                    result.add(Character.toString(value));
                }
            } else {
                for (String r : result) {
                    for (char value : charValues) {
                        temp.add(r + value);
                    }
                }
                result.clear();
                result.addAll(temp);
                temp.clear();
            }

        }
        return result;

    }


    private String[] dataOrigin = {" ", " ", "abc", "def", "fhi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations1(String digits) {
        if(digits==null||digits.length()==0){
            return result;
        }
        dfs(digits, 0, "");
        return result;
    }

    List<String> result = new ArrayList<>();

    private void dfs(String digit, int frequency, String s) {
        //结束条件
        //递归次数=digit长度
        if (frequency == digit.length()) {
            result.add(s);
            return;
        }
        //继续分解到下一级
        int index = digit.charAt(frequency) - '0';
        String str = dataOrigin[index];
        for(char c:str.toCharArray()){
            dfs(digit, frequency + 1, s + c);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String nums = "23";
        System.out.println(solution4.letterCombinations1(nums));
    }
}

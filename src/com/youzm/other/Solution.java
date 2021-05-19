package com.youzm.other;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 3) {
            return s;
        }
        List<StringBuilder> strList = new ArrayList(numRows);
        for (int j = 0; j < numRows; j++) {
            strList.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            strList.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        String result = "";
        for (StringBuilder sb : strList) {
            result = result + sb.toString();
        }
        return result;
    }


    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindromeLength(s, i, i);
            int len2 = palindromeLength(s, i, i + 1);
            maxLength = Math.max(len1, len2);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
            /* System.out.println(s.substring(start,end));*/
        }
        System.out.println(maxLength);
        return s.substring(start, end);
    }

    public int palindromeLength(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (chars[i] == ' ') {
            i++;
        }
        if (chars[i] == '+' || chars[i] == '-' || chars[i] < '0' || chars[i] > '9') {
            return 0;
        } else {
            return 0;
        }

    }

    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;
        int pre_2 = 0;
        for (int k = 0; k < nums.length; k++) {
            cur = Math.max(pre, pre_2 + nums[k]);
            pre_2 = pre;
            pre = cur;
        }
        return cur;
    }


    public int myAtoi1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean flag = false;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                flag = true;
            }
            index++;
        }
        int result=0;
        while (index<str.length()&&Character.isDigit(str.charAt(index))){
            if(result>(Integer.MAX_VALUE-(str.charAt(index)-'0'))/10){
                return flag?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            result=result*10+(str.charAt(index)-'0');
            index++;
        }
        return flag?-result:result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /*String s="ASDFGHJKLKJHGFDSASDFGH";
        solution.convert(s,3);
        System.out.println(solution.longestPalindrome(s));*/
      /*  int[] nums = new int[]{1, 2, 3, 2, 15};
        System.out.println(solution.rob(nums));*/

        String example = "";
        System.out.println(solution.myAtoi1(example));


    }
}

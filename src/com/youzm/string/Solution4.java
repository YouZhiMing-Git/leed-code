package com.youzm.string;

public class Solution4 {
    public boolean isPalindrome(String s) {
        if(s.length()<2)return true;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int length = s.length();
        int begin = 0, end = length - 1;

        while (begin < end) {
            if ((!Character.isDigit(chars[begin])) && (!Character.isLetter(chars[begin]))) {
                begin++;
                continue;
            } else if ((!Character.isDigit(chars[end])) && (!Character.isLetter(chars[end]))) {
                end--;
                continue;
            } else {
                if (chars[begin] == chars[end]) {
                    begin++;
                    end--;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution4 solution4=new Solution4();
        String str="A man, a plan, a canal: Panama";
        System.out.println(solution4.isPalindrome(str));
    }
}

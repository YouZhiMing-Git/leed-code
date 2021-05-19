package com.youzm.other;

public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x;
        int destination = 0;
        while (x > 0) {
            destination = destination * 10 + x % 10;
            x = x / 10;
        }
        return origin == destination;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0) return false;
        int origin = x;
        int destination = 0;
        while (x > 0) {
            destination = destination * 10 + x % 10;
            x = x / 10;
        }
        return origin == destination;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int temp = 0;
        int tempr = 0;
        while (left < right) {
            temp = (right - left) * Math.min(height[left], height[right]);
            if (height[left] < height[right]) left++;
            else right--;
            result = Math.max(result, temp);
        }
        return result;

    }


    public String intToRoman(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < values.length) {
            while (num >= values[index]) {
                sb.append(reps[index]);
                num = num - values[index];
            }
            index++;
        }
        return sb.toString();


    }

    public int romanToInt(String s) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        int result = 0;
        int idx = 0;
        while (index < reps.length) {
            while ((idx = s.indexOf(reps[index])) == 0) {
                result += values[index];
                s = s.substring(reps[index].length());
            }
            index++;
        }
        return result;
    }

    public int romanToInt1(String s) {
       char[] chars=s.toCharArray();
       int length=s.length();
       int result=0 ;
       int temp=0;
       int cur;
       for(int i=length-1;i>=0;i--){
           cur=getValue(chars[i]);
           if(cur<temp){
               result=result-cur;
           }
           else {
               result+=cur;
           }
           temp=cur;
       }
       return result;
    }

    public int getValue(char s){
        switch (s){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;

        }
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int testnum = 454;
        System.out.println(solution1.isPalindrome(testnum));

        int testnum1 = 3;
        System.out.println(solution1.intToRoman(testnum1));

        System.out.println(solution1.romanToInt1("IV"));
    }

}

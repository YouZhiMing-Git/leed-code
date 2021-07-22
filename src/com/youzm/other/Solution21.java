package com.youzm.other;

import java.util.Stack;

/***
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 */

public class Solution21 {
    public String convertToTitle(int columnNumber) {
       StringBuilder sb=new StringBuilder();
       while (columnNumber>0){
           columnNumber--;
           sb.append((char)(columnNumber%26+'A'));
           columnNumber/=26;
       }
       return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        System.out.println(solution21.convertToTitle(52));
    }
}

package com.youzm.string;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class Solution6 {
    public String countAndSay(int n) {
        String baseStr="1";
        if(n==1)return baseStr;

        for(int i=1;i<n;i++){
            baseStr=initStr(baseStr);
        }
        return baseStr;
    }

    public String initStr(String str){

        char[] chars=str.toCharArray();
        int length=str.length();
        StringBuilder sb=new StringBuilder();
        int charCount=1;
        for(int i=0;i<length;i++){
            if(i+1==length){
                sb.append(charCount);
                sb.append(chars[i]);
                charCount=1;
                break;
            }
            if(chars[i]==chars[i+1]){
                charCount++;
            }else{
                sb.append(charCount);
                sb.append(chars[i]);
                charCount=1;
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Solution6 solution6=new Solution6();
        System.out.println(solution6.countAndSay(6));
    }
}

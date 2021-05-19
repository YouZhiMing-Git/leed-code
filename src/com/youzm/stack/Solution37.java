package com.youzm.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Solution37 {
    /**
     * 有限状态机
     * 0起始状态 1符号（+、-）2整数部分 3无整数小数点  4有整数小数点 5小数 6指数底数（e/E）7指数符号（+/-） 8指数 9结束空格
     */
    public boolean isNumber(String s) {
        Map[] maps={
                new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',3);}},//0
                new HashMap(){{put('.',3);put('d',2);}},//1
                new HashMap(){{put('d',2);put('.',4);put('e',6);put(' ',9);}},//2 合法
                new HashMap(){{put('d',5);}},//3
                new HashMap(){{put('d',5);put('e',6);put(' ',9);}},//4 合法
                new HashMap(){{put('d',5);put('e',6);put(' ',9);}},//5 合法
                new HashMap(){{put('s',7);put('d',8);}},//6
                new HashMap(){{put('d',8);}},//7
                new HashMap(){{put('d',8);put(' ',9);}},//8
                new HashMap(){{put(' ',9);}}//9 合法
        };
        char[] chars=s.toCharArray();
        int t=0;
        char p;
        for(char c:chars){
            if(c=='+'||c=='-') p='s';
            else if(c=='.')p='.';
            else if(c=='e'||c=='E')p='e';
            else if('0'<=c&&c<='9') p='d';
            else if(c==' ')p=' ';
            else p='?';
            if(!maps[t].containsKey(p))return false;
            t=(int)maps[t].get(p);
        }
        if(t==2||t==4||t==5||t==8||t==9)return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution37 solution37=new Solution37();
        String str="26.e3";
        System.out.println(solution37.isNumber(str));
    }
}

package com.youzm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class Solution1 {
    public List<String> fizzBuzz(int n) {
        List<String> resultList=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(i%3==0&&i%5!=0)resultList.add("Fizz");
            else if(i%3!=0&&i%5==0)resultList.add("Buzz");
            else if(i%3==0&&i%5==0)resultList.add("FizzBuzz");
            else resultList.add(Integer.toString(i));
        }
        return resultList;
    }
}

package com.youzm.array;

import java.util.*;

public class Solution15 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num=0;
        for (int c : costs) {
            if(c<=coins){
                coins-=c;
                num++;
            }else {
                break;
            }
        }
        return num;
    }
}

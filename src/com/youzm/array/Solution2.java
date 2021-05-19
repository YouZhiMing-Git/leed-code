package com.youzm.array;


/**
 *
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int length=prices.length;
        int buyIndex=-1;
        int profit=0;
        for(int i=0;i<length-1;i++){
            if(prices[i+1]>prices[i]&&buyIndex<0){
                buyIndex=i;
            }else if(prices[i+1]<prices[i]&&buyIndex>=0) {
                profit+=prices[i]-prices[buyIndex];
                buyIndex=-1;
            }
        }
        if(buyIndex>=0){
            profit+=prices[length-1]-prices[buyIndex];
        }
        return profit;

    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        int[] prices={1,2,3,4,5};
        System.out.println(solution2.maxProfit(prices));
    }
}

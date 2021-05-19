package com.youzm.array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 */
public class Solution7 {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        addOne(digits,n-1);

        if(digits[0]==0){
            int[] result=new int[n+1];
            result[0]=1;
            for(int i=0;i<n;i++){
                result[i+1]=digits[i];
            }
            return result;
        }else {
            return digits;
        }
    }
    public void addOne(int[] data,int index){
        if(index<0)return;
        if(data[index]<9) {
            data[index]=(data[index]+1)%10;
            return;
        }else {
            data[index]=0;
            addOne(data,index-1);
        }
    }
/***************************************************************************************************/
    public int[] plusOne1(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]!=0) return digits;
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
}

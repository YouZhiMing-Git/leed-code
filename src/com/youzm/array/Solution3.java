package com.youzm.array;

public class Solution3 {
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        k=k%length;
        if(length<2) return;
        for(int i=0;i<k;i++){
            int temp=nums[length-1];
            for(int j=length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }
    public void rotate1(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);;
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums,int begin,int end){
        int temp;
        while (begin<end){
            temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
            begin++;
            end--;
        }
    }
}

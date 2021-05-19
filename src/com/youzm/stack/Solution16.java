package com.youzm.stack;

/*给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
*/
public class Solution16 {
    /*
    * 暴力破解
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        for(int i=0 ;i<nums1.length;i++){
            result[i]=-1;
            boolean flag=false;
            for(int n2:nums2){
                if(nums1[i]==n2){
                   flag=true;
                }
                if(flag&&n2>nums1[i]){
                    result[i]=n2;
                    break;
                }
            }
        }
        return result;
    }

}

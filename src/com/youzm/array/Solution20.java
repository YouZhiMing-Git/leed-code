package com.youzm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * */
public class Solution20 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int i=0,j=0;
        int left=-1,right=matrix[0].length;
        int top=0,button=matrix.length;

        while (true){

            //往右遍历
            while (j<right){
                res.add(matrix[i][j++]);
            }
            j--;
            i++;
            right--;
            //往下遍历
            while (i<button){
                res.add(matrix[i++][j]);
            }
            i--;
            j--;
            button--;
            //往左遍历
            while (j>left){
                res.add(matrix[i][j--]);
            }
            j++;
            i--;
            left++;
            //往上遍历
            while (i>top){
                res.add(matrix[i--][j]);
            }
            i++;
            j++;
            top++;
            if(top==button&&left==right){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        int [][] arrays={{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println(s.spiralOrder(arrays));
    }
}

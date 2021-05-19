package com.youzm.arraysort;

/**
 * 计数排序
 * 将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 *
 *
 * 适用于数组大小范围确定且不大
 */
public class CountSort {
    public  int[] countSort(int[] arrs){
        if(arrs==null||arrs.length<2)return arrs;
        //找到arrs中的最大值
        int max=arrs[0];
        for(int v:arrs){
            max=v>max?v:max;
        }
        //创建长度为max+1（0~max）的数组
        int[] countArr=new int[max+1];
        //累加结果
        for(int v:arrs){
            countArr[v]++;
        }
        //遍历结果
        int j=0;
        for(int i=0;i<max+1;i++){
            while (countArr[i]>0){
                arrs[j++]=i;
                countArr[i]--;
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        CountSort countSort=new CountSort();
        int[] arrs={0, 1, 1, 2, 3, 3, 3, 4, 8, 5, 5, 6, 7, 7, 8, 9, 9, 9, 9, 10};
        countSort.countSort(arrs);
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}

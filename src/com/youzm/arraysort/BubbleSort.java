package com.youzm.arraysort;

/**
 * 冒泡排序
 *      把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。
 *      接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置….
 */
public class BubbleSort {
    public int[] bubbleSort(int[] arrs){
        int n=arrs.length;
        if(n<2)return arrs;

        for(int i=0;i<n;i++){
            boolean flag=true;
            for(int j=0;j<n-i-1;j++){
                if(arrs[j]>arrs[j+1]) {
                    swap(arrs, j, j + 1);
                    flag=false;
                }
            }
            if(flag)break;
        }
        return arrs;
    }
    private void swap(int[] arrs,int i,int j){
        int temp=arrs[i];
        arrs[i]=arrs[j];
        arrs[j]=temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort=new BubbleSort();
        int[] arrs={45,5,68,6,59,755,69,21,456};
        System.out.println(bubbleSort.bubbleSort(arrs));
    }
}

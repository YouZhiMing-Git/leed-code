package com.youzm.other;

import java.util.Stack;

public class Solution9 {

    /**
     * @param height
     * 按列求
     * @return
     */
    public int trap(int[] height) {
        int result=0;
        int length=height.length;
        int leftMax=0;
        int rightMax=0;
        int[] rightMaxs=new int[height.length];
        for(int i=length-2;i>=0;i--){
            rightMaxs[i]=Math.max(rightMaxs[i+1],height[i+1]);
        }

        for(int i=1;i<length-1;i++){
            leftMax=Math.max(leftMax,height[i-1]);

            if(leftMax>height[i]&&rightMaxs[i]>height[i]){
                result+=Math.min(leftMax,rightMaxs[i])-height[i];
            }
        }
        return result;
    }


    public int trap1(int[] height){
        int result=0;
        Stack<Integer> stack=new Stack<>();
        int index=0;
        int length=height.length;
        while (index<length){
            while (!stack.isEmpty()&&height[stack.peek()]<height[index]){
                int h=height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                //
                int wight=index-stack.peek()-1;
                result+=(Math.min(height[stack.peek()],height[index])-h)*wight;


            }

            stack.push(index);
            index++;
        }
        return result;
    }
}

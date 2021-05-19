package com.youzm.other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution11 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int length = heights.length;
        int[] heights_new = new int[length + 2];
        heights_new[0] = 0;
        for (int i = 0; i < length; i++) {
            heights_new[i + 1] = heights[i];
        }
        heights_new[length + 1] = 0;

        Stack<Integer> stack = new Stack<>();

        length = heights_new.length;
        int index = 0;
        while (index < length) {
            while ((!stack.isEmpty()) && heights_new[index] < heights_new[stack.peek()]) {
                int top = stack.peek();
                int temp = (index - top-1) * heights_new[top];
                result = Math.max(result, temp);
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
            }
            stack.push(index);
            index++;
        }
        return result;
    }



    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] heights = {2, 1, 2};
        System.out.println(solution11.largestRectangleArea(heights));
    }
}

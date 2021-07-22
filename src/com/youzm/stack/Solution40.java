package com.youzm.stack;

import com.youzm.contruct.TreeNode;

import java.util.*;

/**
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推
 */
public class Solution40 {
    String formula;
    int n;
    int i;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        this.n = formula.length();
        this.i = 0;

        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map;
        stack.push(new HashMap<>());
        String atom;
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if (c == ')') {
                i++;
                map = stack.pop();
                Map<String, Integer> upperMap = stack.peek();
                int num = readNum();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    upperMap.put(entry.getKey(), upperMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * num);
                }

            } else {
                map = stack.peek();
                 atom = readAtom();
                map.put(atom, map.getOrDefault(atom, 0) + readNum());
            }
        }
        map = stack.pop();
        TreeMap<String, Integer> treeMap=new TreeMap(map);
        StringBuilder sb=new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue()>1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public String readAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
        return sb.toString();
    }

    public int readNum() {
        StringBuilder sb = new StringBuilder();
        if (i==n||!Character.isDigit(formula.charAt(i)))
            return 1;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        String testStr="H2O";
        Solution40 solution = new Solution40();
        System.out.println(solution.countOfAtoms(testStr));
    }

}

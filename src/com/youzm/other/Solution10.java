package com.youzm.other;

import java.util.Stack;

public class Solution10 {
    /*
    * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
    * */
    /*
    * 1 根据 / 切分
    *
    * */
    public String simplifyPath(String path) {
        String[] dics=path.split("/");
        int length=dics.length;
        Stack<String> stack=new Stack<>();
        for(String dic:dics){
            if(!stack.isEmpty()&&dic.equals("..")){
                stack.pop();
            }else if(!dic.equals("")&&!dic.equals(".")&&!dic.equals("..")){
                stack.push(dic);
            }
        }
        StringBuilder sb=new StringBuilder();
        if(stack.isEmpty()){
            return "/";
        }
        while (!stack.isEmpty()){
            sb.insert(0,"/"+stack.peek());
            stack.pop();
        }
        return sb.toString();

    }

    public String simplifyPath1(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();

    }

    public static void main(String[] args) {
        Solution10 solution10=new Solution10();
        String str="/a/../../b/../c//.//";
        System.out.println(solution10.simplifyPath1(str));
    }
}
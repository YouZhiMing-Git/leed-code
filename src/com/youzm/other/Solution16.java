package com.youzm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution16 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> res=new ArrayList<>();
            res.add(1);
            for(int j=1;j<i;j++){
                int val=resList.get(i-1).get(j-1)+resList.get(i-1).get(j);
                res.add(val);
            }
            if(i>0)res.add(1);
            resList.add(res);
        }
        return resList;
    }
}

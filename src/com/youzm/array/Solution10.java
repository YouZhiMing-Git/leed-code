package com.youzm.array;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class Solution10 {
    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer,Integer>[] cols=new HashMap[9];
        HashMap<Integer,Integer>[] rows=new HashMap[9];
        HashMap<Integer,Integer>[] boxes=new HashMap[9];
        for(int i=0;i<9;i++){
            cols[i]=new HashMap<>();
            rows[i]=new HashMap<>();
            boxes[i]=new HashMap<>();
        }
        //boxex的index= (row / 3) * 3 + columns / 3
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c!='.'){
                    int num=(int)c;
                    int boxesIndex=(i / 3) * 3 + j / 3;
                    int colCount=cols[j].getOrDefault(num,0)+1;
                    int rowCount=rows[i].getOrDefault(num,0)+1;
                    int boxesCount=boxes[boxesIndex].getOrDefault(num,0)+1;
                    cols[j].put(num,colCount);
                    rows[i].put(num,rowCount);
                    boxes[boxesIndex].put(num,boxesCount);
                    if(cols[j].get(num)>1||rows[i].get(num)>1||boxes[boxesIndex].get(num)>1)return false;
                }
            }
        }
        return true;
    }
}

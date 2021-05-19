package com.youzm.stack;

public class Solution29 {
    public boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        char[] moveList = moves.toCharArray();
        for (char move : moveList) {
            if (move == 'R') {
                position[0]++;
                continue;
            }

            if (move == 'L'){
                position[0]--;
                continue;
            }
            if(move=='U'){
                position[1]++;
                continue;
            }
            if(move=='D'){
                position[1]--;
                continue;
            }

        }
        return position[0]==0&&position[1]==0;
    }
}

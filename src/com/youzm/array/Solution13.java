package com.youzm.array;

import java.util.HashSet;

public class Solution13 {
    public void setZeroes(int[][] matrix) {

        int length = matrix.length;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int size = matrix[i].length;
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int size = matrix[i].length;
            if (rows.contains(i)) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = 0;
                }
            } else {
                for (int j = 0; j < size; j++) {
                    if (cols.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
}

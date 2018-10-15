package com.company.superme198.Core;

import java.util.Arrays;

public class VolleyballPositions {


    /**Link:https://app.codesignal.com/arcade/code-arcade/list-backwoods/fmYdsYcGfaTu4yTQt/description
     * The team you favor plays in the following formation:
     * 0 3 0
     * 4 0 2
     * 0 6 0
     * 5 0 1
     * Rotate Kth
     * */
    static String[][] volleyballPositions(String[][] formation, int k){


        k = k% 6;
        if(k == 0) return formation;
        for (int i = 0; i < k; i++) {
            String temp = formation[0][1];
            formation[0][1] = formation[1][2];
            formation[1][2] = formation[3][2];
            formation[3][2] = formation[2][1];
            formation[2][1] = formation[3][0];
            formation[3][0] = formation[1][0];
            formation[1][0] = temp;
        }

        return formation;
    }



    public static void main(String...args){
        System.out.println(Arrays.deepToString(volleyballPositions(new String[][]{{"empty", "Player5", "empty"},
                {"Player4", "empty", "Player2"}, {"empty", "Player3", "empty"}, {"Player6", "empty", "Player1"}}, 2)));
    }
}

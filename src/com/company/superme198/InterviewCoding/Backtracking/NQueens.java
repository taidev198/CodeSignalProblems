package com.company.superme198.InterviewCoding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by traig on 9:37 PM, 12/9/2018
 */
public class NQueens {


    /**Link:https://app.codesignal.com/interview-practice/task/7u7oKqXoFdmh3vGyb/description
     * Tus:https://app.codesignal.com/interview-practice/topics/backtracking/tutorial*/
    static int[][] nQueens(int n) {
        if(n == 1)
            return new int[][]{{1}};
        boolean[][] visited =  new boolean[n][n];
        List<int[]> ans = new ArrayList<>();
        List<List<int[]>> chosen = new ArrayList<>();
         generateQueens(n,visited, ans, chosen, 0);
         int[][] res = new int[chosen.size()][n];
        for (int i = 0; i < chosen.size(); i++) {
            for (int j = 0; j < chosen.get(i).size(); j++) {
                res[i][j] = chosen.get(i).get(j)[1] +1;
            }
        }
        return res;
    }

    static void generateQueens(int n, boolean[][] visited,List<int[]>  ans,  List<List<int[]>> chosen, int row){
        if (row == n){
            boolean ok = true;
            for (int i = 0; i <n -1; i++) {
                if (!isValid(ans.get(0)[0], ans.get(0)[1], ans.get(i+1)[0], ans.get(i+1)[1])){
                    ok = false;
                    break;
                }
            }
            if (ok)
                chosen.add(new ArrayList<>(ans));
        }
        else {
            for(int i =0; i< n; i++){
                    if (!visited[row][i]){
                        boolean ok= true;
                        for (int[] an : ans) {
                            //   System.out.println("row:" + k + " col:" + ans[k]);
                            if (!isValid(row, i, an[0], an[1])) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok ){
                            visited[row][i] = true;
                          //  System.out.println(i +":" + j);
                            ans.add(new int[]{row, i});
                            generateQueens(n, visited, ans, chosen, row+1);
                            ans.remove(ans.size()-1);
                            visited[row][i] = false;
                        }
                    }
            }
        }
    }

    static boolean isValid(int x1, int y1, int x2, int y2){
        return (x1 != x2) && (y1 != y2) && (Math.abs(x1 - x2) != Math.abs(y1 - y2));
    }

    public static void main(String...args){
        System.out.println(Arrays.deepToString(nQueens(4)));

    }

}

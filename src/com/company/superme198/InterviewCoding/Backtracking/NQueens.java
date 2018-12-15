package com.company.superme198.InterviewCoding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by traig on 9:37 PM, 12/9/2018
 */
public class NQueens {

    static int[][] nQueens(int n) {
        if(n == 1)
            return new int[][]{{1}};
      //  int[][] ans = new int[n][n];
        boolean[][] visited =  new boolean[n][n];
        List<int[]> ans = new ArrayList<>();
        List<List<int[]>> chosen = new ArrayList<>();
         generateQueens(n,visited, ans, chosen);
        for (int i = 0; i < chosen.size(); i++) {
            for (int j = 0; j < chosen.get(i).size(); j++) {
                System.out.print(Arrays.toString(chosen.get(i).get(j)));
            }
            System.out.println();
        }
        return new int[0][0];
    }

    static void generateQueens(int n, boolean[][] visited,List<int[]>  ans,  List<List<int[]>> chosen){
        if (ans.size() == n){
            boolean ok = true;
            for (int i = 0; i <n -1; i++) {
                if (!isValid(ans.get(0)[0], ans.get(0)[0], ans.get(i+1)[0], ans.get(i+1)[1])){
                    ok = false;
                    break;
                }
            }
            if (ok)
                chosen.add(new ArrayList<>(ans));
        }
        else {
            for(int i =0; i< n; i++){
                for(int j = 0; j< n ;j++){
                    if (!visited[i][j]){
                        boolean ok= true;
                        for (int k = 0; k <ans.size() ; k++) {
                            //   System.out.println("row:" + k + " col:" + ans[k]);
                            if (!isValid(i, j, ans.get(k)[0], ans.get(k)[1])){
                                ok = false;
                                break;
                            }
                        }
                        if (ok ){
                            visited[i][j] = true;
                          //  System.out.println(i +":" + j);
                            ans.add(new int[]{i, j});
                            generateQueens(n, visited, ans, chosen);
                            ans.remove(ans.size()-1);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    static boolean isValid(int x1, int y1, int x2, int y2){
        return (x1 != x2) && (y1 != y2) && (Math.abs(x1 - y1) != Math.abs(x2 - y2));
    }

    public static void main(String...args){
        System.out.println(Arrays.deepToString(nQueens(4)));

    }

}

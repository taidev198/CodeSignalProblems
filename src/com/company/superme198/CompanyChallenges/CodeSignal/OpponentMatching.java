package com.company.superme198.CompanyChallenges.CodeSignal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpponentMatching {

    static int[][] opponentMatching(int[] xp) {
        int n = xp.length;
        if ( n ==1)
            return new int[0][];
        if(n == 2)
            return new int[][]{{0,1}};
        int radius = 0;
        int[] tmp = new int[2];
        boolean isOk = true;
        int[][] ans = new int[n/2][];
        int idx = 0;
        List<Integer> list = Arrays.stream(xp).boxed().collect(Collectors.toList());
        while(true){
            for(int i = 0; i < n ; i++){
                if(xp[i] == -1){
                    isOk  = true;
                    continue;
                }
                isOk = false;
                for(int j = i+1 ;j< n;j++){
                    if(xp[j] == -1)
                        continue;
                    if(Math.abs(xp[i] - xp[j]) <= 2*radius){
                        tmp[0] = i;
                        tmp[1] = j;
                        ans[idx++] = tmp;
                        xp[i] = -1;
                        xp[j] = -1;
                        break;
                    }
                }
                radius++;
            }
            if(isOk)
                break;
        }
        return ans ;

    }

    public static void main(String...args){

        System.out.println(Arrays.deepToString(opponentMatching(new int[]{200, 100, 70, 130, 100, 800, 810})));
    }

}

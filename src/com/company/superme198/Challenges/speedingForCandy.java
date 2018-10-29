package com.company.superme198.Challenges;

import java.util.Arrays;

public class speedingForCandy {
    /**https://app.codesignal.com/challenge/tetzWm8AJsTGWgL9X*/
    static int speedingForCandy(int[][] streets, int n, int k) {

        int row = streets.length, ans =0;
        int[] tmp = new int[row];
        for(int i =0; i< row ;i++){
            int l=0;
            int m=0;
            while (l <= streets[0].length - n){
                int s =0;
                int j =l;
                while(j < n)
                    s+= streets[i][j++];
                int t = s;
                m = Math.max( s,m);
                while(j < streets[0].length){
                    t += streets[i][j++];
                    m = Math.max( t,m);
                }
                l++;
            }
            tmp[i] = m;
        }
        Arrays.sort(tmp);
        for(int i=row-1;i>0; i--){
            if(tmp[i] >0 && k !=0){
                ans += tmp[i];
                k--;
            }

        }
        return ans;
    }

    public static void main(String...args){


        System.out.println(speedingForCandy(new int[][]{{8,4,-4,-4,4}, {1,1,-4,7,-2}, {-2,5,4,1,4},
                {-2,3,1,7,9}, {4,4,5,-2,2}}, 4 , 5));
    }

}

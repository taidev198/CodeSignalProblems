package com.company.superme198.Challenges;

/**
 * Created by traig on 7:57 AM, 11/20/2018
 */
public class HappyPanda {
    /**Link:https://app.codesignal.com/challenge/cEpnffZAHbeFQjqvC*/
    static int happyPanda(int[] coins, int[][] candies) {
        int ans =0, total =0, left =0,max=0;
        for(int i=0; i< coins.length; i++){
            total += (coins[i] + left);

            if(total < candies[i][0]){
                if(candies[i][1] >= max)
                    ans -= candies[i][1];
            }else{
                left = Math.abs(candies[i][0] - total);
                total -=candies[i][0];
                max = Math.max(max, candies[i][0]);
                ans += candies[i][1];
            }
        }
        return ans;
    }



    public static void main(String...args){
        System.out.println(happyPanda(new int[]{129, 27, 317, 339, 214, 159, 236}, new int[][]{{537,708}, {277,767}, {463,423},
                {441,121}, {412,748}, {615,228}, {170,210}}));
    }
}

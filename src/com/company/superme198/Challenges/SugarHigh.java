package com.company.superme198.Challenges;

import java.util.Arrays;

public class SugarHigh {
    /**Link:https://app.codesignal.com/challenge/dY34cRWCf9Jo7XWqb
     * Your main priority is to eat the maximum number of candies possible, but if there are multiple ways of doing this,
     * choose the one with the fewest grams of sugar total.
     * If there's still a tie, choose the lower indices.
     * Example
     *
     * For candies = [33, 20, 12, 19, 29] and threshold = 33, the output should be sugarHigh(candies, threshold) = [2, 3].
     *
     * Although [1, 2] is also valid, The candies at indices 2 and 3 have a lesser sum (12 + 19 = 31) than the candies
     * at indices 1 and 2 (20 + 12 = 32).
     * Test 10
     * Input:
     * candies: [0, 4, 11, 0, 0, 1]
     * threshold: 5
     * Expected Output:
     * [0, 1, 3, 4, 5]*/
    static int[] sugarHigh(int[] candies, int threshold) {
        int n = candies.length, idx=0, i;
        int[] ans = new int[n];
        int[] fArr = candies.clone();
        Arrays.sort(fArr);
        for( i = 0;i <n ;i++){
            if(threshold -fArr[i] >=0 ){
                threshold -= fArr[i];
                for(int j =0;j < n; j++){
                    if(candies[j] == -1)
                        continue;
                    if(fArr[i] == candies[j] ){
                        ans[idx++] = j;
                        candies[j] = -1;
                        break;
                    }
                }
            }else break;
        }
        ans = Arrays.copyOfRange(ans, 0 , idx);
        Arrays.sort(ans);
        return ans;
    }



    public static void main(String...args){
        System.out.println(Arrays.toString(sugarHigh(new int[]{16, 3, 14, 17, 11}, 99)));

    }
}

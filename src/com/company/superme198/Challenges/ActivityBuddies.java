package com.company.superme198.Challenges;

import java.util.*;

public class ActivityBuddies {

    static int[] activityBuddies(int[][] ratings) {

        int r = ratings.length;
        int c = ratings[0].length;
        int[] ans = new int[c];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i< r; i++){
            int max = ratings[i][0];
            int maxIdx = 0;
            for(int j = 0; j< c; j++){
                if(ratings[i][j] > max){
                    max = ratings[i][j];
                    maxIdx = j;
                }
            }
            if(!map.containsKey(maxIdx)) map.put(maxIdx, 1);
            else {
                int tmp = map.get(maxIdx);
                map.replace(maxIdx, tmp, tmp+1);
            }
        }

        List<Map.Entry<Integer, Integer>> lists = new ArrayList<>(map.entrySet());
        for(int i = 0; i< c; i++){
            if(lists.size() == 1){
                if(i ==0)
                    ans[0] = lists.get(0).getValue() - (r-1)*2;
                else ans[i]= 2;
            }else ans[i] = lists.get(i).getValue();
        }
        return ans;
    }

    public static void main(String...args){
        System.out.println(Arrays.toString(activityBuddies(new int[][]{{1,9, 10}, {3,9, 2},
                {5, 1,7}, {9,8, 5}, {5,5, 2}, {9,7,4},{6,6,6},{7,1,8},
                {   8,4,3},{8,5,5}})));
    }

}

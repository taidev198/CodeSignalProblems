package com.company.superme198.Challenges;

import java.util.*;

/**
 * Created by traig on 9:58 PM, 11/15/2018
 */
public class MedianScores {

    /**Link:https://app.codesignal.com/challenge/BEjXFgMYRt5435RyL
     * For scores = [100, 20, 50, 70, 45] the output should be medianScores(scores) = [100, 60, 50, 60, 50].
     *
     * After each score is entered, the median is recalculated as follows:
     *
     * For [100], the median is 100 since it's the only element.
     * For [20, 100], the median is (20 + 100)/2 = 60 since there's an even number of elements.
     * For [20, 50, 100], the median is 50 (middle element).
     * For [20, 50, 70, 100], the median is (50 + 70)/2 = 60 (mean of the two middle elements).
     * For [20, 45, 50, 70, 100], the median is 50 again (middle element).*/
    static int[] medianScores(int[] scores) {
        int len = scores.length;
        int[] ans= new int[len];
        List<Integer> res = new ArrayList<>();
        for(int i =0 ;i< len; i++){
            int s = res.size();
            if (s == 0)
                res.add(scores[i]);
            else {
                int l = 0, r = s -1;
                while (l < r){
                    int m = l + (r -l) /2;
                    if (scores[i] >= res.get(m))
                        r = m -1;
                    else l = m +1;
                }
                if (res.get(l) <= scores[i])
                res.add(l, scores[i]);
                else res.add(l+1, scores[i]);
            }
            if(i % 2 == 0)
                ans[i] =  res.get(s/2);
            else ans[i] = (int) Math.floor((res.get(s/2) + res.get(s/2 +1) +1 )/2);
        }
        return ans;

    }


    public static void main(String...args){
        System.out.println(Arrays.toString(medianScores(new int[]{100, 20, 50, 70, 45})));


    }
}

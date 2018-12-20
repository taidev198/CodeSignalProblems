package com.company.superme198.Challenges;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by traig on 6:10 AM, 12/18/2018
 */
public class SleddingHill {

    static int sleddingHills(int[] enjoyability, int maxRuns) {
        int max =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        for (int i : enjoyability) {
            queue.add(i);
        }
        while (!queue.isEmpty() && maxRuns != 0){
            int temp = queue.poll();
            max += temp;
            maxRuns--;
            if (temp >1 )
            queue.add(--temp);
        }


        return max;
    }


    public static void main(String...args){
        System.out.println(sleddingHills(new int[]{10}, 20));
    }
}

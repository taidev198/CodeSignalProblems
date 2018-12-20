package com.company.superme198.Challenges;

import java.util.PriorityQueue;

/**
 * Created by traig on 6:09 AM, 12/20/2018
 */
/**Link:https://app.codesignal.com/challenge/jPjWP6EAqKStosvve*/
public class BurningCandles {

    static int burningCandles(int[] candleSizes, int n) {
        int count =0, total =0, ans =0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->-o1.compareTo(o2));
        for(int i : candleSizes)
            queue.add(i);
        while(!queue.isEmpty()){
            int i = queue.poll();
            count++;
            total+= i;
            if(count == n){
                count =0;
                total /=(n+1);
                //ans += total;
                queue.add(total);

            }
                ans +=i;

        }
        return ans;

    }

    public static void main(String...args){
        System.out.println(burningCandles(new int[]{2, 181, 32, 188, 188}, 3));
    }
}

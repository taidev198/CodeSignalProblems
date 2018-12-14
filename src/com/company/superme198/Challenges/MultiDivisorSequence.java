package com.company.superme198.Challenges;

/**
 * Created by traig on 8:25 AM, 12/14/2018
 */
public class MultiDivisorSequence {

    /**Link:https://app.codesignal.com/challenge/supdEsjKCT7NMLDi2
     * Let's define a multi-divisor sequence as a sequence of at least 2 numbers where each number is either
     *
     * a divisor of the previous number, or
     * a multiple of the number before that
     * So [10, 5, 20, 4] is a multi-divisor sequence (5 is a divisor of 10, 20 is a multiple of 10, and 4 is a divisor of 20), but [3, 7, 11] isn't (none of these numbers are divisors or multiples of each other).
     *
     * Given a sequence of numbers, your task is to find the first element where it fails to be a multi-divisor sequence. Or return -1 if the whole thing is a multi-divisor sequence
     *
     * Example
     *
     * For nums = [3, 1, 6, 2, 42, 21, 7] the output should be multiDivisorSequence(nums) = -1.
     *
     * example 1
     *
     * This is a multi-divisor sequence the whole way through.
     *
     * For nums = [35, 5, 35, 25, 7, 175] the output should be multiDivisorSequence(nums) = 7.
     *
     * example 2
     *
     * Because 7 isn't a divisor of 25 or a multiple of 35, it's the first element where this fails to be a multi-divisor sequence.*/
    static int multiDivisorSequence(int[] nums) {

        int len = nums.length;
        for(int i =1; i< len; i++ ){
            boolean isDiv = true;
            boolean isMul = true;
            if( nums[i -1] % nums[i] != 0 )
                isDiv = false;
            if(i > 1 && nums[i ] % nums[i-2] != 0 )
                isMul = false;
            if(!isDiv && !isMul|| ((!isDiv || !isMul) && i ==1))
                return nums[i];

        }
        return -1;

    }

    public static void main(String...args){
        System.out.println(multiDivisorSequence(new int[]{529, 35, 7}));
    }
}

package com.company.superme198.Core;

import java.util.Arrays;

/**
 * Created by traig on 7:03 AM, 12/6/2018
 */
public class DigitDifferentSort {
    static int[] digitDifferenceSort(int[] a) {
        int len = a.length;
        int[] digit = new int[len];
        for(int i =0; i< len ;i ++)
            digit[i]= digitDifference(a[i]);
        for(int i=0; i< len-1; i++){
            int min = digit[i];
            int minIdx = i;
            for(int j = i+1; j < len;j++){
                if(digit[j] <= min ){
                    min = digit[j];
                    if((digit[j] == min && j> minIdx) ||(digit[j] < min))
                        minIdx = j;
                }
            }
            if(i != minIdx){
                a[i] += a[minIdx];
                a[minIdx] = a[i] - a[minIdx];
                a[i] -= a[minIdx];
                digit[i] += digit[minIdx];
                digit[minIdx] = digit[i] - digit[minIdx];
                digit[i] -= digit[minIdx];
            }

        }
        return a;
    }
    static int digitDifference(int n){
        String[] digit  = Integer.toString(n).split("");
        int max = Integer.valueOf(digit[0]), min = Integer.valueOf(digit[0]);
        for(int i =1; i< digit.length; i++){
            min = Math.min(Integer.valueOf(digit[i]), min);
            max = Math.max(Integer.valueOf(digit[i]), max);
        }
       // System.out.println(Math.abs(max - min));
        return Math.abs(max - min);

    }

    public static void main(String...args){
        System.out.println(Arrays.toString(digitDifferenceSort(new int[]{13098, 1308, 12398, 52433, 213, 424, 213, 243, 12213, 54234, 99487, 81892, 11111, 97897})));
    }
}

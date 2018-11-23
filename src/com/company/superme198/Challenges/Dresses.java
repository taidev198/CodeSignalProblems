package com.company.superme198.Challenges;

import java.util.Arrays;

/**
 * Created by traig on 6:30 AM, 11/23/2018
 */
public class Dresses {

    /**Link:https://app.codesignal.com/challenge/t8kHRFHTh4GKBCKSN*/
    static int[] dresses(String[] colors) {
        int len = colors.length, k=0;
        int[] ans = new int[len];
        for(int i=0;i < len; i++){
            char[] arr = colors[i].toCharArray();
            System.out.println(arr[0]-'0');
            int a = (((arr[0]-'0') < 10? arr[0]-'0':(arr[0]-'0')%16+ 9)*16) +((arr[1]-'0') < 10? arr[1]-'0':(arr[1]-'0') %16+9) ;
            int b = (((arr[2]-'0') < 10? arr[2]-'0':(arr[2]-'0') %16+9 )*16) +((arr[3]-'0') < 10? arr[3]-'0':(arr[3]-'0') %16+9) ;
            int c = (((arr[4]-'0') < 10? arr[4]-'0':(arr[4]-'0') %16+9 )*16) +((arr[5]-'0') < 10? arr[5]-'0':(arr[5]-'0') %16+9) ;
            if(b >c && b >a)
                ans[k++] = i;
        }
        return Arrays.copyOfRange(ans , 0 , k);
    }

    public static void main(String...args){
       // System.out.println('D' -'0');
        System.out.println(Arrays.toString(dresses(new String[]{"A0FC77",
                "90CACA"})));
    }
}

package com.company.superme198.Core;

import java.util.Arrays;

/**
 * Created by traig on 10:23 PM, 11/24/2018
 */
public class BishopDialognal {

    static String[] bishopDiagonal(String bishop1, String bishop2) {
        char x1 = bishop1.charAt(0);
        char y1 = bishop1.charAt(1);
        char x2 = bishop2.charAt(0);
        char y2 = bishop2.charAt(1);
        String[] ans = new String[2];
        if((x1- x2) %2 ==1 || (y1 - y2) % 2 ==1)
            return new String[]{bishop2, bishop1};

        if(x1 > x2 ){
            if(y1 > y2){
                while (x1 != 'h' && y1 != '8'){
                    x1++;
                    y1++;
                }
                while (x2 != 'a' && y2 != '1'){
                    x2--;
                    y2--;
                }

                ans[0]  = String.valueOf(x1 ) + String.valueOf(y1);
                ans[1]  = String.valueOf(x2 ) + String.valueOf(y2);
            }else {
                while (x1 != 'h' && y1 != '1'){
                    x1++;
                    y1--;
                }
                while (x2 != 'a' && y2 != '8'){
                    x2--;
                    y2++;
                }

                ans[0]  = String.valueOf(x1 ) + String.valueOf(y1);
                ans[1]  = String.valueOf(x2 ) + String.valueOf(y2);
            }
        }else{
            if(y1 > y2){
                while (x1 != 'a' && y1 != '8'){
                    x1--;
                    y1++;
                }
                while (x2 != 'h' && y2 != '1'){
                    x2++;
                    y2--;
                }

                ans[0]  = String.valueOf(x1 ) + String.valueOf(y1);
                ans[1]  = String.valueOf(x2 ) + String.valueOf(y2);
            }else {
                while (x1 != 'a' && y1 != '1'){
                    x1--;
                    y1--;
                }
                while (x2 != 'h' && y2 != '8'){
                    x2++;
                    y2++;
                }
                ans[0]  = String.valueOf(x1 ) + String.valueOf(y1);
                ans[1]  = String.valueOf(x2 ) + String.valueOf(y2);
            }
        }
        return ans;


    }


    public static void main(String...args){
        System.out.println(Arrays.toString(bishopDiagonal("f5", "d7")));
    }
}

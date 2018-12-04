package com.company.superme198.Core.CornerOf1sAnd2s;

/**
 * Created by traig on 3:09 PM, 12/4/2018
 */
public class ArrayPacking {
    /**Link:https://app.codesignal.com/arcade/code-arcade/corner-of-0s-and-1s/KeMqde6oqfF5wBXxf/description
     * For a = [24, 85, 0], the output should be
     * arrayPacking(a) = 21784.
     *
     * An array [24, 85, 0] looks like [00011000, 01010101, 00000000] in binary.
     * After packing these into one number we get 00000000 01010101 00011000 (spaces are placed for convenience), which equals to 21784.*/
    static int arrayPacking(int[] a) {
        int n = a.length;
        int ans =0;
        if(n == 1) return a[0];
        ans |= a[0];
        for(int i = 1;i <n; i++){
            ans |= a[i]<<(8 * i) ;
        }
        return ans;
    }

}

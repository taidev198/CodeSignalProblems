package com.company.superme198.Core;

public class ThreeSplit {


    
    static int threeSplit(int[] a) {
        int len = a.length;
        int[] prefixSum = new int[len+1];
        for(int i= 1;i <= len; i++)
            prefixSum[i] = prefixSum[i-1] + a[i-1];
        int count =0;
        for(int i= 0 ; i< len-2;i++){
            int sumOfFirstArray = prefixSum[i+1] - prefixSum[0];
            int j = i+1;
            while(j < len -1   ){
                int value = (prefixSum[j+1] - prefixSum[i+1]);
                if (value != sumOfFirstArray )
                    j++;
                else {
                    if((prefixSum[len] - prefixSum[j+1]) == sumOfFirstArray)
                        count++;
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String...args){
        System.out.println(threeSplit(new int[]{1,1,1,1,1,1}));
    }

}

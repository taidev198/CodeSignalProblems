package com.company.superme198.Core;

import java.util.Arrays;
import java.util.Comparator;

public class ShuffledArray {


    /***Link:https://app.codesignal.com/arcade/code-arcade/sorting-outpost/s4BEFMcpLdGbjX9KX*/
    static int[] shuffledArray(int[] shuffled) {
        int len = shuffled.length;
        int ans[] = new int[len -1];
        int[] prefix = new int[len+1];
        Arrays.sort(shuffled);
        for(int i=1;i<=len;i++)
            prefix[i] = prefix[i-1] + shuffled[i-1];
        for(int i=0; i< len; i++){
            if(i ==0 && prefix[len] - prefix[i+1] == shuffled[i]){
                ans =  Arrays.copyOfRange(shuffled,1, len);
                break;
            }
            else if(i == len -1 && prefix[len-1] - prefix[1] == shuffled[i] ){
                ans =  Arrays.copyOfRange(shuffled,0, len-1);

                break;
            }else if(prefix[len] - prefix[i+1] + prefix[i] - prefix[0] == shuffled[i]){
                System.arraycopy(shuffled, 0, ans, 0, i);
                System.arraycopy(shuffled, i+1, ans, i, len-i-1);
                break;
            }

        }
        return ans;
    }


    public static void main(String...args){
        Arrays.sort(new String[]{""}, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return 0;
                else if (o1.length() < o2.length())
                    return -1;
                return 1;
            }
        });
        System.out.println(Arrays.toString(shuffledArray(new int[]{1, -3, -5, 7, 2})));
    }
}

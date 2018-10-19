package com.company.superme198.Challenges;

public class ReverseInference {
    /**Link:https://app.codesignal.com/challenge/PiZD5R2h2Nrdr2ePh*/
    static int reverseInterference(String originalA, String originalB, String broadcastA, String broadcastB) {
        int i = 0, len = originalA.length(), t =0;
        char[] arrA = broadcastA.toCharArray(), arrB = broadcastB.toCharArray(),
                oriA = originalA.toCharArray(), oriB = originalB.toCharArray();
        while(i < len){
            if(oriA[i] != arrA[i]){
                if(!(oriA[i] == arrB[i] && oriB[i] == arrA[i]))
                    return -1;
                int j = i+1;
                while(j < len && oriA[j] != arrA[j]){
                    j++;
                }
                int v = j-i;
                if(v <= 3)//if less than three consecutive characters are different
                    t+= 1;//then move is one
                else{//else K
                    t += v/3;
                    v  -= (v/3) *3;
                    if (v >=1)
                        t+=1;
                }
                i = j-1;
            }else if (oriB[i] != arrB[i])
                return -1;
            i++;
        }
        return t;
    }
}

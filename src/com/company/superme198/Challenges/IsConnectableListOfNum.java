package com.company.superme198.Challenges;

import java.util.Arrays;
import java.util.Comparator;

public class IsConnectableListOfNum {


    static boolean isConnectableListOfNum(String[] listOfNum) {
        Arrays.sort(listOfNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(listOfNum));
        for(int i =0; i< listOfNum.length; i++){
            int l = i+1, r = listOfNum.length -1;
            while(l <= r){
                int m = l + (r- l)/2;
                if(listOfNum[m].contains(listOfNum[i]) ){

                    return false;
                }
                else if(listOfNum[m].compareTo(listOfNum[i]) <=0)
                    l = m-1;
                else r = m+1;
            }
        }
        return true;
    }


    public static void main(String...args){
        System.out.println(isConnectableListOfNum(new String[]{"113",
                "12340",
                "123440",
                "12345",
                "98346"}));


    }
}


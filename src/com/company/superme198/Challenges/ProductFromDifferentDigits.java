package com.company.superme198.Challenges;

import java.util.*;

public class ProductFromDifferentDigits {
    /**Link:https://app.codesignal.com/challenge/L6JX7m2WPmjvK8Mwf*/
    private static int productFromDifferentDigits(int n) {
        Set<Integer> res = new TreeSet<>();
        res.add(0);
        for(int i= 1; i<=9;i++)
            buildValue(i, 1, new ArrayList<>(), res);
        return n >= res.size()? -1:new ArrayList<>(res).get(n);
    }
   private static void buildValue(int n, int num, List<Integer> idx, Set<Integer> res){
        if(n ==0)
            res.add(num);
        else{
            for(int i=1; i<=9; i++){
                if(idx.size() == 0 || idx.get(idx.size()-1) < i){
                    idx.add(i);
                    buildValue(n-1, num * i, idx, res);
                    idx.remove(idx.size()-1);
                }
            }
        }
    }
    public static void main(String...args){
        System.out.println(productFromDifferentDigits(11));
    }

}

package com.company.superme198.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JumpingJimmy2 {

    /**Link:https://app.codesignal.com/challenge/iFMNmfhhwadSaRtpX*/
    static int jumpingJimmy2(int[] tower, int[] power, int[] poison, int jumpHeight) {
        int t=0;
        List<Integer> list = Arrays.stream(power).boxed().collect(Collectors.toList());
        List<Integer> list1 = Arrays.stream(poison).boxed().collect(Collectors.toList());
        for (int i = 0; i <tower.length; i++) {
            if (tower[i] > jumpHeight)
                break;
            t += tower[i];
            int k = i+1, tmp = tower[i];
            while (k < tower.length && tmp + tower[k] <= jumpHeight){
                t += tower[k];
                tmp += tower[k];
                k++;
            }
            k--;
              if(list.contains(k )){
                  jumpHeight++;
              }else if (list1.contains(k)){
                  jumpHeight--;
              }
              i = k;
        }


        return t;
    }


    public static void main(String...args){
        System.out.println(jumpingJimmy2(new int[]{3, 1, 3, 3, 4, 1, 4, 2, 3, 2, 3, 3, 2, 1, 1, 2, 3, 3, 4, 1, 2, 1, 2, 1, 3},
                new int[]{1, 2, 4, 7, 19}, new int[]{3, 12, 14, 16}, 4));
    }
}

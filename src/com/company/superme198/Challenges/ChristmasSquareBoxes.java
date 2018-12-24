package com.company.superme198.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by traig on 3:55 PM, 12/24/2018
 */
/**Link:https://app.codesignal.com/challenge/uhEJTTKzo6qMwTawf
 * For boxes = [5, 1, 2, 4, 7, 2, 1, 2, 3, 6], the output should be christmasSquareBoxes(boxes) = 3.
 *
 * Bill can put boxes in the following way (a -> b means that box with side a contains a box with side b):
 *
 * 7 -> 6 -> 2 -> 1;
 * 5 -> 4 -> 2;
 * 3 -> 2 -> 1.*/
public class ChristmasSquareBoxes {

    static int christmasSquareBoxes(int[] boxes) {
        Arrays.sort(boxes);
        int  ans =0;
        List<Integer> list = Arrays.stream(boxes).boxed().collect(Collectors.toList());
        int i = boxes.length -1;
        boolean[] visited = new boolean[i+1];
        List<Integer> tmp = new ArrayList<>();

        while (i >= 0){
            if (!visited[i]){
                ans++;
                tmp.add(list.get(i));
            }
            else {
                i--;
                continue;
            }
            boolean notValid = true;
            for (int j = i-1; j >=0;j--){
                if (!visited[j]){
                    notValid = false;
                    if ( tmp.size() == 0 ||list.get(j) < tmp.get(tmp.size() -1)){
                        tmp.add(list.get(j));
                        visited[j] = true;
                    }

                }
            }


            i--;
            tmp.clear();
            if (notValid)
                break;
        }
        return ans;
    }


    public static void main(String...args){
        System.out.println(christmasSquareBoxes(new int[]{4, 2, 1, 5, 5}));
    }
}

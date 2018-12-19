package com.company.superme198.InterviewCoding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by traig on 9:16 AM, 12/19/2018
 */

/**Link:https://app.codesignal.com/interview-practice/task/uJvihuafm7PRDPCsL/description
 * Given a sorted array of integers arr and an integer num, find all possible unique subsets of arr that add up to num. Both the array of subsets and the subsets themselves should be sorted in lexicographical order.
 *
 * Example
 *
 * For arr = [1, 2, 3, 4, 5] and num = 5, the output should be
 * sumSubsets(arr, num) = [[1, 4], [2, 3], [5]]*/
public class SumSubsets {

    static int[][] sumSubsets(int[] arr, int num) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        List<List<int[]>> ans = new ArrayList<>();
        List<int[]> chosen  = new ArrayList<>();
        findSubset(arr, num, visited, chosen, ans);
        int[][] res = new int[ans.size()][];
        for (int i = 0; i <ans.size(); i++) {
            int size = ans.get(i).size();
            res[i] = new int[size];
            for (int j = 0; j < size; j++) {
                res[i][j] = ans.get(i).get(j)[0];
            }
        }
        return res  ;

    }

    static void findSubset(int[] arr, int num, boolean[] visited,List<int[]> chosen, List<List<int[]>> ans){
        if(num ==0){
            if (ans.size() ==0 )
                ans.add(new ArrayList<>(chosen));
            else {
                int[] arr1 = new int[chosen.size()];

                for (int i = 0; i < chosen.size(); i++) {
                    arr1[i] = chosen.get(i)[0];
                }
                boolean ok = true;
                for (int i = 0; i < ans.size(); i++) {
                    if (ans.get(i).size() == chosen.size()){
                        int[] arr2 = new int[chosen.size()];
                        for (int j = 0; j < chosen.size(); j++) {
                            arr2[j] = ans.get(i).get(j)[0];
                        }
                        if (Arrays.equals(arr1, arr2)){
                            ok = false;
                            break;
                        }
                    }
                }
               if (ok)
                   ans.add(new ArrayList<>(chosen));
            }


        }else{
            for(int i=0; i<arr.length; i++){
                if(num - arr[i]  >=0 && !visited[i]){
                    boolean ok = true;
                    for (int[] ints : chosen) {
                        if (ints[1] >= i) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok){
                        num -= arr[i];
                        visited[i] = true;
                        chosen.add(new int[]{arr[i], i});
                        findSubset(arr, num, visited, chosen, ans);
                        chosen.remove(chosen.size() -1);
                        visited[i]= false;
                        num += arr[i];
                    }

                }
            }
        }

    }

    public static void main(String...args){
        System.out.println(Arrays.deepToString(sumSubsets(new int[]{1, 2, 2, 3, 4, 5}, 5)));
        HashSet<int[]> set = new HashSet<>();
        set.add(new int[]{1,2});
        set.add(new int[]{1,2});
        System.out.println(set.contains(new int[]{1,2}));
    }

}

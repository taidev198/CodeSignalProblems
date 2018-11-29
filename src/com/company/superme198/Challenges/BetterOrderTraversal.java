package com.company.superme198.Challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by traig on 7:19 PM, 11/29/2018
 */
public class BetterOrderTraversal {

    //
// Definition for binary tree:
 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }  /**Link:https://app.codesignal.com/challenge/W3nmGcuKzkg9AeEwo
     In-order: [95, -29, 2, 100]
     Pre-order: [-29, 95, 2, 100]
     Post-order: [95, 100, 2, -29]
     So in this case, pre-order traversal produces the lexicographically smallest result.*/
    int[] betterOrderTraversal(Tree<Integer> root) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        pre(root, preList);
        in(root, inList);
        post(root, postList);
        int i =0;
        while (i < inList.size()  ){
            if( inList.get(i) > preList.get(i)){
                List<Integer> tmpList = new ArrayList<>(inList);
                inList.clear();
                inList.addAll(preList);
                preList.clear();
                preList.addAll(tmpList);
                break;
            }else if(inList.get(i) < preList.get(i))break;
            i++;
        }
        i =0;
        while (i < inList.size() ){
            if(  inList.get(i) > postList.get(i)){
                List<Integer> tmpList = new ArrayList<>(inList);
                inList.clear();
                inList.addAll(postList);
                postList.clear();
                postList.addAll(tmpList);
                break;
            }else if(inList.get(i) < postList.get(i)) break;
            i++;
        }
        return inList.stream().mapToInt(Integer::intValue).toArray();
    }
    void pre(Tree<Integer> r, List<Integer> chosen){
        if(r != null){
            chosen.add(r.value);
            pre(r.left, chosen);
            pre(r.right, chosen);
        }
    }

    void in(Tree<Integer> r, List<Integer> chosen){
        if(r != null){

            in(r.left, chosen);
            chosen.add(r.value);
            in(r.right, chosen);
        }
    }

    void post(Tree<Integer> r, List<Integer> chosen){
        if(r != null){
            post(r.left, chosen);
            post(r.right, chosen);
            chosen.add(r.value);
        }
    }


}

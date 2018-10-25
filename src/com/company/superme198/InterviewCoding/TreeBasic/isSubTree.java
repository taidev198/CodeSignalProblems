package com.company.superme198.InterviewCoding.TreeBasic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isSubTree {
    //
// Definition for binary tree:
 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }
    /***Link:https://app.codesignal.com/interview-practice/task/mDpAJnDQkJqaYYsCg/description
     * This is what these trees look like:
     *
     *       t1:             t2:
     *        5              10
     *       / \            /  \
     *     10   7          4    6
     *    /  \            / \    \
     *   4    6          1   2   -1
     *  / \    \
     * 1   2   -1
     *
     * output:true*/
    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {

        if(t2 == null) return true;
        if(t1 == null) return false;
        Queue<Tree<Integer>> q = new LinkedList<>();
        q.add(t1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Tree<Integer> cur = q.poll();
                if(cur.value.equals(t2.value) && isSameTree(cur, t2))return true;
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }

        return false;
    }
    boolean isSameTree(Tree<Integer> q, Tree<Integer> p){
        if(q == null || p == null)
            return q == null && p == null;
        return q.value.equals(p.value) && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }

}

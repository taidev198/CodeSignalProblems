package com.company.superme198.Challenges;

import java.util.Arrays;

/**
 * Created by traig on 8:00 AM, 12/13/2018
 */
public class ModeScores {
    static int[] modeScores(int[] scores) {
    int len = scores.length;
    int[] ans = new int[len];
    if (len == 1)
        return ans;

    return ans;
    }


    public static void main(String...args){
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.heapify(5);
        maxHeap.heapify(0);
        maxHeap.heapify(5);
        maxHeap.heapify(15);
        maxHeap.heapify(58);
    }
    static class MaxHeap {
    private int size;
    private int maxSize;
    private int[] heap;

    public MaxHeap(int size){
        this.maxSize = size;
        this.size = 0;
        heap = new int[size];
    }

    public void heapify(int value){
        heap[size++] = value;
        int key = size -1;
        while (key > 0){
            int parent = (key-1)/2;
            if (heap[parent] < heap[key]){
                heap[parent] += heap[key];
                heap[key] = heap[parent] - heap[key];
                heap[parent] -= heap[key];
                key = parent;
            }else break;
        }
        print();
    }

    public void print(){

        System.out.println(Arrays.toString(heap));
    }
    }
}

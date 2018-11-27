package com.company.superme198.Challenges;

/**
 * Created by traig on 6:18 AM, 11/27/2018
 */
public class TrafficLight1D {
    /**Link:https://app.codesignal.com/challenge/RNEKN3MFMDxGwHYab*/
    static int trafficLights1D(int[][] roadMap) {
        int t=roadMap[0][0];
        for(int i =1; i<= roadMap.length; i++){
            int tmp =t /roadMap[i-1][1];
            if(tmp %2== 1 && (t < (tmp+1) * roadMap[i-1][1] && tmp * roadMap[i-1][1] <= t)){
                t += ((tmp+1) * roadMap[i-1][1] - t);//adding the waiting time.
            }
            if(i < roadMap.length)
                t += roadMap[i][0] - roadMap[i-1][0];//going to next stoplight.
        }
        return t;
    }

    public static void main(String...args){
        System.out.println(trafficLights1D(new int[][]{{24, 7}}));
    }
}

package com.company.superme198.Challenges;

public class Sine {
    /**Link:https://app.codesignal.com/challenge/omywriXpSk4k3yE9z
     * The sine ratio is a useful math tool, commonly used for finding the vertical component of an angled vector. It's defined as the ratio between the opposite side and hypotenuse of a right angle triangle.
     *
     * Given an angle theta in degrees, your task is to return sin(theta).
     *
     * Example
     *
     *     For theta = 30, the output should be sine(theta) = 0.5.*/
    public double sine(int t) {
        double x =  t / 180.0 * 3.14159265358979323846,
                ans = x,
                pow = x,
                fact = 1.0,
                ad = -1.0;
        for(int i=2; i<=10;i++){
            fact*= i;
            pow *= x;
            if(i % 2== 1){
                ans += (pow * ad)/fact;
                ad *= (-1.0);
            }
        }
        return ans;
    }
}

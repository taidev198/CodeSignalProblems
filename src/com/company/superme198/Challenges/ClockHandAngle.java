package com.company.superme198.Challenges;

/**
 * Created by traig on 9:04 PM, 11/12/2018
 */
public class ClockHandAngle {

    /**Link:https://app.codesignal.com/challenge/5gPLgp4nMtMHZ8JJF
     * Given a 12-hour time representation, in the form of a string, your task is to find the angle (in degrees) between the hour and minute hands.
     *
     * Example
     *
     * For time = "12:00:00", the output should be clockHandAngle(time) = 0
     *
     * When the hands are together, the angle between them is 0.
     *
     * For time = "3:00:00", the output should be clockHandAngle(time) = 90
     *
     * At this time, the minute and hour hands are perpendicular, which means the angle between them
     * could be measured as 90 or 270 degrees, so we return 90 since it's smaller.*/
    static double clockHandAngle(String time) {
        double ans =0.0;
        int dot = time.indexOf(":");
        int h =  Integer.valueOf(time.substring(0,dot));
        int min = Integer.valueOf(time.substring(dot+1, time.lastIndexOf(":")));
        int sec = Integer.valueOf(time.substring( time.lastIndexOf(":")+1));
        double s = 0.09166666666667425;
        h %= 12;
        if(min /5 >= h)
            ans = (Math.abs(min /5 - h)*30) - (double)min/2 + sec *s +  min %5*6;
        else  ans = (Math.abs(min /5 - h)*30) + (double)min/2 - sec *s - min %5*6;
        if(ans >180)
            ans = 360 - ans;
        return ans;
    }


    public static void main(String...args){

        System.out.println(clockHandAngle("7:46:11"));
    }
}

package com.company.superme198.InterviewCoding.DFS;

/**
 * Created by traig on 7:48 AM, 11/28/2018
 */
public class PressingButton {

    /**Link:https://app.codesignal.com/interview-practice/task/SyBbdPYC86RdkKvjH/description
     * EX;
     * buttons: "42"
     * Expected Output:
     * ["ga",
     *  "gb",
     *  "gc",
     *  "ha",
     *  "hb",
     *  "hc",
     *  "ia",
     *  "ib",
     *  "ic"]
     *  Input:
     * buttons: "22"
     * Expected Output:
     * ["aa",
     *  "ab",
     *  "ac",
     *  "ba",
     *  "bb",
     *  "bc",
     *  "ca",
     *  "cb",
     *  "cc"]*/
    static String[] pressingButtons(String buttons) {
        int n = buttons.length();
        if(n == 0)
            return new String[0];
        String[] buttonToString = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(n == 1)
            return buttonToString[(buttons.charAt(0) - '0') -2].split("");
        String[] get  =  pressingButtons(buttons.substring(1));
        String[] a =  buttonToString[(buttons.charAt(0) - '0') -2].split("");
        String[] set = new String[get.length * a.length];
        int k =0;
        for(int i =0; i<  a.length; i++){
            for(int j =0 ;j< get.length; j++){
                set[k++] = a[i]+get[j];
            }
        }

        return set;

    }

}

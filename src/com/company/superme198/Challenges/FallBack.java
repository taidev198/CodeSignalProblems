package com.company.superme198.Challenges;

public class FallBack {

    /**Link:https://app.codesignal.com/challenge/QTiyM5zk2mHmC8aox*/
    static String fallBack(String time) {
        String[] sp = time.split("\\:");
        int c = Integer.valueOf(sp[0]);
        if(c == 1){
            sp[0] = "12";
        }else if(c ==12){
            sp[0] = "11";
            if(sp[1].charAt(2) == 'P')
                sp[1] = sp[1].replace('P', 'A');
            else sp[1] = sp[1].replace('A', 'P');
        }

        else sp[0] = String.valueOf(c-1);

        return sp[0] +":"+ sp[1];
    }


    public static void main(String...args){
        System.out.println(fallBack("00:00AM"));
    }
}

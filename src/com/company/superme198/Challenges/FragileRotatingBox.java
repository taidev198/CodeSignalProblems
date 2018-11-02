package com.company.superme198.Challenges;

public class FragileRotatingBox {

    /**Link:https://app.codesignal.com/challenge/s6yCyg62daz3xpCou*/
    static int fragileRotatingBox(String[] boxWeakness, String surfaceRoughness) {

        int t =0, i=0, len = surfaceRoughness.length(), r = boxWeakness.length, c = boxWeakness[0].length(), n = len /(r+c);
        for(;n >=0; n--){

            int k = r-1, l =0;

            while(l < c && i < len)
                t += (boxWeakness[k].charAt(l++) -'0') * (surfaceRoughness.charAt(i++) - '0');

            k = r-1; l = c-1;

            while(k >= 0 && i < len)
                t += (boxWeakness[k--].charAt(l) -'0') * (surfaceRoughness.charAt(i++) - '0');

            k = 0; l = c-1;

            while(l >= 0 && i < len)
                t += (boxWeakness[k].charAt(l--) - '0') * (surfaceRoughness.charAt(i++) - '0') ;

            k = 0; l = 0;

            while(k < r && i < len)
                t += (boxWeakness[k++].charAt(l) -'0')* (surfaceRoughness.charAt(i++) - '0');

        }
        return t;

    }


    public static void main(String...args){
        System.out.println(fragileRotatingBox(new String[]{"4",
                "0",
                "5",
                "8",
                "2"}, "58552851124351775074"));
    }
}

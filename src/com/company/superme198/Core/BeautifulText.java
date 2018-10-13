package com.company.superme198.Core;

public class BeautifulText {


    /**Link :https://app.codesignal.com/arcade/code-arcade/spring-of-integration/PSeEALZTxd93zBHS7/description
     * EX:
     *For inputString = "Look at this example of a correct text", l = 5, and r = 15, the output should be
     * beautifulText(inputString, l, r) = true.
     * We can replace 13th and 26th characters with '\n', and obtain the following multiline text of width 12:
     * Look at this
     * example of a
     * correct text
     * */
    static boolean beautifulText(String inputString, int l, int r) {
        int len = inputString.length();
        if(len < l) return false;
        String[] strArray = inputString.split(" ");//slpit string to array of words
        int temp = 0;
        for(int i=0; i< strArray.length-1; i++){
            temp += (strArray[i].length());//cal length of each word then add to temp
            if (temp > r)//if length of temp greater than r so then break
                break;
            if (i > 0)//if temp has length of more one word, add 1 whitespace to temp
                temp ++;
            int nextString = 0;
            int numberOfShite  =i;
            for (int j = i+1; j < strArray.length; j++) {
                nextString += strArray[j].length();//cal the same temp
                if (j - numberOfShite >1)
                    nextString ++;
                if (nextString > temp)//if nextString's length greater than temp so break
                    break;
                if (nextString == temp){
                    nextString = 0;
                    numberOfShite = j;
                }

            }
            nextString += (strArray.length - 1- numberOfShite );
            if (nextString == 0 && temp >= l && temp <= r)//check condition
                return true;
        }
        return false;
    }

    public static void main(String...args){
        System.out.println(beautifulText("Look at this example of a correct text", 5, 15));
    }

}

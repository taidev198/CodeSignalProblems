package com.company.superme198.Challenges;

public class StolenLunch {

   private static String stolenLunch(String note) {
        char[] tmp = note.toCharArray();
        for(int i=0; i< tmp.length;i++){
            if(tmp[i] <='9' && tmp[i] >='0')
                tmp[i] = (char)((tmp[i] -'0') + 'a');
            else if(tmp[i] <='j' && tmp[i] >='a')
                tmp[i] = (char)((tmp[i] -'a') + '0');
        }
        return new String(tmp);
    }

    public static void main(String...args){
        System.out.println(stolenLunch("you'll n4v4r 6u4ss 8t: cdja"));
    }

}

package com.company.superme198.Challenges;

public class WailingGhost {


    /**Link:https://app.codesignal.com/challenge/fBMqpka3pvk9jSHXp
     * They begin with a non-zero length of low-pitched os, then a non-zero length of high-pitched us,
     * and finally another length of low-pitched os that are of the same length as the initial sequence of os.
     For example:
     "ouo" = ghost
     "oouuuuuoo" = ghost
     "ouuooo" = ghost at first, then wind
     "uo" = wind
     Given an uninterrupted sequence of sounds, your task is to determine whether it can be divided into non-overlapping,
     contiguous subsequences that all follow the pattern of ghosts' wails. If so, return true; otherwise, return false.
     Example
     For sounds = "oouuuoo", the output should be wailingGhosts(sounds) = true.*/
    static boolean wailingGhosts(String sounds) {
        int len = sounds.length();
        char[] arr = sounds.toCharArray();
        if(len == 0 || arr[0] != 'o')
            return false;
        int i=0, cnt =0;
        while(i< len){
            if(arr[i] == 'u')
                return false;
            while(i <len && arr[i] == 'o'){
                i++;
                cnt++;
            }
            while(i < len && arr[i] == 'u')
                i++;

            while(i < len && arr[i] =='o'){
                cnt--;
                i++;
                if(cnt == 0)
                    break;
            }
            if(cnt>0)
                return false;
        }
        return true;

    }

}

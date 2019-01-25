package com.company.superme198.Challenges;

public class NaturalNumbersListing {

    /**Link:https://app.codesignal.com/challenge/Jx99MkhcPGQmHabLg*/
    static int naturalNumbersListing(int n) {
        int ans =0, bottom = 1, length =1;
        boolean zig = false;
        while(bottom <= n){
            ans += bottom;
            length++;
            if (zig) {
                bottom += 2 * (length - 1);
            } else {
                bottom++;
            }
            zig = !zig;
        }
        return ans;
    }

}

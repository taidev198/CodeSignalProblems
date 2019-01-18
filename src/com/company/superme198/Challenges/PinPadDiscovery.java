package com.company.superme198.Challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PinPadDiscovery {
    /**Link:https://app.codesignal.com/challenge/qBciCnWsCqNKTeLRP*/
    static String pinPadDiscovery(String[][] logins) {
        StringBuilder ans = new StringBuilder();
        for(int c =0;c < 4; c++){
            Set<String> s = new HashSet<>();
            Map<Character, Integer> m = new HashMap<>();
            for (String[] l : logins) {
                s.add(l[c]);
                for(char le: l[c].toCharArray()){
                    if (!m.containsKey(le))
                        m.put(le, 1);
                    else {
                        int v = m.get(le);
                        if (v == logins.length -2)
                            ans.append(le-'0');
                        m.replace(le, v, v+1);
                    }
                }
            }
            if(s.size() == 1)
                ans.append("?");
        }

        return ans.toString();
    }
}

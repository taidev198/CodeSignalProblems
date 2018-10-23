package com.company.superme198.CompanyChallenges.Dropbox;

import java.util.*;

public class CampusCup {

    static String[] campusCup(String[] emails) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < emails.length; i++) {
            emails[i] = emails[i].substring(emails[i].indexOf("@")+1);
            if (!hashtable.containsKey(emails[i]))
                hashtable.put(emails[i], 1);
            else {
                int tmp = hashtable.get(emails[i]);
                hashtable.replace(emails[i], tmp, tmp +1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashtable.entrySet());
        int n = emails.length;
        int k = 0;
        String[] result = new String[n];

        for (int i = entryList.size() -1; i >=0 ; i--) {
            result[k++] = entryList.get(i).getKey();
        }
        return Arrays.copyOfRange(result, 0, k);

    }

    static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        //  list.sort(Map.Entry.comparingByValue());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                if (((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue()) ==0 )
                    return ((Comparable) ((Map.Entry) (o1)).getKey())
                            .compareTo(((Map.Entry) (o2)).getKey());
                return  ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            System.out.println(entry.getKey());
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public static void main(String...args){
        System.out.println(Arrays.toString(campusCup(new String[]{"a@rain.ifmo.ru",
                "b@rain.ifmo.ru",
                "c@rain.ifmo.ru",
                "d@rain.ifmo.ru",
                "e@rain.ifmo.ru",
                "noname@mit.edu"})));

    }
}

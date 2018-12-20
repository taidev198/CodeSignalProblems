package com.company.superme198.Challenges;

import java.util.Arrays;

/**
 * Created by traig on 6:54 PM, 12/15/2018
 */
public class BankRequests {

    static int[] bankRequests(int[] accounts, String[] requests) {
        int len = accounts.length;
        for (int i =0; i< requests.length; i++) {
            String[] request = requests[i].split(" ");
            int a = Integer.valueOf(request[1]);
            if (request[0].equals("transfer")) {
                int b = Integer.valueOf(request[2]);
                int money = Integer.valueOf(request[3]);
                if (a < 0 || b > len ||  b < 0 || money > accounts[a - 1]) return new int[]{-(i+1)};
                accounts[a - 1] -= money;
                accounts[b - 1] += money;
            } else if (request[0].equals("deposit")) {
                int money = Integer.valueOf(request[2]);
                if (a < 0 || a > len  ) return new int[]{-(i+1)};
                accounts[a - 1] += money;
            } else {
                int money = Integer.valueOf(request[2]);
                if (a < 0 || money > accounts[a - 1] || a > len) return new int[]{-(i+1)};
                accounts[a - 1] -= money;
            }
        }
        return accounts;
    }

    public static void main(String...args){
       // (2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))
        System.out.println(Arrays.toString(bankRequests(new int[]{10, 100, 20, 50, 30}, new String[]{"withdraw 2 10", "transfer 5 1 20",
                "deposit 5 20", "transfer 3 4 15"})));
    }

}

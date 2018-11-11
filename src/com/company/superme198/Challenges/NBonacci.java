package com.company.superme198.Challenges;

public class NBonacci {

    /**Link:https://app.codesignal.com/challenge/2ZSQqGx9H686fZ7if
     * reference":http://oeis.org/wiki/N-bonacci_numbers
     * For sequence = [1, 2, 3], the output should be nbonacciDegree(sequence) = 2.
     *
     * It's not a very long sequence, but since 1 + 2 = 3, it qualifies as a 2-bonacci sequence, so the answer is 2.
     *
     * For sequence = [0, 6, -2, 3, 7, 14, 22, 46, 89, 171, 328, 634, 1222, 2355], the output should be nbonacciDegree(sequence) = 4.
     *
     * After the first four terms, each term of the sequence is the sum of the previous 4 terms, so the answer is 4.
     *
     * For sequence = [1, 2, 5], the output should be nbonacciDegree(sequence) = -1.
     *
     * This sequence does not qualify as n-bonacci, since none of the terms are sums of any number of previous terms.*/
    static int nbonacciDegree(int[] sequence) {
        int len = sequence.length;
        int ans =0, s =0, i;
        for(i = 0;i< len ;i++){
            if(s == sequence[i]){
                int  k = i;
                boolean ok = true;
                while(k < len-1){
                    int tmp = 0;
                    for (int j = k-ans+1; j <= ans + k -i ; j++) {
                        tmp += sequence[j ];
                    }
                    ok = tmp == sequence[k + 1];
                    k++;
                }
                if(ok) return ans;
            }
            s+= sequence[i];
            ans++;

        }
        return  -1;
    }

    public static void main(String...args){


        System.out.println(nbonacciDegree(new int[]{1,2,5}));
    }
}

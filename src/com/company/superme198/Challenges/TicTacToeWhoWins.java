package com.company.superme198.Challenges;

/**
 * Created by traig on 3:04 PM, 11/16/2018
 */
public class TicTacToeWhoWins {

    /**Link:https://app.codesignal.com/challenge/sqoxMxgWEannMAZgz
     * You both kept playing moves without knowing if the game was over, so all tiles have been filled with an "X" or an "O".
     * This could have possibly led to board states with multiple winners, like this:
     *
     * ["XOX",
     *  "XOX",
     *  "XOO"]
     * So in order to keep some evidence of who the first winner was, you recorded the order of the moves that were played,
     * rather than the final board state.
     *
     * Given the list of moves as a 3 x 3 grid of digits from 0 to 8, your task is to find the first winner (return "X", "O", or "draw").*/
    static String ticTacToeWhoWins(String[] game) {

            int r = game.length, c = game[0].length();
            int s, maxX= 0, maxO=0, maxXX=0, maxOO=0;

            boolean xWin = false;
            boolean oWin = false;
            for(int i=0; i< r; i++){
                s= 0;
                if((game[i].charAt(0) -'0') % 2 ==1){
                    s++;

                    maxO = Math.max(maxO, game[i].charAt(0) -'0');
                }else{
                    s--;
                    maxX = Math.max(maxX, game[i].charAt(0) -'0');
                }
                if((game[i].charAt(1) -'0') % 2 ==1 ){
                    s++;
                    maxO = Math.max(maxO, game[i].charAt(1) -'0');
                }

                else {
                    maxX = Math.max(maxX, game[i].charAt(1) -'0');
                    s--;
                }
                if((game[i].charAt(2) -'0') % 2 ==1 ){
                    maxO = Math.max(maxO, game[i].charAt(2) -'0');
                    s++;
                }

                else{
                    maxX = Math.max(maxX, game[i].charAt(2) -'0');
                    s--;
                }
                if(s == 3 ){
                    oWin = true;
                    maxOO = maxO;
                }

                if(s == -3 ){
                    maxXX = maxX;
                    xWin = true;
                }

            }

            for(int i=0; i< r; i++){
                s= 0;
                if((game[0].charAt(i) -'0') % 2 ==1){
                    s++;

                    maxO = Math.max(maxO, game[0].charAt(i) -'0');
                }else {
                    s--;
                    maxX = Math.max(maxX, game[0].charAt(i) -'0');
                }
                if((game[1].charAt(i) -'0') % 2 ==1 ){
                    maxO = Math.max(maxO, game[1].charAt(i) -'0');
                    s++;
                }

                else{
                    maxX = Math.max(maxX, game[1].charAt(0) -'0');
                    s--;
                }
                if((game[2].charAt(i) -'0') % 2 ==1 ){
                    maxO = Math.max(maxO, game[2].charAt(0) -'0');
                    s++;
                }

                else {
                    maxX = Math.max(maxX, game[2].charAt(0) -'0');
                    s--;
                }
                if(s == 3 ){
                    oWin = true;
                    maxOO = maxO;
                }

                if(s == -3 ){
                    maxXX = maxX;
                    xWin = true;
                }
            }

            s= 0;
            if((game[0].charAt(0) -'0') % 2 ==1){
                s++;

                maxO = Math.max(maxO, game[0].charAt(0) -'0');
            }else{
                maxX = Math.max(maxX, game[0].charAt(0) -'0');
                s--;
            }
            if((game[1].charAt(1) -'0') % 2 ==1 ){
                maxO = Math.max(maxO, game[1].charAt(1) -'0');
                s++;
            }

            else {
                maxX = Math.max(maxX, game[1].charAt(1) -'0');
                s--;
            }
            if((game[2].charAt(2) -'0') % 2 ==1 ){
                maxO = Math.max(maxO, game[2].charAt(2) -'0');
                s++;
            }

            else {
                maxX = Math.max(maxX, game[2].charAt(2) -'0');
                s--;
            }
            if(s == 3 ){
                oWin = true;
                maxOO = maxO;
            }

            if(s == -3 ){
                maxXX = maxX;
                xWin = true;
            }



            s= 0;
            if((game[0].charAt(2) -'0') % 2 ==1){
                s++;

                maxO = Math.max(maxO, game[0].charAt(2) -'0');
            }else {
                maxX = Math.max(maxX, game[0].charAt(2) -'0');
                s--;
            }
            if((game[1].charAt(1) -'0') % 2 ==1 ){
                maxO = Math.max(maxO, game[1].charAt(1) -'0');
                s++;
            }

            else {
                maxX = Math.max(maxX, game[1].charAt(1) -'0');
                s--;
            }

            if((game[2].charAt(0) -'0') % 2 ==1 ){
                maxO = Math.max(maxO, game[2].charAt(0) -'0');
                s++;
            }

            else {
                maxX = Math.max(maxX, game[2].charAt(0) -'0');
                s--;
            }
            if(s == 3 ){
                oWin = true;
                maxOO = maxO;
            }

            if(s == -3 ){
                maxXX = maxX;
                xWin = true;
            }

            if(xWin && oWin){
                if(maxXX < maxOO)
                    return "X";
                return "O";
            }
            if(xWin)
                return "X";
            if(oWin)
                return "O";

            return "draw";
    }


    public static void main(String...args){
        System.out.println(ticTacToeWhoWins(new String[]{"645","732", "081"}));
    }
}

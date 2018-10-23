package com.company.superme198.Challenges;
public class IsConnectableListOfNum {


    /**
     *
     *Link:https://app.codesignal.com/challenge/883TZQd7mNbt97GXt
     * the phone numbers is a prefix of another one of the numbers, then it'll start dialing the shorter number before the full number can be entered.
     *  For example, if you're trying to call 416321 but 416 is also among the numbers, then it'll start dialing 416 before you can finish typing in 416321.
     *Jan wants to make sure that everyone can be reached, so she needs for you to check if there are any numbers on the list that are prefixes of any other number on the list.
     *Given an array of phone numbers (in the form of strings), return true if the list is error-free (contains no prefixes) and false otherwise.
     *It is guaranteed that the list does not contain any duplicate numbers.
     *Example
     *For listOfNum = ["911", "97625999", "91125426"], the output should be isConnectableListOfNum(listOfNum) = false.
     *Since 911 is a prefix of 91125426 the list of numbers is not error-free.*/
    static boolean isConnectableListOfNum(String[] listOfNum) {
        TriesNode root = new TriesNode();
        for(int i =0; i< listOfNum.length; i++){

            insert(listOfNum[i], root);
        }

        for(int i =0; i< listOfNum.length; i++){
            if(!search(listOfNum[i], root))
                return false;

        }
        return true;
    }
   static class TriesNode{
        TriesNode[] children = new TriesNode[11];
        {for(int i =0;i<=10;i++)
            children[i] = null;}
        boolean isEndOfWord;
    }

  static   void insert(String key, TriesNode root){
        int level ;
        int len = key.length();
        TriesNode pCawl = root;
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - '0';
            if (pCawl.children[index] == null)
                pCawl.children[index] = new TriesNode();
            pCawl = pCawl.children[index];
        }
        pCawl.isEndOfWord = true;
    }

   static boolean search(String key, TriesNode root){

        int len = key.length();
        TriesNode pCawl = root;
        for (int i = 0; i <len ; i++) {
            int index = key.charAt(i) - '0';
            if (pCawl.children[index] == null)
                return true;
            pCawl = pCawl.children[index];
        }

        for(int i =0;i<=10; i++){
            if(pCawl.children[i] != null)
                return false;
        }
        return  true || !pCawl.isEndOfWord;
    }

    public static void main(String...args){
        System.out.println(isConnectableListOfNum(new String[]{"113",
                "12340",
                "123440",
                "12345",
                "98346"}));


    }
}


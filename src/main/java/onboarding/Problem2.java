package onboarding;

import java.util.Stack;

public class Problem2 {

    public void removeStackDuplication(Stack<Character> stk, int dupCount){

    }

    public int countDuplication(Stack<Character> stk, int dupCount, char c) {
        return dupCount;
    }

    public boolean compareTwoGrams(String cryptogram, String decryptgram){
        return true;
    }

    public String decrypt(String cryptogram){
        return "";
    }

    public static String solution(String cryptogram) {
        Problem2 T = new Problem2();
        String decryptgram = "";
        boolean whileFlag = true;
        while(whileFlag){
            decryptgram = T.decrypt(cryptogram);
            whileFlag = T.compareTwoGrams(cryptogram, decryptgram);
            cryptogram = decryptgram;
        }
        return decryptgram;
    }
}

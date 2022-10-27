package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() == 1) {
            return cryptogram;
        }
        String answer = "answer";
        return answer;
    }
}


class Decryptor{
    private static String checkNeighbors(char prevChar,char presentChar, char nextChar){
        if (prevChar != presentChar && presentChar != nextChar) {
            return presentChar + "";
        }
        return "";
    }

    private static String checkNeighbors(char thisChar,char compareChar){
        if (thisChar != compareChar) {
            return thisChar + "";
        }
        return "";
    }

}

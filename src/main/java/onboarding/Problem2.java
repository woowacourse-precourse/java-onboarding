package onboarding;

import java.util.PriorityQueue;

public class Problem2 {
    static class Password {
        String cryptogram;



        private boolean isValidLength(int cryptogramLength) {
            return cryptogramLength>0 &&cryptogramLength<=1000;
        }
        private boolean isSmallLetter(char c){
            return c >= 97 && c <= 122;
        }


    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

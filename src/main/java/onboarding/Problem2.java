package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        ArrayList<Character> password = new ArrayList<>();
        
        for(int i=0; i<cryptogram.length(); i++) {
        	password.add(cryptogram.charAt(i));
        }
        return answer;
    }
}

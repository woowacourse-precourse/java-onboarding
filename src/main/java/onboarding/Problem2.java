package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        LinkedList<String> password = new LinkedList<String>();

        for(int i = 0; i < cryptogram.length(); i++){
            String cryptogram_i = cryptogram.substring(i, i+1);
            password.add(cryptogram_i);
        }

        return answer;
    }
}

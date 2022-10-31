package onboarding;

import java.util.Objects;

public class Problem2 {
    static String crypto(String a) {
        int StrLen = a.length();
        for(int i=0; i<StrLen-1; i++) {
            char firstCheck = a.charAt(i);
            char secondCheck = a.charAt(i+1);
            if(firstCheck == secondCheck) {
                a = a.substring(0, i) + a.substring(i + 2);
                break;
            }
        }
        return a;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(!Objects.equals(crypto(cryptogram), answer)){
            cryptogram = crypto(cryptogram);
            answer = cryptogram;
        }
        return answer;
    }
}

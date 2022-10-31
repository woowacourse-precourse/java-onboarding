package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        int count = 1;
        String answer = cryptogram;
        while(count != answer.length()) {
            count = 1;
            for (int i = 0; i <answer.length() -1; i++) {
                if (answer.charAt(i) == answer.charAt(i+1)) {
                    if (i ==0){
                        answer = answer.substring(2);
                    }else {
                        answer = answer.substring(0,i) + answer.substring(i+2);
                    }
                    count += 1;
                    break;
                } else {
                    count += 1;
                }
            }
        }

        return answer;
    }
}

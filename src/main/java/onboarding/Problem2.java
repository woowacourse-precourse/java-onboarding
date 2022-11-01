package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    // 중복 문자가 존재하는지 체크하는 기능
    public static boolean isDuplicate(String cryptogram) {
        for (int i = 0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return true;
        }
        return false;
    }
}
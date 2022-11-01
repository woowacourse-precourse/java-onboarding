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

    // 몇 번째 인덱스까지 연속된 문자가 나오는지 확인하는 기능
    public static int getCutIndex(String str) {
        int cutIndex = 0;

        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i+1) && str.charAt(0) == str.charAt(i)) {
                cutIndex = i+1;
            }
        }
        return cutIndex;
    }
}
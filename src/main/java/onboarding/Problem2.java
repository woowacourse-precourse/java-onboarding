package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 0. cryptogram 내의 모든 문자에 대해서 검사한다.
* 1. 연속된 두 문자가 같은지 확인한다.
* 1-1. 같다면, 다음 번 문자 검사를 건너 뛰고, hasChanged = true로 만든다.
* 1-2. 다르다면, 해당 문자를 tmpAnswer.append()한다.
* 2. 검사가 끝난 뒤, answer의 값을 tmpAnswer로 덮어씌운다.
* 3. hasChanged가 true인지 확인한다.
* 3-1. 그렇다면, 0부터 다시 반복한다
* 3-2. 그렇지 않다면, answer을 반환한다.
* */

public class Problem2 {

    static boolean hasChanged = true;

    public static String solution(String cryptogram) {
        hasChanged = true;
        String answer = cryptogram;
        while (hasChanged) {
            hasChanged = false;
            answer = removeReduplicatedString(answer);
        }
        
        return answer;
    }

    private static String removeReduplicatedString(String str) {
        int len = str.length();
        int cnt = 0;

        StringBuilder tmpAnswer = new StringBuilder();

        while (cnt < len-1) {
            if (str.charAt(cnt) == str.charAt(cnt + 1)) {
                cnt += 2;
                hasChanged = true;
                continue;
            }
            tmpAnswer.append(str.charAt(cnt++));
        }

        if (cnt == len-1) tmpAnswer.append(str.charAt(cnt));

        return tmpAnswer.toString();
    }
}

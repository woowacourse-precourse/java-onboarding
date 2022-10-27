package onboarding;

import java.util.List;

/*
*   구현 기능
*   1. 중복 패턴 검사 기능
*   2. 중복 패턴 제거 기능
*/
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

interface Detector {
    List<Integer> location(String cryptogram);
}

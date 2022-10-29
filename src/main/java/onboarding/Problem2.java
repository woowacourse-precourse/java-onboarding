package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    static List<Character> list = new ArrayList<>();

    /**
     * 문자열을 Character형 List로 변환하는 메서드
     *
     * @param cryptogram 입력받는 문자열
     * @return List로 바꾼 문자열
     */
    static List<Character> transStringToList(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            list.add(cryptogram.charAt(i));
        }

        return list;
    }


    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

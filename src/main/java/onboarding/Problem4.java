package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    /**
     * 문자열을 Character형 List로 변환하는 메서드
     *
     * @param word List로 변경할 문자열
     * @return List로 변환한 문자열
     */
    static List<Character> transStringToList(String word) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        return list;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

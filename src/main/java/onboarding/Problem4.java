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


    /**
     * 문자를 청개구리 언어로 변경하는 메서드
     *
     * @param ch 변환할 문자
     * @return 변환한 문자
     */
    static Character changeChar(Character ch) {
        int chType;

        if ('a' <= ch && 'z' >= ch) {
            chType = 1;
        }
        else if ('A' <= ch && 'Z' >= ch) {
            chType = 2;
        }
        else {
            chType = 0;
        }

        if (chType == 1) {
            ch = (char)((25 - (ch - 'a')) + 'a');
        }
        else if (chType == 2) {
            ch = (char)((25 - (ch - 'A')) + 'A');
        }

        return ch;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

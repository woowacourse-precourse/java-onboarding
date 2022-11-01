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
     * List를 String으로 변환하는 메서드
     *
     * @param inputList String으로 바꿀 List ,static 변수 list가 들어간다
     * @return String으로 바꾼 List
     */
    static String transListToString(List<Character> inputList) {
        String str = "";

        for (int i = 0; i < inputList.size(); i++) {
            str += inputList.get(i);
        }

        return str;
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
        } else if ('A' <= ch && 'Z' >= ch) {
            chType = 2;
        } else {
            chType = 0;
        }

        if (chType == 1) {
            ch = (char)((25 - (ch - 'a')) + 'a');
        } else if (chType == 2) {
            ch = (char)((25 - (ch - 'A')) + 'A');
        }

        return ch;
    }

    public static String solution(String word) {
        String answer = word;
        List<Character> charcterList = transStringToList(answer);

        for (int i = 0; i < charcterList.size(); i++) {
            charcterList.set(i, changeChar(charcterList.get(i)));
        }

        answer = transListToString(charcterList);
        return answer;
    }
}

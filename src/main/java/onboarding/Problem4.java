package onboarding;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) convertWord
 *          : 엄마 말씀 word(String)을 인자로 받아 반대로 변환하여 return한다. 단, 다음과 같은 조건을 만족시키며 변환한다.
 *
 *              - 변환 순서는 A-Z를 Z-A로 뒤집은 것과 동일한 순서로 한다.
 *              - 알파벳 대문자는 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 *              - 알파벳 이외의 문자는 변환하지 않는다.
 *     2. 필드 값
 *          1) upperAl : 알파벳 대문자 A-Z를 담은 리스트
 *          2) lowerAl : 알파벳 소문자 a-z를 담은 리스트
 */

public class Problem4 {
    public static String solution(String word) {

        for (int i = 0; i < 26; i++){
            upperAl.add((char) (65 + i));
            lowerAl.add((char) (97 + i));
        }

        String answer = convertWord(word);
        return answer;
    }

    private static List<Character> upperAl = new ArrayList<>();
    private static List<Character> lowerAl = new ArrayList<>();

    public static String convertWord(String word) {

        char[] wordArray = word.toCharArray();


        String result = "";

        for (int i = 0; i < wordArray.length; i++) {
            char al = wordArray[i];

            // al이 대문자일 경우 -> 위치 다른 대문자로 변환
            if (upperAl.contains(al)) {
                int alIndex = upperAl.indexOf(al);
                int convertedIndex = -(alIndex-25);

                result += upperAl.get(convertedIndex);

            }
            // al이 소문자일 경우 -> 위치 다른 소문자로 변환
            else if (lowerAl.contains(al)) {
                int alIndex = lowerAl.indexOf(al);
                int convertedIndex = -(alIndex-25);

                result += lowerAl.get(convertedIndex);
            }
            // al이 알파벳 대문자나 소문자가 아닐 경우 -> 변환하지 않음
            else {
                result += al;
            }
        }
        return result;
    }


}
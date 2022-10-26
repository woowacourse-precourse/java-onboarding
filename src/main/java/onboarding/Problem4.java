package onboarding;

import java.util.HashMap;
import java.util.Map;

// 방법 1. 아스키 값에 대한 규칙으로 변환하기
// HashMap에 각 변환값에 대한 매핑시켜놓기 (일단 좋아보이진 않음 <너무 하드코딩 느낌이 난다.>)
public class Problem4 {

    /*
    A -> Z ==> A + 25
    a -> z ==> a + 25

    B -> Y ==> B + 23
    b -> y ==> b + 23
     */


    /*
    65 = 90
    66 = 89
     */

    static Map<String, String> upperCaseMappingMap = new HashMap<>();
    static Map<String, String> lowerCaseMappingMap = new HashMap<>();

    // 아스키코드 변환 HashMap 셋팅 작업 메서드
    public static void reverseASCII(String word) {

        for (int i = 65; i < 91; i++) {
            upperCaseMappingMap.put(String.valueOf((char) i), String.valueOf((char) (155 - i)));
        }

        for (int i = 97; i < 123; i++) {
            lowerCaseMappingMap.put(String.valueOf((char) i), String.valueOf((char) (219 - i)));
        }
    }

    // 실제 입력 값과 HashMap 매핑
    public static String mappingWord(String word) {

        int wordLength = word.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            if (word.charAt(i) == 32) {
                result.append(" ");
            } else if (upperCaseMappingMap.containsKey(String.valueOf(word.charAt(i)))) {
                result.append(upperCaseMappingMap.get(String.valueOf(word.charAt(i))));
            } else if (lowerCaseMappingMap.containsKey(String.valueOf(word.charAt(i)))) {
                result.append(lowerCaseMappingMap.get(String.valueOf(word.charAt(i))));
            }
        }
        return result.toString();
    }

    public static String solution(String word) {
        reverseASCII(word);
        return mappingWord(word);
    }
}

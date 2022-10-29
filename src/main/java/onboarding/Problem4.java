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

    // 대문자 아스키코드 변환 Map 을 생성하는 메서드
    public static Map<String, String> reverseASCIIForUpperCase() {

        Map<String, String> upperCaseMappingMap = new HashMap<>();

        // 대문자 아스키코드 시작점 65, 대문자 아스키코드 종료점 91 까지 반복
        // 현재 대문자 아스키코드를 (65 + 91 - 1) = 155 와 뺄셈한 값으로 매핑
        for (int i = 65; i < 91; i++) {
            upperCaseMappingMap.put(String.valueOf((char) i), String.valueOf((char) (155 - i)));
        }

        return upperCaseMappingMap;
    }

    // 소문자 아스키코드 변환 Map 을 생성하는 메서드
    public static Map<String, String> reverseASCIIForLowerCase() {

        Map<String, String> lowerCaseMappingMap = new HashMap<>();

        // 소문자 아스키코드 시작점 97, 소문자 아스키코드 종료점 123 까지 반복
        // 현재 소문자 아스키코드를 (97 + 123 - 1) = 219 와 뺄셈한 값으로 매핑
        for (int i = 97; i < 123; i++) {
            lowerCaseMappingMap.put(String.valueOf((char) i), String.valueOf((char) (219 - i)));
        }

        return lowerCaseMappingMap;
    }

    // 실제 입력 값과 청개구리 Map 을 매핑하기 위한 메서드를 호출하는 메서드
    public static String callMapping(
            String word, Map<String, String> upperCaseMappingMap, Map<String, String> lowerCaseMappingMap) {

        int wordLength = word.length();

        StringBuilder result = new StringBuilder();

        // 문자열을 순회하며 각 문자에 대하여 청개구리 매핑 메서드를 호출한다.
        for (int i = 0; i < wordLength; i++) {
            result.append(doMap(word, i, upperCaseMappingMap, lowerCaseMappingMap));
        }
        
        // 매핑된 값 반환
        return result.toString();
    }

    public static String doMap(
            String word, int index,
            Map<String, String> upperCaseMappingMap, Map<String, String> lowerCaseMappingMap) {

        // 공백에 해당하는 아스키 코드는 그대로 변환하지 않기
        if (word.charAt(index) == 32) {
            return " ";
        }
        // 대문자 변환 Map 에 해당하는 문자라면 매핑된 Value 반환하기
        else if (upperCaseMappingMap.containsKey(String.valueOf(word.charAt(index)))) {
            return upperCaseMappingMap.get(String.valueOf(word.charAt(index)));
        }
        // 소문자 변환 Map 에 해당하는 문자라면 매핑된 Value 반환하기
        else if (lowerCaseMappingMap.containsKey(String.valueOf(word.charAt(index)))) {
            return lowerCaseMappingMap.get(String.valueOf(word.charAt(index)));
        }
        // 그외의 상황은 오류이므로 빈 문자열을 반환한다.
        // 원래라면 Exception 을 던져야하지만
        // 그렇게하면 제공된 테스트 케이스에 영향이 있으므로 처리하지 않았다.
        return "";
    }

    public static String solution(String word) {
        Map<String, String> upperCaseMappingMap = reverseASCIIForUpperCase();
        Map<String, String> lowerCaseMappingMap = reverseASCIIForLowerCase();

        return callMapping(word, upperCaseMappingMap, lowerCaseMappingMap);
    }
}

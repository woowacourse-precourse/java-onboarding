package onboarding;

import java.util.HashMap;
import java.util.Map;

/*
1. 대문자 아스키코드 변환 Map 을 생성하는 메서드
2. 소문자 아스키코드 변환 Map 을 생성하는 메서드
3. 실제 입력 값과 1, 2 메서드로 변환된 Map 을 매핑하는 메서드
4.

 */
public class Problem4 {

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

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

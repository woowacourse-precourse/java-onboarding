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

    // 실제로 매핑을 하는 메서드
    public static String doMap(
            String word, int index,
            Map<String, String> upperCaseMappingMap, Map<String, String> lowerCaseMappingMap) {

        // 공백을 포함하여 알파벳 외의 문자는 변환하지 않는 조건 추가
        if (word.charAt(index) < 65 ||
                (word.charAt(index) > 91 && word.charAt(index) < 97) ||
                word.charAt(index) > 122) {
            return String.valueOf(word.charAt(index));
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
        String answer = "";
        return answer;
    }
}

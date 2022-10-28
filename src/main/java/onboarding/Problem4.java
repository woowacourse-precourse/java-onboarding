package onboarding;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {

    public static final int UPPER_MAX_VALUE = 'A' + 'Z';
    public static final int LOWER_MAX_VALUE = 'a' + 'z';
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            answer.append(convertFrogDictionary(word.charAt(i)));
        }

        return answer.toString();
    }

    private static char convertFrogDictionary(char value) {
        int result = value;

        // 대문자 확인 현재 문자 c + 바뀔 문자 idx = 155 이다.
        if (isUpperCase(value)) {
            result = UPPER_MAX_VALUE - value;
        }
        // 소문자 확인 현재 문자 c + 바뀔 문자 idx = 219 이다.
        if (isLowerCase(value)) {
            result = LOWER_MAX_VALUE - value;
        }

        return (char) result;
    }

}

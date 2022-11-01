/*
[기능 목록]
1. 알파벳 여부 체크
    - 대문자 체크 함수
    - 소문자 체크 함수

2. 문자 변환
    - 대문자 변환
    - 소문자 변환

3. 주어진 단어 변환
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordCharArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : wordCharArray) {
            if (isAlphabet(c)) {
                c = reverseAlphabet(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static char reverseAlphabet (char c) {
        if (isUpperCase(c)) { // 대문자 변환
            return (char)('A' + 'Z' - c);
        }
        // 소문자 변환
        return (char)('a' + 'z' - c);
    }

    public static boolean isAlphabet (char c) {
        return isUpperCase(c) || isLowerCase(c);
    }

    public static boolean isUpperCase (char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isLowerCase (char c) {
        return c >= 'a' && c <= 'z';
    }
}

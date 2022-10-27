/*
[기능 목록]
1. 알파벳 여부 체크
    - 대문자 체크 함수
    - 소문자 체크 함수

2. 문자 변환
    - 대문자 변환
    - 소문자 변환

3. 문장 변환
 */

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char reverseAlphabet (char c) {
        if (isUpperCase(c)) {
            return (char)('A' + 'Z' - c);
        }
        // 소문자일 경우
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

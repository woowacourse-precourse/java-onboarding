package onboarding;

/**
 * 기능 목록
 * 1. 알파벳만 반대로 변환
 */

public class Problem4 {
    public static String solution(String word) {
        return toOpposite(word.toCharArray());
    }

    private static String toOpposite(char[] chars) {
        String answer = "";

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                answer += (char)('Z' - (ch - 'A'));
            } else if (Character.isLowerCase(ch)) {
                answer += (char)('z' - (ch - 'a'));
            } else {
                answer += ch;
            }
        }

        return answer;
    }
}

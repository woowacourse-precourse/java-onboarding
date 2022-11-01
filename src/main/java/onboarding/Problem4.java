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
        StringBuilder answer = new StringBuilder();

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                answer.append((char) ('Z' - (ch - 'A')));
            } else if (Character.isLowerCase(ch)) {
                answer.append((char) ('z' - (ch - 'a')));
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}

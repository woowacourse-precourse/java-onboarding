package onboarding;

/** 기능 목록
 * solutionLogic        : 메인 솔루션
 * classifyChar         : 대문자, 소문자, 일반문자 판별
 * transformChar        : 입력된 문자 변환
 * checkValid           : 제한사항 검증
 */

public class Problem4 {

    private static final int LOWER_STANDARD = 'z' + 'a';
    private static final int UPPER_STANDARD = 'Z' + 'A';

    public static String solution(String word) {
        if (!checkValid(word)) {
            throw new IllegalArgumentException("제한사항 위반");
        }
        return solutionLogic(word);
    }

    private static String solutionLogic(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(classifyChar(s.charAt(i)));
        }
        return sb.toString();
    }

    private static char classifyChar(char c) {
        if ('a' <= c && c <= 'z') {
            return transformChar(c, LOWER_STANDARD);
        }
        if ('A' <= c && c <= 'Z') {
            return transformChar(c, UPPER_STANDARD);
        }
        return c;
    }

    private static char transformChar(char c, int standard) {
        return (char) (standard - c);
    }

    private static boolean checkValid(String s) {
        int n = s.length();
        return 1 <= n && n < 1000;
    }
}

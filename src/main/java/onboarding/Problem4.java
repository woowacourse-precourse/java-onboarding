package onboarding;

/** 기능 목록
 * solutionLogic    : 메인 솔루션
 * lowerChange      : 소문자 변환
 * upperChange      : 대문자 변
 * checkValid       : 예외 처리
 * checkWordLength  : 단어 길이 체크
 */

public class Problem4 {
    public static String solution(String word) {
        final String errorCase = "-1";
        String answer = "";
        if (!checkValid(word)) {
            return errorCase;
        }
        answer = solutionLogic(word);
        return answer;
    }

    public static String solutionLogic(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(classifyChar(s.charAt(i)));
        }
        return sb.toString();
    }

    public static char classifyChar(char c) {
        if ('a' <= c && c <= 'z') {
            return lowerChange(c);
        } else if ('A' <= c && c <= 'Z') {
            return upperChange(c);
        } else {
            return c;
        }
    }

    public static char lowerChange(char c) {
        int temp = c - 'a';
        return (char)('z' - temp);
    }

    public static char upperChange(char c) {
        int temp = c - 'A';
        return (char) ('Z' - temp);
    }

    public static boolean checkValid(String s) {
        return checkWordLength(s);
    }

    public static boolean checkWordLength(String s) {
        int n = s.length();
        return 1 <= n && n < 1000;
    }
}

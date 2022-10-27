package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 문자 하나를 반대로 변환하는 함수
    static char convertChar(char c) {
        int ascii;

        if (Character.isUpperCase(c)) {
            ascii = 'Z' - (c - 'A');
        } else {
            ascii = 'z' - (c - 'a');
        }

        return (char)ascii;
    }

    // 알파벳인지 확인하는 함수
    static boolean isAlphabet(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}

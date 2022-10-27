package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return convertString(word);
    }

    // 문자열을 변환하는 함수
    static String convertString(String word) {
        String convertString = "";

        for (int i = 0; i < word.length(); i++) {
            if (isAlphabet(word.charAt(i))) {
                convertString += convertChar(word.charAt(i));
            } else {
                convertString += word.charAt(i);
            }
        }

        return convertString;
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

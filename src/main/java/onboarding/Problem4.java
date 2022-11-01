package onboarding;

/*
* 1. 제한사항 알파벳 외의 문자는 변환하지 않기 때문에 알파벳인지 판별하는 메소드 구현
* 2. 대문자인지 소문자인지 판별하는 메소드 구현
* 3-1. 대문자 -> 대문자, 소문자 -> 소문자 구현
* 3-2. 3-1 메소드 구현 위해 상수 선언
* 4. 최종 반환
* */
public class Problem4 {

    private static final int UPPER_CASE_A = 65;
    private static final int UPPER_CASE_Z = 90;
    private static final int LOWER_CASE_a = 97;
    private static final int LOWER_CASE_z = 122;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char isAlphabet(char alphabet) {
        if (Character.isAlphabetic(alphabet)) {
            return isUpperCaseLowerCase(alphabet);
        }
        return alphabet;
    }

    public static char isUpperCaseLowerCase(char alphabet) {
        if (Character.isUpperCase(alphabet)) {
            return changeUpperAlphabet(alphabet);
        }
        return changeLowerAlphabet(alphabet);
    }

    public static char changeUpperAlphabet(char alphabet) {
        return (char) (UPPER_CASE_Z - (alphabet - UPPER_CASE_A));
    }

    public static char changeLowerAlphabet(char alphabet) {
        return (char) (LOWER_CASE_z - (alphabet - LOWER_CASE_a));
    }
}

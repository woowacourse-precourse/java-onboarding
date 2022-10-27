package onboarding;

/**
 * 기능목록
 * 1. 소문자 알파벳을 반대로 바꿔주는 메서드
 * 2. 대문자 알파벳을 반대로 바꿔주는 메서드
 * 3. 전체 문자열에 대해 알파벳이라면 바꿔주고 문자가 아니면 바꾸지 않도록 구현
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    //기능1. 소문자 알파벳을 반대로 바꿔주는 메서드
    private static Character getLowerCaseCharacter(char c) {
        int dif = c - 'a';
        char changedAlphabet = (char) ('z' - dif);
        return changedAlphabet;
    }

    //기능2. 대문자 알파벳을 반대로 바꿔주는 메서드
    private static Character getUpperCaseCharacter(char c) {
        int dif = c - 'A';
        char changedAlphabet = (char) ('Z' - dif);
        return changedAlphabet;
    }
}

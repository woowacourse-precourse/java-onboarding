package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String toString(char character) {
        if('a' <= character && character <= 'z') {
            return String.valueOf((char) ('z' - character + 'a'));
        }
        else {
            return String.valueOf((char) ('Z' - character + 'A'));
        }
    }
}

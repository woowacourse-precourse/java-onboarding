package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char toString(char character) {
        if('a' <= character && character <= 'z') {
            return (char) ('z' - character + 'a');
        }
        else {
            return (char) ('Z' - character + 'A');
        }
    }
}

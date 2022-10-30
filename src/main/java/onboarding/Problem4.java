package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char frogDict(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));
        }
        if (Character.isUpperCase(ch)) {
            return (char) ('Z' - (ch - 'A'));
        }
        return ch;
    }
}

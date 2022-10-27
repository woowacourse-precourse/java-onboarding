package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char convertToFrogLanguage(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('a' + 'z' - ch);
        }

        if (Character.isUpperCase(ch)) {
            return (char) ('A' + 'Z' - ch);
        }

        return ch;
    }
}

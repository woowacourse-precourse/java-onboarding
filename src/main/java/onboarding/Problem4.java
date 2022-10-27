package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    private static char convert(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) ('A' + 'Z' - ch);
        }

        return (char) ('a' + 'z' - ch);
    }
}

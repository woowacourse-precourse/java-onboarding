package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            getChar(c);
        }
        return " "; // 임시
    }

    private static char getChar(char c) {
        if (Character.isUpperCase(c)) {
            return (char) ('Z' + 'A' - c);
        }
        if (Character.isLowerCase(c)) {
            return (char) ('z' + 'a' - c);
        }
        return c;
    }
}

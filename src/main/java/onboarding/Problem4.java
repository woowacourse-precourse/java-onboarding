package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char reverse(char c) {
        if (Character.isUpperCase(c)) {
            return (char)('A' + 'Z' - c);
        } else if (Character.isLowerCase(c)) {
            return (char)('a' + 'z' - c);
        } else {
            return c;
        }
    }
}

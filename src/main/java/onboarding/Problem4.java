package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static char transform(char c) {
        if ('a' <= c && c <= 'z')
            return (char)('a' + 'z' - c);

        if ('A' <= c && c <= 'Z')
            return (char)('A' + 'Z' - c);

        return c;
    }
}

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] split = word.toCharArray();
        for (char c : split) {
            if (isAlphabetic(c)) {
                answer.append(changeCase(c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    private static char changeCase(char c) {
        if (c >= 65 && c <= 90) {
            return c;
        }
        return c;
    }

    private static boolean isAlphabetic(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}

package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char c : word.toCharArray()) {
            answer.append(changeCase(c));
        }
        return answer.toString();
    }

    private static char changeCase(char c) {
        int result = c;
        if ('A' <= c && c <= 'Z') {
            result = ('A' + 'Z' - c);
        }
        if ('a' <= c && c <= 'z') {
            result = ('a' + 'z' - c);
        }
        return (char) result;
    }
}
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            answer.append(changeCase(c));
        }
        return answer.toString();
    }

    private static char changeCase(char x) {
        int result = x;
        if ('A' <= x && x <= 'Z') {
            result = ('A' + 'Z' - x);
        }
        if ('a' <= x && x <= 'z') {
            result = ('a' + 'z' - x);
        }
        return (char) result;
    }
}
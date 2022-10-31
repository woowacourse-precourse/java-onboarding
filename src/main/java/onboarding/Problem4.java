package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] wordArr = word.toCharArray();

        for (char c: wordArr) {
            char frogChar = c == ' ' ? ' ' : c <= 'Z' ? (char) (155 - c) : (char) (219 - c);    // 'A' + 'C' = 155, 'a' + 'c' = 219
            answer.append(frogChar);
        }

        return answer.toString();
    }
}
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            answer.append(transform(ch));
        }
        return answer.toString();
    }

    public static char transform(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));

        } else if (Character.isUpperCase(ch)) {
            return (char) ('Z' - (ch - 'A'));
        }
        return ch;
    }
}

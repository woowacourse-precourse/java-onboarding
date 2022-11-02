package onboarding;


public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            c = makeReverseIfAlpha(c);
            answer.append(c);
        }
        return answer.toString();
    }

    private static char makeReverseIfAlpha(char c) {
        if (Character.isUpperCase(c)) {
            c = (char) ('Z' - (c - 'A'));
        } else if (Character.isLowerCase(c)) {
            c = (char) ('z' - (c - 'a'));
        }
        return c;
    }
}

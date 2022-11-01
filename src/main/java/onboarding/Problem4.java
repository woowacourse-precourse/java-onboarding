package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char ch : word.toCharArray()) {
            answer.append(convertToFrogLanguage(ch));
        }

        return answer.toString();
    }

    private static char convertToFrogLanguage(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('a' + 'z' - ch);
        }

        if (Character.isUpperCase(ch)) {
            return (char) ('A' + 'Z' - ch);
        }

        return ch;
    }
}

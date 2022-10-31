package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(convertToFrogLanguage(c));
        }
        return answer.toString();
    }

    private static char convertToFrogLanguage(char c) {
        if (Character.isLowerCase(c)) {
            return (char) ('z' - c + 'a');
        } else if (Character.isUpperCase(c)) {
            return (char) ('Z' - c + 'A');
        } else return c;
    }
}


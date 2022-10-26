package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        word.chars().map(c -> convertToFrogDictionary((char) c))
                .forEach(answer::append);
        return answer.toString();
    }

    private static char convertToFrogDictionary(char c) {
        if (isNotContainsFrogDictionary(c)) {
            return c;
        }
        if (Character.isUpperCase(c)) {
            return (char) ('Z' - c + 'A');
        }
        return (char) ('z' - c + 'a');
    }

    private static boolean isNotContainsFrogDictionary(char c) {
        return !Character.isAlphabetic(c);
    }
}

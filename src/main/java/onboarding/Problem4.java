package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(convertToFrogDictionary(c));
        }
        return answer.toString();
    }

    private static Character convertToFrogDictionary(char c) {
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

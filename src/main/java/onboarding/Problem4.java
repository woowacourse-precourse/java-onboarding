package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return convertWord(word);
    }

    private static String convertWord(String word) {
        StringBuilder result = new StringBuilder();

        for (char c: word.toCharArray()) {
            result.append(backwardAlphabet(c));
        }

        return result.toString();
    }

    private static Character backwardAlphabet(char c) {
        if (!validation(c)) {
            return c;
        }

        if (c >= 'A' && c <= 'Z') {
            return (char) ('Z' - (c - 'A'));
        }

        return (char) ('z' - (c - 'a'));
    }

    private static boolean validation(char c) {
        return Character.isAlphabetic(c);
    }

}




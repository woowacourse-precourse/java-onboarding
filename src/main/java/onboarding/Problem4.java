package onboarding;

public class Problem4 {
    private static final int minLength = 1;
    private static final int maxLength = 1000;

    public static String solution(String word) {
        validate(word);
        return converse(word);
    }

    private static String converse(String word) {
        StringBuilder conversedWord = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            if (!Character.isAlphabetic(alphabet)) {
                continue;
            }
            if (Character.isUpperCase(alphabet)) {
                conversedWord.setCharAt(i, (char)(65 + (90 - alphabet)));
                continue;
            }
            conversedWord.setCharAt(i, (char)(97 + (122 - alphabet)));
        }
        return conversedWord.toString();
    }

    private static void validate(String word) {
        if (word.length() < minLength || word.length() > maxLength) {
            throw new IllegalArgumentException("문자열의 길이가 1이상 1000이하여야합니다.");
        }
    }
}

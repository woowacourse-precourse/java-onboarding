package onboarding;

public class Problem4 {
    private static final int UPPER_LAST_ALPHABET = 90;
    private static final int LOWER_LAST_ALPHABET = 122;

    public static String solution(String word) {
        char[] alphabetArray = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : alphabetArray) {
            Character result;
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
                result = (char) (UPPER_LAST_ALPHABET - c + 'A');
            } else if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
                result = (char) (LOWER_LAST_ALPHABET - c + 'a');
            } else {
                result = c;
            }
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }
}

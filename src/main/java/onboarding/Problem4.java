package onboarding;

public class Problem4 {
    private static final int UPPERCASE_ASCII = 65;
    private static final int LOWER_ASCII = 97;
    private static final char UPPER_Z = 'Z';
    private static final char LOWER_Z = 'z';

    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0 ; index < word.length() ; index++) {
            String convertedString = getConvertedString(word, index);
            stringBuilder.append(convertedString);
        }

        return stringBuilder.toString();
    }

    private static String getConvertedString(String word, int index) {
        char originalLetter = word.charAt(index);

        if (Character.isUpperCase(originalLetter)) {
            return convertUpperCase(originalLetter);
        } else if (Character.isLowerCase(word.charAt(index))) {
            return convertLowerCase(originalLetter);
        }

        return String.valueOf(originalLetter);
    }

    private static String convertUpperCase(char originalLetter) {
        int diff = originalLetter - UPPERCASE_ASCII;
        char convertedAlphabet = (char) (UPPER_Z - diff);

        return String.valueOf(convertedAlphabet);
    }

    private static String convertLowerCase(char originalLetter) {
        int diff = originalLetter - LOWER_ASCII;
        char convertedAlphabet = (char) (LOWER_Z - diff);

        return String.valueOf(convertedAlphabet);
    }
}

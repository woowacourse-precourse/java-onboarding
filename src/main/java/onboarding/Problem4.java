package onboarding;

public class Problem4 {
    public static final String UPPER = "upper";
    public static final String LOWER = "lower";
    public static final int UPPER_ALPHABET_START_ASCII = 65;
    public static final int UPPER_ALPHABET_END_ASCII = 90;
    public static final int LOWER_ALPHABET_START_ASCII = 97;
    public static final int LOWER_ALPHABET_END_ASCII = 122;

    public static String solution(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            String changedCharacter = changeCharacter(currentCharacter);
            stringBuilder.append(changedCharacter);
        }

        return stringBuilder.toString();
    }

    private static String changeCharacter(char character) {
        String changedCharacter = null;
        if (Character.isLowerCase(character)) {
            changedCharacter = changeCharacter(character, LOWER);
        }

        if (Character.isUpperCase(character)) {
            changedCharacter = changeCharacter(character, UPPER);
        }

        if(!Character.isLowerCase(character)
                && !Character.isUpperCase(character)) {
            return Character.toString(character);
        }

        return changedCharacter;
    }

    private static String changeCharacter(char character, String alphabetCase) {
        int startAsciiCode = 0;
        int endAsciiCode = 0;

        if (alphabetCase.equals(LOWER)) {
            startAsciiCode = LOWER_ALPHABET_START_ASCII;
            endAsciiCode = LOWER_ALPHABET_END_ASCII;
        }

        if (alphabetCase.equals(UPPER)) {
            startAsciiCode = UPPER_ALPHABET_START_ASCII;
            endAsciiCode = UPPER_ALPHABET_END_ASCII;
        }

        int number = Character.toString(character).charAt(0);
        int newNumber = startAsciiCode - (number - endAsciiCode);
        return String.valueOf((char) newNumber);
    }
}

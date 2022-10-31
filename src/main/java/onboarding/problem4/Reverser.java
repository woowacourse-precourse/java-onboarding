package onboarding.problem4;

public class Reverser {
    public final String UPPER = "upper";
    public final String LOWER = "lower";
    public final int UPPER_ALPHABET_START_ASCII = 65;
    public final int UPPER_ALPHABET_END_ASCII = 90;
    public final int LOWER_ALPHABET_START_ASCII = 97;
    public final int LOWER_ALPHABET_END_ASCII = 122;

    public String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            String changedCharacter = changeCharacter(currentCharacter);
            stringBuilder.append(changedCharacter);
        }

        return stringBuilder.toString();
    }

    private String changeCharacter(char character) {
        if (Character.isLowerCase(character)) {
            return convertCharacter(character, LOWER);
        }

        if (Character.isUpperCase(character)) {
            return convertCharacter(character, UPPER);
        }

        return Character.toString(character);
    }

    private String convertCharacter(char character, String alphabetCase) {
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

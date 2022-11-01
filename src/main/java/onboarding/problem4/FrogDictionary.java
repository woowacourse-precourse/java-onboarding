package onboarding.problem4;

public class FrogDictionary {
    private static final char LOWER_RULE = 'a' + 'z';
    private static final char UPPER_RULE = 'A' + 'Z';

    public String translate(String word) {
        StringBuilder sb = new StringBuilder();

        char[] splitWord = word.toCharArray();
        for (char c : splitWord) {
            sb.append(convert(c));
        }
        return sb.toString();
    }

    private char convert(char letter) {
        if (isAlphabet(letter)) {
            return replaceLetter(letter);
        }
        return letter;
    }

    private boolean isAlphabet(char letter) {
        return isLowerAlphabet(letter) || isUpperAlphabet(letter);
    }

    private boolean isUpperAlphabet(char letter) {
        return letter >= 65 && letter <= 90;
    }

    private boolean isLowerAlphabet(char letter) {
        return letter >= 97 && letter <= 122;
    }

    private char replaceLetter(char letter) {
        if (isLowerAlphabet(letter)) {
            return (char) (LOWER_RULE - letter);
        }
        return (char) (UPPER_RULE - letter);
    }
}

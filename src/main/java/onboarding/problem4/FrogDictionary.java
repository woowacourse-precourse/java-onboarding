package onboarding.problem4;

public class FrogDictionary {
    private static final char LOWER = 'a' + 'z';
    private static final char UPPER = 'A' + 'Z';

    private final String word;

    public FrogDictionary(String word) {
        this.word = word;
    }

    public String translate() {
        StringBuilder sb = new StringBuilder();

        char[] splitWord = word.toCharArray();
        for (char c : splitWord) {
            sb.append(convert(c));
        }
        return sb.toString();
    }

    private char convert(char letter) {
        if ((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122)) {
            return replaceLetter(letter);
        }
        return letter;
    }

    private char replaceLetter(char letter) {
        if (Character.isLowerCase(letter)) {
            return (char) (LOWER - letter);
        }
        return (char) (UPPER - letter);
    }
}

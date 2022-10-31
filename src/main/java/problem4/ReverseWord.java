package problem4;

public class ReverseWord {
    private final String word;
    private final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private final String upperAlphabet = lowerAlphabet.toUpperCase();

    public ReverseWord(String word) {
        this.word = word;
    }

    private boolean isOtherCase(int index) {
        return !(isLowerCase(index) || isUpperCase(index));
    }

    private boolean isLowerCase(int index) {
        char character = word.charAt(index);
        return Character.isLowerCase(character);
    }

    private boolean isUpperCase(int index) {
        char character = word.charAt(index);
        return Character.isUpperCase(character);
    }
}

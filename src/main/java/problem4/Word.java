package problem4;

public class Word {
    private final int UPPERCASE_START = 65;
    private final int UPPERCASE_END = 90;
    private final int LOWERCASE_START = 97;
    private final int LOWERCASE_END = 122;

    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String reverse() {
        StringBuilder reverse = new StringBuilder(word);

        for (int i = 0; i < reverse.length(); i++) {
            reverse.setCharAt(i, getChange(getNow(reverse, i)));
        }
        return reverse.toString();
    }

    private char getNow(StringBuilder reverse, int index) {
        return reverse.charAt(index);
    }

    private char getChange(char now) {
        if (!isSpace(now)) {
            return getReverseCharacter(now);
        }
        return ' ';
    }

    private char getReverseCharacter(char now) {
        if (Character.isUpperCase(now))
            return (char) (UPPERCASE_END - (int) now + UPPERCASE_START);
        return (char) (LOWERCASE_END - (int) now + LOWERCASE_START);
    }

    private boolean isSpace(char character) {
        return character == ' ';
    }
}

package onboarding.problem4;

public enum Alphabet {
    ALPHABET_UPPERCASE_START('A'),
    ALPHABET_UPPERCASE_END('Z'),
    ALPHABET_LOWERCASE_START('a'),
    ALPHABET_LOWERCASE_END('z');

    private final char letter;

    Alphabet(char letter) {
        this.letter = letter;
    }

    public int getLetter() {
        return this.letter;
    }
}

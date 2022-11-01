package onboarding.problem4;

public class Word {

    private final int MIN_WORD_LENGTH = 1;
    private final int MAX_WORD_LENGTH = 1_000;

    private String word;

    public Word(String word) {
        validateWord(word);
        this.word = word;
    }

    private void validateWord(String word) {
        if (isOutOfBounds(word)) throw new IllegalArgumentException("word is out of bounds");
    }

    private boolean isOutOfBounds(String word) {
        return word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH;
    }
}

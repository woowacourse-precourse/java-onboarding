package onboarding.problem4;

public class NormalWord {
    private final String words;

    public NormalWord(String words) {
        isIllegal(words);
        this.words = words;
    }

    private void isIllegal(String words) {
        isNotNull(words);
        isNotInRange(words);
    }

    private void isNotNull(String words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotInRange(String words) {
        if (words.length() == 0 || words.length() > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public String getWords() {
        return words;
    }
}

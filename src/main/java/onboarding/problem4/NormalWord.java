package onboarding.problem4;

import static onboarding.problem4.ConstantsP4.INPUT_MAX_LENGTH;
import static onboarding.problem4.ConstantsP4.INPUT_MIN_LENGTH;

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
        if (words.length() < INPUT_MIN_LENGTH || words.length() > INPUT_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getWords() {
        return words;
    }
}

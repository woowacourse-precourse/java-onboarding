package onboarding.problem4.input;

import onboarding.problem.ProblemInput;
import onboarding.problem4.domain.Word;

public class Problem4Input implements ProblemInput {

    private final Word word;

    public Problem4Input(String word) {
        this.word = new Word(word);
    }

    public Word word() {
        return word;
    }

    @Override
    public boolean hasError() {
        return false;
    }
}

package onboarding.problem4.input;

import onboarding.problem.ProblemInput;
import onboarding.problem4.domain.Word;

public class Problem4Input implements ProblemInput {

    private final Word word;

    public Problem4Input(String input) {
        this.word = new Word(input);
    }

    @Override
    public boolean hasError() {
        return false;
    }
}

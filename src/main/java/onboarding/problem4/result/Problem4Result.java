package onboarding.problem4.result;

import onboarding.problem.ProblemResult;
import onboarding.problem4.domain.Word;

public class Problem4Result implements ProblemResult<String> {

    private final Word word;

    public Problem4Result(Word word) {
        this.word = word;
    }

    @Override
    public String toResult() {
        return word.value();
    }
}

package onboarding.problem2.input;

import onboarding.problem.ProblemInput;
import onboarding.problem2.domain.Cryptogram;

public class Problem2Input implements ProblemInput {

    private final Cryptogram cryptogram;

    public Problem2Input(String cryptogram) {
        this.cryptogram = new Cryptogram(cryptogram);
    }

    public Cryptogram cryptogram() {
        return cryptogram;
    }

    @Override
    public boolean hasError() {
        return false;
    }
}

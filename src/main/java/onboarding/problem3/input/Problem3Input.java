package onboarding.problem3.input;

import onboarding.problem.ProblemInput;
import onboarding.problem3.domain.Number;

public class Problem3Input implements ProblemInput {

    private final Number number;

    public Problem3Input(int number) {
        this.number = Number.valueOf(number);
    }

    public Number number() {
        return number;
    }

    @Override
    public boolean hasError() {
        return false;
    }
}

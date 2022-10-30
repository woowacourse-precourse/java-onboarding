package onboarding.problem5.input;

import onboarding.problem.ProblemInput;
import onboarding.problem5.domain.Money;

public class Problem5Input implements ProblemInput {

    private final Money money;

    public Problem5Input(int money) {
        this.money = new Money(money);
    }

    @Override
    public boolean hasError() {
        return false;
    }
}

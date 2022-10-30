package onboarding.problem5.solver;

import onboarding.problem.Solver;
import onboarding.problem5.domain.Money;
import onboarding.problem5.domain.MoneyConverter;
import onboarding.problem5.domain.Wallet;
import onboarding.problem5.input.Problem5Input;
import onboarding.problem5.result.Problem5Result;

public class Problem5Solver implements Solver<Problem5Input, Problem5Result> {

    @Override
    public Problem5Result solve(Problem5Input input) {
        Money money = input.money();
        MoneyConverter converter = new MoneyConverter();

        Wallet wallet = converter.convert(money);
        return new Problem5Result(wallet);
    }
}
